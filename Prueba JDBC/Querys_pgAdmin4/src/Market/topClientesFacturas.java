import java.sql.*;
public class topClientesFacturas {
    public static void main(String[] args) {

        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Market", "postgres", "bootcamp21");

            topClientesFacturas(c);
//         topClientesGasto(c);
//         topMonedas(c);
//         topProveedor(c);
            // topProductos(c);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public static void topClientesFacturas(Connection c) throws SQLException {
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT c.nombre || ' ' || c.apellido AS CLIENTE, " +
                     "COUNT(f.cliente_id) AS CANTIDAD_FACTURAS " +
                     "FROM factura f " +
                     "JOIN cliente c ON c.id = f.cliente_id " +
                     "GROUP BY c.nombre, c.apellido " +
                     "ORDER BY COUNT(f.cliente_id) DESC;")) {
            while (rs.next()) {
                System.out.println("Cliente: " + rs.getString("CLIENTE") +
                        ", Cantidad de Facturas: " + rs.getInt("CANTIDAD_FACTURAS"));
            }
        }
    }
}
