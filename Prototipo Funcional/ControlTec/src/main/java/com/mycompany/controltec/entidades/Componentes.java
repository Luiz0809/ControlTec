package com.mycompany.controltec.entidades;
public class Componentes {
    
    private Long idComponentes;
    private String nomeComponente;
    private String modeloComponente;
    private Long tamanhoComponente;
    private  Maquina fkMaquina;


   public Componentes(){}

    public Componentes(Long idComponentes, String nomeComponente, String modeloComponente, Long tamanhoComponente, Maquina fkMaquina) {
        this.idComponentes = idComponentes;
        this.nomeComponente = nomeComponente;
        this.modeloComponente = modeloComponente;
        this.tamanhoComponente = tamanhoComponente;
        this.fkMaquina = fkMaquina;
    }

    public Long getIdComponentes() {
        return idComponentes;
    }

    public void setIdComponentes(Long idComponentes) {
        this.idComponentes = idComponentes;
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

    public Long getTamanhoComponente() {
        return tamanhoComponente;
    }

    public void setTamanhoComponente(Long tamanhoComponente) {
        this.tamanhoComponente = tamanhoComponente;
    }

    public Maquina getFkMaquina() {
        return fkMaquina;
    }

    

    @Override
    public String toString() {
        return "idComponentes=" + idComponentes + ", nomeComponente=" + nomeComponente + ", modeloComponente=" + modeloComponente + ", tamanhoComponente=" + tamanhoComponente + ", fkMaquina=" + fkMaquina + '}';
    }

    
   
}
