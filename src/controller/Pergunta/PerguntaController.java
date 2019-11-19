/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Pergunta;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import model.DAO.Pergunta.PerguntaDAO;
import model.Domain.Pergunta.PerguntaDomain;
import model.Domain.TipoPergunta.TipoPerguntaDomain;

/**
 *
 * @author amanda
 */
@ManagedBean(value = "tipoPerguntaController")
@SessionScoped
public class PerguntaController implements Serializable{
    PerguntaDomain pergunta;
    public boolean cadastrarPergunta(){
        PerguntaDAO pergunta_dao = new PerguntaDAO();
        return pergunta_dao.cadastrarPergunta(pergunta);
    }
    
    public List<PerguntaDomain> recuperarPerguntas() throws SQLException{
        PerguntaDAO pergunta_dao = new PerguntaDAO();
        PerguntaDomain pergunta;
        TipoPerguntaDomain tipo_pergunta;
        List<PerguntaDomain> lista_pergunta = new ArrayList();
        
        ResultSet rs =  pergunta_dao.recuperarPerguntas();
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
    }
}
