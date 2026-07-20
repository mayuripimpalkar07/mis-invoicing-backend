package com.codeb.mis_invoicing_system.controller;


import com.codeb.mis_invoicing_system.entity.Invoice;
import com.codeb.mis_invoicing_system.entity.Payment;
import com.codeb.mis_invoicing_system.repository.InvoiceRepository;
import com.codeb.mis_invoicing_system.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository ;

@Autowired
    private InvoiceRepository invoiceRepository ;

@PostMapping

    public Payment createPayment(@RequestBody Payment payment ){
    Payment savedPayment = paymentRepository.save(payment);
Long invoiceId= savedPayment.getInvoice().getId();
Invoice invoice =invoiceRepository.findById(invoiceId).orElse(null);
if(invoice != null){
    invoice.setStatus("paid");
    invoiceRepository.save(invoice);
}


return savedPayment ;
}
@GetMapping
    public List<Payment> getAllPayments(){
    return paymentRepository.findAll();
}
@GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id){
    return paymentRepository.findById(id).orElse(null);
}
@PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id ,@RequestBody Payment updatedPayment) {
    Payment payment = paymentRepository.findById(id).orElse(null);
    if (payment != null) {
        payment.setAmountPaid(updatedPayment.getAmountPaid());
        payment.setPaymentDate(updatedPayment.getPaymentDate());
        payment.setPaymentMethod(updatedPayment.getPaymentMethod());
        payment.setInvoice(updatedPayment.getInvoice());

        return paymentRepository.save(payment);

    }
return null ;

}

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentRepository.deleteById(id);
        return "Payment deleted with id: " + id;
    }

}
