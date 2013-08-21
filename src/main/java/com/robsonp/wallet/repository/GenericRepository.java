package com.robsonp.wallet.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.inject.Inject;
import org.springframework.data.mongodb.core.MongoOperations;

public class GenericRepository<BeanType, KeyType> {
    
    @Inject
    private MongoOperations mongoOperations;
    
    public void save(BeanType bean){
        mongoOperations.save(bean);
    }
    
    public BeanType findById(KeyType id){
        return (BeanType) mongoOperations.findById(id, getKeyClass());
    }
    
    public List<BeanType> findAll(){
        return mongoOperations.findAll(getBeanClass());
    }
    
    public void deleteById(KeyType id){
        BeanType bean = findById(id);
        mongoOperations.remove(bean);
    }
    
    public void deleteByObj(BeanType bean){
        mongoOperations.remove(bean);
    }
    
    public Class<KeyType> getKeyClass(){
        final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();  
        return (Class<KeyType>) type.getActualTypeArguments()[1];
    }
    
    public Class<BeanType> getBeanClass(){
        final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();  
        return (Class<BeanType>) type.getActualTypeArguments()[0];
    }

    public MongoOperations getMongoOperations() {
        return mongoOperations;
    }
    
}
