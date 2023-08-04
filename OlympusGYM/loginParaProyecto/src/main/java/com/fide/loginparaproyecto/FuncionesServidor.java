/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fide.loginparaproyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author acast
 */
public class FuncionesServidor {
    private static final String HOST = "localhost";
    private static final int PUERTO = 5000;
    private ServerSocket servidor;
    private Socket cliente;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private String mensajeRecibido = "";
    Conexion conexion = new Conexion();
    ResultSet resultado = null;
    
    public void levantarServidor(){
        try{
            //Se inicializa el servidor y puerto de clientes
            servidor = new ServerSocket(PUERTO);
            cliente = new Socket();
            System.out.println("Esperando conexion...");
            //Se recibe al cliente
            cliente = servidor.accept();
            System.out.println("Se conecto un cliente");
            //Se atiende y se lee la informacion del cliente
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            //Se prepara la respuesta para el cliente y se establece espacio de comunicacion
            String mensaje = "";
            //En este while, segun la
            while(!mensaje.equals("SALIR") ){
                mensajeRecibido = entrada.readUTF();
                if (mensajeRecibido.equals("CONSULTAR_CLIENTES")) {
                    String respuesta = consultarClientes();
                    salida.writeUTF(respuesta);
                }else if(mensajeRecibido.equals("CONSULTAR_INSTRUCTORES")){
                    String respuesta = consultarInstructores();
                    salida.writeUTF(respuesta);
                }else if(mensajeRecibido.equals("CONSULTAR_RECEPCIONISTAS")){
                    String respuesta = consultarRecepcionistas();
                    salida.writeUTF(respuesta);
                }
            }
            System.out.println("El cliente se ha desconectado");
            servidor.close();

        }catch(IOException error){
            JOptionPane.showMessageDialog(null, "Error de conexion: " + error);
        }
    }
    
    public String consultarClientes() {
        StringBuilder respuestaBuilder = new StringBuilder();
        try {
            // Se abre la conexion
            conexion.setConexion();
            // Se define la consulta
            conexion.setConsulta("SELECT ID, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, FECHA_NAC, TIPO, MIEMBRO_DESDE FROM TAB_PERSONAS WHERE TIPO = 'Cliente'");
            // Se obtiene resultado
            resultado = conexion.getResultado();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                String primerApellido = resultado.getString("PRIMER_APELLIDO");
                String segundoApellido = resultado.getString("SEGUNDO_APELLIDO");
                Date fechaNacimiento = resultado.getDate("FECHA_NAC");
                Date miembroDesde = resultado.getDate("MIEMBRO_DESDE");
                
                //De momento, la consulta se almacena en un string, pero para siguiente avance, se almacenara en un arrayList
                //que luego se puede usar para poblar una tabla en la interfaz del cliente
                respuestaBuilder.append("ID: ").append(id).append(" Nombre: ").append(nombre)
                    .append(" Primer Apellido: ").append(primerApellido)
                    .append(" Segundo Apellido: ").append(segundoApellido)
                    .append(" Fecha de nacimiento: ").append(fechaNacimiento)
                    .append(" Miembro desde: ").append(miembroDesde)
                    .append("\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuestaBuilder.toString();
    }
    
    public String consultarInstructores() {
        StringBuilder respuestaBuilder = new StringBuilder();
        try {
            // Se abre la conexion
            conexion.setConexion();
            // Se define la consulta
            conexion.setConsulta("SELECT ID, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, FECHA_NAC, TIPO, INSTRUCTOR_DESDE FROM TAB_PERSONAS WHERE TIPO = 'Instructor'");
            // Se obtiene resultado
            resultado = conexion.getResultado();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                String primerApellido = resultado.getString("PRIMER_APELLIDO");
                String segundoApellido = resultado.getString("SEGUNDO_APELLIDO");
                Date fechaNacimiento = resultado.getDate("FECHA_NAC");
                Date miembroDesde = resultado.getDate("INSTRUCTOR_DESDE");

                respuestaBuilder.append("ID: ").append(id).append(" Nombre: ").append(nombre)
                    .append(" Primer Apellido: ").append(primerApellido)
                    .append(" Segundo Apellido: ").append(segundoApellido)
                    .append(" Fecha de nacimiento: ").append(fechaNacimiento)
                    .append(" Instructor desde: ").append(miembroDesde)
                    .append("\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuestaBuilder.toString();
    }

    public String consultarRecepcionistas() {
        StringBuilder respuestaBuilder = new StringBuilder();
        try {
            // Se abre la conexion
            conexion.setConexion();
            // Se define la consulta
            conexion.setConsulta("SELECT ID, NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, FECHA_NAC, TIPO, SALARIO FROM TAB_PERSONAS WHERE TIPO = 'Recepcionista'");
            // Se obtiene resultado
            resultado = conexion.getResultado();
            while (resultado.next()) {
                int id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                String primerApellido = resultado.getString("PRIMER_APELLIDO");
                String segundoApellido = resultado.getString("SEGUNDO_APELLIDO");
                Date fechaNacimiento = resultado.getDate("FECHA_NAC");
                Double salario = resultado.getDouble("SALARIO");

                respuestaBuilder.append("ID: ").append(id).append(" Nombre: ").append(nombre)
                    .append(" Primer Apellido: ").append(primerApellido)
                    .append(" Segundo Apellido: ").append(segundoApellido)
                    .append(" Fecha de nacimiento: ").append(fechaNacimiento)
                    .append(" Salario: ").append(salario)
                    .append("\n");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuestaBuilder.toString();
    }
    
    
}
