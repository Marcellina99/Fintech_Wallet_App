package com.decagon.fintechpaymentapisqd11a.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {
    private BigDecimal balance;
    private Integer acctNumber;
    private String bankName = "Wema Bank";
}
