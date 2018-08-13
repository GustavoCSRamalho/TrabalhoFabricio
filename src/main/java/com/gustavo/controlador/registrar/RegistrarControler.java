package com.gustavo.controlador.registrar;

import com.gustavo.modelo.usuario.dto.UsuarioDTO;
import com.gustavo.visao.usuario.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrarControler {

    @Autowired
    private UsuarioServico servico;


    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public ModelAndView registrarLogin(UsuarioDTO usuario) {
        try {

            servico.salvar(usuario.pegarUsuario());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("registrar");
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.GET)
    public ModelAndView paginaRegistrar() {
        return new ModelAndView("registrar");
    }

}
