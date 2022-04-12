package com.mycompany.controltec.entidades;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.mycompany.controltec.jdbc.Conexao;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsoDeMaquinas {

    private Usuario usuario;
    private Componentes componentes;
    private Instant inicializado;
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

    public UsoDeMaquinas(Usuario usuario, Componentes componentes, Instant inicializado, Long tempoEmUso, Double consumoCPU, Long consumoDisco, Long consumoMemoria, Double temperatura, LocalDateTime hora) {
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

    public UsoDeMaquinas() {
    }

    public void capturarDados() throws InterruptedException {
        while (true) {
            Long consumo = 0L;
            Integer contador = 0;
            contador++;
            inicializado = looca.getSistema().getInicializado();
            tempoEmUso = looca.getSistema().getTempoDeAtividade();
            consumoCPU = looca.getProcessador().getUso();
            for (Disco disco : discos) {
                consumo += disco.getBytesDeEscritas() + disco.getBytesDeLeitura();
            }
            consumo = consumo - grupoDeDiscos.getTamanhoTotal();
            consumoDisco = consumo;
            consumoMemoria = looca.getMemoria().getEmUso();
            temperatura = looca.getTemperatura().getTemperatura();
            hora = LocalDateTime.now();

            String insertLogs = "INSERT INTO Logs ("
                    + "idAluno,"
                    + "idMaquina,"
                    + "temperatura,"
                    + "consumoMemoria,"
                    + "consumoCPU,"
                    + "consumoDisco,"
                    + "tempoEmAtividade,"
                    + "inicializado"
                    + ") values"
                    + " (?, ?, ?, ?, ?, ?, ?, ?)";

            con.update(insertLogs,
                    1,
                    1,
                    temperatura,
                    consumoMemoria,
                    consumoCPU,
                    consumoDisco,
                    tempoEmUso,
                    inicializado);
            System.out.println("Contador "+contador);
            contador++;

            Thread.sleep(2000L);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Componentes getComponentes() {
        return componentes;
    }

    public Instant getInicializado() {
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

}
