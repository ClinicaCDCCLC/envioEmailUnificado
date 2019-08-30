
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class TaskMailSender {

    public JFrame parent;

    List<ModelEnvio> mdenvio = new LinkedList<ModelEnvio>();

    List<String> noEnviar = new LinkedList<String>();

    final PopupMenu popup = new PopupMenu();
    public static final TrayIcon trayIcon = new TrayIcon(createImage("bulb.gif", "Reporte Diario"));
    public final SystemTray tray = SystemTray.getSystemTray();

    public void createAndShowGUI() {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        MenuItem panelItemA = new MenuItem("Mostrar panel de control");
        MenuItem panelItemM = new MenuItem("Ocultar panel de control");
        MenuItem aboutItem = new MenuItem("Acerca de");
        MenuItem exitItem = new MenuItem("Exit");

        this.popup.add(panelItemA);
        this.popup.add(panelItemM);
        this.popup.add(aboutItem);
        this.popup.addSeparator();

        this.popup.add(exitItem);

        trayIcon.setPopupMenu(this.popup);
        try {
            this.tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Generador diario de reportes Clinica del country V2.0");
            }
        });

        panelItemA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(true);
            }
        });
        panelItemM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.setVisible(false);
            }
        });
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Generador diario de reportes Clinica del country V2.0");
            }
        });
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuItem item = (MenuItem) e.getSource();

                System.out.println(item.getLabel());
                if (null != item.getLabel()) {
                    switch (item.getLabel()) {
                        case "Error":
                            TaskMailSender.trayIcon.displayMessage("Sun TrayIcon Demo", "This is an error message", TrayIcon.MessageType.ERROR);
                            break;
                        case "Warning":
                            TaskMailSender.trayIcon.displayMessage("Sun TrayIcon Demo", "This is a warning message", TrayIcon.MessageType.WARNING);
                            break;
                        case "Info":
                            TaskMailSender.trayIcon.displayMessage("Sun TrayIcon Demo", "This is an info message", TrayIcon.MessageType.INFO);
                            break;
                        case "None":
                            TaskMailSender.trayIcon.displayMessage("Sun TrayIcon Demo", "This is an ordinary message", TrayIcon.MessageType.NONE);
                            break;
                    }
                }
            }
        };
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TaskMailSender.this.tray.remove(TaskMailSender.trayIcon);
                System.exit(0);
            }
        });
    }

    protected static Image createImage(String path, String description) {
        URL imageURL = TaskMailSender.class.getResource(path);
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        }
        return new ImageIcon(imageURL, description).getImage();
    }

    private boolean reporteGenerado = false;
    public TimerTask mailsTask;
    public int horaEnvioReporte;

    void generarTimerTask() {
        mailsTask = new TimerTask() {
            public void run() {
                DateFormat dateFormat = new SimpleDateFormat("HH");
                String horaInicial = dateFormat.format(Calendar.getInstance().getTime());
                //int horaReporte = 18;

                int horaActual = Integer.parseInt(horaInicial);
                /**
                 * Si la hora actual es igual a la hora del reporte y el reporte
                 * aun no ha sido generado generar el reporte una sola vez
                 * Independiente de los minutos, si es la hora del reporte al
                 * iniciar la aplicación se generará el reporte y lo enviará una
                 * sola vez.
                 *
                 * Al arrancar la aplicacion si la hora del reporte no es la
                 * hora actual el reporte no va a ser enviado.
                 *
                 */

                if (((horaEnvioReporte == horaActual)) && (!TaskMailSender.this.reporteGenerado)) {
                    TaskMailSender.trayIcon.displayMessage("Reporte Diario", "Generando reporte", TrayIcon.MessageType.INFO);
                    try {
                        /**
                         * Envio de emails reporte diario
                         */
                        connectDS conn = new connectDS();
                        String mes = conn.obtenerUltimoMes();
                        String mesStrMes = conn.obtenerNombreUltimoMes();
                        String mesStrMesColina = conn.obtenerNombreUltimoMesColina();
                        String mesStrMesAnt = conn.obtenerNombreUltimoMesMenosUno();
                        String mesStrMesAntColina = conn.obtenerNombreUltimoMesMenosUnoColina();

                        for (ModelEnvio mde : mdenvio) {

                            List<String> mails = new LinkedList<String>();
                            mails.add(mde.getMail());
                            String completo = "";
                            boolean numeros = (noEnviar == null ? true : !noEnviar.contains(mde.getMail().trim()));
                            if (mde.isCompletoCountry()) {
                                String resultado
                                        = "<div    style=\"font-size: 1.1em;\">"
                                        + "<p  style=\"font-size: 1.1em;color: #7c8d87;\">Reporte Country</p>"
                                        + "  </div>";
                                if (conn.esPrimerdia()) {

                                    resultado += conn.obtenerTabla(connectDS.SQL_PRIMER_DIA,
                                            mesStrMesAnt, mde.isSinFacturar(), numeros);
                                    resultado += "<br/>" + conn.obtenerTabla(connectDS.SQL_DIA_NORMAL,
                                            mesStrMes, mde.isSinFacturar(), numeros);
                                    completo += resultado;
                                    //  EmailDelegate.sendMailViaGodaddy(mails, "Reporte Diario", resultado);
                                } else {
                                    completo += resultado + conn.obtenerTabla(connectDS.SQL_DIA_NORMAL,
                                            mesStrMes, mde.isSinFacturar(), numeros);
                                    //   EmailDelegate.sendMailViaGodaddy(mails, "Reporte Diario", conn.obtenerTabla(connectDS.SQL_DIA_NORMAL, mesStrMes));
                                }
                            }
                            if (mde.isCompletoColina()) {
                                String resultado = "<br/><br/><div    style=\"font-size: 1.1em;\">"
                                        + "<p  style=\"font-size: 1.1em;color: #7c8d87;\">Reporte Colina</p>"
                                        + "  </div>";
                                if (conn.esPrimerdia()) {
                                    resultado += conn.obtenerTablaColina(connectDS.SQL_PRIMER_DIA_COLINA,
                                            mesStrMesAntColina, mde.isSinFacturar(), numeros);
                                    resultado += "<br/>" + conn.obtenerTablaColina(connectDS.SQL_DIA_NORMAL_COLINA,
                                            mesStrMesColina, mde.isSinFacturar(), numeros);
                                    completo += resultado;
                                    //  EmailDelegate.sendMailViaGodaddy(mails, "Reporte Diario", resultado);
                                } else {
                                    completo += resultado + conn.obtenerTablaColina(connectDS.SQL_DIA_NORMAL_COLINA,
                                            mesStrMesColina, mde.isSinFacturar(), numeros);
                                    //   EmailDelegate.sendMailViaGodaddy(mails, "Reporte Diario", conn.obtenerTabla(connectDS.SQL_DIA_NORMAL, mesStrMes));
                                }
                            }
                            if (!completo.isEmpty()) {
                                EmailDelegate.sendMailViaGodaddy(mails, "Reporte Diario", completo);

                            }
                            /**
                             * Envio de emails reporte móvil
                             */

                            String mailRep = "";
                            if (mde.isMailCountry()) {
                                ReporteMobil repm = new ReporteMobil();
                                String stringReporteMovil = "<div    style=\"font-size: 1.1em;\">"
                                        + "<p  style=\"font-size: 1.1em;color: #7c8d87;\">Reporte Country</p>"
                                        + "  </div>"
                                        + repm.obtenerTabla(numeros);
                                mailRep += stringReporteMovil;

                            }
                            if (mde.isMailColina()) {

                                ReporteMobil repm = new ReporteMobil();
                                String stringReporteMovil = "<br/><br/><div    style=\"font-size: 1.1em;\">"
                                        + "<p  style=\"font-size: 1.1em;color: #7c8d87;\">Reporte Colina</p>"
                                        + "  </div>"
                                        + repm.obtenerTablaColina(numeros);
                                mailRep += stringReporteMovil;

                            }

                            if (!mailRep.isEmpty()) {
                                EmailDelegate.sendMailViaGodaddy(mails, "Reporte Diario Móvil", mailRep);

                            }

                            // System.err.println(">>>> generado");
                        }
                        TaskMailSender.this.reporteGenerado = true;
                        TaskMailSender.trayIcon.displayMessage("Reporte Diario", "Generadio satisfactoriamente", TrayIcon.MessageType.INFO);

                    } catch (Exception ex) {
                        TaskMailSender.this.reporteGenerado = false;
                        TaskMailSender.trayIcon.displayMessage("Reporte Diario", "Reporte no enviado, ocurrió un error inesperado!", TrayIcon.MessageType.ERROR);
                        Logger.getLogger(TaskMailSender.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                /**
                 * Si las horas de reporte son diferentes y el reporte ya se
                 * generó inicializar en false la variable reporte generado. Asi
                 * cuando nuevamente sean las 6 el reporte va a ser enviado
                 */
                if ((horaEnvioReporte != horaActual) && TaskMailSender.this.reporteGenerado) {
                    TaskMailSender.this.reporteGenerado = false;
                }
            }
        };
        Timer time = new Timer();
        /**
         * Revisar la hora cada 10 segundos
         */
        time.scheduleAtFixedRate(mailsTask, new Date(), EmailDelegate.TIEMPO_SEGUNDOS_VERIFICAR_HORA * 1000L);
        /**
         * 1000*segundos=milisegundos???
         */
        Calendar taskTime = Calendar.getInstance();

        taskTime.set(11, 1);

        taskTime.clear(12);

        taskTime.clear(13);

        taskTime.clear(14);

        trayIcon.displayMessage("Informe diario", "Generando informe diario", TrayIcon.MessageType.INFO);

    }

}
