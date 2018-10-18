/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
public class cascara extends Conexion {

    private int codigo_cascara;
    private int codigo_cliente;
    private String variedad_arroz_cascara;
    private int stock_sacos;

    public int getCodigo_cascara() {
        return codigo_cascara;
    }

    public void setCodigo_cascara(int codigo_cascara) {
        this.codigo_cascara = codigo_cascara;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getVariedad_arroz_cascara() {
        return variedad_arroz_cascara;
    }

    public void setVariedad_arroz_cascara(String variedad_arroz_cascara) {
        this.variedad_arroz_cascara = variedad_arroz_cascara;
    }

    public int getStock_sacos() {
        return stock_sacos;
    }

    public void setStock_sacos(int stock_sacos) {
        this.stock_sacos = stock_sacos;
    }
    
    public ResultSet listarInsumo() throws Exception {
        String sql = "SELECT "
                + "  articulo.codigo_articulo, "
                + "  articulo.nombre, "
                + "  articulo.precio_insumo"
                + "FROM "
                + "  public.articulo"
                + "WHERE"
                + "articulo.linea='I';";
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultado = ejecutarSQLSelectSP(sentencia);
        return resultado;
    }
}
