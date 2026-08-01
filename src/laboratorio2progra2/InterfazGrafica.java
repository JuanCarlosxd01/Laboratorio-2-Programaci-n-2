
package laboratorio2progra2;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFileChooser;
import java.io.File;

public class InterfazGrafica extends JFrame {
    
    private JTabbedPane pestanas;
    
    public InterfazGrafica(){
        pestanas = new JTabbedPane();
        add(pestanas);
        setTitle("Sistema de Gestion de Empleados");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel Registrar = new JPanel();
        JPanel Horas = new JPanel();
        JPanel Ventas = new JPanel();
        JPanel  Contratos = new JPanel();
        JPanel Reportes = new JPanel();
        
        pestanas.add("Registrar", Registrar);
        pestanas.add("Horas", Horas);
        pestanas.add("Ventas", Ventas);
        pestanas.add("Contratos", Contratos);
        pestanas.add("Reportes", Reportes);
        formulario(Registrar);
        tipoEmpleado(Registrar);
        cambiarFecha(Registrar);
        cambiarImagen(Registrar);
        registrar(Registrar);
    }
    
    public static void formulario(JPanel Registrar){
        Registrar.setLayout(new GridLayout(10,2,5,5));
        
        Registrar.add(new JLabel("Codigo"));
        JTextField textoCodigo = new JTextField();
        Registrar.add(textoCodigo);
        
        Registrar.add(new JLabel("Nombre"));
        JTextField textoNombre = new JTextField();
        Registrar.add(textoNombre);
        
        Registrar.add(new JLabel("Salario Base"));
        JTextField textoSalario = new JTextField();
        Registrar.add(textoSalario);
        
        Registrar.add(new JLabel("Horas de trabajo"));
        JTextField textoHoras = new JTextField();
        Registrar.add(textoHoras);
    }
    
    public static void tipoEmpleado(JPanel Registrar){
        JComboBox<String> tipo = new JComboBox<>();
        tipo.addItem("Estandar");
        tipo.addItem("Temporal");
        tipo.addItem("Ventas");
        Registrar.add(new JLabel("Tipo"));
        Registrar.add(tipo);
    }
    
    public static void cambiarFecha(JPanel Registrar){
        JDateChooser Contratacion = new JDateChooser();
        Registrar.add(new JLabel("Fecha contratatcion"));
        Registrar.add(Contratacion);
        
        JDateChooser finContrato = new JDateChooser();
        Registrar.add(new JLabel("Fin Contrato"));
        Registrar.add(finContrato);
    }
    
    public static void cambiarImagen(JPanel Registrar){
        JButton botonFoto = new JButton("Seleccionar foto");
        
        botonFoto.addActionListener(e ->{
            JFileChooser chooser = new JFileChooser();
            int opcion = chooser.showOpenDialog("hola");
            
            if(opcion == JFileChooser.APPROVE_OPTION){
                File foto = chooser.getSelectedFile();
                System.out.println(foto.getAbsolutePath());
            }
        });
    }
    
    public static void registrar(JPanel Registrar){
        JButton botonRegistrar = new JButton("Registrar");
        botonRegistrar.addActionListener(e -> {
            
        });
    }
    
    
    
}
