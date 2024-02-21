package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;


import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.AuthService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UserAuthenticationRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.UserAuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("https://askidaev-57ca6b6ed886.herokuapp.com")
//@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
public class AuthController {


    private AuthService authService;
    @PostMapping("/user")
    public ResponseEntity<UserAuthenticationResponse> authenticateUser(@RequestBody UserAuthenticationRequest userAuthenticationRequest){
        return  authService.authenticateUser(userAuthenticationRequest);
    }

}
