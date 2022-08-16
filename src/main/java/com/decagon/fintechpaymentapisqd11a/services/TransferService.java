package com.decagon.fintechpaymentapisqd11a.services;

import com.decagon.fintechpaymentapisqd11a.models.FlwBank;
import com.decagon.fintechpaymentapisqd11a.response.FlwGetAllBanksResponse;

import java.util.List;


public interface TransferService {
    List<FlwBank> getAllBanks();
}
