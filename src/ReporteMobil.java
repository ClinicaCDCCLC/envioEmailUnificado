
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ramiro
 */
public class ReporteMobil {

    public static final String SQL_REPORTE = "IF( Day(Getdate()) = 01 ) \n"
            + "  BEGIN \n"
            + "      SELECT fecharegistro, \n"
            + "             dia1, \n"
            + "             mes1, \n"
            + "             año, \n"
            + "             ocupaciondia, \n"
            + "             ocupacionproy, \n"
            + "             ocupacionppto, \n"
            + "             ocupdiascama, \n"
            + "             ocupdiascamaproy, \n"
            + "             ocupdiascamappto, \n"
            + "             egrhospi, \n"
            + "             eghppto, \n"
            + "             ehospiproy, \n"
            + "             cx, \n"
            + "             cxproy, \n"
            + "             tcxpto, \n"
            + "             cxhosp, \n"
            + "             cxhospproy, \n"
            + "             tcxhpto, \n"
            + "             cxamb, \n"
            + "             cxambproy, \n"
            + "             tcxapto, \n"
            + "             par_ces, \n"
            + "             par_cesproy, \n"
            + "             tcxpcpto, \n"
            + "             cdiag, \n"
            + "             cdiagproy, \n"
            + "             tcxcdpto, \n"
            + "             urg, \n"
            + "             urgtproy, \n"
            + "             tcupto, \n"
            + "             ingurg, \n"
            + "             ingurgproy, \n"
            + "             tiupto, \n"
            + "             facneta, \n"
            + "             facnetaproy, \n"
            + "             tfppto, \n"
            + "             cumpocup, \n"
            + "             clrocup, \n"
            + "             cumpcamas, \n"
            + "             clrcamas, \n"
            + "             cumpehosp, \n"
            + "             clrehosp, \n"
            + "             cumpcx, \n"
            + "             clrcx, \n"
            + "             cumphosp, \n"
            + "             clrhosp, \n"
            + "             cumpamb, \n"
            + "             clramb, \n"
            + "             cumpparces, \n"
            + "             clrparces, \n"
            + "             cumpdiag, \n"
            + "             clrdiag, \n"
            + "             cumpurg, \n"
            + "             clrurg, \n"
            + "             cumpingurg, \n"
            + "             clringurg, \n"
            + "             cumpfacneta, \n"
            + "             clrfacneta \n"
            + "      FROM   vwinformediarioproy \n"
            + "      WHERE  ( dia1 = Day(Getdate() - 1) ) \n"
            + "             AND ( Month(fecharegistro) = Month(Getdate() - 1) ) \n"
            + "             AND ( Year(fecharegistro) = Year(Getdate() - 1) ) \n"
            + "  END \n"
            + "ELSE \n"
            + "  BEGIN \n"
            + "      IF( Day(Getdate()) = 02 ) \n"
            + "        BEGIN \n"
            + "            SELECT fecharegistro, \n"
            + "                   dia1, \n"
            + "                   mes1, \n"
            + "                   año, \n"
            + "                   ocupaciondia, \n"
            + "                   ocupacionproy, \n"
            + "                   ocupacionppto, \n"
            + "                   ocupdiascama, \n"
            + "                   ocupdiascamaproy, \n"
            + "                   ocupdiascamappto, \n"
            + "                   egrhospi, \n"
            + "                   eghppto, \n"
            + "                   ehospiproy, \n"
            + "                   cx, \n"
            + "                   cxproy, \n"
            + "                   tcxpto, \n"
            + "                   cxhosp, \n"
            + "                   cxhospproy, \n"
            + "                   tcxhpto, \n"
            + "                   cxamb, \n"
            + "                   cxambproy, \n"
            + "                   tcxapto, \n"
            + "                   par_ces, \n"
            + "                   par_cesproy, \n"
            + "                   tcxpcpto, \n"
            + "                   cdiag, \n"
            + "                   cdiagproy, \n"
            + "                   tcxcdpto, \n"
            + "                   urg, \n"
            + "                   urgtproy, \n"
            + "                   tcupto, \n"
            + "                   ingurg, \n"
            + "                   ingurgproy, \n"
            + "                   tiupto, \n"
            + "                   facneta, \n"
            + "                   facnetaproy, \n"
            + "                   tfppto, \n"
            + "                   cumpocup, \n"
            + "                   clrocup, \n"
            + "                   cumpcamas, \n"
            + "                   clrcamas, \n"
            + "                   cumpehosp, \n"
            + "                   clrehosp, \n"
            + "                   cumpcx, \n"
            + "                   clrcx, \n"
            + "                   cumphosp, \n"
            + "                   clrhosp, \n"
            + "                   cumpamb, \n"
            + "                   clramb, \n"
            + "                   cumpparces, \n"
            + "                   clrparces, \n"
            + "                   cumpdiag, \n"
            + "                   clrdiag, \n"
            + "                   cumpurg, \n"
            + "                   clrurg, \n"
            + "                   cumpingurg, \n"
            + "                   clringurg, \n"
            + "                   cumpfacneta, \n"
            + "                   clrfacneta \n"
            + "            FROM   vwinformediarioproy \n"
            + "            WHERE  ( dia1 = Day(Getdate() - 1) ) \n"
            + "                   AND ( Month(fecharegistro) = Month(Getdate()) ) \n"
            + "                   AND ( Year(fecharegistro) = Year(Getdate() - 1) ) \n"
            + "        END \n"
            + "      ELSE \n"
            + "        BEGIN \n"
            + "            SELECT fecharegistro, \n"
            + "                   dia1, \n"
            + "                   mes1, \n"
            + "                   año, \n"
            + "                   ocupaciondia, \n"
            + "                   ocupacionproy, \n"
            + "                   ocupacionppto, \n"
            + "                   ocupdiascama, \n"
            + "                   ocupdiascamaproy, \n"
            + "                   ocupdiascamappto, \n"
            + "                   egrhospi, \n"
            + "                   eghppto, \n"
            + "                   ehospiproy, \n"
            + "                   cx, \n"
            + "                   cxproy, \n"
            + "                   tcxpto, \n"
            + "                   cxhosp, \n"
            + "                   cxhospproy, \n"
            + "                   tcxhpto, \n"
            + "                   cxamb, \n"
            + "                   cxambproy, \n"
            + "                   tcxapto, \n"
            + "                   par_ces, \n"
            + "                   par_cesproy, \n"
            + "                   tcxpcpto, \n"
            + "                   cdiag, \n"
            + "                   cdiagproy, \n"
            + "                   tcxcdpto, \n"
            + "                   urg, \n"
            + "                   urgtproy, \n"
            + "                   tcupto, \n"
            + "                   ingurg, \n"
            + "                   ingurgproy, \n"
            + "                   tiupto, \n"
            + "                   facneta, \n"
            + "                   facnetaproy, \n"
            + "                   tfppto, \n"
            + "                   cumpocup, \n"
            + "                   clrocup, \n"
            + "                   cumpcamas, \n"
            + "                   clrcamas, \n"
            + "                   cumpehosp, \n"
            + "                   clrehosp, \n"
            + "                   cumpcx, \n"
            + "                   clrcx, \n"
            + "                   cumphosp, \n"
            + "                   clrhosp, \n"
            + "                   cumpamb, \n"
            + "                   clramb, \n"
            + "                   cumpparces, \n"
            + "                   clrparces, \n"
            + "                   cumpdiag, \n"
            + "                   clrdiag, \n"
            + "                   cumpurg, \n"
            + "                   clrurg, \n"
            + "                   cumpingurg, \n"
            + "                   clringurg, \n"
            + "                   cumpfacneta, \n"
            + "                   clrfacneta \n"
            + "            FROM   vwinformediarioproy \n"
            + "            WHERE  ( dia1 = Day(Getdate() - 1) ) \n"
            + "                   AND ( Month(fecharegistro - 1) = Month(Getdate()) ) \n"
            + "                   AND ( Year(fecharegistro) = Year(Getdate() - 1) ) \n"
            + "        END \n"
            + "  END;";

