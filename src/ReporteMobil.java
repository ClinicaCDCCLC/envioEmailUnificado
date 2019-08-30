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

    public static final String SQL_REPORTE = "IF(DAY(GETDATE())= 01) "
            + " "
            + "      BEGIN "
            + " "
            + "            SELECT   FechaRegistro,Dia1, Mes1, Año,   OcupacionDia ,  OcupacionProy,OcupacionPpto ,  OcupDiasCama, OcupDiasCamaProy,   OcupDiasCamaPpto,EgrHospi,EGHPPto,EHospiProy,  Cx, CxProy,TCXPto,  CxHosp, CxHospProy, TCXHPto, "
            + " "
            + "CxAmb, CxAmbProy, TCXAPto,  Par_Ces, Par_CesProy, TCXPCPto,  CDiag, CDiagProy, TCXCDPto,  Urg, "
            + " "
            + "UrgTProy,TCUPto,  IngUrg, IngUrgProy, TIUPto,  FacNeta, FacNetaProy,TFPPto,cumpOcup, ClrOcup, cumpCamas, ClrCamas, cumpEhosp,ClrEhosp, cumpCx , ClrCx, cumpHosp, ClrHosp, cumpAmb, ClrAmb, cumpParCes, ClrParCes, "
            + " "
            + "cumpDiag, ClrDiag, cumpUrg, ClrUrg, cumpIngUrg, ClrIngUrg, cumpFacNeta, ClrFacNeta "
            + " "
            + "            FROM        VwInformeDiarioProy "
            + " "
            + "            WHERE     (Dia1 = DAY(GETDATE()-1)) "
            + " "
            + "            AND (MONTH(FechaRegistro) = MONTH(GETDATE()-1)) AND (YEAR(FechaRegistro) = YEAR(GETDATE()-1)) "
            + " "
            + "     END "
            + " "
            + "ELSE "
            + " "
            + "     BEGIN "
            + " "
            + "IF(DAY(GETDATE())= 02 ) "
            + " "
            + "            BEGIN "
            + " "
            + "                  SELECT   FechaRegistro,Dia1, Mes1, Año,   OcupacionDia ,  OcupacionProy,OcupacionPpto ,  OcupDiasCama, OcupDiasCamaProy,   OcupDiasCamaPpto,EgrHospi,EGHPPto,EHospiProy,  Cx, CxProy,TCXPto,  CxHosp, CxHospProy, TCXHPto,CxAmb, CxAmbProy, TCXAPto,  Par_Ces, Par_CesProy, TCXPCPto,  CDiag, CDiagProy, TCXCDPto,  Urg, "
            + " "
            + "UrgTProy,TCUPto,  IngUrg, IngUrgProy, TIUPto,  FacNeta, FacNetaProy,TFPPto,cumpOcup, ClrOcup, cumpCamas, ClrCamas,cumpEhosp,ClrEhosp, cumpCx, ClrCx, cumpHosp, ClrHosp, cumpAmb, ClrAmb, cumpParCes, ClrParCes, "
            + " "
            + "cumpDiag, ClrDiag, cumpUrg, ClrUrg, cumpIngUrg, ClrIngUrg, cumpFacNeta, ClrFacNeta "
            + " "
            + "                  FROM        VwInformeDiarioProy "
            + " "
            + "                  WHERE     (Dia1 = DAY(GETDATE()-1)) AND (MONTH(FechaRegistro) = MONTH(GETDATE())) AND (YEAR(FechaRegistro) = YEAR(GETDATE()-1)) "
            + " "
            + "            END "
            + " "
            + "ELSE "
            + " "
            + "            BEGIN "
            + " "
            + "            SELECT   FechaRegistro,Dia1, Mes1, Año,   OcupacionDia ,  OcupacionProy,OcupacionPpto ,  OcupDiasCama, OcupDiasCamaProy,   OcupDiasCamaPpto,EgrHospi,EGHPPto,EHospiProy,  Cx, CxProy,TCXPto,  CxHosp, CxHospProy, TCXHPto, "
            + " "
            + "CxAmb, CxAmbProy, TCXAPto,  Par_Ces, Par_CesProy, TCXPCPto,  CDiag, CDiagProy, TCXCDPto,  Urg,UrgTProy,TCUPto,  IngUrg, IngUrgProy, TIUPto,  FacNeta, FacNetaProy,TFPPto,cumpOcup, ClrOcup, cumpCamas, ClrCamas,cumpEhosp,ClrEhosp, cumpCx, ClrCx, cumpHosp, ClrHosp, cumpAmb, ClrAmb, cumpParCes, ClrParCes,cumpDiag, ClrDiag, cumpUrg, ClrUrg, cumpIngUrg, ClrIngUrg, cumpFacNeta,ClrFacNeta "
            + " "
            + "            FROM        VwInformeDiarioProy "
            + " "
            + "            WHERE     (Dia1 = DAY(GETDATE()-1)) AND (MONTH(FechaRegistro-1) = MONTH(GETDATE())) AND (YEAR(FechaRegistro) = YEAR(GETDATE()-1)) "
            + " "
            + "            END "
            + " "
            + "END";

    public static final String SQL_REPORTE_COLINA = "IF(DAY(GETDATE())= 01) "
            + " "
            + "      BEGIN "
            + " "
            + "            SELECT   FechaRegistro,Dia1, Mes1, Año,   OcupacionDia ,  OcupacionProy,OcupacionPpto ,  OcupDiasCama, OcupDiasCamaProy,   OcupDiasCamaPpto,EgrHospi,EGHPPto,EHospiProy,  Cx, CxProy,TCXPto,  CxHosp, CxHospProy, TCXHPto, "
            + " "
            + "CxAmb, CxAmbProy, TCXAPto,  Par_Ces, Par_CesProy, TCXPCPto,   Urg, "
            + " "
            + "UrgTProy,TCUPto,  IngUrg, IngUrgProy, TIUPto,  FacNeta, FacNetaProy,TFPPto,cumpOcup, ClrOcup, cumpCamas, ClrCamas, cumpEhosp,ClrEhosp, cumpCx , ClrCx, cumpHosp, ClrHosp, cumpAmb, ClrAmb, cumpParCes, ClrParCes, "
            + " "
            + "cumpUrg, ClrUrg, cumpIngUrg, ClrIngUrg, cumpFacNeta, ClrFacNeta "
            + " "
            + "            FROM        VwInformeDiarioProyCol "
            + " "
            + "            WHERE     (Dia1 = DAY(GETDATE()-1)) "
            + " "
            + "            AND (MONTH(FechaRegistro) = MONTH(GETDATE()-1)) AND (YEAR(FechaRegistro) = YEAR(GETDATE()-1)) "
            + " "
            + "     END "
            + " "
            + "ELSE "
            + " "
            + "     BEGIN "
            + " "
            + "IF(DAY(GETDATE())= 02 ) "
            + " "
            + "            BEGIN "
            + " "
            + "                  SELECT   FechaRegistro,Dia1, Mes1, Año,   OcupacionDia ,  OcupacionProy,OcupacionPpto ,  OcupDiasCama, OcupDiasCamaProy,   OcupDiasCamaPpto,EgrHospi,EGHPPto,EHospiProy,  Cx, CxProy,TCXPto,  CxHosp, CxHospProy, TCXHPto,CxAmb, CxAmbProy, TCXAPto,  Par_Ces, Par_CesProy, TCXPCPto,   Urg, "
            + " "
            + "UrgTProy,TCUPto,  IngUrg, IngUrgProy, TIUPto,  FacNeta, FacNetaProy,TFPPto,cumpOcup, ClrOcup, cumpCamas, ClrCamas,cumpEhosp,ClrEhosp, cumpCx, ClrCx, cumpHosp, ClrHosp, cumpAmb, ClrAmb, cumpParCes, ClrParCes, "
            + " "
            + " cumpUrg, ClrUrg, cumpIngUrg, ClrIngUrg, cumpFacNeta, ClrFacNeta "
            + " "
            + "                  FROM        VwInformeDiarioProyCol "
            + " "
            + "                  WHERE     (Dia1 = DAY(GETDATE()-1)) AND (MONTH(FechaRegistro) = MONTH(GETDATE())) AND (YEAR(FechaRegistro) = YEAR(GETDATE()-1)) "
            + " "
            + "            END "
            + " "
            + "ELSE "
            + " "
            + "            BEGIN "
            + " "
            + "            SELECT   FechaRegistro,Dia1, Mes1, Año,   OcupacionDia ,  OcupacionProy,OcupacionPpto ,  OcupDiasCama, OcupDiasCamaProy,   OcupDiasCamaPpto,EgrHospi,EGHPPto,EHospiProy,  Cx, CxProy,TCXPto,  CxHosp, CxHospProy, TCXHPto, "
            + " "
            + "CxAmb, CxAmbProy, TCXAPto,  Par_Ces, Par_CesProy, TCXPCPto,    Urg,UrgTProy,TCUPto,  IngUrg, IngUrgProy, TIUPto,  FacNeta, FacNetaProy,TFPPto,cumpOcup, ClrOcup, cumpCamas, ClrCamas,cumpEhosp,ClrEhosp, cumpCx, ClrCx, cumpHosp, ClrHosp, cumpAmb, ClrAmb, cumpParCes, ClrParCes,  cumpUrg, ClrUrg, cumpIngUrg, ClrIngUrg, cumpFacNeta,ClrFacNeta "
            + " "
            + "            FROM        VwInformeDiarioProyCol "
            + " "
            + "            WHERE     (Dia1 = DAY(GETDATE()-1)) AND (MONTH(FechaRegistro-1) = MONTH(GETDATE())) AND (YEAR(FechaRegistro) = YEAR(GETDATE()-1)) "
            + " "
            + "            END "
            + " "
            + "END";

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
            con = new connectDS().conn();

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

                if(numeros){
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
//               resultado = resultado + "<td '> ";
//                resultado = resultado + rs.getLong("Dia");
//                resultado = resultado + "</td>";
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
//        resultado = resultado + "<tfoot><tr style='background-color: rgb(40,98,161);'><td colspan='4'></td></tr>";
//        resultado = resultado + "<tr style='color:   black;font-size: 1.1em;'>";
//        resultado = resultado + "<td>Pendientes HB</td>";
//        resultado = resultado + "<td  style='text-align:  right;'>" + nf.format(phb) + "</td>";
//        resultado = resultado + "<td>" + "" + "</td>";
//        resultado = resultado + "<td >" + "" + "</td>";
//        resultado = resultado + "</tr>";
//
//        resultado = resultado + "<tr style=\"color:   black;font-size: 1.1em;\">";
//        resultado = resultado + "<td>Salidas probables</td>";
//        resultado = resultado + "<td  style='text-align:  right;'>" + nf.format(sprobable) + "</td>";
//        resultado = resultado + "<td>" + "" + "</td>";
//        resultado = resultado + "<td >" + "" + "</td>";
//        resultado = resultado + "</tr>";
//
//        resultado = resultado + "<tr style=\"color:   black;font-size: 1.1em;\">";
//        resultado = resultado + "<td>Cx prog.</td>";
//        resultado = resultado + "<td  style='text-align:  right;'>" + nf.format(cxProg) + "</td>";
//        resultado = resultado + "<td>" + "" + "</td>";
//        resultado = resultado + "<td >" + "" + "</td>";
//        resultado = resultado + "</tr>";
//        resultado = resultado + "</tfoot>";
        resultado = resultado + "</table>";

        String cabecera = "<style>"
                //                + "@media only screen and (max-device-width: 480px) { "
                //                + "    .mail { "
                //                + "          display:none !important; "
                //                + "     } "
                //                + "} "
                //                + " @media only screen and (min-device-width: 768px) and (max-device-width: 1024px){ "
                //                + "    .mail { "
                //                + "          display:none !important; "
                //                + "     } "
                //                + "}"
                //                + " "

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
            con = new connectDS().conn();

            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL_REPORTE_COLINA);
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

