package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;


import com.decagon.fintechpaymentapisqd11a.dto.RegistrationRequestDto;
import com.decagon.fintechpaymentapisqd11a.enums.UserStatus;
import com.decagon.fintechpaymentapisqd11a.exceptions.EmailAlreadyTakenException;
import com.decagon.fintechpaymentapisqd11a.exceptions.UserNotFoundException;
import com.decagon.fintechpaymentapisqd11a.models.Users;
import com.decagon.fintechpaymentapisqd11a.models.Wallet;
import com.decagon.fintechpaymentapisqd11a.repositories.ConfirmationTokenRepository;
import com.decagon.fintechpaymentapisqd11a.repositories.UserRepository;
import com.decagon.fintechpaymentapisqd11a.repositories.WalletRepository;
import com.decagon.fintechpaymentapisqd11a.request.FlwWalletRequest;
import com.decagon.fintechpaymentapisqd11a.services.UserService;
import com.decagon.fintechpaymentapisqd11a.services.WalletService;
import com.decagon.fintechpaymentapisqd11a.token.ConfirmationToken;
import com.decagon.fintechpaymentapisqd11a.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;

    private final WalletService walletService;

    private final ConfirmationTokenServiceImpl tokenService;

    private final WalletRepository walletRepository;
    private final Util util;

    @Override
    public String registerUser(RegistrationRequestDto registrationRequestDto) throws JSONException {

        Users user = new Users();
        boolean userExists = userRepository.findByEmail(registrationRequestDto.getEmail()).isPresent();
        boolean passwordMatch = util.validatePassword(registrationRequestDto.getPassword(),
                registrationRequestDto.getConfirmPassword());

        if(userExists){
            throw new EmailAlreadyTakenException("Email Already Taken");
        }
        if(!passwordMatch){
            throw new InputMismatchException("Passwords do not match!");
        }
        //TODO: Encode Password and transaction pin

        BeanUtils.copyProperties(registrationRequestDto, user);
       Users user1 = userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                user
        );
        confirmationTokenRepository.save(confirmationToken);

        Wallet wallet = walletService.createWallet(FlwWalletRequest.builder()
                        .firstname(user1.getFirstName())
                        .lastname(user1.getLastName())
                        .email(user1.getEmail())
                        .phonenumber(user1.getPhoneNumber())
                        .bvn(user1.getBvn())
                .build());
        wallet.setUsers(user1);
        wallet.setBalance(0.00);
        walletRepository.save(wallet);
        return token;
    }

    @Override
    public void enableUser(String email) {
        Users users = userRepository.findByEmail(email)
                .orElseThrow(()-> new UserNotFoundException("User Not Found"));
        users.setUserStatus(UserStatus.ACTIVE);
        userRepository.save(users);
    }

    @Override
    public void saveToken(String token, Users users) {
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                users
        );
        tokenService.saveConfirmationToken(confirmationToken);
    }
}
