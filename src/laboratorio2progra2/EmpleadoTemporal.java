
package laboratorio2progra2;

import java.io.File;
import java.util.Calendar;

public class EmpleadoTemporal extends Empleado{
    
    private Calendar finContrato;
    
    public EmpleadoTemporal(String codigo, String nombre, double salario_b, Calendar contrato, File fotoArchivo, Calendar finContrato){
        super(codigo, nombre, salario_b, contrato, fotoArchivo);
        this.finContrato = finContrato;
    }
    
    public Calendar finContrato(){
        return finContrato;
    }
    
    
    public double calcularPagocondicionado(){
        Calendar fechaActual = Calendar.getInstance();
        if(fechaActual.before(finContrato) || fechaActual.equals(finContrato)){
            return getHoras_t() * getSalario_b();
        }
        
        else{
            return 0;
        }
    }
    
    public void actualizarFincontrato(Calendar nuevaFecha){
        this.finContrato = nuevaFecha;
    }
    
    @Override
    public String toString(){
        return super.mostrarInformacion() + "\n Fecha fin de contrato: " + finContrato.get(Calendar.DAY_OF_MONTH) + "/" + finContrato.get(Calendar.MONTH) + "/" + finContrato.get(Calendar.YEAR);
    }
    
}
