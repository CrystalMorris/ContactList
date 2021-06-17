package com.Crystal.ContactList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HtmlController {

    @Autowired
    private ContactsService contactsService;

    @RequestMapping("/index")
    public String contacts(Model model){
        List<Contact> contacts = contactsService.getContacts();
        model.addAttribute("contacts", contacts);
        return "index";
    }
//    @RequestMapping("/contacts")
//    public String contacts(Model model){
//        List<Contact> contacts = contactsService.getContacts();
//        model.addAttribute("contacts", contacts);
//        return "ContactList";
//    }

    @GetMapping("/addContact")
    public String addContactForm(Model model){
        model.addAttribute("addContact",new Contact());

        return "addContact";
    }
    @PostMapping("/addContact")
    public String addContact(@RequestParam String firstName, @RequestParam String lastName,
                             @RequestParam Long phoneNumber, @RequestParam String email){
        Contact newContact = new Contact();
        newContact.setFirstName(firstName);
        newContact.setLastName(lastName);
        newContact.setPhoneNumber(phoneNumber);
        newContact.setEmail(email);
        contactsService.addContact(newContact);
        return "addContact";
    }





}
