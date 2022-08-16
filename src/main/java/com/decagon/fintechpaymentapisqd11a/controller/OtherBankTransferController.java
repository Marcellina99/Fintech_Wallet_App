package com.decagon.fintechpaymentapisqd11a.controller;

import com.decagon.fintechpaymentapisqd11a.models.FlwBank;
import com.decagon.fintechpaymentapisqd11a.services.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transfer")
@RequiredArgsConstructor
public class OtherBankTransferController {

    private final TransferService transferService;

    @GetMapping("/banks")
    public List<FlwBank> getBanks(){
        return transferService.getAllBanks();
    }
}
