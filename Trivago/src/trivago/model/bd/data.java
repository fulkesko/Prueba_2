package trivago.model.bd;

import trivago.model.bd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class data {
    private Conexion con;
    
    public data() throws ClassNotFoundException, SQLException{
        con = new Conexion("bd_trivago");
        
    //public String ExisteHotel(String nombre, String ciudad){}
        
    }}    


    
    

