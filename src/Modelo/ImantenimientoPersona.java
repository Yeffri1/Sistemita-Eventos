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
public interface ImantenimientoPersona {
    
    boolean crearPersona(Persona p);
    boolean actualizarPersona(int personaId,Persona p);
    boolean eliminarPersona(int personaId);
    
    
}
