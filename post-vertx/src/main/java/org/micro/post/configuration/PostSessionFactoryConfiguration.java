package org.micro.post.configuration;

import org.hibernate.reactive.mutiny.Mutiny;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Persistence;

@Configuration
public class PostSessionFactoryConfiguration {

    private static final String POST_PERSISTENCE_UNIT = "PostPU";

    @Bean
    public Mutiny.SessionFactory sessionFactory() {
        return Persistence.createEntityManagerFactory(POST_PERSISTENCE_UNIT)
                .unwrap(Mutiny.SessionFactory.class);
    }
}