package com.decagon.fintechpaymentapisqd11a.services;

import com.decagon.fintechpaymentapisqd11a.dto.TransactionHistoryDto;
import com.decagon.fintechpaymentapisqd11a.pagination_criteria.TransactionHistoryPages;

import java.util.List;

public interface TransactionHistory {

    List<TransactionHistoryDto> allTransaction(TransactionHistoryPages transactionHistoryPages);

}
