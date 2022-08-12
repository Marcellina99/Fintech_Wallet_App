package com.decagon.fintechpaymentapisqd11a.services;

import com.decagon.fintechpaymentapisqd11a.models.Wallet;
import com.decagon.fintechpaymentapisqd11a.request.FlwWalletRequest;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface WalletService {

    Wallet createWallet(FlwWalletRequest walletRequest) throws JSONException;
}
