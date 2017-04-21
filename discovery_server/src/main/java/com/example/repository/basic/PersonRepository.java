package com.example.repository.basic;

import com.example.entity.basic.Person;
import com.example.repository.base.BaseRepository;

/**
 * Created by SCC on 2017/1/9.
 */
public interface PersonRepository extends BaseRepository<Person, Long> {

    Person findByName(String name);

}
