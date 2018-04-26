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


    /**
     *в @RequestMapping параметр produces отвечает за Заголовок Accept
     * (Список допустимых форматов ресурса) в запросе,
     * consumer - за Заголовок Content-Type	(Формат и способ представления сущности.) в запросе
     * */
    @GetMapping(value = "/last_application/{contactId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ApplicationDto> getJsonLastApplication(@PathVariable Long contactId) {
        ApplicationDto lastApp = service.getLastApplicationByContact(contactId);
        return new ResponseEntity<>(lastApp, HttpStatus.OK);
    }
}
