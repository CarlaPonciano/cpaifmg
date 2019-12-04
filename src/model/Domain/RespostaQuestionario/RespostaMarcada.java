/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.RespostaQuestionario;

/**
 *
 * @author carli
 */
public class RespostaMarcada {
    private int id;
    private int respostaquestionario_id;
    private int id_pergunta;
    private int id_resposta;

    public RespostaMarcada() {}

    public RespostaMarcada(int id, int respostaquestionario_id, int id_pergunta, int id_resposta) {
        this.id = id;
        this.respostaquestionario_id = respostaquestionario_id;
        this.id_pergunta = id_pergunta;
        this.id_resposta = id_resposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRespostaquestionario_id() {
        return respostaquestionario_id;
    }

    public void setRespostaquestionario_id(int respostaquestionario_id) {
        this.respostaquestionario_id = respostaquestionario_id;
    }

    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    public int getId_resposta() {
        return id_resposta;
    }

    public void setId_resposta(int id_resposta) {
        this.id_resposta = id_resposta;
    }
    
}
