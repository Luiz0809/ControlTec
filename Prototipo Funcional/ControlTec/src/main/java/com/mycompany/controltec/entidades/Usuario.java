package com.mycompany.controltec.entidades;

import java.util.Date;

public class Usuario {
    
    protected Long idUsuario;
    private String nome;
    private Date dataNascimento;
    private String codigoInstituicao;
    private String email;
    private String senha;
    private String tipoUsuario;
    private Instituicao fkInstituicao;
    
    public Usuario(){}

    public Usuario(Long idUsuario, String nome, Date dataNascimento, String codigoInstituicao, String email, String senha, String tipoUsuario, Instituicao fkInstituicao) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.codigoInstituicao = codigoInstituicao;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.fkInstituicao = fkInstituicao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCodigoInstituicao() {
        return codigoInstituicao;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public Instituicao getFkInstituicao() {
        return fkInstituicao;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCodigoInstituicao(String codigoInstituicao) {
        this.codigoInstituicao = codigoInstituicao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    @Override
    public String toString() {
        return String.format("Id do Usuario : %d\n"
                + "nome : %s\n ", idUsuario, nome);
                
    }
    
}
