package com.robsonp.wallet.infra;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

    @Bean
    public MongoOperations mongoTemplate(Mongo mongo) {
        String dbName = System.getenv("OPENSHIFT_APP_NAME");
        if(dbName == null)
            dbName = "wallet";
        
        String user = System.getenv("OPENSHIFT_MONGODB_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MONGODB_DB_PASSWORD");
        
        MongoTemplate mongoTemplate;
        if(user == null) {
             mongoTemplate = new MongoTemplate(mongo, dbName);
        } else {
            mongoTemplate = new MongoTemplate(mongo, dbName, new UserCredentials(user, password));
        }
        return mongoTemplate;
    }

    @Bean
    public MongoFactoryBean mongo() {
        String sPort = System.getenv("OPENSHIFT_MONGODB_DB_PORT");
        String host = System.getenv("OPENSHIFT_MONGODB_DB_HOST");
        
        int port = 27017;
        if(sPort != null)
            port = Integer.parseInt(sPort);
        
        if(host == null)
            host = "localhost";
        
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost(host);
        mongo.setPort(port);
        return mongo;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
