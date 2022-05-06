package com.mycompany.controltec.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {

    private BasicDataSource dataSource;

    public Conexao() {

        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://controltech.database.windows.net:1433;"
                + "database=controltec;user=controltec@controltech;"
                + "password={2ads@grupo2};"
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource.setUsername("controltec");
        dataSource.setPassword("2ads@grupo2");

    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
}
