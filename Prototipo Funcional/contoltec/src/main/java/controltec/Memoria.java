package controltec;

public class Memoria {
	
	private Long idMemoria;
	private Integer disponivel;
	private Integer total;
	private Maquina fkMaquina;
	
	public Long getIdMemoria() {
		return idMemoria;
	}
	public void setIdMemoria(Long idMemoria) {
		this.idMemoria = idMemoria;
	}
	public Integer getDisponivel() {
		return disponivel;
	}
	public void setDisponivel(Integer disponivel) {
		this.disponivel = disponivel;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Maquina getFkMaquina() {
		return fkMaquina;
	}
	public void setFkMaquina(Maquina fkMaquina) {
		this.fkMaquina = fkMaquina;
	}

}
