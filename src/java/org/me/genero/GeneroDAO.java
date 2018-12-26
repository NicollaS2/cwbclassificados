package org.me.genero;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.me.database.Database;
import org.me.exception.ExceptionError;

@ManagedBean(name = "generoDAO")
@RequestScoped
public class GeneroDAO {
    
     public static List<Genero> pegaGenero() throws ExceptionError {
        try {
            Database myDb = new Database();
            
            List<Genero> UserGenero = new ArrayList<Genero>();

            String sql = "SELECT * FROM genero_jogos";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery(); 
            
            while(myResult.next()){
                Genero genero = new Genero();
                genero.setId(myResult.getInt("id_genero"));
                genero.setDescricao(myResult.getString("descricao"));
                UserGenero.add(genero);
            }
        
            return UserGenero;
            
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
    }
    
    
    
    
    
}
