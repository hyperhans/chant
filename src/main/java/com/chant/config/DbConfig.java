package com.chant.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DbConfig {

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        URI dbUri;
        try {
            String username="";
            String password="";
            String url = "";
            String dbProperty = System.getProperty("database.url");
            if(dbProperty != null) {
                dbUri = new URI(dbProperty);

                username = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
            }
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (URISyntaxException e) {
            throw e;
        }
    }
}
