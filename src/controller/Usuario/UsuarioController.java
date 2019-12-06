/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Usuario;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.DAO.Usuario.UsuarioDAO;
import model.Domain.Usuario.UsuarioDomain;

/**
 *
 * @author amanda
 */
@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController{
    private UsuarioDomain sessao = null;
    private UsuarioDomain usuario = new UsuarioDomain();
    private String usuario_form, senha_form;

    public UsuarioController() {
        recuperarUsuario();
    }

    public UsuarioDomain getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDomain usuario) {
        this.usuario = usuario;
    }

    public String getUsuario_editar() {
        return usuario_form;
    }

    public void setUsuario_editar(String usuario_form) {
        this.usuario_form = usuario_form;
    }
    
    public void persistirUsuario(){
        UsuarioDAO usuario_dao = new UsuarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(usuario_dao.persistirUsuario(usuario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Conta criada com sucesso!"));
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro ao criar conta!"));
        }
    }
    
    public void atualizarUsuario() throws IOException{
        usuario.setUsuario(usuario_form);
        UsuarioDAO usuario_dao = new UsuarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario_dao.atualizarUsuario(usuario)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Conta atualizada com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("../editarConta.xhtml");
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro na atualização da conta!"));
        }
        recuperarUsuario();
    }
    
    public UsuarioDomain recuperarUsuario(){
        UsuarioDAO usuario_dao = new UsuarioDAO();
        UsuarioDomain u = new UsuarioDomain();
        u.setUsuario(usuario_form);
        setUsuario(usuario_dao.recuperarUsuario(u));
        return usuario;
    }
    
    public void inativarUsuario() throws IOException{
        UsuarioDAO usuario_dao = new UsuarioDAO();
        UsuarioDomain u = new UsuarioDomain();
        u.setUsuario(usuario_form);
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario_dao.inativarUsuario(u)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Perfil inativado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao inativar perfil!"));
        }
    }
    
    public void ativarUsuario() throws IOException{
        UsuarioDAO usuario_dao = new UsuarioDAO();
        UsuarioDomain u = new UsuarioDomain();
        u.setUsuario(usuario_form);
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario_dao.ativarUsuario(u)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Conta ativado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao ativar conta!"));
        }
    }
    
    public void login() throws IOException{
        UsuarioDAO usuario_dao = new UsuarioDAO();
        UsuarioDomain u = new UsuarioDomain();
        u.setUsuario(usuario_form);
        u.setSenha(senha_form);
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario_dao.login(u)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Login realizado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao fazer login!"));
        }
    }
    
    public UsuarioDomain getSession(){
        return sessao;
    }
    
    public void logout(){
        this.sessao = null;
    }
    
}
