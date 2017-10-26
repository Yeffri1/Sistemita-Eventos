/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author yeffr
 */
public interface ImantenimientoInvitaciones 
{
    boolean enviarInvitacion(Invitaciones invitacion);
    boolean eliminarInvitacion(int idInvitacion);
    boolean actualizarInvitacion(int idInvitacion,Invitaciones invitacion);
    
}
