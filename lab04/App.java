import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Consulta de contas!");
        String url = "postgresql://postgres:[Db@40418]@db.qhkfhwoknmhahephugvm.supabase.co:5432/postgres";
        Connection c = DriverManager.getConnection(url);
        System.out.println("Conexão ok!");
        String sql = "SELECT * FROM Contas";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery();
        while (resultado.next()) {
            long nro = resultado.getLong("Cod");
            double saldo = resultado.getDouble("Saldo");
            System.out.println("Número: " + nro + " - R$ " + saldo);
        }
        c.close();
    }
}