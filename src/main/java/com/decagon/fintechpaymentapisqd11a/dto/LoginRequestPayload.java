package com.decagon.fintechpaymentapisqd11a.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestPayload {
    private String email;
    private String password;
}
