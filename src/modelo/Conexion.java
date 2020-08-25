package modelo;

import java.sql.*;

public class Conexion {

	private final  String usr="root";
	private final  String pass="root";
	private final  String db="bd_users";
	private final  String url="jdbc:mysql://localhost/" + db;
	private static Connection conn= null;
	
public  Conexion()
{
	
  try{
	Class.forName("com.mysql.jdbc.Driver");
	
	conn= DriverManager.getConnection(url,usr,pass);
	System.out.println("Conexion a base de datos");
     
   }  
  
  catch(ClassNotFoundException | SQLException e) {
	System.out.println("No se establecio la conexion a base de datos");
   }

	
	
}

public static Connection getConexion() {
	if(conn==null) {
		
		Conexion cnx = new Conexion();
	}
	return conn;
}


public static void Disconnect() {
	try {
		if(conn!=null) {
			conn= null;
			System.out.println("Se desconecto de la base de datos");
		}
	}catch(Exception e) {
		System.out.println("No se realizo la desconexion de la base de datos");
	}
}
		
	
}
