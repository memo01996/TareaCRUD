/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrud;

import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

/**
 *
 * @author guill
 */
public class main {
  public static Scanner entrada = new Scanner(System.in);
    private static ModeloEmpleados model = new ModeloEmpleados();
    public static void main ( String[] args) {
        //System.out.println("Hola Mundo");
        //guessTheNumber();
        Utilidades.encabezado("Gestion de Empleados");
        mostrarListado();
        String menuOption = "";
        System.out.println();
        Utilidades.menu();
        System.out.print("\nIngresa opcion a ingresar :");
        menuOption = entrada.nextLine().toUpperCase();
        while ( !menuOption.contentEquals("S")){
            switch (menuOption) {
                case "N":                  
                    insertarunempleado();
                    break;
                case "A":
                    //Utilidades.print("Actualizar");
                    actualizarunEmpleado();
                    break;
                case "E":
                    //Utilidades.print("Eliminar");
                    eliminarEmpleado();
                    break;
                default:
                    Utilidades.print("Opcion no encontrada!!!");
            }
            Utilidades.menu();
            menuOption = entrada.nextLine().toUpperCase();
        }
    }
    
    private static void insertarunempleado(){
        Empleados nuevoEmpleado = new Empleados();
      Utilidades.encabezado("Nuevo Empleado");
      nuevoEmpleado.setNombre(Utilidades.capturarCampo(entrada,"Nuevo Nombre", nuevoEmpleado.getNombre()));
      nuevoEmpleado.setSalario_base(Double.parseDouble(Utilidades.capturarCampo(entrada, "Salario Base", Double.toString(nuevoEmpleado.getSalario_base()))));
      nuevoEmpleado.setCargo(Utilidades.capturarCampo(entrada, "Cargo", nuevoEmpleado.getCargo()));
      nuevoEmpleado.setAumento(Double.parseDouble(Utilidades.capturarCampo(entrada, "Aumento", Double.toString(nuevoEmpleado.getAumento()))));
      double salario = nuevoEmpleado.getSalario_base(), aumento = nuevoEmpleado.getAumento(),salario_neto = aumento + salario;
      nuevoEmpleado.setSalario_neto(Double.parseDouble(Utilidades.capturarCampo(entrada, "Salario Neto", Double.toString(salario_neto))));
      Utilidades.separador();
      int insertado = model.AgregarEmpleados(nuevoEmpleado);
      if (insertado > 0)
      {
       Utilidades.print("Empleado Agregado Satisfactoriamente!");
      }
      Utilidades.separador();
    }
    
     private static void mostrarListado()
    {
     Utilidades.printEncabezadoTabla();
     ArrayList<Empleados> productos = model.ObtenerEmpleados();
     for (int i = 0; i < productos.size(); i++)
     {
       Utilidades.print(productos.get(i).getRow());
       Utilidades.separador();
     }
    }
    
    private static void actualizarunEmpleado()
    {
      Empleados updateEmpleados = new Empleados();
      int setId;
      Utilidades.encabezado("Empleado a Actualizar");
      updateEmpleados.setId(Integer.parseInt(Utilidades.capturarCampo(entrada, "Id", "")));
      updateEmpleados = model.ObtenerEmpleados(updateEmpleados.getId());
      updateEmpleados.setNombre(Utilidades.capturarCampo(entrada, "Nombre",
              updateEmpleados.getNombre()));
      updateEmpleados.setSalario_base(Double.parseDouble(Utilidades.capturarCampo(entrada, 
              "Salario Base", Double.toString(updateEmpleados.getSalario_base()))));
      updateEmpleados.setCargo(Utilidades.capturarCampo(entrada, 
              "Cargo", (updateEmpleados.getCargo())));
      updateEmpleados.setAumento(Double.parseDouble(Utilidades.capturarCampo(entrada, 
              "Aumento", Double.toString(updateEmpleados.getAumento()))));
      updateEmpleados.setSalario_neto(Double.parseDouble(Utilidades.capturarCampo(entrada, 
              "Salario Neto", Double.toString(updateEmpleados.getSalario_neto()))));
      int actualizar = model.ActualizarEmpleados(updateEmpleados);
      if (actualizar > 0)
      {
       Utilidades.print("Empleado Actualizado Satisfactoriamente!");
      }
      Utilidades.separador();
    }
    
     private static void eliminarEmpleado()
   {
     Empleados borrarEmpleados = new Empleados();
     int setId;
     String resp = " ";
     Utilidades.encabezado("Empleado a Eliminar");
     borrarEmpleados.setId(Integer.parseInt(Utilidades.capturarCampo(entrada, "Id", "")));
       System.out.println("Seguro que desea eliminar el empleado? [Si,No] : ");
       resp = entrada.nextLine().toUpperCase();
       if (resp == "SI"){
           int eliminar = model.BorrarEmpleados(borrarEmpleados);
            if (eliminar != -1)
            {
            Utilidades.print("Empleado Eliminado Satisfactoriamente!");
            }
       }     
      Utilidades.separador();
   }
}     
