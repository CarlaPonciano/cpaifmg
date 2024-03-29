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
import java.util.ArrayList;
import java.util.List;
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
    
    public boolean atualizarCurso(CursoDomain curso){
        String sql = "UPDATE curso SET (curso, campus_id) =  "
                        + "('" + curso.getCurso()+ "', " + curso.getCampus_id() + ") WHERE id = " + curso.getId() + ";";
        System.out.println(sql);
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro na atualização do curso!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean excluirCurso(int id){
        String sql = "DELETE FROM curso WHERE id = " + id + ";";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro na exclusão do curso!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<CursoDomain> recuperarCurso(){
        String sql = "SELECT * FROM curso_campus;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            CursoDomain curso;
            List<CursoDomain> lista_curso = new ArrayList();
            while (rs.next()) {
                    curso = new CursoDomain();
                    curso.setId(rs.getInt("id"));
                    curso.setCurso(rs.getString("curso"));
                    curso.setCampus(rs.getString("campus"));
                    lista_curso.add(curso);
            }
            return lista_curso;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos cursos cadastrados!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
