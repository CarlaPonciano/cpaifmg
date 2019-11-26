/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.TipoQuestionario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    
    public TipoQuestionarioController() {
        try {
            recuperarTipoQuestionario();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(TipoQuestionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<TipoQuestionarioDomain> recuperarTipoQuestionario() throws SQLException{
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

}
