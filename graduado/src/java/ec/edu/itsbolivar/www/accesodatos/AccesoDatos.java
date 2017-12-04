/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.accesodatos;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Dada
 */
public class AccesoDatos {

    public static boolean ejecutaComando1(String comando, ArrayList<Parametro> parametros) throws Exception {
        boolean respuesta = false;
        PreparedStatement ptrs = null;
        Connection con = null;
        Global global = new Global();

        try {

            Class.forName(global.getDRIVER());
            try {
                con = DriverManager.getConnection(global.getURL(), global.getUSER(), global.getPASS());
                ptrs = con.prepareStatement(comando);
                for (Parametro parametro : parametros) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
                }
                int i = ptrs.executeUpdate();//ejectuta la consulta
                if (i > 0) {
                    respuesta = true;//consulta correcta
                }

                ptrs.close();
                ptrs = null;

            } catch (SQLException exConec) {
                throw exConec;
            } finally {
                try {
                    if (con != null) {
                        if (!(con.isClosed())) {
                            con.close();
                        }
                        con = null;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        } catch (ClassNotFoundException exCarga) {
            throw exCarga;
        }

        return respuesta;
    }

    public static boolean ejecutaComando1Tran(String comando, ArrayList<Parametro> parametros) throws Exception {
        boolean respuesta = false;
        PreparedStatement ptrs = null;
        Connection con = null;
        Global global = new Global();

        try {

            Class.forName(global.getDRIVER());
            try {
                con = DriverManager.getConnection(global.getURL(), global.getUSER(), global.getPASS());
                ptrs = con.prepareStatement(comando);
                for (Parametro parametro : parametros) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
                }
                ptrs.executeUpdate();
                respuesta = true;

                ptrs.close();
                ptrs = null;

            } catch (SQLException exConec) {
                throw exConec;
            } finally {
                try {
                    if (con != null) {
                        if (!(con.isClosed())) {
                            con.close();
                        }
                        con = null;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        } catch (ClassNotFoundException exCarga) {
            throw exCarga;
        }

        return respuesta;
    }

    public static boolean ejecutaComando(String comando, ArrayList<Parametro> parametros) throws Exception {

        boolean respuesta = false;
        PreparedStatement ptrs = null;
        Connection con = null;
        Global global = new Global();
        try {
            Class.forName(global.getDRIVER());
            try {
                con = DriverManager.getConnection(global.getURL(), global.getUSER(), global.getPASS());
                ptrs = con.prepareStatement(comando);
                for (Parametro parametro : parametros) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
                }
                ResultSet rst = ptrs.executeQuery();
                if (rst.next()) {
                    String bandera = rst.getString(1);
                    respuesta = bandera.equals("t") ? true : false;
                }
                rst.close();
                ptrs.close();
                rst = null;
                ptrs = null;

            } catch (SQLException exConec) {
                throw exConec;
            } finally {
                try {
                    if (con != null) {
                        if (!(con.isClosed())) {
                            con.close();
                        }
                        con = null;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        } catch (ClassNotFoundException exCarga) {
            throw exCarga;
        }

        return respuesta;
    }
//estos devulven un conjunto de objetos
    public static ConjuntoResultado ejecutaQuery(String query) throws Exception {
        Global global = new Global();
        ResultSet rs = null;

        PreparedStatement pst = null;
        ConjuntoResultado conj = new ConjuntoResultado();
        Connection con = null;
        try {
            Class.forName(global.getDRIVER());
            try {
                con = DriverManager.getConnection(global.getURL(), global.getUSER(), global.getPASS());
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();

                conj.Fill(rs);
                rs.close();
                pst.close();
                rs = null;
                pst = null;

            } catch (SQLException exConec) {
                throw exConec;
            } finally {
                try {
                    if (con != null) {
                        if (!(con.isClosed())) {
                            con.close();
                        }
                        con = null;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        } catch (ClassNotFoundException exCarga) {
            throw exCarga;
        }
        return conj;
    }

    public static ConjuntoResultado ejecutaQuery(String query, ArrayList<Parametro> parametros) throws Exception {

        ResultSet rs = null;
        PreparedStatement ptrs = null;
        ConjuntoResultado conj = new ConjuntoResultado();
        Connection con = null;
        Global global = new Global();
        try {
            Class.forName(global.getDRIVER());
            try {
                String url = global.getURL();
                con = DriverManager.getConnection(url, global.getUSER(), global.getPASS());
                ptrs = con.prepareStatement(query);
                for (Parametro parametro : parametros) {
                    ptrs.setObject(parametro.getPosicion(), parametro.getValor());
                }
                rs = ptrs.executeQuery();
                conj.Fill(rs);
                rs.close();
                ptrs.close();
                rs = null;
                ptrs = null;
            } catch (SQLException exConec) {
                throw exConec;
            } finally {
                try {
                    if (con != null) {
                        if (!(con.isClosed())) {
                            con.close();
                        }
                        con = null;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        } catch (ClassNotFoundException exCarga) {
            throw exCarga;
        }
        return conj;
    }
    /**
     * ***************************START REPORTES****************************
     */
    public Connection con;

    public AccesoDatos() throws Exception {
        try {
            Global global = new Global();
            Class.forName(global.getDRIVER());
            con = DriverManager.getConnection(global.getURL(), global.getUSER(), global.getPASS());

        } catch (ClassNotFoundException e) {
            throw e;
        }
    }

    public Connection getConReportes() {
        return con;
    }
    /**
     * ****************************END REPORTES******************************
     */
}
