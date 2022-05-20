package com.mycompany.controltec.entidades;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mycompany.controltec.jdbc.Conexao;

public class Aluno extends Usuario{
	
	  Conexao conexao = new Conexao();
	  JdbcTemplate con = new JdbcTemplate(conexao.getDataSource());
	  
	  public void meuUsoDeMaquina() {
		  con.execute("select * from UsoDeMaquina where id Usuario = " + idUsuario);
	  }

}
