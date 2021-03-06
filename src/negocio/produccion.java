package negocio;

import datos.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class produccion extends Conexion {

    private int nro_pro;
    private java.sql.Date fecha;
    private int codigo_cliente;
    private int codigo_sucursal;
    private int cantidad_sacos_arroz_cascara;
    private double total_pilado;
    private double total_envases;
    private double humedad_promedio;
    private double total_insumos;

    private ArrayList<produccionDetalle> articuloProduccionDetalle = new ArrayList<produccionDetalle>();
    private ArrayList<produccion_cascara> articuloProduccionCascara = new ArrayList<produccion_cascara>();
    private ArrayList<produccion_insumo> articuloProduccionInsumo = new ArrayList<produccion_insumo>();

    public ArrayList<produccionDetalle> getArticuloDetalleCompra() {
        return articuloProduccionDetalle;
    }

    public void setArticuloDetalleCompra(ArrayList<produccionDetalle> articuloDetalleCompra) {
        this.articuloProduccionDetalle = articuloDetalleCompra;
    }

    public ArrayList<produccionDetalle> getArticuloProduccionDetalle() {
        return articuloProduccionDetalle;
    }

    public void setArticuloProduccionDetalle(ArrayList<produccionDetalle> articuloProduccionDetalle) {
        this.articuloProduccionDetalle = articuloProduccionDetalle;
    }

    public ArrayList<produccion_cascara> getArticuloProduccionCascara() {
        return articuloProduccionCascara;
    }

    public void setArticuloProduccionCascara(ArrayList<produccion_cascara> articuloProduccionCascara) {
        this.articuloProduccionCascara = articuloProduccionCascara;
    }

    public ArrayList<produccion_insumo> getArticuloProduccionInsumo() {
        return articuloProduccionInsumo;
    }

    public void setArticuloProduccionInsumo(ArrayList<produccion_insumo> articuloProduccionInsumo) {
        this.articuloProduccionInsumo = articuloProduccionInsumo;
    }

    public double getHumedad_promedio() {
        return humedad_promedio;
    }

    public void setHumedad_promedio(double humedad_promedio) {
        this.humedad_promedio = humedad_promedio;
    }

    public double getTotal_insumos() {
        return total_insumos;
    }

    public void setTotal_insumos(double total_insumos) {
        this.total_insumos = total_insumos;
    }

    public int getNro_pro() {
        return nro_pro;
    }

    public void setNro_pro(int nro_pro) {
        this.nro_pro = nro_pro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public int getCodigo_sucursal() {
        return codigo_sucursal;
    }

    public void setCodigo_sucursal(int codigo_sucursal) {
        this.codigo_sucursal = codigo_sucursal;
    }

    public int getCantidad_sacos_arroz_cascara() {
        return cantidad_sacos_arroz_cascara;
    }

    public void setCantidad_sacos_arroz_cascara(int cantidad_sacos_arroz_cascara) {
        this.cantidad_sacos_arroz_cascara = cantidad_sacos_arroz_cascara;
    }

    public double getTotal_pilado() {
        return total_pilado;
    }

    public void setTotal_pilado(double total_pilado) {
        this.total_pilado = total_pilado;
    }

    public double getTotal_envases() {
        return total_envases;
    }

    public void setTotal_envases(double total_envases) {
        this.total_envases = total_envases;
    }

    public boolean grabarCompra() throws Exception {
        String sql = "select * from f_generar_correlativo('produccion') as numero";
        ResultSet resultado = this.ejecutarSQLSelect(sql);

        if (resultado.next()) {
            int nuevoCodigo = resultado.getInt("numero");
            setNro_pro(nuevoCodigo);

            Connection transaccion = abrirConexion();
            transaccion.setAutoCommit(false);

            sql = "INSERT INTO produccion(nro_pro, fecha, codigo_cliente, codigo_sucursal, cantidad_sacos_arroz_cascara,total_pilado, total_envases, humedad_promedio,total_insumos) VALUES (?, ?, ?, ?, ?,  ?, ?, ?,?);";
            PreparedStatement sentenciaCompra = transaccion.prepareStatement(sql);
            sentenciaCompra.setInt(1, this.getNro_pro());
            sentenciaCompra.setDate(2, this.getFecha());
            sentenciaCompra.setInt(3, this.getCodigo_cliente());
            sentenciaCompra.setInt(4, this.getCodigo_sucursal());
            sentenciaCompra.setInt(5, this.getCantidad_sacos_arroz_cascara());
            sentenciaCompra.setDouble(6, this.getTotal_pilado());
            sentenciaCompra.setDouble(7, this.getTotal_envases());
            sentenciaCompra.setDouble(8, this.getHumedad_promedio());
            sentenciaCompra.setDouble(9, this.getTotal_insumos());
            this.ejecutarSQL(sentenciaCompra, transaccion);

            for (int i = 0; i < articuloProduccionDetalle.size(); i++) {
                produccionDetalle fila = articuloProduccionDetalle.get(i);
                sql = "INSERT INTO produccion_detalle(nro_pro, codigo_producto, cantidad_sacos, cantidad_kilos, precio_pilado,importe_pilado, codigo_envase, cantidad_envases_utilizados, precio_envase,importe_envases, sub_total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement sentenciaCompraDetalle = transaccion.prepareStatement(sql);
                sentenciaCompraDetalle.setInt(1, this.getNro_pro());
                sentenciaCompraDetalle.setInt(2, fila.getCodigo_producto());
                sentenciaCompraDetalle.setInt(3, fila.getCantidad_sacos());
                sentenciaCompraDetalle.setInt(4, fila.getCantidad_kilos());
                sentenciaCompraDetalle.setDouble(5, fila.getPrecio_pilado());
                sentenciaCompraDetalle.setDouble(6, fila.getImporte_pilado());
                sentenciaCompraDetalle.setInt(7, fila.getCodigo_envase());
                sentenciaCompraDetalle.setInt(8, fila.getCantidad_envases_utilizados());
                sentenciaCompraDetalle.setDouble(9, fila.getPrecio_envase());
                sentenciaCompraDetalle.setDouble(10, fila.getImporte_envases());
                sentenciaCompraDetalle.setDouble(11, fila.getSub_total());
                this.ejecutarSQL(sentenciaCompraDetalle, transaccion);

                sql = "UPDATE articulo  SET stock=stock + ? WHERE codigo_articulo=?";
                PreparedStatement sentenciaActualizarProducto = transaccion.prepareStatement(sql);
                sentenciaActualizarProducto.setInt(1, fila.getCantidad_envases_utilizados());
                sentenciaActualizarProducto.setInt(2, fila.getCodigo_producto());
                this.ejecutarSQL(sentenciaActualizarProducto, transaccion);

                sql = "UPDATE articulo  SET stock=stock - ? WHERE codigo_articulo=?";
                PreparedStatement sentenciaActualizarEnvase = transaccion.prepareStatement(sql);
                sentenciaActualizarEnvase.setInt(1, fila.getCantidad_envases_utilizados());
                sentenciaActualizarEnvase.setInt(2, fila.getCodigo_envase());
                this.ejecutarSQL(sentenciaActualizarEnvase, transaccion);
            }

            for (int i = 0; i < articuloProduccionCascara.size(); i++) {
                produccion_cascara fila = articuloProduccionCascara.get(i);
                sql = "INSERT INTO produccion_cascara("
                        + "            nro_pro, codigo_cascara, cantidad_sacos, porcentaje_humedad)"
                        + "    VALUES (?, ?, ?, ?);";
                PreparedStatement sentenciaProduccionCascara = transaccion.prepareStatement(sql);
                sentenciaProduccionCascara.setInt(1, this.getNro_pro());
                sentenciaProduccionCascara.setInt(2, fila.getCodigo_cascara());
                sentenciaProduccionCascara.setInt(3, fila.getCantidad_sacos());
                sentenciaProduccionCascara.setDouble(4, fila.getPorcentaje_humedad());
                this.ejecutarSQL(sentenciaProduccionCascara, transaccion);
            }

            for (int i = 0; i < articuloProduccionInsumo.size(); i++) {
                produccion_insumo fila = articuloProduccionInsumo.get(i);
                sql = "INSERT INTO produccion_insumo("
                        + "            nro_pro, codigo_insumo, cantidad, precio)"
                        + "    VALUES (?, ?, ?, ?);";
                PreparedStatement sentenciaProduccionCascara = transaccion.prepareStatement(sql);
                sentenciaProduccionCascara.setInt(1, this.getNro_pro());
                sentenciaProduccionCascara.setInt(2, fila.getCodigo_insumo());
                sentenciaProduccionCascara.setDouble(3, fila.getCantidad());
                sentenciaProduccionCascara.setDouble(4, fila.getPrecio());
                this.ejecutarSQL(sentenciaProduccionCascara, transaccion);
            }

            sql = "update correlativo set numero = numero+1 where tabla='produccion'";
            PreparedStatement actualizarCorrelativo = transaccion.prepareStatement(sql);
            this.ejecutarSQL(actualizarCorrelativo, transaccion);

            transaccion.commit();
            transaccion.close();
        } else {
            throw new Exception("No existe un correlativo para la tabla produccion");
        }
        return true;
    }
//

    public ResultSet listarPorFecha(java.sql.Date fecha1, java.sql.Date fecha2, int tip) throws Exception {
        String sql = "select * from f_listado_produccion(?,?,?)";
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        sentencia.setDate(1, fecha1);
        sentencia.setDate(2, fecha2);
        sentencia.setInt(3, tip);

        ResultSet resultado = ejecutarSQLSelectSP(sentencia);
        return resultado;
    }

    public boolean anular(int numeroCompra) throws Exception {
        String sql = "select * from produccion where nro_pro=?";
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql);
        sentencia.setInt(1, numeroCompra);
        ResultSet resultado = this.ejecutarSQLSelectSP(sentencia);

        if (resultado.next()) {
            if (resultado.getString("estado").equalsIgnoreCase("A")) {
                throw new Exception("La produccion que intenta anular ya ha sido anulado");
            } else {

                Connection transaccion = this.abrirConexion();
                transaccion.setAutoCommit(false);

                sql = "update produccion set estado = 'A' where nro_pro=?";
                PreparedStatement sentenciaAnular = transaccion.prepareStatement(sql);
                sentenciaAnular.setInt(1, numeroCompra);
                ejecutarSQL(sentenciaAnular, transaccion);

                sql = "select * from produccion_detalle where nro_pro=?";
                PreparedStatement sentenciaArticuloCompra = this.abrirConexion().prepareStatement(sql);
                sentenciaArticuloCompra.setInt(1, numeroCompra);
                ResultSet resultadoArticuloCompra = ejecutarSQLSelectSP(sentenciaArticuloCompra);

                while (resultadoArticuloCompra.next()) {

                    sql = "UPDATE articulo  SET stock=stock - ? WHERE codigo_articulo=?";
                    PreparedStatement sentenciaActualizarProducto = transaccion.prepareStatement(sql);
                    sentenciaActualizarProducto.setInt(1, resultadoArticuloCompra.getInt("cantidad_envases_utilizados"));
                    sentenciaActualizarProducto.setInt(2, resultadoArticuloCompra.getInt("codigo_producto"));
                    this.ejecutarSQL(sentenciaActualizarProducto, transaccion);

                    sql = "UPDATE articulo  SET stock=stock + ? WHERE codigo_articulo=?";
                    PreparedStatement sentenciaActualizarEnvase = transaccion.prepareStatement(sql);
                    sentenciaActualizarEnvase.setInt(1, resultadoArticuloCompra.getInt("cantidad_envases_utilizados"));
                    sentenciaActualizarEnvase.setInt(2, resultadoArticuloCompra.getInt("codigo_envase"));
                    this.ejecutarSQL(sentenciaActualizarEnvase, transaccion);

                }

                transaccion.commit();
                transaccion.close();

            }
        } else {
            throw new Exception("No se ha encontrado la produccion que quiere anular");
        }
        return true;
    }

    public ResultSet listarCompraDetalle(int numeroCompra) throws Exception {
        String sql = " select tb4.nro_pro,tb3.producto,tb4.cantidad_sacos,tb4.cantidad_kilos,tb4.precio_pilado,tb4.importe_pilado,tb3.envase,tb4.cantidad_envases_utilizados,tb4.precio_envase,tb4.importe_envases,tb4.sub_total from"
                + " (select tb1.codigo as codigo_producto,tb1.nombre as producto,tb1.peso_producto,tb1.precio_pilado,tb1.codigo_envase,tb2.nombre as envase,tb2.precio_envase"
                + " from"
                + " (select * from articulo where linea='P') as tb1"
                + " inner join"
                + " (select * from articulo where linea='E') as tb2"
                + " on tb1.codigo_envase=tb2.codigo) as tb3"
                + " inner join"
                + " (select * from produccion_detalle) as tb4"
                + " on tb3.codigo_producto=tb4.codigo_producto and tb3.codigo_envase=tb4.codigo_envase"
                + " where tb4.nro_pro=?";
        PreparedStatement sentencia = abrirConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        sentencia.setInt(1, numeroCompra);

        ResultSet resultado = ejecutarSQLSelectSP(sentencia);
        return resultado;
    }

}
