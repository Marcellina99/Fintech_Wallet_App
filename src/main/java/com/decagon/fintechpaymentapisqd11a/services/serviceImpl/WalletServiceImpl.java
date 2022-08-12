package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import com.decagon.fintechpaymentapisqd11a.dto.WalletDto;
import com.decagon.fintechpaymentapisqd11a.exceptions.UserNotFoundException;
import com.decagon.fintechpaymentapisqd11a.models.Users;
import com.decagon.fintechpaymentapisqd11a.models.Wallet;
import com.decagon.fintechpaymentapisqd11a.repositories.UsersRepository;
import com.decagon.fintechpaymentapisqd11a.repositories.WalletRepository;
import com.decagon.fintechpaymentapisqd11a.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class WalletServiceImpl implements WalletService {

private final WalletRepository walletRepository;
private final UsersRepository usersRepository;

    @Override
    public WalletDto viewWalletDetails() throws UserNotFoundException {
        WalletDto walletDto =new WalletDto();

        Authentication  users1 = SecurityContextHolder.getContext().getAuthentication();
        Users users = usersRepository.findByEmail(users1.getName());
        if (users == null){
            throw new UserNotFoundException("User not found!");
        }
        Wallet wallet = walletRepository.findWalletByUsersId(users.getId());
        walletDto.setBalance(wallet.getBalance());
        walletDto.setAcctNumber(wallet.getAcctNumber());
        return walletDto;
    }
}
