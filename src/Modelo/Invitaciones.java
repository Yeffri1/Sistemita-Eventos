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
public class Invitaciones {

    /**
     * @return the IdEvento
     */
    public int getIdEvento() {
        return IdEvento;
    }

    /**
     * @param IdEvento the IdEvento to set
     */
    public void setIdEvento(int IdEvento) {
        this.IdEvento = IdEvento;
    }

    /**
     * @return the IdInvitado
     */
    public int getIdInvitado() {
        return IdInvitado;
    }

    /**
     * @param IdInvitado the IdInvitado to set
     */
    public void setIdInvitado(int IdInvitado) {
        this.IdInvitado = IdInvitado;
    }
    
    private int IdEvento;
    private int IdInvitado;
    
    
    public Invitaciones()
    {
        
    }
    public Invitaciones(int pidevento,int pidinvitado)
    {
        this.IdEvento=pidevento;
        this.IdInvitado=pidinvitado;
    }
    
}
