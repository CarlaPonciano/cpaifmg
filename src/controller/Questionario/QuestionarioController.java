/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Questionario;

import java.io.IOException;
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
    private static List<QuestionarioDomain> lista_questionario = new ArrayList();
    private int id_questionario_editar;

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

    static void setLista_questionario(List<QuestionarioDomain> set_lista_questionario) {
        lista_questionario = set_lista_questionario;
    }

    public int getId_questionario_editar() {
        return id_questionario_editar;
    }

    public void setId_questionario_editar(int id_questionario_editar) {
        this.id_questionario_editar = id_questionario_editar;
    }
    
    public void cadastrarQuestionario() throws IOException, InterruptedException{
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(questionario_dao.cadastrarQuestionario(questionario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questionário cadastrado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro no cadastro do questionário!"));
        }
        recuperarQuestionarios();
    }
    
    public void excluirQuestionario(int id) throws IOException{
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(questionario_dao.excluirQuestionario(id)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questionário excluído com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na exclusão do questionário!"));
        }
        recuperarQuestionarios();
    }
    
    public void atualizarQuestionario() throws IOException{
        questionario.setId(id_questionario_editar);
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(questionario_dao.atualizarQuestionario(questionario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questionário atualizado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na atualização do questionário!"));
        }
        recuperarQuestionarios();
    }
    
    public static List<QuestionarioDomain> recuperarQuestionarios(){
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        setLista_questionario(questionario_dao.recuperarQuestionarios());
        return lista_questionario;
    }
}
