/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Disciplina;

import javax.annotation.ManagedBean;
import model.DAO.Disciplina.DisciplinaDAO;
import model.Domain.Disciplina.DisciplinaDomain;

/**
 *
 * @author carli
 */
@ManagedBean(value = "disciplinaController")
public class DisciplinaController {
    DisciplinaDomain disciplina = new DisciplinaDomain();

    public DisciplinaDomain getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaDomain disciplina) {
        this.disciplina = disciplina;
    }
    
    public boolean cadastrarDisciplina(){
        DisciplinaDAO disciplina_dao = new DisciplinaDAO();
        return disciplina_dao.cadastrarDisciplina(disciplina);
    }
}
