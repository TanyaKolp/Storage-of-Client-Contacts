package ru.tanya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tanya.dto.ApplicationDto;
import ru.tanya.service.ApplicationService;

@RestController
@RequestMapping("/")
public class ApplicationController {
    @Autowired
    private ApplicationService service;

    @GetMapping(value = "/last_application/{contactId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicationDto> getJsonLastApplication(@PathVariable Long contactId) {
        ApplicationDto lastApp = service.getLastApplicationByContact(contactId);
        return new ResponseEntity<>(lastApp, HttpStatus.OK);
    }

    @GetMapping(value = "/last_application/{contactId}",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ApplicationDto> getXmlLastApplication(@PathVariable Long contactId) {
        ApplicationDto lastApp = service.getLastApplicationByContact(contactId);
        return new ResponseEntity<>(lastApp, HttpStatus.OK);
    }

}
