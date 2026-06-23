package com.oasis.reservation.service;

import com.oasis.reservation.dao.UserDAO;
import com.oasis.reservation.util.PasswordUtil;

public class AuthService {
    private final UserDAO userDAO = new UserDAO();

    public boolean login(String loginId, String plainPassword) {
        String passwordHash = PasswordUtil.sha256(plainPassword);
        return userDAO.isValidUser(loginId, passwordHash);
    }
}