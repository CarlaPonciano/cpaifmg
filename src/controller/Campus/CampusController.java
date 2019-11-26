/* 
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Campus;

import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.SessionScoped;
 import model.DAO.Campus.CampusDAO;
 import model.Domain.Campus.CampusDomain;

/**
 *
 * @author carli
 */
@javax.faces.bean.ManagedBean(name = "campusController")
@SessionScoped
public class CampusController {
    private CampusDomain campus = new CampusDomain();

    public CampusDomain getCampus() {
        return campus;
    }

    public void setCampus(CampusDomain campus) {
        this.campus = campus;
    }
    
    public boolean cadastrarCampus(){
        CampusDAO campus_dao = new CampusDAO();
        return campus_dao.cadastrarCampus(campus);
    }
    
    public List<CampusDomain> recuperarCampus() throws SQLException{
        CampusDAO campus_dao = new CampusDAO();
        List<CampusDomain> lista_campus = campus_dao.recuperarCampus();
        return lista_campus;
    }
    

}
