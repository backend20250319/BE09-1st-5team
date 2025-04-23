package com.pizzamukza.pizzahut.domain.user.signup.service;

import com.pizzamukza.pizzahut.domain.user.signup.repository.SignUpRepository;
import com.pizzamukza.pizzahut.domain.user.signup.dto.SignUpDTO;

import java.sql.Connection;

import static com.pizzamukza.common.JDBCTemplate.*;

public class SignUpService {
    private SignUpRepository signUpRepository = new SignUpRepository();

    public void registerUser(SignUpDTO user) {

        Connection con = getConnection();

        int result = signUpRepository.insertMember(con, user);

        if(result > 0){
            commit(con);
        } else {
           rollback(con);
        }

        close(con);

        //SignUpDTO.save(user);
    }

    public boolean authenticate(String id, String password) {
       // SignUpDTO user = SignUpDTO.findByUsername(id);
        return false;//user != null && user.getPassword().equals(password);
    }

    public void updatePassword(String id, String newPassword) {
//        SignUpDTO user = SignUpDTO.findByUsername(id);
//        if (user != null) {
//            user.setPassword(newPassword);
//            SignUpDTO.save(user); // 갱신 저장
//        }
    }

    public SignUpDTO getUser(String id) {
        return null;//SignUpDTO.findByUsername(id);
    }
}