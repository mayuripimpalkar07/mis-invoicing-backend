package com.codeb.mis_invoicing_system.controller;

import com.codeb.mis_invoicing_system.entity.Invoice;
import com.codeb.mis_invoicing_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private EstimateRepository estimateRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/summary")
    public Map<String, Object> getDashboardSummary() {
        Map<String, Object> summary = new HashMap<>();

        summary.put("totalClients", clientRepository.count());
        summary.put("totalInvoices", invoiceRepository.count());
        summary.put("totalEstimates", estimateRepository.count());
        summary.put("totalPayments", paymentRepository.count());
        summary.put("totalEmployees", employeeRepository.count());

        List<Invoice> allInvoices = invoiceRepository.findAll();
        long pendingInvoices = allInvoices.stream()
                .filter(invoice -> !"paid".equalsIgnoreCase(invoice.getStatus()))
                .count();
        summary.put("pendingInvoices", pendingInvoices);

        double totalRevenue = allInvoices.stream()
                .filter(invoice -> "paid".equalsIgnoreCase(invoice.getStatus()))
                .mapToDouble(invoice -> invoice.getTotalAmount() != null ? invoice.getTotalAmount() : 0.0)
                .sum();
        summary.put("totalRevenueCollected", totalRevenue);

        return summary;
    }
}