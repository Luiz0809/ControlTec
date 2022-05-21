package com.mycompany.controltec.entidades;

import java.time.Instant;

public class Alertas {
   
    private Long idAlerta;
    private String descricao;
    private Instant hora;
    private Usuario usuario;
    private Componentes componentes;

    public Alertas(Long idAlerta, String descricao, Instant hora, Usuario usuario, Componentes componentes) {
        this.idAlerta = idAlerta;
        this.descricao = descricao;
        this.hora = hora;
        this.usuario = usuario;
        this.componentes = componentes;
    }
    
    public Alertas(){}

    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Componentes getComponentes() {
        return componentes;
    }

    public void setComponentes(Componentes componentes) {
        this.componentes = componentes;
    }

    @Override
    public String toString() {
        return "Alertas{" + "idAlerta=" + idAlerta + ", descricao=" + descricao + ", hora=" + hora + ", usuario=" + usuario + ", componentes=" + componentes + '}';
    }
    
    

}