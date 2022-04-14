package com.mycompany.controltec.entidades;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.mycompany.controltec.jdbc.Conexao;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsoDeMaquinas {

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

    public UsoDeMaquinas(Usuario usuario, Componentes componentes, LocalDateTime inicializado, Long tempoEmUso, Double consumoCPU, Long consumoDisco, Long consumoMemoria, Double temperatura, LocalDateTime hora) {
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

    public void capturarDados(Usuario usuario, Componentes componentes) throws Exception {
        while (true) {
            Long consumo = 0L;
            inicializado = looca.getSistema().getInicializado()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
                    
            tempoEmUso = looca.getSistema().getTempoDeAtividade();
            consumoCPU = looca.getProcessador().getUso();
            
            for (Disco disco : discos) {
                consumo += disco.getLeituras() + disco.getEscritas();
            }

            consumo = consumo;
            consumoDisco = consumo;
            consumoMemoria = looca.getMemoria().getEmUso();
            temperatura = looca.getTemperatura().getTemperatura();
            hora = LocalDateTime.now();

            String insertLogs = "INSERT INTO UsoDeMaquinas ("
                    + "idUsuario,"
                    + "idComponentes,"
                    + "temperatura,"
                    + "consumoMemoria,"
                    + "consumoCPU,"
                    + "consumoDisco,"
                    + "tempoEmUso,"
                    + "inicializado,"
                    + "hora"
                    + ") values"
                    + " (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            con.update(insertLogs,
                    usuario.getIdUsuario(),
                    componentes.getIdComponentes(),
                    temperatura,
                    consumoMemoria,
                    consumoCPU,
                    consumoDisco,
                    tempoEmUso,
                    inicializado.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    hora.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            Thread.sleep(2000L);
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

    @Override
    public String toString() {
        return String.format("IdUsuario : %d\n"
                + "idComponente : %d\n"
                + "Inicializado : %s\n"
                + "Tempo em uso : %s\n"
                + "Consumo CPU : %d\n"
                + "Coonsumo de Memória : %d\n"
                + "Consumo de Disco : %d\n"
                + "Temperatura : %.1f\n"
                + "hora : %s\n"
                + "-".repeat(30),
                usuario.getIdUsuario(),
                componentes.getIdComponentes(),
                inicializado.toString(),
                tempoEmUso.toString(),
                consumoCPU,
                consumoMemoria,
                consumoDisco,
                temperatura,
                hora.toString());
    }

}
