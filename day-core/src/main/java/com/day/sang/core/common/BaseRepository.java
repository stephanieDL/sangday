package com.day.sang.core.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by yaojialu on 2017/1/9.
 *
 * 自定义repository接口
 * @author yaojialu
 * @param <T> 领域对象即实体类
 * @param <ID>领域对象的注解
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    <S extends T> S save(S entity, int id);

}
