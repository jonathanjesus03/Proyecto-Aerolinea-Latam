package VIEW1.VIEW2;

import VIEW1.Dashboard;
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Samsung
 */
public class nuevo_pasajero extends javax.swing.JPanel {

    /**
     * Creates new form Principal
     */
    public nuevo_pasajero() {
        initComponents();
        
        Nombrestxt.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del Pasajero");
        Apellidostxt.putClientProperty("JTextField.placeholderText", "Ingrese el apellido del Pasajero");
        edadtxt.putClientProperty("JTextField.placeholderText", "Ingrese la edad del Pasajero");
        Contactotxt.putClientProperty("JTextField.placeholderText", "Numero de contacto del Pasajero ");
        Emailtxt.putClientProperty("JTextField.placeholderText", "Ingrese el correo del Pasajero");
        Documentotxt.putClientProperty("JTextField.placeholderText", "Ingrese el N. de documento del Pasajero");
        discapacidadtxt.putClientProperty("JTextField.placeholderText", "(Campo Opcional)");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        Nombrestxt = new javax.swing.JTextField();
        lbNombre = new javax.swing.JLabel();
        lbNuevoPasajero = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        Apellidostxt = new javax.swing.JTextField();
        lbEdad = new javax.swing.JLabel();
        edadtxt = new javax.swing.JTextField();
        lbDocumento = new javax.swing.JLabel();
        Documentotxt = new javax.swing.JTextField();
        lbContacto = new javax.swing.JLabel();
        Contactotxt = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        Emailtxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lbPosibleDiscapacidad = new javax.swing.JLabel();
        discapacidadtxt = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        lb_back = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(710, 403));
        setPreferredSize(new java.awt.Dimension(710, 403));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(710, 403));
        bg.setPreferredSize(new java.awt.Dimension(710, 390));

        Nombrestxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombrestxtActionPerformed(evt);
            }
        });

        lbNombre.setText("Nombre");

        lbNuevoPasajero.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        lbNuevoPasajero.setForeground(new java.awt.Color(0, 0, 0));
        lbNuevoPasajero.setText("Nuevo Pasajero");

        lbApellido.setText("Apellido");

        Apellidostxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidostxtActionPerformed(evt);
            }
        });

        lbEdad.setText("Edad");

        edadtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edadtxtActionPerformed(evt);
            }
        });

        lbDocumento.setText("Documento");

        Documentotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocumentotxtActionPerformed(evt);
            }
        });

        lbContacto.setText("Contacto");

        Contactotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactotxtActionPerformed(evt);
            }
        });

        lbEmail.setText("Email");

        Emailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailtxtActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbPosibleDiscapacidad.setText("Posible discapacidad");

        discapacidadtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                discapacidadtxtFocusGained(evt);
            }
        });
        discapacidadtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                discapacidadtxtMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                discapacidadtxtMouseReleased(evt);
            }
        });
        discapacidadtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discapacidadtxtActionPerformed(evt);
            }
        });

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setActionCommand("");
        btnRegistrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnRegistrarFocusLost(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lb_back.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        lb_back.setForeground(new java.awt.Color(191, 191, 191));
        lb_back.setText("<<<");
        lb_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_backMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbNuevoPasajero, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addGap(345, 345, 345)
                .addComponent(lb_back, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(104, 104, 104))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Documentotxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edadtxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Apellidostxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombrestxt))
                        .addGap(48, 48, 48)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPosibleDiscapacidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Contactotxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Emailtxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discapacidadtxt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbNuevoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(lbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(Nombrestxt)
                                .addGap(12, 12, 12)
                                .addComponent(lbApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(Apellidostxt)
                                .addGap(12, 12, 12)
                                .addComponent(lbEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(edadtxt)
                                .addGap(12, 12, 12)
                                .addComponent(lbDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(Documentotxt))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(lbContacto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(Contactotxt)
                                .addGap(12, 12, 12)
                                .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(Emailtxt)
                                .addGap(12, 12, 12)
                                .addComponent(lbPosibleDiscapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6)
                                .addComponent(discapacidadtxt)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addGap(20, 20, 20)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NombrestxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombrestxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombrestxtActionPerformed

    private void ApellidostxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidostxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ApellidostxtActionPerformed

    private void edadtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edadtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edadtxtActionPerformed

    private void DocumentotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocumentotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DocumentotxtActionPerformed

    private void ContactotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactotxtActionPerformed

    private void EmailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailtxtActionPerformed

    private void discapacidadtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discapacidadtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discapacidadtxtActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void lb_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_backMouseClicked
    }//GEN-LAST:event_lb_backMouseClicked

    private void lb_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_backMouseEntered
        lb_back.setForeground(Color.BLACK);
    }//GEN-LAST:event_lb_backMouseEntered

    private void lb_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_backMouseExited
        lb_back.setForeground(new Color(191,191,191));
    }//GEN-LAST:event_lb_backMouseExited

    private void discapacidadtxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discapacidadtxtMouseClicked

    }//GEN-LAST:event_discapacidadtxtMouseClicked

    private void discapacidadtxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discapacidadtxtFocusGained

    }//GEN-LAST:event_discapacidadtxtFocusGained

    private void btnRegistrarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnRegistrarFocusLost
      
    }//GEN-LAST:event_btnRegistrarFocusLost

    private void discapacidadtxtMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_discapacidadtxtMouseReleased

    }//GEN-LAST:event_discapacidadtxtMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Apellidostxt;
    public javax.swing.JTextField Contactotxt;
    public javax.swing.JTextField Documentotxt;
    public javax.swing.JTextField Emailtxt;
    public javax.swing.JTextField Nombrestxt;
    public javax.swing.JPanel bg;
    public javax.swing.JButton btnRegistrar;
    public javax.swing.JTextField discapacidadtxt;
    public javax.swing.JTextField edadtxt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbContacto;
    private javax.swing.JLabel lbDocumento;
    private javax.swing.JLabel lbEdad;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNuevoPasajero;
    private javax.swing.JLabel lbPosibleDiscapacidad;
    public javax.swing.JLabel lb_back;
    // End of variables declaration//GEN-END:variables
}
