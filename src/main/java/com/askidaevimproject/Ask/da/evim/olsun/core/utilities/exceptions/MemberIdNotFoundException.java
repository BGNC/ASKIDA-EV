package com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class MemberIdNotFoundException extends IdProblemDetails {


    Map<String,String> errors;
    public MemberIdNotFoundException(String message) {
        super(message);
    }
}
