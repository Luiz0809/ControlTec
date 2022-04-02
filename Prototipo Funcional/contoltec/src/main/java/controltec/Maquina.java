package controltec;

public class Maquina {

    private Long idMaquina;
    private String codigoMaquina;
    private String descricao;

    public Maquina(){}
    
    public Maquina(Long idMaquina, String codigoMaquina, String descricao) {
        this.idMaquina = idMaquina;
        this.codigoMaquina = codigoMaquina;
        this.descricao = descricao;
    }

    public Long getIdMaquina() {
        return idMaquina;
    }

    public String getCodigoMaquina() {
        return codigoMaquina;
    }

    public String getDescricao() {
        return descricao;
    }


}
