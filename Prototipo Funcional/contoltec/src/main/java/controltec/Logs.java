package controltec;

import java.sql.Date;

public class Logs {
	
	private Usuario usuario;
	private Maquina maquina;
	private Long momento;
	private Double temperatura;
	private Integer consumoMemoria;
	private Integer consumoCpu;
	private String programaUsado;
	private Integer consumoDisco;
	private Integer tempoEmUso;
	private Date inicializado;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Maquina getMaquina() {
		return maquina;
	}
	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}
	public Long getMomento() {
		return momento;
	}
	public void setMomento(Long momento) {
		this.momento = momento;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public Integer getConsumoMemoria() {
		return consumoMemoria;
	}
	public void setConsumoMemoria(Integer consumoMemoria) {
		this.consumoMemoria = consumoMemoria;
	}
	public Integer getConsumoCpu() {
		return consumoCpu;
	}
	public void setConsumoCpu(Integer consumoCpu) {
		this.consumoCpu = consumoCpu;
	}
	public String getProgramaUsado() {
		return programaUsado;
	}
	public void setProgramaUsado(String programaUsado) {
		this.programaUsado = programaUsado;
	}
	public Integer getConsumoDisco() {
		return consumoDisco;
	}
	public void setConsumoDisco(Integer consumoDisco) {
		this.consumoDisco = consumoDisco;
	}
	public Integer getTempoEmUso() {
		return tempoEmUso;
	}
	public void setTempoEmUso(Integer tempoEmUso) {
		this.tempoEmUso = tempoEmUso;
	}
	public Date getInicializado() {
		return inicializado;
	}
	public void setInicializado(Date inicializado) {
		this.inicializado = inicializado;
	}

}
