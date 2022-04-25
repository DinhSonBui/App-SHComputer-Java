/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Model.CustomerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bui Dinh Son
 */
public class CustomerCtr {
    public ArrayList<CustomerDTO> getAll () {
    ArrayList<CustomerDTO> data = new ArrayList<CustomerDTO>() ;
    ConnectDB db = new ConnectDB ();
    Connection conn = db.getConnection ();
    String Query = "Select * From tblCustomer";
    try {  
        Statement st = conn.createStatement ();
        ResultSet rs = st.executeQuery (Query) ;
        while (rs.next ()) {
            CustomerDTO obj = new CustomerDTO();
            obj.setIdCustomer(rs.getString("idCustomer"));
            obj.setFullname(rs.getString ("fullname"));
            obj.setAddress(rs.getString ("address"));
            obj.setPhone(rs.getString ("phone"));
            data.add(obj);
        }
     } catch (SQLException ex) {
        Logger.getLogger(CustomerCtr.class.getName ()).log (Level.SEVERE, null, ex);
     }
       return data;
    }
    
     public boolean delete (String idCus) {
        ConnectDB db = new ConnectDB ();
        Connection conn = db.getConnection ();
    
        String Query = "Delete from tblCustomer where idCustomer = ?";
        try {
            PreparedStatement prSt = conn.prepareStatement(Query);
            prSt.setString(1, idCus);
            int sl = prSt.executeUpdate();
            if(sl ==1){
               return true;
            }
         } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
        return false;
        
    }
     
     public boolean create (CustomerDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Insert Into tblCustomer (idCustomer, fullname, address, phone) VALUES (?, ?, ?, ?)";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getIdCustomer());
            prSt.setString (2, data.getFullname());
            prSt.setString (3, data.getAddress());
            prSt.setString (4, data.getPhone());
            int sl = prSt.executeUpdate();
            if (sl == 1){
                return true;
            }
        } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
    return false;
   }
    
    
    public boolean update (CustomerDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Update tblCustomer set fullname=?, address=?, phone=? where idCustomer = ? ";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getFullname());
            prSt.setString (2, data.getAddress());
            prSt.setString (3, data.getPhone());
            prSt.setString (4, data.getIdCustomer());
            int sl = prSt.executeUpdate();
            if (sl == 1){
                return true;
            }
        } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
    return false;
   }
}
