
package laboratorio2progra2;

import java.util.Calendar;

public class EmpleadoTemporal extends Empleado{
    
    private Calendar finContrato;
    
    public EmpleadoTemporal(Calendar finContrato){
        super(Empleado);
        this.finContrato = finContrato;
    }
    
    public Calendar finContrato(){
        return finContrato;
    }
    
    
    public double calcularPagocondicionado(double Salario){
        Calendar fechaActual = Calendar.getInstance();
        if(fechaActual.before(finContrato) || fechaActual.equals(finContrato)){
            return Salario;
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
