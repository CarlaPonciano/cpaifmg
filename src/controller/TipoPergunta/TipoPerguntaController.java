/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.TipoPergunta;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import model.DAO.TipoPergunta.TipoPerguntaDAO;
import model.Domain.TipoPergunta.TipoPerguntaDomain;
import model.Domain.TipoResposta.TipoRespostaDomain;

/**
 *
 * @author amanda
 */
@ManagedBean(value = "tipoPerguntaController")
@SessionScoped
public class TipoPerguntaController implements Serializable{
   TipoPerguntaDomain tp;
   public List<TipoPerguntaDomain> recuperarTipoPergunta() throws SQLException{
        TipoPerguntaDAO tipo_pergunta_dao = new TipoPerguntaDAO();
        TipoPerguntaDomain tipo_pergunta;
        
        List<TipoPerguntaDomain> lista_tipo_pergunta = new ArrayList();
        ResultSet rs =  tipo_pergunta_dao.recuperarTipoPergunta();
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
    } 
}
