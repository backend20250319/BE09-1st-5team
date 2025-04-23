package com.pizzamukza.pizzahut.domain.admin.sidemenu.repository;

import com.pizzamukza.pizzahut.domain.admin.sidemenu.dto.SideMenu;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

public class SideMenuRepository {

    private Properties props = null;

    public SideMenuRepository() {
        props = new Properties();
        try {
            props.loadFromXML(new FileInputStream("src/test/resources/mapper.MemberMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SideMenu> selectSideMenu() {

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        System.out.println();

        String sql = props.getProperty("selectSideMenu");

    }
}
