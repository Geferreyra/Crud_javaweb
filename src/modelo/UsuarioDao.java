package modelo;

import java.sql.*;
import java.util.*;
import java.text.*;

public class UsuarioDao{
	
	static Connection currentCon= null;
	static ResultSet rs= null;

	//Cambiar nombres de la tabla y de los campos
	
	 //AGREGAR METODOS DAO
	public static UsuarioVO login(UsuarioVO user) {
		
		Statement stmt = null;
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		String searchQuery=
				"select * from usuarios where username='"
		           
						+username
						+"' AND password ='"
						+password
						+"'";
		
		System.out.println("User: " + username);
		System.out.println("Pass: "+ password);
		System.out.println("Query: "+ searchQuery);
		
		
     try {
    	 
    	currentCon = Conexion.getConexion();
    	 
    	stmt= currentCon.createStatement();
    	rs= stmt.executeQuery(searchQuery);
    	
    	
    	boolean more= rs.next();
    	if(!more) {
    		
    		System.out.println("Sorry, no estas registrado! "
    				+ "Por favor registrate primero");
    		
    		user.setValid(false);
    		
    	}
    	
    	else if(more) {
    		
    		String firstName = rs.getString("firstname");
    		String lastName= rs.getString("lastname");
    		
    		System.out.println("Welcome " + firstName);
    		user.setFirstName(firstName);
    		user.setLastName(lastName);
    		user.setValid(true);
    		
    		
    	}
    
     
     }
     
     catch( Exception e) {
    	 
    	 System.out.println("Log in failed: Review Exception");
    	 
    	 
     }
     
     
     finally {
    	 
    	 
    	 if(rs!=null) {
     
    	 try {
    		 rs.close();
    		 
    	 }catch(Exception e) {}
    	 rs= null;
    	 
    	 }
     
     if(stmt!= null) {
    	 
    	 try {
    		 
    		 stmt.close();
    	 }catch(Exception e) {}
    	 
    	 stmt= null;
    	 
     }
     
     
     if(currentCon!=null) {
    	 
    	 try {
    		 currentCon.close();
    	 }catch(Exception e) {}
    	 
    	 currentCon = null;
     }
     
     
     }
     	
		
		return user;
		
	}
	
	public static int save(UsuarioVO user) throws SQLException {
		int status=0;
		
		try {
		   currentCon= Conexion.getConexion();
		   PreparedStatement ps= currentCon.prepareStatement("insert into usuarios "
		   		+ "(firstname,lastname,username,email,password)values(?,?,?,?,?)");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			
			status= ps.executeUpdate();
			
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		finally{
			
		Conexion.Disconnect();
		}
		
		
		return status;
	}
	
	public static int update(UsuarioVO user) {
		int status= 0;
		
		try {
			currentCon=Conexion.getConexion();
			PreparedStatement ps=currentCon.prepareStatement("update employees set FirstName=?,LastName=?,username=?,passowrd=? where idUser=?");
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setInt(5, user.getId());
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return status;
		
		
		
	}
	
	
	
	
	
	
		
}
