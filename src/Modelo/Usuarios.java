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
public abstract class Usuarios extends Persona
{
    
    protected String Usuario;
    protected String Password;
    protected String Rol;
    
    
    public Usuarios()
    {
        
    }
    public Usuarios(String puser,String pss,String prol)
    {
        this.Usuario=puser;
        this.Password=pss;
        this.Rol=prol;
    }
    
    @Override
    public String ToString()       
    {
        StringBuilder sb = new StringBuilder();
        sb.append(super.ToString());
        sb.append(" ");
        sb.append("El usuario es: ");
        sb.append(this.getUsuario());
        sb.append(" ");
        sb.append("La contraseña es: ");
        sb.append(this.getPassword());
        sb.append(" ");
        sb.append("El rol es: ");
        sb.append(this.getRol());
        
        
        return sb.toString();  
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Rol
     */
    public String getRol() {
        return Rol;
    }

    /**
     * @param Rol the Rol to set
     */
    public void setRol(String Rol) {
        
        if(Rol.equals("Administrador") || Rol.equals("Portero"))
        {
          this.Rol = Rol;    
        }
    }
}
