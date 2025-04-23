package com.pizza.pizzahut.user.signup.dao;


import com.pizza.pizzahut.user.signup.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class LoginRepository {


        private static Map<String, UserDTO> database = new HashMap<>();

        public void save(UserDTO user) {
            database.put(user.getId(), user);
        }

        public UserDTO findById(String id) {
            return database.get(id);
        }
    }
