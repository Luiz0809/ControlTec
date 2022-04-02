package controltec;

import controltec.banco.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class Aplicacao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
        Disco disco = new Disco();
        
        con.execute("DROP TABLE IF EXISTS Disco");
        StringBuilder create = new StringBuilder();
        
        create.append("CREATE TABLE Disco (");
        create.append("idDisco int primary key auto_increment,");
        create.append("nome VARCHAR(45),");
        create.append("modelo VARCHAR(150),");
        create.append("serial VARCHAR(45),");
        create.append("tamanho bigint(20),");
        create.append("leiturasEmBytes bigint(20),");
        create.append("escritasEmBytes bigint(20),");
        create.append("tamanhoAtualDaFila bigint(20),");
        create.append("tempoDeTransferencia bigint(20),");
        create.append("fkMaquina int");
//        create.append("foreing key (fkMaquina) references Maquina(idMaquina)");
        create.append(");");
        
        con.update(create.toString());
        
        disco.capturarDadosDeDisco();
    }
}
