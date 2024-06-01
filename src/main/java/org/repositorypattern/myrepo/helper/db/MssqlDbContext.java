package org.repositorypattern.myrepo.helper.db;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;


@Component
public class MssqlDbContext {


   private final String conn_string =
           "jdbc:sqlserver://RAMOPC\\SQLEXPRESS:1433;databaseName=master;user=sa;Password=12345;trustServerCertificate=true";

    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(conn_string);
    }



}
