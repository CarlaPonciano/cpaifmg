/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.Disciplina;

import model.Connection.ConnectionPostgreSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Domain.Disciplina.DisciplinaDomain;

/**
 *
 * @author carli
 */
public class DisciplinaDAO {
    public boolean cadastrarDisciplina(DisciplinaDomain disciplina){
        String sql = "INSERT INTO disciplina(disciplina, curso_id, periodo) VALUES ('" + disciplina.getDisciplina() + "', " 
                        + disciplina.getCurso_id() + ", " + disciplina.getPeriodo() + ");";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro no cadastro da disciplina!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return false;
        }
    }
}
