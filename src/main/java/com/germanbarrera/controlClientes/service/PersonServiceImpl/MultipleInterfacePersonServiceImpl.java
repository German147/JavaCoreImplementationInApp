package com.germanbarrera.controlClientes.service.PersonServiceImpl;

import com.germanbarrera.controlClientes.entity.Person;
import com.germanbarrera.controlClientes.exceptions.ClienteNotFoundExceptions;
import com.germanbarrera.controlClientes.repository.PersonRepository;
import com.germanbarrera.controlClientes.service.GettersMethodsPersonService;
import com.germanbarrera.controlClientes.service.MultiplePostInheritranceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//Here the implementation of ALL the methods from the interface is a MUST.
//Here is a clear example if multiple INHERITANCE
public class MultipleInterfacePersonServiceImpl implements MultiplePostInheritranceInterface,
        GettersMethodsPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean deleteById(Integer person_id) throws Exception {
        Optional<Person> op = personRepository.findById(person_id);

        if (!op.isPresent()) {
            throw new Exception("ID NO ENCONTRADO" + person_id);
        }
        personRepository.deleteById(person_id);

        return true;
    }

    @Override
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonById(Integer person_id) {
        Optional<Person> person1 = personRepository.findById(person_id);
        return person1.isPresent() ? person1.get() : new Person();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person, Integer person_id) {

        Person person1 = new Person();

        if (person_id != null && person_id > 0) {
            Optional<Person> optionalPerson1 = personRepository.findById(person_id);
            if (optionalPerson1.isPresent()) {
                person.setPerson_id(person_id);
                person1 = personRepository.save(person);
            }
        } else {
            throw new ClienteNotFoundExceptions("The Id number " + person_id + " does not exist");
        }

        return person1;
    }
}
