package controltec;

import controltec.banco.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class Aplicacao {
    public static void main(String[] args) throws InterruptedException {
        Conexao conexao = new Conexao();
        JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
        Disco disco = new Disco();
        
        con.execute("DROP TABLE IF EXISTS Logs");
        StringBuilder create = new StringBuilder();
        
        create.append("CREATE TABLE Logs (");
        create.append("idAluno int,");
        create.append("idMaquina int,");
        create.append("momento datetime default current_timestamp,");
        create.append("temperatura float,");
        create.append("consumoMemoria bigint(20),");
        create.append("consumoCPU bigint(20),");
        create.append("consumoDisco bigint(20),");
        create.append("tempoEmAtividade Varchar(100),");
        create.append("Inicializado MEDIUMTEXT");
        create.append(");");
        
        con.update(create.toString());
        
        Logs logs = new Logs();
        logs.capturarDadosDaMaquina();
    }
}
