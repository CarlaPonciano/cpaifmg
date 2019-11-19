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

    public PerguntaDomain() {}

    public PerguntaDomain(int id, String pergunta, TipoPerguntaDomain tipoPergunta) {
        this.id = id;
        this.pergunta = pergunta;
        this.tipoPergunta = tipoPergunta;
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
