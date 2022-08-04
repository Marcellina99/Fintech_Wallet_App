package com.decagon.fintechpaymentapisqd11a.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "wallet_tbl")
public class Wallet extends BaseClass {

    private BigDecimal balance;

    @Column(length = 10, nullable = false)
    private Integer acctNumber;

    @Column(nullable = false)
    private String bankName;

}
