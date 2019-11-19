/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.Curso;

import model.Connection.ConnectionPostgreSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Domain.Curso.CursoDomain;

/**
 *
 * @author carli
 */
public class CursoDAO {
    public boolean cadastrarCurso(CursoDomain curso){
        String sql = "INSERT INTO curso(curso, campus_id) VALUES ('" + curso.getCurso() + "', " 
                        + curso.getCampus_id() + ");";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro no cadastro do curso!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet recuperarCurso(){
        String sql = "SELECT * FROM curso;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            return rs;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos cursos cadastrados!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
