
package com.fide.loginparaproyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    
    //Datos de gestion de base de datos
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    
    //Parametros de inicializacion de base de datos
    String url = "jdbc:mysql://localhost:3306/GIMNASIO_OLYMPUS_SQL";
    String username = "root";
    String password = "AChumbolt7";
    
    //Metodos para conexion a base de datos

    //Mandar consulta
    public void setConsulta(String sql) {
        try{
            this.consulta = conexion.prepareStatement(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public PreparedStatement getConsulta() {
        return consulta;
    }

    //Traer resultado
    public ResultSet getResultado() {
        try{
            return consulta.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    //Set conexion
    public void setConexion() {
        try{
            this.conexion = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void cerrarConexion() {
        if (resultado != null) {
            try {
                resultado.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (consulta != null) {
            try {
                consulta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    
    
    
    
}
