/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Interfaces;

import DAOs.*;
import dominio.Habitat;
import javax.swing.JOptionPane;

/**
 *
 * @author MoonA
 */
public class DlgRegistrarHabitat extends javax.swing.JDialog {

    /**
     * Atributos de la clase
     */
    IConexionDB conexion = new ConexionDB();
    HabitatDAO habitatDAO = new HabitatDAO(conexion);
    HabitatContinenteDAO habitatContinenteDAO = new HabitatContinenteDAO(conexion);
    ContinentesDAO cDAO = new ContinentesDAO();

    /**
     * Creates new form DlgRegistrarHabitat
     */
    public DlgRegistrarHabitat() {
        initComponents();
        this.setVisible(true);
    }

    /**
     * Método que permite verificar el nombre ingresado
     *
     * @param nombre
     */
    public void verificarNombre(String nombre) {
        boolean verificarNombre = true;
        for (int i = 0; i < habitatDAO.consultarTodos().size(); i++) {
            if (habitatDAO.consultarTodos().get(i).getNombre().equalsIgnoreCase(nombre)) {
                verificarNombre = false;
                JOptionPane.showMessageDialog(rootPane, "Habitat existente");
            }
            break;
        }
        if (txtNombreHabitat.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "El nombre es necesario");
        } else if (verificarNombre) {
            activarCampos();
        }

    }

    /**
     * Métoodo que permite autoincrementar el id de los habitatcontinente
     *
     * @return
     */
    public long autoIncrementarIdHabitatC() {
        long contador = 0;
        for (int i = 0; i < habitatContinenteDAO.consultarTodo().size(); i++) {
            contador = habitatContinenteDAO.consultarTodo().get(i).getIdHabitatContinente();
        }
        return contador = contador + 1;
    }

    /**
     * Método que permite autoincrementar el id del habitat
     *
     * @return
     */
    public long autoIncrementarIdHabitat() {
        long contador = 0;
        for (int i = 0; i < habitatDAO.consultarTodos().size(); i++) {
            contador = habitatDAO.consultarTodos().get(i).getIdHabitat();
        }
        return contador = contador + 1;
    }

    /**
     * Método que permite activar todos los campos del dlg
     */
    public void activarCampos() {
        cmboBxClimas.setEnabled(true);
        cmboBoxTipoVegetacion.setEnabled(true);
        chkBoxAmerica.setEnabled(true);
        chkBoxEuropa.setEnabled(true);
        chkBoxAsia.setEnabled(true);
        chkBoxAfrica.setEnabled(true);
        chkBoxOceania.setEnabled(true);
        btnGuardar.setEnabled(true);
    }

    /**
     * Método que permite obtener el id de un continente
     *
     * @param nombre
     * @return
     */
    public long obtenerContinente(String nombre) {
        long id = -1;
        for (int i = 0; i < cDAO.consultarTodos().size(); i++) {
            if (cDAO.consultarTodos().get(i).getNombre().equalsIgnoreCase(nombre)) {
                id = cDAO.consultarTodos().get(i).getIdContinente();
            }
        }
        return id;
    }

    /**
     * Método que permite crear un habitat
     */
    public void agregarHabitat() {
        Habitat hab = new Habitat(autoIncrementarIdHabitat(), txtNombreHabitat.getText(), cmboBxClimas.getSelectedItem().toString(), cmboBoxTipoVegetacion.getSelectedItem().toString());
        int cont = 0;
        while (cont < 1 ) {
            if (this.chkBoxAmerica.isSelected()) {
                long idContinente = obtenerContinente("América");
                JOptionPane.showMessageDialog(rootPane, idContinente);
                cont++;
                habitatContinenteDAO.agregar(autoIncrementarIdHabitatC(), hab, idContinente);
            }
            if (this.chkBoxEuropa.isSelected()) {
                long idContinente = obtenerContinente("Europa");
                habitatContinenteDAO.agregar(autoIncrementarIdHabitatC(), hab, idContinente);
                cont++;
            }
            if (this.chkBoxAfrica.isSelected()) {
                long idContinente = obtenerContinente("África");
                habitatContinenteDAO.agregar(autoIncrementarIdHabitatC(), hab, idContinente);
                cont++;
            }
            if (this.chkBoxAsia.isSelected()) {
                long idContinente = obtenerContinente("Asia");
                habitatContinenteDAO.agregar(autoIncrementarIdHabitatC(), hab, idContinente);
                cont++;
            }
            if (this.chkBoxOceania.isSelected()) {
                long idContinente = obtenerContinente("Oceanía");
                habitatContinenteDAO.agregar(autoIncrementarIdHabitatC(), hab, idContinente);
                cont++;
            } 
            if(cont < 1) {
                JOptionPane.showMessageDialog(rootPane, "Es necesario elegir un continente");

            }
        }

        habitatDAO.agregar(hab);
    }

