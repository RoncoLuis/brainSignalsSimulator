/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author KeepToo
 */
public class View_administrador extends javax.swing.JFrame {
TableRowSorter tsrfiltro;
    /**
     * Creates new form Home
     */
    public View_administrador() {
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

        jPanel1 = new javax.swing.JPanel();
        Button1 = new javax.swing.JPanel();
        lblPaginaWeb = new javax.swing.JLabel();
        Button2 = new javax.swing.JPanel();
        lblNuevo = new javax.swing.JLabel();
        Button3 = new javax.swing.JPanel();
        lblEliminar = new javax.swing.JLabel();
        Button4 = new javax.swing.JPanel();
        lblActualizar = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_uregistrados = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_eregistrados = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_dregistrados = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_close = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_iregistrados = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        itmBuscar = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Button1.setBackground(new java.awt.Color(255, 255, 255));
        Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button1MouseExited(evt);
            }
        });

        lblPaginaWeb.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPaginaWeb.setForeground(new java.awt.Color(181, 77, 180));
        lblPaginaWeb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPaginaWeb.setText("Página web");
        lblPaginaWeb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Button1Layout = new javax.swing.GroupLayout(Button1);
        Button1.setLayout(Button1Layout);
        Button1Layout.setHorizontalGroup(
            Button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPaginaWeb, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        Button1Layout.setVerticalGroup(
            Button1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPaginaWeb, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel1.add(Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, 232, -1));

        Button2.setBackground(new java.awt.Color(255, 255, 255));
        Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button2MouseExited(evt);
            }
        });

        lblNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNuevo.setForeground(new java.awt.Color(96, 83, 150));
        lblNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNuevo.setText("Nuevo usuario");
        lblNuevo.setToolTipText("Registra a un nuevo usuario");
        lblNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Button2Layout = new javax.swing.GroupLayout(Button2);
        Button2.setLayout(Button2Layout);
        Button2Layout.setHorizontalGroup(
            Button2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        Button2Layout.setVerticalGroup(
            Button2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel1.add(Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 227, 232, -1));

        Button3.setBackground(new java.awt.Color(255, 255, 255));
        Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button3MouseExited(evt);
            }
        });

        lblEliminar.setBackground(new java.awt.Color(255, 255, 255));
        lblEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEliminar.setForeground(new java.awt.Color(96, 83, 150));
        lblEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEliminar.setText("Eliminar usuario");
        lblEliminar.setToolTipText("Elimina al usuario seleccionado de la tabla");
        lblEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Button3Layout = new javax.swing.GroupLayout(Button3);
        Button3.setLayout(Button3Layout);
        Button3Layout.setHorizontalGroup(
            Button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        Button3Layout.setVerticalGroup(
            Button3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel1.add(Button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 279, 232, -1));

        Button4.setBackground(new java.awt.Color(255, 255, 255));
        Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button4MouseExited(evt);
            }
        });

        lblActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblActualizar.setForeground(new java.awt.Color(96, 83, 150));
        lblActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActualizar.setText("Actualizar");
        lblActualizar.setToolTipText("Actualiza la lista de usuarios y las estadísticas");
        lblActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout Button4Layout = new javax.swing.GroupLayout(Button4);
        Button4.setLayout(Button4Layout);
        Button4Layout.setHorizontalGroup(
            Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        Button4Layout.setVerticalGroup(
            Button4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel1.add(Button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 331, 232, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/imagenes/iconos/usuarios icon/estudiante/estudiante72px.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jPanel14.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

        jPanel13.setBackground(new java.awt.Color(96, 83, 150));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 530));

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(96, 83, 150));
        jLabel5.setText("Bienvenido administrador");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 23, 270, 37));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbl_uregistrados.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_uregistrados.setForeground(new java.awt.Color(96, 83, 150));
        lbl_uregistrados.setText("100");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(96, 83, 150));
        jLabel6.setText("Total");

        jPanel11.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_uregistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lbl_uregistrados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(96, 83, 150));
        jLabel7.setText("Usuarios registrados");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 102, 124, 41));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_eregistrados.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_eregistrados.setForeground(new java.awt.Color(96, 83, 150));
        lbl_eregistrados.setText("50");
        jPanel4.add(lbl_eregistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, -1, -1));

        jPanel10.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 10));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(96, 83, 150));
        jLabel20.setText("Total");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 30, 10));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 130, 80));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(96, 83, 150));
        jLabel10.setText("Estudiantes");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 102, 124, 41));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dregistrados.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_dregistrados.setForeground(new java.awt.Color(96, 83, 150));
        lbl_dregistrados.setText("30");
        jPanel5.add(lbl_dregistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, 75, -1));

        jPanel12.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 10));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(96, 83, 150));
        jLabel22.setText("Total");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 30, 10));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 140, 80));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(96, 83, 150));
        jLabel12.setText("Docentes");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 106, 124, 30));

        btn_close.setBackground(new java.awt.Color(96, 83, 150));
        btn_close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("X");
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });
        jPanel2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 20, 30));

        jScrollPane1.setBackground(new java.awt.Color(247, 247, 247));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setBackground(new java.awt.Color(247, 247, 247));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Allan", "XLS", "2hrs", "$200"},
                {"Brian", "React", "1hr", "$100 per hr"},
                {"Romeo", "C#", "3 Days", "$1000"},
                {"Alex", "C++ ", "10 hrs", "$50 per hr"}
            },
            new String [] {
                "Name", "Project", "Time", "Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(247, 247, 247));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(96, 83, 150));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 730, 210));

        jPanel8.setBackground(new java.awt.Color(96, 83, 150));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 180, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(96, 83, 150));
        jLabel13.setText("Investigadores");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 124, 30));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_iregistrados.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_iregistrados.setForeground(new java.awt.Color(96, 83, 150));
        lbl_iregistrados.setText("20");
        jPanel7.add(lbl_iregistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, 75, -1));

        jPanel15.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 10));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(96, 83, 150));
        jLabel19.setText("Total");
        jPanel7.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 30, 10));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 140, 80));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Filtro:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        itmBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "tipo", "usuario", "correo", "registro" }));
        jPanel2.add(itmBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        txtBuscar.setBackground(new java.awt.Color(123, 156, 225));
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setText("Escriba aquí");
        txtBuscar.setBorder(null);
        txtBuscar.setCaretColor(new java.awt.Color(255, 255, 255));
        txtBuscar.setPreferredSize(new java.awt.Dimension(2, 20));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel2.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 780, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
       // System.exit(0);
    }//GEN-LAST:event_btn_closeMouseClicked

    private void Button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseClicked
        // TODO add your handling code here:
        onClick(Button1);
        onLeaveClick(Button2);
        onLeaveClick(Button3);
        onLeaveClick(Button4);

        //indicators
