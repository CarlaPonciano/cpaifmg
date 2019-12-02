/* 
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Campus;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

 import model.DAO.Campus.CampusDAO;
 import model.Domain.Campus.CampusDomain;

/**
 *
 * @author carli
 */
@ManagedBean(name = "campusController")
@SessionScoped
public class CampusController {
    private CampusDomain campus;
    private List<CampusDomain> lista_campus = new ArrayList();
    
    public CampusController() {
        campus = new CampusDomain();
        recuperarCampus();
    }

    public CampusDomain getCampus() {
        return campus;
    }

    public void setCampus(CampusDomain campus) {
        this.campus = campus;
    }

    public List<CampusDomain> getListaCampus() {
        return lista_campus;
    }

    public void setListaCampus(List<CampusDomain> lista_campus) {
        this.lista_campus = lista_campus;
    }
    
    public void cadastrarCampus(){
        CampusDAO campus_dao = new CampusDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(campus_dao.cadastrarCampus(campus)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Campus cadastrado com sucesso!"));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro no cadastro do campus!"));
        }
    }
    
    public List<CampusDomain> recuperarCampus(){
        CampusDAO campus_dao = new CampusDAO();
        setListaCampus(campus_dao.recuperarCampus());
        return lista_campus;
    }
    

}
