package org.me.jogos_anuncios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.me.bairro.Bairro;
import org.me.console.Console;
import org.me.database.Database;
import org.me.exception.ExceptionError;
import org.me.genero.Genero;
import org.me.user.User;

public class Jogos_anunciosDao {
    
    
    public Jogos_anuncios cadastrar(Jogos_anuncios jogos) throws ExceptionError {
        Jogos_anuncios retorno = null;
        try {
            Database myDb = new Database();

            String sql = "INSERT INTO jogos_anuncio "
                    + "(descricao,id_console, id_genero, id_usuario, nome) VALUES (?, ?, ?, ?, ?)";
            myDb.setQuerySql(sql);

            myDb.setQueryParameter().setString(1, jogos.getDescricao());
            myDb.setQueryParameter().setInt(2, jogos.getId_console());
            myDb.setQueryParameter().setInt(3, jogos.getId_genero());
            myDb.setQueryParameter().setInt(4, jogos.getId_user());
            myDb.setQueryParameter().setString(5, jogos.getNome());
            
            int result = myDb.setQueryParameter().executeUpdate();
            
            if (result == 1){
               String sql2 = "SELECT * FROM jogos_anuncio WHERE id_usuario = ?"; 
               myDb.setQuerySql(sql2);
               
               myDb.setQueryParameter().setInt(1, 1);
               ResultSet myResult = myDb.setQueryParameter().executeQuery();
               
               if (myResult.next()){
                    Jogos_anuncios jogoss = new Jogos_anuncios();

                    jogoss.setId_console(myResult.getInt("id_console"));
                    jogoss.setId_genero(myResult.getInt("id_genero"));
                    jogoss.setDescricao(myResult.getString("descricao"));
                    jogoss.setId_user(myResult.getInt("id_usuario"));
                    

                    retorno = jogoss; 
                }
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }
        
    
    public static List<Jogos_anuncios> getDescricaoAnuncios(int id) throws ExceptionError, SQLException {

        List<Jogos_anuncios> anuncio = new ArrayList<Jogos_anuncios>();
        try {
             
            Database myDB = new Database();
            String sql = "SELECT * FROM jogos_anuncio AS j  "
                    + "INNER JOIN usuario AS u ON u.id_usuario = j.id_usuario "
                    + "INNER JOIN telefone AS t ON t.id_usuario = u.id_usuario "
                    + "INNER JOIN bairro AS b ON b.id_bairro = u.id_bairro "
                    + "INNER JOIN console AS c ON c.id_console = j.id_console "
                    + "INNER JOIN genero_jogos AS g ON g.id_genero = j.id_genero "
                    + "WHERE j.id_anuncio = "+id;
            
                Jogos_anuncios jogos = new Jogos_anuncios();
            myDB.setQuerySql(sql);

            ResultSet resultado = myDB.setQueryParameter().executeQuery();

            while (resultado.next()) {
                Console console = new Console();
                Genero genero = new Genero();
                User user = new User();
                Bairro bairro = new Bairro();

                jogos.setId_jogosAnuncios(resultado.getInt("j.id_anuncio"));
                jogos.setDescricao(resultado.getString("j.descricao"));
                jogos.setNome(resultado.getString("j.nome"));
                jogos.setImg(resultado.getString("j.img"));
                console.setDescricao(resultado.getString("c.descricao"));
                genero.setDescricao(resultado.getString("g.descricao"));
                bairro.setBairroNome(resultado.getString("b.descricao"));
                user.setNome(resultado.getString("u.nome"));
                user.setTelefone_ddd(resultado.getString("t.ddd"));
                user.setTelefone_numero(resultado.getString("t.fone"));
                jogos.setConsole(console);
                jogos.setGenero(genero);
                user.setBairro(bairro);
                jogos.setUser(user);

                anuncio.add(jogos);
                
                System.out.println("anuncios DAO"+jogos.getId_jogosAnuncios());
                System.out.println(jogos.getDescricao());
                System.out.println(jogos.getNome());

            }
            return anuncio;

        } catch (SQLException | ExceptionError e) {
            throw new ExceptionError(e);
        }

    }
    
    public static List<Jogos_anuncios> getJogos(String filterGenero, String filterBairro, String filterConsole , String filterHTTPRequest) throws ExceptionError, SQLException {

        List<Jogos_anuncios> anuncio = new ArrayList<Jogos_anuncios>();
        
        try {
            
            int idGenero = 0;
            int idBairro = 0;
            int idConsole = 0;
            String sql;
            String VarGenero = "genero=";
            String VarBairro = "bairro=";
            String VarConsole = "console=";
            
            
                System.out.println("genero="+filterGenero);
                if (filterGenero!=null){
                    idGenero = Integer.parseInt(filterGenero);
                }
                
                System.out.println("console="+filterConsole);
                if (filterConsole!=null){
                    idConsole = Integer.parseInt(filterConsole);
                }
                
           
                if (filterBairro!=null){
                    idBairro = Integer.parseInt(filterBairro);  
                }
                
           
            String VarUltimasAtualizacoes = "ultimasAtualizacoes=";
            if (filterHTTPRequest.equals(VarGenero+filterGenero)) {
                                System.out.println("else if genero");

                 sql = "SELECT * "
                        + "FROM jogos_anuncio AS j "
                        + "INNER JOIN usuario AS u ON u.id_usuario = j.id_usuario "
                        + "INNER JOIN bairro AS b ON b.id_bairro = u.id_bairro "
                        + "INNER JOIN console AS c ON c.id_console = j.id_console "
                        + "INNER JOIN genero_jogos AS g ON g.id_genero = j.id_genero "
                        + "WHERE j.id_genero = " + idGenero + " AND ativo = 1 ORDER BY u.id_usuario DESC;" ;
            }
            else if (filterHTTPRequest.equals(VarBairro + filterBairro)) {
                                System.out.println("else if bairro");

                 sql = "SELECT * "
                        + "FROM jogos_anuncio AS j "
                        + "INNER JOIN usuario AS u ON u.id_usuario = j.id_usuario "
                        + "INNER JOIN bairro AS b ON b.id_bairro = u.id_bairro "
                        + "INNER JOIN console AS c ON c.id_console = j.id_console "
                        + "INNER JOIN genero_jogos AS g ON g.id_genero = j.id_genero "
                        + "WHERE b.id_bairro =  " + idBairro + " AND ativo = 1 ORDER BY u.id_usuario DESC;";
                 
            }
            else if (filterHTTPRequest.equals(VarConsole + filterConsole)) {
                                System.out.println("else if console");

                 sql = "SELECT * "
                        + "FROM jogos_anuncio AS j "
                        + "INNER JOIN usuario AS u ON u.id_usuario = j.id_usuario "
                        + "INNER JOIN bairro AS b ON b.id_bairro = u.id_bairro "
                        + "INNER JOIN console AS c ON c.id_console = j.id_console "
                        + "INNER JOIN genero_jogos AS g ON g.id_genero = j.id_genero "
                        + "WHERE c.id_console =  " + idConsole + " AND ativo = 1 ORDER BY u.id_usuario DESC;"; 
                 
            }
            
            else {

                 sql = "SELECT * "
                        + "FROM jogos_anuncio AS j "
                        + "INNER JOIN usuario AS u ON u.id_usuario = j.id_usuario "
                        + "INNER JOIN bairro AS b ON b.id_bairro = u.id_bairro "
                        + "INNER JOIN console AS c ON c.id_console = j.id_console "
                        + "INNER JOIN genero_jogos AS g ON g.id_genero = j.id_genero WHERE ativo = 1 ORDER BY u.id_usuario DESC; ";
                 
            }
            
            Database myDB = new Database();

            myDB.setQuerySql(sql);
            ResultSet resultado = myDB.setQueryParameter().executeQuery();

            while (resultado.next()) {
                Jogos_anuncios jogos = new Jogos_anuncios();
                Console console = new Console();
                Genero genero = new Genero();
                User user = new User();
                Bairro bairro = new Bairro();

                jogos.setId_jogosAnuncios(resultado.getInt("j.id_anuncio"));
                jogos.setDescricao(resultado.getString("j.descricao"));
                jogos.setNome(resultado.getString("j.nome"));
                jogos.setImg(resultado.getString("j.img"));
                console.setDescricao(resultado.getString("c.descricao"));
                genero.setDescricao(resultado.getString("g.descricao"));
                bairro.setBairroNome(resultado.getString("b.descricao"));
                user.setNome(resultado.getString("u.nome"));
                jogos.setConsole(console);
                jogos.setGenero(genero);
                user.setBairro(bairro);
                jogos.setUser(user);

                anuncio.add(jogos);

            }
            return anuncio;

        } catch (SQLException | ExceptionError e) {
            throw new ExceptionError(e);
        }

    }
    
    
    
    public static List<Jogos_anuncios> getJogosUser(Jogos_anuncios jogo) throws ExceptionError, SQLException{
        
        List<Jogos_anuncios> anuncio = new ArrayList<Jogos_anuncios>();
        try {
            
        Database myDB = new Database();
        String sql = "SELECT * FROM jogos_anuncio AS j INNER JOIN usuario AS u ON u.id_usuario = j.id_usuario INNER JOIN bairro AS b ON b.id_bairro = u.id_bairro INNER JOIN console AS c ON c.id_console = j.id_console INNER JOIN genero_jogos AS g ON g.id_genero = j.id_genero WHERE u.id_usuario = ? AND ativo = 1;";
        
        myDB.setQuerySql(sql);
        myDB.setQueryParameter().setInt(1, jogo.getId_user());
        ResultSet resultado = myDB.setQueryParameter().executeQuery();
        
        while(resultado.next()){
            Jogos_anuncios jogos = new Jogos_anuncios();
            Console console = new Console();
            Genero genero = new Genero();
            User user = new User();
            Bairro bairro = new Bairro();
            
            jogos.setId_jogosAnuncios(resultado.getInt("j.id_anuncio"));
            jogos.setDescricao(resultado.getString("j.descricao"));
            jogos.setNome(resultado.getString("j.nome"));
            jogos.setImg(resultado.getString("j.img"));
            console.setDescricao(resultado.getString("c.descricao"));
            genero.setDescricao(resultado.getString("g.descricao"));
            bairro.setBairroNome(resultado.getString("b.descricao"));
            user.setNome(resultado.getString("u.nome"));
            jogos.setConsole(console);
            jogos.setGenero(genero);
            user.setBairro(bairro);
            jogos.setUser(user);
            
            
            anuncio.add(jogos);
            
        
        }
        return anuncio;
        
        } catch (SQLException | ExceptionError e) {
            throw new ExceptionError(e);
        }
           
    }  
    
    
    public Jogos_anuncios excluirAnuncio(int game) throws ExceptionError {
        Jogos_anuncios retorno = null;
        try {
            Database myDb = new Database();

            String sql = "UPDATE jogos_anuncio "
                    + "SET ativo = 0 WHERE id_anuncio = ?";
            myDb.setQuerySql(sql);

            myDb.setQueryParameter().setInt(1, game);
            
            
            int result = myDb.setQueryParameter().executeUpdate();
            
            if (result == 1){
               String sql2 = "SELECT * FROM jogos_anuncio WHERE id_usuario = ? AND ativo = 1"; 
               myDb.setQuerySql(sql2);
               
               myDb.setQueryParameter().setInt(1, 1);
               ResultSet myResult = myDb.setQueryParameter().executeQuery();
               
               if (myResult.next()){
                    Jogos_anuncios jogoss = new Jogos_anuncios();

                    jogoss.setId_console(myResult.getInt("id_console"));
                    jogoss.setId_genero(myResult.getInt("id_genero"));
                    jogoss.setDescricao(myResult.getString("descricao"));
                    jogoss.setId_user(myResult.getInt("id_usuario"));
                    

                    retorno = jogoss; 
                }
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }
    
    
    public boolean Alterar(Jogos_anuncios jogos) throws ExceptionError {
        boolean retorno = false;
        try {
            Database myDb = new Database();
           
            String sql = "update jogos_anuncio set nome = ?, descricao = ?, id_console = ?, id_genero = ? where id_anuncio = ?";
            myDb.setQuerySql(sql);

            myDb.setQueryParameter().setString(1, jogos.getNome());
            myDb.setQueryParameter().setString(2, jogos.getDescricao());
            myDb.setQueryParameter().setInt(3, jogos.getId_console());
            myDb.setQueryParameter().setInt(4, jogos.getId_genero());
            myDb.setQueryParameter().setInt(5, jogos.getId_jogosAnuncios());
            
            System.out.println(jogos.getNome());
            System.out.println(jogos.getDescricao());
            System.out.println(jogos.getId_console());
            System.out.println(jogos.getId_genero());
            System.out.println(jogos.getId_jogosAnuncios());
            
            System.out.println(myDb.setQueryParameter().executeUpdate());
            
           if (myDb.setQueryParameter().executeUpdate() != 0){
               retorno = true;
           }
            
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }
      
}