//        Indicator1.setOpaque(true);
//        Indicator2.setOpaque(false);
//        Indicator3.setOpaque(false);
//        Indicator4.setOpaque(false);

    }//GEN-LAST:event_Button1MouseClicked

    private void Button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseClicked
        // TODO add your handling code here:
        onClick(Button2);
        onLeaveClick(Button1);
        onLeaveClick(Button3);
        onLeaveClick(Button4);

        //indicators
//        Indicator1.setOpaque(false);
//        Indicator2.setOpaque(true);
//        Indicator3.setOpaque(false);
//        Indicator4.setOpaque(false);
    }//GEN-LAST:event_Button2MouseClicked

    private void Button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseClicked
        // TODO add your handling code here:
        onClick(Button3);
        onLeaveClick(Button2);
        onLeaveClick(Button1);
        onLeaveClick(Button4);

        //indicators
//        Indicator1.setOpaque(false);
//        Indicator2.setOpaque(false);
//        Indicator3.setOpaque(true);
//        Indicator4.setOpaque(false);
    }//GEN-LAST:event_Button3MouseClicked

    private void Button4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button4MouseClicked
        // TODO add your handling code here:
        onClick(Button4);
        onLeaveClick(Button2);
        onLeaveClick(Button3);
        onLeaveClick(Button1);
        //indicators
//        Indicator1.setOpaque(false);
//        Indicator2.setOpaque(false);
//        Indicator3.setOpaque(false);
//        Indicator4.setOpaque(true);
    }//GEN-LAST:event_Button4MouseClicked

    private void Button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_Button1MouseEntered

    private void Button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_Button2MouseEntered

    private void Button3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_Button3MouseEntered

    private void Button4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button4MouseEntered
        // TODO add your handling code here:]

    }//GEN-LAST:event_Button4MouseEntered

    private void Button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Button1MouseExited

    private void Button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Button2MouseExited

    private void Button3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Button3MouseExited

    private void Button4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Button4MouseExited

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar.getText());
                txtBuscar.setText(cadena);
                repaint();
                filtro();
            }
        });
        tsrfiltro = new TableRowSorter(jTable1.getModel());
        jTable1.setRowSorter(tsrfiltro);
    }//GEN-LAST:event_txtBuscarKeyTyped

     public void filtro() {
        int columna = 0;
        if (itmBuscar.getSelectedItem() == "id") {
            columna = 0;
        }
        if (itmBuscar.getSelectedItem() == "tipo") {
            columna = 1;
        }
        if (itmBuscar.getSelectedItem() == "usuario") {
            columna = 2;
        }
        if (itmBuscar.getSelectedItem() == "correo") {
            columna = 3;
        }
        if (itmBuscar.getSelectedItem() == "registro") {
            columna = 5;
        }              
        tsrfiltro.setRowFilter(RowFilter.regexFilter(txtBuscar.getText(), columna));
    }
    int xx, xy;

    //bad idea
    private void onClick(JPanel panel) {
        panel.setBackground(new Color(205, 136, 205));
    }

    private void onLeaveClick(JPanel panel) {
        panel.setBackground(Color.white);
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Button1;
    private javax.swing.JPanel Button2;
    private javax.swing.JPanel Button3;
    private javax.swing.JPanel Button4;
    public javax.swing.JLabel btn_close;
    public javax.swing.JComboBox<String> itmBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JLabel lblActualizar;
    public javax.swing.JLabel lblEliminar;
    public javax.swing.JLabel lblNuevo;
    public javax.swing.JLabel lblPaginaWeb;
    public javax.swing.JLabel lbl_dregistrados;
    public javax.swing.JLabel lbl_eregistrados;
    public javax.swing.JLabel lbl_iregistrados;
    public javax.swing.JLabel lbl_uregistrados;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
