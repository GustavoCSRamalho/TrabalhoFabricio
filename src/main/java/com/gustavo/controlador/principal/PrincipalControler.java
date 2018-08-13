package com.javapointers.controllers.controlador.principal;


import com.javapointers.controllers.visao.boletim.OcorrenciaServico;
import com.javapointers.controllers.modelo.ocorrencia.Ocorrencia;
import com.javapointers.controllers.modelo.telefone.Telefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Jerry on 4/5/14.
 */
@Controller
//@SessionAttributes("sessao_Usuario")
public class PrincipalControler {

//    @Autowired
//    private UsuarioServico servico;

    @Autowired
    private OcorrenciaServico ocorrenciaServico;


//    @RequestMapping(value="/home", method = RequestMethod.GET)
//    public String viewHome(){
////        UsuarioDTO user = new UsuarioDTO();
////        user.setOc_usuario("Gustavo");
////        user.setEmail("gustavo@hotmail.com");
////
////        Itens itens = new Itens();
////        itens.setName("Ramalho");
////        itens.setOc_usuario(user);
////        user.getItens().add(itens);
////        itens = new Itens();
////        itens.setName("Douglas");
////        itens.setOc_usuario(user);
////        user.getItens().add(itens);
////        UsuarioDTO user = null;
//
//        try{
////            service.salvar(user);
////            user = service.buscarPorId((long)17);
////            user = service.buscarUsuario((long)17);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return "home";
//    }

//    @RequestMapping(value = "/teste", method = RequestMethod.GET)
//    public ModelAndView salvar() {
////        service.salvar(usuario);
//
////        List<Ocorrencia> ocorrencia = (List<Ocorrencia>) this.ocorrenciaServico.buscarOcorrencia("Assalto");
//        return new ModelAndView("home");
//    }

    @RequestMapping(value = "/cadastro",method = RequestMethod.GET)
    public ModelAndView paginaCadastroOcorrencia(){
        return new ModelAndView("cadastro");
    }

    @RequestMapping(value = "/cadastro",method = RequestMethod.POST)
    public ModelAndView cadastrarOcorrencia(@RequestParam(value = "tipo") String tipo,
                                            @RequestParam(value = "descricao") String descricao,
                                            @RequestParam(value = "telefone1") String telefone1,
                                            @RequestParam(value = "telefone2") String telefone2
//            ,
//                                            @ModelAttribute("usuario") String usuario){
    ){
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
        modeloEVisao.addObject("estado","Sucesso!");

        return modeloEVisao;
    }


    @RequestMapping(value = "/principal",method = RequestMethod.GET)
    public ModelAndView principal(HttpSession sessao){

        String sessao_usuario = (String)sessao.getAttribute("sessao_usuario");
        ModelAndView modeloEVisao = new ModelAndView("principal");
        List<Ocorrencia> ocorrencias = this.ocorrenciaServico.buscarOcorrencia("gustavo");
        modeloEVisao.addObject("ocorrencias",ocorrencias);
//        modeloEVisao.addObject("sessao_Usuario",sessao_Usuario);

        return modeloEVisao;
    }

    @RequestMapping(value = "/atualizar",method = RequestMethod.GET)
    public ModelAndView atualizarPagina(@RequestParam(value = "codigo") Long codigo){
//        String sessao_Usuario = sessao;
        ModelAndView modeloEVisao = new ModelAndView("atualizar");
        Ocorrencia ocorrencia = (Ocorrencia) this.ocorrenciaServico.buscarOcorrenciaPorCodigo(codigo);
        modeloEVisao.addObject("ocorrencia",ocorrencia);
//        ocorrencia.setOc_descricao(ocorrencia.getOc_descricao() + "123456");
//        this.ocorrenciaServico.salvarOcorrencia(ocorrencia);

        return modeloEVisao;
    }


    @RequestMapping(value = "/atualizar",method = RequestMethod.POST)
    public ModelAndView atualizarOcorrenciass(@RequestParam(value = "codigo") Long codigo,
        @RequestParam(value = "usuario") String usuario,
    @RequestParam(value = "telefone1_id") Long tel1_codigo,
    @RequestParam(value = "telefone2_id") Long tel2_codigo,
    @RequestParam(value = "descricao") String descricao,
    @RequestParam(value = "tipo") String tipo,
    @RequestParam(value = "telefone1") String telefone1,
    @RequestParam(value = "telefone2") String telefone2){

        ModelAndView  modeloEVisao = new ModelAndView("atualizar");


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

        modeloEVisao.addObject("ocorrencia",ocorrencia);

        return modeloEVisao;
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.GET)
    private ModelAndView deletarOcorrencia(@RequestParam(value = "codigo") Long codigo){

        Ocorrencia ocorrencia = (Ocorrencia) this.ocorrenciaServico.buscarOcorrenciaPorCodigo(codigo);

        this.ocorrenciaServico.deletarOcorrencia(ocorrencia);

        return new ModelAndView("principal");

    }

}