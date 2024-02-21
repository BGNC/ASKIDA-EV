package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplyForHomeResponseEntity {

    private String message;
    private HttpStatus status;

}
