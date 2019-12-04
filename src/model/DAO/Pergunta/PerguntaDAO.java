/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.Pergunta;

import model.Domain.Pergunta.PerguntaDomain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;
import model.Domain.TipoPergunta.TipoPerguntaDomain;

/**
 *
 * @author amanda
 */
public class PerguntaDAO {
    public boolean cadastrarPergunta(PerguntaDomain pergunta){
        String sql = "INSERT INTO pergunta (pergunta, tipopergunta_id) VALUES "
                        + "('" + pergunta.getPergunta() + "', " + pergunta.getTipoPergunta().getId() + ");";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro no cadastro da quest√£o!");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<PerguntaDomain> recuperarPerguntas(){
        String sql = "SELECT P.id AS P_id, P.pergunta, TP.id AS TP_id, TP.tipo FROM pergunta AS P, tipopergunta AS TP"
                    + " WHERE P.tipoPergunta_id = TP.id;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            PerguntaDomain pergunta;
            TipoPerguntaDomain tipo_pergunta;
            List<PerguntaDomain> lista_pergunta = new ArrayList();
            while(rs.next()){
                pergunta = new PerguntaDomain();
                pergunta.setId(rs.getInt("P_id"));
                pergunta.setPergunta(rs.getString("pergunta"));

                tipo_pergunta = new TipoPerguntaDomain();
                tipo_pergunta.setId(rs.getInt("TP_id"));
                tipo_pergunta.setTipo(rs.getString("tipo"));

                pergunta.setTipoPergunta(tipo_pergunta);
                lista_pergunta.add(pergunta);
            }
            return lista_pergunta;
        }catch(SQLException e){
            System.out.println("Erro na recupera√ß√£o das quest√µes!");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<PerguntaDomain> recuperarPerguntasQuestionario(int tipo_questionario_id){
        String sql = "select distinct pergunta_id, pergunta from tipoquestionario_tipopergunta_tiporesposta_pergunta_resposta "
                + "where tipo_questionario_id = " + tipo_questionario_id + ";";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            PerguntaDomain pergunta;
            TipoPerguntaDomain tipo_pergunta;
            List<PerguntaDomain> lista_pergunta = new ArrayList();
            while(rs.next()){
                pergunta = new PerguntaDomain();
                pergunta.setId(rs.getInt("pergunta_id"));
                pergunta.setPergunta(rs.getString("pergunta"));
                lista_pergunta.add(pergunta);
            }
            return lista_pergunta;
        }catch(SQLException e){
            System.out.println("Erro na recuperaÁ„o das perguntas do question·rio!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
