package dev.naimsulejmani.bankav2backend.configs.migration;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayMigration {

    @Bean
    public FlywayMigrationStrategy runMigration(){
        return flyway -> {
            flyway.migrate();
            flyway.repair();
        };
    }
}
