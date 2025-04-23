package com.pizza.pizzahut.user.signup.service;

import com.pizza.pizzahut.user.signup.dao.LoginRepository;
import com.pizza.pizzahut.user.signup.dto.UserDTO;

public class LoginService {


        private LoginRepository userDAO = new LoginRepository();

        public void registerUser(UserDTO user) {
            userDAO.save(user);
        }

        public boolean authenticate(String id, String password) {
            UserDTO user = userDAO.findById(id);
            return user != null && user.getPassword().equals(password);
        }

        public void updatePassword(String id, String newPassword) {
            UserDTO user = userDAO.findById(id);
            if (user != null) {
                user.setPassword(newPassword);
                userDAO.save(user); // 갱신 저장
            }
        }

        public UserDTO getUser(String id) {
            return userDAO.findById(id);
        }
    }
