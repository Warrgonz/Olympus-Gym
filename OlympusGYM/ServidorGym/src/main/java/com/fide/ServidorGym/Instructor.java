
package com.fide.loginparaproyecto;

import java.sql.Date;


public class Instructor extends Persona{
    private Date instructorDesde;

    public Instructor(Date instructorDesde, String cedula, String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String tipo) {
        super(cedula, nombre, primerApellido, segundoApellido, fechaNacimiento, tipo);
        this.instructorDesde = instructorDesde;
    }

    public Instructor(Date instructorDesde) {
        this.instructorDesde = instructorDesde;
    }

    public Instructor() {
    }

    public Date getInstructorDesde() {
        return instructorDesde;
    }

    public void setInstructorDesde(Date instructorDesde) {
        this.instructorDesde = instructorDesde;
    }
}
