package com.mycompany.controltec.entidades;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.controltec.jdbc.Conexao;
import com.mycompany.controltec.jdbc.ConexaoLocal;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class Maquina {

    private Long idMaquina;
    private String identificador;
    private String sistemaOperacional;
    private Long fkTurma;
    private List<Componentes> componentes;
    private Looca looca = new Looca();
    Conexao conexao = new Conexao();
    JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
    ConexaoLocal conexaoLocal = new ConexaoLocal();
    JdbcTemplate conLocal = new JdbcTemplate(conexaoLocal.getDataSource());

    public Maquina() {
    }

    public Maquina(Long idMaquina, String identificador, String sistemaOperacional, Long fkTurma) {
        this.idMaquina = idMaquina;
        this.identificador = identificador;
        this.sistemaOperacional = sistemaOperacional;
        this.fkTurma = fkTurma;
    }

    public void informacoesMaquina(Long fkTurma) {
        identificador = looca.getProcessador().getId();
        sistemaOperacional = looca.getSistema().getSistemaOperacional();
        String insertMaquina = "Insert into dbo.maquina ("
                + "identificador,"
                + "sistemaOperacional,"
                + "fkTurma) values (?,?,?)";
        con.update(insertMaquina, identificador, sistemaOperacional, 1);
        
        String insertMaquinaLocal = "Insert into dbo.maquina ("
                + "identificador,"
                + "sistemaOperacional,"
                + "fkTurma) values (?,?,?)";
        con.update(insertMaquinaLocal, identificador, sistemaOperacional, fkTurma);
    }

    public void criarTabelaMaquina() {
        String criacaoTabela = "create table if not exists Maquina (\n"
                + "idMaquina int primary key auto_increment,\n"
                + "identificador varchar(100),\n"
                + "sistemaOperacional varchar(45),\n"
                + "fkTurma int\n"
                + ");";

        String insercaoLocal = "Insert into Maquina values (?,?,?,?)";
        conLocal.execute(criacaoTabela);
        List<Maquina> listaDeMaquina = con.query("select *from dbo.Maquina;",
                new BeanPropertyRowMapper(Maquina.class));

        List<Maquina> listaDeMaquinaLocal = conLocal.query("select *from Maquina;",
                new BeanPropertyRowMapper(Maquina.class));

        if (listaDeMaquinaLocal.isEmpty()) {
            for (Maquina maquina : listaDeMaquina) {
                conLocal.update(insercaoLocal,
                        maquina.getIdMaquina(),
                        maquina.getIdentificador(),
                        maquina.getSistemaOperacional(),
                        maquina.getFkTurma());
            }
        }
    }

    public void adicionarComponentesTabela(Long idMaquina){
        String insertComponentes = "INSERT INTO dbo.Componentes ("
                + "idComponente,"
                + "nomeComponente,"
                + "modeloComponente,"
                + "tamanhoComponenteEmBytes,"
                + "fkMaquina);";

        String insertComponentesLocal = "INSERT INTO Componentes ("
                + "idComponente,"
                + "nomeComponente,"
                + "modeloComponente,"
                + "tamanhoComponenteEmBytes,"
                + "fkMaquina);";
        
       

        con.update(insertComponentes,
                null,
                "Memória",
                "Hard-Disk",
                looca.getMemoria().getTotal(),
                idMaquina);
        
        con.update(insertComponentes,
                null,
                "Disco",
                "HD",
                looca.getGrupoDeDiscos().getTamanhoTotal(),
                idMaquina);

        conLocal.update(insertComponentesLocal,
                null,
                "Memória",
                "Hard-Disk",
                looca.getMemoria().getTotal(),
                idMaquina);
        
        con.update(insertComponentesLocal,
                null,
                "Disco",
                "HD",
                looca.getGrupoDeDiscos().getTamanhoTotal(),
                idMaquina);
    }
    public Long getIdMaquina() {
        return idMaquina;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public Long getFkTurma() {
        return fkTurma;
    }

    public void setIdMaquina(Long idMaquina) {
        this.idMaquina = idMaquina;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public void setFkTurma(Long fkTurma) {
        this.fkTurma = fkTurma;
    }

    public void adicionarComponentes(Componentes c) {
        if (c != null) {
            componentes.add(c);
        }
    }

    public Componentes getComponente(Long id) {
        for (Componentes componente : componentes) {
            if (componente.getIdComponente().equals(id)) {
                return componente;
            }

        }

        return null;

    }

    @Override
    public String toString() {
        return "Maquina{" + "idMaquina=" + idMaquina
                + ", identificador=" + identificador
                + ", sistemaOperacional=" + sistemaOperacional
                + ", fkTurma=" + fkTurma;
    }

}
