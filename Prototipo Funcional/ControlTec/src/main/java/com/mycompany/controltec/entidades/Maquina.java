
package com.mycompany.controltec.entidades;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.controltec.jdbc.Conexao;

public class Maquina {
    
    private Long idMaquina;
    private String identificador;
    private String sistemaOperacional;
    private Integer fkTurma;
    private List<Componentes> componentes;
    private Looca looca = new Looca();
    Conexao conexao = new Conexao();
    JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
    
    public Maquina(){}

    public Maquina(Long idMaquina, String identificador, String sistemaOperacional, Integer fkTurma) {
        this.idMaquina = idMaquina;
        this.identificador = identificador;
        this.sistemaOperacional = sistemaOperacional;
        this.fkTurma = fkTurma;
    }
    
    public void informacoesMaquina(){
        identificador = looca.getProcessador().getId();
        sistemaOperacional = looca.getSistema().getSistemaOperacional();
        String insertMaquina = "Insert into dbo.maquina ("
                + "identificador,"
                + "sistemaOperacional,"
                + "fkTurma) values (?,?,?)";
        con.update(insertMaquina,identificador, sistemaOperacional, 1);
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

    public Integer getFkTurma() {
        return fkTurma;
    }

    public void setIdMaquina(Long idMaquina) {
        this.idMaquina = idMaquina;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public void setFkTurma(Integer fkTurma) {
        this.fkTurma = fkTurma;
    }
    
    public void adicionarComponentes(Componentes c) {
    	if(c != null) {
    		componentes.add(c);
    	}
    }
    
    public Componentes getComponente(Long id) {
		for (Componentes componente : componentes) {
			if (componente.getIdComponente().equals(id)) {
				return componente;
			}

		}

		return null;

	}
    
    

    @Override
    public String toString() {
        return "Maquina{" + "idMaquina=" + idMaquina
                + ", identificador=" + identificador 
                + ", sistemaOperacional=" + sistemaOperacional 
                + ", fkTurma=" + fkTurma; 
    }
    
    
}
