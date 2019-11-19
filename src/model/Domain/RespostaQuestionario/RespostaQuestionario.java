/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.RespostaQuestionario;

import java.util.List;

/**
 *
 * @author carli
 */
public class RespostaQuestionario {
    private int id;
    private String semestre_marcado;
    private int id_opcao_disciplina;
    private int id_opcao_curso;
    private int id_opcao_campus;
    private String nome;
    private String observacoes;
    private List<RespostaMarcada> resposta_marcada;

    public RespostaQuestionario() {}

    public RespostaQuestionario(int id, String semestre_marcado, int id_opcao_disciplina, int id_opcao_curso, int id_opcao_campus, String nome, String observacoes, List<RespostaMarcada> resposta_marcada) {
        this.id = id;
        this.semestre_marcado = semestre_marcado;
        this.id_opcao_disciplina = id_opcao_disciplina;
        this.id_opcao_curso = id_opcao_curso;
        this.id_opcao_campus = id_opcao_campus;
        this.nome = nome;
        this.observacoes = observacoes;
        this.resposta_marcada = resposta_marcada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemestre_marcado() {
        return semestre_marcado;
    }

    public void setSemestre_marcado(String semestre_marcado) {
        this.semestre_marcado = semestre_marcado;
    }

    public int getId_opcao_disciplina() {
        return id_opcao_disciplina;
    }

    public void setId_opcao_disciplina(int id_opcao_disciplina) {
        this.id_opcao_disciplina = id_opcao_disciplina;
    }

    public int getId_opcao_curso() {
        return id_opcao_curso;
    }

    public void setId_opcao_curso(int id_opcao_curso) {
        this.id_opcao_curso = id_opcao_curso;
    }

    public int getId_opcao_campus() {
        return id_opcao_campus;
    }

    public void setId_opcao_campus(int id_opcao_campus) {
        this.id_opcao_campus = id_opcao_campus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<RespostaMarcada> getResposta_marcada() {
        return resposta_marcada;
    }

    public void setResposta_marcada(List<RespostaMarcada> resposta_marcada) {
        this.resposta_marcada = resposta_marcada;
    }
    
}
