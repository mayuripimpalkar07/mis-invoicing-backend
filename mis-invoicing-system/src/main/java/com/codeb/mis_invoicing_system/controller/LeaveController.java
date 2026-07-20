package com.codeb.mis_invoicing_system.controller;

import com.codeb.mis_invoicing_system.entity.Leave;
import com.codeb.mis_invoicing_system.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveRepository leaveRepository;

    @PostMapping
    public Leave createLeave(@RequestBody Leave leave) {
        return leaveRepository.save(leave);
    }

    @GetMapping
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @GetMapping("/{id}")
    public Leave getLeaveById(@PathVariable Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable Long id, @RequestBody Leave updatedLeave) {
        updatedLeave.setId(id);
        return leaveRepository.save(updatedLeave);
    }

    @DeleteMapping("/{id}")
    public String deleteLeave(@PathVariable Long id) {
        leaveRepository.deleteById(id);
        return "Leave deleted with id: " + id;
    }
}