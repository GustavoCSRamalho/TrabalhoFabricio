package com.javapointers.controllers.visao.usuario.implementado;//package com.javapointers.controllers;
//
import com.javapointers.controllers.modelo.usuario.Usuario;
import com.javapointers.controllers.visao.usuario.UsuarioRepositorio;
import com.javapointers.controllers.visao.usuario.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicoImplementacao implements UsuarioServico<Usuario> {

    @Autowired
    private UsuarioRepositorio repositorio;


    @Override
    public Usuario salvar(Usuario usuario) {

        if(repositorio == null){
            if(usuario != null){
                return new Usuario();
            }else{
                return null;
            }
        }
        return this.repositorio.save(usuario);
    }

    @Override
    public Usuario buscarPorUsuario(String usuario) {

        if(repositorio == null){
            if(usuario != null){
                return new Usuario();
            }else{
                return null;
            }
        }
        return this.repositorio.buscarPorUsuario(usuario);
    }
}
