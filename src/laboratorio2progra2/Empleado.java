
package laboratorio2progra2;

import java.io.File;
import java.util.Calendar;

/**
 *
 * @author Ian Suazo Palao
 */
public class Empleado {
    protected String codigo;
    protected String nombre;
    protected Calendar contrato;
    protected double salario_b;
    protected double horas_t;
    protected File foto;
    
    public Empleado(String codigo, String nombre, double salario_b, Calendar contrato, File fotoArchivo){
        this.codigo=codigo;
        this.nombre=nombre;
        this.salario_b=salario_b;
        
        if (contrato!=null){
            this.contrato=contrato;
        }
        else{
            this.contrato=Calendar.getInstance();
        }
        
        this.horas_t=0.0;
        this.foto=fotoArchivo;
    }
    
    //asegurandose que las horas que trabaja el empleado se le actualize a su persona completamente
    public void registroDeHoras(double horas){
        if (horas<0){
            throw new IllegalArgumentException("No se puede trabajar con horas negativas.");
        }
        this.horas_t=horas;
    }
    
    // metodo para calcular el pago del empleado:
    
    //Calcular pago: implementa la regla del empleado estándar (ver fórmula abajo). Las subclases sobrescriben este método para aplicar su propia regla, tomando como base un mes estándar de 160 horas. Si las horas trabajadas superan las 160, el cálculo se limita a este máximo.
    
    public void calcularPagoEmpleado(){
        double horas_ef,salario_p,deduc,pago_total;
        
    }
}
