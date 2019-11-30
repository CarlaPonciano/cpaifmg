/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.Questionario;

import model.Domain.Questionario.QuestionarioDomain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;

/**
 *
 * @author carli
 */
public class QuestionarioDAO {
    public boolean cadastrarQuestionario(QuestionarioDomain questionario){
        String sql = "INSERT INTO questionario(nome, descricao, Usuario_usuario, TipoQuestionario_id) VALUES "
                        + "('" + questionario.getNome() + "', '" + questionario.getDescricao() + "', '"
                        + questionario.getCriador() + "', " + questionario.getId_tipo_questionario() + ");";
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
    
    public boolean atualizarQuestionario(QuestionarioDomain questionario){
        String sql = "UPDATE questionario SET (nome, descricao, Usuario_usuario, TipoQuestionario_id) =  "
                        + "('" + questionario.getNome() + "', '" + questionario.getDescricao() + "', '"
                        + questionario.getCriador() + "', " + questionario.getId_tipo_questionario() + ") WHERE id = " + questionario.getId() + ";";
        System.out.println(sql);
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro na atualização do questionário!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean excluirQuestionario(int id){
        String sql = "DELETE FROM questionario WHERE id = " + id + ";";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro na exclusão do questionário!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<QuestionarioDomain> recuperarQuestionarios(){
        String sql = "SELECT * FROM questionario_tipoquestionario;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            QuestionarioDomain questionario;
            List<QuestionarioDomain> lista_questionario = new ArrayList();
            while(rs.next()){
                questionario = new QuestionarioDomain();
                questionario.setId(rs.getInt("id"));
                questionario.setNome(rs.getString("nome"));
                questionario.setDescricao(rs.getString("descricao"));
                questionario.setCriador(rs.getString("usuario_usuario"));
                questionario.setTipo_questionario(rs.getString("tipo_questionario"));
                lista_questionario.add(questionario);
            }
            return lista_questionario;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos questionários!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
