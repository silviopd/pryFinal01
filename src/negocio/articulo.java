/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.ResultSet;
import datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class articulo extends Conexion {

    private int codigo_articulo;
    private String nombre;
    private String linea;
    private double precio_pilado;
    private int codigo_envase;
    private double precio_envase;
    private int peso_producto;
    private double precio_insumo;
    private double stock;

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public double getPrecio_pilado() {
        return precio_pilado;
    }

    public void setPrecio_pilado(double precio_pilado) {
        this.precio_pilado = precio_pilado;
    }

    public int getCodigo_envase() {
        return codigo_envase;
    }

    public void setCodigo_envase(int codigo_envase) {
        this.codigo_envase = codigo_envase;
    }

    public double getPrecio_envase() {
        return precio_envase;
    }

    public void setPrecio_envase(double precio_envase) {
        this.precio_envase = precio_envase;
    }

    public int getPeso_producto() {
        return peso_producto;
    }

    public void setPeso_producto(int peso_producto) {
        this.peso_producto = peso_producto;
    }

    public double getPrecio_insumo() {
        return precio_insumo;
    }

    public void setPrecio_insumo(double precio_insumo) {
        this.precio_insumo = precio_insumo;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public ResultSet listarProducto() throws Exception {
        String sql = "select tb1.codigo_articulo as codigo_producto,tb1.nombre as producto,tb1.peso_producto,tb1.precio_pilado,tb1.codigo_envase,tb2.nombre as envase,tb2.precio_envase"
                + "              from "
                + "              (select * from articulo where linea='P') as tb1"
                + "              inner join"
                + "               (select * from articulo where linea='E') as tb2"
                + "                 on tb1.codigo_envase=tb2.codigo_articulo";
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = ejecutarSQLSelectSP(sentencia);
        return resultado;
    }

    public ResultSet listarInsumo() throws Exception {
        String sql = "SELECT "
                + "  articulo.codigo_articulo, "
                + "  articulo.nombre, "
                + "  articulo.precio_insumo"
                + " FROM "
                + "  public.articulo"
                + " WHERE"
                + " articulo.linea='I';";
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = ejecutarSQLSelectSP(sentencia);
        return resultado;
    }

    public ResultSet listarCascara() throws Exception {
        String sql = "SELECT "
                + "  cascara.codigo_cascara, "
                + "  cascara.variedad_arroz_cascara"
                + " FROM "
                + "  public.cascara;";
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = ejecutarSQLSelectSP(sentencia);
        return resultado;
    }

}
