
package com.mycompany.controltec.entidades;
public class Maquina {
    
    private Long idMaquina;
    private String identificador;
    private String sistemaOperacional;
    private Turma fkTurma;
    
    public Maquina(){}

    public Maquina(Long idMaquina, String identificador, String sistemaOperacional, Turma fkTurma) {
        this.idMaquina = idMaquina;
        this.identificador = identificador;
        this.sistemaOperacional = sistemaOperacional;
        this.fkTurma = fkTurma;
    }

    public Long getIdMaquina() {
        return idMaquina;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public Turma getFkTurma() {
        return fkTurma;
    }
    
}
