package com.pizzamukza.pizzahut.domain.user.signup.service;

import com.pizzamukza.common.UserInfo;
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
    }

    public boolean authenticate(String id, String password) {
       // SignUpDTO user = SignUpDTO.findByUsername(id);
        Connection con = getConnection();
        SignUpDTO user = signUpRepository.findByUser(con, id, password);

        // 로그인 정보를 전역으로  설정
        UserInfo.info = user;

        close(con);
        return user != null && user.getPassword().equals(password);
    }

    public void updatePassword(String id, String Password) {

        Connection con = getConnection();

        signUpRepository.updatePassword(con, id, Password);
        commit(con);
        close(con);
    }

}