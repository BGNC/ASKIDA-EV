package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateContactRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllContactResponse;

import java.util.List;

public interface ContactService {
    List<GetAllContactResponse> getAllContact();

    void addContact(CreateContactRequest createContactRequest);
}
