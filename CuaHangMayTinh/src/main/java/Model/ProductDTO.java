/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bui Dinh Son
 */
public class ProductDTO {
    private String idProduct;
    private String nameProduct;
    private String nameCategory;
    private String price;

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductDTO() {
    }

    public ProductDTO(String idProduct, String nameProduct, String nameCategory, String price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.nameCategory = nameCategory;
        this.price = price;
    }
}
