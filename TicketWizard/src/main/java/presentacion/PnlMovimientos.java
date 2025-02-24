/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import itson.ticketwizard.control.ControlMovimientos;
import itson.ticketwizard.dto.MostrarTransaccionDTO;
import itson.ticketwizard.excepciones.TransaccionException;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.swing.Box;
import javax.swing.JOptionPane;

/**
 *
 * @author Peter
 */
public class PnlMovimientos extends javax.swing.JPanel {

    private ControlMovimientos control;
    private FrmPrincipal parent;
    private int COMPRAS = 1;
    private int VENTAS = 2;
    private int currentSection = 0;
    private List<MostrarTransaccionDTO> movimientos;

    /**
     * Creates new form PnlMovimientos
     */
    public PnlMovimientos(ControlMovimientos control, FrmPrincipal parent) {
        this.control = control;
        this.parent = parent;
        initComponents();
        almacenarMovimientos();
    }

    private void almacenarMovimientos() {
        try {
            this.movimientos = control.consultarMovimientos(parent.getUsuario());
            JOptionPane.showMessageDialog(
                    parent,
                    "Selecciona los movimientos que quieres consultar",
                    "Como usar",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } catch (TransaccionException ex) {
            JOptionPane.showMessageDialog(
                    parent,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            this.movimientos = null;
        }
    }

    private void cargarMovimientos() {
        if (movimientos == null) {
            JOptionPane.showMessageDialog(
                    parent,
                    "No ha hecho ningun movimiento",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        List<MostrarTransaccionDTO> listaMovimientos;
        //Filtrar lista de movimientos para mostrar solo las que son compras o ventas
        if (this.currentSection == COMPRAS) {
            listaMovimientos
                    = movimientos.stream()
                            .filter(movimiento -> movimiento.getRol().equals("Comprador"))
                            .collect(Collectors.toList());
        } else if (currentSection == VENTAS) {
            listaMovimientos
                    = movimientos.stream()
                            .filter(movimiento -> movimiento.getRol().equals("Vendedor"))
                            .collect(Collectors.toList());
        } else {
            return;
        }

        //Lista para agrupar las compras que sucedieron en el mismo movimiento
        List<MostrarTransaccionDTO> paqueteCompras = new LinkedList<>();
        //Recorre la lista de movimientos completa
        for (MostrarTransaccionDTO movimiento : listaMovimientos) {
            //Si es el primero, agregalo al paquete
            if (movimiento.equals(listaMovimientos.getFirst())) {
                paqueteCompras.add(movimiento);
            } else {
                //Si no es el primero, comparar si no son parte de la misma transaccion
                //Y crear el panel para agregarlo a la pantalla (tambien si ya es el ultimo)
                if (!paqueteCompras.getLast().getIdTransaccion()
                        .equals(movimiento.getIdTransaccion())
                        || movimiento.equals(listaMovimientos.getLast())) {
                    //Si es el ultimo, agregar al paquete antes de enviarlo al panel.
                    if (movimiento.equals(listaMovimientos.getLast())) {
                        paqueteCompras.add(movimiento);
                    }
                    //Crea el panel del movimiento y borra el paquete para mostrar el siguiente
                    PnlMovimiento pnlMovimiento = new PnlMovimiento(paqueteCompras, this);
                    if (currentSection == COMPRAS) {
                        this.pnlCompras.add(pnlMovimiento);
                        this.pnlCompras.add(Box.createVerticalStrut(30));
                    } else if (currentSection == VENTAS) {
                        this.pnlVentas.add(pnlMovimiento);
                        this.pnlVentas.add(Box.createVerticalStrut(30));
                    } else {
                        return;
                    }
                    paqueteCompras.clear();
                }
                paqueteCompras.add(movimiento);
            }
            if (movimiento.equals(listaMovimientos.getFirst()) && movimiento.equals(listaMovimientos.getLast())) {
                PnlMovimiento pnlMovimiento = new PnlMovimiento(paqueteCompras, this);
                if (currentSection == COMPRAS) {
                    this.pnlCompras.add(pnlMovimiento);
                    this.pnlCompras.add(Box.createVerticalStrut(30));
                } else if (currentSection == VENTAS) {
                    this.pnlVentas.add(pnlMovimiento);
                    this.pnlVentas.add(Box.createVerticalStrut(30));
                } else {
                    return;
                }
            }

        }

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
        pnlMovimientos = new javax.swing.JPanel();
        scrollPnlMovimientos = new javax.swing.JScrollPane();
        boxPanelMovimientos = new javax.swing.JPanel();
        pnlVentas = new javax.swing.JPanel();
        pnlCompras = new javax.swing.JPanel();
        lblCompras = new javax.swing.JLabel();
        lblVentas = new javax.swing.JLabel();

        pnlMovimientos.setBackground(new java.awt.Color(233, 233, 233));
        pnlMovimientos.setForeground(new java.awt.Color(30, 30, 30));

        scrollPnlMovimientos.setBackground(new java.awt.Color(233, 233, 233));
        scrollPnlMovimientos.setBorder(null);

        boxPanelMovimientos.setBackground(new java.awt.Color(233, 233, 233));
        boxPanelMovimientos.setLayout(new java.awt.CardLayout());

        pnlVentas.setBackground(new java.awt.Color(233, 233, 233));
        pnlVentas.setLayout(new javax.swing.BoxLayout(pnlVentas, javax.swing.BoxLayout.Y_AXIS));

        pnlCompras.setBackground(new java.awt.Color(233, 233, 233));
        pnlCompras.setLayout(new javax.swing.BoxLayout(pnlCompras, javax.swing.BoxLayout.Y_AXIS));
        pnlVentas.add(pnlCompras);

        boxPanelMovimientos.add(pnlVentas, "card3");

        scrollPnlMovimientos.setViewportView(boxPanelMovimientos);

        lblCompras.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblCompras.setForeground(new java.awt.Color(0, 0, 0));
        lblCompras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompras.setText("Compras");
        lblCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblComprasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblComprasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblComprasMouseExited(evt);
            }
        });

        lblVentas.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblVentas.setForeground(new java.awt.Color(0, 0, 0));
        lblVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVentas.setText("Ventas");
        lblVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVentasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlMovimientosLayout = new javax.swing.GroupLayout(pnlMovimientos);
        pnlMovimientos.setLayout(pnlMovimientosLayout);
        pnlMovimientosLayout.setHorizontalGroup(
            pnlMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlMovimientosLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(scrollPnlMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        pnlMovimientosLayout.setVerticalGroup(
            pnlMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPnlMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprasMouseClicked
        currentSection = COMPRAS;
        Font font = new Font("Sans Serif", Font.BOLD, 36);
        lblVentas.setFont(font);
        boxPanelMovimientos.removeAll();
        pnlCompras.removeAll();
        boxPanelMovimientos.add(pnlCompras);
        cargarMovimientos();
        boxPanelMovimientos.repaint();
        boxPanelMovimientos.revalidate();
    }//GEN-LAST:event_lblComprasMouseClicked

    private void lblComprasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprasMouseEntered
        if (currentSection != COMPRAS) {
            Font font = new Font("Sans Serif", Font.BOLD, 36);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblCompras.setFont(font.deriveFont(attributes));
        }
    }//GEN-LAST:event_lblComprasMouseEntered

    private void lblComprasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblComprasMouseExited
        if (currentSection != COMPRAS) {
            Font font = new Font("Sans Serif", Font.BOLD, 36);
            lblCompras.setFont(font);
        }
    }//GEN-LAST:event_lblComprasMouseExited

    private void lblVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasMouseEntered
        if (currentSection != VENTAS) {
            Font font = new Font("Sans Serif", Font.BOLD, 36);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblVentas.setFont(font.deriveFont(attributes));
        }    }//GEN-LAST:event_lblVentasMouseEntered

    private void lblVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasMouseExited
        if (currentSection != VENTAS) {
            Font font = new Font("Sans Serif", Font.BOLD, 36);
            lblVentas.setFont(font);
        }    }//GEN-LAST:event_lblVentasMouseExited

    private void lblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVentasMouseClicked
        currentSection = VENTAS;
        Font font = new Font("Sans Serif", Font.BOLD, 36);
        lblCompras.setFont(font);
        boxPanelMovimientos.removeAll();
        pnlVentas.removeAll();
        boxPanelMovimientos.add(pnlVentas);
        cargarMovimientos();
        boxPanelMovimientos.repaint();
        boxPanelMovimientos.revalidate();    }//GEN-LAST:event_lblVentasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boxPanelMovimientos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCompras;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JPanel pnlCompras;
    private javax.swing.JPanel pnlMovimientos;
    private javax.swing.JPanel pnlVentas;
    private javax.swing.JScrollPane scrollPnlMovimientos;
    // End of variables declaration//GEN-END:variables
}
