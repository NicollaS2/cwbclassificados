package org.me.bairro;

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


public class BairroDao {
    public static List<Bairro> pegaBairro() throws ExceptionError {
        try {
            Database myDb = new Database();
            
            List<Bairro> Userbairro = new ArrayList<Bairro>();

            String sql = "SELECT * FROM bairro group by descricao";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery(); 
            
            
            while(myResult.next()){
                Bairro bairro = new Bairro();
                bairro.setId(myResult.getInt("id_bairro"));
                bairro.setBairroNome(myResult.getString("descricao"));
                Userbairro.add(bairro);
            }
        
            return Userbairro;
            
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
    }
}
