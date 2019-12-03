/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.Resposta;

import model.Domain.Pergunta.PerguntaDomain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;
import model.Domain.Resposta.RespostaDomain;
import model.Domain.TipoPergunta.TipoPerguntaDomain;

/**
 *
 * @author amanda
 */
public class RespostaDAO {
    public List<PerguntaDomain> recuperarRespostas(){
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
    
    public List<RespostaDomain> recuperarRespostasQuestionario(int tipo_questionario_id){
        String sql = "select distinct resposta_id, resposta from tipoquestionario_tipopergunta_tiporesposta_pergunta_resposta "
                + "where tipo_questionario_id = " + tipo_questionario_id + " order by resposta_id;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            RespostaDomain resposta;
            List<RespostaDomain> lista_resposta = new ArrayList();
            while(rs.next()){
                resposta = new RespostaDomain();
                resposta.setId(rs.getInt("resposta_id"));
                resposta.setResposta(rs.getString("resposta"));
                lista_resposta.add(resposta);
            }
            return lista_resposta;
        }catch(SQLException e){
            System.out.println("Erro na recuperaÁ„o das respostas do question·rio!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
