
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

public class connectDS {

    public Connection conn_country() throws SQLServerException {
        Connection con = null;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setIntegratedSecurity(false);
        /**
         * Producción
         */
        ds.setUser("conexion");
        ds.setPassword("Server2011_Acceso.");
        ds.setServerName("10.10.131.48");
        ds.setPortNumber(1047);
        ds.setDatabaseName("CTY_PRI");

        /**
         * Pruebas
         */
//        ds.setUser("pruebas");
//        ds.setPassword("123");
//        ds.setServerName("10.10.131.29");
//        ds.setPortNumber(1433);
//        ds.setDatabaseName("CTY_PRI");
        con = ds.getConnection();
        return con;
    }

    public Connection conn_colina() throws SQLServerException {
        Connection con = null;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setIntegratedSecurity(false);
        /**
         * Producción
         */
        ds.setUser("conexion");
        ds.setPassword("Server2011_Acceso.");
        ds.setServerName("10.10.131.48");
        ds.setPortNumber(1047);
        ds.setDatabaseName("Estadistica");

        /**
         * Pruebas
         */
//        ds.setUser("pruebas");
//        ds.setPassword("123");
//        ds.setServerName("10.10.131.29");
//        ds.setPortNumber(1433);
//        ds.setDatabaseName("Estadistica");
        con = ds.getConnection();
        return con;
    }

    public String obtenerUltimoMes() {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        try {
            String sql = "SELECT  LTRIM(RTRIM(SUBSTRING(Mes, 1,2 )))AS Mes1,Mes,FechaRegistro FROM InformeDiario  order by (FechaRegistro)  desc ";
            con = this.conn_country();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next() && mes == null) {
                mes = rs.getString("Mes");

            }

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
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
        return mes;

    }

