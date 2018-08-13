package com.gustavo.controlador.principal;

import com.gustavo.modelo.ocorrencia.Ocorrencia;
import com.gustavo.modelo.telefone.Telefone;
import com.gustavo.visao.boletim.OcorrenciaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class PrincipalControler {


    @Autowired
    private OcorrenciaServico ocorrenciaServico;


    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public ModelAndView paginaCadastroOcorrencia() {
        return new ModelAndView("cadastro");
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ModelAndView cadastrarOcorrencia(@RequestParam(value = "tipo") String tipo,
                                            @RequestParam(value = "descricao") String descricao,
                                            @RequestParam(value = "telefone1") String telefone1,
                                            @RequestParam(value = "telefone2") String telefone2
//            ,
//                                            @ModelAttribute("usuario") String usuario){
    ) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setOc_descricao(descricao);
        ocorrencia.setOc_tipo(tipo);
        ocorrencia.setOc_usuario("gustavo");

        Telefone telefone = new Telefone();
        telefone.setTel_telefone(telefone1);
        telefone.setOcorrencia(ocorrencia);
        ocorrencia.getTelefones().add(telefone);

        telefone = new Telefone();
        telefone.setTel_telefone(telefone2);
        telefone.setOcorrencia(ocorrencia);
        ocorrencia.getTelefones().add(telefone);

        this.ocorrenciaServico.salvarOcorrencia(ocorrencia);

        ModelAndView modeloEVisao = new ModelAndView("cadastro");
        modeloEVisao.addObject("estado", "Sucesso!");

        return modeloEVisao;
    }


    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    public ModelAndView principal(HttpSession sessao) {

        String sessao_usuario = (String) sessao.getAttribute("sessao_usuario");
        ModelAndView modeloEVisao = new ModelAndView("principal");
        List<Ocorrencia> ocorrencias = this.ocorrenciaServico.buscarOcorrencia("gustavo");
        modeloEVisao.addObject("ocorrencias", ocorrencias);

        return modeloEVisao;
    }

    @RequestMapping(value = "/atualizar", method = RequestMethod.GET)
    public ModelAndView atualizarPagina(@RequestParam(value = "codigo") Long codigo) {
        ModelAndView modeloEVisao = new ModelAndView("atualizar");
        Ocorrencia ocorrencia = (Ocorrencia) this.ocorrenciaServico.buscarOcorrenciaPorCodigo(codigo);
        modeloEVisao.addObject("ocorrencia", ocorrencia);

        return modeloEVisao;
    }


    @RequestMapping(value = "/atualizar", method = RequestMethod.POST)
    public ModelAndView atualizarOcorrencias(@RequestParam(value = "codigo") Long codigo,
                                             @RequestParam(value = "usuario") String usuario,
                                             @RequestParam(value = "telefone1_id") Long tel1_codigo,
                                             @RequestParam(value = "telefone2_id") Long tel2_codigo,
                                             @RequestParam(value = "descricao") String descricao,
                                             @RequestParam(value = "tipo") String tipo,
                                             @RequestParam(value = "telefone1") String telefone1,
                                             @RequestParam(value = "telefone2") String telefone2) {

        ModelAndView modeloEVisao = new ModelAndView("atualizar");


        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setOc_usuario(usuario);
        ocorrencia.setOc_descricao(descricao);
        ocorrencia.setOc_tipo(tipo);
        ocorrencia.setOc_codigo(codigo);

        Telefone telefone = new Telefone();
        telefone.setOcorrencia(ocorrencia);
        telefone.setTel_codigo(tel1_codigo);
        telefone.setTel_telefone(telefone1);
        ocorrencia.getTelefones().add(telefone);

        telefone = new Telefone();
        telefone.setOcorrencia(ocorrencia);
        telefone.setTel_codigo(tel2_codigo);
        telefone.setTel_telefone(telefone2);
        ocorrencia.getTelefones().add(telefone);

        this.ocorrenciaServico.alterarOcorrencia(ocorrencia);

        modeloEVisao.addObject("ocorrencia", ocorrencia);

        return modeloEVisao;
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.GET)
    private ModelAndView deletarOcorrencia(@RequestParam(value = "codigo") Long codigo) {

        Ocorrencia ocorrencia = (Ocorrencia) this.ocorrenciaServico.buscarOcorrenciaPorCodigo(codigo);

        this.ocorrenciaServico.deletarOcorrencia(ocorrencia);

        return new ModelAndView("principal");

    }

}
