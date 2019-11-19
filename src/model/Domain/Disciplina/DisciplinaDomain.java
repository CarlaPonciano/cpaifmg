/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.Disciplina;

/**
 *
 * @author carli
 */
public class DisciplinaDomain {
    private int id;
    private String disciplina;
    private int curso_id;
    private int periodo;

    public DisciplinaDomain() {}

    public DisciplinaDomain(int id, String disciplina, int curso_id, int periodo) {
        this.id = id;
        this.disciplina = disciplina;
        this.curso_id = curso_id;
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
}
