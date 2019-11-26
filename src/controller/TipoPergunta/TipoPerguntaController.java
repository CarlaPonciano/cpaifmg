/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.TipoPergunta;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import model.DAO.TipoPergunta.TipoPerguntaDAO;
import model.Domain.TipoPergunta.TipoPerguntaDomain;

/**
 *
 * @author amanda
 */
@javax.faces.bean.ManagedBean(name = "tipoPerguntaController")
@javax.faces.bean.SessionScoped
public class TipoPerguntaController implements Serializable{
    
   public List<TipoPerguntaDomain> recuperarTipoPergunta() throws SQLException{
        TipoPerguntaDAO tipo_pergunta_dao = new TipoPerguntaDAO();
        List<TipoPerguntaDomain> lista_tipo_pergunta = tipo_pergunta_dao.recuperarTipoPergunta();
        return lista_tipo_pergunta;
    } 
   
}
