/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2progra2;

import java.util.ArrayList;

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
            System.out.println("Ya existe un empleado registrado con ese código " + nuevoEmpleado.getCodigo());
            return false;
        }
        
        empleados.add(nuevoEmpleado);
        System.out.println("Empleado " + nuevoEmpleado.getNombre() + " registrado.");
        return true;
    }

    public void registrarHorasTrabajadas(String codigo, int horas) {
        Empleado emp = buscarEmpleadoPorCodigo(codigo);
        
        if (emp != null) {
            emp.registrarHorasTrabajadas(horas); 
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
                e_temp.actualizarFinContrato(fecha_n);
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
}