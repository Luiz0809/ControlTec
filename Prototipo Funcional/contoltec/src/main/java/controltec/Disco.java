package controltec;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import controltec.banco.Conexao;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

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
    private Looca looca = new Looca();
    private Conexao conexao = new Conexao();
    private JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());

    public Disco(){}
    public Disco(Long idDisco, String nome, String modelo, String serial, Integer tamanho, Integer leituraEmBytes, Integer escritasEmBytes, Integer tamanhoAtualDaFila, Integer tempoDeTransferencia, Maquina maquina) {
        this.idDisco = idDisco;
        this.nome = nome;
        this.modelo = modelo;
        this.serial = serial;
        this.tamanho = tamanho;
        this.leituraEmBytes = leituraEmBytes;
        this.escritasEmBytes = escritasEmBytes;
        this.tamanhoAtualDaFila = tamanhoAtualDaFila;
        this.tempoDeTransferencia = tempoDeTransferencia;
        this.maquina = maquina;
    }

    public void capturarDadosDeDisco() {

        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        List<com.github.britooo.looca.api.group.discos.Disco> discos = grupoDeDiscos.getDiscos();
        String insertDisco = "INSERT INTO Disco () values"
                + " (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        for (com.github.britooo.looca.api.group.discos.Disco disco : discos) {
            con.update(insertDisco, disco.getNome(), disco.getModelo(),
                    disco.getSerial(), disco.getTamanho(), disco.getBytesDeLeitura(),
                    disco.getBytesDeEscritas(), disco.getTamanhoAtualDaFila(),
                    disco.getTempoDeTransferencia(), 1);
        }
    }

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
