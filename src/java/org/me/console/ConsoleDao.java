package org.me.console;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.me.database.Database;
import org.me.exception.ExceptionError;

public class ConsoleDao {
    public static List<Console> pegaConsole() throws ExceptionError {
        try {
            Database myDb = new Database();
            
            List<Console> Userconsole = new ArrayList<Console>();

            String sql = "SELECT * FROM console";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery(); 
            
            while(myResult.next()){
                Console console = new Console();
                console.setId(myResult.getInt("id_console"));
                console.setDescricao(myResult.getString("descricao"));
                Userconsole.add(console);
            }
        
            return Userconsole;
            
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
    }



    
}
