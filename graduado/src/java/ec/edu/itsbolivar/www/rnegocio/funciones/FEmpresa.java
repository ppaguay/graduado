package ec.edu.itsbolivar.www.rnegocio.funciones;

import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import java.util.ArrayList;

public class FEmpresa {

    public static boolean insertar(Empresa obj) throws Exception {
        boolean band = false;
        String sql = "insert into empresa (`cod_tipoactividad`, `nombre`, `direccion`, `telefono`, `usuario`, `pertenece`, `clave`) values (?,?,?,?,?,?,?)";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getTipo_actividad().getCodigo()));

//campos sin referencias
// lstpar.add(new Parametro(1,obj.getCodigo()));
        lstpar.add(new Parametro(2, obj.getNombre()));
        lstpar.add(new Parametro(3, obj.getDireccion()));
        lstpar.add(new Parametro(4, obj.getTelefono()));
        lstpar.add(new Parametro(5, obj.getUsuario()));
        lstpar.add(new Parametro(6, obj.getPertenece()));
        lstpar.add(new Parametro(7, obj.getClave()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean modificar(Empresa obj) throws Exception {
        boolean band = false;
        String sql = "update empresa set codigo=?,cod_tipoactividad=?,nombre=?,direccion=?,telefono=?,usuario=?,pertenece=?,clave=? where codigo=?  ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(2, obj.getTipo_actividad().getCodigo()));

//campos sin referencias
        lstpar.add(new Parametro(1, obj.getCodigo()));
        lstpar.add(new Parametro(9, obj.getCodigo()));
        lstpar.add(new Parametro(3, obj.getNombre()));
        lstpar.add(new Parametro(4, obj.getDireccion()));
        lstpar.add(new Parametro(5, obj.getTelefono()));
        lstpar.add(new Parametro(6, obj.getUsuario()));
        lstpar.add(new Parametro(7, obj.getPertenece()));
        lstpar.add(new Parametro(8, obj.getClave()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean eliminar(Empresa obj) throws Exception {
        boolean band = false;
        String sql = "delete from empresa where codigo=? ";
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

    public static Empresa obtener(int pcodigo) throws Exception {
        Empresa miEmpresa = null;
        try {
            String sql = "select codigo,cod_tipoactividad,nombre,direccion,telefono,usuario,pertenece,clave from empresa where   codigo=? ";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, pcodigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            ArrayList<Empresa> lst = llenarEmpresas(rs);
            for (Empresa c : lst) {
                miEmpresa = c;
            }

        } catch (Exception ex) {
            throw ex;
        }
        return miEmpresa;
    }

    public static ArrayList<Empresa> obtener() throws Exception {
        ArrayList<Empresa> lst = new ArrayList<>();
        try {
            String sql = "select codigo,cod_tipoactividad,nombre,direccion,telefono,usuario,pertenece,clave from empresa; ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarEmpresas(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    private static ArrayList<Empresa> llenarEmpresas(ConjuntoResultado cr) throws Exception {
        ArrayList<Empresa> lst = new ArrayList<Empresa>();
        Empresa obj = null;
        try {
            while (cr.next()) {
                obj = new Empresa();

//campos con referencias
                obj.setTipo_actividad(FTipo_actividad.obtener(cr.getInt(2)));

//campos sin referencias
                obj.setCodigo(cr.getInt(1));
                obj.setNombre(cr.getString(3));
                obj.setDireccion(cr.getString(4));
                obj.setTelefono(cr.getString(5));
                obj.setUsuario(cr.getString(6));
                obj.setPertenece(cr.getString(7));
                obj.setClave(cr.getString(8));
                lst.add(obj);

            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

}
