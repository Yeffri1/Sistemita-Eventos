/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author yeffr
 * @version 1.0
 */
public abstract class Persona {

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }


    /**
     * @return the Direccion
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * @param Direccion the Direccion to set
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    protected String Nombre;
    protected String Apellido;
    protected String Direccion;
    
    public Persona()
    {
        
    }
    /**
     * @param pnombre
     * @param papellido
     * @param pdireccion 
     */
    public Persona(String pnombre,String papellido,String pdireccion)
    {
        this.Nombre=pnombre;
        this.Apellido=papellido;
        this.Direccion=pdireccion;
    }
    
    
    public String ToString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre:");
        sb.append(this.getNombre());
        sb.append(" ");
        sb.append("Apellido:");
        sb.append(this.getApellido());
        sb.append(" ");
        sb.append("Direccion");
        sb.append(this.getDireccion());
        
        
       return sb.toString();
    }

    
}
