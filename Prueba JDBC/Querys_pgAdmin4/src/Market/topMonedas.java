import java.sql.*;

public class topMonedas {

    public static void main(String[] args) {

        Connection c = null;

        try {

            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Market", "postgres", "bootcamp21");

//         topClientesFacturas(c);
//         topClientesGasto(c);
         topMonedas(c);
//         topProveedor(c);
//         topProductos(c);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Opened database successfully");

    }

    public static void topMonedas(Connection c) throws SQLException {

        try (Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT m.nombre AS moneda, " +
                     "COUNT(*) AS monedas_mas_utilizadas " +
                     "FROM factura f " +
                     "INNER JOIN moneda m ON f.moneda_id = m.id " +
                     "GROUP BY m.nombre " +
                     "ORDER BY monedas_mas_utilizadas DESC;")) {

            while (rs.next()) {
                System.out.println("Moneda: " + rs.getString("moneda") +
                        ", Cantidad de monedas más utilizadas: " + rs.getInt("monedas_mas_utilizadas"));
            }

        }

    }

}