 

package com.fide.loginparaproyecto;

public class LoginParaProyecto {

    public static void main(String[] args) {
        
        FuncionesServidor servidor = new FuncionesServidor();
        servidor.levantarServidor();
        
        
        //Persona recepcionista1 = new Recepcionista();
        
        Login login = new Login();
        login.show();
    }
}
