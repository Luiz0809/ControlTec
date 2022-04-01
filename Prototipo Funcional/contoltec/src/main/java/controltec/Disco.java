package controltec;

public class Disco {
	
	private Long idDisco;
	private String nome;
	private String modelo;
	private String serial;
	private Integer tamanho;
	private Integer leituraEmBytes;
	private Integer escritasEmBytes;
	private Integer tamanhoAtualDaFila;
	private Integer tempoDeTransferencia;
	private Maquina maquina;
	
	public Long getIdDisco() {
		return idDisco;
	}
	public void setIdDisco(Long idDisco) {
		this.idDisco = idDisco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public Integer getTamanho() {
		return tamanho;
	}
	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}
	public Integer getLeituraEmBytes() {
		return leituraEmBytes;
	}
	public void setLeituraEmBytes(Integer leituraEmBytes) {
		this.leituraEmBytes = leituraEmBytes;
	}
	public Integer getEscritasEmBytes() {
		return escritasEmBytes;
	}
	public void setEscritasEmBytes(Integer escritasEmBytes) {
		this.escritasEmBytes = escritasEmBytes;
	}
	public Integer getTamanhoAtualDaFila() {
		return tamanhoAtualDaFila;
	}
	public void setTamanhoAtualDaFila(Integer tamanhoAtualDaFila) {
		this.tamanhoAtualDaFila = tamanhoAtualDaFila;
	}
	public Integer getTempoDeTransferencia() {
		return tempoDeTransferencia;
	}
	public void setTempoDeTransferencia(Integer tempoDeTransferencia) {
		this.tempoDeTransferencia = tempoDeTransferencia;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

}
