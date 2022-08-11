package com.decagon.fintechpaymentapisqd11a.services.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.decagon.fintechpaymentapisqd11a.dto.RegistrationRequestDto;
import com.decagon.fintechpaymentapisqd11a.enums.UserStatus;
import com.decagon.fintechpaymentapisqd11a.exceptions.EmailAlreadyTakenException;
import com.decagon.fintechpaymentapisqd11a.models.Users;
import com.decagon.fintechpaymentapisqd11a.models.Wallet;
import com.decagon.fintechpaymentapisqd11a.repositories.ConfirmationTokenRepository;
import com.decagon.fintechpaymentapisqd11a.repositories.UserRepository;
import com.decagon.fintechpaymentapisqd11a.repositories.WalletRepository;
import com.decagon.fintechpaymentapisqd11a.services.WalletService;
import com.decagon.fintechpaymentapisqd11a.util.Util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private ConfirmationTokenRepository confirmationTokenRepository;

    @MockBean
    private ConfirmationTokenServiceImpl confirmationTokenServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @MockBean
    private Util util;

    @MockBean
    private WalletRepository walletRepository;

    @MockBean
    private WalletService walletService;

    /**
     * Method under test: {@link UserServiceImpl#registerUser(RegistrationRequestDto)}
     */
    @Test
    void testRegisterUser() throws JSONException {
        Wallet wallet = new Wallet();
        wallet.setAcctNumber("42");
        wallet.setBalance(10.0d);
        wallet.setBankName("Bank Name");
        wallet.setCreatedAt(null);
        wallet.setId(123L);
        wallet.setTransactionList(new ArrayList<>());
        wallet.setUpdatedAt(null);
        wallet.setUsers(new Users());

        Users users = new Users();
        users.setBvn("Bvn");
        users.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setId(123L);
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        users.setPhoneNumber("4105551212");
        users.setTransactionPin("Transaction Pin");
        users.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        users.setUserStatus(UserStatus.ACTIVE);
        users.setWallet(wallet);

        Wallet wallet1 = new Wallet();
        wallet1.setAcctNumber("42");
        wallet1.setBalance(10.0d);
        wallet1.setBankName("Bank Name");
        wallet1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        wallet1.setId(123L);
        wallet1.setTransactionList(new ArrayList<>());
        wallet1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        wallet1.setUsers(users);

        Users users1 = new Users();
        users1.setBvn("Bvn");
        users1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        users1.setEmail("jane.doe@example.org");
        users1.setFirstName("Jane");
        users1.setId(123L);
        users1.setLastName("Doe");
        users1.setPassword("iloveyou");
        users1.setPhoneNumber("4105551212");
        users1.setTransactionPin("Transaction Pin");
        users1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        users1.setUserStatus(UserStatus.ACTIVE);
        users1.setWallet(wallet1);
        Optional<Users> ofResult = Optional.of(users1);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(util.validatePassword((String) any(), (String) any())).thenReturn(true);
        assertThrows(EmailAlreadyTakenException.class, () -> userServiceImpl.registerUser(new RegistrationRequestDto("Jane",
                "Doe", "jane.doe@example.org", "4105551212", "Bvn", "iloveyou", "iloveyou", "Transaction Pin")));
        verify(userRepository).findByEmail((String) any());
        verify(util).validatePassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#registerUser(RegistrationRequestDto)}
     */
    @Test
    void testRegisterUser2() throws JSONException {
        Wallet wallet = new Wallet();
        wallet.setAcctNumber("42");
        wallet.setBalance(10.0d);
        wallet.setBankName("Bank Name");
        wallet.setCreatedAt(null);
        wallet.setId(123L);
        wallet.setTransactionList(new ArrayList<>());
        wallet.setUpdatedAt(null);
        wallet.setUsers(new Users());

        Users users = new Users();
        users.setBvn("Bvn");
        users.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        users.setEmail("jane.doe@example.org");
        users.setFirstName("Jane");
        users.setId(123L);
        users.setLastName("Doe");
        users.setPassword("iloveyou");
        users.setPhoneNumber("4105551212");
        users.setTransactionPin("Transaction Pin");
        users.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        users.setUserStatus(UserStatus.ACTIVE);
        users.setWallet(wallet);

        Wallet wallet1 = new Wallet();
        wallet1.setAcctNumber("42");
        wallet1.setBalance(10.0d);
        wallet1.setBankName("Bank Name");
        wallet1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        wallet1.setId(123L);
        wallet1.setTransactionList(new ArrayList<>());
        wallet1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        wallet1.setUsers(users);

        Users users1 = new Users();
        users1.setBvn("Bvn");
        users1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        users1.setEmail("jane.doe@example.org");
        users1.setFirstName("Jane");
        users1.setId(123L);
        users1.setLastName("Doe");
        users1.setPassword("iloveyou");
        users1.setPhoneNumber("4105551212");
        users1.setTransactionPin("Transaction Pin");
        users1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        users1.setUserStatus(UserStatus.ACTIVE);
        users1.setWallet(wallet1);
        Optional<Users> ofResult = Optional.of(users1);
        when(userRepository.findByEmail((String) any())).thenReturn(ofResult);
        when(util.validatePassword((String) any(), (String) any()))
                .thenThrow(new EmailAlreadyTakenException("An error occurred"));
        assertThrows(EmailAlreadyTakenException.class, () -> userServiceImpl.registerUser(new RegistrationRequestDto("Jane",
                "Doe", "jane.doe@example.org", "4105551212", "Bvn", "iloveyou", "iloveyou", "Transaction Pin")));
        verify(userRepository).findByEmail((String) any());
        verify(util).validatePassword((String) any(), (String) any());
    }
}

