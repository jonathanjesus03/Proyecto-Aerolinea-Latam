    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW1;

import VIEW1.VIEW2.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import VIEW1.VIEW2.Principal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;
import javax.swing.JPanel;

/**
 *
 * @author Samsung
 */
public class Dashboard extends javax.swing.JFrame {
    public static boolean PC = false;
    /**
     * Creates new form NewJFrame
     */
    public Dashboard() {
        initComponents();
        InitStyles();
        SetDate();
        principalfunc();
    }

    public static boolean getPC() {
        return PC;
    }
    
   public void principalfunc(){
       showJPanel(new Principal());
   }
    
   public void showJPanel(JPanel p1){  
       content.setLayout(new BorderLayout());
       content.removeAll();
       content.add(p1, BorderLayout.CENTER);
       content.revalidate();
       content.repaint();
   }
   
    public void SetDate(){
        LocalDate now=LocalDate.now();
        int year=now.getYear();
        int dia=now.getDayOfMonth();
        int month=now.getMonthValue();
        String[] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Septiembre","Octubre","Noviembre","Diciembre"};
        date.setText("Hoy es "+dia+" de "+meses[month - 1]+" de "+year);
        }
    public void InitStyles(){
     message.putClientProperty( "FlatLaf.style", "font: 18 $light.font" );  
     navtext.putClientProperty( "FlatLaf.style", "font: bold $h3.regular.font" );
     navtext.setForeground(Color.white);
     date.putClientProperty( "FlatLaf.style", "font: 24 $light.font" );
     date.setForeground(Color.white);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        bg = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        logo_menu = new javax.swing.JLabel();
        appname = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        bt_gestion_vuelos = new javax.swing.JButton();
        bt_inicio = new javax.swing.JButton();
        AnotherFunc = new javax.swing.JButton();
        bt_administracion_pasajeros = new javax.swing.JButton();
        bt_informes_estadisticas = new javax.swing.JButton();
        bt_pax_control = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        navtext = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1060, 700));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(0, 0));

        menu.setBackground(new java.awt.Color(42, 0, 136));
        menu.setMinimumSize(new java.awt.Dimension(330, 510));

        logo_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/log2.png"))); // NOI18N

        appname.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        appname.setForeground(new java.awt.Color(255, 255, 255));
        appname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appname.setText("Latam");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));

        bt_gestion_vuelos.setBackground(new java.awt.Color(87, 52, 165));
        bt_gestion_vuelos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_gestion_vuelos.setForeground(new java.awt.Color(255, 255, 255));
        bt_gestion_vuelos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar-multiple-check.png"))); // NOI18N
        bt_gestion_vuelos.setText("Gestión de Vuelo");
        bt_gestion_vuelos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 80, 1, 1, new java.awt.Color(0, 0, 0)));
        bt_gestion_vuelos.setBorderPainted(false);
        bt_gestion_vuelos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_gestion_vuelos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_gestion_vuelos.setIconTextGap(15);
        bt_gestion_vuelos.setInheritsPopupMenu(true);
        bt_gestion_vuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gestion_vuelosActionPerformed(evt);
            }
        });

        bt_inicio.setBackground(new java.awt.Color(87, 52, 165));
        bt_inicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_inicio.setForeground(new java.awt.Color(255, 255, 255));
        bt_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-outline.png"))); // NOI18N
        bt_inicio.setText("Inicio");
        bt_inicio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 115, 1, 1, new java.awt.Color(0, 0, 0)));
        bt_inicio.setBorderPainted(false);
        bt_inicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_inicio.setIconTextGap(15);
        bt_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inicioActionPerformed(evt);
            }
        });

        AnotherFunc.setBackground(new java.awt.Color(87, 52, 165));
        AnotherFunc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AnotherFunc.setForeground(new java.awt.Color(255, 255, 255));
        AnotherFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/account-multiple.png"))); // NOI18N
        AnotherFunc.setText("IN DEVELOPMENT ");
        AnotherFunc.setActionCommand("");
        AnotherFunc.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 75, 1, 1, new java.awt.Color(0, 0, 0)));
        AnotherFunc.setBorderPainted(false);
        AnotherFunc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AnotherFunc.setIconTextGap(15);
        AnotherFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnotherFuncActionPerformed(evt);
            }
        });

        bt_administracion_pasajeros.setBackground(new java.awt.Color(87, 52, 165));
        bt_administracion_pasajeros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_administracion_pasajeros.setForeground(new java.awt.Color(255, 255, 255));
        bt_administracion_pasajeros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar-plus.png"))); // NOI18N
        bt_administracion_pasajeros.setText("Administración de Pasajeros");
        bt_administracion_pasajeros.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 45, 1, 1, new java.awt.Color(0, 0, 0)));
        bt_administracion_pasajeros.setBorderPainted(false);
        bt_administracion_pasajeros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_administracion_pasajeros.setIconTextGap(15);
        bt_administracion_pasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_administracion_pasajerosActionPerformed(evt);
            }
        });

        bt_informes_estadisticas.setBackground(new java.awt.Color(87, 52, 165));
        bt_informes_estadisticas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_informes_estadisticas.setForeground(new java.awt.Color(255, 255, 255));
        bt_informes_estadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file-chart.png"))); // NOI18N
        bt_informes_estadisticas.setText("Informes y Estadisticas");
        bt_informes_estadisticas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 60, 1, 1, new java.awt.Color(0, 0, 0)));
        bt_informes_estadisticas.setBorderPainted(false);
        bt_informes_estadisticas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_informes_estadisticas.setIconTextGap(15);
        bt_informes_estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_informes_estadisticasActionPerformed(evt);
            }
        });

        bt_pax_control.setBackground(new java.awt.Color(87, 52, 165));
        bt_pax_control.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_pax_control.setForeground(new java.awt.Color(255, 255, 255));
        bt_pax_control.setIcon(new javax.swing.ImageIcon(getClass().getResource("/book-open-page-variant.png"))); // NOI18N
        bt_pax_control.setText("Pax Control");
        bt_pax_control.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 100, 1, 1, new java.awt.Color(0, 0, 0)));
        bt_pax_control.setBorderPainted(false);
        bt_pax_control.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bt_pax_control.setIconTextGap(15);
        bt_pax_control.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pax_controlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appname, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(logo_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(bt_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bt_pax_control, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bt_administracion_pasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bt_gestion_vuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(bt_informes_estadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(AnotherFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(appname))
                    .addComponent(logo_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(bt_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_pax_control, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_administracion_pasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_gestion_vuelos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_informes_estadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AnotherFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        header.setBackground(new java.awt.Color(220, 20, 83));

        navtext.setText("Administración/Control/Aerolinea");

        date.setText("Hoy es {dayname} {day} de {month} del {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(navtext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(navtext, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        message.setFont(new java.awt.Font("Dubai Medium", 3, 18)); // NOI18N
        message.setText("Secure Travel <3");

        content.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inicioActionPerformed
        showJPanel(new Principal());
    }//GEN-LAST:event_bt_inicioActionPerformed

    private void bt_informes_estadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_informes_estadisticasActionPerformed
    }//GEN-LAST:event_bt_informes_estadisticasActionPerformed

    private void bt_gestion_vuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gestion_vuelosActionPerformed
       
    }//GEN-LAST:event_bt_gestion_vuelosActionPerformed

    private void AnotherFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnotherFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnotherFuncActionPerformed

    private void bt_administracion_pasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_administracion_pasajerosActionPerformed
    }//GEN-LAST:event_bt_administracion_pasajerosActionPerformed

    private void bt_pax_controlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pax_controlActionPerformed
  
    }//GEN-LAST:event_bt_pax_controlActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AnotherFunc;
    private javax.swing.JLabel appname;
    public javax.swing.JPanel bg;
    public javax.swing.JButton bt_administracion_pasajeros;
    public javax.swing.JButton bt_gestion_vuelos;
    public javax.swing.JButton bt_informes_estadisticas;
    public javax.swing.JButton bt_inicio;
    public javax.swing.JButton bt_pax_control;
    public javax.swing.JPanel content;
    private javax.swing.JLabel date;
    public javax.swing.JPanel header;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo_menu;
    public javax.swing.JPanel menu;
    private javax.swing.JLabel message;
    private javax.swing.JLabel navtext;
    // End of variables declaration//GEN-END:variables
}
