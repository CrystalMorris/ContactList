package com.Crystal.ContactList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ContactsService {

    private final ContactsRepository contactsRepository;

    @Autowired
    public ContactsService(ContactsRepository contactsRepository){
        this.contactsRepository = contactsRepository;
    }

    public List<Contact> getContacts(){
        return contactsRepository.findAll();
    }

    public void addContact(Contact newContact){
//        Optional<Contact> testContact =contactsRepository.findContactByPhoneNumber(newContact.getPhoneNumber());
//        if(testContact.isPresent()){}

        contactsRepository.save(newContact);

        }
    public void deleteContact(Long contactId){
        boolean exists = contactsRepository.existsById(contactId);
        if(!exists){
            throw new IllegalStateException("Contact does not exist");
        }
        contactsRepository.deleteById(contactId);
    }


    @Transactional
    public void updateContact(Long contactId, String firstName, String lastName, Long phoneNumber, String email){
        Contact contactToUpdate= contactsRepository.findById(contactId).orElseThrow(()-> new IllegalStateException(
                "Contact not found"));
        if(firstName != null && !contactToUpdate.getFirstName().equals(firstName)){
            contactToUpdate.setFirstName(firstName);
        }
        if(lastName != null && !contactToUpdate.getLastName().equals(lastName)){
            contactToUpdate.setLastName(lastName);
        }
        if(phoneNumber != null && !contactToUpdate.getPhoneNumber().equals(phoneNumber)){
            contactToUpdate.setPhoneNumber(phoneNumber);
        }
        if(email != null && !contactToUpdate.getEmail().equals(email)){
            contactToUpdate.setEmail(email);
        }

    }




}

