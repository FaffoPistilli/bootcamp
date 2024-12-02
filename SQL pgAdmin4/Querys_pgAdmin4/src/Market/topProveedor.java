import java.sql.*;
public class topProveedor {
    public static void main(String[] args) {

        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Market", "postgres", "bootcamp21");

//         topClientesFacturas(c);
//         topClientesGasto(c);
//         topMonedas(c);
         topProveedor(c);
//         topProductos(c);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public static void topProveedor(Connection c) throws SQLException {
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.proveedor_id, " +
                     "COUNT(*) AS cantidad_productos " +
                     "FROM producto p " +
                     "GROUP BY p.proveedor_id " +
                     "ORDER BY cantidad_productos DESC;")) {
            while (rs.next()) {
                System.out.println("Proveedor " + rs.getString("proveedor_id") +
                        ", Cantitad de Productos: " + rs.getDouble("cantidad_productos"));
            }
        }
    }
}