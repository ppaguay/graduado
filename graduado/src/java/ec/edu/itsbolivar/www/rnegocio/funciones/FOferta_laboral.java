package ec.edu.itsbolivar.www.rnegocio.funciones;

import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import java.util.ArrayList;

public class FOferta_laboral {

    public static boolean insertar(Oferta_laboral obj) throws Exception {
        boolean band = false;
        String sql = "insert into oferta_laboral( `cod_empresa`, `cod_tipocargo`, `cod_tiposueldo`, `caract_cargo`, `experiencia`) values (?,?,?,?,?)";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getEmpresa().getCodigo()));

        lstpar.add(new Parametro(2, obj.getTipo_cargo().getCodigo()));

        lstpar.add(new Parametro(3, obj.getTipo_sueldo().getCodigo()));

//campos sin referencias
        //lstpar.add(new Parametro(1,obj.getCodigo()));
        lstpar.add(new Parametro(4, obj.getCaract_cargo()));
        lstpar.add(new Parametro(5, obj.getExperiencia()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean modificar(Oferta_laboral obj) throws Exception {
        boolean band = false;
        String sql = "update oferta_laboral set codigo=?,cod_empresa=?,cod_tipocargo=?,cod_tiposueldo=?,caract_cargo=?,experiencia=? where codigo=?  ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(2, obj.getEmpresa().getCodigo()));

        lstpar.add(new Parametro(3, obj.getTipo_cargo().getCodigo()));

        lstpar.add(new Parametro(4, obj.getTipo_sueldo().getCodigo()));

//campos sin referencias
        lstpar.add(new Parametro(1, obj.getCodigo()));
        lstpar.add(new Parametro(7, obj.getCodigo()));
        lstpar.add(new Parametro(5, obj.getCaract_cargo()));
        lstpar.add(new Parametro(6, obj.getExperiencia()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean eliminar(Oferta_laboral obj) throws Exception {
        boolean band = false;
        String sql = "delete from oferta_laboral where codigo=? ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
//campos sin referencias
        lstpar.add(new Parametro(1, obj.getCodigo()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            System.out.println("error al eliminar");
            throw ex;
        }
        return band;
    }

    public static Oferta_laboral obtener(int pcodigo) throws Exception {
        Oferta_laboral miOferta_laboral = null;
        try {
            String sql = "select codigo,cod_empresa,cod_tipocargo,cod_tiposueldo,caract_cargo,experiencia from oferta_laboral where   codigo=? ";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, pcodigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            ArrayList<Oferta_laboral> lst = llenarOferta_laborals(rs);
            for (Oferta_laboral c : lst) {
                miOferta_laboral = c;
            }

        } catch (Exception ex) {
            throw ex;
        }
        return miOferta_laboral;
    }

    public static ArrayList<Oferta_laboral> obtener() throws Exception {
        ArrayList<Oferta_laboral> lst = new ArrayList<>();
        try {
            String sql = "select codigo,cod_empresa,cod_tipocargo,cod_tiposueldo,caract_cargo,experiencia from oferta_laboral; ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarOferta_laborals(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    private static ArrayList<Oferta_laboral> llenarOferta_laborals(ConjuntoResultado cr) throws Exception {
        ArrayList<Oferta_laboral> lst = new ArrayList<Oferta_laboral>();
        Oferta_laboral obj = null;
        try {
            while (cr.next()) {
                obj = new Oferta_laboral();

//campos con referencias
                obj.setEmpresa(FEmpresa.obtener(cr.getInt(2)));

                obj.setTipo_cargo(FTipo_cargo.obtener(cr.getInt(3)));

                obj.setTipo_sueldo(FTipo_sueldo.obtener(cr.getInt(4)));

//campos sin referencias
                obj.setCodigo(cr.getInt(1));
                obj.setCaract_cargo(cr.getString(5));
                obj.setExperiencia(cr.getString(6));
                lst.add(obj);

            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

}
