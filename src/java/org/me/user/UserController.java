package org.me.user;
import org.me.exception.ExceptionError;

public class UserController {

    public User login(User user) throws ExceptionError {
        UserDao userDao = new UserDao();
        User retorno = userDao.login(user);
        return retorno;
    }
    public User cadastro(User user) throws ExceptionError {
        UserDao userDao = new UserDao();
        User retorno = userDao.cadastrar(user);
        return retorno;
    }
    
    public User Alterar(User user) throws ExceptionError {
        UserDao userDao = new UserDao();
        User retorno = userDao.Alterar(user);
        return retorno;
    }

}
