/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.sql.Date;
import java.sql.ResultSet;
import negocio.produccion;
import util.Funciones;

/**
 *
 * @author USER
 */
public class frmProduccionListado extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCompraListado
     */
    public frmProduccionListado(int ancho, int alto) {
        initComponents();
        setSize(ancho, alto);

        cargarFecha();
        rbHoy.setSelected(true);
        txtDesde.setEnabled(false);
        txtHasta.setEnabled(false);
        listar();
    }

    private void cargarFecha() {
        java.util.Date fecha = new java.util.Date();
        txtHasta.setDate(fecha);
        txtDesde.setDate(fecha);
    }

    private void listar() {
        try {
            int tipo = 0;

            if (rbHoy.isSelected()) {
                tipo = 1;
            } else if (rbFecha.isSelected()) {
                tipo = 2;
            } else if (rbTodasFechas.isSelected()) {
                tipo = 3;
            }

            java.sql.Date fecha1 = new java.sql.Date(txtDesde.getDate().getTime());
            java.sql.Date fecha2 = new java.sql.Date(txtHasta.getDate().getTime());

            ResultSet resultado = new produccion().listarPorFecha(fecha1, fecha2, tipo);

            Funciones.llenarTabla(tblCompraListado, resultado);

        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbFecha = new javax.swing.JRadioButton();
        rbHoy = new javax.swing.JRadioButton();
        rbTodasFechas = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtDesde = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtHasta = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompraListado = new javax.swing.JTable(){
            public boolean isCellEditable(int fila,int columna){
                return false;
            }
        };
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Registro de Compras");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar por fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        buttonGroup1.add(rbFecha);
        rbFecha.setText("Por Fecha");
        rbFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rbFechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rbFechaFocusLost(evt);
            }
        });
        rbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFechaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbHoy);
        rbHoy.setSelected(true);
        rbHoy.setText("Hoy");

        buttonGroup1.add(rbTodasFechas);
        rbTodasFechas.setText("Todas las Fechas");

        jLabel2.setText("Desde:");

        jLabel3.setText("Hasta: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTodasFechas)
                    .addComponent(rbHoy)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbFecha)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbHoy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbFecha)
                    .addComponent(jLabel2)
                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addComponent(rbTodasFechas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblCompraListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCompraListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCompraListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCompraListado);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Anular");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 308, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frmProduccion obj = new frmProduccion(null, true);
        obj.setTitle("Agregar Compra");
        obj.setVisible(true);

        if (obj.valorRetorno == 1) {
            this.rbHoy.setSelected(true);
            this.listar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFechaActionPerformed

    }//GEN-LAST:event_rbFechaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila = this.tblCompraListado.getSelectedRow();

        if (fila < 0) {
            Funciones.mensajeError("Debe seleccionar la compra que desea anular", "Verificar");
            return;
        }

        int r = Funciones.mensajeConfirmacion("Estas seguro de anular la compra", "Verifique");
        if (r != 0) {
            return;
        }

        int numeroCompra = Integer.parseInt(tblCompraListado.getValueAt(fila, 0).toString());

        try {
            produccion obj = new produccion();
            if (obj.anular(numeroCompra)) {
                Funciones.mensajeInformacion("La produccion ha sido anulada correctamento", Funciones.NOMBRE_SOFTWARE);
                listar();
            }
        } catch (Exception e) {
            Funciones.mensajeError(e.getMessage(), "Error");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void rbFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbFechaFocusGained

        txtHasta.setEnabled(true);
        txtDesde.setEnabled(true);

    }//GEN-LAST:event_rbFechaFocusGained

    private void rbFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rbFechaFocusLost

        txtHasta.setEnabled(false);
        txtDesde.setEnabled(false);

    }//GEN-LAST:event_rbFechaFocusLost
      public static int numeroCompra=0;
  
    private void tblCompraListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCompraListadoMouseClicked
//        
//        if (evt.getClickCount() == 2) {
//            int fila = tblCompraListado.getSelectedRow();
//            if (fila<0) {
//                Funciones.mensajeError("Debe seleccionar un registro de compra", "Error");
//            }
//            
//            numeroCompra=Integer.parseInt(tblCompraListado.getValueAt(fila, 0).toString());
//            
//            frmProduccionDetalle obj = new frmProduccionDetalle(null, true);
//            obj.setTitle("Detalle de la compra");
//            obj.setVisible(true);
//        }
        
    }//GEN-LAST:event_tblCompraListadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbFecha;
    private javax.swing.JRadioButton rbHoy;
    private javax.swing.JRadioButton rbTodasFechas;
    private javax.swing.JTable tblCompraListado;
    private com.toedter.calendar.JDateChooser txtDesde;
    private com.toedter.calendar.JDateChooser txtHasta;
    // End of variables declaration//GEN-END:variables
}
