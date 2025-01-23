package org.cleaning.cleaning.controller;

import org.cleaning.cleaning.dto.cleaningTask;
import org.cleaning.cleaning.service.cleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@Tag(name = "Cleaning Tasks", description = "Cleaning Tasks API")
public class cleaningController {
    
    @Autowired
    cleaningService service;

    /* To Add a new cleaning task */
    @Operation(summary = "Add a new cleaning task", description = "Add a new cleaning task")
    @ApiResponse(responseCode = "201", description = "Cleaning task created")
    @ApiResponse(responseCode = "406", description = "Cleaning task already exists")
    @PostMapping("/tasks")
    public ResponseEntity<Object> addTask(@RequestBody cleaningTask task) {
        return service.addTask(task);
    }






    /* To get the cleaning tasks */
    @Operation(summary = "Get all cleaning tasks", description = "Get all cleaning tasks")
    @ApiResponse(responseCode = "302", description = "Cleaning tasks retrieved")
    @ApiResponse(responseCode = "404", description = "No cleaning tasks found")
    @GetMapping("/tasks")
    public ResponseEntity<Object> getTasks(){
        return service.getTasks();
    }

    @Operation(summary = "Get cleaning tasks by assigned to", description = "Get All the Cleaning Tasks by assigned to")
    @ApiResponse(responseCode = "302", description = "Cleaning tasks retrieved")
    @ApiResponse(responseCode = "404", description = "No cleaning tasks found by the assigned to")
    @GetMapping("/tasks/{assignedTo}")
    public ResponseEntity<Object> getTasksByAssignedTo(@PathVariable String assignedTo){
        return service.getTasksByAssignedTo(assignedTo);
    }

    @Operation(summary = "Get cleaning tasks by task", description = "Get All the Cleaning Tasks by task")
    @ApiResponse(responseCode = "302", description = "Cleaning tasks retrieved")
    @ApiResponse(responseCode = "404", description = "No cleaning tasks found for task")
    @GetMapping("/tasks/task/{task}")
    public ResponseEntity<Object> getTasksByTask(@PathVariable String task){
        return service.getTasksByTask(task);
    }




    /* To delete a cleaning task */
    @Operation(summary = "Delete a cleaning task", description = "Delete a cleaning task")
    @ApiResponse(responseCode = "200", description = "Cleaning task deleted")
    @ApiResponse(responseCode = "400", description = "Cleaning task not found")
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable int id){
        return service.deleteTask(id);
    }






    /* To update a cleaning task */
    @Operation(summary = "Update a cleaning task", description = "Update a cleaning task By the Patch Method")
    @ApiResponse(responseCode = "200", description = "Cleaning task updated")
    @ApiResponse(responseCode = "400", description = "Cleaning task not found")
    @PatchMapping("/tasks/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable int id, @RequestBody cleaningTask task){
        return service.updateTask(id, task);
    }
    
}
