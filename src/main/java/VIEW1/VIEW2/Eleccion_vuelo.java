package VIEW1.VIEW2;
import CONTROLADOR.DAOVuelosIMPL;
import Interfaces.DAOVuelos;
import VIEW1.Dashboard;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Samsung
 */
public class Eleccion_vuelo extends javax.swing.JPanel{

    /**
     * Creates new form Principal
     */
    public Eleccion_vuelo() {
        initComponents();                
        searchField.putClientProperty("JTextField.placeholderText", "Ingrese el Id del vuelo a buscar.");
        listarVuelos();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        txtnumv = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_vuelos = new javax.swing.JTable();
        bt_elegir_vuelo = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(710, 403));
        setPreferredSize(new java.awt.Dimension(710, 403));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMinimumSize(new java.awt.Dimension(710, 403));
        bg.setPreferredSize(new java.awt.Dimension(710, 390));

        jLabel2.setText("Elija un vuelo valido porfavor, para proceder a la sala de abordaje");

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Vuelos Disponibles");

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        txtnumv.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtnumv.setForeground(new java.awt.Color(0, 0, 0));
        txtnumv.setText("Total de vuelos en cola: ");

        tabla_vuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Numero de vuelo", "Codigo de Referencia"
            }
        ));
        jScrollPane2.setViewportView(tabla_vuelos);

        bt_elegir_vuelo.setText("Elegir");
        bt_elegir_vuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_elegir_vueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(238, 238, 238))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(searchField)
                                .addGap(18, 18, 18)
                                .addComponent(bt_elegir_vuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(88, 88, 88))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(txtnumv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(365, 365, 365))
                            .addComponent(jScrollPane2))))
                .addGap(107, 107, 107))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnumv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_elegir_vuelo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(searchField))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void listarVuelos(){
        try {
            searchField.setText("");
            String name = searchField.getText();
            DAOVuelos dao = new DAOVuelosIMPL();
            DefaultTableModel model = (DefaultTableModel) tabla_vuelos.getModel();
            model.setRowCount(0);
            dao.listarVU(name).forEach((v)->model.addRow(new Object[]{v.getIdvuelo(),v.getCodigo()}));
            txtnumv.setText("Total de vuelos en cola:  "+String.valueOf(tabla_vuelos.getRowCount()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void bt_elegir_vueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_elegir_vueloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_elegir_vueloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel bg;
    public javax.swing.JButton bt_elegir_vuelo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField searchField;
    public javax.swing.JTable tabla_vuelos;
    private javax.swing.JLabel txtnumv;
    // End of variables declaration//GEN-END:variables
}
