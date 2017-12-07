package ec.edu.itsbolivar.www.rnegocio.funciones;

import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Personal;
import java.util.ArrayList;

public class FPersonal {

    public static boolean insertar(Personal obj) throws Exception {
        boolean band = false;
        String sql = "insert into personal(`cod_tipopersonal`, `nombre`, `clave`) values (?,?,?)";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getTipo_personal().getCodigo()));

//campos sin referencias
// lstpar.add(new Parametro(1,obj.getCodigo()));
        lstpar.add(new Parametro(2, obj.getNombre()));
        lstpar.add(new Parametro(3, obj.getClave()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean modificar(Personal obj) throws Exception {
        boolean band = false;
        String sql = "update personal set codigo=?,cod_tipopersonal=?,nombre=?,clave=? where codigo=?  ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(2, obj.getTipo_personal().getCodigo()));

//campos sin referencias
        lstpar.add(new Parametro(1, obj.getCodigo()));
        lstpar.add(new Parametro(5, obj.getCodigo()));
        lstpar.add(new Parametro(3, obj.getNombre()));
        lstpar.add(new Parametro(4, obj.getClave()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean eliminar(Personal obj) throws Exception {
        boolean band = false;
        String sql = "delete from personal where codigo=? ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
//campos sin referencias
        lstpar.add(new Parametro(1, obj.getCodigo()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static Personal obtener(int pcodigo) throws Exception {
        Personal miPersonal = null;
        try {
            String sql = "select codigo,cod_tipopersonal,nombre,clave from personal where   codigo=? ";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, pcodigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            ArrayList<Personal> lst = llenarPersonals(rs);
            for (Personal c : lst) {
                miPersonal = c;
            }

        } catch (Exception ex) {
            throw ex;
        }
        return miPersonal;
    }

    public static ArrayList<Personal> obtener() throws Exception {
        ArrayList<Personal> lst = new ArrayList<>();
        try {
            String sql = "select codigo,cod_tipopersonal,nombre,clave from personal; ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPersonals(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    private static ArrayList<Personal> llenarPersonals(ConjuntoResultado cr) throws Exception {
        ArrayList<Personal> lst = new ArrayList<Personal>();
        Personal obj = null;
        try {
            while (cr.next()) {
                obj = new Personal();

//campos con referencias
                obj.setTipo_personal(FTipo_personal.obtener(cr.getInt(2)));

//campos sin referencias
                obj.setCodigo(cr.getInt(1));
                obj.setNombre(cr.getString(3));
                obj.setClave(cr.getString(4));
                lst.add(obj);

            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

}
