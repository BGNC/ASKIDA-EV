package com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdProblemDetails extends NoSuchElementException {
    private String message;
}
