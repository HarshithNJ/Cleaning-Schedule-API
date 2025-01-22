package org.cleaning.cleaning.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
