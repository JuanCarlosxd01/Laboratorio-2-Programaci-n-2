
package laboratorio2progra2;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import javax.swing.JFileChooser;
import java.io.File;
import java.awt.GridLayout;
import java.util.Calendar;

public class InterfazGrafica extends JFrame {
    
    private JTabbedPane pestanas;
    private Empresa empresa;
    private  JTextField textoCodigo;
    private  JTextField textoNombre;
    private JTextField textoSalario;
    private  JTextField textoHoras;
    private  JComboBox<String> tipo;
    private  JDateChooser Contratacion;
    private  JDateChooser finContrato;
    private  File foto;
    
    
    public InterfazGrafica(){
        empresa = new Empresa();
        
        pestanas = new JTabbedPane();
        add(pestanas);
        setTitle("Sistema de Gestion de Empleados");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        
        setVisible(true);
        
    }
    
    public void formulario(JPanel Registrar){
        Registrar.setLayout(new GridLayout(10,2,5,5));
        
        Registrar.add(new JLabel("Codigo"));
        textoCodigo = new JTextField();
        Registrar.add(textoCodigo);
        
        Registrar.add(new JLabel("Nombre"));
        textoNombre = new JTextField();
        Registrar.add(textoNombre);
        
        Registrar.add(new JLabel("Salario Base"));
        textoSalario = new JTextField();
        Registrar.add(textoSalario);
        
        Registrar.add(new JLabel("Horas de trabajo"));
        textoHoras = new JTextField();
        Registrar.add(textoHoras);
    }
    
    public  void tipoEmpleado(JPanel Registrar){
        tipo = new JComboBox<>();
        tipo.addItem("Estandar");
        tipo.addItem("Temporal");
        tipo.addItem("Ventas");
        Registrar.add(new JLabel("Tipo"));
        Registrar.add(tipo);
    }
    
    public  void cambiarFecha(JPanel Registrar){
        Contratacion = new JDateChooser();
        Registrar.add(new JLabel("Fecha contratatcion"));
        Registrar.add(Contratacion);
        
        finContrato = new JDateChooser();
        Registrar.add(new JLabel("Fin Contrato"));
        Registrar.add(finContrato);
    }
    
    public  void cambiarImagen(JPanel Registrar){
        JButton botonFoto = new JButton("Seleccionar foto");
        Registrar.add(botonFoto);
        botonFoto.addActionListener(e ->{
            JFileChooser chooser = new JFileChooser();
            int opcion = chooser.showOpenDialog(null);
            if(opcion == JFileChooser.APPROVE_OPTION){
                foto = chooser.getSelectedFile();
                System.out.println(foto.getAbsolutePath());
            }
        });
    }
    
    public void registrar(JPanel Registrar){

    JButton botonRegistrar = new JButton("Registrar");
    Registrar.add(botonRegistrar);

    botonRegistrar.addActionListener(e -> {
        try {
            String codigo = textoCodigo.getText();
            String nombre = textoNombre.getText();
            double salario = Double.parseDouble(textoSalario.getText());
            double horas = Double.parseDouble(textoHoras.getText());
            Calendar fecha = Calendar.getInstance();
            if(Contratacion.getDate() != null){
                fecha.setTime(Contratacion.getDate());
            }
            String tipoEmpleado = tipo.getSelectedItem().toString();
            Empleado empleado;
            if(tipoEmpleado.equals("Estandar")){
                empleado = new Empleado(codigo,nombre,salario,fecha,foto);
            } else if(tipoEmpleado.equals("Temporal")){
                Calendar fin = Calendar.getInstance();
                if(finContrato.getDate() == null){
                    JOptionPane.showMessageDialog(this,"Seleccione la fecha de fin de contrato");
                    return;
                }
                fin.setTime(finContrato.getDate());
                empleado = new EmpleadoTemporal(codigo,nombre,salario,fecha,foto,fin);
            } else {
                double comision = 0.05;
                empleado = new EmpleadoVentas(codigo,nombre,salario,fecha,foto,comision);
            }
            empleado.registroDeHoras(horas);
            if(empresa.registrarEmpleado(empleado)){
                JOptionPane.showMessageDialog(this,"Empleado registrado correctamente"
                );
                limpiarFormulario();

            }else{
                JOptionPane.showMessageDialog(this,"El código ya existe"
                );
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Ingrese valores numéricos correctos"
            );
        }
    });
}      
    
        private void limpiarFormulario(){
        textoCodigo.setText("");
        textoNombre.setText("");
        textoSalario.setText("");
        textoHoras.setText("");
        tipo.setSelectedIndex(0);
        Contratacion.setDate(null);
        finContrato.setDate(null);
        foto = null;

}
}
