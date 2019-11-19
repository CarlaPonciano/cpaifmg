/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Domain.Campus;

/**
 *
 * @author carli
 */
public enum OpcaoCampusEnum {
    IFMG_OURO_BRANCO(1);

    private final int id;

    OpcaoCampusEnum(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}
