package com.codeb.mis_invoicing_system.controller;

import com.codeb.mis_invoicing_system.entity.Chain;
import com.codeb.mis_invoicing_system.repository.ChainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RestController
@RequestMapping("/api/chains")
public class ChainController {

    @Autowired
    private ChainRepository chainRepository ;

    @PostMapping
    public Chain createChain(@RequestBody Chain chain){
        return chainRepository.save(chain);

    }

    @GetMapping
    public List<Chain>GetAllChains(){
        return chainRepository.findAll();
    }

    @GetMapping("/{id}")
    public Chain getChainById(@PathVariable Long id ){
        return chainRepository.findById(id).orElse(null);

    }
    @PutMapping("/{id}")
    public Chain UpdateChain(@PathVariable long id,@RequestBody Chain updatedChain) {
        updatedChain.setId(id);
    return chainRepository.save(updatedChain);
    }

    @DeleteMapping("/{id}")
    public String deleteChain(@PathVariable Long id){
         chainRepository.deleteById(id);
     return "Chain Deleted With Id : " + id;
    }



}
