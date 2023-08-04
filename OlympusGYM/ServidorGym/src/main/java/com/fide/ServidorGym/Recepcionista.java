
package com.fide.loginparaproyecto;

import java.sql.Date;

public class Recepcionista extends Persona{
    private double salario;

    public Recepcionista(double salario, String cedula, String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String tipo) {
        super(cedula, nombre, primerApellido, segundoApellido, fechaNacimiento, tipo);
        this.salario = salario;
    }

    public Recepcionista() {
    }
    
    public Recepcionista(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
