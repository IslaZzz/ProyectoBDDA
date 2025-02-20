/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

/**
 *
 * @author Peter
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private int currentSection = 0;
    private int EVENTOS = 1;
    private int BOLETOS = 2;
    private int MOVIMIENTOS = 3;
    private int SALDO = 4;

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
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

        pnlMenu = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblMovimientos = new javax.swing.JLabel();
        lblEventos = new javax.swing.JLabel();
        lblBoletos = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        pnlCardLayout = new javax.swing.JPanel();
        pnlPrincipal = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlEventos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        pnlBoletos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlMovimientos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlSaldo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicketWizard");

        pnlMenu.setBackground(new java.awt.Color(233, 233, 233));

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(30, 30, 30));
        lblTitulo.setText("TicketWizard");
        lblTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloMouseClicked(evt);
            }
        });

        lblMovimientos.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblMovimientos.setForeground(new java.awt.Color(30, 30, 30));
        lblMovimientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMovimientos.setText("Movimientos");
        lblMovimientos.setAlignmentX(0.5F);
        lblMovimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMovimientos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMovimientosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMovimientosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMovimientosMouseExited(evt);
            }
        });

        lblEventos.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblEventos.setForeground(new java.awt.Color(30, 30, 30));
        lblEventos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEventos.setText("Eventos");
        lblEventos.setAlignmentX(0.5F);
        lblEventos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEventos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEventosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEventosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEventosMouseExited(evt);
            }
        });

        lblBoletos.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblBoletos.setForeground(new java.awt.Color(30, 30, 30));
        lblBoletos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBoletos.setText("Mis Boletos");
        lblBoletos.setAlignmentX(0.5F);
        lblBoletos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBoletos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblBoletos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBoletosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBoletosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBoletosMouseExited(evt);
            }
        });

        lblSaldo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(30, 30, 30));
        lblSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo.setText("Saldo");
        lblSaldo.setAlignmentX(0.5F);
        lblSaldo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSaldo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSaldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSaldoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSaldoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSaldoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(lblEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBoletos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblEventos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBoletos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
        );

        getContentPane().add(pnlMenu, java.awt.BorderLayout.PAGE_START);

        pnlCardLayout.setBackground(new java.awt.Color(233, 233, 233));
        pnlCardLayout.setLayout(new java.awt.CardLayout());

        pnlPrincipal.setBackground(new java.awt.Color(233, 233, 233));

        lblBienvenido.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        lblBienvenido.setForeground(new java.awt.Color(30, 30, 30));
        lblBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenido.setText(" ¡Bienvenido al Sistema de TicketWizard!");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBienvenido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pnlCardLayout.add(pnlPrincipal, "card4");

        pnlEventos.setBackground(new java.awt.Color(233, 233, 233));
        pnlEventos.setForeground(new java.awt.Color(30, 30, 30));

        jScrollPane1.setBackground(new java.awt.Color(233, 233, 233));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Eventos Disponibles");

        javax.swing.GroupLayout pnlEventosLayout = new javax.swing.GroupLayout(pnlEventos);
        pnlEventos.setLayout(pnlEventosLayout);
        pnlEventosLayout.setHorizontalGroup(
            pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEventosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEventosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(200, 200, 200))
        );
        pnlEventosLayout.setVerticalGroup(
            pnlEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEventosLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCardLayout.add(pnlEventos, "card4");

        jLabel3.setText("Boletos");

        javax.swing.GroupLayout pnlBoletosLayout = new javax.swing.GroupLayout(pnlBoletos);
        pnlBoletos.setLayout(pnlBoletosLayout);
        pnlBoletosLayout.setHorizontalGroup(
            pnlBoletosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoletosLayout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jLabel3)
                .addContainerGap(443, Short.MAX_VALUE))
        );
        pnlBoletosLayout.setVerticalGroup(
            pnlBoletosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoletosLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel3)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        pnlCardLayout.add(pnlBoletos, "card3");

        jLabel4.setText("Movimientos");

        javax.swing.GroupLayout pnlMovimientosLayout = new javax.swing.GroupLayout(pnlMovimientos);
        pnlMovimientos.setLayout(pnlMovimientosLayout);
        pnlMovimientosLayout.setHorizontalGroup(
            pnlMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMovimientosLayout.createSequentialGroup()
                .addContainerGap(459, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(357, 357, 357))
        );
        pnlMovimientosLayout.setVerticalGroup(
            pnlMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovimientosLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel4)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        pnlCardLayout.add(pnlMovimientos, "card5");

        jLabel5.setText("Saldo");

        javax.swing.GroupLayout pnlSaldoLayout = new javax.swing.GroupLayout(pnlSaldo);
        pnlSaldo.setLayout(pnlSaldoLayout);
        pnlSaldoLayout.setHorizontalGroup(
            pnlSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaldoLayout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(jLabel5)
                .addContainerGap(476, Short.MAX_VALUE))
        );
        pnlSaldoLayout.setVerticalGroup(
            pnlSaldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaldoLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel5)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        pnlCardLayout.add(pnlSaldo, "card6");

        getContentPane().add(pnlCardLayout, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblEventosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseEntered
        if (currentSection != EVENTOS) {
            Font font = new Font("Sans Serif", Font.PLAIN, 18);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblEventos.setFont(font.deriveFont(attributes));
        }
    }//GEN-LAST:event_lblEventosMouseEntered

    private void lblEventosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseExited
        if(currentSection != EVENTOS) {
            Font font =  new Font("Sans Serif", Font.PLAIN, 18);
            lblEventos.setFont(font);
        }
    }//GEN-LAST:event_lblEventosMouseExited

    private void lblBoletosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBoletosMouseEntered
        if (currentSection != BOLETOS) {
            Font font = new Font("Sans Serif", Font.PLAIN, 18);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblBoletos.setFont(font.deriveFont(attributes));
        }
    }//GEN-LAST:event_lblBoletosMouseEntered

    private void lblBoletosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBoletosMouseExited
        if(currentSection != BOLETOS) {
            Font font =  new Font("Sans Serif", Font.PLAIN, 18);
            lblBoletos.setFont(font);
        }
    }//GEN-LAST:event_lblBoletosMouseExited

    private void lblBoletosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBoletosMouseClicked
        currentSection = BOLETOS;
        Font font = new Font("Sans Serif", Font.PLAIN, 18);
        lblEventos.setFont(font);
        lblMovimientos.setFont(font);
        lblSaldo.setFont(font);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblBoletos.setFont(font.deriveFont(attributes));
        pnlCardLayout.removeAll();
        pnlCardLayout.add(pnlBoletos);
        pnlCardLayout.repaint();
        pnlCardLayout.revalidate();
        lblBoletos.setBackground(new Color(16, 23, 66));
    }//GEN-LAST:event_lblBoletosMouseClicked

    private void lblEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEventosMouseClicked
        currentSection = EVENTOS;
        Font font = new Font("Sans Serif", Font.PLAIN, 18);
        lblBoletos.setFont(font);
        lblMovimientos.setFont(font);
        lblSaldo.setFont(font);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblEventos.setFont(font.deriveFont(attributes));
        pnlCardLayout.removeAll();
        pnlCardLayout.add(pnlEventos);
        pnlCardLayout.repaint();
        pnlCardLayout.revalidate();
        lblEventos.setBackground(new Color(16, 23, 66));
    }//GEN-LAST:event_lblEventosMouseClicked

    private void lblMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMovimientosMouseClicked
        currentSection = MOVIMIENTOS;
        Font font = new Font("Sans Serif", Font.PLAIN, 18);
        lblBoletos.setFont(font);
        lblEventos.setFont(font);
        lblSaldo.setFont(font);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblMovimientos.setFont(font.deriveFont(attributes));
        pnlCardLayout.removeAll();
        pnlCardLayout.add(pnlMovimientos);
        pnlCardLayout.repaint();
        pnlCardLayout.revalidate();
        lblEventos.setBackground(new Color(16, 23, 66));
    }//GEN-LAST:event_lblMovimientosMouseClicked

    private void lblMovimientosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMovimientosMouseEntered
        if (currentSection != MOVIMIENTOS) {
            Font font = new Font("Sans Serif", Font.PLAIN, 18);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblMovimientos.setFont(font.deriveFont(attributes));
        }
    }//GEN-LAST:event_lblMovimientosMouseEntered

    private void lblMovimientosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMovimientosMouseExited
        if(currentSection != MOVIMIENTOS) {
            Font font =  new Font("Sans Serif", Font.PLAIN, 18);
            lblMovimientos.setFont(font);
        }
    }//GEN-LAST:event_lblMovimientosMouseExited

    private void lblSaldoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaldoMouseExited
        if(currentSection != SALDO) {
            Font font =  new Font("Sans Serif", Font.PLAIN, 18);
            lblSaldo.setFont(font);
        }
    }//GEN-LAST:event_lblSaldoMouseExited

    private void lblSaldoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaldoMouseEntered
        if (currentSection != SALDO) {
            Font font = new Font("Sans Serif", Font.PLAIN, 18);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            lblSaldo.setFont(font.deriveFont(attributes));
        }
    }//GEN-LAST:event_lblSaldoMouseEntered

    private void lblSaldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSaldoMouseClicked
        currentSection = SALDO;
        Font font = new Font("Sans Serif", Font.PLAIN, 18);
        lblBoletos.setFont(font);
        lblMovimientos.setFont(font);
        lblEventos.setFont(font);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblSaldo.setFont(font.deriveFont(attributes));
        pnlCardLayout.removeAll();
        pnlCardLayout.add(pnlSaldo);
        pnlCardLayout.repaint();
        pnlCardLayout.revalidate();
        lblSaldo.setBackground(new Color(16, 23, 66));
    }//GEN-LAST:event_lblSaldoMouseClicked

    private void lblTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloMouseClicked
        currentSection = 0;
        Font font = new Font("Sans Serif", Font.PLAIN, 18);
        lblEventos.setFont(font);
        lblBoletos.setFont(font);
        lblMovimientos.setFont(font);
        lblSaldo.setFont(font);
        pnlCardLayout.removeAll();
        pnlCardLayout.add(pnlPrincipal);
        pnlCardLayout.repaint();
        pnlCardLayout.revalidate();
        lblEventos.setBackground(new Color(16, 23, 66));
    }//GEN-LAST:event_lblTituloMouseClicked
    
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblBoletos;
    private javax.swing.JLabel lblEventos;
    private javax.swing.JLabel lblMovimientos;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBoletos;
    private javax.swing.JPanel pnlCardLayout;
    private javax.swing.JPanel pnlEventos;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMovimientos;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlSaldo;
    // End of variables declaration//GEN-END:variables
}
