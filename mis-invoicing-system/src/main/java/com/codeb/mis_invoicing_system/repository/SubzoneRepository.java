package com.codeb.mis_invoicing_system.repository;


import com.codeb.mis_invoicing_system.entity.Subzone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubzoneRepository extends JpaRepository<Subzone,Long > {

}
