package dev.naimsulejmani.bankav2backend.configs.flyway;


import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlyWayMigration {
    @Bean
    public FlywayMigrationStrategy runMigration() {
        return flyway -> {
            flyway.migrate();
            flyway.repair();
        };
    }
}
