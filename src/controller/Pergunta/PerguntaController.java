/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Pergunta;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.DAO.Pergunta.PerguntaDAO;
import model.Domain.Pergunta.PerguntaDomain;

/**
 *
 * @author amanda
 */
@ManagedBean(name = "perguntaController")
@SessionScoped
public class PerguntaController implements Serializable{
    PerguntaDomain pergunta;

    public PerguntaController(){
        pergunta = new PerguntaDomain();
        recuperarPerguntas();
    }

    public PerguntaDomain getPergunta() {
        return pergunta;
    }

    public void setPergunta(PerguntaDomain pergunta) {
        this.pergunta = pergunta;
    }
    
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
    
    public List<PerguntaDomain> recuperarPerguntas(){
        PerguntaDAO pergunta_dao = new PerguntaDAO();
        
        List<PerguntaDomain> lista_pergunta = pergunta_dao.recuperarPerguntas();
        return lista_pergunta;
    }
}
