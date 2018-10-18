/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Conexion;

/**
 *
 * @author USER
 */
public class produccion_insumo extends Conexion{
    
  private int nro_pro;
  private int codigo_insumo;
  private int cantidad;
  private double precio;

    public int getNro_pro() {
        return nro_pro;
    }

    public void setNro_pro(int nro_pro) {
        this.nro_pro = nro_pro;
    }

    public int getCodigo_insumo() {
        return codigo_insumo;
    }

    public void setCodigo_insumo(int codigo_insumo) {
        this.codigo_insumo = codigo_insumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
  
  
}
