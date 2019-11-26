/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.TipoPergunta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;
import model.Domain.TipoPergunta.TipoPerguntaDomain;
import model.Domain.TipoResposta.TipoRespostaDomain;

/**
 *
 * @author amanda
 */
public class TipoPerguntaDAO {
    public List<TipoPerguntaDomain> recuperarTipoPergunta(){
        String sql = "SELECT * FROM tipopergunta;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            TipoPerguntaDomain tipo_pergunta;
            List<TipoPerguntaDomain> lista_tipo_pergunta = new ArrayList();
            while(rs.next()){
                tipo_pergunta = new TipoPerguntaDomain();
                tipo_pergunta.setId(rs.getInt("id"));
                tipo_pergunta.setTipo(rs.getString("tipo"));

                TipoRespostaDomain tipo_resposta = new TipoRespostaDomain();
                tipo_resposta.setId(rs.getInt("TipoResposta_id"));

                tipo_pergunta.setTipo_resposta(tipo_resposta);
                lista_tipo_pergunta.add(tipo_pergunta);
            }
            return lista_tipo_pergunta;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos tipos de perguntas!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
