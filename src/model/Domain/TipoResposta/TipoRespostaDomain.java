/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.TipoResposta;

import java.util.List;
import model.Domain.Resposta.RespostaDomain;

/**
 *
 * @author carli
 */
public class TipoRespostaDomain {
    private int id;
    private String tipo;
    private List<RespostaDomain> lista_resposta;

    public TipoRespostaDomain() {}

    public TipoRespostaDomain(int id, String tipo, List<RespostaDomain> lista_resposta) {
        this.id = id;
        this.tipo = tipo;
        this.lista_resposta = lista_resposta;
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

    public List<RespostaDomain> getLista_resposta() {
        return lista_resposta;
    }

    public void setLista_resposta(List<RespostaDomain> lista_resposta) {
        this.lista_resposta = lista_resposta;
    }
    
}
