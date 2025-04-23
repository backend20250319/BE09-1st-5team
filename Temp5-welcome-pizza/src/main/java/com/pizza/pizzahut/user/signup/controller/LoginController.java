package com.pizza.pizzahut.user.signup.controller;


import com.pizza.pizzahut.user.signup.dto.UserDTO;
import com.pizza.pizzahut.user.signup.service.LoginService;

public class LoginController {

        private LoginService service = new LoginService();

        public void register(String id, String pw, String name) {
            UserDTO user = new UserDTO(id, pw, name);
            service.registerUser(user);
        }

        public boolean login(String id, String pw) {
            return service.authenticate(id, pw);
        }

        public void changePassword(String id, String newPw) {
            service.updatePassword(id, newPw);
        }

        public String getName(String id) {
            UserDTO user = service.getUser(id);
            return user != null ? user.getName() : null;
        }
    }
