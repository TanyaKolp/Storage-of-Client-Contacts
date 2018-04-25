package ru.tanya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tanya.dto.ApplicationDto;
import ru.tanya.entities.Application;
import ru.tanya.exceptions.NoContactException;
import ru.tanya.repositories.ApplicationRepository;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Transactional
    public ApplicationDto getLastApplicationByContact(Long contactId) {
        Application lastApp = applicationRepository.findTopByContactIdOrderByCreatedDesc(contactId);
        if (Objects.isNull(lastApp)) {
            throw new NoContactException();
        }
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
