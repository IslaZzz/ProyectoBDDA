package presentacion;

import itson.ticketwizard.entidades.Boleto;
import javax.swing.JCheckBox;

/**
 *
 * @author Peter
 */
public class PnlBoletoComprar extends javax.swing.JPanel {

    private Boleto boleto;
    private PnlComprarBoletos parent;

    /**
     * Constructor para panel de boleto que se mostrara en la pantalla para comprar boletos
     * @param boleto objeto Boleto con los datos del boleto
     * @param parent Panel padre del panel
     */
    public PnlBoletoComprar(Boleto boleto, PnlComprarBoletos parent) {
        this.boleto = boleto;
        this.parent = parent;
        initComponents();
        cargarBoleto();
    }

    public JCheckBox getCheckBox() {
        return CheckBox;
    }

    public Boleto getBoleto() {
        return boleto;
    }
    
    

    private void cargarBoleto(){
        lblNombre.setText(parent.getControl().consultaEvento(boleto));
        lblFila.setText("Fila: "+boleto.getFila());
        lblAsiento.setText("Asiento: "+boleto.getAsiento());
        lblPrecio.setText("Precio: "+String.valueOf(boleto.getPrecio()));
        lblTipoVenta.setText("Tipo de venta: "+parent.getControl().determinarTipoVenta(boleto));
        
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
        lblNombre = new javax.swing.JLabel();
        lblFila = new javax.swing.JLabel();
        lblAsiento = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        CheckBox = new javax.swing.JCheckBox();
        lblTipoVenta = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(30, 30, 30));
        lblNombre.setText("Nombre Evento");

        lblFila.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblFila.setForeground(new java.awt.Color(30, 30, 30));
        lblFila.setText("Fila");

        lblAsiento.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblAsiento.setForeground(new java.awt.Color(30, 30, 30));
        lblAsiento.setText("Asiento");

        lblPrecio.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(30, 30, 30));
        lblPrecio.setText("Precio");

        CheckBox.setBackground(new java.awt.Color(255, 255, 255));
        CheckBox.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        CheckBox.setForeground(new java.awt.Color(30, 30, 30));
        CheckBox.setText("Seleccionar");

        lblTipoVenta.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTipoVenta.setForeground(new java.awt.Color(30, 30, 30));
        lblTipoVenta.setText("Tipo de Venta: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPrecio)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFila)
                            .addComponent(lblAsiento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CheckBox)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipoVenta)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFila)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CheckBox)
                        .addComponent(lblAsiento)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTipoVenta)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAsiento;
    private javax.swing.JLabel lblFila;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTipoVenta;
    // End of variables declaration//GEN-END:variables
}
