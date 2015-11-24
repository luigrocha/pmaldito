package com.espe.distribuidas.pmaldito.jclient;

import com.espe.distribuidas.pmaldito.cliente.InformacionClienteRQ;
import com.espe.distribuidas.pmaldito.jclient.controler.ClienteSocket;
import com.espe.distribuidas.pmaldito.originador.Originador;
import com.espe.distribuidas.pmaldito.pcs.Mensaje;
import com.espe.distribuidas.pmaldito.pcs.MensajeRQ;
import com.espe.distribuidas.pmaldito.producto.InformacionProductoRQ;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
public class BuscarFactura extends javax.swing.JFrame {
    private ClienteSocket cliente;
    
    DefaultTableModel modelof;
    

    /**
     * Creates new form IngresarFactura
     */
    public BuscarFactura() {
        setUndecorated(true);
        setOpacity(0.95f);
        initComponents();
        modelof= new DefaultTableModel();
        modelof.addColumn("NumeroFact");
        modelof.addColumn("FechaFact");
        modelof.addColumn("Valor");
        
        tblDatos.setModel(modelof);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new java.awt.Color(255,255,255));
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("/org/freedesktop/tango/22x22/actions/address-book-new.png"));
        this.setIconImage(imageIcon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnClientes = new javax.swing.JPanel();
        txtbuscli = new javax.swing.JTextField();
        btnbuscli = new javax.swing.JButton();
        btnbusnuevo = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnClientes.setBackground(new java.awt.Color(255, 255, 255));
        jpnClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Facturas ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 204, 0))); // NOI18N

        txtbuscli.setForeground(new java.awt.Color(102, 102, 102));
        txtbuscli.setText("Búsqueda de facturas");
        txtbuscli.setFocusable(false);
        txtbuscli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbuscliFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbuscliFocusLost(evt);
            }
        });

        btnbuscli.setBackground(new java.awt.Color(51, 153, 255));
        btnbuscli.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscli.setText("Buscar");
        btnbuscli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbuscliMouseClicked(evt);
            }
        });
        btnbuscli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscliActionPerformed(evt);
            }
        });

        btnbusnuevo.setBackground(new java.awt.Color(0, 255, 0));
        btnbusnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnbusnuevo.setText("Nuevo");
        btnbusnuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbusnuevoMouseClicked(evt);
            }
        });
        btnbusnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusnuevoActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDatos);

        javax.swing.GroupLayout jpnClientesLayout = new javax.swing.GroupLayout(jpnClientes);
        jpnClientes.setLayout(jpnClientesLayout);
        jpnClientesLayout.setHorizontalGroup(
            jpnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnClientesLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jpnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpnClientesLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtbuscli, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbusnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jpnClientesLayout.setVerticalGroup(
            jpnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscli, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscli)
                    .addComponent(btnbusnuevo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbusnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusnuevoActionPerformed
        // TODO add your handling code here:
        IngresarCliente ingcli= new IngresarCliente();
        ingcli.setCliente(cliente);
        ingcli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnbusnuevoActionPerformed

    private void btnbuscliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscliActionPerformed
        // TODO add your handling code here:
        InformacionClienteRQ inf = new InformacionClienteRQ();
        inf.setValor(txtbuscli.getText());
        MensajeRQ rq=new MensajeRQ(Originador.getOriginador(Originador.CLIENTE), Mensaje.INFO_CLIENT);
        rq.setCuerpo(inf);
        cliente.flujo(rq.asTexto());
        Object [] arr2=cliente.flujoRSc();
        //modelo.addRow(arr2);
        //tareaCli.setText(cliente.flujoRSc());
        
    }//GEN-LAST:event_btnbuscliActionPerformed

    private void txtbuscliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbuscliFocusGained
        // TODO add your handling code here:
        txtbuscli.setText(null);
    }//GEN-LAST:event_txtbuscliFocusGained

    private void txtbuscliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbuscliFocusLost
        // TODO add your handling code here:
       //txtbuscli.setText("Ingrese ID CLIENTE");
    }//GEN-LAST:event_txtbuscliFocusLost

    private void btnbuscliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbuscliMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnbuscliMouseClicked

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        // TODO add your handling code here:
        int x=tblDatos.getSelectedRow();
/*        lbNombre.setText(lbNombre.getText()+tblDatos.getValueAt(x, 2));
        lbApellido.setText(lbApellido.getText()+tblDatos.getValueAt(x, 3));
        lbRuc.setText(lbRuc.getText()+tblDatos.getValueAt(x, 1));
        lbDireccion.setText(lbDireccion.getText()+tblDatos.getValueAt(x, 4));
        lbTelefono.setText(lbTelefono.getText()+tblDatos.getValueAt(x, 5));
        lbCelular.setText(lbCelular.getText()+tblDatos.getValueAt(x, 6));
        lbCorreo.setText(lbCorreo.getText()+tblDatos.getValueAt(x, 7));*/
    }//GEN-LAST:event_tblDatosMouseClicked

    private void btnbusnuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbusnuevoMouseClicked
        // TODO add your handling code here:
        IngresarFactura fact= new IngresarFactura();
        fact.setCliente(cliente);
        fact.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnbusnuevoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscli;
    private javax.swing.JButton btnbusnuevo;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpnClientes;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtbuscli;
    // End of variables declaration//GEN-END:variables

    public ClienteSocket getCliente() {
        return cliente;
    }

    public void setCliente(ClienteSocket cliente) {
        this.cliente = cliente;
    }
}
