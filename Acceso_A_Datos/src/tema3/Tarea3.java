package tema3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Tarea3 {

	private static String servidor = "jdbc:mysql://dns11036.phdns11.es";
    private static Connection connection;
    private static Statement st = null;
    public static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
	  conectar();
	  String []player = {"idPlayer INT PRIMARY KEY", "Nick VARCHAR(45)", "password VARCHAR(128)", "email VARCHAR(100)"};
      String []compras = {"idCompra INT PRIMARY KEY", "idPlayer INT", "idGames INT", "cosa VARCHAR(25)", "Precio DECIMAL(6,2)", "FechaCompra DATE"};
      String []games= {"idGames INT", "Nombre VARCHAR(45)", "tiempoJugado TIME"};
      //crearTablas(st, "Games", games);
    }
  public static void conectar() {
	  try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          connection = DriverManager.getConnection(servidor,"asosa","asosa");
          if ( connection != null){
              st = (Statement) connection.createStatement();
              System.out.println("Conexión a base de datos test correcta ");
              System.out.println(st.toString());
          }
          else {
              System.out.println("Conexión fallida");
          }
          connection.close();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }catch (SQLException e){
          e.printStackTrace();
      }
}
  public static void crearTablas(Statement st, String tabla, String []campos) throws SQLException {
      //String sql2 = "DELETE from ad2223_asosa." + tabla + ";";
      String sql="CREATE TABLE ad2223_asosa." + tabla +"(";
      for(int i = 0; i < campos.length; i++){

          if (i == campos.length - 1){
              sql += campos[i];
          } else {
              sql += campos[i] + ",";
          }
      }
      sql += ")";
      System.out.println(sql);
      ((java.sql.Statement) st).executeUpdate(sql);
      //((java.sql.Statement) st).executeUpdate(sql2);
}
  public static void insertar() {
	
}
  public static void listarPlayer(Connection con) throws SQLException {
	  PreparedStatement ps = connection.prepareStatement("SELECT * from ad2223_asosa.Player");
	  ResultSet rs = ps.executeQuery();
  	while(rs.next()) {
  		System.out.println("idPlayer: " + rs.getString("idPlayer") + " Nick: " + rs.getString("Nick") + 
  				" password: " + rs.getString("password") + " email: " + rs.getString("email"));
  	}
}
  public static void listarCompras(Connection con) throws SQLException {
	  PreparedStatement ps = connection.prepareStatement("SELECT * from ad2223_asosa.Compras");
	  ResultSet rs = ps.executeQuery();
  	while(rs.next()) {
  		System.out.println("idCompra: " + rs.getString("idCompra") + " idPlayer: " + rs.getString("idPlayer") + " idGames: " + rs.getString("idGames") +
  				" cosa: " + rs.getString("cosa") + " precio: " + rs.getString("precio") + " FechaCompra: " + rs.getString("FechaCompra"));
  	}
}
  public static void listarGames(Connection con) throws SQLException {
	  PreparedStatement ps = connection.prepareStatement("SELECT * from ad2223_asosa.Games");
	  ResultSet rs = ps.executeQuery();
  	while(rs.next()) {
  		System.out.println("idGames: " + rs.getString("idGames") + " Nombre: " + rs.getString("Nombre") + 
  				" tiempoJugado: " + rs.getString("tiempoJugado"));
  	}
}
}
