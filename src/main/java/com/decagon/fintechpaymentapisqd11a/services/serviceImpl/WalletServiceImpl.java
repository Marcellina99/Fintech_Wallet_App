package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import com.decagon.fintechpaymentapisqd11a.dto.WalletDto;
import com.decagon.fintechpaymentapisqd11a.models.Users;
import com.decagon.fintechpaymentapisqd11a.models.Wallet;
import com.decagon.fintechpaymentapisqd11a.repositories.UserRepository;
import com.decagon.fintechpaymentapisqd11a.repositories.WalletRepository;
import com.decagon.fintechpaymentapisqd11a.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;


@RequiredArgsConstructor
@Service
public class WalletServiceImpl implements WalletService {

private final WalletRepository walletRepository;
private final UserRepository userRepository;

    @Override
    public WalletDto viewWalletDetails(Long UserId) throws UserPrincipalNotFoundException {
        Users users = userRepository.findUsersById(UserId)
                .orElseThrow(() -> new UserPrincipalNotFoundException("User not found!"));
        Wallet wallet = walletRepository.findWalletByUsersId(users.getId());
        WalletDto walletDto = new WalletDto();
        walletDto.setBalance(wallet.getBalance());
        walletDto.setAcctNumber(wallet.getAcctNumber());
        return walletDto;
    }
}
