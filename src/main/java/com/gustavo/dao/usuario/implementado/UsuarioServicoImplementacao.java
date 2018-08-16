package com.gustavo.dao.usuario.implementado;//

import com.gustavo.dao.usuario.UsuarioServico;
import com.gustavo.modelo.usuario.Usuario;
import com.gustavo.repositorio.usuario.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServicoImplementacao implements UsuarioServico<Usuario> {

    @Autowired
    private UsuarioRepositorio repositorio;


    @Override
    public Usuario salvar(Usuario usuario) {

        if (repositorio == null) {
            if (usuario != null) {
                return new Usuario();
            } else {
                return null;
            }
        }
        return this.repositorio.save(usuario);
    }

    @Override
    public Usuario buscarPorUsuario(String usuario) {

        if (repositorio == null) {
            if (usuario != null) {
                return new Usuario();
            } else {
                return null;
            }
        }
        return this.repositorio.buscarPorUsuario(usuario);
    }
}