//    /**
//     * Object []ob = chkBoxAmerica.getSelectedObjects();
//     * JOptionPane.showMessageDialog(rootPane, ob.length);
//     * habitatDAO.agregar(hab); Método que valida que haya al menos un
//     * continente seleccionado
//     */
//    public void verificarGuardado() {
//        if (chkBoxAmerica.getSelectedObjects() == null || chkBoxEuropa.getSelectedObjects() == null
//                || chkBoxAsia.getSelectedObjects() == null || chkBoxAfrica.getSelectedObjects() == null
//                || chkBoxOceania.getSelectedObjects() == null) {
//            JOptionPane.showMessageDialog(rootPane, "Es necesario elegir un continente");
//        } else {
//            agregarHabitat();
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblRegistrarHabitat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chkBoxAmerica = new javax.swing.JCheckBox();
        chkBoxEuropa = new javax.swing.JCheckBox();
        chkBoxOceania = new javax.swing.JCheckBox();
        chkBoxAsia = new javax.swing.JCheckBox();
        chkBoxAfrica = new javax.swing.JCheckBox();
        txtNombreHabitat = new javax.swing.JTextField();
        btnVerificarNombre = new javax.swing.JButton();
        cmboBxClimas = new javax.swing.JComboBox<>();
        cmboBoxTipoVegetacion = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar hábitat");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        lblRegistrarHabitat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblRegistrarHabitat.setText("Registrar hábitat");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
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

        jLabel1.setText("Nombre del hábitat:");

        jLabel2.setText("Clima:");

        jLabel3.setText("Continentes:");

        jLabel4.setText("Tipo de vegetación:");

        chkBoxAmerica.setText("América");
        chkBoxAmerica.setEnabled(false);

        chkBoxEuropa.setText("Europa");
        chkBoxEuropa.setEnabled(false);

        chkBoxOceania.setText("Oceanía");
        chkBoxOceania.setEnabled(false);

        chkBoxAsia.setText("Asia");
        chkBoxAsia.setEnabled(false);

        chkBoxAfrica.setText("África");
        chkBoxAfrica.setEnabled(false);

        btnVerificarNombre.setText("Verificar nombre");
        btnVerificarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarNombreActionPerformed(evt);
            }
        });

        cmboBxClimas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tropical", "Seco", "Templado", "Continental", "Polar" }));
        cmboBxClimas.setEnabled(false);

        cmboBoxTipoVegetacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tundra", "Taiga", "Selva", "Bosque", "Desierto", "Sabana", "Pradera", "Páramo" }));
        cmboBoxTipoVegetacion.setEnabled(false);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmboBxClimas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmboBoxTipoVegetacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(chkBoxAmerica)
                                    .addGap(18, 18, 18)
                                    .addComponent(chkBoxEuropa)
                                    .addGap(18, 18, 18)
                                    .addComponent(chkBoxAsia)
                                    .addGap(18, 18, 18)
                                    .addComponent(chkBoxAfrica)
                                    .addGap(18, 18, 18)
                                    .addComponent(chkBoxOceania))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtNombreHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnVerificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerificarNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cmboBxClimas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmboBoxTipoVegetacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chkBoxAmerica)
                    .addComponent(chkBoxEuropa)
                    .addComponent(chkBoxOceania)
                    .addComponent(chkBoxAsia)
                    .addComponent(chkBoxAfrica))
                .addGap(41, 41, 41)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnVerificarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarNombreActionPerformed
        // TODO add your handling code here:
        verificarNombre(txtNombreHabitat.getText());
    }//GEN-LAST:event_btnVerificarNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        agregarHabitat();
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
//            java.util.logging.Logger.getLogger(DlgRegistrarHabitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarHabitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarHabitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarHabitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DlgRegistrarHabitat dialog = new DlgRegistrarHabitat(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificarNombre;
    private javax.swing.JCheckBox chkBoxAfrica;
    private javax.swing.JCheckBox chkBoxAmerica;
    private javax.swing.JCheckBox chkBoxAsia;
    private javax.swing.JCheckBox chkBoxEuropa;
    private javax.swing.JCheckBox chkBoxOceania;
    private javax.swing.JComboBox<String> cmboBoxTipoVegetacion;
    private javax.swing.JComboBox<String> cmboBxClimas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblRegistrarHabitat;
    private javax.swing.JTextField txtNombreHabitat;
    // End of variables declaration//GEN-END:variables
}
