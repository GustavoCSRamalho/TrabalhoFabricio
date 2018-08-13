package com.javapointers.controllers.modelo.ocorrencia;

import com.javapointers.controllers.modelo.telefone.Telefone;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ocorrencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oc_codigo;

    private String oc_usuario;

    private String oc_tipo;

    private String oc_descricao;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ocorrencia", cascade = CascadeType.ALL)
    private List<Telefone> telefones = new ArrayList<>();

    public Long getOc_codigo() {
        return oc_codigo;
    }

    public void setOc_codigo(Long oc_codigo) {
        this.oc_codigo = oc_codigo;
    }

    public String getOc_usuario() {
        return oc_usuario;
    }

    public void setOc_usuario(String oc_usuario) {
        this.oc_usuario = oc_usuario;
    }

    public String getOc_tipo() {
        return oc_tipo;
    }

    public void setOc_tipo(String oc_tipo) {
        this.oc_tipo = oc_tipo;
    }

    public String getOc_descricao() {
        return oc_descricao;
    }

    public void setOc_descricao(String oc_descricao) {
        this.oc_descricao = oc_descricao;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }


}
