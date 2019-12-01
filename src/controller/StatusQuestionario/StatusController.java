/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.StatusQuestionario;

import java.util.ArrayList;
import java.util.List;
import model.DAO.StatusQuestionario.StatusQuestionarioDAO;
import model.Domain.StatusQuestionario.StatusQuestionarioDomain;

/**
 *
 * @author amanda
 */
@javax.faces.bean.ManagedBean(name = "statusQuestionarioController")
@javax.faces.bean.SessionScoped
public class StatusController{
    private List<StatusQuestionarioDomain> lista_status = new ArrayList();

    public StatusController() {
        recuperarStatus();
    }

    public List<StatusQuestionarioDomain> getLista_status() {
        return lista_status;
    }

    public void setLista_status(List<StatusQuestionarioDomain> lista_status) {
        this.lista_status = lista_status;
    }
    
    public List<StatusQuestionarioDomain> recuperarStatus(){
        StatusQuestionarioDAO status_questionario_dao = new StatusQuestionarioDAO();
        setLista_status(status_questionario_dao.recuperarStatusQuestionario());
        return lista_status;
    } 
   
}
