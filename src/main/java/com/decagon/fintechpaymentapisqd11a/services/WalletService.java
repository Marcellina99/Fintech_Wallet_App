package com.decagon.fintechpaymentapisqd11a.services;

import com.decagon.fintechpaymentapisqd11a.dto.WalletDto;
import com.decagon.fintechpaymentapisqd11a.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;


@Service
public interface WalletService {
    WalletDto viewWalletDetails() throws UserNotFoundException;

}
