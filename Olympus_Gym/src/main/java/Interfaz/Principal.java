package Interfaz;

import static java.awt.BorderLayout.CENTER;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class Principal {

    /**
     * *** Atributos *******
     */
    // Crear marco
    JFrame ventana;

    // Panel Principal
    JPanel panelPrincipal;
    JLabel fondoPrincipal;
    ImageIcon imagenFondoPrin;

    // Botones del Panel Principal
    JButton Inscripcion;
    JButton Horarios;
    // JButton botones[];

    // Panel Inicio de Sesion
    JPanel panelInicioSesion;
    JLabel fondoInicioSesion;
    ImageIcon imagenInicioSes;

    // Botones del Inicio de Sesion
    JButton IniciarSesion;
    JButton Registrarse;
    JButton OlvidarContrasena;

    // Ingresar datos de Inicio de Sesion
    JTextField usuario;
    JTextField contrasena;

    // Constructor por defecto
    public Principal() {
        /**
         * ************************ MARCO (JFrame) ***************************
         */
        // Nombre del marco
        ventana = new JFrame("OLYMPUS");
        // Tamaño de la ventana (ancho por largo)
        ventana.setSize(1000, 700);
        /* Permite indicarle al programa que vamos a indicar las coordenadas donde 
        queremos colocar los elementos en la interfaz. */
        ventana.setLayout(null);
        // Colocar el Frame en el centro de la pantalla
        ventana.setLocationRelativeTo(null);
        // Al cerrar la ventana se detiene el programa.
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Desactivar el boton de agrandar el marco
        ventana.setResizable(false);

        /**
         * ****************** PANEL PRINCIPAL (JPanel) ***********************
         */
        // Dar memoria a la variable
        panelPrincipal = new JPanel();
        // Permite poner los componentes en el panel donde queramos
        panelPrincipal.setLayout(null);
        /* Colocamos la ventana en la esquina sup izq de nuestra ventana (JFrame) 
        y va a ser del tamaño de la ventana.*/
        panelPrincipal.setBounds(0, 0, ventana.getWidth(),
                ventana.getHeight());
        // Para que el panel sea visible
        panelPrincipal.setVisible(true);

        /**
         * ********** Darle imagen de fondo al panel Principal ***************
         */
        fondoPrincipal = new JLabel();
        fondoPrincipal.setBounds(0, 0, ventana.getWidth(),
                ventana.getHeight());
        // Entre parentesis se da la ruta de donde se encuentra la imagen
        imagenFondoPrin = new ImageIcon("Imagenes/FondoPrincipal.jpg");
        /*
        "getImage": Agarra la imagen
        ".getScaleInstace: Darle nueva escala"
        "ventana.getWidth" y "ventana.getHeight": Tamaño del marco
        "Image.SCALE_DEFAULT": Ayuda a adaptar el tamaño de la imagen al marco
         */
        imagenFondoPrin = new ImageIcon(imagenFondoPrin.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoPrincipal.setIcon(imagenFondoPrin);
        fondoPrincipal.setVisible(true);
        panelPrincipal.add(fondoPrincipal, 0);
        // Agregar el panelPrincipal al marco
        ventana.add(panelPrincipal);

        /**
         * ***************AGREGAR BOTONES AL PANEL PRINCIPAL******************
         */
        // Dar memoria al boton
        // Boton de Inscripcion
        Inscripcion = new JButton("UNIRSE YA");
        // Color de la letra
        Inscripcion.setForeground(Color.WHITE);
        // Color del fondo
        Inscripcion.setBackground(Color.BLACK);
        Inscripcion.setBounds(140, 520, 150, 50);
        Inscripcion.setFont(new Font("Arial", Font.BOLD, 20));
        Inscripcion.setHorizontalAlignment(JButton.CENTER);
        Inscripcion.setVisible(true);
        panelPrincipal.add(Inscripcion);

        // Boton de Horarios pagina principal
        Horarios = new JButton("Horarios");
        Horarios.setForeground(Color.WHITE);
        Horarios.setBackground(Color.BLACK);
        Horarios.setBounds(165, 585, 100, 30);
        Horarios.setFont(new Font("Arial", Font.BOLD, 15));
        Horarios.setHorizontalAlignment(JButton.CENTER);
        Horarios.setVisible(true);
        panelPrincipal.add(Horarios);

        /**
         * **************** Función del Botón de Inscripcion *****************
         */
        Inscripcion.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Inicio_Sesion();
            }

        });

