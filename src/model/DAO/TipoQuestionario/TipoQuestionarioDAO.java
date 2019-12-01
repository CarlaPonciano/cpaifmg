/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.TipoQuestionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;
import model.Domain.TipoPergunta.TipoPerguntaDomain;
import model.Domain.TipoQuestionario.TipoQuestionarioDomain;

/**
 *
 * @author carli
 */
public class TipoQuestionarioDAO {
    
    public boolean cadastrarTipoQuestionario(TipoQuestionarioDomain tipo_questionario){
        String sql = "INSERT INTO tipoquestionario(nome, descricao, tipopergunta_id) VALUES "
                        + "('" + tipo_questionario.getNome() + "', '" + tipo_questionario.getDescricao() + "', "
                        + tipo_questionario.getTipo_pergunta_id() + ");";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro no cadastro do tipo do questionário!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<TipoQuestionarioDomain> recuperarTipoQuestionario(){
        String sql = "SELECT * FROM tipoQuestionario;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            TipoQuestionarioDomain tipo_questionario;
            List<TipoQuestionarioDomain> lista_tipo_questionario = new ArrayList();
            while(rs.next()){
                tipo_questionario = new TipoQuestionarioDomain();
                tipo_questionario.setId(rs.getInt("id"));
                tipo_questionario.setNome(rs.getString("nome"));
                tipo_questionario.setDescricao(rs.getString("descricao"));
                tipo_questionario.setTipo_pergunta(new TipoPerguntaDomain(rs.getInt("TipoPergunta_id")));
                System.out.println(tipo_questionario);
                lista_tipo_questionario.add(tipo_questionario);
            }
            return lista_tipo_questionario;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos tipos de questionários!");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
