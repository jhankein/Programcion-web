/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecbasedate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhan Kein
 */
public class ConexionBD {
    
     static Connection cn = null;
     static Statement st = null;
     static ResultSet rs = null;
    
    private static String servidor = "localhost";
    private static String nombreBd = "sampledb";
    private static String Usuario = "root";
    private static String clave = "root";
    
    
    public static void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://"+servidor+":3306/"+nombreBd;
            cn = DriverManager.getConnection(url,Usuario,clave);
            
        } catch (ClassNotFoundException ex){ex.printStackTrace();} catch (SQLException ex) {}{}
        
          if (cn != null)
              JOptionPane.showMessageDialog(null, "CONEXIÓN EXITOSA !!!!");
        }
    
    public static Object[][] leerdatosArray (String consulta){
        conectar();
        Object [][] filas = null;
        if (cn == null) {
            
        }

        try {
            
           st = cn.createStatement();
           rs = st.executeQuery(consulta);
           int numfilas =0;
           int numcolum = rs.getMetaData().getColumnCount();
           
            System.out.println("Lista de Usuarios");
            while (rs.next()) {
                numfilas++;
            }
            
            filas = new Object[numfilas][numcolum];
            rs.beforeFirst();
            int contadorTmp =0;
            while(rs.next()){
                
              filas[contadorTmp][0]=rs.getInt(1);
               filas[contadorTmp][1]=rs.getInt(2);
                filas[contadorTmp][2]=rs.getInt(3);
                 filas[contadorTmp][3]=rs.getInt(4);
                  filas[contadorTmp][4]=rs.getInt(5);
            }   contadorTmp ++;
            st.close();
            rs.close();

        } catch (SQLException e) {
        }
         return filas;
       
    }
}

