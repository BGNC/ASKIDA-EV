package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UserAuthenticationRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.UserAuthenticationResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<UserAuthenticationResponse> authenticateUser(UserAuthenticationRequest userAuthenticationRequest);
}
