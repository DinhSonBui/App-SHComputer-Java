/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Model.CategoryDTO;
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
public class CategoryCtr {
    public ArrayList<CategoryDTO> getAll () {
        ArrayList<CategoryDTO> data = new ArrayList<CategoryDTO> () ;
        ConnectDB db = new ConnectDB ();
        Connection conn = db.getConnection ();
        String Query = "Select * From tblCategory";
        try {

            Statement st = conn.createStatement ();
            ResultSet rs = st.executeQuery (Query) ;
           
            while (rs.next ()) {
                CategoryDTO obj = new CategoryDTO();
                obj.setIdCate(rs.getString("idCate"));
                obj.setNameCategory(rs.getString ("nameCategory"));
                data.add(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryCtr.class.getName ()).log (Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public boolean delete (String idCate) {
        ConnectDB db = new ConnectDB ();
        Connection conn = db.getConnection ();
    
        String Query = "Delete from tblCategory where idCate = ?";
        try {
            PreparedStatement prSt = conn.prepareStatement(Query);
            prSt.setString(1, idCate);
            int sl = prSt.executeUpdate();
            if(sl ==1){
               return true;
            }
         } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
        return false;
        
    }
    
    public boolean create (CategoryDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Insert Into tblCategory (idCate, nameCategory) VALUES (?, ?)";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getIdCate());
            prSt.setString (2, data.getNameCategory());
           
            int sl = prSt.executeUpdate();
            if (sl == 1){
                return true;
            }
        } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
    return false;
   }
    
    
    public boolean update (CategoryDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Update tblCategory set nameCategory=? where idCate = ? ";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getNameCategory());
            prSt.setString (2, data.getIdCate());
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
