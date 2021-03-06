package ec.edu.itsbolivar.www.rnegocio.funciones;

import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Capacitacion;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import java.util.ArrayList;

public class FCapacitacion {

    public static boolean insertar(Capacitacion obj) throws Exception {
        boolean band = false;
        String sql = "insert into capacitacion(`cod_tipocapacitacion`, `nombre`, `horas`, `caracteristica`, `fecha`)  values (?,?,?,?,?)";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getTipo_capacitacion().getCodigo()));

//campos sin referencias
        //lstpar.add(new Parametro(1,obj.getCodigo()));
        lstpar.add(new Parametro(2, obj.getNombre()));
        lstpar.add(new Parametro(3, obj.getHoras()));
        lstpar.add(new Parametro(4, obj.getCaracteristica()));
        lstpar.add(new Parametro(5, obj.getFecha()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static Capacitacion insertarReturnId(Capacitacion obj) throws Exception {
        Capacitacion miCapacitacion = null;
        String sql = "insert into capacitacion(`cod_tipocapacitacion`, `nombre`, `horas`, `caracteristica`, `fecha`)  values (?,?,?,?,?)";

        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getTipo_capacitacion().getCodigo()));

//campos sin referencias
        //lstpar.add(new Parametro(1,obj.getCodigo()));
        lstpar.add(new Parametro(2, obj.getNombre()));
        lstpar.add(new Parametro(3, obj.getHoras()));
        lstpar.add(new Parametro(4, obj.getCaracteristica()));
        lstpar.add(new Parametro(5, obj.getFecha()));

        try {
            //AccesoDatos.ejecutaComando1(sql, lstpar);
            int rs = AccesoDatos.ejecutaQueryInsertReturn(sql, lstpar);

            miCapacitacion = new Capacitacion();
            miCapacitacion.setCodigo(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return miCapacitacion;
    }

    public static boolean modificar(Capacitacion obj) throws Exception {
        boolean band = false;
        String sql = "update capacitacion set codigo=?,cod_tipocapacitacion=?,nombre=?,horas=?,caracteristica=?,fecha=? where codigo=?  ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(2, obj.getTipo_capacitacion().getCodigo()));

//campos sin referencias
        lstpar.add(new Parametro(1, obj.getCodigo()));
        lstpar.add(new Parametro(7, obj.getCodigo()));
        lstpar.add(new Parametro(3, obj.getNombre()));
        lstpar.add(new Parametro(4, obj.getHoras()));
        lstpar.add(new Parametro(5, obj.getCaracteristica()));
        lstpar.add(new Parametro(6, obj.getFecha()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean eliminar(Capacitacion obj) throws Exception {
        boolean band = false;
        String sql = "delete from capacitacion where codigo=? ";
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

    public static Capacitacion obtener(int pcodigo) throws Exception {
        Capacitacion miCapacitacion = null;
        try {
            String sql = "select codigo,cod_tipocapacitacion,nombre,horas,caracteristica,fecha from capacitacion where   codigo=? ";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, pcodigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            ArrayList<Capacitacion> lst = llenarCapacitacions(rs);
            for (Capacitacion c : lst) {
                miCapacitacion = c;
            }

        } catch (Exception ex) {
            throw ex;
        }
        return miCapacitacion;
    }

    public static ArrayList<Capacitacion> obtener() throws Exception {
        ArrayList<Capacitacion> lst = new ArrayList<>();
        try {
            String sql = "select codigo,cod_tipocapacitacion,nombre,horas,caracteristica,fecha from capacitacion; ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarCapacitacions(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    public static ArrayList<Capacitacion> obtener(Graduado item) throws Exception {
        ArrayList<Capacitacion> lst = new ArrayList<>();
        try {
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, item.getCodigo()));
            String sql = "select c.codigo,c.cod_tipocapacitacion,c.nombre,c.horas,c.caracteristica,c.fecha from capacitacion as c INNER JOIN cursado as cu on cu.cod_capacitacion=c.codigo INNER join graduado as g on g.codigo=cu.cod_graduado WHERE g.codigo=? ORDER BY c.codigo desc";

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            lst = llenarCapacitacions(rs);
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    private static ArrayList<Capacitacion> llenarCapacitacions(ConjuntoResultado cr) throws Exception {
        ArrayList<Capacitacion> lst = new ArrayList<Capacitacion>();
        Capacitacion obj = null;
        try {
            while (cr.next()) {
                obj = new Capacitacion();

//campos con referencias
                obj.setTipo_capacitacion(FTipo_capacitacion.obtener(cr.getInt(2)));

//campos sin referencias
                obj.setCodigo(cr.getInt(1));
                obj.setNombre(cr.getString(3));
                obj.setHoras(cr.getInt(4));
                obj.setCaracteristica(cr.getString(5));
                obj.setFecha(cr.getLong(6));
                lst.add(obj);

            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    private static ArrayList<Capacitacion> llenarCapacitacionsUno(ConjuntoResultado cr) throws Exception {
        ArrayList<Capacitacion> lst = new ArrayList<Capacitacion>();
        Capacitacion obj = null;
        try {
            while (cr.next()) {
                obj = new Capacitacion();
                obj.setCodigo(cr.getInt(1));
                System.out.println("code:" + obj.getCodigo());
                lst.add(obj);

            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }
}
