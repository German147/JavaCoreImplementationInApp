package com.germanbarrera.controlClientes.service;

import com.germanbarrera.controlClientes.entity.Person;

public interface UpdatePersonById {
    Person update(Person person, Integer person_id);
}
