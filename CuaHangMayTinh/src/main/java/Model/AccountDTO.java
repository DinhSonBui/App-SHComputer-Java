/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bui Dinh Son
 */
public class AccountDTO {
    private String idAcc;
    private String username;
    private String password;
    private String fullname;

    public String getIdAcc() {
        return idAcc;
    }

    public void setIdAcc(String idAcc) {
        this.idAcc = idAcc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public AccountDTO() {
    }

    public AccountDTO(String idAcc, String username, String password, String fullname) {
        this.idAcc = idAcc;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

   
}
