/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeffr
 */
public class mantenimientoEvento implements ImantenimientoEvento {

    @Override
    public boolean crearEvento(Evento event) 
    {
         try 
        {
            CallableStatement cstm = Conexion.conectar().prepareCall("exec Insertar_Eventos ?,?,?,?,?");
            cstm.setString(1, event.getDireccion());
            cstm.setString(2, event.getNombre());
            cstm.setString(3, event.getFecha());
            cstm.setString(4, event.getTipo());
            cstm.registerOutParameter(5, java.sql.Types.INTEGER);
            
            cstm.execute();
            
            if(cstm.getInt(5)>0)
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
    public boolean actualizarEvento(int IdEvento, Evento event) 
    {
         try 
        {
            CallableStatement cstm = Conexion.conectar().prepareCall("exec Actualizar_Eventos ?,?,?,?,?,?");
            cstm.setInt(1, IdEvento);
            cstm.setString(2, event.getDireccion());
            cstm.setString(3, event.getNombre());
            cstm.setString(4, event.getFecha());
            cstm.setString(5, event.getTipo());
            cstm.registerOutParameter(6, java.sql.Types.INTEGER);
            
            cstm.execute();
            
            if(cstm.getInt(6)>0)
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
    public boolean eliminarEvento(int IdEvento) 
    {
        try
        {
          CallableStatement cstm = Conexion.conectar().prepareCall("exec Eliminar_Eventos ?,?");
          cstm.setInt(1,IdEvento);
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
