package com.gustavo.controlador.logar;

import com.gustavo.visao.usuario.UsuarioServico;
import com.javapointers.controllers.modelo.usuario.Usuario;
import com.javapointers.controllers.modelo.usuario.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LogarControler {

    @Autowired
    private UsuarioServico servico;


    @RequestMapping(value = "/logar", method = RequestMethod.POST)
    public ModelAndView entrarLogin(UsuarioDTO usuarioDTO, HttpSession sessao) {
        ModelAndView modeloEVisao = new ModelAndView("redirect:/principal");
        Usuario usuarioBancoDeDados = null;
        Usuario usuario = usuarioDTO.pegarUsuario();
        try {
            usuarioBancoDeDados = (Usuario) servico.buscarPorUsuario(usuario.getUs_usuario());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (usuarioBancoDeDados != null && (usuario.getUs_usuario().equals(usuarioBancoDeDados.getUs_usuario())) && (usuario.getUs_senha().equals(usuarioBancoDeDados.getUs_senha()))) {
            System.out.println("Entrou");
            sessao.setAttribute("sessao_usuario", usuarioBancoDeDados.getUs_usuario());
        } else {
            modeloEVisao = new ModelAndView("logar");
        }

        return modeloEVisao;
    }

    @RequestMapping(value = "/logar", method = RequestMethod.GET)
    public ModelAndView paginaLogin() {
        ModelAndView modeloEVisao = new ModelAndView("logar");
        return modeloEVisao;
    }

}
