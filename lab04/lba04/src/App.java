import java.math.BigDecimal;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Consulta de contas!");
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.qhkfhwoknmhahephugvm&password=QDfu4Lly3103NtKV";
        Connection c = DriverManager.getConnection(url);
        System.out.println("Conexão ok!");
        String sql = "SELECT * FROM CONTAS";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery();
        create();
        update();
        while (resultado.next()) {
            long nro = resultado.getLong("Nro_CONTA");
            double saldo = resultado.getDouble("Saldo");
            System.out.println("Número: " + nro + " - R$ " + saldo);
        }
        c.close();
        delete();
    }
public static void create() throws SQLException{
    System.out.println("Numero da conta?");
    long nro = Long.parseLong(System.console().readLine());
    System.out.println("Saldo da conta?");
    BigDecimal saldo = new BigDecimal(System.console().readLine());
    String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.qhkfhwoknmhahephugvm&password=QDfu4Lly3103NtKV";
    Connection c = DriverManager.getConnection(url);
    System.out.println("Conexão ok!");
    String sql = "INSERT into contas (nro_conta, saldo) values (150, 246.98)";
    PreparedStatement stm = c.prepareStatement(sql);
    stm.setLong(1, nro);
    stm.setBigDecimal(2, saldo);
    int ret = stm.executeUpdate();
    c.close();
}
public static void update() throws SQLException{
    System.out.println("Numero da conta?");
    long nro = Long.parseLong(System.console().readLine());
    System.out.println("Saldo da conta?");
    BigDecimal saldo = new BigDecimal(System.console().readLine());
    String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.qhkfhwoknmhahephugvm&password=QDfu4Lly3103NtKV";
    Connection c = DriverManager.getConnection(url);
    System.out.println("Conexão ok!");
    String sql = "Update contas set saldo=? where nro_conta=?";
    PreparedStatement stm = c.prepareStatement(sql);
    stm.setLong(1, nro);
    stm.setBigDecimal(2, saldo);
    int ret = stm.executeUpdate();
    c.close();
}
public static void delete() throws SQLException{
    System.out.println("Numero da conta?");
    long nro = Long.parseLong(System.console().readLine());
    String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.qhkfhwoknmhahephugvm&password=QDfu4Lly3103NtKV";
    Connection c = DriverManager.getConnection(url);
    System.out.println("Conexão ok!");
    String sql = "delete from contas where nro_conta=?";
    PreparedStatement stm = c.prepareStatement(sql);
    stm.setLong(1, nro);
    int ret = stm.executeUpdate();
    c.close();
}
}