package com.example.service.base;

import com.example.entity.base.BaseEntity;
import com.example.repository.base.BaseRepository;
import com.example.util.Common;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SCC on 2017/1/17.
 */
@Transactional
public abstract class BaseService<T, Long extends Serializable> {
    private BaseRepository<T, Long> baseRepository;

    public void setBaseRepository(BaseRepository<T, Long> baseRepository) {
        this.baseRepository = baseRepository;
    }


    public void save(T entity) {
        BaseEntity baseEntity = (BaseEntity)entity;
        entity = (T)Common.setUpdated(baseEntity);
        baseRepository.save(entity);
    }


    public void save(List<T> list) {
        for (T entity:list) {
            BaseEntity baseEntity = (BaseEntity)entity;
            entity = (T)Common.setUpdated(baseEntity);
        }

        baseRepository.save(list);
    }


    public void delete(Long id) {
        baseRepository.delete(id);
    }


    public T findOne(Long id) {
        return baseRepository.findOne(id);
    }


    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public List<T> findAll(Specification specification) {
        return baseRepository.findAll(specification);
    }

    public List<T> findAll(Sort sort) {
        return baseRepository.findAll(sort);
    }

    public Page<T> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    public List<T> findAll(Specification specification, Sort sort) {

        return baseRepository.findAll(specification, sort);
    }

    public Page<T> findAll(Specification specification, Pageable pageable) {
        return baseRepository.findAll(specification, pageable);

    }
}
