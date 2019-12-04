/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.RespostaQuestionario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import model.DAO.Pergunta.PerguntaDAO;
import model.Domain.Pergunta.PerguntaDomain;
import model.Domain.Resposta.RespostaDomain;

import model.Domain.RespostaQuestionario.RespostaQuestionarioDomain;
import model.DAO.Resposta.RespostaDAO;
import model.DAO.RespostaQuestionarioDAO.RespostaQuestionarioDAO;

/**
 *
 * @author carli
 */
@ManagedBean(name = "respostaQuestionarioController")
@SessionScoped
public class RespostaQuestionarioController{
    public RespostaQuestionarioDomain resposta_questionario;
    private List<PerguntaDomain> lista_pergunta = new ArrayList();
    private List<RespostaDomain> lista_resposta = new ArrayList();
    private int idRespostaSelecionada;
    private int idPerguntaSelecionada;

    public RespostaQuestionarioController() {
        resposta_questionario = new RespostaQuestionarioDomain();
        recuperarPerguntas();
        recuperarRespostas();
    }

    public RespostaQuestionarioDomain getResposta_questionario() {
        return resposta_questionario;
    }

    public void setResposta_questionario(RespostaQuestionarioDomain resposta_questionario) {
        this.resposta_questionario = resposta_questionario;
    }

    public List<PerguntaDomain> getLista_pergunta() {
        return lista_pergunta;
    }

    public void setLista_pergunta(List<PerguntaDomain> lista_pergunta) {
        this.lista_pergunta = lista_pergunta;
    }

    public List<RespostaDomain> getLista_resposta() {
        return lista_resposta;
    }

    public void setLista_resposta(List<RespostaDomain> lista_resposta) {
        this.lista_resposta = lista_resposta;
    }
    
    public List<PerguntaDomain> recuperarPerguntas(){
        PerguntaDAO pergunta_dao = new PerguntaDAO();
        setLista_pergunta(pergunta_dao.recuperarPerguntasQuestionario(1));
        return lista_pergunta;
    }
    
    public List<RespostaDomain> recuperarRespostas(){
        RespostaDAO resposta_dao = new RespostaDAO();
        setLista_resposta(resposta_dao.recuperarRespostasQuestionario(1));
        return lista_resposta;
    }
    
    public void cadastrarResposta() throws IOException, InterruptedException{
        RespostaQuestionarioDAO resposta_questionario_dao = new RespostaQuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(resposta_questionario_dao.cadastrarResposta(resposta_questionario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questionário respondido com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("responderQuestionarioRedirecionamento.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro no cadastro da resposta do questionário!"));
        }
    }
    
    public void respondeuQuestao(int idPergunta){
        System.out.println("Pergunta: "+idPergunta + " resposta: "+this.getIdRespostaSelecionada());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Pergunta: "+idPergunta + " resposta: "+this.getIdRespostaSelecionada()));
    }

    public int getIdRespostaSelecionada() {
        return idRespostaSelecionada;
    }

    public void setIdRespostaSelecionada(int idRespostaSelecionada) {
        this.idRespostaSelecionada = idRespostaSelecionada;
    }

    public int getIdPerguntaSelecionada() {
        return idPerguntaSelecionada;
    }

    public void setIdPerguntaSelecionada(int idPerguntaSelecionada) {
        this.idPerguntaSelecionada = idPerguntaSelecionada;
    }
    
}
