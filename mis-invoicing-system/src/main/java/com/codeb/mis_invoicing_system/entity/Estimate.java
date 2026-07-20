package com.codeb.mis_invoicing_system.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Estimate {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String estimateNumber ;
    private LocalDate estimateDate;
    private Double amount ;
    private String status ;


    @ManyToOne
    @JoinColumn (name = "client_id",nullable=false )
    private Client client;
}
