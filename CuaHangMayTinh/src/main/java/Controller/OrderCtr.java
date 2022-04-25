/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Model.OrderDTO;
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
public class OrderCtr {
     public ArrayList<OrderDTO> getAll () {
    ArrayList<OrderDTO> data = new ArrayList<OrderDTO> () ;
    ConnectDB db = new ConnectDB ();
    Connection conn = db.getConnection ();
    String Query = "Select * From tblOrder";
    try {
       
        Statement st = conn.createStatement ();
        ResultSet rs = st.executeQuery (Query) ;
        while (rs.next ()) {
            OrderDTO obj = new OrderDTO();
            obj.setIdOrder(rs.getString("idOrder"));
            obj.setPrice(rs.getString("price"));
            obj.setDate(rs.getString("date"));
         
            obj.setStatus(rs.getString("status"));
            data.add(obj);
        }
     } catch (SQLException ex) {
        Logger.getLogger(OrderCtr.class.getName ()).log (Level.SEVERE, null, ex);
     }
       return data;
    }
    
    public boolean delete (String idHoaDon) {
        ConnectDB db = new ConnectDB ();
        Connection conn = db.getConnection ();
    
        String Query = "Delete from tblOrder where idOrder = ?";
        try {
            PreparedStatement prSt = conn.prepareStatement(Query);
            prSt.setString(1, idHoaDon);
            int sl = prSt.executeUpdate();
            if(sl ==1){
               return true;
            }
         } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
        return false;
        
    }
    
    public boolean create (OrderDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Insert Into tblOrder (idOrder, date, price, status) VALUES (?, ?, ?, 'Chưa thanh toán')";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getIdOrder());
            
            prSt.setString (2, data.getDate());
            prSt.setString (3, data.getPrice());
            int sl = prSt.executeUpdate();
            if (sl == 1){
                return true;
            }
        } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
    return false;
   }
    
    
    public boolean update (OrderDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Update tblOrder set date=?, price=? where idOrder = ? ";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            
            prSt.setString (1, data.getDate());
            prSt.setString (2, data.getPrice());
           
            prSt.setString (3, data.getIdOrder());
            int sl = prSt.executeUpdate();
            if (sl == 1){
                return true;
            }
        } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
    return false;
   }
    
    public boolean order (OrderDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Update tblOrder set status='Đã thanh toán' where idOrder = ? ";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getIdOrder());
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
