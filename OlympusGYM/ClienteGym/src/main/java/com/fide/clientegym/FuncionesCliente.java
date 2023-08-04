
package com.fide.clientegym;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FuncionesCliente {
    private static final String HOST = "localhost";
    private static final int PUERTO = 5000;
    private Socket conexionServidor;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private String mensajeRecibido = "";
    
    public void conectarCliente(){
        Scanner lectura = new Scanner(System.in);
        try{
            //Configurar conexion al servidor
            conexionServidor = new Socket(HOST, PUERTO);
            salida = new DataOutputStream(conexionServidor.getOutputStream());
            entrada = new DataInputStream(conexionServidor.getInputStream());
            //Se comienza comunicacion con servidor
            String mensajeEnviado = "";
            
            while(!mensajeEnviado.equals("SALIR")){
                System.out.println("Digite su mensaje para el servidor: ");
                mensajeEnviado = lectura.nextLine();
                salida.writeUTF(mensajeEnviado);
                mensajeRecibido = entrada.readUTF();
                System.out.println("Mensaje del servidor: \n" + mensajeRecibido);
            }
            
        }catch(IOException error){
            JOptionPane.showMessageDialog(null, "Error de conexion" + error);
        }
    }
}
