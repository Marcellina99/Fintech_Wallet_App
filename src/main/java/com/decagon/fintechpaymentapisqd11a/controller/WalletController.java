package com.decagon.fintechpaymentapisqd11a.controller;

import antlr.Token;
import com.decagon.fintechpaymentapisqd11a.dto.WalletDto;
import com.decagon.fintechpaymentapisqd11a.models.Wallet;
import com.decagon.fintechpaymentapisqd11a.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
public class WalletController {
    @Autowired
    private WalletService walletService;
    @RequestMapping ("/viewWallet/{userId}")
    public ResponseEntity<WalletDto> viewWallet(@PathVariable Long userId) throws UserPrincipalNotFoundException {
        WalletDto walletDto = walletService.viewWalletDetails(userId);
        return new ResponseEntity<>(walletDto, HttpStatus.OK);
    }
}
