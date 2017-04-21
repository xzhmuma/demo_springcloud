package com.example.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SCC on 2017/2/7.
 */
@NoRepositoryBean
@Transactional(readOnly=true)
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    List<Object[]> listBySQL(String sql);

    @Transactional
    public void updateBySql(String sql, Object... args);
    @Transactional
    public void updateByHql(String hql, Object... args);
}
