/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bui Dinh Son
 */
public class CategoryDTO {
    private String idCate;
    private String nameCategory;

    public String getIdCate() {
        return idCate;
    }

    public void setIdCate(String idCate) {
        this.idCate = idCate;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public CategoryDTO(String idCate, String nameCategory) {
        this.idCate = idCate;
        this.nameCategory = nameCategory;
    }

    public CategoryDTO() {
    }
}
