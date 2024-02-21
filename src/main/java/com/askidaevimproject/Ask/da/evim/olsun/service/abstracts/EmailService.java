package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendEmail(SimpleMailMessage email);
}
