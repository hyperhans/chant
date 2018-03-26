package com.chant.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DbConfig {

    @Bean
    public BasicDataSource bigDataSource() throws URISyntaxException {
        URI dbUri;
        try {
            String username = "username";
            String password = "password";
            String url = "jdbc:postgresql://localhost/dbname";
            String dbProperty = System.getProperty("database.url");
            if(dbProperty != null) {
                dbUri = new URI(dbProperty);

                username = dbUri.getUserInfo().split(":")[0];
                password = dbUri.getUserInfo().split(":")[1];
                url = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
            }

            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(url);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);
            return basicDataSource;

        } catch (URISyntaxException e) {
            //Deal with errors here.
            throw e;
        }
    }
}
