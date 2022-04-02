package controltec;

public class Maquina {
	
	private Long idMaquina;
	private String codigoMaquina;
	private String descricao;

    public Maquina(Long idMaquina, String codigoMaquina, String descricao) {
        this.idMaquina = idMaquina;
        this.codigoMaquina = codigoMaquina;
        this.descricao = descricao;
    }
	
        
	public Long getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(Long idMaquina) {
		this.idMaquina = idMaquina;
	}
	public String getCodigoMaquina() {
		return codigoMaquina;
	}
	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
