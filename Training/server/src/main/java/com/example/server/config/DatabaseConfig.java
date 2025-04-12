package com.example.server.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.sql.DataSource;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.postgresql.ds.PGSimpleDataSource;

@ApplicationScoped
public class DatabaseConfig {

    @ConfigProperty(name = "db.url")
    String dbUrl;

    @ConfigProperty(name = "db.user")
    String dbUser;

    @ConfigProperty(name = "db.password")
    String dbPassword;

    @Produces
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUser(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }
}