
package laboratorio2progra2;


public class EmpleadoVentas extends Empleado {
    
    private double[] ventasMensuales;
    private double tasaComision;

    public EmpleadoVentas(String codigo, String nombre, java.util.Date fechaContratacion, double salarioBase, String foto, double tasaComision) {
        super(codigo, nombre, fechaContratacion, salarioBase, foto);
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

    @Override
    public double calcularPago() {
        int horas = getHorasTrabajadas();
        if (horas > 160) {
            horas = 160;
        }
        
        double salarioProporcional = (getSalarioBase() / 160.0) * horas;
        return salarioProporcional + calcularComision();
    }

    public double calcularVentasAnuales() {
        double total = 0;
        for (int i = 0; i < 12; i++) {
            total += this.ventasMensuales[i];
        }
        return total;
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + "  Total Ventas Anuales: " + calcularVentasAnuales();
    }
}