/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NEGOCIO.Alumno;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author desarrollo
 */
public class IFrmListar extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfrmListar
     */
    public IFrmListar() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnListar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Listado");

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Numero", "Becado", "Ciudad", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnListar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(btnListar)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarAlumno();
    }//GEN-LAST:event_btnListarActionPerformed

    public void listarAlumno(){
        try {
            
            
            
            
            ((DefaultTableModel)tblDatos.getModel()).setRowCount(1);
            
            Alumno objAlu=new Alumno();
            ResultSet listado=objAlu.listado();
            
            int cont;
            
            while (listado.next()) {
                cont=tblDatos.getModel().getRowCount()-1;
                
                tblDatos.getModel().setValueAt(listado.getString(1), cont, 0);
                tblDatos.getModel().setValueAt(listado.getString(2), cont, 1);
                //tblDatos.getModel().setValueAt(listado.getString(3),cont, 2);
                if (listado.getString(3).equals("1")) {
                    tblDatos.getModel().setValueAt("Becado",cont, 2);
                } else {
                    tblDatos.getModel().setValueAt("No Becado",cont, 2);
                }
                //tblDatos.getModel().setValueAt(listado.getString(4),cont, 3);
                tblDatos.getModel().setValueAt(listado.getString(4),cont, 3);
                tblDatos.getModel().setValueAt(listado.getString(5),cont, 4);
                //jTblCliente.getModel()
                //((DefaultTableModel)tblDatos.getModel()).setRowCount(tblDatos.getRowCount()+1);
                ((DefaultTableModel)tblDatos.getModel()).setRowCount(tblDatos.getRowCount()+1);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error carga");
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