    public Double[] obtenerDatosCountryMes(String mes) {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        Double[] datos = null;

        try {
            String sql;
            con = this.conn_country();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            sql = Sql.SQL_INICIO.replace("???", mes);
            System.err.println(">>>" + sql);
            stmt.execute(sql);
            datos = new Double[2];
            datos[0] = 0D;
            datos[1] = 0D;
            rs = stmt.executeQuery(Sql.SQL_SELECT);
            while (rs.next()) {
                datos[0] = rs.getDouble("PorFacturarConEgreso");
                datos[1] = rs.getDouble("PacientesAcostados");

            }

            stmt.execute(Sql.SQL_DROP);

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return datos;

    }

    public Double[] obtenerDatosColinaMes(String mes) {
        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        Double[] datos = null;

        try {
            String sql;
            con = this.conn_colina();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            sql = Sql.SQL_INICIO_COLINA.replace("???", mes);
            System.err.println(">>>" + sql);
            stmt.execute(sql);
            datos = new Double[2];
            datos[0] = 0D;
            datos[1] = 0D;
            rs = stmt.executeQuery(Sql.SQL_SELECT_COLINA);
            while (rs.next()) {
                datos[0] = rs.getDouble("PorFacturarConEgreso");
                datos[1] = rs.getDouble("PacientesAcostados");

            }

            stmt.execute(Sql.SQL_DROP_COLINA);

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return datos;
    }

    public String obtenerUltimoMesColina() {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        try {
            String sql = "SELECT  LTRIM(RTRIM(SUBSTRING(Mes, 1,2 )))AS Mes1,Mes,FechaRegistro FROM InformeDiarioSahiCol  order by (FechaRegistro)  desc ";
            con = this.conn_colina();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next() && mes == null) {
                mes = rs.getString("Mes");

            }

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
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
        return mes;

    }
//
//    public static void main(String args[]) {
//        System.err.println(">>>" + new connectDS().esPrimerdia());
//    }

    public boolean esPrimerdia() {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        int dia = 0;
        try {
            String sql = "SELECT  (DAY(GETDATE())) as dia";
            con = this.conn_country();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                dia = rs.getInt("dia");

            }

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
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
        return dia == 1;
        // return true;

    }

    public String obtenerNombreUltimoMesMenosUno() {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        try {
            String sql = "SELECT  LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1,Mes,FechaRegistro FROM InformeDiario WHERE  MONTH(FechaRegistro)= MONTH(GETDATE())-1 and YEAR(FechaRegistro) = YEAR(GETDATE())   order by (FechaRegistro)  desc  ";
            con = this.conn_country();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next() && mes == null) {
                mes = rs.getString("Mes1");

            }

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
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
        return mes;

    }

    public String obtenerNombreUltimoMesMenosUnoColina() {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        try {
            String sql = "SELECT  LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1,Mes,FechaRegistro FROM InformeDiarioSahiCol WHERE  MONTH(FechaRegistro)= MONTH(GETDATE())-1 and YEAR(FechaRegistro) = YEAR(GETDATE())   order by (FechaRegistro)  desc  ";
            con = this.conn_colina();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next() && mes == null) {
                mes = rs.getString("Mes1");

            }

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
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
        return mes;

    }

    public String obtenerNombreUltimoMes() {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        try {
            String sql = "SELECT  LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1,Mes,FechaRegistro FROM InformeDiario WHERE  MONTH(FechaRegistro)= MONTH(GETDATE()) and YEAR(FechaRegistro) = YEAR(GETDATE())   order by (FechaRegistro)  desc ";
            con = this.conn_country();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next() && mes == null) {
                mes = rs.getString("Mes1");

            }

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
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
        return mes;

    }

    public String obtenerNombreUltimoMesColina() {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        try {
            String sql = "SELECT  LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1,Mes,FechaRegistro FROM InformeDiarioSahiCol WHERE  MONTH(FechaRegistro)= MONTH(GETDATE()) and YEAR(FechaRegistro) = YEAR(GETDATE())   order by (FechaRegistro)  desc ";
            con = this.conn_colina();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next() && mes == null) {
                mes = rs.getString("Mes1");

            }

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
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
        return mes;

    }

    public static String SQL_DIA_NORMAL = "            SELECT     TCamas, (Unidad+Hospi) as Ocupadas,Unidad as CriticoO, Hospi as NoCriticoO,  "
            + "  "
            + "                  (Critico-Unidad-MantCri)+(NCritico-Hospi-MantNcri)as Disponible,  "
            + "  "
            + "                  (Critico-Unidad-MantCri) as Critico, (NCritico-Hospi-MantNcri)as NoCritico , MantTot, MantCri, MantNcri, HPendientes, SProbables, CxSProgram, EgrHospi,(CxProg+Partos)as CxProgramada ,  "
            + "  "
            + "                  (Cra15+Partos)as Cra15, Cra16, CDiag, CxAmb, (CxHosp-Cesareas) as CxHosp,(Partos+Cesareas) as Par_Ces,Partos,Cesareas, UrgT, UrgA, UrgP, UrgO,  "
            + "  "
            + "                                                 IUrg, DUrCxMa, DUrgMed, Mes, Dia, FacNeta, FecInfo,FechaRegistro,LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1, YEAR(fecinfo) as Año  "
            + "  "
            + "            FROM         InformeDiario  "
            + "  "
            + "            where MONTH(FechaRegistro)= MONTH(GETDATE()) and YEAR(FechaRegistro) = YEAR(GETDATE())  ";

    public static String SQL_DIA_NORMAL_COLINA = "            SELECT     TCamas, (Unidad+Hospi) as Ocupadas,Unidad as CriticoO, Hospi as NoCriticoO,  "
            + "  "
            + "                  (Critico-Unidad-MantCri)+(NCritico-Hospi-MantNcri)as Disponible,  "
            + "  "
            + "                  (Critico-Unidad-MantCri) as Critico, (NCritico-Hospi-MantNcri)as NoCritico , MantTot, MantCri, MantNcri, HPendientes, SProbables, CxSProgram, EgrHospi,(CxProg+Partos)as CxProgramada ,  "
            + "  "
            + "                  (Cra15+Partos)as Cra15, Cra16, CDiag, CxAmb, (CxHosp-Cesareas) as CxHosp,(Partos+Cesareas) as Par_Ces,Partos,Cesareas, UrgT, UrgA, UrgP, UrgO,  "
            + "  "
            + "                                                 IUrg, DUrCxMa, DUrgMed, Mes, Dia, FacNeta, FecInfo,FechaRegistro,LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1, YEAR(fecinfo) as Año  "
            + "  "
            + "            FROM         InformeDiarioSahiCol"
            + "  "
            + "            where MONTH(FechaRegistro)= MONTH(GETDATE()) and YEAR(FechaRegistro) = YEAR(GETDATE())  ";

    public static String SQL_PRIMER_DIA = "            SELECT     TCamas, (Unidad+Hospi) as Ocupadas,Unidad as CriticoO, Hospi as NoCriticoO,              "
            + "                                   (Critico-Unidad-MantCri)+(NCritico-Hospi-MantNcri)as Disponible,              "
            + "                                   (Critico-Unidad-MantCri) as Critico, (NCritico-Hospi-MantNcri)as NoCritico , MantTot, MantCri, MantNcri, HPendientes, SProbables, CxSProgram,EgrHospi, (CxProg+Partos)as CxProgramada ,              "
            + "                                    (Cra15+Partos)as Cra15, Cra16, CDiag, CxAmb, (CxHosp-Cesareas) as CxHosp,(Partos+Cesareas) as Par_Ces,Partos,Cesareas, UrgT, UrgA, UrgP, UrgO,              "
            + "                                                               IUrg, DUrCxMa, DUrgMed, Mes, Dia, FacNeta, FecInfo,FechaRegistro,LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1, YEAR(fecinfo) as Año              "
            + "                       FROM         InformeDiario  "
            + "            "
            + "                      where MONTH(FechaRegistro)= MONTH((GETDATE())-1) and YEAR(FechaRegistro) = YEAR((GETDATE())-1) ";

    public static String SQL_PRIMER_DIA_COLINA = "            SELECT     TCamas, (Unidad+Hospi) as Ocupadas,Unidad as CriticoO, Hospi as NoCriticoO,              "
            + "                                   (Critico-Unidad-MantCri)+(NCritico-Hospi-MantNcri)as Disponible,              "
            + "                                   (Critico-Unidad-MantCri) as Critico, (NCritico-Hospi-MantNcri)as NoCritico , MantTot, MantCri, MantNcri, HPendientes, SProbables, CxSProgram,EgrHospi, (CxProg+Partos)as CxProgramada ,              "
            + "                                    (Cra15+Partos)as Cra15, Cra16, CDiag, CxAmb, (CxHosp-Cesareas) as CxHosp,(Partos+Cesareas) as Par_Ces,Partos,Cesareas, UrgT, UrgA, UrgP, UrgO,              "
            + "                                                               IUrg, DUrCxMa, DUrgMed, Mes, Dia, FacNeta, FecInfo,FechaRegistro,LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1, YEAR(fecinfo) as Año              "
            + "                       FROM         InformeDiarioSahiCol"
            + "            "
            + "                      where MONTH(FechaRegistro)= MONTH((GETDATE())-1) and YEAR(FechaRegistro) = YEAR((GETDATE())-1) ";

    public String getSql(String mes) {
        String sql = "IF((DAY(GETDATE()) )= 01)  "
                + "  "
                + "      BEGIN  "
                + "  "
                + "            SELECT     TCamas, (Unidad+Hospi) as Ocupadas,Unidad as CriticoO, Hospi as NoCriticoO,  "
                + "  "
                + "                        (Critico-Unidad-MantCri)+(NCritico-Hospi-MantNcri)as Disponible,  "
                + "  "
                + "                        (Critico-Unidad-MantCri) as Critico, (NCritico-Hospi-MantNcri)as NoCritico , MantTot, MantCri, MantNcri, HPendientes, SProbables, CxSProgram, (CxProg+Partos)as CxProgramada ,  "
                + "  "
                + "                        (Cra15+Partos)as Cra15, Cra16, CDiag, CxAmb, (CxHosp-Cesareas) as CxHosp,(Partos+Cesareas) as Par_Ces,Partos,Cesareas, UrgT, UrgA, UrgP, UrgO,  "
                + "  "
                + "                                                       IUrg, DUrCxMa, DUrgMed, Mes, Dia, FacNeta, FecInfo,FechaRegistro,LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1, YEAR(fecinfo) as Año  "
                + "  "
                + "            FROM         InformeDiario  "
                + "  "
                + "            where MONTH(FechaRegistro)= MONTH(GETDATE())-1 and YEAR(FechaRegistro) = YEAR(GETDATE())  "
                + "  "
                + "            union all  "
                + "  "
                + "            SELECT     TCamas, (Unidad+Hospi) as Ocupadas,Unidad as CriticoO, Hospi as NoCriticoO,  "
                + "  "
                + "                        (Critico-Unidad-MantCri)+(NCritico-Hospi-MantNcri)as Disponible,  "
                + "  "
                + "                        (Critico-Unidad-MantCri) as Critico, (NCritico-Hospi-MantNcri)as NoCritico , MantTot, MantCri, MantNcri, HPendientes, SProbables, CxSProgram, (CxProg+Partos)as CxProgramada ,  "
                + "  "
                + "                        (Cra15+Partos)as Cra15, Cra16, CDiag, CxAmb, (CxHosp-Cesareas) as CxHosp,(Partos+Cesareas) as Par_Ces,Partos,Cesareas, UrgT, UrgA, UrgP, UrgO,  "
                + "  "
                + "                                                       IUrg, DUrCxMa, DUrgMed, Mes, Dia, FacNeta, FecInfo,FechaRegistro,LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1, YEAR(fecinfo) as Año  "
                + "  "
                + "            FROM         InformeDiario  "
                + "  "
                + "            where MONTH(FechaRegistro)= MONTH(GETDATE()) and YEAR(FechaRegistro) = YEAR(GETDATE())  "
                + "  "
                + "            order by mes  "
                + "  "
                + "      END  "
                + "  "
                + "ELSE  "
                + "  "
                + "      BEGIN  "
                + "  "
                + "  "
                + "      END  ";
        return sql;
    }

    public String getSqlColina(String mes) {
        String sql = "IF((DAY(GETDATE()) )= 01)  "
                + "  "
                + "      BEGIN  "
                + "  "
                + "            SELECT     TCamas, (Unidad+Hospi) as Ocupadas,Unidad as CriticoO, Hospi as NoCriticoO,  "
                + "  "
                + "                        (Critico-Unidad-MantCri)+(NCritico-Hospi-MantNcri)as Disponible,  "
                + "  "
                + "                        (Critico-Unidad-MantCri) as Critico, (NCritico-Hospi-MantNcri)as NoCritico , MantTot, MantCri, MantNcri, HPendientes, SProbables, CxSProgram, (CxProg+Partos)as CxProgramada ,  "
                + "  "
                + "                        (Cra15+Partos)as Cra15, Cra16, CDiag, CxAmb, (CxHosp-Cesareas) as CxHosp,(Partos+Cesareas) as Par_Ces,Partos,Cesareas, UrgT, UrgA, UrgP, UrgO,  "
                + "  "
                + "                                                       IUrg, DUrCxMa, DUrgMed, Mes, Dia, FacNeta, FecInfo,FechaRegistro,LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1, YEAR(fecinfo) as Año  "
                + "  "
                + "            FROM         InformeDiarioSahiCol"
                + "  "
                + "            where MONTH(FechaRegistro)= MONTH(GETDATE())-1 and YEAR(FechaRegistro) = YEAR(GETDATE())  "
                + "  "
                + "            union all  "
                + "  "
                + "            SELECT     TCamas, (Unidad+Hospi) as Ocupadas,Unidad as CriticoO, Hospi as NoCriticoO,  "
                + "  "
                + "                        (Critico-Unidad-MantCri)+(NCritico-Hospi-MantNcri)as Disponible,  "
                + "  "
                + "                        (Critico-Unidad-MantCri) as Critico, (NCritico-Hospi-MantNcri)as NoCritico , MantTot, MantCri, MantNcri, HPendientes, SProbables, CxSProgram, (CxProg+Partos)as CxProgramada ,  "
                + "  "
                + "                        (Cra15+Partos)as Cra15, Cra16, CDiag, CxAmb, (CxHosp-Cesareas) as CxHosp,(Partos+Cesareas) as Par_Ces,Partos,Cesareas, UrgT, UrgA, UrgP, UrgO,  "
                + "  "
                + "                                                       IUrg, DUrCxMa, DUrgMed, Mes, Dia, FacNeta, FecInfo,FechaRegistro,LTRIM(RTRIM(SUBSTRING(Mes, 3,10 )))AS Mes1, YEAR(fecinfo) as Año  "
                + "  "
                + "            FROM         InformeDiarioSahiCol"
                + "  "
                + "            where MONTH(FechaRegistro)= MONTH(GETDATE()) and YEAR(FechaRegistro) = YEAR(GETDATE())  "
                + "  "
                + "            order by mes  "
                + "  "
                + "      END  "
                + "  "
                + "ELSE  "
                + "  "
                + "      BEGIN  "
                + "  "
                + "  "
                + "      END  ";
        return sql;
    }

    public String obtenerTabla(String sql, String strMes, boolean noFacturado, boolean Numeros) {

        float contador = 0;
        float Dia = 0;
        float hora = 0;
        float porcent = 0;
        float TCamas = 0;
        float Ocupadas = 0;
        float CriticoO = 0;
        float NoCriticoO = 0;
        float Disponible = 0;
        float Critico = 0;
        float NoCritico = 0;
        float MantTot = 0;
        float MantCri = 0;
        float MantNcri = 0;
        float CxProgramada = 0;
        float Cra15 = 0;
        float Cra16 = 0;
        float CDiag = 0;
        float CxAmb = 0;
        float CxHosp = 0;
        float HPendientes = 0;
        float SProbables = 0;
        float CxSProgram = 0;
        float UrgT = 0;
        float UrgA = 0;
        float UrgP = 0;
        float UrgO = 0;
        float IUrg = 0;
        float DUrCxMa = 0;
        float DUrgMed = 0;
        float FacNeta = 0;
        float EgrHospi = 0;
        float sumaNofacturadoHab = 0;
        float sumaNofacturadoInhab = 0;
        Float porcentaje = 0F;
        String par = "style='background-color: #CADBE7; transition: all .125s ease-in-out;'";
        String resultado = " <style>"
                + "*{"
                + "font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;font-size: 1em;"
                + "}"
                + "td{color: #333;}"
                + "th"
                + "{"
                + "    box-sizing: border-box;"
                + "    text-align: center;"
                + "}"
                + "tbody tr:nth-child(2n-1) {"
                + "background-color: #CADBE7  !important;"
                + "transition: all .125s ease-in-out;"
                + "}"
                + "</style>"
                + "<div    style=\"font-size: 1.1em;\">"
                + "                    <p  style=\"font-size: 1.1em;color: #7c8d87;\">" + "Reporte mes de " + strMes + "</p>"
                + "                     </div>"
                + "<table  id = \"table\" class=\"sticky-enabled\" style=\"font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;color: #FFFFFF;font-size: 0.9em;border-collapse: separate;border-spacing: 2px;font-size: 12px;\">"
                + "    <thead>"
                + "<tr style=\"color: #FFFFFF;font-size: 0.9em;\"> "
                + "<th style=\"background-color: rgb(40,98,161);height: 41px;\">D&iacute;a</th>"
                + "    <th style=\"background-color: #ebebeb;color:#2862a1\">Ocupaci&oacute;n</th>"
                + "    <th style=\"background-color: rgb(40,98,161);\">Total<br/> Camas</th>"
                + "    <th style=\"min-width: 82px;background-color: #ebebeb;color:#2862a1\">Ocupadas</th>"
                + "    <th style=\"min-width: 48px;background-color: rgb(40,98,161);\">      "
                + "Disponibles     </th>  "
                + "    <th style=\"min-width: 67px;background-color: #9293A3;text-align: center;\">"
                + "Mant."
                + "    </th>"
                + "    <th style=\"min-width: 48px;background-color: rgb(40,98,161);\">"
                + "Pendientes <br/>Hospitalizaci&oacute;n"
                + "    </th>"
                + "    <th style=\"background-color: #9293A3;text-align: center;\">Salidas<br/> probables</th>  "
                + "    <th style=\"background-color: #9293A3;text-align: center;\">Egresos<br/> Hospi</th>  "
                + "    <th style=\"min-width: 48px;background-color: rgb(40,98,161);text-align: center;\">       "
                + "      Cx Seg&uacute;n "
                + "      <br/>"
                + "Progrm"
                + ""
                + "    </th>"
                + "    <th style=\"min-width: 48px;background-color: #9293A3;text-align: center;\">"
                + "       "
                + " Cirugias <br/>Realizadas."
                + "</th>"
                + "    <th style=\"min-width: 48px;background-color: rgb(40,98,161);text-align: center;\" >"
                + "Urgencias"
                + "       "
                + "    </th>"
                + "    <th style=\"min-width: 48px;background-color: #9293A3;\">"
                + "       Ingreso"
                + "    </th>";
        if (noFacturado) {
            resultado = resultado + "<th style=\"min-width: 48px;background-color: rgb(40,98,161);\">"
                    + "Por facturar pac. activos</th>"
                    + "    <th style=\"min-width: 48px;background-color: #9293A3;\">"
                    + "       Por facturar pac. inactivos"
                    + "    </th>";
        }
        if (Numeros) {
            resultado = resultado + "<th style=\"min-width: 48px;background-color: rgb(40,98,161);\">"
                    + "Facturaci&oacute;n Neta</th>";
        }
        resultado = resultado + "</tr>" + "    </thead>"
                + "    <tbody>";

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        resultado = resultado + "";
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(0);
        DateFormat df = new SimpleDateFormat("yyyyMMdd"); //2017-01-19
        try {

            con = this.conn_country();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                i++;
                porcentaje = 0F;
                Date fecha = rs.getDate("FecInfo");
                if (rs.getFloat("TCamas") == 0) {
                    HPendientes += rs.getFloat("HPendientes");
                    SProbables += rs.getFloat("SProbables");
                    CxSProgram += rs.getFloat("CxSProgram");
                }
                if (rs.getFloat("TCamas") > 0) {

                    contador++;

                    TCamas += rs.getFloat("TCamas");
                    Ocupadas += rs.getFloat("Ocupadas");
                    CriticoO += rs.getFloat("CriticoO");
                    NoCriticoO += rs.getFloat("NoCriticoO");
                    Disponible += rs.getFloat("Disponible");
                    Critico += rs.getFloat("Critico");
                    NoCritico += rs.getFloat("NoCritico");
                    MantTot += rs.getFloat("MantTot");
                    MantCri += rs.getFloat("MantCri");
                    MantNcri += rs.getFloat("MantNcri");
                    CxProgramada += rs.getFloat("CxProgramada");
                    Cra15 += rs.getFloat("Cra15");
                    Cra16 += rs.getFloat("Cra16");
                    CDiag += rs.getFloat("CDiag");
                    CxAmb += rs.getFloat("CxAmb");
                    CxHosp += rs.getFloat("CxHosp");
                    HPendientes += rs.getFloat("HPendientes");
                    SProbables += rs.getFloat("SProbables");
                    CxSProgram += rs.getFloat("CxSProgram");
                    UrgT += rs.getFloat("UrgT");
                    UrgA += rs.getFloat("UrgA");
                    UrgP += rs.getFloat("UrgP");
                    UrgO += rs.getFloat("UrgO");
                    IUrg += rs.getFloat("IUrg");
                    DUrCxMa += rs.getFloat("DUrCxMa");
                    DUrgMed += rs.getFloat("DUrgMed");
                    FacNeta += rs.getFloat("FacNeta");
                    EgrHospi += rs.getFloat("EgrHospi");

                    float c = rs.getFloat("CriticoO");
                    float nc = rs.getFloat("NoCriticoO");
                    float tc = rs.getFloat("TCamas");

                    porcentaje = ((c + nc) / tc * 100);
                    float ppp = Math.round(porcentaje);
                    porcentaje = ppp;
                    //  System.err.println(porcentaje);
                    porcent += porcentaje;

                }

                resultado = resultado + "<tr class='grid' " + (i % 2 == 0 ? par : "") + " >";

                resultado = resultado + "<td style='text-align:center;'> ";
                resultado = resultado + rs.getInt("Dia");
                resultado = resultado + "</td>";

                resultado = resultado + "<td>";

                resultado = resultado + (porcentaje == 0 ? '-' : porcentaje.intValue() + "%");
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("TCamas") == 0 ? '-' : nf.format(rs.getInt("TCamas")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("Ocupadas") == 0 ? '-' : nf.format(rs.getInt("Ocupadas")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("Disponible") == 0 ? '-' : nf.format(rs.getInt("Disponible")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("MantTot") == 0 && rs.getInt("TCamas") == 0 ? '-' : nf.format(rs.getInt("MantTot")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("HPendientes") == 0 ? '-' : nf.format(rs.getInt("HPendientes")));
                resultado = resultado + "</td>";
                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("SProbables") == 0 ? '-' : nf.format(rs.getInt("SProbables")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("EgrHospi") == 0 ? '-' : nf.format(rs.getInt("EgrHospi")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("CxSProgram") == 0 ? '-' : nf.format(rs.getInt("CxSProgram")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("CxProgramada") == 0 ? '-' : nf.format(rs.getInt("CxProgramada")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("UrgT") == 0 ? '-' : nf.format(rs.getInt("UrgT")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("IUrg") == 0 ? '-' : nf.format(rs.getInt("IUrg")));
                resultado = resultado + "</td>";
                if (noFacturado) {
                    Double[] datos = obtenerDatosCountryMes(df.format(fecha));
                    sumaNofacturadoHab = datos[0].floatValue();
                    sumaNofacturadoInhab = datos[1].floatValue();
                    resultado = resultado + "<td>";
                    resultado = resultado + (datos[0] == 0D ? "-" : "$" + nf.format(datos[0]));
                    resultado = resultado + "</td>";

                    resultado = resultado + "<td>";
                    resultado = resultado + (datos[1] == 0D ? "-" : "$" + nf.format(datos[1]));
                    resultado = resultado + "</td>";
                }
                if (Numeros) {
                    resultado = resultado + "<td>";
                    resultado = resultado + (rs.getLong("FacNeta") == 0 ? "-" : "$" + nf.format(rs.getLong("FacNeta")));
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
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        resultado = resultado + "</tbody>";
        resultado = resultado + "  <tfoot><tr style=\"color: #FFFFFF;font-size: 0.9em;\">";

        resultado = resultado + "<td style=\"background-color: #CADBE7;\"> </td>";
        float valorls;
        if (contador == 0) {
            valorls = 0;
        } else {
            valorls = (porcent / contador);
        }
        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) Math.round(valorls)) + "%</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) TCamas) + "</td>";
        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) Ocupadas) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) Disponible) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) MantTot) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) HPendientes) + "</td>";
        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) SProbables) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) EgrHospi) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) CxSProgram) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) CxProgramada) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) UrgT) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) IUrg) + "</td>";

        if (noFacturado) {
            resultado = resultado + "<td style=\"color: #FFFFFF;background-color:#FF2020\">" + formatter.format((long) sumaNofacturadoHab) + "</td>";
            resultado = resultado + "<td style=\"color: #FFFFFF;background-color:#FF2020\">" + formatter.format((long) sumaNofacturadoInhab) + "</td> ";
        }
        if (Numeros) {
            resultado = resultado + "<td style=\"color: #FFFFFF;background-color:#FF2020\">" + formatter.format((long) FacNeta) + "</td></tr>  </tfoot>";
        }
        resultado = resultado + "</table>";

        return resultado;
    }

    public String obtenerDatosMes() {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        try {
            String sql = "SELECT  LTRIM(RTRIM(SUBSTRING(Mes, 1,2 )))AS Mes1,Mes,FechaRegistro FROM InformeDiario  order by (FechaRegistro)  desc ";
            con = this.conn_country();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next() && mes == null) {
                mes = rs.getString("Mes");

            }

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
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
        return mes;

    }

    public String obtenerDatosMesColina() {

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        try {
            String sql = "SELECT  LTRIM(RTRIM(SUBSTRING(Mes, 1,2 )))AS Mes1,Mes,FechaRegistro FROM InformeDiarioSahiCol  order by (FechaRegistro)  desc ";
            con = this.conn_colina();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next() && mes == null) {
                mes = rs.getString("Mes");

            }

            // Iterate through the data in the result set and display it.
        } // Handle any errors that may have occurred.
        catch (Exception e) {
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
        return mes;

    }

    public String obtenerTablaColina(String sql, String strMes, boolean noFacturado, boolean Numeros) {

        float contador = 0;
        float Dia = 0;
        float hora = 0;
        float porcent = 0;
        float TCamas = 0;
        float Ocupadas = 0;
        float CriticoO = 0;
        float NoCriticoO = 0;
        float Disponible = 0;
        float Critico = 0;
        float NoCritico = 0;
        float MantTot = 0;
        float MantCri = 0;
        float MantNcri = 0;
        float CxProgramada = 0;
        float Cra15 = 0;
        float Cra16 = 0;
        float CDiag = 0;
        float CxAmb = 0;
        float CxHosp = 0;
        float HPendientes = 0;
        float SProbables = 0;
        float CxSProgram = 0;
        float UrgT = 0;
        float UrgA = 0;
        float UrgP = 0;
        float UrgO = 0;
        float IUrg = 0;
        float DUrCxMa = 0;
        float DUrgMed = 0;
        float FacNeta = 0;
        float EgrHospi = 0;
        float sumaNofacturadoHab = 0;
        float sumaNofacturadoInhab = 0;
        Float porcentaje = 0F;
        String par = "style='background-color: #CADBE7; transition: all .125s ease-in-out;'";
        String resultado = " <style>"
                + "*{"
                + "font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;font-size: 1em;"
                + "}"
                + "td{color: #333;}"
                + "th"
                + "{"
                + "    box-sizing: border-box;"
                + "    text-align: center;"
                + "}"
                + "tbody tr:nth-child(2n-1) {"
                + "background-color: #CADBE7  !important;"
                + "transition: all .125s ease-in-out;"
                + "}"
                + "</style>"
                + "<div    style=\"font-size: 1.1em;\">"
                + "                    <p  style=\"font-size: 1.1em;color: #7c8d87;\">" + "Reporte mes de " + strMes + "</p>"
                + "                     </div>"
                + "<table  id = \"table\" class=\"sticky-enabled\" style=\"font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;color: #FFFFFF;font-size: 0.9em;border-collapse: separate;border-spacing: 2px;font-size: 12px;\">"
                + "    <thead>"
                + "<tr style=\"color: #FFFFFF;font-size: 0.9em;\"> "
                + "<th style=\"background-color: rgb(40,98,161);height: 41px;\">D&iacute;a</th>"
                + "    <th style=\"background-color: #ebebeb;color:#2862a1\">Ocupaci&oacute;n</th>"
                + "    <th style=\"background-color: rgb(40,98,161);\">Total<br/> Camas</th>"
                + "    <th style=\"min-width: 82px;background-color: #ebebeb;color:#2862a1\">Ocupadas</th>"
                + "    <th style=\"min-width: 48px;background-color: rgb(40,98,161);\">      "
                + "Disponibles     </th>  "
                + "    <th style=\"min-width: 67px;background-color: #9293A3;text-align: center;\">"
                + "Mant."
                + "    </th>"
                + "    <th style=\"min-width: 48px;background-color: rgb(40,98,161);\">"
                + "Pendientes <br/>Hospitalizaci&oacute;n"
                + "    </th>"
                + "    <th style=\"background-color: #9293A3;text-align: center;\">Salidas<br/> probables</th>  "
                + "    <th style=\"background-color: #9293A3;text-align: center;\">Egresos<br/> Hospi</th>  "
                + "    <th style=\"min-width: 48px;background-color: rgb(40,98,161);text-align: center;\">       "
                + "      Cx Seg&uacute;n "
                + "      <br/>"
                + "Progrm"
                + ""
                + "    </th>"
                + "    <th style=\"min-width: 48px;background-color: #9293A3;text-align: center;\">"
                + "       "
                + " Cirugias <br/>Realizadas."
                + "</th>"
                + "    <th style=\"min-width: 48px;background-color: rgb(40,98,161);text-align: center;\" >"
                + "Urgencias"
                + "       "
                + "    </th>"
                + "    <th style=\"min-width: 48px;background-color: #9293A3;\">"
                + "       Ingreso"
                + "    </th>";
        if (noFacturado) {
            resultado = resultado + "<th style=\"min-width: 48px;background-color: rgb(40,98,161);\">"
                    + "Por facturar pac. activos</th>"
                    + "    <th style=\"min-width: 48px;background-color: #9293A3;\">"
                    + "       Por facturar pac. inactivos"
                    + "    </th>";
        }
        if (Numeros) {
            resultado = resultado + "<th style=\"min-width: 48px;background-color: rgb(40,98,161);\">"
                    + "Facturaci&oacute;n Neta</th>";
        }
        resultado = resultado + "</tr>" + "    </thead>"
                + "    <tbody>";

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        Statement stmt = null;
        String mes = null;
        resultado = resultado + "";
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(0);
        DateFormat df = new SimpleDateFormat("yyyyMMdd"); //2017-01-19
        try {

            con = this.conn_colina();
            // Execute a stored procedure that returns some data.
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                i++;
                porcentaje = 0F;
                Date fecha = rs.getDate("FecInfo");
                if (rs.getFloat("TCamas") == 0) {
                    HPendientes += rs.getFloat("HPendientes");
                    SProbables += rs.getFloat("SProbables");
                    CxSProgram += rs.getFloat("CxSProgram");
                }
                if (rs.getFloat("TCamas") > 0) {

                    contador++;

                    TCamas += rs.getFloat("TCamas");
                    Ocupadas += rs.getFloat("Ocupadas");
                    CriticoO += rs.getFloat("CriticoO");
                    NoCriticoO += rs.getFloat("NoCriticoO");
                    Disponible += rs.getFloat("Disponible");
                    Critico += rs.getFloat("Critico");
                    NoCritico += rs.getFloat("NoCritico");
                    MantTot += rs.getFloat("MantTot");
                    MantCri += rs.getFloat("MantCri");
                    MantNcri += rs.getFloat("MantNcri");
                    CxProgramada += rs.getFloat("CxProgramada");
                    Cra15 += rs.getFloat("Cra15");
                    Cra16 += rs.getFloat("Cra16");
                    CDiag += rs.getFloat("CDiag");
                    CxAmb += rs.getFloat("CxAmb");
                    CxHosp += rs.getFloat("CxHosp");
                    HPendientes += rs.getFloat("HPendientes");
                    SProbables += rs.getFloat("SProbables");
                    CxSProgram += rs.getFloat("CxSProgram");
                    UrgT += rs.getFloat("UrgT");
                    UrgA += rs.getFloat("UrgA");
                    UrgP += rs.getFloat("UrgP");
                    UrgO += rs.getFloat("UrgO");
                    IUrg += rs.getFloat("IUrg");
                    DUrCxMa += rs.getFloat("DUrCxMa");
                    DUrgMed += rs.getFloat("DUrgMed");
                    FacNeta += rs.getFloat("FacNeta");
                    EgrHospi += rs.getFloat("EgrHospi");

                    float c = rs.getFloat("CriticoO");
                    float nc = rs.getFloat("NoCriticoO");
                    float tc = rs.getFloat("TCamas");

                    porcentaje = ((c + nc) / tc * 100);
                    float ppp = Math.round(porcentaje);
                    porcentaje = ppp;
                    //  System.err.println(porcentaje);
                    porcent += porcentaje;

                }

                resultado = resultado + "<tr class='grid' " + (i % 2 == 0 ? par : "") + " >";

                resultado = resultado + "<td style='text-align:center;'> ";
                resultado = resultado + rs.getInt("Dia");
                resultado = resultado + "</td>";

                resultado = resultado + "<td>";

                resultado = resultado + (porcentaje == 0 ? '-' : porcentaje.intValue() + "%");
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("TCamas") == 0 ? '-' : nf.format(rs.getInt("TCamas")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("Ocupadas") == 0 ? '-' : nf.format(rs.getInt("Ocupadas")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("Disponible") == 0 ? '-' : nf.format(rs.getInt("Disponible")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("MantTot") == 0 && rs.getInt("TCamas") == 0 ? '-' : nf.format(rs.getInt("MantTot")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("HPendientes") == 0 ? '-' : nf.format(rs.getInt("HPendientes")));
                resultado = resultado + "</td>";
                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("SProbables") == 0 ? '-' : nf.format(rs.getInt("SProbables")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("EgrHospi") == 0 ? '-' : nf.format(rs.getInt("EgrHospi")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("CxSProgram") == 0 ? '-' : nf.format(rs.getInt("CxSProgram")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("CxProgramada") == 0 ? '-' : nf.format(rs.getInt("CxProgramada")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("UrgT") == 0 ? '-' : nf.format(rs.getInt("UrgT")));
                resultado = resultado + "</td>";

                resultado = resultado + "<td> ";
                resultado = resultado + (rs.getInt("IUrg") == 0 ? '-' : nf.format(rs.getInt("IUrg")));
                resultado = resultado + "</td>";
                if (noFacturado) {
                    Double[] datos = obtenerDatosColinaMes(df.format(fecha));
                    sumaNofacturadoHab = datos[0].floatValue();
                    sumaNofacturadoInhab = datos[1].floatValue();
                    resultado = resultado + "<td>";
                    resultado = resultado + (datos[0] == 0D ? "-" : "$" + nf.format(datos[0]));
                    resultado = resultado + "</td>";

                    resultado = resultado + "<td>";
                    resultado = resultado + (datos[1] == 0D ? "-" : "$" + nf.format(datos[1]));
                    resultado = resultado + "</td>";
                }
                if (Numeros) {
                    resultado = resultado + "<td>";
                    resultado = resultado + (rs.getLong("FacNeta") == 0 ? "-" : "$" + nf.format(rs.getLong("FacNeta")));
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
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        resultado = resultado + "</tbody>";
        resultado = resultado + "  <tfoot><tr style=\"color: #FFFFFF;font-size: 0.9em;\">";

        resultado = resultado + "<td style=\"background-color: #CADBE7;\"> </td>";
        float valorls;
        if (contador == 0) {
            valorls = 0;
        } else {
            valorls = (porcent / contador);
        }
        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) Math.round(valorls)) + "%</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) TCamas) + "</td>";
        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) Ocupadas) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) Disponible) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) MantTot) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) HPendientes) + "</td>";
        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) SProbables) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) EgrHospi) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) CxSProgram) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) CxProgramada) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: rgb(40,98,161);\">" + nf.format((int) UrgT) + "</td>";

        resultado = resultado + "<td style=\"color: #FFFFFF;background-color: #9293A3;\">" + nf.format((int) IUrg) + "</td>";

        if (noFacturado) {
            resultado = resultado + "<td style=\"color: #FFFFFF;background-color:#FF2020\">" + formatter.format((long) sumaNofacturadoHab) + "</td>";
            resultado = resultado + "<td style=\"color: #FFFFFF;background-color:#FF2020\">" + formatter.format((long) sumaNofacturadoInhab) + "</td> ";
        }
        if (Numeros) {
            resultado = resultado + "<td style=\"color: #FFFFFF;background-color:#FF2020\">" + formatter.format((long) FacNeta) + "</td></tr>  </tfoot>";
        }
        resultado = resultado + "</table>";

        return resultado;
    }

}
