package com.mycompany.controltec.entidades;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.mycompany.controltec.jdbc.Conexao;
import com.mycompany.controltec.slack.SlackIntegrationTest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsoDeMaquina {

    private Usuario usuario;
    private Componentes componentes;
    private LocalDateTime inicializado;
    private Long tempoEmUso;
    private Double consumoCPU;
    private Long consumoDisco;
    private Long consumoMemoria;
    private Double temperatura;
    private LocalDateTime hora;
    private Looca looca = new Looca();
    DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
    private List<Disco> discos = grupoDeDiscos.getDiscos();
    Conexao conexao = new Conexao();
    JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());

    public UsoDeMaquina(Usuario usuario, Componentes componentes, LocalDateTime inicializado, Long tempoEmUso, Double consumoCPU, Long consumoDisco, Long consumoMemoria, Double temperatura, LocalDateTime hora) {
        this.usuario = usuario;
        this.componentes = componentes;
        this.inicializado = inicializado;
        this.tempoEmUso = tempoEmUso;
        this.consumoCPU = consumoCPU;
        this.consumoDisco = consumoDisco;
        this.consumoMemoria = consumoMemoria;
        this.temperatura = temperatura;
        this.hora = hora;
    }

    public UsoDeMaquina() {
    }

    public void capturarDados(Usuario usuario, Componentes componentes) throws IOException {

        inicializado = looca.getSistema()
                .getInicializado()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        tempoEmUso = looca.getSistema().getTempoDeAtividade();
        consumoCPU = looca.getProcessador().getUso();

        Long consumo = 0L;
        for (Disco disco : discos) {
            consumo += disco.getBytesDeEscritas() + disco.getBytesDeLeitura();
        }
        
        consumoDisco = consumo;
        consumoMemoria = looca.getMemoria().getEmUso();
        temperatura = looca.getTemperatura().getTemperatura();
        hora = LocalDateTime.now();

        String insertLogs = "INSERT INTO dbo.UsoDeMaquina ("
                + "Usuario,"
                + "Componentes,"
                + "temperatura,"
                + "consumoMemoriaEmBytes,"
                + "consumoCPU,"
                + "consumoDiscoEmBytes,"
                + "tempoEmUso,"
                + "inicializado,"
                + "hora"
                + ") values"
                + " (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        con.update(insertLogs,
                usuario.getIdUsuario(),
                componentes.getIdComponente(),
                temperatura,
                consumoMemoria,
                consumoCPU,
                consumoDisco,
                tempoEmUso,
                inicializado.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                hora.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        if(consumoCPU > 75){
            SlackIntegrationTest.sendMessageToSlack("Sr.(a) "+ usuario.getNome()
                    + ", sua máquina está com consumo de CPU acima de 75%"
                    + ", nosso Script de correção será ativado automáticamente");
        }
        
        Long porcentagemMemoria = (consumoMemoria*100/looca.getMemoria().getTotal()*100)/100;
        if(porcentagemMemoria > 75){
            SlackIntegrationTest.sendMessageToSlack("Sr.(a) "+ usuario.getNome()
                    + ", sua máquina está com consumo de Memória acima de 75%"
                    + ", nosso Script de correção será ativado automáticamente");
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Componentes getComponentes() {
        return componentes;
    }

    public LocalDateTime getInicializado() {
        return inicializado;
    }

    public Long getTempoEmUso() {
        return tempoEmUso;
    }

    public Double getConsumoCPU() {
        return consumoCPU;
    }

    public Long getConsumoDisco() {
        return consumoDisco;
    }

    public Long getConsumoMemoria() {
        return consumoMemoria;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setComponentes(Componentes componentes) {
        this.componentes = componentes;
    }

    public void setInicializado(LocalDateTime inicializado) {
        this.inicializado = inicializado;
    }

    public void setTempoEmUso(Long tempoEmUso) {
        this.tempoEmUso = tempoEmUso;
    }

    public void setConsumoCPU(Double consumoCPU) {
        this.consumoCPU = consumoCPU;
    }

    public void setConsumoDisco(Long consumoDisco) {
        this.consumoDisco = consumoDisco;
    }

    public void setConsumoMemoria(Long consumoMemoria) {
        this.consumoMemoria = consumoMemoria;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public void setLooca(Looca looca) {
        this.looca = looca;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }

    @Override
    public String toString() {
        return String.format("IdUsuario : %d\n" +
"                             idComponente : %d\n" +
"                             Inicializado : %s\n" +
"                             Tempo em uso : %s\n" +
"                             Consumo CPU : %.1f\n" +
"                             Coonsumo de Memória : %d\n" +
"                             Consumo de Disco : %d\n" +
"                             Temperatura : %.1f\n" +
"                             hora : %s"
                + "-".repeat(30),
                4,
                3,
                looca.getSistema().getInicializado(),
                looca.getSistema().getTempoDeAtividade(),
                looca.getProcessador().getUso(),
                looca.getMemoria().getEmUso(),
                consumoDisco,
                looca.getTemperatura().getTemperatura(),
                LocalDateTime.now().toString());
    }

}
