package com.gustavo.repositorio.usuario;

import com.gustavo.modelo.usuario.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.us_usuario=?1 ")
    public Usuario buscarPorUsuario(final String usuario);

}
