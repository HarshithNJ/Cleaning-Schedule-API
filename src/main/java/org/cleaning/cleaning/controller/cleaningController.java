package org.cleaning.cleaning.controller;

import org.cleaning.cleaning.dto.cleaningTask;
import org.cleaning.cleaning.service.cleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class cleaningController {
    
    @Autowired
    cleaningService service;

    /* To Add a new cleaning task */
    @PostMapping("/tasks")
    public ResponseEntity<Object> addTask(@RequestBody cleaningTask task) {
        return service.addTask(task);
    }


    /* To get the cleaning tasks */
    @GetMapping("/tasks")
    public ResponseEntity<Object> getTasks(){
        return service.getTasks();
    }

    @GetMapping("/tasks/{assignedTo}")
    public ResponseEntity<Object> getTasksByAssignedTo(@PathVariable String assignedTo){
        return service.getTasksByAssignedTo(assignedTo);
    }
    
}
