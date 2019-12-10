/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.Pergunta;

import model.Domain.TipoPergunta.TipoPerguntaDomain;

/**
 *
 * @author carli
 */
public class PerguntaDomain {
    private int id;
    private String pergunta;
    private TipoPerguntaDomain tipoPergunta;
    private int tipopergunta_id;

    public PerguntaDomain() {}

    public PerguntaDomain(int id, String pergunta, TipoPerguntaDomain tipoPergunta, int tipopergunta_id) {
        this.id = id;
        this.pergunta = pergunta;
        this.tipoPergunta = tipoPergunta;
        this.tipopergunta_id = tipopergunta_id;
    }

    public int getTipopergunta_id() {
        return tipopergunta_id;
    }

    public void setTipopergunta_id(int tipopergunta_id) {
        this.tipopergunta_id = tipopergunta_id;
    }

    public TipoPerguntaDomain getTipoPergunta() {
        return tipoPergunta;
    }

    public void setTipoPergunta(TipoPerguntaDomain tipoPergunta) {
        this.tipoPergunta = tipoPergunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    
}
