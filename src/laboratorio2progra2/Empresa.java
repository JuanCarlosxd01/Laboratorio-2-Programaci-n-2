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