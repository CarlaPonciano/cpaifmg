/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.Campus;

/**
 *
 * @author carli
 */
public class CampusDomain {
    private int id;
    private String campus;

    public CampusDomain() {}

    public CampusDomain(int id, String campus) {
        this.id = id;
        this.campus = campus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
    
}
