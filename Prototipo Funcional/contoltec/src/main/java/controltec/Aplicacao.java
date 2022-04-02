package controltec;

import controltec.banco.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class Aplicacao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
        
        
    }
}
