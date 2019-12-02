/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Curso;

import java.io.IOException;
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
    private int id_curso_editar;
    
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

    public int getId_curso_editar() {
        return id_curso_editar;
    }

    public void setId_curso_editar(int id_curso_editar) {
        this.id_curso_editar = id_curso_editar;
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
    
    public void atualizarCurso() throws IOException{
        curso.setId(id_curso_editar);
        CursoDAO curso_dao = new CursoDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(curso_dao.atualizarCurso(curso)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Curso atualizado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("../campusCursoDisciplina.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na atualização do cruso!"));
        }
        recuperarCurso();
    }
    
    public void excluirCurso(int id) throws IOException{
        CursoDAO curso_dao = new CursoDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(curso_dao.excluirCurso(id)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Curso excluído com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("campusCursoDisciplina.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na exclusão do curso!"));
        }
        recuperarCurso();
    }
    
    public List<CursoDomain> recuperarCurso(){
        CursoDAO curso_dao = new CursoDAO();
        setLista_curso(curso_dao.recuperarCurso());
        return lista_curso;
    }
}
