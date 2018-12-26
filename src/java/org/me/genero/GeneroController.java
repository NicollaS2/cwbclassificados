
package org.me.genero;

import java.util.ArrayList;
import java.util.List;
import org.me.exception.ExceptionError;


public class GeneroController {
    public List generos() throws ExceptionError {
        GeneroDAO generoDao = new GeneroDAO();
        List retorno; 
        retorno = generoDao.pegaGenero();
        return retorno;
    }
}
