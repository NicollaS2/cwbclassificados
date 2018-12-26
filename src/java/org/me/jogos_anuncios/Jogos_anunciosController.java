package org.me.jogos_anuncios;

import java.sql.SQLException;
import java.util.List;
import org.me.exception.ExceptionError;

public class Jogos_anunciosController {

    Jogos_anuncios jogos = new Jogos_anuncios();
    public Jogos_anuncios cadastro(Jogos_anuncios jogos) throws ExceptionError {
        Jogos_anunciosDao jogosDao = new Jogos_anunciosDao();
        Jogos_anuncios retorno = jogosDao.cadastrar(jogos);
        return retorno;
    }
    
    public List getJogos(String filterGenero, String filterBairro,String filterConsole, String filterHTTPResquest) throws ExceptionError, SQLException{
        List lista;
        lista = Jogos_anunciosDao.getJogos(filterGenero, filterBairro,filterConsole, filterHTTPResquest);
        
        return lista;
    }
    
    public List TelaAnuncioController(int filterAnuncio) throws ExceptionError, SQLException{
        List lista;
        lista = Jogos_anunciosDao.getDescricaoAnuncios(filterAnuncio);
        
        System.out.println("controller metodo anuncio" + filterAnuncio);
        System.out.println(jogos.getId_jogosAnuncios());
        System.out.println(jogos.getNome());
        return lista;
    }
    
    public List getJogosUser(Jogos_anuncios jogo) throws ExceptionError, SQLException{
        List lista;
        lista = Jogos_anunciosDao.getJogosUser(jogo);
        
        return lista;
    } 
    
  
    public Jogos_anuncios excluir(int game) throws ExceptionError {
        Jogos_anunciosDao jogosDao = new Jogos_anunciosDao();
        Jogos_anuncios retorno = jogosDao.excluirAnuncio(game);
        return retorno;
    }
     
    public boolean Alterar(Jogos_anuncios jogos) throws ExceptionError {
        Jogos_anunciosDao jogosDao = new Jogos_anunciosDao();
        boolean retorno = jogosDao.Alterar(jogos);
        return retorno;
    }
     
}
