package com.mycompany.controltec.entidades;

import java.util.List;

public class Turma {

	private Long idTurma;
	private String nome;
	private String descricao;
	private String sala;
	private Instituicao fkInstituicao;
	private List<Usuario> usuarios;
	private List<Maquina> maquinas;

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

	public void adicionarMaquina(Maquina maquina) {
		if (maquina != null) {

			maquinas.add(maquina);

		}

	}

	public Maquina getMaquina(Long id) {
		if (id != null) {
			for (Maquina maquina : maquinas) {
				if (maquina.getIdMaquina().equals(id)) {
					return maquina;
				}

			}

		}
		return null;
	}

	public void adicionarUsuario(Usuario usuario) {
		if (usuario != null) {

			usuarios.add(usuario);

		}

	}

	public Usuario getUsuario(Long id) {
		if (id != null) {
			for (Usuario usuario : usuarios) {
				if (usuario.getIdUsuario().equals(id)) {
					return usuario;
				}

			}

		}
		return null;
	}

}
