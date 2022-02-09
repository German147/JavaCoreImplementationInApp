package com.germanbarrera.controlClientes.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persona")
public class Person extends People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer person_id;

    private String name;
    private String surname;
    private String email;
    private String phone;





}
