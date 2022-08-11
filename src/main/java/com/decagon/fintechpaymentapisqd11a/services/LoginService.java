package com.decagon.fintechpaymentapisqd11a.services;

import com.decagon.fintechpaymentapisqd11a.dto.LoginRequestPayload;

public interface LoginService {
    String authenticate(LoginRequestPayload loginDto) throws Exception;
}
