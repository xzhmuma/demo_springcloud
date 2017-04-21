package com.example.entity.base;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by SCC on 2017/1/3.
 */
@MappedSuperclass
public abstract class IdEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Long id;

    public IdEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
