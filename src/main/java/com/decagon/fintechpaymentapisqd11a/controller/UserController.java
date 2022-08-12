package com.decagon.fintechpaymentapisqd11a.controller;

import com.decagon.fintechpaymentapisqd11a.dto.AuthResponse;
import com.decagon.fintechpaymentapisqd11a.dto.LoginRequestPayload;
import com.decagon.fintechpaymentapisqd11a.dto.WalletDto;
import com.decagon.fintechpaymentapisqd11a.services.LoginService;
import com.decagon.fintechpaymentapisqd11a.services.UserService;
import com.decagon.fintechpaymentapisqd11a.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;
    private final LoginService loginService;
    private final WalletService walletService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequestPayload loginRequestPayload) throws Exception {
        String token = loginService.authenticate(loginRequestPayload);
        AuthResponse authResponse = new AuthResponse(token);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
    @RequestMapping ("/viewWallet")
    public ResponseEntity<WalletDto> viewWallet() {
        WalletDto walletDto = walletService.viewWalletDetails();
        return new ResponseEntity<>(walletDto, HttpStatus.OK);
    }
}
