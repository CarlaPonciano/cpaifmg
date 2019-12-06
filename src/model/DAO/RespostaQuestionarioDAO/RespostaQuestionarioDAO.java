/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.RespostaQuestionarioDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connection.ConnectionPostgreSQL;
import model.DAO.RespostaMarcada.RespostaMarcadaDAO;
import model.Domain.RespostaQuestionario.RespostaMarcadaDomain;
import model.Domain.RespostaQuestionario.RespostaQuestionarioDomain;

/**
 *
 * @author carli
 */
public class RespostaQuestionarioDAO {
    
    public int cadastrarResposta(RespostaQuestionarioDomain resposta_questionario){
        String sql = "INSERT INTO respostaquestionario(semestremarcado, questionario_id, campus_id, disciplina_id, curso_id, observacoes, nome) VALUES "
                        + "(" + resposta_questionario.getSemestre_marcado()+ ", " + resposta_questionario.getQuestionario_id()+ ", "
                        + resposta_questionario.getId_opcao_campus()+ ", " + resposta_questionario.getId_opcao_disciplina()+ ", " + resposta_questionario.getId_opcao_curso() + ""
                + ", '" + resposta_questionario.getObservacoes() + "', '"+ resposta_questionario.getNome()+ "') returning id;";
        try{
            int id = 0;
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(sql);
            if(resultado.next()){
                id = resultado.getInt("id");
            }
            return id;
        }catch(SQLException e){
            System.out.println("Erro no cadastro da resposta do questionário questionário!");
            System.out.println(sql);
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public List<RespostaQuestionarioDomain> recuperarRespostas(){
        String sql = "SELECT * FROM respostaquestionario_campus_disciplina_curso_questionario;";
        try{
            Connection con = ConnectionPostgreSQL.getInstance().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            RespostaQuestionarioDomain resposta_questionario;
            List<RespostaQuestionarioDomain> lista_resposta_questionario = new ArrayList();
            while(rs.next()){
                resposta_questionario = new RespostaQuestionarioDomain();
                resposta_questionario.setId(rs.getInt("id"));
                resposta_questionario.setSemestre_marcado(rs.getString("semestremarcado"));
                resposta_questionario.setNome_questionario(rs.getString("questionario_nome"));
                resposta_questionario.setCampus(rs.getString("campus"));
                resposta_questionario.setDisciplina(rs.getString("disciplina"));
                resposta_questionario.setCurso(rs.getString("curso"));
                resposta_questionario.setObservacoes(rs.getString("observacoes"));
                if(rs.getString("nome") == null){
                    resposta_questionario.setNome("Não Informado");
                }else{
                    resposta_questionario.setNome(rs.getString("nome"));
                }
                RespostaMarcadaDAO resposta_marcada_dao = new RespostaMarcadaDAO();
                resposta_questionario.setResposta_marcada(resposta_marcada_dao.recuperarListaResposta(resposta_questionario.getId()));
                lista_resposta_questionario.add(resposta_questionario);
            }
            return lista_resposta_questionario;
        }catch(SQLException e){
            System.out.println("Erro na recuperação das respostas dos questionários!");
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
}
