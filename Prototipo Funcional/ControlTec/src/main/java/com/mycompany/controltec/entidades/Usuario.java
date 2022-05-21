package com.mycompany.controltec.entidades;

import com.mycompany.controltec.jdbc.Conexao;
import com.mycompany.controltec.jdbc.ConexaoLocal;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class Usuario {

    protected Long idUsuario;
    private String nome;
    private Date dataNascimento;
    private String codigoInstituicao;
    private String email;
    private String senha;
    private String tipoUsuario;
    private Instituicao fkInstituicao;
    ConexaoLocal conexaoLocal = new ConexaoLocal();
    JdbcTemplate conLocal = new JdbcTemplate(conexaoLocal.getDataSource());
    Conexao conexao = new Conexao();
    JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nome, Date dataNascimento, String codigoInstituicao, String email, String senha, String tipoUsuario, Instituicao fkInstituicao) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.codigoInstituicao = codigoInstituicao;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.fkInstituicao = fkInstituicao;
    }

    public void criarTabelaUsuario() {
        String criacaoTabela = "create table if not exists Usuario  (\n"
                + "idUsuario int primary key auto_increment,\n"
                + "nome varchar(45),\n"
                + "dataNascimento date,\n"
                + "email varchar(50),\n"
                + "senha varchar(50),\n"
                + "tipo_usuario varchar(20),\n"
                + "fkInstituicao int,\n"
                + "foreign key (fkInstituicao) references Instituicao(idInstituicao)\n"
                + ");";

        String insercaoLocal = "Insert into Usuario values (?,?,?,?,?,?,?)";
        conLocal.execute(criacaoTabela);
        List<Usuario> listaDeUsuarios = con.query("select *from dbo.Usuario;",
                new BeanPropertyRowMapper(Usuario.class));

        List<Usuario> listaDeUsuariosLocal = conLocal.query("select *from Usuario;",
                new BeanPropertyRowMapper(Usuario.class));

        if (listaDeUsuariosLocal.isEmpty()) {
            for (Usuario usuario : listaDeUsuarios) {
                conLocal.update(insercaoLocal,
                        usuario.getIdUsuario(),
                        usuario.getNome(),
                        usuario.getDataNascimento(),
                        usuario.getEmail(),
                        usuario.getSenha(),
                        usuario.getTipoUsuario(),
                        usuario.getFkInstituicao());
            }
        }
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCodigoInstituicao() {
        return codigoInstituicao;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public Instituicao getFkInstituicao() {
        return fkInstituicao;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCodigoInstituicao(String codigoInstituicao) {
        this.codigoInstituicao = codigoInstituicao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return String.format("Id do Usuario : %d\n"
                + "nome : %s\n ", idUsuario, nome);

    }

}
