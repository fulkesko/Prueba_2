package trivago.model.tableModel;

import java.util.List;
import trivago.model.Hotel;
import javax.swing.table.AbstractTableModel;

public class TMHoteles extends AbstractTableModel {

    private List<Hotel> lista;

    public TMHoteles(List<Hotel> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hotel ht = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return ht.getId();
            case 1:
                return ht.getNombre();
            case 2:
                return ht.getCiudad();
            default:
                return "$ " + ht.getPrecio_por_noche();

        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "Ciudad";
            default:
                return "Precio";
        }

    }
}
