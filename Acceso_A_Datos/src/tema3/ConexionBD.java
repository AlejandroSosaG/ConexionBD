package tema3;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
	  private static String servidor = "jdbc:mysql://dns11036.phdns11.es";
	    private static Connection connection;
	    private static Statement st = null;
	  public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(servidor,"ad2223","nervion");
	            if ( connection != null){
	                st = (Statement) connection.createStatement();
	                System.out.println("Conexión a base de datos test correcta ");
	                System.out.println(st.toString());

	                String []campos = {"Id int PRIMARY KEY AUTO_INCREMENT", "Nombre varchar(255)", "Apellidos varchar(255)", "Edad int"};
	                //crearTabla(st, "asosa", campos);
	                //insertarTabla(st);
	                //listado(st);
	                //listadoNombreApellido(st);
	                //listadoEdad(st);
	                //listadoNombre(st);
	                //listado5(st);
	                //listadomedia(st);
	                //listadoApellidos(st);
	                //listado8(st);
	                listado9(st);
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
	  
	  public static void listado9(Statement st) throws SQLException {
	    	String list = "SELECT Nombre, Apellidos FROM ad2223.asosa WHERE Edad>65";
			mostrar9(st, list);
		}
	    
	    public static void mostrar9(Statement st, String list) throws SQLException {
			ResultSet rs = st.executeQuery(list);
			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("Nombre") + " ,Apellidos: " + rs.getString("Apellidos"));
			}
		}

	    public static void crearTabla(Statement st, String tabla, String []campos) throws SQLException {
	            String sql = "DELETE from ad2223.asosa;";
//	            		String sql2="CREATE TABLE ad2223."+tabla+"(";
	            /*for(int i = 0; i < campos.length; i++){

	                if (i == campos.length - 1){
	                    sql += campos[i];
	                } else {
	                    sql += campos[i] + ",";
	                }
	            }
	            sql += ")";*/
	            System.out.println(sql);
	            ((java.sql.Statement) st).executeUpdate(sql);
	         //   ((java.sql.Statement) st).executeUpdate(sql2);
	    }
	    
	    public static void listado8(Statement st) throws SQLException {
	    	String list = "SELECT * FROM ad2223.asosa WHERE Edad BETWEEN 24 AND 32";
			mostrar8(st, list);
		}
	    
	    public static void mostrar8(Statement st, String list) throws SQLException {
			ResultSet rs = st.executeQuery(list);
			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("0N0ombre") + " ,Apellidos: " + rs.getString("Apellidos") + " ,Edad: " + rs.getString("Edad"));
			}
		}
	    
	    public static void listado(Statement st) throws SQLException {
			String list = "SELECT * FROM ad2223.asosa ORDER BY Edad;";
			mostrar(st, list);
		}
	    
	    public static void mostrar(Statement st, String list) throws SQLException {
			ResultSet rs = st.executeQuery(list);
			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("Nombre") + " ,Apellidos: " + rs.getString("Apellidos") + " ,Edad: " + rs.getString("Edad"));
			}
		}
	    
	    public static void listadoNombreApellido(Statement st) throws SQLException {
			String list2 = "SELECT Nombre, Apellidos FROM ad2223.asosa ORDER BY Apellidos";
			mostrarNomBreApellido(st, list2);
		}
	    
	    public static void mostrarNomBreApellido(Statement st, String list) throws SQLException {
			ResultSet rs = st.executeQuery(list);
			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("Nombre") + " ,Apellidos: " + rs.getString("Apellidos"));
			}
		}
	    
	    public static void listadoEdad(Statement st) throws SQLException {
	    	String list = "SELECT Nombre, Apellidos FROM ad2223.asosa WHERE Edad>30";
			mostrarEdad(st, list);
		}
	    
	    public static void mostrarEdad(Statement st, String list) throws SQLException {
			ResultSet rs = st.executeQuery(list);
			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("Nombre") + " ,Apellidos: " + rs.getString("Apellidos"));
			}
		}
	    
	    public static void listadoNombre(Statement st) throws SQLException {
	    	String list = "SELECT Nombre FROM ad2223.asosa WHERE Nombre LIKE('J%') ORDER BY Apellidos";
	    	mostrarNombre(st, list);
		}
	    public static void mostrarNombre(Statement st, String list) throws SQLException {
			ResultSet rs = st.executeQuery(list);
			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("Nombre"));
			}
		}
	    
	    public static void listado5(Statement st) throws SQLException {
	    	String list = "SELECT Nombre FROM ad2223.asosa WHERE Nombre LIKE 'C%' OR Apellidos LIKE 'A%' ORDER BY Edad Desc";
	    	mostrar5(st, list);
		}
	    public static void mostrar5(Statement st, String list) throws SQLException {
			ResultSet rs = st.executeQuery(list);
			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("Nombre"));
			}
		}
	    
	    public static void listadomedia(Statement st) throws SQLException {
	    	String list = "SELECT AVG(Edad) AS 'Media' FROM ad2223.asosa";
	    	mostrarMedia(st, list);
		}
	    public static void mostrarMedia(Statement st, String list) throws SQLException {
			ResultSet rs = st.executeQuery(list);
			while (rs.next()) {
				System.out.println("Media de edad: " + rs.getString("Media"));
			}
		}
	    
	    public static void listadoApellidos(Statement st) throws SQLException {
	    	String list = "SELECT Apellidos FROM ad2223.asosa WHERE Apellidos LIKE('%oh%') OR Apellidos LIKE '%ma%'";
	    	mostrarApellidos(st, list);
		}
	    public static void mostrarApellidos(Statement st, String list) throws SQLException {
			ResultSet rs = st.executeQuery(list);
			while (rs.next()) {
				System.out.println("Apellidos: " + rs.getString("Apellidos"));
			}
		}
	    
	    public static void insertarTabla(Statement st) throws SQLException {
	    	String ins="insert into ad2223.asosa(Nombre, Apellidos, Edad) values ('Windham', 'Truckell', 23),"
	    			+ "  ('Maiga', 'Caddens', 57),"
	    			+ "  ('Benedikt', 'Ferry', 52),"
	    			+ "  ('Jo', 'Nelissen', 64),"
	    			+ "  ('Ediva', 'Keech', 50),"
	    			+ "  ('Dianemarie', 'De Ferraris', 31),"
	    			+ "  ('Tracey', 'Le Friec', 47),"
	    			+ "  ('Alvy', 'Ball', 61),"
	    			+ "  ('Grata', 'Eyers', 84),"
	    			+ "  ('Jesse', 'Albrecht', 58),"
	    			+ "  ('Porty', 'Bunten', 71),"
	    			+ "  ('Cleon', 'Malham', 14),"
	    			+ "  ('Tresa', 'Bamsey', 78),"
	    			+ "  ('Myrtie', 'Gruszka', 29),"
	    			+ "  ('Marja', 'Gimson', 42),"
	    			+ "  ('Faustina', 'Eversfield', 49),"
	    			+ "  ('Calypso', 'Pipkin', 70),"
	    			+ "  ('Patrice', 'Gremain', 54),"
	    			+ "  ('Shelley', 'Kief', 66),"
	    			+ "  ('Gil', 'Ballham', 66),"
	    			+ "  ('Starla', 'Bett', 72),"
	    			+ "  ('Udall', 'Burdus', 96),"
	    			+ "  ('Elizabeth', 'Boundley', 28),"
	    			+ "  ('Eliot', 'Ballentime', 81),"
	    			+ "  ('Raynor', 'Simonyi', 40),"
	    			+ "  ('Edmund', 'Cuesta', 19),"
	    			+ "  ('Stephi', 'Chartman', 64),"
	    			+ "  ('Rafe', 'Vaney', 64),"
	    			+ "  ('Paddie', 'Pach', 79),"
	    			+ "  ('Dennis', 'Frangleton', 65),"
	    			+ "  ('Tim', 'Norgan', 92),"
	    			+ "  ('Trixi', 'Simo', 98),"
	    			+ "  ('Clarance', 'Ellerington', 81),"
	    			+ "  ('Leilah', 'Poser', 61),"
	    			+ "  ('Odelia', 'Robion', 69),"
	    			+ "  ('Enrichetta', 'Cammis', 12),"
	    			+ "  ('Allissa', 'Klemke', 50),"
	    			+ "  ('Xenos', 'Brannan', 36),"
	    			+ "  ('Pammie', 'McEntagart', 97),"
	    			+ "  ('Ario', 'Clew', 51),"
	    			+ "  ('Nichole', 'Gabbitis', 58),"
	    			+ "  ('Francois', 'Vlasin', 52),"
	    			+ "  ('Tally', 'Goaks', 40),"
	    			+ "  ('Antonio', 'McQuaide', 82),"
	    			+ "  ('Sydney', 'McVitty', 65),"
	    			+ "  ('Ella', 'Readitt', 60),"
	    			+ "  ('Reyna', 'Bladder', 96),"
	    			+ "  ('Melania', 'Ambrogini', 20),"
	    			+ "  ('Don', 'Attenbrow', 55),"
	    			+ "  ('Cyndi', 'Vaillant', 18),"
	    			+ "  ('Wenda', 'Meriet', 18),"
	    			+ "  ('Keefer', 'Luggar', 51),"
	    			+ "  ('Sashenka', 'Tabbernor', 93),"
	    			+ "  ('Ginny', 'McAvinchey', 49),"
	    			+ "  ('Tabbie', 'Cullip', 15),"
	    			+ "  ('Ezra', 'Jankovic', 31),"
	    			+ "  ('Alena', 'MacGinley', 87),"
	    			+ "  ('Boris', 'Trengrove', 41),"
	    			+ "  ('Chick', 'Thain', 35),"
	    			+ "  ('Keelia', 'Florez', 50),"
	    			+ "  ('Ossie', 'Waliszek', 74),"
	    			+ "  ('Karole', 'Lesper', 31),"
	    			+ "  ('Durante', 'McBrady', 31),"
	    			+ "  ('Stefania', 'Girardengo', 67),"
	    			+ "  ('Gypsy', 'Povall', 48),"
	    			+ "  ('Hayden', 'Borrel', 45),"
	    			+ "  ('Tirrell', 'Renon', 84),"
	    			+ "  ('Lena', 'Odam', 75),"
	    			+ "  ('Phaedra', 'Jone', 82),"
	    			+ "  ('Corinna', 'Haddrill', 50),"
	    			+ "  ('Hubert', 'Maskew', 66),"
	    			+ "  ('Angeline', 'Helversen', 51),"
	    			+ "  ('Christoper', 'Kenvin', 15),"
	    			+ "  ('Wait', 'Cattell', 98),"
	    			+ "  ('Marcus', 'Dilgarno', 55),"
	    			+ "  ('Devonna', 'Barlee', 20),"
	    			+ "  ('Abeu', 'Hitter', 40),"
	    			+ "  ('Florian', 'Showers', 62),"
	    			+ "  ('Phyllida', 'Dyneley', 26),"
	    			+ "  ('Clemens', 'Hasell', 50),"
	    			+ "  ('Josy', 'Gronno', 56),"
	    			+ "  ('Alano', 'Faill', 100),"
	    			+ "  ('Ellsworth', 'O''Flannery', 36),"
	    			+ "  ('Ernest', 'Zuanelli', 23),"
	    			+ "  ('Selig', 'Kernock', 59),"
	    			+ "  ('Welsh', 'Pelham', 40),"
	    			+ "  ('Stephen', 'Gerty', 70),"
	    			+ "  ('Nixie', 'Drysdell', 28),"
	    			+ "  ('Yetty', 'Bonafacino', 15),"
	    			+ "  ('Cari', 'Enion', 18),"
	    			+ "  ('Paxon', 'Mallard', 28),"
	    			+ "  ('Tremain', 'Kumar', 95),"
	    			+ "  ('Jan', 'Chiddy', 92),"
	    			+ "  ('Robbin', 'Ricardet', 89),"
	    			+ "  ('Urbain', 'Muggleton', 26),"
	    			+ "  ('Adolpho', 'Rundall', 37),"
	    			+ "  ('Dorise', 'Farrall', 30),"
	    			+ "  ('Jud', 'Ebbles', 15),"
	    			+ "  ('Deni', 'Varley', 32),"
	    			+ "  ('Dillon', 'Tombling', 71),"
	    			+ "  ('August', 'Dimitrov', 22),"
	    			+ "  ('Darb', 'Cady', 20),"
	    			+ "  ('Darrick', 'Dearle-Palser', 23),"
	    			+ "  ('Hildagarde', 'Durno', 63),"
	    			+ "  ('Phylys', 'Jedrachowicz', 99),"
	    			+ "  ('Winifred', 'Ainslie', 39),"
	    			+ "  ('Gilbertina', 'Pycock', 65),"
	    			+ "  ('Ryann', 'Scudder', 44),"
	    			+ "  ('Jenelle', 'Rosenzveig', 70),"
	    			+ "  ('Granthem', 'Emmer', 75),"
	    			+ "  ('Camala', 'Banstead', 56),"
	    			+ "  ('Gavra', 'Gage', 16),"
	    			+ "  ('Richart', 'Rennicks', 85),"
	    			+ "  ('Anatollo', 'de Castelain', 75),"
	    			+ "  ('Emory', 'Fouracre', 63),"
	    			+ "  ('Mignonne', 'Iacobucci', 51),"
	    			+ "  ('Jeniece', 'Appleton', 86),"
	    			+ "  ('Iggy', 'Korting', 98),"
	    			+ "  ('Patin', 'Thickens', 32),"
	    			+ "  ('Innis', 'Pontain', 30),"
	    			+ "  ('Kaia', 'Gingold', 33),"
	    			+ "  ('Germana', 'Chritchley', 68),"
	    			+ "  ('Kip', 'Rittelmeyer', 81),"
	    			+ "  ('Vick', 'Colecrough', 27),"
	    			+ "  ('Patrizio', 'Axel', 42),"
	    			+ "  ('Dawna', 'Bosher', 20),"
	    			+ "  ('Oriana', 'Antonijevic', 79),"
	    			+ "  ('Jorgan', 'Over', 88),"
	    			+ "  ('Lorrayne', 'Calltone', 34),"
	    			+ "  ('Junette', 'Palin', 100),"
	    			+ "  ('Lancelot', 'Drewitt', 41),"
	    			+ "  ('Dionisio', 'Moiser', 93),"
	    			+ "  ('Hana', 'Thrussell', 58),"
	    			+ "  ('Thelma', 'Gorry', 65),"
	    			+ "  ('Timothy', 'Trimming', 63),"
	    			+ "  ('Britni', 'Boughey', 38),"
	    			+ "  ('Montgomery', 'Southwell', 46),"
	    			+ "  ('Cassius', 'Smitheman', 73),"
	    			+ "  ('Vanya', 'Poskitt', 74),"
	    			+ "  ('Kelli', 'Chudleigh', 32),"
	    			+ "  ('Julienne', 'Dewes', 46),"
	    			+ "  ('Rocky', 'Pegg', 21),"
	    			+ "  ('Shirlee', 'Boyes', 89),"
	    			+ "  ('Pernell', 'Worthington', 59),"
	    			+ "  ('Layla', 'Carbry', 17),"
	    			+ "  ('Elbertine', 'Neal', 67),"
	    			+ "  ('Carena', 'Marusyak', 81),"
	    			+ "  ('Elizabeth', 'Brooking', 74),"
	    			+ "  ('Kipp', 'Morrad', 20),"
	    			+ "  ('Delilah', 'Carpmile', 34),"
	    			+ "  ('Fredrick', 'Dumphrey', 31),"
	    			+ "  ('Ferd', 'Careless', 97),"
	    			+ "  ('Annora', 'Ladbrooke', 90),"
	    			+ "  ('Barn', 'Alvis', 67),"
	    			+ "  ('Cindie', 'Whitley', 72),"
	    			+ "  ('Miranda', 'Shoebridge', 32),"
	    			+ "  ('Dottie', 'Geffinger', 83),"
	    			+ "  ('Carine', 'Swarbrigg', 30),"
	    			+ "  ('Alysia', 'Agg', 63),"
	    			+ "  ('Sinclair', 'Strathman', 94),"
	    			+ "  ('Briggs', 'Espine', 74),"
	    			+ "  ('Geoffrey', 'McLucky', 55),"
	    			+ "  ('Benedicta', 'Shobrook', 50),"
	    			+ "  ('Fredi', 'Wiggall', 63),"
	    			+ "  ('Clemens', 'Branni', 59),"
	    			+ "  ('Elroy', 'Rampton', 55),"
	    			+ "  ('Umberto', 'Harbin', 24),"
	    			+ "  ('Leisha', 'Pottes', 70),"
	    			+ "  ('Ivor', 'Woolatt', 37),"
	    			+ "  ('Dawn', 'Lilleman', 78),"
	    			+ "  ('Kele', 'Bonnesen', 14),"
	    			+ "  ('Mab', 'Whitwell', 28),"
	    			+ "  ('Edgard', 'Lehmann', 97),"
	    			+ "  ('Wenonah', 'Faircliff', 35),"
	    			+ "  ('Man', 'Lainge', 24),"
	    			+ "  ('Bibby', 'Ginn', 32),"
	    			+ "  ('Imojean', 'Cammomile', 64),"
	    			+ "  ('Bordie', 'Kinnie', 71),"
	    			+ "  ('Wallache', 'Andraud', 55),"
	    			+ "  ('Ruth', 'Cohen', 48),"
	    			+ "  ('Huntley', 'Gallichiccio', 61),"
	    			+ "  ('Shandie', 'Hounsom', 28),"
	    			+ "  ('Thane', 'Tewkesbury', 64),"
	    			+ "  ('Carla', 'Ballinger', 26),"
	    			+ "  ('Jared', 'Haysman', 72),"
	    			+ "  ('Paige', 'Neeve', 87),"
	    			+ "  ('Tommie', 'Gronou', 46),"
	    			+ "  ('Diann', 'Cattellion', 86),"
	    			+ "  ('Rena', 'Heskins', 24),"
	    			+ "  ('Bryn', 'Senett', 97),"
	    			+ "  ('Kellsie', 'Burnie', 79),"
	    			+ "  ('Pattie', 'Impey', 34),"
	    			+ "  ('Clarance', 'Sawkin', 100),"
	    			+ "  ('Silvie', 'Balaison', 95),"
	    			+ "  ('Veronike', 'Pickworth', 68),"
	    			+ "  ('Omero', 'Mc Pake', 57),"
	    			+ "  ('Riccardo', 'Soutter', 58),"
	    			+ "  ('Les', 'Nobbs', 57),"
	    			+ "  ('Barde', 'O''Fogarty', 26),"
	    			+ "  ('Royce', 'Lomath', 22);";
	    	st.executeUpdate(ins);
		}
	}
