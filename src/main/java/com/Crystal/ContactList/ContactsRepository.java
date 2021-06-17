package com.Crystal.ContactList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactsRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findContactByPhoneNumber(Long phoneNumber);
    Optional<Contact> findContactByEmail(String email);

}
