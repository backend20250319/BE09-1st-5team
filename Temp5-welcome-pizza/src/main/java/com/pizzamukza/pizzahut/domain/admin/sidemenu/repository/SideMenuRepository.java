package com.pizzamukza.pizzahut.domain.admin.sidemenu.repository;

import com.pizzamukza.pizzahut.domain.admin.sidemenu.dto.SideMenu;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.pizzamukza.common.JDBCTemplate.close;
import static com.pizzamukza.common.JDBCTemplate.getConnection;

public class SideMenuRepository {

    private static Properties props = null;

    public SideMenuRepository() {
        props = new Properties();
        try {
            props.loadFromXML(new FileInputStream("src/test/resources/mapper.MemberMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<SideMenu> selectAllSideMenu(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = props.getProperty("selectAllSideMenu");

        System.out.println("sql : " + sql);

        List<SideMenu> sideMenus = null;
        try {
            rset = pstmt.executeQuery();
            sideMenus = new ArrayList<>();
            while (rset.next()) {
                SideMenu sm = new SideMenu();
                sm.setSideId(rset.getInt("sideId"));
                sm.setSideName(rset.getString("sideName"));
                sm.setPrice(rset.getInt("setPrice"));
                sm.setQuantity(rset.getInt("quantity"));

                sideMenus.add(sm);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
        return sideMenus;
    }

    /* 잘 안되는 쿼리문 호출 (목록조회) */
//    public static List<SideMenu> selectAllSideMenu2(Connection con) {
//        Statement stmt = null;
//        ResultSet rset = null;
//
//        String query = "SELECT * FROM tbl_side_menu";
//        System.out.println("query = " + query);
//
//        try {
//            stmt = con.createStatement();
//            rset = stmt.executeQuery(query);
//
//            if (rset.next()) {
//                System.out.println(rset.getString("sideName") + "");
//            } else {
//                System.out.println("메뉴 정보가 없습니다.");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            close(rset);
//            close(stmt);
//            close(con);
//
//        }
//    }
}
