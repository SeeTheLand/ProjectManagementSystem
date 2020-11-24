package com.dermentli.projectmanagementsystem.datasource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyDataSourceFactory {
    public static DataSource getMyPostrgresDataSource() {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        PostgresDataSource postgresDS = new PostgresDataSource();
        try {
            fileInputStream = new FileInputStream("src/main/resources/db.properties");
            properties.load(fileInputStream);
            assert postgresDS != null;
            postgresDS.setUrl(properties.getProperty("POSTGRES_DB_URL"));
            postgresDS.setUser(properties.getProperty("POSTGRES_DB_USERNAME"));
            postgresDS.setPassword(properties.getProperty("POSTGRES_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postgresDS;
    }
}
