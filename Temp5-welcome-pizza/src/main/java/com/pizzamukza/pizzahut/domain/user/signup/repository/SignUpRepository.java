package com.pizzamukza.pizzahut.domain.user.signup.repository;

import com.pizzamukza.common.JDBCTemplate;
import com.pizzamukza.pizzahut.domain.user.signup.dto.SignUpDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.pizzamukza.common.JDBCTemplate.close;

public class SignUpRepository {

    public int insertMember(Connection con, SignUpDTO user) {

        PreparedStatement pstmt = null;
        int result = 0;

        String sql = "INSERT INTO tbl_member (username, password, name) VALUES (?, ?, ?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getMemberId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }


        return result;
    }

//    public void save(SignUpDTO user) {
//        tbl_member.put(user.getId(), user);
//        System.out.println("✅ [tbl_member]에 저장 완료: " + user.getId());
//    }

    public SignUpDTO findByUsername(String username) {
        return null;
    }

    public boolean existsByUsername(String username) {
        return false;
    }

    public void updatePassword(String username, String newPassword) {
//        SignUpDTO user = tbl_member.get(username);
//        if (user != null) {
//            user.setPassword(newPassword);
//            System.out.println("🔐 비밀번호 변경 완료");
//        }
    }

}

