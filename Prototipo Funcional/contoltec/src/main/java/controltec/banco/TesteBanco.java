package controltec.banco;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class TesteBanco {
	
	public static void main(String[] args) {
		
		Conexao config = new Conexao();
		
		JdbcTemplate template = new JdbcTemplate(config.getDataSource());
		
		List<?> comando = template.queryForList("select * from instituicao");
		System.out.println(comando);
		
		//dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
	}

}