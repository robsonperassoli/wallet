package com.robsonp.wallet.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

@ApplicationScoped
public class MongoOperationsProducer {
    
    @Inject
    private ApplicationContext appContext;
    
    @Produces
    @ApplicationScoped
    public MongoOperations produce(){
        return appContext.getBean(MongoOperations.class);
    }
}
