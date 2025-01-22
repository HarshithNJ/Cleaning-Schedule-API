package org.cleaning.cleaning.repository;

import org.cleaning.cleaning.dto.cleaningTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cleaningRepository extends JpaRepository<cleaningTask, Integer>{

    boolean existsByTask(String task);

}