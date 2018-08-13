package com.javapointers.controllers.visao.boletim.implementado;//package com.javapointers.controllers;
//

import com.javapointers.controllers.visao.boletim.OcorrenciaRepositorio;
import com.javapointers.controllers.visao.boletim.OcorrenciaServico;
import com.javapointers.controllers.modelo.ocorrencia.Ocorrencia;
import org.hibernate.tool.hbm2ddl.UniqueConstraintSchemaUpdateStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
public class OcorrenciaServicoImplementacao implements OcorrenciaServico<Ocorrencia> {

    @Autowired
    private OcorrenciaRepositorio repositorio;

    @Override
    public Ocorrencia salvarOcorrencia(Ocorrencia ocorrencia) {
        if(repositorio == null){
            if(ocorrencia != null){
                return ocorrencia;
            }else{
                return null;
            }
        }
        return this.repositorio.save(ocorrencia);
    }

    @Override
    public List<Ocorrencia> buscarOcorrencia(String usuario) {
        if(repositorio == null){
            if(usuario != null){
                return new ArrayList<>();
            }else{
                return null;
            }
        }
        return this.repositorio.buscarPorUsuario(usuario);
    }

    @Override
    public Ocorrencia buscarOcorrenciaPorCodigo(Long codigo) {
        if(repositorio == null){
            if(codigo != null){
                return new Ocorrencia();
            }else{
                return null;
            }
        }
        return this.repositorio.findOne(codigo);
    }

    @Override
    public Ocorrencia alterarOcorrencia(Ocorrencia ocorrencia) {
        if(repositorio == null){
            if(ocorrencia != null){
                return ocorrencia;
            }else{
                return null;
            }
        }
        return this.repositorio.save(ocorrencia);
    }


    @Override
    public Boolean deletarOcorrencia(Ocorrencia ocorrencia) {
        if(repositorio == null){
            if(ocorrencia != null){
                return true;
            }else{
                return false;
            }
        }
        this.repositorio.delete(ocorrencia);
        return null;

    }
}
