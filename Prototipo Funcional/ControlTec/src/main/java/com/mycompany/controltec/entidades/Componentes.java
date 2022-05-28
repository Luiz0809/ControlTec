package com.mycompany.controltec.entidades;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.controltec.jdbc.Conexao;
import com.mycompany.controltec.jdbc.ConexaoLocal;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Componentes extends Maquina {

    private Long idComponente;
    private String nomeComponente;
    private String modeloComponente;
    private Long tamanhoComponenteEmBytes;
    private Long fkMaquina;
    ConexaoLocal conexaoLocal = new ConexaoLocal();
    JdbcTemplate conLocal = new JdbcTemplate(conexaoLocal.getDataSource());
    Conexao conexao = new Conexao();
    JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
    Looca looca = new Looca();

    public Componentes() {
    }

    public Componentes(Long idComponente, String nomeComponente, String modeloComponente, Long tamanhoComponenteEmBytes, Long fkMaquina) {
        this.idComponente = idComponente;
        this.nomeComponente = nomeComponente;
        this.modeloComponente = modeloComponente;
        this.tamanhoComponenteEmBytes = tamanhoComponenteEmBytes;
        this.fkMaquina = fkMaquina;
    }

    public void cadastrarComponente(String nomeComponente, String modeloComponente, String tipoComponente, Long Maquina) {
        String insercao = "Insert into dbo.Componentes ("
                + "nomeComponente,"
                + "modeloComponente,"
                + "tamanhoComponenteEmBytes,"
                + "fkMaquina)"
                + " values (?,?,?,?)";

        if (tipoComponente.equalsIgnoreCase("Memória")) {
            con.update(insercao,
                    nomeComponente,
                    modeloComponente,
                    looca.getMemoria().getTotal(),
                    Maquina);
        }
        if (tipoComponente.equalsIgnoreCase("Disco")) {
            con.update(insercao,
                    nomeComponente,
                    modeloComponente,
                    looca.getGrupoDeDiscos().getDiscos().get(0).getTamanho(),
                    Maquina);
        }
    }

    public void criarTabelaComponentes() {
        String criacaoTabela = "create table if not exists Componentes (\n"
                + "idComponente int primary key auto_increment,\n"
                + "nomeComponente varchar(45),\n"
                + "modeloComponente varchar(45),\n"
                + "tamanhoComponenteEmBytes bigint,\n"
                + "fkMaquina int,\n"
                + "foreign key (fkMaquina) references Maquina(idMaquina)\n"
                + ");";

        String insercaoLocal = "Insert into Componentes values (?,?,?,?,?)";
        conLocal.execute(criacaoTabela);
        List<Componentes> listaDeComponentes = con.query("select *from dbo.Componentes;",
                new BeanPropertyRowMapper(Componentes.class));

        List<Componentes> listaDeComponentesLocal = conLocal.query("select *from Componentes;",
                new BeanPropertyRowMapper(Componentes.class));

        if (listaDeComponentesLocal.isEmpty()) {
            for (Componentes componentes : listaDeComponentes) {
                conLocal.update(insercaoLocal,
                        componentes.getIdComponente(),
                        componentes.getNomeComponente(),
                        componentes.getModeloComponente(),
                        componentes.getTamanhoComponenteEmBytes(),
                        componentes.getFkMaquina());
            }
        }
    }

    public Long getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Long idComponente) {
        this.idComponente = idComponente;
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public String getModeloComponente() {
        return modeloComponente;
    }

    public void setModeloComponente(String modeloComponente) {
        this.modeloComponente = modeloComponente;
    }

    public Long getTamanhoComponenteEmBytes() {
        return tamanhoComponenteEmBytes;
    }

    public void setTamanhoComponenteEmBytes(Long tamanhoComponenteEmBytes) {
        this.tamanhoComponenteEmBytes = tamanhoComponenteEmBytes;
    }

    public Long getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Long fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return "Componentes{" + "idComponente=" + idComponente + ", nomeComponente=" + nomeComponente + ", modeloComponente=" + modeloComponente + ", tamanhoComponenteEmBytes=" + tamanhoComponenteEmBytes + ", fkMaquina=" + fkMaquina + '}';
    }

}
