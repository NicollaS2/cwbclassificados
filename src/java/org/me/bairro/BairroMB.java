package org.me.bairro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import org.me.exception.ExceptionError;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;

@ManagedBean(name = "bairroMB")
@RequestScoped

public class BairroMB {
    
    private SessionMB sessionMB = new SessionMB();
    
    
    public BairroMB() {
    }

    
    public List<Bairro> getBairros() throws ExceptionError{
        BairroDao userDao = new BairroDao();
        
        List<Bairro> bairros = new ArrayList<Bairro>(); 
        bairros = userDao.pegaBairro();
        
        //bairros.add(new Bairro(1, "teste"));
        
        
        /* bairros.add(new Bairro(2, "teste2"));
        bairros.add(new Bairro(3, "teste3 teste 159357"));
        
        for(Bairro e : retorno){
           bairros.add(new Bairro(retorno));
        } */
        
        
        
        
        return bairros;
    }
    
   
    
}
