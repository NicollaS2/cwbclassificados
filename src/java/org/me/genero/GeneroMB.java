package org.me.genero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import org.me.exception.ExceptionError;
import org.me.jogos_anuncios.Jogos_anunciosController;
import org.me.user.User;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;
/**
 *
 * @author 2017102346
 */
@ManagedBean(name = "generoMB")
@RequestScoped

public class GeneroMB {

    private SessionMB sessionMB = new SessionMB();
    private Genero user = new Genero();

    public SessionMB getSessionMB() {
        return sessionMB;
    }

    public void setSessionMB(SessionMB sessionMB) {
        this.sessionMB = sessionMB;
    }

    public Genero getUser() {
        return user;
    }

    public void setUser(Genero user) {
        this.user = user;
    }

    
    
    public GeneroMB() {
    }

    public List<Genero> getGeneroMB() throws ExceptionError{
        List<Genero> generos = new ArrayList<Genero>(); 
        try {
        GeneroController generoController = new GeneroController();
        generos = generoController.generos();


        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }
        
        
        return generos;
    }
    
    
}
