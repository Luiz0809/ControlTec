package controltec;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import controltec.banco.Conexao;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

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
    private Looca looca = new Looca();
    private Conexao conexao = new Conexao();
    private JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());

    public Logs() {
    }

    public Logs(Usuario usuario, Maquina maquina, Long momento, Double temperatura, Integer consumoMemoria, Integer consumoCpu, String programaUsado, Integer consumoDisco, Integer tempoEmUso, Date inicializado) {
        this.usuario = usuario;
        this.maquina = maquina;
        this.momento = momento;
        this.temperatura = temperatura;
        this.consumoMemoria = consumoMemoria;
        this.consumoCpu = consumoCpu;
        this.programaUsado = programaUsado;
        this.consumoDisco = consumoDisco;
        this.tempoEmUso = tempoEmUso;
        this.inicializado = inicializado;
    }

    public void capturarDadosDaMaquina() throws InterruptedException {
        int contador = 1;
        while (true) {
            Long idUsuario = 1L;
            Long idMaquina = 1L;
            Long consumindo = 0L;
            Instant momento = null;
            Double temperatura = looca.getTemperatura().getTemperatura();
            Long consumoMemoria = looca.getMemoria().getEmUso();
            Double consumoCPU = looca.getProcessador().getUso();
            DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
            List<com.github.britooo.looca.api.group.discos.Disco> discos = grupoDeDiscos.getDiscos();
            for (com.github.britooo.looca.api.group.discos.Disco disco : discos) {
                consumindo += disco.getBytesDeEscritas();
                consumindo += disco.getBytesDeLeitura();
            }
            Long consumoDisco = looca.getGrupoDeDiscos().getTamanhoTotal() - consumindo;

            String tempoEmAtividade = Conversor.formatarSegundosDecorridos(looca.getSistema().getTempoDeAtividade());
            String inicializado = looca.getSistema().getInicializado().toString();
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

            System.out.println(String.format("Capturando dado Nº%d", contador));

            con.update(insertLogs,
                    idUsuario,
                    idMaquina,
                    temperatura,
                    consumoMemoria,
                    consumoCPU,
                    consumoDisco,
                    tempoEmAtividade,
                    inicializado);

            Thread.sleep(2000L);
            contador++;

        }
    }

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
