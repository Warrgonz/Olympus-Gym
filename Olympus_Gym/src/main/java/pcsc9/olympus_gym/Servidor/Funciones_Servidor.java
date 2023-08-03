/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcsc9.olympus_gym.Servidor;
import java.io.*;
import java.util.Scanner;
import java.net.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Daniel
 */
public class Funciones_Servidor {
    private static final String HOST = "localhost";
    private static final int PUERTO = 5000;
    private ServerSocket servidor;
    private Socket cliente;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private String mensajeRecibido = "";
    
    public void levantarServidor()
    {
        Scanner lectura = new Scanner(System.in);
        try
        {
            //Inicializamos el servidor y abirmos el puerto para conexión de clientes
            servidor = new ServerSocket(PUERTO);
            cliente = new Socket();
            System.out.println("Esperando conexión....");
            //Recibimos a los clientes
            cliente = servidor.accept();
            System.out.println("Se conectó un cliente!");
            //Aquí atendemos y leemos a los clientes
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            //Preparamos la respuesta para el cliente y estableciendo el espacio de comunicación
            String mensajeEnviado = "";
            while(!mensajeEnviado.equals("SALIR"))
            {
                mensajeRecibido = entrada.readUTF();
                System.out.println("Mensaje del cliente: " + mensajeRecibido);
                System.out.println("Digite su respuesta para el cliente: ");
                mensajeEnviado = lectura.nextLine();
                salida.writeUTF(mensajeEnviado);
            }
        }
        catch(IOException error)
        {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + error);
        }
    }
}
