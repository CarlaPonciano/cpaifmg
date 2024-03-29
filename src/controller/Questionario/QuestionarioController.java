/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Questionario;

import controller.Usuario.UsuarioController;
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
    private static List<QuestionarioDomain> lista_questionario_ativo = new ArrayList();
    private int id_questionario_editar;

    public QuestionarioController() {
        questionario = new QuestionarioDomain();
        if(UsuarioController.getSessao() != null){
            recuperarQuestionariosUsuario();
            recuperarQuestionariosAtivos();
        }else{
            recuperarQuestionarios();
        }
        
    }

    public QuestionarioDomain getQuestionario() {
        return questionario;
    }

    public void setQuestionario(QuestionarioDomain questionario) {
        this.questionario = questionario;
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

    public static List<QuestionarioDomain> getLista_questionario_ativo() {
        return lista_questionario_ativo;
    }

    public static void setLista_questionario_ativo(List<QuestionarioDomain> lista_questionario_ativo) {
        QuestionarioController.lista_questionario_ativo = lista_questionario_ativo;
    }
    
    public void cadastrarQuestionario() throws IOException, InterruptedException{
        questionario.setCriador(UsuarioController.recuperarSessaoNomeUsuario());
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(questionario_dao.cadastrarQuestionario(questionario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questionário cadastrado com sucesso!"));
            recuperarQuestionariosUsuario();
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro no cadastro do questionário!"));
        }
    }
    
    public void excluirQuestionario(int id) throws IOException{
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(questionario_dao.excluirQuestionario(id)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questionário excluído com sucesso!"));
            recuperarQuestionariosUsuario();
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na exclusão do questionário!"));
        }
    }
    
    public void atualizarQuestionario() throws IOException{
        questionario.setId(id_questionario_editar);
        questionario.setCriador(UsuarioController.recuperarSessaoNomeUsuario());
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(questionario_dao.atualizarQuestionario(questionario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Questionário atualizado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na atualização do questionário!"));
        }
        recuperarQuestionariosUsuario();
    }
    
    public static List<QuestionarioDomain> recuperarQuestionariosUsuario(){
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        setLista_questionario(questionario_dao.recuperarQuestionariosUsuario());
        return lista_questionario;
    }
    
    public static List<QuestionarioDomain> recuperarQuestionarios(){
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        setLista_questionario(questionario_dao.recuperarQuestionarios());
        return lista_questionario;
    }
    
    public static List<QuestionarioDomain> recuperarQuestionariosAtivos(){
        QuestionarioDAO questionario_dao = new QuestionarioDAO();
        setLista_questionario_ativo(questionario_dao.recuperarQuestionariosAtivos());
        return lista_questionario_ativo;
    }
}
