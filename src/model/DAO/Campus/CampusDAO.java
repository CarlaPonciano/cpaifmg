/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.Campus;

import model.Connection.ConnectionPostgreSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Domain.Campus.CampusDomain;

/**
 *
 * @author carli
 */
public class CampusDAO {
    public boolean cadastrarCampus(CampusDomain campus){
        String sql = "INSERT INTO campus(campus) VALUES ('" + campus.getCampus() + "');";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch(SQLException e){
            System.out.println("Erro no cadastro do campus!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet recuperarCampus(){
        String sql = "SELECT * FROM campus;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            return rs;
        }catch(SQLException e){
            System.out.println("Erro na recuperação dos campus cadastrados!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
