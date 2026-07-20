package com.codeb.mis_invoicing_system.controller;

import com.codeb.mis_invoicing_system.entity.Invoice;

import com.codeb.mis_invoicing_system.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/api/invoices")

public class InvoiceController {
@Autowired
    private InvoiceRepository invoiceRepository;

// Add new Invoice
    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice ) {
        Double gstAmount = invoice.getSubTotal()*(invoice.getGstPercentage()/100);
        Double totalAmount= invoice.getSubTotal() + gstAmount;

        invoice.setGstAmount(gstAmount);
        invoice.setTotalAmount(totalAmount);
        return invoiceRepository.save(invoice);


    }
//2.See all invoices
    @GetMapping
    public List<Invoice>getAllInvoice() {
        return invoiceRepository.findAll();
    }
        //see Specific invoice by id
        @GetMapping("/{id}")
                public Invoice getInvoiceById(@PathVariable Long id){
               return invoiceRepository.findById(id).orElse(null);
        }
        //4.update invoice
    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id ,@RequestBody Invoice updatedInvoice){
             updatedInvoice.setId(id);
             return invoiceRepository.save(updatedInvoice);
    }
    //5 Delete Invoice
    @DeleteMapping ("/{id}")
    public String deleteInvoice (@PathVariable Long id ){
        invoiceRepository.deleteById(id);
        return "Invoice Deleted With Id : " + id ;
    }
}
