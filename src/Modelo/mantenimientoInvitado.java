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
public class mantenimientoInvitado implements ImantenimientoPersona {

    @Override
    public boolean crearPersona(Persona p) 
    {
        Invitado invitado = (Invitado)p;
        
         try 
        {
            CallableStatement cstm = Conexion.conectar().prepareCall("exec Insertar_Invitado ?,?,?,?,?,?");
            cstm.setString(1, invitado.Nombre);
            cstm.setString(2, invitado.Apellido);
            cstm.setString(3,invitado.Direccion);
            cstm.setString(4, invitado.getSexo());
            cstm.setString(5, invitado.getEmail());
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
    public boolean actualizarPersona(int personaId, Persona p) 
    {
        Invitado invitado = (Invitado)p;
        try 
        {
            CallableStatement cstm = Conexion.conectar().prepareCall("exec Actualizar_Invitado ?,?,?,?,?,?,?");
            cstm.setInt(1,personaId);
            cstm.setString(2, invitado.Nombre);
            cstm.setString(3, invitado.Apellido);
            cstm.setString(4,invitado.Direccion);
            cstm.setObject(5, invitado.getSexo());
            cstm.setString(6, invitado.getEmail());
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
    public boolean eliminarPersona(int personaId) 
    {
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
