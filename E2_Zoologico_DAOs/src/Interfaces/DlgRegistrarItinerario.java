/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Interfaces;

import DAOs.*;
import dominio.*;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MoonA
 */
public class DlgRegistrarItinerario extends javax.swing.JDialog {

    /**
     * Atributos del Dlg
     */
    IConexionDB conexion = new ConexionDB();
    ItinerariosDAO itinerarioDAO = new ItinerariosDAO();
    ZonasDAO zonasDAO = new ZonasDAO();
    GuiaDAO guiaDAO = new GuiaDAO(conexion);
    EmpleadosDAO empleadoDAO = new EmpleadosDAO();

    /**
     * Creates new form DlgRegistrarItinerario
     */
    public DlgRegistrarItinerario() {
        initComponents();
        this.setVisible(true);
        llenarTablaGuias();
        llenarTablaZonas();

    }

    /**
     * Método que permite llenar la tabla de las zonas
     */
    private void llenarTablaZonas() {
        List<Zona> listaZonas = this.zonasDAO.consultarTodos();

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblZonas.getModel();

        modeloTabla.setRowCount(0);

        listaZonas.forEach(zona -> {
            Object[] fila = new Object[3];
            fila[0] = zona.getIdZona();
            fila[1] = zona.getNombreZona();
            fila[2] = zona.getExtension();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Método que permite obtener los guias
     *
     * @return
     */
    public List<Empleado> obtenerGuia() {
        List<Empleado> listaGuias = new LinkedList<>();
        for (int i = 0; i < guiaDAO.consultarTodo().size(); i++) {
            Empleado empleado = empleadoDAO.consultarEmpleado(guiaDAO.consultarTodo().get(i).getIdEmpleado());
            listaGuias.add(empleado);
        }
        return listaGuias;
    }

    /**
     * Método que permite llenar la tabla de los guias
     */
    private void llenarTablaGuias() {
        List<Empleado> listaEmpleados = this.obtenerGuia();

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblGuias.getModel();

        modeloTabla.setRowCount(0);
        listaEmpleados.forEach(empleado -> {
            Object[] fila = new Object[2];
            fila[0] = empleado.getIdEmpleado();
            fila[1] = empleado.getNombre();
            modeloTabla.addRow(fila);
        });
    }

    /**
     * Método que permite habilitar los campos del dlg
     */
    public void habilitarCampos() {
        this.txtNombreItinerarioNuevo.setEditable(false);
        this.txtLongitud.setEnabled(true);
        this.txtVisitantesMax.setEnabled(true);
        this.txtIdZona.setEnabled(true);
        this.txtDuracion1.setEnabled(true);
        this.chkBxLunes.setEnabled(true);
        this.chkBxMartes.setEnabled(true);
        this.chkBoxMiercoles.setEnabled(true);
        this.chkBxJueves.setEnabled(true);
        this.chkBxViernes.setEnabled(true);
        this.txtHoraInicio.setEnabled(true);
        this.btnGuardar.setEnabled(true);
        this.txtIdGuia.setEnabled(true);
        this.txtNombreBuscar.setEditable(false);
    }

    /**
     * Método que permite verificar en nombre ingresado
     */
    public void verificarNombre() {
        for (int i = 0; i < itinerarioDAO.consultarTodos().size(); i++) {
            if (itinerarioDAO.consultarTodos().get(i).getNombre().equalsIgnoreCase(txtNombreBuscar.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Nombre repetido, favor ingresar otro");
            } else if (!itinerarioDAO.consultarTodos().get(i).getNombre().equalsIgnoreCase(txtNombreBuscar.getText())) {
                habilitarCampos();
                txtNombreItinerarioNuevo.setText(txtNombreBuscar.getText());
            }
        }
    }

    /**
     * Método que permite hacer funcio AI
     *
     * @return
     */
    public long aumentarId() {
        long contador = 0;
        for (int i = 0; i < itinerarioDAO.consultarTodos().size(); i++) {
            if (contador < itinerarioDAO.consultarTodos().get(i).getIdItinerario()) {
                contador = itinerarioDAO.consultarTodos().get(i).getIdItinerario() + 1;
            }
        }
        return contador;
    }

    /**
     * Método que permite obtener los días de los checkBox
     *
     * @return
     */
    public String getDia() {
        String dia = null;
        if (chkBxLunes.isSelected()) {
            chkBxMartes.setEnabled(false);
            chkBoxMiercoles.setEnabled(false);
            chkBxJueves.setEnabled(false);
            chkBxViernes.setEnabled(false);
            dia = "Lunes";
        } else if (chkBxMartes.isSelected()) {
            chkBxLunes.setEnabled(false);
            chkBoxMiercoles.setEnabled(false);
            chkBxJueves.setEnabled(false);
            chkBxViernes.setEnabled(false);
            dia = "Martes";
        } else if (chkBoxMiercoles.isSelected()) {
            chkBxLunes.setEnabled(false);
            chkBxMartes.setEnabled(false);
            chkBxJueves.setEnabled(false);
            chkBxViernes.setEnabled(false);
            dia = "Miércoles";
        } else if (chkBxJueves.isSelected()) {
            chkBxLunes.setEnabled(false);
            chkBxMartes.setEnabled(false);
            chkBoxMiercoles.setEnabled(false);
            chkBxViernes.setEnabled(false);
            dia = "Jueves";
        } else if (chkBxViernes.isSelected()) {
            chkBxLunes.setEnabled(false);
            chkBxMartes.setEnabled(false);
            chkBoxMiercoles.setEnabled(false);
            chkBxJueves.setEnabled(false);
            dia = "Viernes";
        }
        return dia;
    }

    public void guardar() {
        Itinerario itinerarioNuevo = new Itinerario(aumentarId(), Long.valueOf(txtIdGuia.getText()), Integer.valueOf(txtVisitantesMax.getText()), Integer.valueOf(txtIdZona.getText()),
                Double.valueOf(txtLongitud.getText()), txtDuracion1.getText(), getDia(), txtHoraInicio.getText(), txtNombreItinerarioNuevo.getText());
        itinerarioDAO.agregar(itinerarioNuevo);
        txtDIAAAA.setText(getDia());
        JOptionPane.showMessageDialog(rootPane, "Se ha guardado correctamente");
        dispose();
    }

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblZonas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGuias = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLongitud = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDuracion1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtVisitantesMax = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        chkBxLunes = new javax.swing.JCheckBox();
        chkBxMartes = new javax.swing.JCheckBox();
        chkBoxMiercoles = new javax.swing.JCheckBox();
        chkBxJueves = new javax.swing.JCheckBox();
        chkBxViernes = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtNombreItinerarioNuevo = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        txtNombreBuscar = new javax.swing.JTextField();
        txtIdGuia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIdZona = new javax.swing.JTextField();
        txtDIAAAA = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar itinerario");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1048, 900));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        lblRegistrarHabitat.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        lblRegistrarHabitat.setText("Registrar itinerario");

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
            .addGap(0, 61, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblRegistrarHabitat)
                    .addGap(0, 15, Short.MAX_VALUE)))
        );

        tblZonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id zona", "Nombre", "Extensión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblZonas);

