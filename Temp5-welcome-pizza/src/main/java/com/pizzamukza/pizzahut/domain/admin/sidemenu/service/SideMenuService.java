package com.pizzamukza.pizzahut.domain.admin.sidemenu.service;

import com.pizzamukza.pizzahut.domain.admin.sidemenu.dto.SideMenu;
import com.pizzamukza.pizzahut.domain.admin.sidemenu.repository.SideMenuRepository;

import java.sql.Connection;
import java.util.List;

import static com.pizzamukza.common.JDBCTemplate.close;
import static com.pizzamukza.common.JDBCTemplate.getConnection;

public class SideMenuService {

    private final SideMenuRepository sideMenuRepository;

    public SideMenuService() {
        sideMenuRepository = new SideMenuRepository();
    }

    public void selectAllSideMenus() {

        Connection con = getConnection();

        List<SideMenu> sideMenuList = SideMenuRepository.selectAllSideMenu(con);

        for(SideMenu sm : sideMenuList) {
            System.out.println(sm);
        }

        close(con);

    }
}


