package com.javapointers.controllers.visao.boletim;//package com.javapointers.controllers;

import com.javapointers.controllers.modelo.ocorrencia.Ocorrencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OcorrenciaRepositorio extends CrudRepository<Ocorrencia, Long> {

//    @Query("select u from UsuarioDTO u where u.usuario =?1 ")
//    public UsuarioDTO buscarPorUsuario(final String usuario);

    @Query("select u from Ocorrencia u where u.oc_usuario=?1")
    public List<Ocorrencia> buscarPorUsuario(final String usuario);

}
