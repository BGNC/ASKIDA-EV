package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Contact;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.ContactRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.ContactService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateContactRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllContactResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllContactResponse> getAllContact() {
        List<Contact> contactList = this.contactRepository.findAll();

        return contactList.stream().
                map(contact ->
                        this.modelMapperService.forResponse().
                                map(contact,GetAllContactResponse.class)).toList();
    }

    @Override
    public void addContact(@NotNull  CreateContactRequest createContactRequest) {

        Contact contact = this.modelMapperService.forRequest().map(createContactRequest,Contact.class);
        this.contactRepository.save(contact);
    }





}
