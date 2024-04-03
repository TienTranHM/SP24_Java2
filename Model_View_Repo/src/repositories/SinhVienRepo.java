/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;
import utils.ConnectDB;

/**
 *
 * @author TienTHM_1
 */
public class SinhVienRepo {
    private Connection conn;

    public SinhVienRepo() {
        conn = ConnectDB.getConnection();
    }

    public List<SinhVien> getListSinhVien() {
        List<SinhVien> list = new ArrayList();
        String querySelect = "SELECT * FROM SinhVien";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(querySelect);
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString(1));
                sv.setHoTen(rs.getString(2));
                list.add(sv);
            }
        } catch (Exception e) {
            System.out.println("e: " + e);
        }

        return list;
    }
}
