/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeffr
 */
public class mantenimientoVisita implements ImantenimientoVisita{

    @Override
    public boolean registrarVisita(Visita visit) 
    {
        try 
        {
            CallableStatement cstm = Conexion.conectar().prepareCall("exec Insertar_Visitas ?,?");
            cstm.setInt(1, visit.IdInvitacion);
            cstm.registerOutParameter(2, java.sql.Types.INTEGER);
            
            cstm.execute();
            
            if(cstm.getInt(2)>0)
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

    
}
