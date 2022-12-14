/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Interfaces;

import javax.swing.JOptionPane;
import DAOs.*;
import dominio.Especie;
import dominio.Habitat;
import dominio.Empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MoonA
 */
public class DlgRegistrarEspecie extends javax.swing.JDialog {

    IConexionDB conexion = new ConexionDB();
    EspeciesDAO especiesDAO = new EspeciesDAO();
    HabitatDAO habitatDAO = new HabitatDAO(conexion);
    EmpleadosDAO empleadosDAO = new EmpleadosDAO();
    EspeciesCuidadoresDAO especiesCuidadoresDAO = new EspeciesCuidadoresDAO();
    ArrayList<Long> listaHabitatId = new ArrayList<>();

    /**
     * Creates new form DlgRegistrarEspecie
     */
    public DlgRegistrarEspecie() {
        initComponents();
        this.setVisible(true);
        List<Habitat> listaHabitats = habitatDAO.consultarTodos();
        for (int i = 0; i < listaHabitats.size(); i++) {
            cmboBxHabitats.addItem(listaHabitats.get(i).getNombre());
            listaHabitatId.add(listaHabitats.get(i).getIdHabitat());
        }
        List<Empleado> listaEmpleados = empleadosDAO.consultarTodos();
        for (int i = 0; i < listaEmpleados.size(); i++) {
            cmboBoxCuidador.addItem(listaEmpleados.get(i).getNombre());
        }
    }

    public void verificarNombre(String nombre) {
        boolean verificarNombre = true;
        for (int i = 0; i < especiesDAO.consultarTodos().size(); i++) {
            if (especiesDAO.consultarTodos().get(i).getNombreEspanol().equalsIgnoreCase(nombre)) {
                verificarNombre = false;
                JOptionPane.showMessageDialog(rootPane, "Especie existente");
                return;
            }
        }
        if (txtNombreEspecieAnimal.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "El nombre es necesario");
        } else if (verificarNombre) {
            activarCampos();
        }
    }
    
    public void agregarEspecie() {
        Especie especie = new Especie(autoIncrementarIdEspecie(), WIDTH, txtNombreEspa??ol.getText(),
                txtNombreCientifico.getText(), txtDescripcionGeneral.getText());
        long idHabitat = (long) cmboBxHabitats.getSelectedIndex();
        
        especiesDAO.agregar(especie, idHabitat);
    }

    public long autoIncrementarIdCuidador() {
        long contador = 0;
        for (int i = 0; i < especiesCuidadoresDAO.consultarTodos().size(); i++) {
            contador = especiesCuidadoresDAO.consultarTodos().get(i).getIdCuidador();
        }
        return contador = contador + 1;
    }

    public long autoIncrementarIdEspecie() {
        long contador = 0;
        for (int i = 0; i < especiesDAO.consultarTodos().size(); i++) {
            contador = especiesDAO.consultarTodos().get(i).getIdEspecie();
        }

        return contador = contador + 1;
    }

    public void activarCampos() {
        cmboBxHabitats.setEnabled(true);
        cmboBoxCuidador.setEnabled(true);
        txtNombreEspa??ol.setEnabled(true);
        txtNombreCientifico.setEnabled(true);
        txtDescripcionGeneral.setEnabled(true);
        btnEditarAnimales.setEnabled(true);
        btnGuardar.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmboBoxCuidador = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombreEspa??ol = new javax.swing.JTextField();
        txtNombreCientifico = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescripcionGeneral = new javax.swing.JTextField();
        btnEditarAnimales = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblRegistrarHabitat = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreEspecieAnimal = new javax.swing.JTextField();
        btnVerificarNombre = new javax.swing.JButton();
        cmboBxHabitats = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar especie");

        cmboBoxCuidador.setEnabled(false);
        cmboBoxCuidador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboBoxCuidadorActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre en espa??ol:");

        jLabel6.setText("Nombre cient??fico: ");

        txtNombreEspa??ol.setEnabled(false);

        txtNombreCientifico.setEnabled(false);

        jLabel7.setText("Descripci??n general:");

        txtDescripcionGeneral.setEnabled(false);

        btnEditarAnimales.setText("Editar animales");
        btnEditarAnimales.setEnabled(false);
        btnEditarAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAnimalesActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        lblRegistrarHabitat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblRegistrarHabitat.setText("Registrar especie");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblRegistrarHabitat)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblRegistrarHabitat)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel3.setText("Editar Animales:");

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nombre de especie animal:");

        jLabel2.setText("H??bitat:");

        jLabel4.setText("Cuidador:");

        txtNombreEspecieAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEspecieAnimalActionPerformed(evt);
            }
        });

        btnVerificarNombre.setText("Verificar nombre");
        btnVerificarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarNombreActionPerformed(evt);
            }
        });

        cmboBxHabitats.setEnabled(false);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtNombreEspecieAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnVerificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cmboBxHabitats, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmboBoxCuidador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreCientifico)
                                .addComponent(txtNombreEspa??ol)
                                .addComponent(txtDescripcionGeneral))
                            .addComponent(btnEditarAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreEspecieAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerificarNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cmboBxHabitats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmboBoxCuidador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreEspa??ol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNombreCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescripcionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnEditarAnimales))
                .addGap(47, 47, 47)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAnimalesActionPerformed
        // TODO add your handling code here:
        DlgEditarAnimal editarAnimal = new DlgEditarAnimal();
    }//GEN-LAST:event_btnEditarAnimalesActionPerformed

    private void txtNombreEspecieAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEspecieAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEspecieAnimalActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:+
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnVerificarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarNombreActionPerformed
        // TODO add your handling code here:
        verificarNombre(txtNombreEspa??ol.getText());
    }//GEN-LAST:event_btnVerificarNombreActionPerformed

    private void cmboBoxCuidadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboBoxCuidadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboBoxCuidadorActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        agregarEspecie();
    }//GEN-LAST:event_btnGuardarActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarEspecie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarEspecie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarEspecie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarEspecie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DlgRegistrarEspecie dialog = new DlgRegistrarEspecie(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarAnimales;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificarNombre;
    private javax.swing.JComboBox<String> cmboBoxCuidador;
    private javax.swing.JComboBox<String> cmboBxHabitats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRegistrarHabitat;
    private javax.swing.JTextField txtDescripcionGeneral;
    private javax.swing.JTextField txtNombreCientifico;
    private javax.swing.JTextField txtNombreEspa??ol;
    private javax.swing.JTextField txtNombreEspecieAnimal;
    // End of variables declaration//GEN-END:variables
}
