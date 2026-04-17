package Modelo;

import Controlador.TipoPuesto;
import Controlador.clsBitacora;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoPuestoDAO {

    private static final String SQL_SELECT =
            "SELECT id_tipo_puesto, nombre_puesto, salario FROM tipo_puesto";

    private static final String SQL_INSERT =
            "INSERT INTO tipo_puesto (nombre_puesto, salario) VALUES(?, ?)";

    private static final String SQL_UPDATE =
            "UPDATE tipo_puesto SET nombre_puesto=?, salario=? WHERE id_tipo_puesto=?";

    private static final String SQL_DELETE =
            "DELETE FROM tipo_puesto WHERE id_tipo_puesto=?";

    private static final String SQL_SELECT_ID =
            "SELECT id_tipo_puesto, nombre_puesto, salario FROM tipo_puesto WHERE id_tipo_puesto=?";


    // Métodos CRUD para TipoPuesto
    public List<TipoPuesto> obtenerTipoPuestos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TipoPuesto> lista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                TipoPuesto tp = new TipoPuesto();
                tp.setId_tipo_puesto(rs.getInt("id_tipo_puesto"));
                tp.setNombre_puesto(rs.getString("nombre_puesto"));
                tp.setSalario(rs.getDouble("salario"));
                lista.add(tp);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return lista;
    }

    public int insertarTipoPuesto(TipoPuesto tipoPuesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, tipoPuesto.getNombre_puesto());
            stmt.setDouble(2, tipoPuesto.getSalario());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizarTipoPuesto(TipoPuesto tipoPuesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, tipoPuesto.getNombre_puesto());
            stmt.setDouble(2, tipoPuesto.getSalario());
            stmt.setInt(3, tipoPuesto.getId_tipo_puesto());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int eliminarTipoPuesto(TipoPuesto tipoPuesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, tipoPuesto.getId_tipo_puesto());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public TipoPuesto obtenerTipoPuestoPorId(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TipoPuesto tipoPuesto = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                tipoPuesto = new TipoPuesto();
                tipoPuesto.setId_tipo_puesto(rs.getInt("id_tipo_puesto"));
                tipoPuesto.setNombre_puesto(rs.getString("nombre_puesto"));
                tipoPuesto.setSalario(rs.getDouble("salario"));
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return tipoPuesto;
    }
}
