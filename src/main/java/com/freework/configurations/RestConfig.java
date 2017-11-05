package com.freework.configurations;

import com.freework.entities.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(User.class);
        config.exposeIdsFor(Company.class);
        config.exposeIdsFor(Contest.class);
        config.exposeIdsFor(Entry.class);
        config.exposeIdsFor(Job.class);
        config.exposeIdsFor(Freelancer.class);
    }
}
