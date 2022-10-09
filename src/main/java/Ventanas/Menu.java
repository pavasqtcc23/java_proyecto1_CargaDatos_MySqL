package Ventanas;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Menu extends JFrame implements ActionListener {

   private JLabel labelSubtitulo1;
    private JLabel labelSubtitulo2;
   private JTextField ingresarNombre;
   private  JTextField ingresarApellido;

    private JButton btnRegistro;


    public  Menu() {

           componentes();


           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //al cerrar el programa de detiene el programa
           setSize(400,600); // tamaño de ancho y largo
           setLocationRelativeTo(null); // centrar la ventana en el monitor
           setLayout(null); // elimina toda platilla
           setResizable(false); // evita que se pueda modficar el tamaño de la ventana
           setVisible(true); // hace visible a la ventana
           setTitle(" ** Menu Principal ** "); //le pone un titulo a la ventana


    }

    public void componentes() {

        labelSubtitulo1 = new JLabel();
        labelSubtitulo1.setBounds(120, 25, 180, 20);
        labelSubtitulo1.setText("Ingrese su nombre ");
        add(labelSubtitulo1);

        ingresarNombre = new JTextField();
        ingresarNombre.setBounds(120, 50, 150, 20);
        ingresarNombre.setText("");
        add(ingresarNombre);

        labelSubtitulo2 = new JLabel();
        labelSubtitulo2.setBounds(120, 100, 180, 20);
        labelSubtitulo2.setText("Ingrese su apellido ");
        add(labelSubtitulo2);


        ingresarApellido = new JTextField();
        ingresarApellido.setBounds(120, 150, 150, 20);
        ingresarApellido.setText("");
        add(ingresarApellido);


        btnRegistro = new JButton();
        btnRegistro.setBounds(120, 200, 150, 20);
        btnRegistro.setText("Registrar");
        //inicializo ecuchar el boton
        btnRegistro.addActionListener(this);
        add(btnRegistro);
    }

    private void jButton1ActionPerfomed(java.awt.event.ActionEvent evt){
        try {
             Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/localstorage","root","1234");
             PreparedStatement pst = cn.prepareStatement("insert into empleado values(?,?,?)");

             pst.setString(1,"0");
             pst.setString(2,ingresarNombre.getText().trim());
             pst.setString(3,ingresarApellido.getText().trim());
             pst.executeUpdate();

             ingresarNombre.setText("");
             ingresarApellido.setText("");
        }
        catch (Exception e){

        }
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(btnRegistro)) {

            jButton1ActionPerfomed(e);
        }
        throw new UnsupportedOperationException("Not supported yet. ");
    }

}
