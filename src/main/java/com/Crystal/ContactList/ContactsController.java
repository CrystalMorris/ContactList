package com.Crystal.ContactList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path="api/contacts")
public class ContactsController {

    private final ContactsService contactsService;

    @Autowired
    public ContactsController(ContactsService contactsService){
        this.contactsService = contactsService;
    }
    @GetMapping
    public List<Contact> getAllContacts(){
       return contactsService.getContacts();
    }
    @PostMapping
    public void addContact(@RequestBody Contact newContact){
        contactsService.addContact(newContact);
    }

    @DeleteMapping(path ="{contactId}")
    public void deleteContact(@PathVariable("contactId") Long contactId){
        contactsService.deleteContact(contactId);
    }
    @PutMapping(path="{contactId}")
    public void updateContact(@PathVariable("contactId") Long contactId,@RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName, @RequestParam(required = false) Long phoneNumber,
    @RequestParam(required = false) String email){
    contactsService.updateContact(contactId, firstName, lastName, phoneNumber, email);
    }
}