    public static final String SQL_REPORTE_COLINA = "IF( Day(Getdate()) = 01 ) \n"
            + "  BEGIN \n"
            + "      SELECT fecharegistro, \n"
            + "             dia1, \n"
            + "             mes1, \n"
            + "             año, \n"
            + "             ocupaciondia, \n"
            + "             ocupacionproy, \n"
            + "             ocupacionppto, \n"
            + "             ocupdiascama, \n"
            + "             ocupdiascamaproy, \n"
            + "             ocupdiascamappto, \n"
            + "             egrhospi, \n"
            + "             eghppto, \n"
            + "             ehospiproy, \n"
            + "             cx, \n"
            + "             cxproy, \n"
            + "             tcxpto, \n"
            + "             cxhosp, \n"
            + "             cxhospproy, \n"
            + "             tcxhpto, \n"
            + "             cxamb, \n"
            + "             cxambproy, \n"
            + "             tcxapto, \n"
            + "             par_ces, \n"
            + "             par_cesproy, \n"
            + "             tcxpcpto, \n"
            + "             cdiag, \n"
            + "             cdiagproy, \n"
            + "             tcxcdpto, \n"
            + "             urg, \n"
            + "             urgtproy, \n"
            + "             tcupto, \n"
            + "             ingurg, \n"
            + "             ingurgproy, \n"
            + "             tiupto, \n"
            + "             facneta, \n"
            + "             facnetaproy, \n"
            + "             tfppto, \n"
            + "             cumpocup, \n"
            + "             clrocup, \n"
            + "             cumpcamas, \n"
            + "             clrcamas, \n"
            + "             cumpehosp, \n"
            + "             clrehosp, \n"
            + "             cumpcx, \n"
            + "             clrcx, \n"
            + "             cumphosp, \n"
            + "             clrhosp, \n"
            + "             cumpamb, \n"
            + "             clramb, \n"
            + "             cumpparces, \n"
            + "             clrparces, \n"
            + "             cumpdiag, \n"
            + "             clrdiag, \n"
            + "             cumpurg, \n"
            + "             clrurg, \n"
            + "             cumpingurg, \n"
            + "             clringurg, \n"
            + "             cumpfacneta, \n"
            + "             clrfacneta \n"
            + "      FROM   vwinformediarioproySahiCol\n"
            + "      WHERE  ( dia1 = Day(Getdate() - 1) ) \n"
            + "             AND ( Month(fecharegistro) = Month(Getdate() - 1) ) \n"
            + "             AND ( Year(fecharegistro) = Year(Getdate() - 1) ) \n"
            + "  END \n"
            + "ELSE \n"
            + "  BEGIN \n"
            + "      IF( Day(Getdate()) = 02 ) \n"
            + "        BEGIN \n"
            + "            SELECT fecharegistro, \n"
            + "                   dia1, \n"
            + "                   mes1, \n"
            + "                   año, \n"
            + "                   ocupaciondia, \n"
            + "                   ocupacionproy, \n"
            + "                   ocupacionppto, \n"
            + "                   ocupdiascama, \n"
            + "                   ocupdiascamaproy, \n"
            + "                   ocupdiascamappto, \n"
            + "                   egrhospi, \n"
            + "                   eghppto, \n"
            + "                   ehospiproy, \n"
            + "                   cx, \n"
            + "                   cxproy, \n"
            + "                   tcxpto, \n"
            + "                   cxhosp, \n"
            + "                   cxhospproy, \n"
            + "                   tcxhpto, \n"
            + "                   cxamb, \n"
            + "                   cxambproy, \n"
            + "                   tcxapto, \n"
            + "                   par_ces, \n"
            + "                   par_cesproy, \n"
            + "                   tcxpcpto, \n"
            + "                   cdiag, \n"
            + "                   cdiagproy, \n"
            + "                   tcxcdpto, \n"
            + "                   urg, \n"
            + "                   urgtproy, \n"
            + "                   tcupto, \n"
            + "                   ingurg, \n"
            + "                   ingurgproy, \n"
            + "                   tiupto, \n"
            + "                   facneta, \n"
            + "                   facnetaproy, \n"
            + "                   tfppto, \n"
            + "                   cumpocup, \n"
            + "                   clrocup, \n"
            + "                   cumpcamas, \n"
            + "                   clrcamas, \n"
            + "                   cumpehosp, \n"
            + "                   clrehosp, \n"
            + "                   cumpcx, \n"
            + "                   clrcx, \n"
            + "                   cumphosp, \n"
            + "                   clrhosp, \n"
            + "                   cumpamb, \n"
            + "                   clramb, \n"
            + "                   cumpparces, \n"
            + "                   clrparces, \n"
            + "                   cumpdiag, \n"
            + "                   clrdiag, \n"
            + "                   cumpurg, \n"
            + "                   clrurg, \n"
            + "                   cumpingurg, \n"
            + "                   clringurg, \n"
            + "                   cumpfacneta, \n"
            + "                   clrfacneta \n"
            + "            FROM   vwinformediarioproySahiCol\n"
            + "            WHERE  ( dia1 = Day(Getdate() - 1) ) \n"
            + "                   AND ( Month(fecharegistro) = Month(Getdate()) ) \n"
            + "                   AND ( Year(fecharegistro) = Year(Getdate() - 1) ) \n"
            + "        END \n"
            + "      ELSE \n"
            + "        BEGIN \n"
            + "            SELECT fecharegistro, \n"
            + "                   dia1, \n"
            + "                   mes1, \n"
            + "                   año, \n"
            + "                   ocupaciondia, \n"
            + "                   ocupacionproy, \n"
            + "                   ocupacionppto, \n"
            + "                   ocupdiascama, \n"
            + "                   ocupdiascamaproy, \n"
            + "                   ocupdiascamappto, \n"
            + "                   egrhospi, \n"
            + "                   eghppto, \n"
            + "                   ehospiproy, \n"
            + "                   cx, \n"
            + "                   cxproy, \n"
            + "                   tcxpto, \n"
            + "                   cxhosp, \n"
            + "                   cxhospproy, \n"
            + "                   tcxhpto, \n"
            + "                   cxamb, \n"
            + "                   cxambproy, \n"
            + "                   tcxapto, \n"
            + "                   par_ces, \n"
            + "                   par_cesproy, \n"
            + "                   tcxpcpto, \n"
            + "                   cdiag, \n"
            + "                   cdiagproy, \n"
            + "                   tcxcdpto, \n"
            + "                   urg, \n"
            + "                   urgtproy, \n"
            + "                   tcupto, \n"
            + "                   ingurg, \n"
            + "                   ingurgproy, \n"
            + "                   tiupto, \n"
            + "                   facneta, \n"
            + "                   facnetaproy, \n"
            + "                   tfppto, \n"
            + "                   cumpocup, \n"
            + "                   clrocup, \n"
            + "                   cumpcamas, \n"
            + "                   clrcamas, \n"
            + "                   cumpehosp, \n"
            + "                   clrehosp, \n"
            + "                   cumpcx, \n"
            + "                   clrcx, \n"
            + "                   cumphosp, \n"
            + "                   clrhosp, \n"
            + "                   cumpamb, \n"
            + "                   clramb, \n"
            + "                   cumpparces, \n"
            + "                   clrparces, \n"
            + "                   cumpdiag, \n"
            + "                   clrdiag, \n"
            + "                   cumpurg, \n"
            + "                   clrurg, \n"
            + "                   cumpingurg, \n"
            + "                   clringurg, \n"
            + "                   cumpfacneta, \n"
            + "                   clrfacneta \n"
            + "            FROM   vwinformediarioproySahiCol\n"
            + "            WHERE  ( dia1 = Day(Getdate() - 1) ) \n"
            + "                   AND ( Month(fecharegistro - 1) = Month(Getdate()) ) \n"
            + "                   AND ( Year(fecharegistro) = Year(Getdate() - 1) ) \n"
            + "        END \n"
            + "  END;";

