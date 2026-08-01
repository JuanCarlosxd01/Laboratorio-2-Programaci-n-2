package laboratorio2progra2;

import java.io.File;
import java.util.Calendar;

public class EmpleadoVentas extends Empleado {
    
    private double[] ventasMensuales;
    private double tasaComision;

    public EmpleadoVentas(String codigo, String nombre, double salario_b, Calendar contrato, File fotoArchivo, double tasaComision) {
        super(codigo, nombre, salario_b, contrato, fotoArchivo);
        this.ventasMensuales = new double[12];
        this.tasaComision = tasaComision;
    }

    public void registrarVentas(double monto) {
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        this.ventasMensuales[mesActual] += monto;
    }

    public double calcularComision() {
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        return this.ventasMensuales[mesActual] * this.tasaComision;
    }

    
    public double calcularPagoEmpleado() {
        double horas = getHoras_t(); 
        if (horas > 160.0) {
            horas = 160.0;
        }
        
        double salarioProporcional = (getSalario_b() / 160.0) * horas;
        return salarioProporcional + calcularComision();
    }

    public double calcularVentasAnuales() {
        double total = 0;
        for (int i = 0; i < 12; i++) {
            total += this.ventasMensuales[i];
        }
        return total;
    }

    public String mostrarInformacion() {
        return "Código: " + getCodigo() + "  Nombre: " + getNombre() + "  Total Ventas Anuales:  " + calcularVentasAnuales();
    }
}