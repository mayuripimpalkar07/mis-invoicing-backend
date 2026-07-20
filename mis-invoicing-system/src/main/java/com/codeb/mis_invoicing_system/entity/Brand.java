package com.codeb.mis_invoicing_system.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data

public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
}
