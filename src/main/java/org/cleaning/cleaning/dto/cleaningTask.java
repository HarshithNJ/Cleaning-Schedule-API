package org.cleaning.cleaning.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class cleaningTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String task;
    private String frequency;
    private boolean completed;
    private String assignedTo;
    
}
