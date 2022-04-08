package com.mycompany.controltec.entidades;
public class Componentes {
    
    private Long idComponente;
    private String nomeDisco;
    private String modeloDisco;
    private String serialDisco;
    private Long tamanhoDisco;
    private Long memoriaTotal;
    private String processador;
    private  Maquina maquina;

    public Componentes(Long idComponente, String nomeDisco, String modeloDisco, String serialDisco, Long tamanhoDisco, Long memoriaTotal, String processador, Maquina maquina) {
        this.idComponente = idComponente;
        this.nomeDisco = nomeDisco;
        this.modeloDisco = modeloDisco;
        this.serialDisco = serialDisco;
        this.tamanhoDisco = tamanhoDisco;
        this.memoriaTotal = memoriaTotal;
        this.processador = processador;
        this.maquina = maquina;
    }
    
    public Componentes(){}

    public Long getIdComponente() {
        return idComponente;
    }

    public String getNomeDisco() {
        return nomeDisco;
    }

    public String getModeloDisco() {
        return modeloDisco;
    }

    public String getSerialDisco() {
        return serialDisco;
    }

    public Long getTamanhoDisco() {
        return tamanhoDisco;
    }

    public Long getMemoriaTotal() {
        return memoriaTotal;
    }

    public String getProcessador() {
        return processador;
    }

    public Maquina getMaquina() {
        return maquina;
    }
    
    
    
    
}
