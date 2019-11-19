/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Usuario;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import model.DAO.Usuario.UsuarioDAO;
import model.Domain.Usuario.UsuarioDomain;

/**
 *
 * @author amanda
 */
@ManagedBean(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable{
    
    private UsuarioDomain sessao = null;
    private String mensagem = "";
    UsuarioDomain usuario = new UsuarioDomain();
    
    public UsuarioDomain getSession(){
        return sessao;
    }
    
    public void logout(){
        this.sessao = null;
    }
    
    public void persistirUsuario(){
        UsuarioDAO usuario_dao = new UsuarioDAO();
        usuario_dao.persistirUsuario(usuario);
        if (usuario != null && usuario.getUsuario() != null) {
            this.setMensagem("Conta criada com sucesso!");            
        }
    }
    
    public boolean atualizarUsuario(UsuarioDomain usuario){
        UsuarioDAO usuario_dao = new UsuarioDAO();
        return usuario_dao.atualizarUsuario(usuario);
    }
    
    public UsuarioDomain recuperarUsuario(UsuarioDomain usuario){
        UsuarioDAO usuario_dao = new UsuarioDAO();
        return usuario_dao.recuperarUsuario(usuario);
    }
    
    public boolean inativarUsuario(UsuarioDomain usuario){
        UsuarioDAO usuario_dao = new UsuarioDAO();
        return usuario_dao.inativarUsuario(usuario);
    }
    
    public boolean ativarUsuario(UsuarioDomain usuario){
        UsuarioDAO usuario_dao = new UsuarioDAO();
        return usuario_dao.ativarUsuario(usuario);
    }
    
    public boolean login(UsuarioDomain usuario){
        UsuarioDAO usuario_dao = new UsuarioDAO();
        return usuario_dao.login(usuario);
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
