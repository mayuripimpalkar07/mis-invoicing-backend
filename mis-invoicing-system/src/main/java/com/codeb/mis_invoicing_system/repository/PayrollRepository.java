package com.codeb.mis_invoicing_system.repository;

import com.codeb.mis_invoicing_system.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}