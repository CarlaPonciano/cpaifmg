/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.RespostaQuestionario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.DAO.Pergunta.PerguntaDAO;
import model.Domain.Pergunta.PerguntaDomain;
import model.Domain.Resposta.RespostaDomain;

import model.Domain.RespostaQuestionario.RespostaQuestionarioDomain;
import model.DAO.Resposta.RespostaDAO;
import model.DAO.RespostaMarcada.RespostaMarcadaDAO;
import model.DAO.RespostaQuestionarioDAO.RespostaQuestionarioDAO;
import model.Domain.RespostaQuestionario.RespostaMarcada;

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
    private List<RespostaMarcada> lista_resposta_marcada = new ArrayList();
    private int idRespostaSelecionada;

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
    
    public int getIdRespostaSelecionada() {
        return idRespostaSelecionada;
    }

    public void setIdRespostaSelecionada(int idRespostaSelecionada) {
        this.idRespostaSelecionada = idRespostaSelecionada;
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
        RespostaMarcadaDAO resposta_marcada_dao = new RespostaMarcadaDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        int index = resposta_questionario_dao.cadastrarResposta(resposta_questionario);
        if(resposta_marcada_dao.cadastrarListaResposta(lista_resposta_marcada, index)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questionário respondido com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("responderQuestionarioRedirecionamento.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro no cadastro da resposta do questionário!"));
        }
    }
    
    public void respondeuQuestao(int idPergunta){
        RespostaMarcada resposta_marcada = new RespostaMarcada();
        
        resposta_marcada.setRespostaquestionario_id(resposta_questionario.getQuestionario_id());
        resposta_marcada.setId_pergunta(idPergunta);
        resposta_marcada.setId_resposta(this.getIdRespostaSelecionada());
        
        boolean flag = true;
        if(!lista_resposta_marcada.isEmpty()){
            for(RespostaMarcada lista : lista_resposta_marcada){
                if(lista.getId_pergunta() == idPergunta){
                    lista.setId_resposta(this.getIdRespostaSelecionada());
                    flag = false;
                }
            }
        }else{
            lista_resposta_marcada.add(resposta_marcada);
            flag = false;
        }
        if(flag) lista_resposta_marcada.add(resposta_marcada);
    }
    
}
