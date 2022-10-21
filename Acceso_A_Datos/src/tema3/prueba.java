package tema3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conexionUrl= "jdbc:mysql://localhost/test?" + 
					"user = pruebasJava&password=contraseña";
			Connection con = DriverManager.getConnection(conexionUrl);
			System.out.println(con.toString());
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