    private String color(String valor, int color) {
        switch (color) {
            case 3:
                return "<table align=\"right\" cellspacing=\"0\" cellpadding=\"0\"> <tr> "
                        + "<td style=\"font-size: 0.8em\">" + valor + "</td>"
                        + "  <td align=\"center\" width=\"16\" height=\"10\" bgcolor=\"#B60000\" style=\"font-size: 0.7em;-webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; color: #B60000; display: block;\"> "
                        + "  </td>  "
                        + "  </tr> </table>  ";
            case 1:
                return "<table align=\"right\" cellspacing=\"0\" cellpadding=\"0\"> <tr> "
                        + "<td style=\"font-size: 0.8em\">" + valor + "</td>"
                        + "  <td align=\"center\" width=\"16\" height=\"10\" bgcolor=\"#006405\" style=\"-webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; color: #006405; display: block;\"> "
                        + "    <span style=\"color: #006405;\">"
                        + "        "
                        + "    </span>"
                        + "  </td>  "
                        + "  </tr> </table>";
            case 2:
                return "<table align=\"right\" cellspacing=\"0\" cellpadding=\"0\"> <tr> "
                        + "<td style=\"font-size: 0.8em\">" + valor + "</td>"
                        + "  <td align=\"center\" width=\"16\" height=\"10\" bgcolor=\"#F9FF00\" style=\"-webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; color: #F9FF00; display: block;\"> "
                        + "    <span style=\"color: #F9FF00;\">"
                        + "      "
                        + "    </span>"
                        + "  </td>  "
                        + "  </tr> </table>  ";

        }
        return "";
    }

