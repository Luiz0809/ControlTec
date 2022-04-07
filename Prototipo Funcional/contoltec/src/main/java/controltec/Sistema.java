package controltec;

public class Sistema {
	
	private Long idDisco;
	private String nome;
	private String modelo;
	private String serial;
	private Integer tamanho;
	private Integer leituraEmBytes;
	private Integer escritasEmBytes;
	private Integer tamanhoAtualDaFila;
	private Integer tempoDeTransferencia;
	private Maquina fkMaquina;

    public Sistema(Long idDisco, String nome, String modelo, String serial, Integer tamanho, Integer leituraEmBytes, Integer escritasEmBytes, Integer tamanhoAtualDaFila, Integer tempoDeTransferencia, Maquina fkMaquina) {
        this.idDisco = idDisco;
        this.nome = nome;
        this.modelo = modelo;
        this.serial = serial;
        this.tamanho = tamanho;
        this.leituraEmBytes = leituraEmBytes;
        this.escritasEmBytes = escritasEmBytes;
        this.tamanhoAtualDaFila = tamanhoAtualDaFila;
        this.tempoDeTransferencia = tempoDeTransferencia;
        this.fkMaquina = fkMaquina;
    }

	public Long getIdDisco() {
		return idDisco;
	}

	public String getNome() {
		return nome;
	}

	public String getModelo() {
		return modelo;
	}

	public String getSerial() {
		return serial;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public Integer getLeituraEmBytes() {
		return leituraEmBytes;
	}

	public Integer getEscritasEmBytes() {
		return escritasEmBytes;
	}

	public Integer getTamanhoAtualDaFila() {
		return tamanhoAtualDaFila;
	}

	public Integer getTempoDeTransferencia() {
		return tempoDeTransferencia;
	}

	public Maquina getFkMaquina() {
		return fkMaquina;
	}
        
}
