/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.Resposta;

/**
 *
 * @author carli
 */
public class RespostaDomain {
    private int id;
    private String resposta;

    public RespostaDomain() {}

    public RespostaDomain(int id, String resposta) {
        this.id = id;
        this.resposta = resposta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
}