    public String obtenerTabla(boolean numeros) {

        String resultado = "";

        Connection con = null;

        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = "";
        resultado = resultado + "";

        Long phb = null;
        Long sprobable = null;
        Long cxProg = null;
        String dia = "";
        String año = "";
        NumberFormat nf = NumberFormat.getInstance();
        try {
            con = new connectDS().conn_country();

            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_REPORTE);
            boolean seguir = true;
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            while (rs.next() && seguir) {
//                phb = rs.getLong("HPendientes");
//                sprobable = rs.getLong("SProbables");
//                cxProg = rs.getLong("CxSProgram");
                dia = rs.getString("Dia1");
                mes = rs.getString("Mes1");
                año = rs.getString("Año");

                seguir = false;

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";
                // style='text-align:center;'

                resultado = resultado + "<td class='grid' >";
                resultado = resultado + "Ocupaci&oacute;n";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + (int) (rs.getFloat("OcupacionDia") * 100) + "%";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + (int) (rs.getFloat("OcupacionProy") * 100) + "%";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + (int) (rs.getFloat("OcupacionPpto") * 100) + "%";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpOcup") * 100)) + "%", rs.getInt("ClrOcup"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";
                resultado = resultado + "<td  style='font-weight: 900;'> ";
                resultado = resultado + "D&iacute;as cama";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("OcupDiasCama"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("OcupDiasCamaProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("OcupDiasCamaPpto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpCamas") * 100)) + "%", rs.getInt("ClrCamas"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";
                resultado = resultado + "<td style='font-weight: 900;'> ";
                resultado = resultado + "Egresos Hospi";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("EgrHospi"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("EHospiProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("EGHPPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpEhosp") * 100)) + "%", rs.getInt("ClrEhosp"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";
                resultado = resultado + "<td  style='font-weight: 900;'> ";
                resultado = resultado + "Cx";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("Cx"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpCx") * 100)) + "%", rs.getInt("ClrCx"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";
                resultado = resultado + "<td> ";
                resultado = resultado + "Hosp.";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxHosp"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxHospProy"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXHPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpHosp") * 100)) + "%", rs.getInt("ClrHosp"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";
                resultado = resultado + "<td> ";
                resultado = resultado + "Amb.";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxAmb"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxAmbProy"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXAPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpAmb") * 100)) + "%", rs.getInt("ClrAmb"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";
                resultado = resultado + "<td> ";
                resultado = resultado + "Par_Ces.";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("Par_Ces"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("Par_CesProy"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXPCPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpParCes") * 100)) + "%", rs.getInt("ClrParCes")) + "";
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";
                resultado = resultado + "<td> ";
                resultado = resultado + "CDiag.";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CDiag"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CDiagProy"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXCDPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpDiag") * 100)) + "%", rs.getInt("ClrDiag"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";

                resultado = resultado + "<td style='font-weight: 900;'> ";
                resultado = resultado + "Urg";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("Urg"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("UrgTProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCUPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpUrg") * 100)) + "%", rs.getInt("ClrUrg"));
                resultado = resultado + "</td>";

                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";

                resultado = resultado + "<td style='font-weight: 900;'> ";
                resultado = resultado + "Ing Urg";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("IngUrg"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("IngUrgProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TIUPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpIngUrg") * 100)) + "%", rs.getInt("ClrIngUrg"));
                resultado = resultado + "</td>";

                resultado = resultado + "</tr>";

                if (numeros) {
                    resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";

                    resultado = resultado + "<td style='font-weight: 900;'> ";
                    resultado = resultado + "Total Fac. Neta M$";
                    resultado = resultado + "</td>";

                    resultado = resultado + "<td style='text-align:  right;'> ";
                    resultado = resultado + "" + nf.format(rs.getLong("FacNeta"));
                    resultado = resultado + "</td>";

                    resultado = resultado + "<td style='text-align:  right;'> ";
                    resultado = resultado + "" + nf.format(rs.getLong("FacNetaProy"));
                    resultado = resultado + "</td>";

                    resultado = resultado + "<td style='text-align:  right;'> ";
                    resultado = resultado + "" + nf.format(rs.getLong("TFPPto"));
                    resultado = resultado + "</td>";
                    resultado = resultado + "<td style='text-align:  right;'> ";
                    resultado = resultado + color(df.format((float) (rs.getFloat("cumpFacNeta") * 100)) + "%", rs.getInt("ClrFacNeta")) + "";
                    resultado = resultado + "</td>";
                }
                resultado = resultado + "</tr>";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }

        resultado = resultado + "</tbody>";
        resultado = resultado + "</table>";

        String cabecera = "<style>"
                + ".mail { "
                + " float: right !important; "
                + "} "
                + " *{"
                + "font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;"
                + "font-size: 1em;"
                + "padding: 8px;"
                + "}"
                + "td{color: #333;padding: 4px;}"
                + "th"
                + "{"
                + "box-sizing: border-box;"
                + "text-align: center;"
                + "}"
                + "tbody tr:nth-child(2n) { "
                + "background-color: #CADBE7;transition: all .125s ease-in-out; "
                + "}"
                + "tfoot  tr:nth-child(2n) {"
                + "background-color: #CADBE7; "
                + "transition: all .125s ease-in-out; "
                + "}"
                + "    .circle {"
                + "                -moz-border-radius: 50%;"
                + "                -webkit-border-radius: 50%;"
                + "                -khtml-border-radius: 50%;"
                + "                border-radius: 50%;"
                + "                display: inline-block;"
                + "                margin-right: 50%;"
                + "                width: 1px;"
                + "                height: 1px;"
                + ""
                + "            }"
                + " #rojo {"
                + "                background: red;       "
                + "            }"
                + " #verde {"
                + "                background: green;"
                + "            }"
                + "  #amarillo {"
                + "                background: yellow;"
                + "}  "
                + "</style>"
                + "<div    style=\"font-size: 1.1em;\"> "
                + "                    <p  style=\"font-size: 1.1em;color: #7c8d87;\">" + "Resumen Diario-Facturaci&oacute;n Neta para: " + mes + "/" + dia + "/" + año + "</p>"
                + "                     </div>"
                + "<table  id = \"table\" class=\"sticky-enabled\" style=\"color:   black;font-size: 0.9em;border-collapse: separate;border-spacing: 2px;font-size: 12px;\">"
                + "    <thead >"
                + "    <tr style=\"color:   black;font-size: 0.9em;\"> "
                + "    <th style=\"background-color: rgb(40,98,161);height: 41px;color:white;\">Tipo</th>"
                + "    <th style=\"background-color: #ebebeb;color:#2862a1;color:#2862a1;\">D&iacute;a</th>"
                + "    <th style=\"background-color: rgb(40,98,161);;color:white;\">Proy.</th>"
                + "    <th style=\"background-color: #ebebeb;color:#2862a1;color:#2862a1;\">Ppto.</th>"
                + "    <th style=\"  width: 70px;background-color: rgb(40,98,161);;color:white;\">Cump.</th>"
                + "    </tr>"
                + "    </thead>"
                + "    <tbody>";

        return cabecera + resultado;
    }

    public String obtenerTablaColina(boolean numeros) {
        String resultado = "";

        Connection con = null;

        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = "";
        resultado = resultado + "";

        Long phb = null;
        Long sprobable = null;
        Long cxProg = null;
        String dia = "";
        String año = "";
        NumberFormat nf = NumberFormat.getInstance();
        try {
            con = new connectDS().conn_colina();

            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_REPORTE_COLINA);
            boolean seguir = true;
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            while (rs.next() && seguir) {
                dia = rs.getString("Dia1");
                mes = rs.getString("Mes1");
                año = rs.getString("Año");

                seguir = false;

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";
                // style='text-align:center;'

                resultado = resultado + "<td class='grid' >";
                resultado = resultado + "Ocupaci&oacute;n";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + (int) (rs.getFloat("OcupacionDia") * 100) + "%";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + (int) (rs.getFloat("OcupacionProy") * 100) + "%";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + (int) (rs.getFloat("OcupacionPpto") * 100) + "%";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpOcup") * 100)) + "%", rs.getInt("ClrOcup"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";
                resultado = resultado + "<td  style='font-weight: 900;'> ";
                resultado = resultado + "D&iacute;as cama";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("OcupDiasCama"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("OcupDiasCamaProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("OcupDiasCamaPpto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpCamas") * 100)) + "%", rs.getInt("ClrCamas"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";
                resultado = resultado + "<td style='font-weight: 900;'> ";
                resultado = resultado + "Egresos Hospi";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("EgrHospi"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("EHospiProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("EGHPPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpEhosp") * 100)) + "%", rs.getInt("ClrEhosp"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";
                resultado = resultado + "<td  style='font-weight: 900;'> ";
                resultado = resultado + "Cx";
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("Cx"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpCx") * 100)) + "%", rs.getInt("ClrCx"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";
                resultado = resultado + "<td> ";
                resultado = resultado + "Hosp.";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxHosp"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxHospProy"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXHPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpHosp") * 100)) + "%", rs.getInt("ClrHosp"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";
                resultado = resultado + "<td> ";
                resultado = resultado + "Amb.";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxAmb"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CxAmbProy"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXAPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpAmb") * 100)) + "%", rs.getInt("ClrAmb"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";
                resultado = resultado + "<td> ";
                resultado = resultado + "Par_Ces.";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("Par_Ces"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("Par_CesProy"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXPCPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpParCes") * 100)) + "%", rs.getInt("ClrParCes")) + "";
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";
                resultado = resultado + "<td> ";
                resultado = resultado + "CDiag.";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CDiag"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("CDiagProy"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCXCDPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpDiag") * 100)) + "%", rs.getInt("ClrDiag"));
                resultado = resultado + "</td>";
                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";

                resultado = resultado + "<td style='font-weight: 900;'> ";
                resultado = resultado + "Urg";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("Urg"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("UrgTProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TCUPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpUrg") * 100)) + "%", rs.getInt("ClrUrg"));
                resultado = resultado + "</td>";

                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";

                resultado = resultado + "<td style='font-weight: 900;'> ";
                resultado = resultado + "Ing Urg";
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("IngUrg"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("IngUrgProy"));
                resultado = resultado + "</td>";

                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + "" + nf.format(rs.getLong("TIUPto"));
                resultado = resultado + "</td>";
                resultado = resultado + "<td style='text-align:  right;'> ";
                resultado = resultado + color(df.format((float) (rs.getFloat("cumpIngUrg") * 100)) + "%", rs.getInt("ClrIngUrg"));
                resultado = resultado + "</td>";

                resultado = resultado + "</tr>";

                if (numeros) {
                    resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";

                    resultado = resultado + "<td style='font-weight: 900;'> ";
                    resultado = resultado + "Total Fac. Neta M$";
                    resultado = resultado + "</td>";

                    resultado = resultado + "<td style='text-align:  right;'> ";
                    resultado = resultado + "" + nf.format(rs.getLong("FacNeta"));
                    resultado = resultado + "</td>";

                    resultado = resultado + "<td style='text-align:  right;'> ";
                    resultado = resultado + "" + nf.format(rs.getLong("FacNetaProy"));
                    resultado = resultado + "</td>";

                    resultado = resultado + "<td style='text-align:  right;'> ";
                    resultado = resultado + "" + nf.format(rs.getLong("TFPPto"));
                    resultado = resultado + "</td>";
                    resultado = resultado + "<td style='text-align:  right;'> ";
                    resultado = resultado + color(df.format((float) (rs.getFloat("cumpFacNeta") * 100)) + "%", rs.getInt("ClrFacNeta")) + "";
                    resultado = resultado + "</td>";
                }
                resultado = resultado + "</tr>";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
            }
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (Exception e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }

        resultado = resultado + "</tbody>";
        resultado = resultado + "</table>";

        String cabecera = "<style>"
                + ".mail { "
                + " float: right !important; "
                + "} "
                + " *{"
                + "font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;"
                + "font-size: 1em;"
                + "padding: 8px;"
                + "}"
                + "td{color: #333;padding: 4px;}"
                + "th"
                + "{"
                + "box-sizing: border-box;"
                + "text-align: center;"
                + "}"
                + "tbody tr:nth-child(2n) { "
                + "background-color: #CADBE7;transition: all .125s ease-in-out; "
                + "}"
                + "tfoot  tr:nth-child(2n) {"
                + "background-color: #CADBE7; "
                + "transition: all .125s ease-in-out; "
                + "}"
                + "    .circle {"
                + "                -moz-border-radius: 50%;"
                + "                -webkit-border-radius: 50%;"
                + "                -khtml-border-radius: 50%;"
                + "                border-radius: 50%;"
                + "                display: inline-block;"
                + "                margin-right: 50%;"
                + "                width: 1px;"
                + "                height: 1px;"
                + ""
                + "            }"
                + " #rojo {"
                + "                background: red;       "
                + "            }"
                + " #verde {"
                + "                background: green;"
                + "            }"
                + "  #amarillo {"
                + "                background: yellow;"
                + "}  "
                + "</style>"
                + "<div    style=\"font-size: 1.1em;\"> "
                + "                    <p  style=\"font-size: 1.1em;color: #7c8d87;\">" + "Resumen Diario-Facturaci&oacute;n Neta para: " + mes + "/" + dia + "/" + año + "</p>"
                + "                     </div>"
                + "<table  id = \"table\" class=\"sticky-enabled\" style=\"color:   black;font-size: 0.9em;border-collapse: separate;border-spacing: 2px;font-size: 12px;\">"
                + "    <thead >"
                + "    <tr style=\"color:   black;font-size: 0.9em;\"> "
                + "    <th style=\"background-color: rgb(40,98,161);height: 41px;color:white;\">Tipo</th>"
                + "    <th style=\"background-color: #ebebeb;color:#2862a1;color:#2862a1;\">D&iacute;a</th>"
                + "    <th style=\"background-color: rgb(40,98,161);;color:white;\">Proy.</th>"
                + "    <th style=\"background-color: #ebebeb;color:#2862a1;color:#2862a1;\">Ppto.</th>"
                + "    <th style=\"  width: 70px;background-color: rgb(40,98,161);;color:white;\">Cump.</th>"
                + "    </tr>"
                + "    </thead>"
                + "    <tbody>";

        return cabecera + resultado;
    }
}
