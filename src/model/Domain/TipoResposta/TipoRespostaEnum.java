/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.TipoResposta;

/**
 *
 * @author carli
 */
public enum TipoRespostaEnum {
    ESCALA_NUMERICA(1);

    private final int id;

    TipoRespostaEnum(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}
