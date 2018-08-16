package com.gustavo.dao.usuario;

public interface UsuarioServico<T> {

    public T salvar(final T usuario);

    public T buscarPorUsuario(final String usuario);

}
