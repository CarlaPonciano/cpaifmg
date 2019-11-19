/* 
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Campus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.ManagedBean;
import java.util.List;
 import model.DAO.Campus.CampusDAO;
 import model.Domain.Campus.CampusDomain;

/**
 *
 * @author carli
 */
@ManagedBean(value = "campusController")
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
        CampusDomain campus;
        
        List<CampusDomain> lista_campus = new ArrayList();
        ResultSet rs =  campus_dao.recuperarCampus();
        while(rs.next()){
            campus = new CampusDomain();
            campus.setId(rs.getInt("id"));
            campus.setCampus(rs.getString("campus"));
            lista_campus.add(campus);
        }
        return lista_campus;
    }
}
