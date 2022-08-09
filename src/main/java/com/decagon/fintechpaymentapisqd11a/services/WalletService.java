package com.decagon.fintechpaymentapisqd11a.services;

import com.decagon.fintechpaymentapisqd11a.dto.WalletDto;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public interface WalletService {
    WalletDto viewWalletDetails(Long UserId) throws UserPrincipalNotFoundException;
}
