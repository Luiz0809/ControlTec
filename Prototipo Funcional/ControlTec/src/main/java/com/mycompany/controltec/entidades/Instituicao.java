package com.mycompany.controltec.entidades;

import java.util.List;

public class Instituicao {

	private Long instituicao;
	private String nome;
	private Integer numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String complemento;
	private String pontoDeReferencia;
	private List<Turma> turmas;
	private List<Usuario> usuarios;

	public Turma getTurmas(Long id) {
		for (Turma turma : turmas) {
			if (turma.getIdTurma().equals(id)) {
				return turma;
			}

		}

		return null;

	}

	public Usuario getUsuarios(Long id) {
		for (Usuario usuario : usuarios) {
			if (usuario.getIdUsuario().equals(id)) {
				return usuario;
			}

		}

		return null;
	}

	public void adicionarTurma(Turma turma) {
		if (turma != null) {
			this.turmas.add(turma);
		}
	}

	public void adicionarUsuario(Usuario usuarios) {
		if (usuarios != null) {
			this.usuarios.add(usuarios);
		}
	}

	public Instituicao(Long instituicao, String nome, Integer numero, String rua, String bairro, String cidade,
			String estado, String cep, String complemento, String pontoDeReferencia) {
		this.instituicao = instituicao;
		this.nome = nome;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.complemento = complemento;
		this.pontoDeReferencia = pontoDeReferencia;
	}

	public Instituicao() {
	}

	public Long getInstituicao() {
		return instituicao;
	}

	public String getNome() {
		return nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getRua() {
		return rua;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getPontoDeReferencia() {
		return pontoDeReferencia;
	}

}
