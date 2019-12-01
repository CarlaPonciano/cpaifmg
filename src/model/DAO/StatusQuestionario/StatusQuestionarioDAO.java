/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.StatusQuestionario;

import model.Domain.Questionario.QuestionarioDomain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;
import model.Domain.StatusQuestionario.StatusQuestionarioDomain;

/**
 *
 * @author carli
 */
public class StatusQuestionarioDAO {
    
    public List<StatusQuestionarioDomain> recuperarStatusQuestionario(){
        String sql = "SELECT * FROM statusquestionario;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            StatusQuestionarioDomain status_questionaio;
            List<StatusQuestionarioDomain> lista_status_questionario = new ArrayList();
            while(rs.next()){
                status_questionaio = new StatusQuestionarioDomain();
                status_questionaio.setId(rs.getInt("id"));
                status_questionaio.setStatus(rs.getString("status"));
                lista_status_questionario.add(status_questionaio);
            }
            return lista_status_questionario;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos status dos questionários!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
