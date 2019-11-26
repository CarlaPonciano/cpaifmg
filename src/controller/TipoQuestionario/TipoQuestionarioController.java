/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.TipoQuestionario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Domain.TipoPergunta.TipoPerguntaDomain;
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
    private TipoQuestionarioDomain it;
    
    public TipoQuestionarioController() {
        System.out.println("OIIIIIIIIIIII - construtor");
        try {
            this.it = new TipoQuestionarioDomain();
            this.it.setNome("TESTEEE");
            recuperarTipoQuestionario();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(TipoQuestionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TipoQuestionarioDomain getIt() {
        return it;
    }

    public void setIt(TipoQuestionarioDomain it) {
        this.it = it;
    }
    
    public List<TipoQuestionarioDomain> recuperarTipoQuestionario() throws SQLException{
        TipoQuestionarioDAO tipo_questionario_dao = new TipoQuestionarioDAO();
        TipoQuestionarioDomain tipo_questionario;
        System.out.println("OIIIIIIIIIIII - inicio antes do while");
        ResultSet rs =  tipo_questionario_dao.recuperarTipoQuestionario();
        while(rs.next()){
            tipo_questionario = new TipoQuestionarioDomain();
            tipo_questionario.setId(rs.getInt("id"));
            tipo_questionario.setNome(rs.getString("nome"));
            tipo_questionario.setDescricao(rs.getString("descricao"));
            tipo_questionario.setTipo_pergunta(new TipoPerguntaDomain(rs.getInt("TipoPergunta_id")));
            System.out.println(tipo_questionario);
            lista_tipo_questionario.add(tipo_questionario);
            it = tipo_questionario;
        }
        return lista_tipo_questionario;
    }

    public List<TipoQuestionarioDomain> getLista_tipo_questionario() {
        return lista_tipo_questionario;
    }

    public void setLista_tipo_questionario(List<TipoQuestionarioDomain> lista_tipo_questionario) {
        this.lista_tipo_questionario = lista_tipo_questionario;
    }

}
