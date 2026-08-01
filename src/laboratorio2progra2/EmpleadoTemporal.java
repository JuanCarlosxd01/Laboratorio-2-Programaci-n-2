
package laboratorio2progra2;

import java.util.Calendar;

public class EmpleadoTemporal extends Empleado{
    
    private Calendar finContrato;
    
    public EmpleadoTemporal(Calendar finContrato){
        super(Empleado);
        this.finContrato = finContrato;
    }
    
    
    public void calcularPagoadicional(){
        Calendar fechaActual = Calendar.getInstance();
        if(fechaActual.after(finContrato)){
            
        }
    }
    
}
