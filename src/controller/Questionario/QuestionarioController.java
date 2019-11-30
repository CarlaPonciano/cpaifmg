/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Questionario;

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

    public QuestionarioController() {
        questionario = new QuestionarioDomain();
    }
    
    public void setQuestionario(QuestionarioDomain questionario) {
        this.questionario = questionario;
    }
    
    public QuestionarioDomain getQuestionario() {
        return questionario;
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
}
