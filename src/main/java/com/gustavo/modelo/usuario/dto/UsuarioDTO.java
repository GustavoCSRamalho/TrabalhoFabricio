package com.gustavo.modelo.usuario.dto;

import com.gustavo.modelo.usuario.Usuario;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {


    private Long us_codigo;

    private String us_usuario;

    private String us_senha;

    public Long getUs_codigo() {
        return us_codigo;
    }

    public void setUs_codigo(Long us_codigo) {
        this.us_codigo = us_codigo;
    }

    public String getUs_usuario() {
        return us_usuario;
    }

    public void setUs_usuario(String us_usuario) {
        this.us_usuario = us_usuario;
    }

    public String getUs_senha() {
        return us_senha;
    }

    public void setUs_senha(String us_senha) {
        this.us_senha = us_senha;
    }

    public Usuario pegarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUs_senha(this.getUs_senha());
        usuario.setUs_codigo(this.getUs_codigo());
        usuario.setUs_usuario(this.getUs_usuario());

        return usuario;
    }

}


