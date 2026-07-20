package com.codeb.mis_invoicing_system.entity;


import jakarta.persistence.* ;

import java.time.LocalDate ;



@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;
    private String invoiceNumber; // INV-2026-001
    private LocalDate invoiceDate ;
     private LocalDate dueDate ;
     private Double subTotal;
     private Double gstPercentage;
     private Double gstAmount ;
     private Double totalAmount ;
     private String status ; // paid,inpaid,draft

    //many Invoice  can belong to one client
    @ManyToOne

    @JoinColumn (name="client_id",nullable=false)
    private Client client;

    //---Getters and setter method --//

    public Long getId (){
        return id;
    }
public void setId(Long id){
        this.id = id ;
}

public String getInvoiceNumber(){
        return invoiceNumber;
}

public void setInvoiceNumber (String invoiceNumber){
        this.invoiceNumber= invoiceNumber;
}
 public LocalDate getInvoiceDate () {
        return invoiceDate ;
 }
 public void setInvoiceDate(LocalDate invoiceDate){
        this.invoiceDate = invoiceDate ;
 }
 public LocalDate getDueDate (){
        return dueDate ;
    }

 public void setDueDate(LocalDate dueDate ){
        this.dueDate = dueDate ;
 }

 public Double getSubTotal(){
        return subTotal;

 }
 public void setSubTotal(Double subTotal){
        this.subTotal=subTotal;
 }
public Double getGstPercentage(){
        return gstPercentage;
}
public void setGstPercentage( Double gstPercentage){
        this.gstPercentage= gstPercentage;
}

public  Double getGstAmount(){
        return gstAmount ;
}
public void setGstAmount (Double gstAmount ){
        this.gstAmount=gstAmount ;
}



public Double  getTotalAmount (){
        return totalAmount ;
}
public void setTotalAmount (Double totalAmount){
        this.totalAmount = totalAmount ;
}
public String getStatus(){
        return status ;
}

public void setStatus(String status){
        this.status =status;
}

public Client getClient (){
        return client ;
}
public void  setClient(Client client){
        this.client=client ;
}
}