        tblGuias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id guia", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblGuias);

        jLabel8.setText("Zonas del zoológico");

        jLabel9.setText("Guías registrados");

        jLabel10.setText("Nombre:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar itinerario");

        jLabel2.setText("Registrar itinerario");

        jLabel3.setText("Longitud:");

        txtLongitud.setEnabled(false);

        jLabel4.setText("Duración:");

        txtDuracion1.setEnabled(false);

        jLabel5.setText("Días:");

        txtVisitantesMax.setEnabled(false);
        txtVisitantesMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVisitantesMaxActionPerformed(evt);
            }
        });

        jLabel6.setText("Visitantes max.:");

        jLabel7.setText("Hora de inicio:");

        txtHoraInicio.setEnabled(false);

        chkBxLunes.setText("Lu");
        chkBxLunes.setEnabled(false);

        chkBxMartes.setText("Ma");
        chkBxMartes.setEnabled(false);

        chkBoxMiercoles.setText("Mi");
        chkBoxMiercoles.setEnabled(false);

        chkBxJueves.setText("Ju");
        chkBxJueves.setEnabled(false);

        chkBxViernes.setText("Vi");
        chkBxViernes.setEnabled(false);

        jLabel11.setText("Id zonas: ");

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel12.setText("Nombre:");

        txtNombreItinerarioNuevo.setEditable(false);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtIdGuia.setEnabled(false);

        jLabel13.setText("Id del guia:");

        txtIdZona.setEnabled(false);

        txtDIAAAA.setText("jTextField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegresar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtLongitud, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                .addComponent(txtNombreItinerarioNuevo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVisitantesMax, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                                    .addComponent(txtIdZona))))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkBxLunes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBxMartes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBoxMiercoles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBxJueves)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkBxViernes)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDuracion1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(382, 382, 382)))
                .addGap(43, 43, 43))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel8)
                                .addGap(382, 382, 382)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(txtDIAAAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(568, 568, 568))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(txtDIAAAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNombreItinerarioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtDuracion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNombreBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(chkBxLunes)
                    .addComponent(chkBxMartes)
                    .addComponent(chkBoxMiercoles)
                    .addComponent(chkBxJueves)
                    .addComponent(chkBxViernes)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtVisitantesMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnRegresar)
                    .addComponent(txtIdGuia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtIdZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1426, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtVisitantesMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVisitantesMaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVisitantesMaxActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        verificarNombre();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
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
//            java.util.logging.Logger.getLogger(DlgRegistrarItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DlgRegistrarItinerario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DlgRegistrarItinerario dialog = new DlgRegistrarItinerario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JCheckBox chkBoxMiercoles;
    private javax.swing.JCheckBox chkBxJueves;
    private javax.swing.JCheckBox chkBxLunes;
    private javax.swing.JCheckBox chkBxMartes;
    private javax.swing.JCheckBox chkBxViernes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRegistrarHabitat;
    private javax.swing.JTable tblGuias;
    private javax.swing.JTable tblZonas;
    private javax.swing.JTextField txtDIAAAA;
    private javax.swing.JTextField txtDuracion1;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtIdGuia;
    private javax.swing.JTextField txtIdZona;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombreBuscar;
    private javax.swing.JTextField txtNombreItinerarioNuevo;
    private javax.swing.JTextField txtVisitantesMax;
    // End of variables declaration//GEN-END:variables
}
