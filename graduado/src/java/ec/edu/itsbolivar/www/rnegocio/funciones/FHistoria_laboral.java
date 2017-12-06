package ec.edu.itsbolivar.www.rnegocio.funciones;

import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Historia_laboral;
import java.util.ArrayList;

public class FHistoria_laboral {

    public static boolean insertar(Historia_laboral obj) throws Exception {
        boolean band = false;
        String sql = "insert into historia_laboral( `cod_graduado`, `cod_tipocausasalida`, `cod_tipocargo`, `fechainicio`, `fechafin`, `empresa`)   values (?,?,?,?,?,?)";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getGraduado().getCodigo()));

        lstpar.add(new Parametro(2, obj.getTipo_causa_salida().getCodigo()));

        lstpar.add(new Parametro(3, obj.getTipo_cargo().getCodigo()));

//campos sin referencias
        //lstpar.add(new Parametro(1,obj.getCodigo()));
        lstpar.add(new Parametro(4, obj.getFechainicio()));
        lstpar.add(new Parametro(5, obj.getFechafin()));
        lstpar.add(new Parametro(6, obj.getEmpresa()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean modificar(Historia_laboral obj) throws Exception {
        boolean band = false;
        String sql = "update historia_laboral set codigo=?,cod_graduado=?,cod_tipocausasalida=?,cod_tipocargo=?,fechainicio=?,fechafin=?,empresa=? where codigo=?  ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(2, obj.getGraduado().getCodigo()));

        lstpar.add(new Parametro(3, obj.getTipo_causa_salida().getCodigo()));

        lstpar.add(new Parametro(4, obj.getTipo_cargo().getCodigo()));

//campos sin referencias
        lstpar.add(new Parametro(1, obj.getCodigo()));
        lstpar.add(new Parametro(8, obj.getCodigo()));
        lstpar.add(new Parametro(5, obj.getFechainicio()));
        lstpar.add(new Parametro(6, obj.getFechafin()));
        lstpar.add(new Parametro(7, obj.getEmpresa()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean eliminar(Historia_laboral obj) throws Exception {
        boolean band = false;
        String sql = "delete from historia_laboral where codigo=? ";
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

    public static Historia_laboral obtener(int pcodigo) throws Exception {
        Historia_laboral miHistoria_laboral = null;
        try {
            String sql = "select codigo,cod_graduado,cod_tipocausasalida,cod_tipocargo,fechainicio,fechafin,empresa from historia_laboral where   codigo=? ";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, pcodigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            ArrayList<Historia_laboral> lst = llenarHistoria_laborals(rs);
            for (Historia_laboral c : lst) {
                miHistoria_laboral = c;
            }

        } catch (Exception ex) {
            throw ex;
        }
        return miHistoria_laboral;
    }

    public static ArrayList<Historia_laboral> obtener() throws Exception {
        ArrayList<Historia_laboral> lst = new ArrayList<>();
        try {
            String sql = "select codigo,cod_graduado,cod_tipocausasalida,cod_tipocargo,fechainicio,fechafin,empresa from historia_laboral; ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarHistoria_laborals(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }
    public static ArrayList<Historia_laboral> obtener(Graduado item) throws Exception {
        ArrayList<Historia_laboral> lst = new ArrayList<>();
        try {
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, item.getCodigo()));
           
            String sql = "select codigo,cod_graduado,cod_tipocausasalida,cod_tipocargo,fechainicio,fechafin,empresa from historia_laboral where cod_graduado =? ORDER by codigo desc ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstpar);
            lst = llenarHistoria_laborals(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    private static ArrayList<Historia_laboral> llenarHistoria_laborals(ConjuntoResultado cr) throws Exception {
        ArrayList<Historia_laboral> lst = new ArrayList<Historia_laboral>();
        Historia_laboral obj = null;
        try {
            while (cr.next()) {
                obj = new Historia_laboral();

//campos con referencias
                obj.setGraduado(FGraduado.obtener(cr.getInt(2)));

                obj.setTipo_causa_salida(FTipo_causa_salida.obtener(cr.getInt(3)));

                obj.setTipo_cargo(FTipo_cargo.obtener(cr.getInt(4)));

//campos sin referencias
                obj.setCodigo(cr.getInt(1));
                obj.setFechainicio(cr.getLong(5));
                obj.setFechafin(cr.getLong(6));
                obj.setEmpresa(cr.getString(7));
                lst.add(obj);

            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

}
