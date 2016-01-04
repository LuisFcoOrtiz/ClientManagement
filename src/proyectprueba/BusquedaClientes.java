/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectprueba;

import com.itextpdf.text.DocumentException;
import database.SeeClient;
import database.WorkWithDatabase;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LFOM
 */
public class BusquedaClientes extends javax.swing.JFrame {
    
    //Object client to use for all methods
    SeeClient client = new SeeClient();
    
    /**
     * Creates new form BusquedaClientes
     */
    public BusquedaClientes() throws SQLException, ClassNotFoundException {
        initComponents();        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jSeparator2 = new javax.swing.JSeparator();
        verClientes = new javax.swing.JButton();
        irAIngresarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClient = new javax.swing.JTable();
        textoSalida = new javax.swing.JTextField();
        imprimirClientes = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        verClientes.setText("Visualizar clientes");
        verClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verClientesActionPerformed(evt);
            }
        });

        irAIngresarCliente.setText("Nuevo cliente");
        irAIngresarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irAIngresarClienteActionPerformed(evt);
            }
        });

        tableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Direccion", "Materia", "Cuota a pagar"
            }
        ));
        jScrollPane2.setViewportView(tableClient);

        textoSalida.setText("jTextField1");

        imprimirClientes.setIcon(new javax.swing.ImageIcon("C:\\Users\\LFOM\\Documents\\NetBeansProjects\\ProyectPrueba\\images\\printer.png")); // NOI18N
        imprimirClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imprimirClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(irAIngresarCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(verClientes)
                                        .addGap(195, 195, 195))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(verClientes)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(imprimirClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(irAIngresarCliente)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void verClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verClientesActionPerformed
        
        //To see client in interface        
        try {
            String clientPrueba = null;
            //work with database pagos.db
            client.createNewDatabase();
            clientPrueba = client.showClients("*", "nombre");            
            textoSalida.setText(clientPrueba);
            client.numberOfRows();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BusquedaClientes.class.getName()).log(Level.SEVERE, null, ex);
        } //End of try catch  
                       
    }//GEN-LAST:event_verClientesActionPerformed

    private void irAIngresarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irAIngresarClienteActionPerformed
        //Send to Client class
        try {
            //Return to Client class
            Clientes clientes = new Clientes ();
            clientes.setVisible(true);
            dispose();
            
        } catch (SQLException ex) {
            Logger.getLogger(BusquedaClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BusquedaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_irAIngresarClienteActionPerformed

    private void imprimirClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirClientesActionPerformed
        // TODO add your handling code here:        
        try {
            //Work with database
            client.createNewDatabase();                        
            //Create a PDF with clients
            client.clientInPDF();
            
        } catch (SQLException ex) {
            Logger.getLogger(BusquedaClientes.class.getName()).log(Level.SEVERE, null, ex);
            textoSalida.setText("Error a la hora de crear un documento PDF");
        } catch (ClassNotFoundException | FileNotFoundException | DocumentException ex) {
            Logger.getLogger(BusquedaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_imprimirClientesActionPerformed

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
            java.util.logging.Logger.getLogger(BusquedaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BusquedaClientes().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(BusquedaClientes.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BusquedaClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton imprimirClientes;
    private javax.swing.JButton irAIngresarCliente;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tableClient;
    private javax.swing.JTextField textoSalida;
    private javax.swing.JButton verClientes;
    // End of variables declaration//GEN-END:variables
}
