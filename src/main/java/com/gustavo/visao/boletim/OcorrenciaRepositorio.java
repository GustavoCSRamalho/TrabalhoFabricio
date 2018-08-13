package com.gustavo.visao.boletim;

import com.javapointers.controllers.modelo.ocorrencia.Ocorrencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OcorrenciaRepositorio extends CrudRepository<Ocorrencia, Long> {


    @Query("select u from Ocorrencia u where u.oc_usuario=?1")
    public List<Ocorrencia> buscarPorUsuario(final String usuario);

}
