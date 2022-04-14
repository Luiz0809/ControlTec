
package com.mycompany.controltec.entidades;

import com.github.britooo.looca.api.core.Looca;

public class Maquina {
    
    private Long idMaquina;
    private String identificador;
    private String sistemaOperacional;
    private Turma fkTurma;
    private Looca looca = new Looca();
    
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
        return sistemaOperacional = looca.getSistema().getSistemaOperacional();
    }

    public Turma getFkTurma() {
        return fkTurma;
    }
    
}
