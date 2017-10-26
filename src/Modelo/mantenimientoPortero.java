/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yeffr
 */
public class mantenimientoPortero implements ImantenimientoPersona{

    
    @Override
    public boolean crearPersona(Persona p) {
        
        Portero portero =(Portero)p;
       
        try 
        {
            CallableStatement cstm = Conexion.conectar().prepareCall("exec Insertar_Usuario ?,?,?,?,?,?,?");
            cstm.setString(1, portero.Nombre);
            cstm.setString(2, portero.Apellido);
            cstm.setString(3,portero.Direccion);
            cstm.setString(4,portero.Usuario); 
            cstm.setString(5,portero.Password);
            cstm.setString(6,"Portero");
            cstm.registerOutParameter(7, java.sql.Types.INTEGER);
            
            cstm.execute();
            
            if(cstm.getInt(7)>0)
            {
                cstm.close();
                Conexion.conectar().close();
                return true;
            }
            
            
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(mantenimientoPortero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }

    @Override
    public boolean actualizarPersona(int personaId,Persona p) {
        
        Portero portero =(Portero)p;
       try 
        {
            CallableStatement cstm = Conexion.conectar().prepareCall("exec Actualizar_Usuario ?,?,?,?,?,?,?,?");
            cstm.setInt(1,personaId);
            cstm.setString(2, portero.Nombre);
            cstm.setString(3, portero.Apellido);
            cstm.setString(4,portero.Direccion);
            cstm.setString(5,portero.Usuario); 
            cstm.setString(6,portero.Password);
            cstm.setString(7,"Portero");
            cstm.registerOutParameter(8, java.sql.Types.INTEGER);
            
            cstm.execute();
            
            if(cstm.getInt(8)>0)
            {
                cstm.close();
                Conexion.conectar().close();
                return true;
            }
            
            
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(mantenimientoPortero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
    }

    @Override
    public boolean eliminarPersona(int personaId) {
        
        try
        {
          CallableStatement cstm = Conexion.conectar().prepareCall("exec Eliminar_Personas ?,?");
          cstm.setInt(1,personaId);
          cstm.registerOutParameter(2, java.sql.Types.INTEGER);
          
          cstm.execute();
          
          if(cstm.getInt(2)>0)
          {
              cstm.close();
              Conexion.conectar().close();
              return true;
          }
          
          
        }
        catch(SQLException ex)
        {
            Logger.getLogger(mantenimientoPortero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false; 
    }
    
}
