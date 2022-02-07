package com.germanbarrera.controlClientes.service;

import com.germanbarrera.controlClientes.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAllPersons();

    Person  save(Person persona);

    boolean deleteById(Integer person_id) throws Exception;

    Person findPersonById(Integer person_id);

    Person update(Person person,Integer person_id);
}
