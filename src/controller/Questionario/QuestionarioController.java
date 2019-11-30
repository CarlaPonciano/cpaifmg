/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Questionario;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.DAO.Questionario.QuestionarioDAO;
import model.Domain.Questionario.QuestionarioDomain;

/**
 *
 * @author carli
 */
@ManagedBean(name = "questionarioController")
@SessionScoped
public class QuestionarioController {
    private QuestionarioDomain questionario;
    private List<QuestionarioDomain> lista_questionario = new ArrayList();

    public QuestionarioController() {
        questionario = new QuestionarioDomain();
        recuperarQuestionarios();
    }
    
    public void setQuestionario(QuestionarioDomain questionario) {
        this.questionario = questionario;
    }
    
    public QuestionarioDomain getQuestionario() {
        return questionario;
    }

    public List<QuestionarioDomain> getLista_questionario() {
        return lista_questionario;
    }

    public void setLista_questionario(List<QuestionarioDomain> lista_questionario) {
        this.lista_questionario = lista_questionario;
    }
    
    public void cadastrarQuestionario(){
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(questionario_dao.cadastrarQuestionario(questionario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questionário cadastrado com sucesso!"));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro no cadastro do questionário!"));
        }
    }
    
    public List<QuestionarioDomain> recuperarQuestionarios(){
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        setLista_questionario(questionario_dao.recuperarQuestionarios());
        return lista_questionario;
    }
}
