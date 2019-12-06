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
    private static UsuarioDomain sessao;
    private UsuarioDomain usuario;
    private String senha_form;

    public UsuarioController() {
        usuario = new UsuarioDomain();
        recuperarUsuario();
    }

    public UsuarioDomain getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDomain usuario) {
        this.usuario = usuario;
    }

    public UsuarioDomain getSessao() {
        if(sessao != null){
            return sessao;
        }else{
            UsuarioDomain retorno = new UsuarioDomain();
            retorno.setUsuario("Faça Login!");
            return retorno;
        }
    }

    public void setSessao(UsuarioDomain sessao) {
        this.sessao = sessao;
    }
    
    public void persistirUsuario() throws IOException{
        UsuarioDAO usuario_dao = new UsuarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if(usuario_dao.persistirUsuario(usuario)){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sucesso", "Conta criada com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Erro ao criar conta!"));
        }
    }
    
    public void atualizarUsuario() throws IOException{
        UsuarioDAO usuario_dao = new UsuarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario_dao.atualizarUsuario(usuario)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Conta atualizada com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro na atualização da conta!"));
        }
        recuperarUsuario();
    }
    
    public UsuarioDomain recuperarUsuario(){
        UsuarioDAO usuario_dao = new UsuarioDAO();
        setUsuario(usuario_dao.recuperarUsuario(usuario));
        return usuario;
    }
    
    public void inativarUsuario() throws IOException{
        UsuarioDAO usuario_dao = new UsuarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario_dao.inativarUsuario(usuario)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Perfil inativado com sucesso!"));
            sessao = null;
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao inativar perfil!"));
        }
    }
    
    public void ativarUsuario() throws IOException{
        UsuarioDAO usuario_dao = new UsuarioDAO();
        FacesContext context = FacesContext.getCurrentInstance();
        if (usuario_dao.ativarUsuario(usuario)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Conta ativado com sucesso!"));
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao ativar conta!"));
        }
    }
    
    public void login() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        if(sessao != null){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Login já feito"));
        }else{
            UsuarioDAO usuario_dao = new UsuarioDAO();
            if(usuario_dao.login(usuario)) {
                sessao = usuario_dao.recuperarUsuario(usuario);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Login realizado com sucesso!"));
                FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", "Erro ao fazer login!"));
            }
        }
    }
    
    public static String recuperarSessaoNomeUsuario(){
        if(sessao != null)
            return sessao.getUsuario();
        return "Não Logado!";
    }
    
    public void logout(){
        this.sessao = null;
    }
    
}
