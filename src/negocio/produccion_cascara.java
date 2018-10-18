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
public class produccion_cascara extends Conexion {
    
  private int nro_pro;
  private int codigo_cascara;
  private int cantidad_sacos;
  private double porcentaje_humedad;

    public int getNro_pro() {
        return nro_pro;
    }

    public void setNro_pro(int nro_pro) {
        this.nro_pro = nro_pro;
    }

    public int getCodigo_cascara() {
        return codigo_cascara;
    }

    public void setCodigo_cascara(int codigo_cascara) {
        this.codigo_cascara = codigo_cascara;
    }

    public int getCantidad_sacos() {
        return cantidad_sacos;
    }

    public void setCantidad_sacos(int cantidad_sacos) {
        this.cantidad_sacos = cantidad_sacos;
    }

    public double getPorcentaje_humedad() {
        return porcentaje_humedad;
    }

    public void setPorcentaje_humedad(double porcentaje_humedad) {
        this.porcentaje_humedad = porcentaje_humedad;
    }
  
  
    
}
