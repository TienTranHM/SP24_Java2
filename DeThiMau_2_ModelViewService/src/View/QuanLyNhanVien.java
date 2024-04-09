/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.NhanVien;
import Service.NhanVienService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TienTHM_1
 */
public class QuanLyNhanVien extends javax.swing.JFrame {
    List<NhanVien> list = new ArrayList();
    private NhanVienService nvService = new NhanVienService();
//  MaNVUpdate lưu mã nhân viên lại, để dùng khi chạy chức năng update
    private String MaNVUpdate;
    /**
     * Creates new form QuanLyNhanVien
     */
    public QuanLyNhanVien() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        this.loadData();
    //  Lấy index của phần tử cuối cùng trong list: list.size() - 1
        displayTextField(list.size() - 1);
        MaNVUpdate = list.get(list.size() - 1).getMa();
    }
    
    public void loadData() throws SQLException{
        list = nvService.getAll();
        this.fillToTable();
    }
    
    public void fillToTable(){
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for(NhanVien nv:list){
            Object[] row = {nv.getMa(), nv.getTen(), nv.getSdt(), nv.getTrangThai()==1?"Dang lam":"Nghi viec"};
            model.addRow(row);
        }
    }
    
    public void displayTextField(int index){
        NhanVien nv = list.get(index);
        txtMa.setText(nv.getMa());
        txtTen.setText(nv.getTen());
        txtSDT.setText(nv.getSdt());
        if(nv.getTrangThai()==1)
            rdoDangLam.setSelected(true);
        else rdoNghiViec.setSelected(true);
    }

   
    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        int index = tblNhanVien.getSelectedRow();
        this.displayTextField(index);
        MaNVUpdate = list.get(index).getMa();
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            NhanVien nv = this.readDataForm();
            if(nvService.update(nv, MaNVUpdate) == 0){
                JOptionPane.showMessageDialog(rootPane, "Trung ma, vui long kiem tra lai");
                return;
            } else JOptionPane.showMessageDialog(rootPane, "Update thanh cong");
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    
    public NhanVien readDataForm(){
        NhanVien nv = new NhanVien();
        nv.setMa(txtMa.getText());
        nv.setTen(txtTen.getText());
        nv.setSdt(txtSDT.getText());
        nv.setTrangThai(rdoDangLam.isSelected()?1:0);    
        return nv;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new QuanLyNhanVien().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoDangLam;
    private javax.swing.JRadioButton rdoNghiViec;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
