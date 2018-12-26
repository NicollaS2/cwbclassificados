package org.me.bairro;

import java.util.ArrayList;
import java.util.List;
import org.me.exception.ExceptionError;

public class BairroController {
    
    public List<Bairro> bairros() throws ExceptionError {
        BairroDao userDao = new BairroDao();
        List<Bairro> retorno = new ArrayList<Bairro>(); 
        retorno = userDao.pegaBairro();
        
        for(Bairro e : retorno){
           // this.lista.add(e);
           // System.out.println(e.getNome());
        }
        return retorno;
    }

}



