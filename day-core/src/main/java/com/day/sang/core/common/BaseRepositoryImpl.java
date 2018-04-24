package com.day.sang.core.common;

import com.day.sang.core.po.BasePO;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by yaojialu on 2017/1/9.
 *
 * 自定义Repository实现类
 *
 * @author yaojialu
 * @param <T> 领域对象即实体类
 * @param <ID>领域对象的注解
 *
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final JpaEntityInformation<T, ?> entityInformation;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, em);
    }

    private static String currentTimeStamp(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(LocalDateTime.now());
    }

    public <S extends T> S save(S entity, int id) {
        // set current timestamp and user
        if( entity instanceof BasePO){
            if( this.entityInformation.isNew(entity) ){
                ((BasePO) entity).setCreatedId(id);
                ((BasePO) entity).setCreatedAt(currentTimeStamp());
            }
            ((BasePO) entity).setUpdatedId(id);
            ((BasePO) entity).setUpdatedAt(currentTimeStamp());
        }
        if( entity instanceof BasePO){
            if( this.entityInformation.isNew(entity) ){
                ((BasePO) entity).setCreatedId(id);
                ((BasePO) entity).setCreatedAt(currentTimeStamp());
            }
        }
        return save(entity);
    }

}
