package trivago.model.bd;

import trivago.model.bd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import trivago.model.Hotel;

public class data {
    private Conexion con;
    
    public data() throws ClassNotFoundException, SQLException{
        con = new Conexion("bd_trivago");
    }
        
    public Hotel getHotel(String nombre, String ciudad) throws SQLException{
        String query = "SELECT * FROM hotel WHERE nombre = '"+nombre+"' OR ciudad = '"+ciudad+"'";
        
        
        Hotel nom = null;
        
        
        ResultSet rs = con.ejecutar(query);
        
        if (rs.next()) {
            
            nom = new Hotel();
            
            nom.setId(rs.getInt("id"));
            nom.setNombre(rs.getString("nombre"));
            nom.setCiudad(rs.getString("ciudad"));
            nom.setPrecio_por_noche(rs.getInt("precio_por_noche"));
        }
        
        con.close();
        
        return nom;
        
        
    }
}
  

    
    