//                resultado = resultado + "<tr class='grid'>";
//                resultado = resultado + "<td> ";
//                resultado = resultado + "CDiag.";
//                resultado = resultado + "</td>";
//                resultado = resultado + "<td style='text-align:  right;'> ";
//                resultado = resultado + "" + nf.format(rs.getLong("CDiag"));
//                resultado = resultado + "</td>";
//                resultado = resultado + "<td style='text-align:  right;'> ";
//                resultado = resultado + "" + nf.format(rs.getLong("CDiagProy"));
//                resultado = resultado + "</td>";
//                resultado = resultado + "<td style='text-align:  right;'> ";
//                resultado = resultado + "" + nf.format(rs.getLong("TCXCDPto"));
//                resultado = resultado + "</td>";
//                resultado = resultado + "<td style='text-align:  right;'> ";
//                resultado = resultado + color(df.format((float) (rs.getFloat("cumpDiag") * 100)) + "%", rs.getInt("ClrDiag"));
//                resultado = resultado + "</td>";
//                resultado = resultado + "</tr>";

                resultado = resultado + "<tr class='grid'>";

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

                resultado = resultado + "<tr class='grid' style='background-color: #CADBE7;transition: all .125s ease-in-out;'>";

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
                
                if(numeros){

                resultado = resultado + "<tr class='grid'>";

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
                resultado = resultado + "</tr>";
                }
