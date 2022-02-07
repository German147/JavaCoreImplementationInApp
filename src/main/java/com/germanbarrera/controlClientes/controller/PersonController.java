package com.germanbarrera.controlClientes.controller;

import com.germanbarrera.controlClientes.entity.Person;
//import com.germanbarrera.controlClientes.service.PersonService;
import com.germanbarrera.controlClientes.service.PersonServiceImpl.MultipleInterfacePersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/person")
@Slf4j
public class PersonController {

//    @Autowired
//    private PersonService personService;

    @Autowired
    private MultipleInterfacePersonServiceImpl personService;

    @GetMapping("/menu")
    public String showMenu(){
        return "menu";
    }


    @GetMapping(value = "/show_list")
    public String showingClients(Model model) {
        log.info("SEARCH FOR ALL PERSONS");
        model.addAttribute("person", personService.findAllPersons());
        return "list_person";
    }

    //when we hit the /add in a @GetMapping we call the form ( it is still not saved here).
    @GetMapping("/add")
    public String addPerson(Model model) {
        log.info("INVOKING THE ADDING FORM");
        model.addAttribute("person", new Person());
        return "add_persons";
    }

    //when we hit the /add in a @PostMapping we save the object and redirect to the list.
    @PostMapping(value = "/add")
    public String save(@ModelAttribute Person person,
                             RedirectAttributes redirectAttrs) {
        log.info("ADDING A NEW CLIENT");
        personService.save(person);
        redirectAttrs
                .addFlashAttribute("mensaje", "Person added succesfully")
                .addFlashAttribute("clase", "success");
        return "redirect:/person/show_list";
    }

//    @PostMapping
//    public @ResponseBody
//    Person save(@RequestBody Person person) {
//        return personService.save(person);
//    }

    @PostMapping(value = "/delete/{person_id}")
    public String deletePerson(@ModelAttribute Person person, Integer person_id, RedirectAttributes redirectAttrs) throws Exception {
        log.info("DELETING A CLIENT");
        redirectAttrs
                .addFlashAttribute("mensaje", "Client Deleted Succesfully!")
                .addFlashAttribute("clase", "warning");
        personService.deleteById(person.getPerson_id());
        return "redirect:/person/show_list";
    }

    @GetMapping(value = "/edit/{person_id}")
    public String editingClientFrom(@PathVariable Integer person_id, Model model) {
        log.info("INVOKING THE EDITING FORM");
        model.addAttribute("person", personService.findPersonById(person_id));
        return "edit_client";
    }

    // Se colocó el parámetro ID para eso de los errores, ya sé el id se puede recuperar
    // a través del modelo, pero lo que yo quiero es que se vea la misma URL para regresar la vista con
    // los errores en lugar de hacer un redirect, ya que si hago un redirect, no se muestran los errores del formulario
    // y por eso regreso mejor la vista ;)
    @PostMapping(value = "/edit/{id}")
    public String updatingClientById(@ModelAttribute @Valid Person person, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        log.info("EDITING A CLIENT");
        if (bindingResult.hasErrors()) {
            if (person.getPerson_id() != null) {
                return "edit_client";
            }
            return "redirect:/clientes/mostrar";
        }
        Person posiblePersonExist = personService.findPersonById(person.getPerson_id());

        if (posiblePersonExist != null && !posiblePersonExist.getPerson_id().equals(person.getPerson_id())) {
            redirectAttrs
                    .addFlashAttribute("mensaje", "A Client with that ID already exists")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/person/add";
        }
       personService.save(person);
        redirectAttrs
                .addFlashAttribute("mensaje", "Client Edited Succesfully!")
                .addFlashAttribute("clase", "success");
        return "redirect:/person/show_list";
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) throws Exception {
//        personService.deleteById(id);
//        return new ResponseEntity<Object>(HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public @ResponseBody
//    Person findPersonById(@PathVariable("id") Integer id) {
//        return personService.findPersonById(id);
//    }


}
