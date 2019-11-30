/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Disciplina;

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
    
    public DisciplinaController() {
    }

    public DisciplinaDomain getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaDomain disciplina) {
        this.disciplina = disciplina;
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
}
