package ru.tanya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tanya.dto.ApplicationDto;
import ru.tanya.entities.Application;
import ru.tanya.entities.Contact;
import ru.tanya.exceptions.NoApplicationsForContact;
import ru.tanya.exceptions.NoContactException;
import ru.tanya.repositories.ApplicationRepository;
import ru.tanya.repositories.ContactRepository;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private ContactRepository contactRepository;

    @Transactional
    public ApplicationDto getLastApplicationByContact(Long contactId) {
        Optional<Contact> contactOptional = contactRepository.findById(contactId);
        if(!contactOptional.isPresent()) throw new NoContactException();
        Application lastApp = applicationRepository.findTopByContactOrderByCreatedDesc(contactOptional.get());
        if (Objects.isNull(lastApp)) throw new NoApplicationsForContact();
        return convertToDto(lastApp);
    }

    private ApplicationDto convertToDto(Application application) {
        if (Objects.isNull(application)) return null;
        ApplicationDto dto = new ApplicationDto();
        dto.setProductName(application.getProductName());
        dto.setCreated(application.getCreated());
        dto.setId(application.getId());
        dto.setContactId(application.getContact().getId());
        return dto;
    }


}
