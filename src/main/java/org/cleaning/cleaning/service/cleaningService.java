package org.cleaning.cleaning.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.cleaning.cleaning.dto.cleaningTask;
import org.cleaning.cleaning.repository.cleaningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class cleaningService {
    
    @Autowired
    cleaningRepository repository;

    public ResponseEntity<Object> addTask(cleaningTask task) {
        if(repository.existsByTask(task.getTask())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Task already exists");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }else{
            repository.save(task);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Task created successfully");
            map.put("Cleaning Task", task);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> getTasks() {
        List<cleaningTask> tasks = repository.findAll();

        if(tasks.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No tasks found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Tasks found");
            map.put("Cleaning Tasks", tasks);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getTasksByAssignedTo(String assignedTo) {
        List<cleaningTask> tasks = repository.findByAssignedTo(assignedTo);

        if(tasks.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No tasks found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Tasks found");
            map.put("Cleaning Tasks", tasks);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> getTasksByTask(String task) {
        List<cleaningTask> li = repository.findByTask(task);

        if(li.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No tasks found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Tasks found");
            map.put("Cleaning Tasks", li);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> deleteTask(int id) {
        Optional<cleaningTask> op = repository.findById(id);

        if(op.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Task deleted successfully");
            map.put("Cleaning Task", op.get());

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Task not found with the id : "+id);

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> updateTask(int id, cleaningTask task) {
        if(repository.findById(id).isPresent()){
            cleaningTask ctask = repository.findById(id).get();

            if(task.getTask() != null)
                ctask.setTask(task.getTask());

            if(task.getFrequency() != null)
                ctask.setFrequency(task.getFrequency());

            if(task.isCompleted() != false)
                ctask.setCompleted(task.isCompleted());

            if(task.getAssignedTo() != null)
                ctask.setAssignedTo(task.getAssignedTo());

            repository.save(ctask);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Task updated successfully");
            map.put("Cleaning Task", ctask);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Task not found with the id : "+id);

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }
    }
}
