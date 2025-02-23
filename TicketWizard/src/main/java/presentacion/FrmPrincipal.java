/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import itson.ticketwizard.control.ControlCompraBoletos;
import itson.ticketwizard.control.ControlInicioSesion;
import itson.ticketwizard.control.ControlMostrarEventos;
import itson.ticketwizard.control.ControlMovimientos;
import itson.ticketwizard.control.ControlSaldo;
import itson.ticketwizard.entidades.Usuario;
import itson.ticketwizard.persistencia.BoletosDAO;
import itson.ticketwizard.persistencia.EventosDAO;
import itson.ticketwizard.persistencia.ManejadorConexiones;
import itson.ticketwizard.persistencia.TransaccionesDAO;
import itson.ticketwizard.persistencia.UsuariosDAO;
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
    private Usuario usuario;
    
    private ControlInicioSesion controlInicioSesion;
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal(ControlInicioSesion controlInicioSesion) {
        this.controlInicioSesion = controlInicioSesion;
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
        lblCerrarSesion = new javax.swing.JLabel();
        pnlBoletos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
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

        lblCerrarSesion.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblCerrarSesion.setForeground(new java.awt.Color(30, 30, 30));
        lblCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrarSesion.setText("Cerrar Sesión");
        lblCerrarSesion.setAlignmentX(0.5F);
        lblCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addComponent(lblBienvenido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(lblCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pnlCardLayout.add(pnlPrincipal, "card4");

        jLabel3.setText("Boletos");

        javax.swing.GroupLayout pnlBoletosLayout = new javax.swing.GroupLayout(pnlBoletos);
        pnlBoletos.setLayout(pnlBoletosLayout);
        pnlBoletosLayout.setHorizontalGroup(
            pnlBoletosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoletosLayout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jLabel3)
                .addContainerGap(469, Short.MAX_VALUE))
        );
        pnlBoletosLayout.setVerticalGroup(
            pnlBoletosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoletosLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel3)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        pnlCardLayout.add(pnlBoletos, "card3");

        getContentPane().add(pnlCardLayout, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarEventos(){
        currentSection = EVENTOS;
        Font font = new Font("Sans Serif", Font.PLAIN, 18);
        lblBoletos.setFont(font);
        lblMovimientos.setFont(font);
        lblSaldo.setFont(font);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblEventos.setFont(font.deriveFont(attributes));
        pnlCardLayout.removeAll();
        ManejadorConexiones conexionBD = new ManejadorConexiones();
        EventosDAO eventosDAO = new EventosDAO(conexionBD);
        ControlMostrarEventos control = new ControlMostrarEventos(eventosDAO);
        PnlEventos pnlEventos = new PnlEventos(control, this);
        pnlCardLayout.add(pnlEventos);
        pnlCardLayout.repaint();
        pnlCardLayout.revalidate();
    };
    
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
        mostrarEventos();
    }//GEN-LAST:event_lblEventosMouseClicked

    private void lblMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMovimientosMouseClicked
        currentSection = MOVIMIENTOS;
        Font font = new Font("Sans Serif", Font.PLAIN, 18);
        lblBoletos.setFont(font);
        lblMovimientos.setFont(font);
        lblSaldo.setFont(font);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblEventos.setFont(font.deriveFont(attributes));
        pnlCardLayout.removeAll();
        ManejadorConexiones conexionBD = new ManejadorConexiones();
        TransaccionesDAO movimientosDAO = new TransaccionesDAO(conexionBD);
        ControlMovimientos control = new ControlMovimientos(movimientosDAO);
        PnlMovimientos pnlMovimientos = new PnlMovimientos(control, this);
        pnlCardLayout.add(pnlMovimientos);
        pnlCardLayout.repaint();
        pnlCardLayout.revalidate();
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
        
        ManejadorConexiones conexionBD = new ManejadorConexiones();
        UsuariosDAO usuariosDAO = new UsuariosDAO(conexionBD);
        ControlSaldo controlSaldo = new ControlSaldo(usuariosDAO);
        PnlConsultarSaldo pnlConsultarSaldo = new PnlConsultarSaldo(controlSaldo, this);
        pnlCardLayout.removeAll();
        pnlCardLayout.add(pnlConsultarSaldo);
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

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        this.usuario = null;
        controlInicioSesion.mostrarInicioSesion();
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

    private void lblCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseEntered
        Font font = new Font("Sans Serif", Font.PLAIN, 18);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblSaldo.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_lblCerrarSesionMouseEntered

    private void lblCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseExited
        Font font =  new Font("Sans Serif", Font.PLAIN, 18);
        lblSaldo.setFont(font);
    }//GEN-LAST:event_lblCerrarSesionMouseExited
    
    public void mostrarBoletosEvento(Integer idEvento){
        pnlCardLayout.removeAll();
        ManejadorConexiones conexionBD = new ManejadorConexiones();
        BoletosDAO boletosDAO = new BoletosDAO(conexionBD);
        ControlCompraBoletos control = new ControlCompraBoletos(boletosDAO);
        PnlComprarBoletos pnlCompraBoletos = new PnlComprarBoletos(control, this, idEvento);
        pnlCardLayout.add(pnlCompraBoletos);
        pnlCardLayout.repaint();
        pnlCardLayout.revalidate();
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblBoletos;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblEventos;
    private javax.swing.JLabel lblMovimientos;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBoletos;
    private javax.swing.JPanel pnlCardLayout;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
