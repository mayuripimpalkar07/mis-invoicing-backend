package com.codeb.mis_invoicing_system.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="client_groups")
@Data
public class Group {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    private String name;



}
