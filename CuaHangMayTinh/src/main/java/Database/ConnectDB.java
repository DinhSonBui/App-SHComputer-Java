/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bui Dinh Son
 */
public class ConnectDB {
    private Connection conn = null;
    
    String userName = "sa";
    String password = "123";
    int port = 1433;
    String dbName = "csdl_QLCHMayTinh";
    String urlDB = "jdbc:sqlserver://localhost:"+port+";encrypt=false;databaseName="+dbName+";";
    
    public void connectSQL() {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try{
                conn = DriverManager.getConnection(urlDB,userName,password);
                System.out.print("Ket noi thanh cong");
            }
            catch(SQLException ex){
                System.out.println("Lỗi kết nối: " + ex.getMessage());
            }
           
        }
        catch(ClassNotFoundException ex){
                System.out.println("Loi khong nap dc Driver : " +ex.getMessage());
        }
        

    }
    public ConnectDB(){
        this.connectSQL();
    }
    public Connection getConnection(){
        return conn;
    }
}
