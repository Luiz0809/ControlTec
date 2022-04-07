package controltec;

public class Memoria {

    private Long idMemoria;
    private Integer disponivel;
    private Integer total;
    private Maquina fkMaquina;

    public Memoria(Long idMemoria, Integer disponivel, Integer total, Maquina fkMaquina) {
        this.idMemoria = idMemoria;
        this.disponivel = disponivel;
        this.total = total;
        this.fkMaquina = fkMaquina;
    }

	public Long getIdMemoria() {
		return idMemoria;
	}

	public Integer getDisponivel() {
		return disponivel;
	}

	public Integer getTotal() {
		return total;
	}

	public Maquina getFkMaquina() {
		return fkMaquina;
	}

   

}
