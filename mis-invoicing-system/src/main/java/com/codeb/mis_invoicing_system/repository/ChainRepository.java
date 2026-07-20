package com.codeb.mis_invoicing_system.repository;

import com.codeb.mis_invoicing_system.entity.Chain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainRepository extends JpaRepository<Chain,Long > {
}
