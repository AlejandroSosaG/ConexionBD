package tema3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class prueba {
	private static String servidor = "jdbc:mysql://dns11036.phdns11.es";
	private static Statement st = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(servidor, "asosa", "asosa");
			if(con!=null) {
				st = con.createStatement();
				System.out.println("Conexión a base de datos test correscta");
				System.out.println(st.toString());
			}else System.out.println("Conexión fallida");
			//cuentaSQL(st);
			con.close();
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void cuentaSQL(Statement st) throws SQLException {
		String contraseña = "SET PASSWORD FOR 'asosa'@'%' = password('asosa')";
		st.executeUpdate(contraseña);
	}

}
