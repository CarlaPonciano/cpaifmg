/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.Curso;

/**
 *
 * @author carli
 */
public class CursoDomain {
    private int id;
    private String curso;
    private int campus_id;

    public CursoDomain() {}

    public CursoDomain(int id, String curso, int campus_id) {
        this.id = id;
        this.curso = curso;
        this.campus_id = campus_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(int campus_id) {
        this.campus_id = campus_id;
    }
    
}
