package com.gustavo.modelo.telefone;

import com.gustavo.modelo.ocorrencia.Ocorrencia;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Telefone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tel_codigo;

    private String tel_telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oc_codigo", referencedColumnName = "oc_codigo")
    private Ocorrencia ocorrencia;

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public Long getTel_codigo() {
        return tel_codigo;
    }

    public void setTel_codigo(Long tel_codigo) {
        this.tel_codigo = tel_codigo;
    }

    public String getTel_telefone() {
        return tel_telefone;
    }

    public void setTel_telefone(String tel_telefone) {
        this.tel_telefone = tel_telefone;
    }
}