//    //Creando unvector de 5 botones
//    botones = new JButton[5];
//    for (int i = 0; i< botones.length; i++) {
//        botones [i] = new JButton();
//    }
//    
//    
        //Para poder ver la ventana. 
        ventana.setVisible(true);
    }

    public void Inicio_Sesion() {
        /**
         * ******************* PANEL DE INICIO DE SESION *************************
         */
        panelPrincipal.setVisible(false);
        panelInicioSesion = new JPanel();
        panelInicioSesion.setLayout(null);
        panelInicioSesion.setBounds(0, 0, ventana.getWidth(),
                ventana.getHeight());
        panelInicioSesion.setVisible(true);

        /**
         * *************** IMAGEN DEL PANEL DE INICIO DE SESION ******************
         */
        fondoInicioSesion = new JLabel();
        fondoInicioSesion.setBounds(0, 0, ventana.getWidth(),
                ventana.getHeight());
        // Entre parentesis se da la ruta de donde se encuentra la imagen
        imagenInicioSes = new ImageIcon("Imagenes/FondoInicioSesion.jpg");
        /*
        "getImage": Agarra la imagen
        ".getScaleInstace: Darle nueva escala"
        "ventana.getWidth" y "ventana.getHeight": Tamaño del marco
        "Image.SCALE_DEFAULT": Ayuda a adaptar el tamaño de la imagen al marco
         */
        imagenInicioSes = new ImageIcon(imagenInicioSes.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoInicioSesion.setIcon(imagenInicioSes);
        fondoInicioSesion.setVisible(true);
        panelInicioSesion.add(fondoInicioSesion, 0);
        // Agregar el panelPrincipal al marco

        /**
         * **************** INGRESAR DATOS DE INICIO DE SESIÓN *******************
         */
        // Usuario
        usuario = new JTextField();
        usuario.requestFocusInWindow();
        usuario.selectAll();
        usuario.setLayout(null);
        usuario.setBounds(406, 243, 200, 27);
        usuario.setFont(new Font("Arial", Font.ITALIC, 10));
        usuario.setHorizontalAlignment(JTextField.CENTER);
        usuario.setVisible(true);
        panelInicioSesion.add(usuario);

        // Contraseña
        contrasena = new JTextField();
        contrasena.setLayout(null);
        contrasena.setBounds(406, 335, 200, 27);
        contrasena.setFont(new Font("Arial", Font.ITALIC, 10));
        contrasena.setHorizontalAlignment(JTextField.CENTER);
        contrasena.setVisible(true);
        panelInicioSesion.add(contrasena);

        // Boton de Iniciar Sesion
        IniciarSesion = new JButton("Ingresar");
        IniciarSesion.setForeground(Color.WHITE);
        IniciarSesion.setBackground(Color.BLACK);
        IniciarSesion.setBounds(443, 385, 115, 40);
        IniciarSesion.setFont(new Font("Arial", Font.BOLD, 18));
        IniciarSesion.setHorizontalAlignment(JButton.CENTER);
        IniciarSesion.setVisible(true);
        panelInicioSesion.add(IniciarSesion);

        // Boton de Registrarse
        Registrarse = new JButton("Registrarse");
        Registrarse.setForeground(Color.WHITE);
        Registrarse.setBackground(Color.GRAY);
        Registrarse.setBounds(415, 535, 170, 40);
        Registrarse.setFont(new Font("Arial", Font.BOLD, 18));
        Registrarse.setHorizontalAlignment(JButton.CENTER);
        Registrarse.setVisible(true);
        panelInicioSesion.add(Registrarse);

        
         // Boton de Olvidar Contraseña
        OlvidarContrasena = new JButton("¿Olvidó su contraseña");
        OlvidarContrasena.setForeground(Color.WHITE);
        OlvidarContrasena.setBackground(Color.LIGHT_GRAY);
        OlvidarContrasena.setBounds(415, 445, 170, 25);
        OlvidarContrasena.setFont(new Font("Arial", Font.BOLD, 12));
        OlvidarContrasena.setHorizontalAlignment(JButton.CENTER);
        OlvidarContrasena.setVisible(true);
        panelInicioSesion.add(OlvidarContrasena);
        
        ventana.add(panelInicioSesion);
    }
}
