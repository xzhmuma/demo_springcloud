package com.example.service.basic;

import com.example.entity.basic.Person;
import com.example.repository.basic.PersonRepository;
import com.example.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SCC on 2017/1/12.
 */
@Service
public class PersonService extends BaseService<Person, Long> {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    public void setBaseRepository() {
        super.setBaseRepository(personRepository);
    }
    public Person findByName(String name){
        return personRepository.findByName(name);
    }

}
