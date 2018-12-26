package org.me.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.me.exception.ExceptionError;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;

@ManagedBean(name = "userMB")
@RequestScoped

public class UserMB {
    
    private SessionMB sessionMB = new SessionMB();
    private User user = new User();
    private User dados = (User) sessionMB.getAttribute("user");
    
    public UserMB() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void login() throws IOException {
        try {
            UserController userContreoller = new UserController();
            
            User userLogado = userContreoller.login(this.user);
            
            if(userLogado!=null){
                //new MessageMB("msgInfo", "Login realizado com sucesso!", "", 1);
                //return "/site/index.xhtml";
                
                boolean auth = true;
                sessionMB.setAttribute("auth", auth);
                sessionMB.setAttribute("user", userLogado);
                
                String url = "/site/index.xhtml";
                new RedirectMB(url);
            } else {
                new MessageMB("msgInfo", "Usuário ou Senha inválidos!", "", 3);
                //return null;
            }
        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }
        
    }
    
    public void logout() throws IOException {
        String url = "/index.xhtml";
        new RedirectMB(url);
        
        sessionMB.getSession().invalidate();
    }
    
    public void cadastro() throws IOException {
        try {
            UserController userContreoller = new UserController();
            
            User userCadastrado = userContreoller.cadastro(this.user);
            
            if(userCadastrado!=null){
                //new MessageMB("msgInfo", "Login realizado com sucesso!", "", 1);
                //return "/site/index.xhtml";
                
                boolean auth = true;
                sessionMB.setAttribute("auth", auth);
                sessionMB.setAttribute("user", userCadastrado);
                
                String url = "/site/index.xhtml";
                new RedirectMB(url);
            } else {
                new MessageMB("msgInfo", "Email já Cadastrado, tente outro...", "", 3);
                //return null;
            }
        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }
        
    }
    
    public void alterar() throws IOException {
        try {
            UserController userContreoller = new UserController();
            
            dados.setId_bairro(user.getId_bairro());
            dados.setNome(user.getNome());
            dados.setUltimonome(user.getUltimonome());
            dados.setEmail(user.getEmail());
            dados.setSenha(user.getSenha());
            dados.setTelefone_ddd(user.getTelefone_ddd());
            dados.setTelefone_numero(user.getTelefone_numero());
            dados.setTelefone_tipo_id(user.getTelefone_tipo_id());
            
            User userAlterar = userContreoller.Alterar(this.dados); 
            
            if(userAlterar!=null){
                //new MessageMB("msgInfo", "Login realizado com sucesso!", "", 1);
                //return "/site/index.xhtml";
                
                String url = "/site/index.xhtml";
                new RedirectMB(url);
            } else {
                new MessageMB("msgInfo", "Usuário ou Senha inválidos!", "", 3);
                //return null;
            }
        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }
        
    }
    
    public User getSessionUser(String user){
        return (User) sessionMB.getAttribute("user");
    }
    
    public List<User> getTipofone() throws ExceptionError{
        UserDao userDao = new UserDao();
        
        List<User> telefone = new ArrayList<User>(); 
        telefone = userDao.pegaTelefone();
        
        return telefone;
    }
    
    public void userSeguranca(){
        
        Object logado = sessionMB.getAttribute("auth");
        
        if(logado==null){
            String url = "/index.xhtml";
            new RedirectMB(url);   
         
        }
        
    }
    
    public void validateEmail(FacesContext context, UIComponent toValidate, Object value) {  
    String email = (String) value;  
  
    if (email.indexOf('@') == -1) {  
        ((UIInput)toValidate).setValid(false);  
  
        FacesMessage message = new FacesMessage("Email inválido ou sem o caractere @");  
        context.addMessage(toValidate.getClientId(context), message);  
        }  
    }
    
    public void somenteNumeros(FacesContext context, UIComponent toValidate, Object value) {   
    String numero = (String) value;
    
    if (numero.contains("a") || numero.contains("b") || numero.contains("c") || numero.contains("d") || numero.contains("e") || numero.contains("f") ||
        numero.contains("g") || numero.contains("h") || numero.contains("i") || numero.contains("j") || numero.contains("k") || numero.contains("l") ||
        numero.contains("m") || numero.contains("n") || numero.contains("o") || numero.contains("p") || numero.contains("q") || numero.contains("r") ||
        numero.contains("s") || numero.contains("t") || numero.contains("u") || numero.contains("v") || numero.contains("x") || numero.contains("y") ||
        numero.contains("z") || numero.contains("w") || numero.contains("ç") || numero.contains("!") || numero.contains("@") || numero.contains("#") ||
        numero.contains("$") || numero.contains("%") || numero.contains("¨") || numero.contains("&") || numero.contains("*") || numero.contains("(") ||
        numero.contains(")") || numero.contains("-") || numero.contains("_") || numero.contains(",") || numero.contains(".") || numero.contains(";")) {  
        ((UIInput)toValidate).setValid(false);  
  
        FacesMessage message = new FacesMessage("Verifique o DDD ou o Telefone: o campo deve conter apenas números");  
        context.addMessage(toValidate.getClientId(context), message);  
        }  
    }  
    
    
    
}
