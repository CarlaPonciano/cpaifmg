/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.RespostaMarcada;

import model.DAO.RespostaQuestionarioDAO.*;
import model.Domain.Questionario.QuestionarioDomain;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;
import model.Domain.RespostaQuestionario.RespostaMarcada;

/**
 *
 * @author carli
 */
public class RespostaMarcadaDAO {
    
    /*public boolean cadastrarListaResposta(List<RespostaMarcada> lista_resposta_marcada){
        for(RespostaMarcada lista : lista_resposta_marcada){
            String sql = "INSERT INTO listarespostamarcada(respostaquestionario_id, resposta_id, pergunta_id) VALUES "
                            + "('" + lista.getRespostaquestionario_id() + "', '" + lista.getId_resposta() + "', '"
                            + lista.getId_pergunta()+ ");";
            try{
                Connection con = ConnectionPostgreSQL.getInstance().getConnection();
                Statement stm = con.createStatement();
                stm.executeUpdate(sql);
                return true;
            }catch(SQLException e){
                System.out.println("Erro no cadastro do questionário!");
                System.out.println(sql);
                System.out.println(e.getMessage());
                return false;
            }
        }
    }*/
    
    
}
