package com.mycompany.controltec.entidades;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mycompany.controltec.jdbc.Conexao;

public class Professor extends Usuario {
	
	 
	
	  Conexao conexao = new Conexao();
	  JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
	  
	
	public void todosAsMaquinasEmUso(){
		con.execute("select * from [dbo].[UsoDeMaquina]");
	}

}
