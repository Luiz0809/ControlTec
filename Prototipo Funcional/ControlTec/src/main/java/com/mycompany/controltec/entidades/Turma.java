package com.mycompany.controltec.entidades;

public class Turma {
	
	private Long idTurma;
	private String nome;
	private String descricao;
	private String sala;
        private Instituicao fkInstituicao;

    public Turma(Long idTurma, String nome, String descricao, String sala, Instituicao fkInstituicao) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.descricao = descricao;
        this.sala = sala;
        this.fkInstituicao = fkInstituicao;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSala() {
        return sala;
    }

    public Instituicao getFkInstituicao() {
        return fkInstituicao;
    }
	
        
        
      
}
