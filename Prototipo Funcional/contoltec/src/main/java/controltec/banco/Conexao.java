package controltec.banco;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {
	
	private BasicDataSource dataSource;
	
	public Conexao() {
		
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/teste?useTimezone=true&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("******");
		
	}
	
	public BasicDataSource getDataSource() {
		return dataSource;
	}

}
