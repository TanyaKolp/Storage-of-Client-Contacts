package ru.tanya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tanya.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}