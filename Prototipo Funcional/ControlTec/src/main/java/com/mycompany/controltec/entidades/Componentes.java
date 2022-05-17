package com.mycompany.controltec.entidades;
public class Componentes {
    
    private Long idComponente;
    private String nomeComponente;
    private String modeloComponente;
    private Long tamanhoComponenteEmBytes;
    private  Long fkMaquina;


   public Componentes(){}

    public Componentes(Long idComponente, String nomeComponente, String modeloComponente, Long tamanhoComponenteEmBytes, Long fkMaquina) {
        this.idComponente = idComponente;
        this.nomeComponente = nomeComponente;
        this.modeloComponente = modeloComponente;
        this.tamanhoComponenteEmBytes = tamanhoComponenteEmBytes;
        this.fkMaquina = fkMaquina;
    }

    
    public Long getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Long idComponente) {
        this.idComponente = idComponente;
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public String getModeloComponente() {
        return modeloComponente;
    }

    public void setModeloComponente(String modeloComponente) {
        this.modeloComponente = modeloComponente;
    }

    public Long getTamanhoComponenteEmBytes() {
        return tamanhoComponenteEmBytes;
    }

    public void setTamanhoComponenteEmBytes(Long tamanhoComponenteEmBytes) {
        this.tamanhoComponenteEmBytes = tamanhoComponenteEmBytes;
    }

    public Long getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Long fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return "Componentes{" + "idComponente=" + idComponente + ", nomeComponente=" + nomeComponente + ", modeloComponente=" + modeloComponente + ", tamanhoComponenteEmBytes=" + tamanhoComponenteEmBytes + ", fkMaquina=" + fkMaquina + '}';
    }

    
   
}
