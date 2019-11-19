/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.TipoPergunta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Connection.ConnectionPostgreSQL;

/**
 *
 * @author amanda
 */
public class TipoPerguntaDAO {
    public ResultSet recuperarTipoPergunta(){
        String sql = "SELECT * FROM tipopergunta;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            return rs;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos tipos de perguntas!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
