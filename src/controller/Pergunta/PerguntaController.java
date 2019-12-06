/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Pergunta;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    public void cadastrarPergunta() throws IOException{
        PerguntaDAO pergunta_dao = new PerguntaDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if (pergunta_dao.cadastrarPergunta(pergunta)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questão cadastrada com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro ao cadastrar questão!"));
        }
    }
    
    public List<PerguntaDomain> recuperarPerguntas() throws SQLException{
        PerguntaDAO pergunta_dao = new PerguntaDAO();
        
        List<PerguntaDomain> lista_pergunta = pergunta_dao.recuperarPerguntas();
        return lista_pergunta;
    }
}
