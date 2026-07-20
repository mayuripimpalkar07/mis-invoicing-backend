package com.codeb.mis_invoicing_system.controller;


import com.codeb.mis_invoicing_system.entity.Subzone;
import com.codeb.mis_invoicing_system.repository.SubzoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/subzones")
public class SubzoneController {

@Autowired
    private SubzoneRepository subzoneRepository;

@PostMapping
public Subzone createSubzone(@RequestBody Subzone subzone){
    return subzoneRepository.save(subzone);

}
@GetMapping
    public List<Subzone> getAllSubzone(){
    return subzoneRepository.findAll();
}

@GetMapping("/{id}")
    public Subzone getSubzoneById(@PathVariable Long id ){
    return subzoneRepository.findById(id).orElse(null);
}
@PutMapping ("/{id}")
    public Subzone UpdateSubzone(@PathVariable Long id ,@RequestBody Subzone updatedSubzone ){
    updatedSubzone.setId(id);
    return subzoneRepository.save(updatedSubzone);
}
@DeleteMapping("/{id}")
    public String deleteSubzone(@PathVariable Long id ){
    subzoneRepository.deleteById(id);
    return"Subzone deleted With  Id : " + id ;
}






}
