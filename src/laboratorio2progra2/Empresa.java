/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2progra2;

import java.util.ArrayList;
import java.util.Calendar;

public class Empresa {
    
    private ArrayList<Empleado> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public Empleado buscarEmpleadoPorCodigo(String codigo) {
        for (Empleado emp : empleados) {
            if (emp.getCodigo().equals(codigo)) {
                return emp; 
            }
        }
        return null;
    }

    public boolean registrarEmpleado(Empleado nuevoEmpleado) {
        if (buscarEmpleadoPorCodigo(nuevoEmpleado.getCodigo()) != null) {
            System.out.println("Ya existe un empleado registrado con e código " + nuevoEmpleado.getCodigo());
            return false;
        }
        
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado " + nuevoEmpleado.getNombre() + " registrado exitosamente.");
        return true;
    }

    public void registrarHorasTrabajadas(String codigo, int horas) {
        Empleado emp = buscarEmpleadoPorCodigo(codigo);
        
        if (emp != null) {
            emp.registroDeHoras(horas); 
            System.out.println("Horas registradas con éxito para: " + emp.getNombre());
        } else {
            System.out.println("Error: No se encontró ningún empleado con el código " + codigo);
        }
    }

    public void registrarVentas(String codigo, double monto) {
        Empleado emp = buscarEmpleadoPorCodigo(codigo);
        
        if (emp == null) {
            System.out.println("Error: No se encontró ningún empleado con el código " + codigo);
            return;
        }

        if (emp instanceof EmpleadoVentas) {
            EmpleadoVentas empVentas = (EmpleadoVentas) emp;
            empVentas.registrarVentas(monto);
            System.out.println("Venta de " + monto + " registrada al empleado " + emp.getNombre());
        } else {
            System.out.println("Acción denegada: El empleado " + emp.getNombre() + " no esta en el  departamento de ventas.");
        }
        
        
    }
    public void actualizarFechaContrato(String codigo, Calendar fecha_n){
            Empleado emp=buscarEmpleadoPorCodigo(codigo);
            
            if (emp==null){
                System.out.println("No se encuentra ningun empleado con este codigo");
                return;
                
            }
            if (emp instanceof EmpleadoTemporal){
                EmpleadoTemporal e_temp= (EmpleadoTemporal) emp;
                e_temp.actualizarFincontrato(fecha_n);
                System.out.println("Fecha de fin de contrato ha sido actualizada.");
            }
            
            else{
                System.out.println("No se ha podido cambiar la fecha de fin de contrato para el empleado: "+emp.getNombre());
            }
        }
    
    public double calcularPagoMensual(String codigo){
        Empleado e=buscarEmpleadoPorCodigo(codigo);
        
        if (e!=null){
            return e.calcularPagoEmpleado();
        }
        
        System.out.println("No se encuentra ningun empleado con este codigo");
        return 0.0;
    }
    
    public String generarReportes(){
        if (empleados.isEmpty()){
            return "No hay empleados registrados aun en la empresa";
        }
        
        int total_est=0,total_temp=0,total_vent=0;
        String s_estandar,s_temporal,s_venta;
        
        s_estandar="--- EMPLEADO ESTANDAR ---\n";
        s_temporal="--- EMPLEADO TEMPORAL ---\n";
        s_venta="--- EMPLEADO DE VENTA ---\n";
        
        for (Empleado emp: empleados) {
            if(emp instanceof EmpleadoTemporal){
                total_temp++;
                s_temporal+=emp.toString()
                                + "Horas: " + emp.getHoras_t()
                                + "Salario Base: " + emp.getSalario_b()
                                + "Pago Mensual: " + emp.calcularPagoEmpleado();
            }
            
            else if(emp instanceof EmpleadoVentas){
                total_vent++;
                EmpleadoVentas e=(EmpleadoVentas) emp;
                s_venta+=e.toString()
                                + "Horas: " + e.getHoras_t()
                                + "Salario Base: " + e.getSalario_b()
                                + "Ventas Anuales: " + e.calcularVentasAnuales()
                                + "Pago Mensual: " + e.calcularPagoEmpleado();
            }
            
            else{
                total_est++;
                s_estandar+=emp.mostrarInformacion()
                        + "Horas: " + emp.getHoras_t()
                        + "Salario Base: " + emp.getSalario_b()
                        + "Pago Mensual: " + emp.calcularPagoEmpleado();
            }
        }
        
        String reporte="===REPORTE GENERAL DE EMPLEADOS===";
        
        if(total_est>0){
            reporte+=s_estandar+"\n";
        }
        if(total_temp>0){
            reporte+=s_temporal+"\n";
        }
        if(total_vent>0){
            reporte+=s_venta+"\n";
        }
        
        reporte+="CONTEO TOTAL POR TIPO DE EMPLEADO:\n"
                +" Estandar: "+total_est+"\n"
                +" Temporales: "+total_temp+"\n"
                +" Ventas: "+total_vent+"\n"
                +" TOTAL FINAL: "+empleados.size()+"\n";
        
        return reporte;
    }
}