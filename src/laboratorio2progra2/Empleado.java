/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    protected double horas;
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
        
        this.horas=0.0;
        this.foto=fotoArchivo;
    }
}
