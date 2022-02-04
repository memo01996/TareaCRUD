/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrud;

/**
 *
 * @author guill
 */
public class Empleados {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the salario_base
     */
    public double getSalario_base() {
        return salario_base;
    }

    /**
     * @param salario_base the salario_base to set
     */
    public void setSalario_base(double salario_base) {
        this.salario_base = salario_base;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the aumento
     */
    public double getAumento() {
        return aumento;
    }

    /**
     * @param aumento the aumento to set
     */
    public void setAumento(double aumento) {
        this.aumento = aumento;
    }

    /**
     * @return the salario_neto
     */
    public double getSalario_neto() {
        return salario_neto;
    }

    /**
     * @param salario_neto the salario_neto to set
     */
    public void setSalario_neto(double salario_neto) {
        this.salario_neto = salario_neto;
    }
    
    public String getRow()
    {
      return String.format("%d\t%s\t%f\t%s\t%f\t%f\n", id, nombre, salario_base, cargo, aumento, salario_neto);
    }
    
    private int id;
    private String nombre;
    private double salario_base;
    private String cargo;
    private double aumento;
    private double salario_neto;
    
}
