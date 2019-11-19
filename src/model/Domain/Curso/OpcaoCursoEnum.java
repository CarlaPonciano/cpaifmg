/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.Curso;

/**
 *
 * @author carli
 */
public enum OpcaoCursoEnum {
    SISTEMAS_DE_INFORMACAO(1), 
    ENGENHARIA_METALURGICA(2), 
    ADMINISTRACAO(3),
    PEDAGOGIA(4);

    private final int id;

    OpcaoCursoEnum(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
      
}
