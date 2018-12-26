package org.me.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.me.bairro.Bairro;
import org.me.database.Database;
import org.me.exception.ExceptionError;
import org.me.exception.LibraryError;


public class UserDao {
    public User login(User user) throws ExceptionError {
        User retorno = null;
        try {
            Database myDb = new Database();

            String sql = "SELECT * FROM usuario WHERE email = ? AND senha = MD5(?)";
            myDb.setQuerySql(sql);

            myDb.setQueryParameter().setString(1, user.getEmail());
            myDb.setQueryParameter().setString(2, user.getSenha());
            
            System.out.println(user.getEmail());
            System.out.println(user.getSenha());
            
            ResultSet myResult = myDb.setQueryParameter().executeQuery();
            
            if (myResult.next()){
               User userLogado = new User();
               
               userLogado.setId(myResult.getInt("id_usuario"));
               userLogado.setNome(myResult.getString("nome"));
               userLogado.setUltimonome(myResult.getString("ultimo_nome"));
               userLogado.setEmail(myResult.getString("email"));
               userLogado.setSenha(myResult.getString("senha"));
               
               retorno = userLogado; 
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }
    
    public User cadastrar(User user) throws ExceptionError {
        User retorno = null;
        try {
            Database myDb = new Database();

            String sql = "CALL  inserir_dados_cadastro(? ,? ,? ,? ,? ,? ,? ,?)";
                    
            myDb.setQuerySql(sql);

            myDb.setQueryParameter().setString(1, user.getNome());
            myDb.setQueryParameter().setString(2, user.getUltimonome());
            myDb.setQueryParameter().setString(3, user.getEmail());
            myDb.setQueryParameter().setString(4, user.getSenha());
            myDb.setQueryParameter().setInt(5, user.getId());
            myDb.setQueryParameter().setString(6, user.getTelefone_ddd());
            myDb.setQueryParameter().setString(7, user.getTelefone_numero());
            myDb.setQueryParameter().setInt(8, user.getTelefone_tipo_id());
            
            int result = myDb.setQueryParameter().executeUpdate();
            
            if (result == 1){
               String sql2 = "SELECT * FROM usuario WHERE email = ?"; 
               myDb.setQuerySql(sql2);
               
               myDb.setQueryParameter().setString(1, user.getEmail());
               ResultSet myResult = myDb.setQueryParameter().executeQuery();
               
               if (myResult.next()){
                    User userLogado = new User();

                    userLogado.setId(myResult.getInt("id_usuario"));
                    userLogado.setNome(myResult.getString("nome"));
                    userLogado.setUltimonome(myResult.getString("ultimo_nome"));
                    userLogado.setEmail(myResult.getString("email"));
                    userLogado.setSenha(myResult.getString("senha"));

                    retorno = userLogado; 
                }
               
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }
    
    public User Alterar(User user) throws ExceptionError {
        User retorno = null;
        try {
            Database myDb = new Database();
           
            String sql = "CALL alterar_dados_cadastro(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            myDb.setQuerySql(sql);

            myDb.setQueryParameter().setString(1, user.getNome());
            myDb.setQueryParameter().setString(2, user.getUltimonome());
            myDb.setQueryParameter().setString(3, user.getEmail());
            myDb.setQueryParameter().setString(4, user.getSenha());
            myDb.setQueryParameter().setInt(5, user.getId_bairro());
            myDb.setQueryParameter().setInt(6, user.getId());
            myDb.setQueryParameter().setString(7, user.getTelefone_ddd());
            myDb.setQueryParameter().setString(8, user.getTelefone_numero());
            myDb.setQueryParameter().setInt(9, user.getTelefone_tipo_id());
            
            
           if (myDb.setQueryParameter().executeUpdate() !=0){
               retorno = user;
           }
            
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }
    
    public static List<User> pegaTelefone() throws ExceptionError {
        try {
            Database myDb = new Database();
            
            List<User> Userbairro = new ArrayList<User>();

            String sql = "SELECT * FROM tipo_fone";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery(); 
            
            while(myResult.next()){
                User user = new User();
                user.setTelefone_tipo_id(myResult.getInt("id_tipo_fone"));
                user.setTelefone_descricao(myResult.getString("descricao"));
                Userbairro.add(user);
            }
        
            return Userbairro;
            
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
    }
    
}
