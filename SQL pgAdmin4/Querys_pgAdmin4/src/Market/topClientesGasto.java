import java.sql.*;
public class topClientesGasto {
    public static void main(String[] args) {

        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Market", "postgres", "bootcamp21");

//         topClientesFacturas(c);
         topClientesGasto(c);
//         topMonedas(c);
//         topProveedor(c);
//         topProductos(c);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public static void topClientesGasto(Connection c) throws SQLException {
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT c.nombre, c.apellido, " +
                     "SUM(fd.cantidad * p.precio) AS total_gastado " +
                     "FROM cliente c " +
                     "INNER JOIN factura f ON c.id = f.cliente_id " +
                     "INNER JOIN factura_detalle fd ON f.id = fd.factura_id " +
                     "INNER JOIN producto p ON fd.producto_id = p.id " +
                     "GROUP BY c.id, c.nombre, c.apellido " +
                     "ORDER BY total_gastado DESC;")) {
            while (rs.next()) {
                System.out.println("Cliente: " + rs.getString("nombre") + " " + rs.getString("apellido") +
                        ", Total Gastado: $" + rs.getDouble("total_gastado"));
            }
        }
    }
}
