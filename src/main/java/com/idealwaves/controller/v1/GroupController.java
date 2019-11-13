package com.idealwaves.controller.v1;

import com.idealwaves.domain.Group;
import com.idealwaves.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * create by mohannad on 11/12/2019
 */
@RestController
@RequestMapping(GroupController.BASE_URL)
public class GroupController  {
    public static final String BASE_URL = "/api/v1/groups";
    
    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<Group> addGroup(@RequestBody Group group){
        return new ResponseEntity(groupService.save(group) , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable long id){
        Group Group = groupService.findById(id).
                orElseThrow(()-> new EntityNotFoundException("cant find Group with id: " + id));
        return new ResponseEntity(Group , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGroup(@PathVariable long id){
        groupService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups(){
        return new ResponseEntity(groupService.findAll() , HttpStatus.OK);
    }
}
