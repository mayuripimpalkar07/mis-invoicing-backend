package com.codeb.mis_invoicing_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    @ManyToOne
    @JoinColumn(name = "chain_id")
    private Chain chain;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;


    @ManyToOne
    @JoinColumn (name="subzone_id")
    private Subzone subzone ;

    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;


}
