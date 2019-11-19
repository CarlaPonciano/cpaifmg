/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.TipoPergunta;

import java.util.List;
import model.Domain.Pergunta.PerguntaDomain;
import model.Domain.TipoResposta.TipoRespostaDomain;

/**
 *
 * @author carli
 */
public class TipoPerguntaDomain {
    private int id;
    private String tipo;
    private TipoRespostaDomain tipo_resposta;
    private List<PerguntaDomain> lista_pergunta;

    public TipoPerguntaDomain() {}

    public TipoPerguntaDomain(int id, String tipo, TipoRespostaDomain tipo_resposta, List<PerguntaDomain> lista_pergunta) {
        this.id = id;
        this.tipo = tipo;
        this.tipo_resposta = tipo_resposta;
        this.lista_pergunta = lista_pergunta;
    }

    public TipoPerguntaDomain(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoRespostaDomain getTipo_resposta() {
        return tipo_resposta;
    }

    public void setTipo_resposta(TipoRespostaDomain tipo_resposta) {
        this.tipo_resposta = tipo_resposta;
    }

    public List<PerguntaDomain> getLista_pergunta() {
        return lista_pergunta;
    }

    public void setLista_pergunta(List<PerguntaDomain> lista_pergunta) {
        this.lista_pergunta = lista_pergunta;
    }
    
}
