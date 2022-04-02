package controltec;


import java.util.Calendar;

public class Usuario {
	
	private Long idUsuario;
	private String nome;
	private Calendar dataNascimento;
	private String codigoInstituicao;
	private String email;
	private String senha;
	private String tipoUsuario;
	private Integer fkInstituicao;
   

    public Usuario(Long idUsuario, String nome, Calendar dataNascimento, String codigoInstituicao, String email, String senha, String tipoUsuario, Integer fkInstituicao) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.codigoInstituicao = codigoInstituicao;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.fkInstituicao = fkInstituicao;
    }

    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCodigoInstituicao() {
        return codigoInstituicao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public Integer getFkInstituicao() {
        return fkInstituicao;
    }

    @Override
    public String toString() {
        return String.format("Nome do Aluno : %s\n"
                + "Data de nascimento : %s\n"
                + "E-mail : %s\n"
                + "Tipo de Usuário : %s\n"
                + "Instituição : %s\n"
                + "Código da instituição : %s\n",
                nome, dataNascimento.toString(), email, tipoUsuario,
                fkInstituicao, codigoInstituicao);
    }


    
	
	

}
