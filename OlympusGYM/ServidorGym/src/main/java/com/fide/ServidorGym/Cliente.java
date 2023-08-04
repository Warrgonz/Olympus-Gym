
package com.fide.loginparaproyecto;

import java.sql.Date;


public class Cliente extends Persona{
    private Date miembroDesde;

    public Cliente(Date miembroDesde, String cedula, String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String tipo) {
        super(cedula, nombre, primerApellido, segundoApellido, fechaNacimiento, tipo);
        this.miembroDesde = miembroDesde;
    }

    public Cliente(Date miembroDesde) {
        this.miembroDesde = miembroDesde;
    }

    public Cliente() {
    }

    public Date getMiembroDesde() {
        return miembroDesde;
    }

    public void setMiembroDesde(Date miembroDesde) {
        this.miembroDesde = miembroDesde;
    }
    
}
