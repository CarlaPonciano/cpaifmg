/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.TipoPergunta;

import java.util.ArrayList;
import java.util.List;
import model.DAO.TipoPergunta.TipoPerguntaDAO;
import model.Domain.TipoPergunta.TipoPerguntaDomain;

/**
 *
 * @author amanda
 */
@javax.faces.bean.ManagedBean(name = "tipoPerguntaController")
@javax.faces.bean.SessionScoped
public class TipoPerguntaController{
    private List<TipoPerguntaDomain> lista_tipo_pergunta = new ArrayList();

    public TipoPerguntaController() {
        recuperarTipoPergunta();
    }

    public List<TipoPerguntaDomain> getLista_tipo_pergunta() {
        return lista_tipo_pergunta;
    }

    public void setLista_tipo_pergunta(List<TipoPerguntaDomain> lista_tipo_pergunta) {
        this.lista_tipo_pergunta = lista_tipo_pergunta;
    }
    
    public List<TipoPerguntaDomain> recuperarTipoPergunta(){
        TipoPerguntaDAO tipo_pergunta_dao = new TipoPerguntaDAO();
        setLista_tipo_pergunta(tipo_pergunta_dao.recuperarTipoPergunta());
        return lista_tipo_pergunta;
    } 
   
}
