package com.decagon.fintechpaymentapisqd11a.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {
    private BigDecimal balance;
    private Integer acctNumber;
    private String bankName = "Wema Bank";
}
