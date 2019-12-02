/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Disciplina;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.DAO.Disciplina.DisciplinaDAO;
import model.Domain.Disciplina.DisciplinaDomain;

/**
 *
 * @author carli
 */
@ManagedBean(name = "disciplinaController")
@SessionScoped
public class DisciplinaController {
    DisciplinaDomain disciplina = new DisciplinaDomain();
    private List<DisciplinaDomain> lista_disciplina = new ArrayList();
    
    public DisciplinaController() {
        recuperarDisciplinas();
    }

    public DisciplinaDomain getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaDomain disciplina) {
        this.disciplina = disciplina;
    }

    public List<DisciplinaDomain> getLista_disciplina() {
        return lista_disciplina;
    }

    public void setLista_disciplina(List<DisciplinaDomain> lista_disciplina) {
        this.lista_disciplina = lista_disciplina;
    }
    
    public void cadastrarDisciplina(){
        DisciplinaDAO disciplina_dao = new DisciplinaDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(disciplina_dao.cadastrarDisciplina(disciplina)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Disciplina cadastrada com sucesso!"));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro no cadastro da disciplina!"));
        }
    }
    
    public void excluirDisciplina(int id) throws IOException{
        DisciplinaDAO disciplina_dao = new DisciplinaDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(disciplina_dao.excluirDisciplina(id)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Disciplina excluída com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("campusCursoDisciplina.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na exclusão da disciplina!"));
        }
        recuperarDisciplinas();
    }
    
    public List<DisciplinaDomain> recuperarDisciplinas(){
        DisciplinaDAO disciplina_dao = new DisciplinaDAO();
        setLista_disciplina(disciplina_dao.recuperarDisciplina());
        return lista_disciplina;
    }
}
