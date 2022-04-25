/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.cuahangmaytinh;

import Controller.OrderCtr;
import Model.OrderDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bui Dinh Son
 */
public class frmOrder extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmOrder
     */
    
    private OrderCtr db = new OrderCtr ();
    private final DefaultTableModel tableModel = new DefaultTableModel ();
    private ArrayList<OrderDTO> data;
    private boolean isAdd = false;
   

    public void clearData () {
        int n = tableModel.getRowCount()-1;
        for (int i=n; i>=0; i--) {
            tableModel.removeRow(i);
        }
    }
    
    public void setNull(){
      
        txtMaHD.setText("");
        txtNgayLap.setText("");
        txtGiaHD.setText("");
      
    }
    
    public void setLock () {
        
        txtMaHD.setEnabled (false);
        txtNgayLap.setEnabled (false);
        txtGiaHD.setEnabled (false);
        txtGiaHD.setEnabled (false);
         btnSua.setEnabled (false) ;
         btnXoa.setEnabled(false);
         btnLuu.setEnabled (false);
         btnHuy.setEnabled (false);
    }
    
    public void getData () {
        data = db.getAll();
    }
    public void reloadData(){
        clearData();
        getData();
        showData();
    }
    public void showData () {
        for (int i=0; i<data.size (); i++) {
            String rows [] = new String[4];
            rows [0] = data.get (i).getIdOrder();
            rows [1] = data.get(i).getPrice();
            rows [2] = data.get(i).getDate();
            rows [3] = data.get(i).getStatus();
            tableModel.addRow (rows);
        }
    }

    
    
    public frmOrder() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        
        setLock ();
        String []colsName = {"Mã hóa đơn",  "Ngày lập","Gía hóa đơn", "Trạng  thái"};
        tableModel.setColumnIdentifiers (colsName);
        tblHoaDon.setModel (tableModel);
        getData ();
        showData ();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtGiaHD = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnThanhToan = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(714, 511));

        jPanel1.setBackground(new java.awt.Color(25, 36, 58));
        jPanel1.setPreferredSize(new java.awt.Dimension(714, 511));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã HĐ");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Doanh Thu");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày");

        txtGiaHD.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtMaHD.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        txtNgayLap.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btnThem.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnThanhToan.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(txtGiaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)))
                        .addComponent(btnThanhToan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        setNull();
        txtMaHD.setEnabled(true);
        txtGiaHD.setEnabled (true);
        txtNgayLap.setEnabled (true);
       
        btnSua.setEnabled (false) ;
        btnXoa.setEnabled(false);
        btnLuu.setEnabled (true);
        btnHuy.setEnabled (true);

        isAdd = true;
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        txtGiaHD.setEnabled (true);
        txtNgayLap.setEnabled (true);
        
        btnLuu.setEnabled (true);
        btnHuy.setEnabled (true);
        btnXoa.setEnabled(false);

        isAdd= false;
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String idAcc = txtMaHD.getText();
        boolean kt = db.delete(idAcc);
        if (kt == true)
        {
            setNull();
            setLock();
            reloadData();
            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", 1);

        }
        else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại!","Thông bảo", 1);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        setNull();
        setLock();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
       OrderDTO obj = new OrderDTO();
        obj.setIdOrder(txtMaHD.getText());
        obj.setDate(txtNgayLap.getText());
        obj.setPrice(txtGiaHD.getText());
       
        obj.setStatus("Chưa thanh toán");

        if(isAdd == true)
        {
            boolean kt = db.create(obj);
            if(kt == true)
            {
                setNull();
                setLock();
                reloadData();
                JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", 1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Thêm thất bại!", "Thông báo", 1);
            }
        }
        else{
            boolean kt = db.update(obj);
            if(kt == true)
            {
                setNull();
                setLock();
                reloadData();
                JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", 1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Thông báo", 1);
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        try {
            int row = tblHoaDon.getSelectedRow ();
            txtMaHD.setText (data.get(row).getIdOrder());
            txtGiaHD.setText(data.get(row).getDate());
            txtNgayLap.setText (data.get(row).getPrice());

            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }
        catch (Exception ex) {
            System.out.print ("Loi:" + ex.getMessage ());
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        OrderDTO obj = new OrderDTO();
        obj.setIdOrder(txtMaHD.getText());
       
        obj.setDate(txtNgayLap.getText());
        obj.setPrice(txtGiaHD.getText());
        obj.setStatus("Đã thanh toán");    
        boolean kt = db.order(obj);
            if(kt == true)
            {
                setNull();
                setLock();
                reloadData();
                JOptionPane.showMessageDialog(null, "Thanh toán thành công!", "Thông báo", 1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Thanh toán thất bại!", "Thông báo", 1);
            }
    }//GEN-LAST:event_btnThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtGiaHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayLap;
    // End of variables declaration//GEN-END:variables
}