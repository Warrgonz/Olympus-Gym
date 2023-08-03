/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcsc9.olympus_gym.Cliente;
import java.io.*;
import java.util.Scanner;
import java.net.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Daniel
 */
public class Funciones_Cliente {
    
     private static final String HOST = "localhost";
    private static final int PUERTO = 5000;
    private Socket conexionAlServidor;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private String mensajeRecibido = "";
    
    public void conectarCliente()
    {
        Scanner lectura = new Scanner(System.in);
        try
        {
            //Configurar la conexión al servidor
            conexionAlServidor = new Socket(HOST, PUERTO);
            salida = new DataOutputStream(conexionAlServidor.getOutputStream());
            entrada = new DataInputStream(conexionAlServidor.getInputStream());
            //Comenzamos la comunicación con el servidor
            String mensajeEnviado = "";
            
            while(!mensajeEnviado.equals("SALIR"))
            {
                System.out.println("Digite su mensaje para el servidor: ");
                mensajeEnviado = lectura.nextLine();
                salida.writeUTF(mensajeEnviado);
                mensajeRecibido = entrada.readUTF();
                System.out.println("Mensaje del servidor: " + mensajeRecibido);
            }
        }
        catch(IOException error)
        {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + error);
        }
    }
}
