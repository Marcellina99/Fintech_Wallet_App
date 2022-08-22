package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import com.decagon.fintechpaymentapisqd11a.dto.TransactionHistoryDto;
import com.decagon.fintechpaymentapisqd11a.exceptions.UserNotFoundException;
import com.decagon.fintechpaymentapisqd11a.models.Transaction;
import com.decagon.fintechpaymentapisqd11a.models.Users;
import com.decagon.fintechpaymentapisqd11a.models.Wallet;
import com.decagon.fintechpaymentapisqd11a.pagination_criteria.TransactionHistoryPages;
import com.decagon.fintechpaymentapisqd11a.repositories.TransactionRepository;
import com.decagon.fintechpaymentapisqd11a.repositories.UsersRepository;
import com.decagon.fintechpaymentapisqd11a.repositories.WalletRepository;
import com.decagon.fintechpaymentapisqd11a.services.TransactionHistory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionHistoryImpl implements TransactionHistory {
    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;
    private final UsersRepository usersRepository;

    public TransactionHistoryImpl(TransactionRepository transactionRepository, WalletRepository walletRepository, UsersRepository usersRepository) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public List<TransactionHistoryDto> allTransaction(TransactionHistoryPages transactionHistoryPages) {

        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = usersRepository.findUsersByEmail(userEmail).orElseThrow(()-> new UserNotFoundException("User not found"));
        Wallet wallet = walletRepository.findWalletByUsers(user);
        List<Transaction> allTransact = transactionRepository.findAllByWallet(wallet);

        List<TransactionHistoryDto> response = new ArrayList<>();
        for(Transaction transaction : allTransact){
            TransactionHistoryDto transactionHistoryDto = new TransactionHistoryDto();
            transactionHistoryDto.setName(transaction.getDestinationAccountName());
            transactionHistoryDto.setBank(transaction.getDestinationBank());
            transactionHistoryDto.setTransactionTime(transaction.getCreatedAt());
            transactionHistoryDto.setTransactionType(transaction.getTransactiontype());
            transactionHistoryDto.setAmount(transaction.getAmount());
            response.add(transactionHistoryDto);

        }

        return response;
    }
    }
