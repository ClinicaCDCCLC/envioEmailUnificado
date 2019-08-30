
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ramiro
 */
public class mailsSender extends javax.swing.JFrame {
//QUITAR DIAGNOSTICOS DE COLINA CRY_PRI

    private Pattern pattern;
    private Matcher matcher;
    private String RUTA_GUARDAR;
    private String RUTA_GUARDAR_DOS;

    TaskMailSender al;

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Creates new form mailsSender
     */
    public mailsSender() {

        Path dir = Paths.get(".").toAbsolutePath();
        String file = dir.toString().substring(0, dir.toString().length() - 1);
        RUTA_GUARDAR = file + "c.conf";
        RUTA_GUARDAR_DOS = file + "c2.conf";
        //System.err.println(">>>"+RUTA_GUARDAR);
        List<ModelEnvio> md = Utiles.readObject(RUTA_GUARDAR);

        ModelNoNumeros md_dos = Utiles.readObjectNumeros(RUTA_GUARDAR_DOS);

        initComponents();
        pattern = Pattern.compile(EMAIL_PATTERN);
        btnDetener.setEnabled(false);
        btnCerrar1.setEnabled(false);
        jtHora.setText("12");
 
        if (md != null) {

            DefaultTableModel model = (DefaultTableModel) jTMails.getModel();

            for (int count = 0; count < md.size(); count++) {

                model.setValueAt(md.get(count).getMail(), count, 0);

                model.setValueAt(md.get(count).isCompletoCountry(), count, 1);
                model.setValueAt(md.get(count).isMailCountry(), count, 2);
                model.setValueAt(md.get(count).isCompletoColina(), count, 3);
                model.setValueAt(md.get(count).isMailColina(), count, 4);
                model.setValueAt(md.get(count).isSinFacturar(), count, 5);

                if (md_dos != null) {

                    model.setValueAt(md_dos.noEnviarDatos(md.get(count).getMail().trim()), count, 6);
                }

                jtHora.setText(md.get(count).getHora() + "");

            }

        }

       // btnIniciar.doClick();
    }

    /**
     * Vaidar email
     *
     * @param mail
     * @return
     */
    private boolean validateMail(final String mail) {
        matcher = pattern.matcher(mail);
        return matcher.matches();

    }

    private boolean validarMails(String mailsCommaSeparated) {
        try {
            String[] mails = mailsCommaSeparated.replace("\n", "").split(",");
            for (String m : mails) {
                if (!validateMail(m)) {
                    JOptionPane.showMessageDialog(null, "El e-mail \"" + m + "\" no es un e-mail valido");
                    return false;
                }
            }
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

    private void startApp(List<ModelEnvio> envios,List<String> noNumeros) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        al = new TaskMailSender();
        al.parent = this;
        al.mdenvio = envios;
        al.noEnviar=noNumeros;

        try {
            al.horaEnvioReporte = Integer.parseInt(jtHora.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "La hora ingresada no es válida.");
            return;
        }
        btnDetener.setEnabled(true);
        btnIniciar.setEnabled(false);
        btnCerrar1.setEnabled(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                al.createAndShowGUI();
                al.generarTimerTask();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnDetener = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtHora = new javax.swing.JTextField();
        btnCerrar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTMails = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        btnIniciar.setText("Iniciar envio");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar aplicacion");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnDetener.setText("Detener ");
        btnDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerActionPerformed(evt);
            }
        });

        jLabel2.setText("Destinatarios");
        jLabel2.setToolTipText("Correos electrónicos a enviar el reporte, separados por coma, Ej: email1@clinicadelcountry.com,email2@clinicadelcountry.com ");

        jLabel3.setText("Hora de envio de reporte (Formato 24h): ");

        jtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtHoraActionPerformed(evt);
            }
        });

        btnCerrar1.setText("Correr en segundo plano");
        btnCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar1ActionPerformed(evt);
            }
        });

        jTMails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null},
                {null, null, null, null, null, null,null}
            },
            new String [] {
                "E-mail", "Reporte completo Country", "Reporte Móvil Country", "Reporte completo Colina", "Reporte Móvil Colina", "Sin facturar","Sin montos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class,
                java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTMails);

        jMenu2.setText("Ayuda");

        jMenuItem1.setText("Como debo escribir los correos? ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(0, 477, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetener, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDetener, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(null, "Los correos electrónicos a enviar el reporte, deben estar\n separados por coma:\n Ej: email1@clinicadelcountry.com,email2@clinicadelcountry.com ");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerActionPerformed

        btnIniciar.setEnabled(true);
        btnDetener.setEnabled(false);
        btnCerrar1.setEnabled(false);
        Object[] options = {"Continuar, entiendo",
            "Cancelar"};
        int n = JOptionPane.showOptionDialog(this,
                "Recuerda que si detienes el proceso y no lo inicias de nuevo los correos no serán enviados.",
                "Estas seguro de que deseas detener el proceso? ",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if (n == 0) {
            try {
                if (al != null) {
                    al.tray.remove(TaskMailSender.trayIcon);
                    if (al.mailsTask != null) {
                        al.mailsTask.cancel();
                    }
                    al = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnDetenerActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Object[] options = {"Salir, entiendo",
            "Cancelar"};
        int n = JOptionPane.showOptionDialog(this,
                "Recuerda que si cierras la aplicación correos no serán enviados.",
                "Estas seguro de que deseas cerrar la aplicación? ",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if (n == 0) {
            try {
                if (al != null) {
                    al.tray.remove(TaskMailSender.trayIcon);
                    if (al.mailsTask != null) {
                        al.mailsTask.cancel();
                    }
                    al = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        List<ModelEnvio> envios = new LinkedList<>();
        DefaultTableModel model = (DefaultTableModel) jTMails.getModel();

        ModelNoNumeros nn = new ModelNoNumeros();
        List<String> noEnviar = new LinkedList<>();
        for (int count = 0; count < model.getRowCount(); count++) {
            String mail = model.getValueAt(count, 0) == null ? "" : model.getValueAt(count, 0).toString().trim();
            if (mail != null && !mail.isEmpty() && validarMails(mail)) {
                boolean completoCountry = model.getValueAt(count, 1) == null ? false : (Boolean) model.getValueAt(count, 1);
                boolean mailCountry = model.getValueAt(count, 2) == null ? false : (Boolean) model.getValueAt(count, 2);

                boolean completoColina = model.getValueAt(count, 3) == null ? false : (Boolean) model.getValueAt(count, 3);
                boolean mailColina = model.getValueAt(count, 4) == null ? false : (Boolean) model.getValueAt(count, 4);

                boolean resumenGer = model.getValueAt(count, 5) == null ? false : (Boolean) model.getValueAt(count, 5);
                boolean noNumeros = model.getValueAt(count, 6) == null ? false : (Boolean) model.getValueAt(count, 6);
                if (noNumeros) {
                    noEnviar.add(mail);
                }
                ModelEnvio mdE = new ModelEnvio(mail, completoCountry, mailCountry, completoColina, mailColina, resumenGer);
                System.err.println(mail + ">" + completoCountry + ">" + mailCountry + ">" + completoColina + ">" + mailColina);
                try {
                    mdE.setHora(Integer.parseInt(jtHora.getText()));
                } catch (Exception ex) {

                }
                envios.add(mdE);
            } else if (!mail.isEmpty() && !validarMails(mail)) {
                JOptionPane.showMessageDialog(null, "El e-mail: \"" + mail + "\" no es válido");
            }

        }
        if (envios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes proporcionar al menos un email");
        } else {
            nn.setMails(noEnviar);
            Utiles.WriteObjectNumeros(nn, RUTA_GUARDAR_DOS);
            Utiles.WriteObject(envios, RUTA_GUARDAR);
            startApp(envios,noEnviar);
        }

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void jtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtHoraActionPerformed

    private void btnCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCerrar1;
    private javax.swing.JButton btnDetener;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTMails;
    private javax.swing.JTextField jtHora;
    // End of variables declaration//GEN-END:variables
}
