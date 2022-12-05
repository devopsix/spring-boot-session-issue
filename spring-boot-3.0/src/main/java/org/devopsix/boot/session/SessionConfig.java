package org.devopsix.boot.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.PostgreSqlJdbcIndexedSessionRepositoryCustomizer;

@Configuration
public class SessionConfig {

    @Bean
    public PostgreSqlJdbcIndexedSessionRepositoryCustomizer postgreSqlJdbcIndexedSessionRepositoryCustomizer() {
        return new PostgreSqlJdbcIndexedSessionRepositoryCustomizer();
    }
}
