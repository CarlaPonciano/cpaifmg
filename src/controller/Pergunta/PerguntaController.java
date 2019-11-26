/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Pergunta;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import model.DAO.Pergunta.PerguntaDAO;
import model.Domain.Pergunta.PerguntaDomain;

/**
 *
 * @author amanda
 */
@javax.faces.bean.ManagedBean(name = "perguntaController")
@javax.faces.bean.SessionScoped
public class PerguntaController implements Serializable{
    PerguntaDomain pergunta;
    public boolean cadastrarPergunta(){
        PerguntaDAO pergunta_dao = new PerguntaDAO();
        return pergunta_dao.cadastrarPergunta(pergunta);
    }
    
    public List<PerguntaDomain> recuperarPerguntas() throws SQLException{
        PerguntaDAO pergunta_dao = new PerguntaDAO();
        
        List<PerguntaDomain> lista_pergunta = pergunta_dao.recuperarPerguntas();
        return lista_pergunta;
    }
}