//               resultado = resultado + "<td '> ";
//                resultado = resultado + rs.getLong("Dia");
//                resultado = resultado + "</td>";
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
//        resultado = resultado + "<tfoot><tr style='background-color: rgb(40,98,161);'><td colspan='4'></td></tr>";
//        resultado = resultado + "<tr style='color:   black;font-size: 1.1em;'>";
//        resultado = resultado + "<td>Pendientes HB</td>";
//        resultado = resultado + "<td  style='text-align:  right;'>" + nf.format(phb) + "</td>";
//        resultado = resultado + "<td>" + "" + "</td>";
//        resultado = resultado + "<td >" + "" + "</td>";
//        resultado = resultado + "</tr>";
//
//        resultado = resultado + "<tr style=\"color:   black;font-size: 1.1em;\">";
//        resultado = resultado + "<td>Salidas probables</td>";
//        resultado = resultado + "<td  style='text-align:  right;'>" + nf.format(sprobable) + "</td>";
//        resultado = resultado + "<td>" + "" + "</td>";
//        resultado = resultado + "<td >" + "" + "</td>";
//        resultado = resultado + "</tr>";
//
//        resultado = resultado + "<tr style=\"color:   black;font-size: 1.1em;\">";
//        resultado = resultado + "<td>Cx prog.</td>";
//        resultado = resultado + "<td  style='text-align:  right;'>" + nf.format(cxProg) + "</td>";
//        resultado = resultado + "<td>" + "" + "</td>";
//        resultado = resultado + "<td >" + "" + "</td>";
//        resultado = resultado + "</tr>";
//        resultado = resultado + "</tfoot>";
        resultado = resultado + "</table>";

        String cabecera = "<style>"
                //                + "@media only screen and (max-device-width: 480px) { "
                //                + "    .mail { "
                //                + "          display:none !important; "
                //                + "     } "
                //                + "} "
                //                + " @media only screen and (min-device-width: 768px) and (max-device-width: 1024px){ "
                //                + "    .mail { "
                //                + "          display:none !important; "
                //                + "     } "
                //                + "}"
                //                + " "

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
                + "                    <p  style=\"font-size: 1.1em;color: #7c8d87;\">" + "Resumen Diario-Facturaci&oacute;n Neta para:  " + mes + "/" + dia + "/" + año + "</p>"
                + "                     </div>"
                + "<table  id = \"table\" class=\"sticky-enabled\" style=\"color:   black;font-size: 0.9em;border-collapse: separate;border-spacing: 2px;font-size: 12px;\">"
                + "    <thead >"
                + "    <tr style=\"color:   black;font-size: 0.9em;\"> "
                + "    <th style=\"background-color: rgb(40,98,161);height: 41px;;color:white;\">Tipo</th>"
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
