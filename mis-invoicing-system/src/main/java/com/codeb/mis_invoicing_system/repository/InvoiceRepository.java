package com.codeb.mis_invoicing_system.repository;

import com.codeb.mis_invoicing_system.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {


}
