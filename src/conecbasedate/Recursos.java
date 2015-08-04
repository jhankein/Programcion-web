/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecbasedate;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sun.java2d.d3d.D3DRenderQueue;

/**
 *
 * @author Jhan Kein
 */
public class Recursos {
    

    
 void MostrarDatos (String consulta) {
     
   String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "secret";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "SELECT * FROM Users";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			int count = 0;
			
			while (result.next()){
				String name = result.getString(2);
				String pass = result.getString(3);
				String fullname = result.getString("fullname");
				String email = result.getString("email");
				
				String output = "User #%d: %s - %s - %s - %s";
				System.out.println(String.format(output, ++count, name, pass, fullname, email));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
     
}
 
 


public void Insertar (int id,String user,String pass, String full, String email){
String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "root";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "INSERT INTO users (user_id,username, password, fullname, email) VALUES (?, ?, ?, ?,?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, user);
			statement.setString(3, pass);
			statement.setString(4, full);
			statement.setString(5, email);
                        
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
	             JOptionPane.showMessageDialog(null,"Un nuevo usuario a sido insertado!");
			}
                       
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}

public void Eliminar (int id){
String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "root";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "DELETE FROM users WHERE user_id=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1,id);
			
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
               JOptionPane.showMessageDialog(null,"Se ha eliminado un usuario!");

			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
}

public void Actualizar (){
String dbURL = "jdbc:mysql://localhost:3306/sampledb";
		String username = "root";
		String password = "root";

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "UPDATE users SET id_user =? password=?, fullname=?, email=? WHERE username=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "123456789");
			statement.setString(2, "William Henry Bill Gates");
			statement.setString(3, "bill@gatesfoundation.org");
			statement.setString(4, "bill");

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
	          JOptionPane.showMessageDialog(null,"Se ha actualizado un usuario!");

			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

 

}