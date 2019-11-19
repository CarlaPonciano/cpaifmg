/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.TipoQuestionario;

/**
 *
 * @author carli
 */
public enum TipoQuestionarioEnum {
    AVALIACAO_DISCIPLINAS(1), 
    AVALIACAO_CURSO(2), 
    AVALIACAO_INSTITUICAO(3);

    private final int id;

    TipoQuestionarioEnum(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}
