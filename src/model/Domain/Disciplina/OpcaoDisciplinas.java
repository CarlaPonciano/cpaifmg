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
public class OpcaoDisciplinas {
    private int id;
    private String opcao;
    private String professor;

    public OpcaoDisciplinas() {}

    public OpcaoDisciplinas(int id, String opcao, String professor) {
        this.id = id;
        this.opcao = opcao;
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
}
