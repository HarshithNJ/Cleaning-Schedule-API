package org.cleaning.cleaning.controller;

import org.cleaning.cleaning.dto.cleaningTask;
import org.cleaning.cleaning.service.cleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
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
    
}
