/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.Usuario;

import controller.Usuario.UsuarioController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Connection.ConnectionPostgreSQL;
import model.Domain.Usuario.UsuarioDomain;

/**
 *
 * @author carli
 */
public class UsuarioDAO {
    public boolean persistirUsuario(UsuarioDomain usuario){
        
        String sqlValidacao = "SELECT * FROM usuario"
                +       " WHERE usuario = '" + usuario.getUsuario() + "' "
                +       " OR email = '" + usuario.getEmail() + "';";
        try {
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stmValidacao = con.createStatement();
            ResultSet rs = stmValidacao.executeQuery(sqlValidacao);
            if (rs.next()) {
                System.out.println("ERRO: J� existe um usu�rio cadastrado com o nome de usu�rio e/ou o e-mail informados.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao validar o usu�rio!");
            System.out.println(e.getMessage());
            return false;
        }
        
        String sql = "INSERT INTO usuario(nome, sobrenome, email, usuario, senha, ativo) VALUES "
                        + "('" + usuario.getNome() + "', '" + usuario.getSobrenome() + "', '"
                        + usuario.getEmail() + "', '" + usuario.getUsuario() + "', '" + usuario.getSenha() + "', 1);";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro no cadastro do usu�rio!");
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public boolean atualizarUsuario(UsuarioDomain usuario){
        String sqlValidacao = "SELECT * FROM usuario"
                            + " WHERE email = '" + usuario.getEmail() + "';";
        try {
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stmValidacao = con.createStatement();
            ResultSet rs = stmValidacao.executeQuery(sqlValidacao);
            if (rs.next()) {
                System.out.println("ERRO: J� existe um usu�rio cadastrado com o e-mail informado.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao validar o usu�rio!");
            System.out.println(e.getMessage());
            return false;
        }
        
        String sql = "UPDATE usuario"
                    + " SET nome = '" + usuario.getNome() + "', sobrenome = '" + usuario.getSobrenome() + "', email = '" + usuario.getEmail() + "', senha = '" + usuario.getSenha() + "'"
                    + " WHERE usuario = '" + UsuarioController.recuperarSessaoNomeUsuario() + "';";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro no atualizar o usu�rio!");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public UsuarioDomain recuperarUsuario(UsuarioDomain usuario){
        String sql = "SELECT * FROM usuario"
                    + " WHERE usuario = '" + usuario.getUsuario() + "';";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                String nome = rs.getString("nome");
                usuario.setNome(nome);
                String sobrenome = rs.getString("sobrenome");
                usuario.setSobrenome(sobrenome);
                String email = rs.getString("email");
                usuario.setEmail(email);
                String senha = rs.getString("senha");
                usuario.setSenha(senha);
                int ativo = rs.getInt("ativo");
                usuario.setAtivo(ativo);
                return usuario;
            }
        }catch(SQLException e){
            System.out.println("Erro na recupera��o do usu�rio!");
            System.out.println(e.getMessage());
            return null;
        }
        return usuario;
    }
    
    public boolean inativarUsuario(UsuarioDomain usuario){
        String sql = "UPDATE usuario"
                    + " SET ativo = 0"
                    + " WHERE usuario = '" + usuario.getUsuario() + "';";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao inativar o usu�rio!");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean ativarUsuario(UsuarioDomain usuario){
        String sql = "UPDATE usuario"
                    + " SET ativo = 1"
                    + " WHERE usuario = '" + usuario.getUsuario() + "';";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao ativar o usu�rio!");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public UsuarioDomain login(UsuarioDomain usuario){
        String sql = "SELECT * FROM usuario"
                    + " WHERE usuario = '" + usuario.getUsuario() + "'"
                    + " AND senha = '" + usuario.getSenha() + "' AND ativo = 1;";
        try {
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setEmail(rs.getString("email"));
                return usuario;
            }else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fazer login!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
