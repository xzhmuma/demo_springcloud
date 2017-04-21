package com.example.service.basic;

import com.example.entity.basic.Department;
import com.example.repository.basic.DepartmentRepository;
import com.example.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SCC on 2017/1/12.
 */
@Service
public class DepartmentService extends BaseService<Department, Long> {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    public void setBaseRepository() {
        super.setBaseRepository(departmentRepository);

    }
}
