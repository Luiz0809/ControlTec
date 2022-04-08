package com.mycompany.controltec.entidades;

import java.time.Instant;

public class LogsDeErro {
   
    private Long idLogsDeErros;
    private String descricao;
    private String identificadorLog;
    private Instant hora;
    private UsoDeMaquinas usuario;
    private UsoDeMaquinas componentes;

    public LogsDeErro(Long idLogsDeErros, String descricao, String identificadorLog, Instant hora, UsoDeMaquinas usuario, UsoDeMaquinas componentes) {
        this.idLogsDeErros = idLogsDeErros;
        this.descricao = descricao;
        this.identificadorLog = identificadorLog;
        this.hora = hora;
        this.usuario = usuario;
        this.componentes = componentes;
    }
    
    public LogsDeErro(){}

    public Long getIdLogsDeErros() {
        return idLogsDeErros;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIdentificadorLog() {
        return identificadorLog;
    }

    public Instant getHora() {
        return hora;
    }

    public UsoDeMaquinas getUsuario() {
        return usuario;
    }

    public UsoDeMaquinas getComponentes() {
        return componentes;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
