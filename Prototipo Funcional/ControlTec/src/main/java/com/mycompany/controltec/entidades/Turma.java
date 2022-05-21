package com.mycompany.controltec.entidades;

import com.mycompany.controltec.jdbc.Conexao;
import com.mycompany.controltec.jdbc.ConexaoLocal;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Turma {

    private Long idTurma;
    private String nome;
    private String descricao;
    private String sala;
    private Instituicao fkInstituicao;
    private List<Usuario> usuarios;
    private List<Maquina> maquinas;
    Conexao conexao = new Conexao();
    JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
    ConexaoLocal conexaoLocal = new ConexaoLocal();
    JdbcTemplate conLocal = new JdbcTemplate(conexaoLocal.getDataSource());

    public Turma(Long idTurma, String nome, String descricao, String sala, Instituicao fkInstituicao) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.descricao = descricao;
        this.sala = sala;
        this.fkInstituicao = fkInstituicao;
    }

    public Turma(){}
    
    public void criarTabelaTurma() {
        String criacaoTabela = "create table if not exists Turma(\n"
                + "idTurma int primary key auto_increment,\n"
                + "nome varchar(45),\n"
                + "descricao varchar(45),\n"
                + "sala varchar(10),\n"
                + "fkInstituicao int,\n"
                + "foreign key (fkInstituicao) references Instituicao(idInstituicao)\n"
                + ");";

        String insercaoLocal = "Insert into Turma values (?,?,?,?,?)";
        conLocal.execute(criacaoTabela);
        List<Turma> listaDeTurma = con.query("select *from dbo.Turma;",
                new BeanPropertyRowMapper(Turma.class));

        List<Turma> listaDeTurmaLocal = conLocal.query("select *from Turma;",
                new BeanPropertyRowMapper(Turma.class));

        if (listaDeTurmaLocal.isEmpty()) {
            for (Turma turma : listaDeTurma) {
                conLocal.update(insercaoLocal,
                        turma.getIdTurma(),
                        turma.getNome(),
                        turma.getDescricao(),
                        turma.getSala(),
                        turma.getFkInstituicao());
            }
        }
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSala() {
        return sala;
    }

    public Instituicao getFkInstituicao() {
        return fkInstituicao;
    }

    public void adicionarMaquina(Maquina maquina) {
        if (maquina != null) {

            maquinas.add(maquina);

        }

    }

    public Maquina getMaquina(Long id) {
        if (id != null) {
            for (Maquina maquina : maquinas) {
                if (maquina.getIdMaquina().equals(id)) {
                    return maquina;
                }

            }

        }
        return null;
    }

    public void adicionarUsuario(Usuario usuario) {
        if (usuario != null) {

            usuarios.add(usuario);

        }

    }

    public Usuario getUsuario(Long id) {
        if (id != null) {
            for (Usuario usuario : usuarios) {
                if (usuario.getIdUsuario().equals(id)) {
                    return usuario;
                }

            }

        }
        return null;
    }

    @Override
    public String toString() {
        return "Turma{" + "idTurma=" + idTurma + ", nome=" + nome + ", descricao=" + descricao + ", sala=" + sala + ", fkInstituicao=" + fkInstituicao + '}';
    }

 
}
