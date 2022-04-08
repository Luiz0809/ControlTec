package com.mycompany.controltec.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {
    private BasicDataSource dataSource;
	
	public Conexao() {
		
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/Teste?useTimezone=true&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("102025fe");
		
	}
	
	public BasicDataSource getDataSource() {
		return dataSource;
	}
}
