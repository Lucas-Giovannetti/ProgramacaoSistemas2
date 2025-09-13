import java.math.BigDecimal;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("(1) Listar todas as contas");
            System.out.println("(2) Buscar uma conta específica pelo número");
            System.out.println("(3) Criar uma nova conta");
            System.out.println("(4) Alterar o saldo de uma conta");
            System.out.println("(5) Apagar uma conta");
            System.out.println("(0) Sair");
            opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    listar();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    create();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
public static void listar() throws SQLException{
    System.out.println("Consulta de contas!");
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.qhkfhwoknmhahephugvm&password=QDfu4Lly3103NtKV";
        Connection c = DriverManager.getConnection(url);
        System.out.println("Conexão ok!");
        String sql = "SELECT * FROM CONTAS";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery();
        while (resultado.next()) {
            long nro = resultado.getLong("Nro_CONTA");
            double saldo = resultado.getDouble("Saldo");
            System.out.println("Número: " + nro + " - R$ " + saldo);
        }
        c.close();
}
public static void buscar() throws SQLException{
    System.out.println("Numero da conta?");
    long nro = Long.parseLong(System.console().readLine());
    String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.qhkfhwoknmhahephugvm&password=QDfu4Lly3103NtKV";
    Connection c = DriverManager.getConnection(url);
    String sql = "SELECT * FROM CONTAS where (nro_conta) =?";
    PreparedStatement stm = c.prepareStatement(sql);
    stm.setLong(1, nro);
    ResultSet resultado = stm.executeQuery();
    if (resultado.next()) {
        long numeroConta = resultado.getLong("nro_conta");
        double saldo = resultado.getDouble("saldo");
        System.out.println("Número: " + numeroConta + " - R$ " + saldo);
        } else {
            System.out.println("Nenhuma conta encontrada com o número: " + nro);
    }
    c.close();
}
public static void create() throws SQLException{
    System.out.println("Numero da conta?");
    long nro = Long.parseLong(System.console().readLine());
    System.out.println("Saldo da conta?");
    BigDecimal saldo = new BigDecimal(System.console().readLine());
    String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.qhkfhwoknmhahephugvm&password=QDfu4Lly3103NtKV";
    Connection c = DriverManager.getConnection(url);
    String sql = "INSERT into contas (nro_conta, saldo) values (?,?)";
    PreparedStatement stm = c.prepareStatement(sql);
    stm.setLong(1, nro);
    stm.setBigDecimal(2, saldo);
    c.close();
}
public static void update() throws SQLException{
    System.out.println("Numero da conta?");
    long nro = Long.parseLong(System.console().readLine());
    System.out.println("Saldo da conta?");
    BigDecimal saldo = new BigDecimal(System.console().readLine());
    String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.qhkfhwoknmhahephugvm&password=QDfu4Lly3103NtKV";
    Connection c = DriverManager.getConnection(url);
    String sql = "Update contas set saldo=? where nro_conta=?";
    PreparedStatement stm = c.prepareStatement(sql);
    stm.setLong(1, nro);
    stm.setBigDecimal(2, saldo);
    c.close();
}
public static void delete() throws SQLException{
    System.out.println("Numero da conta?");
    long nro = Long.parseLong(System.console().readLine());
    String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.qhkfhwoknmhahephugvm&password=QDfu4Lly3103NtKV";
    Connection c = DriverManager.getConnection(url);
    String sql = "delete from contas where nro_conta=?";
    PreparedStatement stm = c.prepareStatement(sql);
    stm.setLong(1, nro);
    c.close();
}
}