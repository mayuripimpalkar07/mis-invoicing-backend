package com.codeb.mis_invoicing_system.controller;


import com.codeb.mis_invoicing_system.entity.Group;
import com.codeb.mis_invoicing_system.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @PostMapping
    public Group CreateGroup(@RequestBody Group group){
        return groupRepository.save(group);
    }

@GetMapping
public List <Group> getAllGroup(){
        return groupRepository.findAll();
}
@GetMapping("/{id}")
    public Group getGroupById(@PathVariable Long id ){
        return groupRepository.findById(id).orElse(null);
}
@PutMapping("/{id}")
    public Group updateGroup(@PathVariable Long id ,@RequestBody Group updatedGroup){
        updatedGroup.setId(id);
        return groupRepository.save(updatedGroup);
}
@DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable Long id ){
        groupRepository.deleteById(id);
                return"Group deleted with Id:"+id;
}

}
