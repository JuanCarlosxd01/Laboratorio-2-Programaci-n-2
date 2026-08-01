
package laboratorio2progra2;

import javax.swing.*;

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
    }
    
    public formulario(){
        
    }
    
    
    
    
}
