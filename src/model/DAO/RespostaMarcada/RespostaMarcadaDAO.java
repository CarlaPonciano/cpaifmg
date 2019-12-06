/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.RespostaMarcada;

import model.DAO.RespostaQuestionarioDAO.*;
import model.Domain.Questionario.QuestionarioDomain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;
import model.Domain.RespostaQuestionario.RespostaMarcadaDomain;

/**
 *
 * @author carli
 */
public class RespostaMarcadaDAO {
    
    public boolean cadastrarListaResposta(List<RespostaMarcadaDomain> lista_resposta_marcada, int index){
        boolean executou = true;
        for(RespostaMarcadaDomain lista : lista_resposta_marcada){
            String sql = "INSERT INTO listarespostamarcada(respostaquestionario_id, resposta_id, pergunta_id) VALUES "
                            + "(" + index + ", " + lista.getId_resposta() + ", "
                            + lista.getId_pergunta()+ ");";
            try{
                Connection con = ConnectionPostgreSQL.getInstance().getConnection();
                Statement stm = con.createStatement();
                stm.executeUpdate(sql);
            }catch(SQLException e){
                System.out.println("Erro no cadastro das respostas do questionário");
                System.out.println(sql);
                System.out.println(e.getMessage());
                executou = false;
            }
        }
        return executou;
    }
    
    public List<RespostaMarcadaDomain> recuperarListaResposta(int resposta_questionario_id){
        String sql = "SELECT * FROM listarespostamarcada_pergunta_resposta where respostaquestionario_id = " + resposta_questionario_id + ";";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            RespostaMarcadaDomain resposta_marcada;
            List<RespostaMarcadaDomain> lista_resposta_marcada = new ArrayList();
            while(rs.next()){
                resposta_marcada = new RespostaMarcadaDomain();
                resposta_marcada.setId(rs.getInt("id"));
                resposta_marcada.setPergunta(rs.getString("pergunta"));
                resposta_marcada.setResposta(rs.getString("resposta"));
                lista_resposta_marcada.add(resposta_marcada);
            }
            return lista_resposta_marcada;
        }catch(SQLException e){
            System.out.println("Erro na recuperação das respostas dos questionários!");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
}
