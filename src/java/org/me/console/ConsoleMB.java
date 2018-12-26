package org.me.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import org.me.user.User;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.exception.ExceptionError;
import org.me.util.SessionMB;

@ManagedBean(name = "consoleMB")
@RequestScoped

public class ConsoleMB {
    
    private SessionMB sessionMB = new SessionMB();
    private Console user = new Console();

    public SessionMB getSessionMB() {
        return sessionMB;
    }

    public void setSessionMB(SessionMB sessionMB) {
        this.sessionMB = sessionMB;
    }

    public Console getUser() {
        return user;
    }

    public void setUser(Console user) {
        this.user = user;
    }
    
    public ConsoleMB() {
    }
    
    public List<Console> consoleListar() throws ExceptionError{
        ConsoleController jogosController = new ConsoleController();
        
        List<Console> consoles = new ArrayList<Console>(); 
        consoles = jogosController.consoles();

        return consoles;
    }

    public List<Console> getConsole() throws ExceptionError{
        ConsoleDao jogosDao = new ConsoleDao();
        
        List<Console> consoles = new ArrayList<Console>(); 
        consoles = jogosDao.pegaConsole();

        return consoles;
    }
   
}
