/* 
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Campus;

import java.io.IOException;
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
    private int id_campus_editar;
    
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

    public int getId_campus_editar() {
        return id_campus_editar;
    }

    public void setId_campus_editar(int id_campus_editar) {
        this.id_campus_editar = id_campus_editar;
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
    
    public void atualizarCampus() throws IOException{
        System.out.println("ATUALIZAAAAAAR");
        campus.setId(id_campus_editar);
        System.out.println(id_campus_editar);
        CampusDAO campus_dao = new CampusDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(campus_dao.atualizarCampus(campus)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Campus atualizado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("../campusCursoDisciplina.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na atualização do campus!"));
        }
        recuperarCampus();
    }
    
    public void excluirCampus(int id) throws IOException{
        CampusDAO campus_dao = new CampusDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(campus_dao.excluirCampus(id)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Campus excluído com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("campusCursoDisciplina.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro na exclusão do campus!"));
        }
        recuperarCampus();
    }
    
    public List<CampusDomain> recuperarCampus(){
        CampusDAO campus_dao = new CampusDAO();
        setListaCampus(campus_dao.recuperarCampus());
        return lista_campus;
    }
    

}
