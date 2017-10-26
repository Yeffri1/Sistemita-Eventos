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
public interface ImantenimientoEvento {
    
    boolean crearEvento(Evento event);
    boolean actualizarEvento(int IdEvento,Evento event);
    boolean eliminarEvento(int IdEvento);
    
    
}
