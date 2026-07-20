package com.codeb.mis_invoicing_system.controller;



import com.codeb.mis_invoicing_system.entity.Estimate;
import com.codeb.mis_invoicing_system.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estimates")
public class EstimateController {

@Autowired
    private EstimateRepository estimateRepository ;

@PostMapping
    public Estimate createEstimate(@RequestBody Estimate estimate ){
    return estimateRepository.save(estimate);
}
@GetMapping
    public List<Estimate> getAllEstimate(){
    return estimateRepository.findAll();
}
@GetMapping("/{id}")
    public Estimate getEstimateById(@PathVariable Long id ){
    return estimateRepository.findById(id).orElse(null);
}
@PutMapping("/{id}")
    public Estimate updateEstimate(@PathVariable Long id , @RequestBody Estimate updatedEstimate){
    updatedEstimate.setId(id);
    return estimateRepository.save(updatedEstimate);
}
@DeleteMapping("/{id}")
    public String deleteEstimate(@PathVariable Long id ){
    estimateRepository.deleteById(id);
    return "Estimate Deleted with Id : " + id ;
}


}
