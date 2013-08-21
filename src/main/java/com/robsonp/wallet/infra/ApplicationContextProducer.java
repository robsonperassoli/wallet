package com.robsonp.wallet.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ApplicationScoped
public class ApplicationContextProducer {

    @Produces
    @ApplicationScoped
    public ApplicationContext produceContext() {
        return new AnnotationConfigApplicationContext("com.robsonp.wallet.infra", "com.robsonp.wallet.repository");
    }

}
