package com.pizzamukza.pizzahut.domain.user.signup.controller;

import com.pizzamukza.pizzahut.domain.user.signup.dto.SignUpDTO;
import com.pizzamukza.pizzahut.domain.user.signup.service.SignUpService;

public class SignUpController {
    private SignUpService service = new SignUpService();

    public void register(String id, String pw, String name) {
        SignUpDTO user = new SignUpDTO(id, pw, name);
         service.registerUser(user);
    }

    public boolean login(String id, String pw) {
        return service.authenticate(id, pw);
    }

    public void changePassword(String id, String newPw) {
        service.updatePassword(id, newPw);
    }
}
