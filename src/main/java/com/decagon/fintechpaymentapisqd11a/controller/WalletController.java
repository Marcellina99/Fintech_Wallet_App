package com.decagon.fintechpaymentapisqd11a.controller;

import com.decagon.fintechpaymentapisqd11a.dto.WalletDto;
import com.decagon.fintechpaymentapisqd11a.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/api/user")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @RequestMapping ("/viewWallet")
    public ResponseEntity<WalletDto> viewWallet() {
        WalletDto walletDto = walletService.viewWalletDetails();
        return new ResponseEntity<>(walletDto, HttpStatus.OK);
    }
}
