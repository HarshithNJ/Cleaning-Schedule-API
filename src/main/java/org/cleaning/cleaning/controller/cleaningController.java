package org.cleaning.cleaning.controller;

import org.cleaning.cleaning.service.cleaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cleaningController {
    
    @Autowired
    cleaningService service;
}
