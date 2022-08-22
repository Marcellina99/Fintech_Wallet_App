package com.decagon.fintechpaymentapisqd11a.repositories;

import com.decagon.fintechpaymentapisqd11a.models.Users;
import com.decagon.fintechpaymentapisqd11a.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface WalletRepository extends JpaRepository<Wallet, java.lang.Long> {
    Wallet findWalletById(Long id);

    Wallet findWalletByUsers(Users users);

}