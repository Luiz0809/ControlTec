package com.mycompany.controltec.entidades;

import com.mycompany.controltec.jdbc.Conexao;
import com.mycompany.controltec.jdbc.ConexaoLocal;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class Instituicao {

    private Long IdIinstituicao;
    private String nome;
    private String numeroEndereco;
    private String Rua;
    private String Bairro;
    private String CEP;
    private String complemento;
    private String pontoDeReferencia;
    private String cidade;
    private String estado;
    private String email;
    private String senha;
    private List<Turma> turmas;
    private List<Usuario> usuarios;
    ConexaoLocal conexaoLocal = new ConexaoLocal();
    JdbcTemplate conLocal = new JdbcTemplate(conexaoLocal.getDataSource());
    Conexao conexao = new Conexao();
    JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());

    public Instituicao(Long IdIinstituicao, String nome, String numeroEndereco, String Rua, String Bairro, String CEP, String complemento, String pontoDeReferencia, String cidade, String estado, String email, String senha) {
        this.IdIinstituicao = IdIinstituicao;
        this.nome = nome;
        this.numeroEndereco = numeroEndereco;
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.complemento = complemento;
        this.pontoDeReferencia = pontoDeReferencia;
        this.cidade = cidade;
        this.estado = estado;
        this.email = email;
        this.senha = senha;
    }

    public Instituicao() {}
    
    public Turma getTurmas(Long id) {
        for (Turma turma : turmas) {
            if (turma.getIdTurma().equals(id)) {
                return turma;
            }
        }
        return null;
    }

    public Usuario getUsuarios(Long id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public void adicionarTurma(Turma turma) {
        if (turma != null) {
            this.turmas.add(turma);
        }
    }

    public void adicionarUsuario(Usuario usuarios) {
        if (usuarios != null) {
            this.usuarios.add(usuarios);
        }
    }

    public void criarTabelaInstituicao() {
        String criacaoTabela = "create table if not exists Instituicao(\n"
                + "idInstituicao int primary key auto_increment,\n"
                + "nome varchar(100),\n"
                + "numeroEndereco varchar(9),\n"
                + "Rua varchar(45),\n"
                + "Bairro varchar(45),\n"
                + "CEP varchar(45),\n"
                + "Complemento varchar(100),\n"
                + "pontoReferencia varchar(100),\n"
                + "cidade varchar(50),\n"
                + "estado varchar(2),\n"
                + "email varchar(45),\n"
                + "senha varchar(45)\n"
                + ");";

        String insercaoLocal = "Insert into Instituicao values (?,?,?,?,?,?,?,?,?,?,?,?)";
        conLocal.execute(criacaoTabela);
        List<Instituicao> listaDeInstituicao = con.query("select * from dbo.Instituicao;",
                new BeanPropertyRowMapper(Instituicao.class));
        
        List<Instituicao> listaDeInstituicaoLocal = conLocal.query("select * from Instituicao;",
                new BeanPropertyRowMapper(Instituicao.class));
        
        if (listaDeInstituicaoLocal.isEmpty()) {
            for (Instituicao instituicao : listaDeInstituicao) {
                conLocal.update(insercaoLocal,
                        instituicao.getIdIinstituicao(),
                        instituicao.getNome(),
                        instituicao.getNumeroEndereco(),
                        instituicao.getRua(),
                        instituicao.getBairro(),
                        instituicao.getCEP(),
                        instituicao.getComplemento(),
                        instituicao.getPontoDeReferencia(),
                        instituicao.getCidade(),
                        instituicao.getEstado(),
                        instituicao.getEmail(),
                        instituicao.getSenha());
            }
        }
    }

    public Long getIdIinstituicao() {
        return IdIinstituicao;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public String getRua() {
        return Rua;
    }

    public String getBairro() {
        return Bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Instituicao{" + ""
                + "IdIinstituicao=" + IdIinstituicao + ", \n"
                + "nome=" + nome + ", \n"
                + "numeroEndereco=" + numeroEndereco + ", \n"
                + "Rua=" + Rua + ", \n"
                + "Bairro=" + Bairro + ", \n"
                + "CEP=" + CEP + ", \n"
                + "complemento=" + complemento + ", \n"
                + "pontoDeReferencia=" + pontoDeReferencia + ", \n"
                + "cidade=" + cidade + ", \n"
                + "estado=" + estado + ", \n"
                + "email=" + email + ", \n"
                + "senha=" + senha + '}';
    }

   

}
