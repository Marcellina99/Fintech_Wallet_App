package com.decagon.fintechpaymentapisqd11a.models;

import com.decagon.fintechpaymentapisqd11a.enums.UserStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_tbl")
public class Users extends BaseClass{

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(length = 11, unique = true, nullable = false)
    private String bvn;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 11)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(length = 6)
    private String transactionPin;

    @Column(nullable = false)
    private String token;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private String role;

}
