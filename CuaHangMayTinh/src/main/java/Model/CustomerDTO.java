/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bui Dinh Son
 */
public class CustomerDTO {
    private String idCustomer;
    private String fullname;
    private String address;
    private String phone;

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(String idCustomer, String fullname, String address, String phone) {
        this.idCustomer = idCustomer;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
    }
}
