package trivago.model;

import trivago.model.bd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import trivago.model.Hotel;
import trivago.model.bd.Conexion;

public class Data {

    private Conexion con;

    public Data() throws ClassNotFoundException, SQLException {
        con = new Conexion("bd_trivago");
    }

    public Hotel getHotel(String nombre) throws SQLException {
        String query = "SELECT * FROM hotel WHERE nombre = '" + nombre + "'";
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
    public Hotel getCiudad(String ciudad) throws SQLException {
        String query = "SELECT * FROM hotel WHERE ciudad = '" + ciudad + "'";
        Hotel ciu = null;
        ResultSet rs = con.ejecutar(query);
        if (rs.next()) {
            ciu = new Hotel();

            ciu.setId(rs.getInt("id"));
            ciu.setNombre(rs.getString("nombre"));
            ciu.setCiudad(rs.getString("ciudad"));
            ciu.setPrecio_por_noche(rs.getInt("precio_por_noche"));
        }

        con.close();

        return ciu;
    }
    public void crearHotel(Hotel h) throws SQLException {
        String insert = "INSERT INTO hotel VALUES "
                + "(NULL, '" + h.getNombre() + "',"
                + "'" + h.getCiudad() + "',"
                + "'" + h.getPrecio_por_noche() + "')";
        con.ejecutar(insert);
    }
}
