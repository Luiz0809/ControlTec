
package com.mycompany.controltec.entidades;

import java.time.Instant;
import java.util.Date;

public class UsoDeMaquinas {
    private Usuario usuario;
    private Componentes componentes;
    private Date inicializado;
    private Long tempoEmUso;
    private Integer consumoCPU;
    private Long consumoDisco;
    private Long consumoMemoria;
    private Double temperatura;
    private Instant hora;

    public UsoDeMaquinas(Usuario usuario, Componentes componentes, Date inicializado, Long tempoEmUso, Integer consumoCPU, Long consumoDisco, Long consumoMemoria, Double temperatura, Instant hora) {
        this.usuario = usuario;
        this.componentes = componentes;
        this.inicializado = inicializado;
        this.tempoEmUso = tempoEmUso;
        this.consumoCPU = consumoCPU;
        this.consumoDisco = consumoDisco;
        this.consumoMemoria = consumoMemoria;
        this.temperatura = temperatura;
        this.hora = hora;
    }
    
    public UsoDeMaquinas(){}

    public Usuario getUsuario() {
        return usuario;
    }

    public Componentes getComponentes() {
        return componentes;
    }

    public Date getInicializado() {
        return inicializado;
    }

    public Long getTempoEmUso() {
        return tempoEmUso;
    }

    public Integer getConsumoCPU() {
        return consumoCPU;
    }

    public Long getConsumoDisco() {
        return consumoDisco;
    }

    public Long getConsumoMemoria() {
        return consumoMemoria;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public Instant getHora() {
        return hora;
    }
    
    
}
