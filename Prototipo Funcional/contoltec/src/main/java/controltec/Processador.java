package controltec;

public class Processador {

    private Long idProcessador;
    private String fabricante;
    private String nome;
    private String identificador;
    private String microarquitetura;
    private Integer frequencia;
    private Integer pacotesFisicos;
    private Integer cpusFisicas;
    private Integer uso;
    private Maquina fkMaquina;

    public Processador(Long idProcessador, String fabricante, String nome, String identificador, String microarquitetura, Integer frequencia, Integer pacotesFisicos, Integer cpusFisicas, Integer uso, Maquina fkMaquina) {
        this.idProcessador = idProcessador;
        this.fabricante = fabricante;
        this.nome = nome;
        this.identificador = identificador;
        this.microarquitetura = microarquitetura;
        this.frequencia = frequencia;
        this.pacotesFisicos = pacotesFisicos;
        this.cpusFisicas = cpusFisicas;
        this.uso = uso;
        this.fkMaquina = fkMaquina;
    }

	public Long getIdProcessador() {
		return idProcessador;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getNome() {
		return nome;
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getMicroarquitetura() {
		return microarquitetura;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public Integer getPacotesFisicos() {
		return pacotesFisicos;
	}

	public Integer getCpusFisicas() {
		return cpusFisicas;
	}

	public Integer getUso() {
		return uso;
	}

	public Maquina getFkMaquina() {
		return fkMaquina;
	}


}
