import java.sql.*;
public class topProductos {
    public static void main(String[] args) {

        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Market", "postgres", "bootcamp21");

//         topClientesFacturas(c);
//         topClientesGasto(c);
//         topMonedas(c);
//         topProveedor(c);
         topProductos(c);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public static void topProductos(Connection c) throws SQLException {
        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.id, p.nombre, " +
                     "SUM(fd.cantidad) AS total_vendido " +
                     "FROM factura_detalle fd " +
                     "INNER JOIN producto p ON fd.producto_id = p.id " +
                     "GROUP BY p.id, p.nombre " +
                     "ORDER BY total_vendido DESC;")) {
            while (rs.next()) {
                System.out.println("Producto " + rs.getString("id") + " " + rs.getString("nombre") +
                        ", TOTAL Vendido " + rs.getDouble("total_vendido"));
            }
        }
    }
}