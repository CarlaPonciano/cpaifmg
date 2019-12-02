/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.Questionario;

import java.util.List;
import model.Domain.RespostaQuestionario.RespostaQuestionarioDomain;
import model.Domain.TipoPergunta.TipoPerguntaDomain;

/**
 *
 * @author carli
 */
public class QuestionarioDomain {
    private int id;
    private String nome;
    private String descricao;
    private String criador;
    private int id_tipo_questionario;
    private String tipo_questionario;
    private List<RespostaQuestionarioDomain> resposta_questionario;
    private int status_id;
    private String status;
    private TipoPerguntaDomain tipo_pergunta;

    public QuestionarioDomain() {}

    public QuestionarioDomain(int id, String nome, String descricao, String criador, int id_tipo_questionario, String tipo_questionario, List<RespostaQuestionarioDomain> resposta_questionario, int status_id, String status, TipoPerguntaDomain tipo_pergunta) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.criador = criador;
        this.id_tipo_questionario = id_tipo_questionario;
        this.tipo_questionario = tipo_questionario;
        this.resposta_questionario = resposta_questionario;
        this.status_id = status_id;
        this.status = status;
        this.tipo_pergunta = tipo_pergunta;
    }

    public TipoPerguntaDomain getTipo_pergunta() {
        return tipo_pergunta;
    }

    public void setTipo_pergunta(TipoPerguntaDomain tipo_pergunta) {
        this.tipo_pergunta = tipo_pergunta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public int getId_tipo_questionario() {
        return id_tipo_questionario;
    }

    public String getTipo_questionario() {
        return tipo_questionario;
    }

    public void setTipo_questionario(String tipo_questionario) {
        this.tipo_questionario = tipo_questionario;
    }

    public void setId_tipo_questionario(int id_tipo_questionario) {
        this.id_tipo_questionario = id_tipo_questionario;
    }
    
    public List<RespostaQuestionarioDomain> getResposta_questionario() {
        return resposta_questionario;
    }

    public void setResposta_questionario(List<RespostaQuestionarioDomain> resposta_questionario) {
        this.resposta_questionario = resposta_questionario;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }
    
}
