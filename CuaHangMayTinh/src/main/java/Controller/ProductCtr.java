/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectDB;
import Model.ProductDTO;
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
public class ProductCtr {
    public ArrayList<ProductDTO> getAll () {
        ArrayList<ProductDTO> data = new ArrayList<ProductDTO> () ;
        ConnectDB db = new ConnectDB ();
        Connection conn = db.getConnection ();
        String Query = "Select * From tblProduct";
        try {

            Statement st = conn.createStatement ();
            ResultSet rs = st.executeQuery (Query) ;
           // Buớc 4: Đọc đữ liệu từ rs ra ArrayList
            while (rs.next ()) {
                ProductDTO obj = new ProductDTO();
                obj.setIdProduct(rs.getString("idProduct"));
                obj.setNameProduct(rs.getString ("nameProduct"));
                obj.setNameCategory(rs.getString ("nameCategory"));
                obj.setPrice(rs.getString ("price"));
                data.add(obj);
            }
         } catch (SQLException ex) {
            Logger.getLogger(ProductCtr.class.getName ()).log (Level.SEVERE, null, ex);
         }
           return data;
    }
    
    public boolean delete (String idProduct) {
        ConnectDB db = new ConnectDB ();
        Connection conn = db.getConnection ();
    
        String Query = "Delete from tblProduct where idProduct = ?";
        try {
            PreparedStatement prSt = conn.prepareStatement(Query);
            prSt.setString(1, idProduct);
            int sl = prSt.executeUpdate();
            if(sl ==1){
               return true;
            }
         } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
        return false;
        
    }
    
    public boolean create (ProductDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Insert Into tblProduct (idProduct, nameProduct, nameCategory, price) VALUES (?, ?, ?, ?)";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getIdProduct());
            prSt.setString (2, data.getNameProduct());
            prSt.setString (3, data.getNameCategory());
            prSt.setString (4, data.getPrice());
            int sl = prSt.executeUpdate();
            if (sl == 1){
                return true;
            }
        } catch (SQLException ex) {
            
            System.out.println("Loi:" + ex.getMessage ());
        }
    return false;
   }
    
    
    public boolean update (ProductDTO data) {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
 
        String Query = "Update tblProduct set nameProduct=?, nameCategory=?, price=? where idProduct = ? ";
        try
        {
            PreparedStatement prSt = conn.prepareStatement(Query) ;
            prSt.setString (1, data.getNameProduct());
            prSt.setString (2, data.getNameCategory());
            prSt.setString (3, data.getPrice());
            prSt.setString (4, data.getIdProduct());
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
