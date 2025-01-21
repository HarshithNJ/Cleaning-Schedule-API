package org.cleaning.cleaning.service;

import org.cleaning.cleaning.repository.cleaningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cleaningService {
    
    @Autowired
    cleaningRepository repository;
}
