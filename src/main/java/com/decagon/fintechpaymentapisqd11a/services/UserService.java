package com.decagon.fintechpaymentapisqd11a.services;

import com.decagon.fintechpaymentapisqd11a.models.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface UserService {
    List<Users> getUsers();

    Users getUser(String username);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
