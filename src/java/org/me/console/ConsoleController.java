package org.me.console;

import java.util.ArrayList;
import java.util.List;
import org.me.exception.ExceptionError;

public class ConsoleController {

    public List<Console> consoles() throws ExceptionError {
        ConsoleDao jogosDao = new ConsoleDao();
        List<Console> retorno = new ArrayList<Console>(); 
        retorno = jogosDao.pegaConsole();
        
        for(Console e : retorno){

            
        }
        return retorno;
    }

    
}
