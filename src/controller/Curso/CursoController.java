/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Curso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import model.DAO.Curso.CursoDAO;
import model.Domain.Curso.CursoDomain;

/**
 *
 * @author carli
 */
@ManagedBean(value = "cursoController")
public class CursoController {
    private CursoDomain curso = new CursoDomain();

    public CursoDomain getCurso() {
        return curso;
    }

    public void setCurso(CursoDomain curso) {
        this.curso = curso;
    }
    
    public boolean cadastrarCurso(){
        CursoDAO curso_dao = new CursoDAO();
        return curso_dao.cadastrarCurso(curso);
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public List<CursoDomain> recuperarCurso() throws SQLException{
        CursoDAO curso_dao = new CursoDAO();
        CursoDomain curso;
        
        List<CursoDomain> lista_curso = new ArrayList();
        ResultSet rs =  curso_dao.recuperarCurso();
        while(rs.next()){
            curso = new CursoDomain();
            curso.setId(rs.getInt("id"));
            curso.setCurso(rs.getString("curso"));
            curso.setCampus_id(rs.getInt("campus_id"));
            lista_curso.add(curso);
        }
        return lista_curso;
    }
}
