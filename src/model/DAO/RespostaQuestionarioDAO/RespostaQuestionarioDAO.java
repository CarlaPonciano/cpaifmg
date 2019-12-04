/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.RespostaQuestionarioDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;
import model.Domain.RespostaQuestionario.RespostaMarcada;
import model.Domain.RespostaQuestionario.RespostaQuestionarioDomain;

/**
 *
 * @author carli
 */
public class RespostaQuestionarioDAO {
    
    public int cadastrarResposta(RespostaQuestionarioDomain resposta_questionario){
        String sql = "INSERT INTO respostaquestionario(semestremarcado, questionario_id, campus_id, disciplina_id, curso_id, observacoes) VALUES "
                        + "(" + resposta_questionario.getSemestre_marcado()+ ", " + resposta_questionario.getQuestionario_id()+ ", "
                        + resposta_questionario.getId_opcao_campus()+ ", " + resposta_questionario.getId_opcao_disciplina()+ ", " + resposta_questionario.getId_opcao_curso() + ""
                + ", '" + resposta_questionario.getObservacoes() + "') returning id;";
        try{
            int id = 0;
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(sql);
            if(resultado.next()){
                id = resultado.getInt("id");
            }
            return id;
        }catch(SQLException e){
            System.out.println("Erro no cadastro da resposta do questionário questionário!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    
}
