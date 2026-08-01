
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getContrato() {
        return contrato;
    }

    public void setContrato(Calendar contrato) {
        this.contrato = contrato;
    }

    public double getSalario_b() {
        return salario_b;
    }

    public void setSalario_b(double salario_b) {
        this.salario_b = salario_b;
    }

    public double getHoras_t() {
        return horas_t;
    }

    public void setHoras_t(double horas_t) {
        this.horas_t = horas_t;
    }

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
        this.foto = foto;
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
    
    public double calcularPagoEmpleado(){
        double horas_ef,salario_p,deduc,pago_total;
        
        horas_ef=Math.min(this.horas_t, 160.0);
        
        //formula para sacar el salario proporcional al salario base y las horas trabajadas
        salario_p=((this.salario_b/160.0)*horas_ef);
        
        //deducion del 3.5% del salario base
        deduc=this.salario_b*0.035;
        
        pago_total=(salario_p-deduc);
        
        //en caso que la deduccion supere al salario proporcional
        return Math.max(0,pago_total);
    }
}
