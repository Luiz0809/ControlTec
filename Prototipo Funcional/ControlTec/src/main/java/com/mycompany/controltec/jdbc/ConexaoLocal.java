package com.mycompany.controltec.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexaoLocal {

    private BasicDataSource dataSource;

    public ConexaoLocal() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.20.20.4:3306/ControlTec?useTimezone=true&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("102025fe");
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
