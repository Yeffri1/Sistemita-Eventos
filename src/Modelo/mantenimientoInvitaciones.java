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
public class mantenimientoInvitaciones implements ImantenimientoInvitaciones {

    @Override
    public boolean enviarInvitacion(Invitaciones invitacion) 
    {
        try
        {
          CallableStatement cstm = Conexion.conectar().prepareCall("exec Insertar_Invitaciones ?,?,?");
          cstm.setInt(1, invitacion.getIdInvitado());
          cstm.setInt(2, invitacion.getIdEvento());
          cstm.registerOutParameter(3, java.sql.Types.INTEGER);
          
          cstm.execute();
          
          if(cstm.getInt(3)>0)
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

    @Override
    public boolean eliminarInvitacion(int idInvitacion) 
    {
         try
        {
          CallableStatement cstm = Conexion.conectar().prepareCall("exec Eliminar_Invitaciones ?,?");
          cstm.setInt(1,idInvitacion);
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
    @Override
    public boolean actualizarInvitacion(int idInvitacion, Invitaciones invitacion) 
    {
        
         try
        {
          CallableStatement cstm = Conexion.conectar().prepareCall("exec Actualizar_Invitaciones ?,?,?,?");
          cstm.setInt(1,idInvitacion);
          cstm.setInt(2, invitacion.getIdInvitado());
          cstm.setInt(3, invitacion.getIdEvento());
          cstm.registerOutParameter(4, java.sql.Types.INTEGER);
          
          cstm.execute();
          
          if(cstm.getInt(4)>0)
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
