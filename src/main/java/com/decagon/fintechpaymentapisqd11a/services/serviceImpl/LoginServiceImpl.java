package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import com.decagon.fintechpaymentapisqd11a.util.JwtUtils;
import com.decagon.fintechpaymentapisqd11a.dto.LoginRequestPayload;
import com.decagon.fintechpaymentapisqd11a.exceptions.UserNotFoundException;
import com.decagon.fintechpaymentapisqd11a.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager userAuthenticationManager;
    private final JwtUtils jwtUtils;
    private final UserDetailsService userService;

    @Override
    public String authenticate(LoginRequestPayload loginDto) throws Exception {
        try {
            userAuthenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new UserNotFoundException("Invalid Credentials");
        }
        final UserDetails userDetails = userService.loadUserByUsername(loginDto.getEmail());
        return jwtUtils.generateToken(userDetails);
    }
}
