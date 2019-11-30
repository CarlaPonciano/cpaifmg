/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Curso;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.DAO.Curso.CursoDAO;
import model.Domain.Curso.CursoDomain;

/**
 *
 * @author carli
 */
@ManagedBean(name = "cursoController")
@SessionScoped
public class CursoController {
    private CursoDomain curso = new CursoDomain();
    private List<CursoDomain> lista_curso = new ArrayList();
    
    public CursoController() {
        recuperarCurso();
    }
    
    public CursoDomain getCurso() {
            return curso;
    }

    public void setCurso(CursoDomain curso) {
            this.curso = curso;
    }

    public List<CursoDomain> getLista_curso() {
        return lista_curso;
    }

    public void setLista_curso(List<CursoDomain> lista_curso) {
        this.lista_curso = lista_curso;
    }

    public void cadastrarCurso() {
        CursoDAO curso_dao = new CursoDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(curso_dao.cadastrarCurso(curso)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Curso cadastrado com sucesso!"));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro no cadastro do curso!"));
        }
    }
    
    public List<CursoDomain> recuperarCurso(){
        CursoDAO curso_dao = new CursoDAO();
        setLista_curso(curso_dao.recuperarCurso());
        return lista_curso;
    }
}
