package trivago.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trivago.model.Hotel;
import trivago.model.bd.Conexion;

public class Data {

    private Conexion con;

    public Data() throws ClassNotFoundException, SQLException {
        con = new Conexion("bd_trivago");
    }

    public void crearHotel(Hotel h) throws SQLException {
        String insert = "INSERT INTO hotel VALUES "
                + "(NULL, '" + h.getNombre() + "', "
                + "'" + h.getCiudad() + "', "
                + "'" + h.getPrecio_por_noche() + "')";
        con.ejecutar(insert);
        con.close();
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

    public List<Hotel> getHotel() throws SQLException {
        List<Hotel> lista = new ArrayList<>();

        String query = "SELECT * FROM hotel ORDER BY precio_por_noche DESC;";
        ResultSet rs = con.ejecutar(query);

        while (rs.next()) {

            Hotel hot = new Hotel();

            hot.setId(rs.getInt(1));
            hot.setNombre(rs.getString(2));
            hot.setCiudad(rs.getString(3));
            hot.setPrecio_por_noche(rs.getInt(4));

            lista.add(hot);
        }

        con.close();

        return lista;
    }

    public List<Hotel> getHoteles(String filtro) throws SQLException {
        List<Hotel> lista = new ArrayList<>();

        String query = "SELECT * FROM hotel WHERE(nombre LIKE '%" + filtro + "%' "
                + "OR ciudad LIKE '%" + filtro + "%')"
                + " ORDER BY precio_por_noche DESC;";

        ResultSet rs = con.ejecutar(query);

        while (rs.next()) {
            Hotel hot = new Hotel();

            hot.setId(rs.getInt(1));
            hot.setNombre(rs.getString(2));
            hot.setCiudad(rs.getString(3));
            hot.setPrecio_por_noche(rs.getInt(4));

            lista.add(hot);
        }
        con.close();
        return lista;
    }

    /*
  
     */
    public int contarHoteles() throws SQLException {
        int cont = 0;
        ResultSet rs = con.ejecutar("SELECT COUNT(0) FROM hotel");
        if (rs.next()) {
            cont = rs.getInt(1);
        }
        return cont;

    }

    public int precioPromedio() throws SQLException {
        int preP = 0;
        ResultSet rs = con.ejecutar("SELECT AVG(precio_por_noche) FROM hotel");
        if (rs.next()) {
            preP = rs.getInt(1);

        }
        return preP;
    }

    public String precioMenor() throws SQLException {
        String hotelBarato = null;
        ResultSet rs = con.ejecutar("SELECT nombre FROM hotel WHERE precio_por_noche = (SELECT MIN(precio_por_noche) FROM hotel)");
        if (rs.next()) {
            hotelBarato = rs.getString(1);
        }
        return hotelBarato;

    }

    public String precioMenorNombre() throws SQLException {
        String hotel = null;
        ResultSet rs = con.ejecutar("SELECT MIN(precio_por_noche) FROM hotel");
        if (rs.next()) {
            hotel = rs.getString(1);
        }
        return hotel;
    }

}
