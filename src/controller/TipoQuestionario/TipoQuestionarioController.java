/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.TipoQuestionario;

import controller.Questionario.QuestionarioController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.DAO.TipoQuestionario.TipoQuestionarioDAO;
import model.Domain.TipoQuestionario.TipoQuestionarioDomain;

/**
 *
 * @author carli
 */
@ManagedBean(name = "tipoQuestionarioController")
@SessionScoped
public class TipoQuestionarioController {
    private List<TipoQuestionarioDomain> lista_tipo_questionario = new ArrayList();
    private TipoQuestionarioDomain tipo_questionario = new TipoQuestionarioDomain();
    private int id_tipo_questionario_editar;
    
    public TipoQuestionarioController() {
        recuperarTipoQuestionario();
    }
    
    public List<TipoQuestionarioDomain> recuperarTipoQuestionario(){
        TipoQuestionarioDAO tipo_questionario_dao = new TipoQuestionarioDAO();
        setLista_tipo_questionario(tipo_questionario_dao.recuperarTipoQuestionario());
        return lista_tipo_questionario;
    }

    public List<TipoQuestionarioDomain> getLista_tipo_questionario() {
        return lista_tipo_questionario;
    }

    public void setLista_tipo_questionario(List<TipoQuestionarioDomain> lista_tipo_questionario) {
        this.lista_tipo_questionario = lista_tipo_questionario;
    }

    public TipoQuestionarioDomain getTipo_questionario() {
        return tipo_questionario;
    }

    public void setTipo_questionario(TipoQuestionarioDomain tipo_questionario) {
        this.tipo_questionario = tipo_questionario;
    }

    public int getId_tipo_questionario_editar() {
        return id_tipo_questionario_editar;
    }

    public void setId_tipo_questionario_editar(int id_tipo_questionario_editar) {
        this.id_tipo_questionario_editar = id_tipo_questionario_editar;
    }

    public void cadastrarTipoQuestionario() throws IOException, InterruptedException{
        TipoQuestionarioDAO tipo_questionario_dao = new TipoQuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(tipo_questionario_dao.cadastrarTipoQuestionario(tipo_questionario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Tipo questionário cadastrado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro no cadastro do tipo do questionário!"));
        }
        recuperarTipoQuestionario();
    }
    
    public void excluirQuestionario(int id) throws IOException{
        TipoQuestionarioDAO tipo_questionario_dao = new TipoQuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(tipo_questionario_dao.excluirTipoQuestionario(id)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Tipo do questionário excluído com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na exclusão do tipo do questionário!"));
        }
        recuperarTipoQuestionario();
    }
    
    public void atualizarTipoQuestionario() throws IOException{
        tipo_questionario.setId(id_tipo_questionario_editar);
        TipoQuestionarioDAO tipo_questionario_dao = new TipoQuestionarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(tipo_questionario_dao.atualizarTipoQuestionario(tipo_questionario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Tipo do questionário atualizado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicial.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na atualização do tipo do questionário!"));
        }
        recuperarTipoQuestionario();
        QuestionarioController.recuperarQuestionarios();
    }
}
