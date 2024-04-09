/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import MyUtils.ConnectDB;
/**
 *
 * @author TienTHM_1
 */
public class NhanVienService {
    private Connection conn;
    
    public NhanVienService(){
        conn = ConnectDB.getConnection();
    }
    
    public List<NhanVien> getAll() throws SQLException{
        List<NhanVien> list = new ArrayList();
        String querySelect = "SELECT Ma, Ten, Sdt, TrangThai FROM NhanVien ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(querySelect);
        
        while(rs.next()){
            NhanVien nv = new NhanVien();
            nv.setMa(rs.getString(1));
            nv.setTen(rs.getString(2));
            nv.setSdt(rs.getString(3));
            nv.setTrangThai(rs.getInt(4));
            list.add(nv);
        }
        return list;
    }
    
    public int update(NhanVien nv, String MaNVUpdate) throws SQLException{
        int result = 0;
        if(checkMaUnique(nv.getMa(), MaNVUpdate))
            return result;
        
        String queryUpdate = "UPDATE NhanVien SET Ma = ?, Ten = ?, Sdt = ?, TrangThai =? WHERE Ma = ?";
        
        PreparedStatement ps = conn.prepareStatement(queryUpdate);
        ps.setString(1,nv.getMa());
        ps.setString(2,nv.getTen());
        ps.setString(3,nv.getSdt());
        ps.setInt(4,nv.getTrangThai());
        ps.setString(5, MaNVUpdate);
        
        result = ps.executeUpdate();
        
        return result;
    }
    
    public boolean checkMaUnique(String ma, String maNVUpdate) throws SQLException{
        List<NhanVien> list = getAll();
        for(NhanVien nv:list){
            if(nv.getMa().equals(ma) && !nv.getMa().equals(maNVUpdate))
                return true;
        }
        return false;
        
    }
}
