/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Curso;

import java.sql.SQLException;
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
	private String nome;

	
	public CursoController() {

	}

	private CursoDomain curso = new CursoDomain();

	public CursoDomain getCurso() {
		return curso;
	}

	public void setCurso(CursoDomain curso) {
		this.curso = curso;
	}

	public boolean cadastrarCurso() {
		CursoDAO curso_dao = new CursoDAO();
		return curso_dao.cadastrarCurso(curso);
	}

	/**
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<CursoDomain> recuperarCurso() throws SQLException {
            CursoDAO curso_dao = new CursoDAO();
            List<CursoDomain> lista_curso = curso_dao.recuperarCurso();
            return lista_curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void cadastrarTeste() {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage("Successful", "Nome Digitado: " + this.getNome()));

	}
}
