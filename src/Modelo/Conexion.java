/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeffr
 */
public class Conexion {
    
    public static Connection conectar()
    {
        Connection cn = null;
      try
       {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=SistemaEventos;integratedSecurity=true;");
        System.out.print("Conectado");
        
        
        }
        catch(SQLException ex)
        {
            System.out.print(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       return cn;     
    }
    
}
