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

        //SignUpDTO.save(user);
    }

    public boolean authenticate(String id, String password) {
       // SignUpDTO user = SignUpDTO.findByUsername(id);
        Connection con = getConnection();
        SignUpDTO user = signUpRepository.findByUser(con, id, password);

        // 로그인 정보를 전역으로  설정
        UserInfo.info = user;

        close(con);
        return user != null && user.getPassword().equals(password);
      //  return false;//user != null && user.getPassword().equals(password);
    }

    public void updatePassword(String id, String Password) {
//        SignUpDTO user = SignUpDTO.findByUsername(id);
//        if (user != null) {
//            user.setPassword(newPassword);
//            SignUpDTO.save(user); // 갱신 저장
//        }
        Connection con = getConnection();
        signUpRepository.updatePassword(con, id, Password);
        commit(con);
        close(con);
    }

//    public SignUpDTO getUser(String id) {
//        Connection con = getConnection();
//        SignUpDTO user = signUpRepository.findByUsername(con, id);
//        close(con);
//        return user;
//       // return null;//SignUpDTO.findByUsername(id);
//    }
}