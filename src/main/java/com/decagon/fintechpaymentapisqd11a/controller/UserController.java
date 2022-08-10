package com.decagon.fintechpaymentapisqd11a.controller;


import com.decagon.fintechpaymentapisqd11a.dto.RegistrationRequestDto;
import com.decagon.fintechpaymentapisqd11a.models.Users;
import com.decagon.fintechpaymentapisqd11a.services.serviceImpl.RegistrationServiceImpl;
import com.decagon.fintechpaymentapisqd11a.services.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final RegistrationServiceImpl registrationService;


    @PostMapping("/registration")
    public ResponseEntity<String> createUserAccount(@Valid @RequestBody RegistrationRequestDto
                                                requestDto) throws JSONException {

        return new ResponseEntity<> (registrationService.createUser(requestDto), HttpStatus.CREATED);
    }

    @GetMapping( "/confirm")
    public String confirmToken(@RequestParam("token") String token ){
        return registrationService.confirmToken(token);
    }
}
