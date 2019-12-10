/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.Questionario;

import controller.Usuario.UsuarioController;
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
        String sql = "INSERT INTO questionario(nome, descricao, Usuario_usuario, TipoQuestionario_id, status_id) VALUES "
                        + "('" + questionario.getNome() + "', '" + questionario.getDescricao() + "', '"
                        + questionario.getCriador() + "', " + questionario.getId_tipo_questionario() + ", 1);";
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
        String sql = "UPDATE questionario SET (nome, descricao, Usuario_usuario, TipoQuestionario_id, status_id) =  "
                        + "('" + questionario.getNome() + "', '" + questionario.getDescricao() + "', '"
                        + questionario.getCriador() + "', " + questionario.getId_tipo_questionario() + ", " + questionario.getStatus_id() + ") WHERE id = " + questionario.getId() + ";";
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
        List<String> id_resposta = new ArrayList();
        String sql = "SELECT id FROM respostaquestionario WHERE questionario_id = " + id + ";";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                String sql2 = "DELETE FROM listarespostamarcada where respostaquestionario_id =  " + rs.getInt("id") + ";";
                id_resposta.add(sql2);
                String sql3 = "DELETE FROM respostaquestionario where id =  " + rs.getInt("id") + ";";
                id_resposta.add(sql3);
            }
            for(String lista : id_resposta){
                try{
                    stm.executeUpdate(lista);
                }catch(SQLException e){
                    System.out.println("Erro na exclusão das respostas do questionário!");
                    System.out.println(e.getMessage());
                }
            }
            String sql3 = "DELETE FROM questionario WHERE id = " + id + ";";
            stm.executeUpdate(sql3);
            return true;
        }catch(SQLException e){
            System.out.println("Erro na exclusão do questionário!");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<QuestionarioDomain> recuperarQuestionariosUsuario(){
        String sql = "SELECT * FROM questionario_tipoquestionario_status_quantrespostas WHERE usuario_usuario = '" + UsuarioController.recuperarSessaoNomeUsuario() + "';";
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
                questionario.setStatus(rs.getString("status"));
                questionario.setQuant_respostas(rs.getInt("quant_respostas"));
                lista_questionario.add(questionario);
            }
            return lista_questionario;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos questionários!");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<QuestionarioDomain> recuperarQuestionarios(){
        String sql = "SELECT * FROM questionario_tipoquestionario_status_quantrespostas;";
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
                questionario.setTipo_questionario(rs.getString("tipo_questionario"));
                questionario.setStatus(rs.getString("status"));
                questionario.setQuant_respostas(rs.getInt("quant_respostas"));
                lista_questionario.add(questionario);
            }
            return lista_questionario;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos questionários!");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<QuestionarioDomain> recuperarQuestionariosAtivos(){
        String sql = "SELECT * FROM questionario_tipoquestionario_status_quantrespostas WHERE status = 'Ativo';";
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
                questionario.setStatus(rs.getString("status"));
                lista_questionario.add(questionario);
            }
            return lista_questionario;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos questionários ativos!");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
}
