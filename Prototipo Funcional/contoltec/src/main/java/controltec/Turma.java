package controltec;

public class Turma {
	
	private Long idTurma;
	private String nome;
	private String descricao;
	private String sala;
	private Integer fkInstituicao;

    public Turma(Long idTurma, String nome, String descricao, String sala, Integer fkInstituicao) {
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

	public Integer getFkInstituicao() {
		return fkInstituicao;
	}
        

}
