/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareacrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author guill
 */
public class ModeloEmpleados {
private Connection _conexion = null;
    public ModeloEmpleados()
    {
        _conexion = Conexion.getConexion();
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS empleados" 
                + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," 
                + " nombre TEXT NOT NULL," 
                + " salario base DECIMAL(10,2)," 
                + " cargo TEXT,"
                + " aumento DECIMAL(10,2),"
                + " salario neto DECIMAL(10,2);";
        try
        {
          Statement comando = _conexion.createStatement();
          int resultado = comando.executeUpdate(sqlCreateTable);
        }
        catch (Exception ex)
        {
          System.err.println(ex.getMessage());
        }
    }
    public ArrayList<Empleados> ObtenerEmpleados ()
    {
        try
        {
           
       ArrayList empleados = new ArrayList<Empleados>();
       Statement comandoSQL = _conexion.createStatement();
       ResultSet registroEnTabla = comandoSQL.executeQuery("SELECT * FROM productos;");
       while (registroEnTabla.next())
       {
         Empleados empleadoactual = new Empleados();
         empleadoactual.setId(registroEnTabla.getInt("Id"));
         empleadoactual.setNombre(registroEnTabla.getString("Nombre"));
         empleadoactual.setSalario_base(registroEnTabla.getDouble("Salario Base"));
         empleadoactual.setCargo(registroEnTabla.getString("Cargo"));
         empleadoactual.setAumento(registroEnTabla.getDouble("Aumento"));
         empleadoactual.setSalario_neto(registroEnTabla.getDouble("Salario Neto"));
         
         empleados.add(empleadoactual);
       }
       return empleados;
        }
       catch (Exception ex)
        {
          System.err.println(ex.getMessage());
          return new ArrayList<Empleados>();
        }
    }
    public Empleados ObtenerEmpleados (int id)
    {
        try
        {
       PreparedStatement comandoSQL = _conexion.prepareStatement("SELECT * FROM empleados where id =?;");
       comandoSQL.setInt(1, id);
       ResultSet registroEnTabla = comandoSQL.executeQuery();
       Empleados empleadoactual = new Empleados();
       while (registroEnTabla.next())
       {
          empleadoactual.setId(registroEnTabla.getInt("Id"));
         empleadoactual.setNombre(registroEnTabla.getString("Nombre"));
         empleadoactual.setSalario_base(registroEnTabla.getDouble("Salario Base"));
         empleadoactual.setCargo(registroEnTabla.getString("Cargo"));
         empleadoactual.setAumento(registroEnTabla.getDouble("Aumento"));
         empleadoactual.setSalario_neto(registroEnTabla.getDouble("Salario Neto"));
         
         break;
       }
       return empleadoactual;
        }
       catch (Exception ex)
        {
          System.err.println(ex.getMessage());
          return null;
        }
    }
    public int AgregarEmpleados (Empleados agregarEmpleado)
    {
        try
        {
          String insertSql = "INSERT INTO productos (nombre, Salario Base, Cargo, Aumento, Salario Neto) values (?, ?, ?, ?, ?);";
          PreparedStatement comandoSQL = _conexion.prepareStatement(insertSql);
          comandoSQL.setString(1, agregarEmpleado.getNombre());
          comandoSQL.setDouble(2, agregarEmpleado.getSalario_base());
          comandoSQL.setString(3, agregarEmpleado.getCargo());
          comandoSQL.setDouble(4, agregarEmpleado.getAumento());
          comandoSQL.setDouble(5, agregarEmpleado.getSalario_neto());
          
          int RegistroAfectados = comandoSQL.executeUpdate();
          comandoSQL.close();
          return RegistroAfectados;
        }
      catch (Exception ex)
      {
        System.err.println(ex.getMessage());
        return 0;
      }
    }
    public int ActualizarEmpleados (Empleados updateEmpleado)
    {
        try
        {
          String updateSql = "UPDATE empleados SET nombre=?, Salario Base=?, Cargo=?, Aumento=?, Salario Neto=? where id =?;";
          PreparedStatement comandoSQL = _conexion.prepareStatement(updateSql);
          comandoSQL.setString(1, updateEmpleado.getNombre());
          comandoSQL.setDouble(2, updateEmpleado.getSalario_base());
          comandoSQL.setString(3, updateEmpleado.getCargo());
          comandoSQL.setDouble(4, updateEmpleado.getAumento());
          comandoSQL.setDouble(5, updateEmpleado.getSalario_neto());
          comandoSQL.setInt(6, updateEmpleado.getId());
          
          int RegistroAfectados = comandoSQL.executeUpdate();
          comandoSQL.close();
          return RegistroAfectados;
        }
      catch (Exception ex)
      {
        System.err.println(ex.getMessage());
        return 0;
      }
    }
    public int BorrarEmpleados (Empleados borrarEmpleado)
    {
        try
        {
          String deleteSql = "DELETE FROM empleados where id =?;";
          PreparedStatement comandoSQL = _conexion.prepareStatement(deleteSql);
          comandoSQL.setInt(1, borrarEmpleado.getId());
          int RegistroAfectados = comandoSQL.executeUpdate();
          comandoSQL.close();
          return RegistroAfectados;
        }
      catch (Exception ex)
      {
        System.err.println(ex.getMessage());
        return 0;
      }
    }
}
