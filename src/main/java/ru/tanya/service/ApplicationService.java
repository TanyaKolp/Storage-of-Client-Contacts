package ru.tanya.service;

import ru.tanya.dto.ApplicationDto;

public interface ApplicationService {
    ApplicationDto getLastApplicationByContact(Long contactId);
}
