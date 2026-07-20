package com.codeb.mis_invoicing_system.controller;


import com.codeb.mis_invoicing_system.entity.Brand;
import com.codeb.mis_invoicing_system.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/brands")

public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

@PostMapping
    public Brand createBrand(@RequestBody Brand brand){
    return brandRepository.save(brand);
}

@GetMapping
    public List<Brand> getAllBrands(){
    return brandRepository.findAll();

}

@GetMapping("/{id}")
    public Brand getbrandById(@PathVariable Long id ){
    return brandRepository.findById(id).orElse(null);
}

@PutMapping("/{id}")
    public Brand updateBrand(@PathVariable Long id ,@RequestBody Brand updatedBrand){
    updatedBrand.setId(id);
    return brandRepository.save(updatedBrand);
}
@DeleteMapping("/{id}")
    public String deleteBrand(@PathVariable Long id){
brandRepository.deleteById(id);
return "Brand delete with id "+ id ;
    }


}
