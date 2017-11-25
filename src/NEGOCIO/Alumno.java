package NEGOCIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author desarrollo
 */
import java.sql.*;
import DATA.*;
import javax.swing.JOptionPane;

public class Alumno {
    private String rut;
    private int numero;
    private boolean  becado;
    private String ciudad;
    private char sexo;

    public Alumno(String rut) {
        this.rut = rut;
    }
    
    public Alumno(String rut, int numero,boolean  becado,String ciudad,char sexo)  {
        this.rut=rut;
        this.numero=numero;
        this.becado=becado;
        this.ciudad=ciudad;
        this.sexo=sexo;
    }

    public Alumno() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws Exception {
        
            this.rut = rut;
        
    }
    
    public void insertar(){
        
        try {
            Conexion.s=Conexion.con.createStatement();
            Conexion.query="insert into alumno values('"+rut+"','"+numero+"',"+becado+",'"+ciudad+"','"+sexo+"')";
            Conexion.s.executeUpdate(Conexion.query);
            JOptionPane.showMessageDialog(null, "Alumno ingresado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error ingreso\n"+ex);
        }
        
    }
    public void actualizar(){
        try {
            Conexion.s=Conexion.con.createStatement();
            Conexion.query="update alumno set numero='"+numero+"', becado="+becado+",ciudad='"+ciudad+"',sexo='"+sexo+"' where rut='"+rut+"'";
            Conexion.s.executeUpdate(Conexion.query);
            JOptionPane.showMessageDialog(null, "Alumno Actualizado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Actualizacion\n"+ex);
        }
    }
    
    public void eliminarAlumno(){
        try {
            Conexion.s=Conexion.con.createStatement();
            Conexion.query="delete from alumno where rut='"+rut+"'";
            Conexion.s.executeUpdate(Conexion.query);
            JOptionPane.showMessageDialog(null, "Alumno Eliminado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Borrado\n"+ex);
        }
    }
    
    public ResultSet cargarRut(){
        try {
            String strSql="select * from alumno where rut='"+rut+"'";
            ResultSet objRes;
            Conexion.s=Conexion.con.prepareStatement(strSql);
            objRes=Conexion.s.executeQuery(strSql);
            return objRes;
        } catch (Exception e) {
            return null;
        }
    }
    
    public ResultSet listado(){
        try {
            String strSql="select * from alumno";
            ResultSet objRes;
            Conexion.s=Conexion.con.prepareStatement(strSql);
            objRes=Conexion.s.executeQuery(strSql);
            return objRes;
        } catch (Exception e) {
            return null;
        }
    }
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean  isBecado() {
        return becado;
    }

    public void setBecado(boolean  becado) {
        this.becado = becado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
}
