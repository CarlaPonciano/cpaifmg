/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.Pergunta;

import model.Domain.Pergunta.PerguntaDomain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Connection.ConnectionPostgreSQL;

/**
 *
 * @author amanda
 */
public class PerguntaDAO {
    public boolean cadastrarPergunta(PerguntaDomain pergunta){
        String sql = "INSERT INTO pergunta (pergunta, tipopergunta_id) VALUES "
                        + "('" + pergunta.getPergunta() + "', " + pergunta.getTipoPergunta().getId() + ");";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro no cadastro da questão!");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet recuperarPerguntas(){
        String sql = "SELECT P.id AS P_id, P.pergunta, TP.id AS TP_id, TP.tipo FROM pergunta AS P, tipopergunta AS TP"
                    + " WHERE P.tipoPergunta_id = TP.id;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            return rs;
        }catch(SQLException e){
            System.out.println("Erro na recuperação das questões!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
