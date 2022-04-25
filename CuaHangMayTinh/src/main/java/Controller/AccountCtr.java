/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Model.AccountDTO;
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
public class AccountCtr {
    public boolean checkLogin(String userName, String password){
        String query ="SELECT COUNT(*) AS SoLuong FROM tblAccount Where username = ? AND password =?";
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
        
        try {
            PreparedStatement prSt = conn.prepareStatement(query);
            prSt.setString(1, userName);
            prSt.setString(2,password);
            ResultSet rs = prSt.executeQuery();
            rs.next();
            int SoLuong = rs.getInt("SoLuong");
            return SoLuong==1;
        } catch (SQLException ex) {
               System.out.println("Loi truy van :" + ex.getMessage());
        }
        return false;
    }
     
    public ArrayList<AccountDTO> getAll () {
    ArrayList<AccountDTO> data = new ArrayList<AccountDTO> () ;
    ConnectDB db = new ConnectDB ();
    Connection conn = db.getConnection ();
    String Query = "Select * From tblAccount";
    try {
       
        Statement st = conn.createStatement ();
        ResultSet rs = st.executeQuery (Query) ;
        while (rs.next ()) {
            AccountDTO obj = new AccountDTO();
            obj.setIdAcc(rs.getString("idAcc"));
            obj.setUsername(rs.getString ("username"));
            obj.setPassword(rs.getString ("password"));
            obj.setFullname(rs.getString ("fullname"));
            data.add(obj);
        }
     } catch (SQLException ex) {
        Logger.getLogger(AccountCtr.class.getName ()).log (Level.SEVERE, null, ex);
     }
       return data;
    }
    
    public boolean delete (String idAcc) {
        ConnectDB db = new ConnectDB ();
        Connection conn = db.getConnection ();
    
        String Query = "Delete from tblAccount where idAcc = ?";
        try {
            PreparedStatement prSt = conn.prepareStatement(Query);
            prSt.setString(1, idAcc);
            int sl = prSt.executeUpdate();
            if(sl ==1){
               return true;
            }
         } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
        return false;
        
    }
    
    public boolean create (AccountDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Insert Into tblAccount (idAcc, username, password, fullname) VALUES (?, ?, ?, ?)";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getIdAcc());
            prSt.setString (2, data.getUsername());
            prSt.setString (3, data.getPassword());
            prSt.setString (4, data.getFullname());
            int sl = prSt.executeUpdate();
            if (sl == 1){
                return true;
            }
        } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
    return false;
   }
    
    
    public boolean update (AccountDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Update tblAccount set username=?, password=?, fullname=? where idAcc = ? ";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getUsername());
            prSt.setString (2, data.getPassword());
            prSt.setString (3, data.getFullname());
            prSt.setString (4, data.getIdAcc());
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
