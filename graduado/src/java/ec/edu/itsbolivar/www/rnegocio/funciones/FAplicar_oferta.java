package ec.edu.itsbolivar.www.rnegocio.funciones;

import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Aplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import java.util.ArrayList;

public class FAplicar_oferta {

    public static boolean insertar(Aplicar_oferta obj) throws Exception {
        boolean band = false;
        String sql = "insert into aplicar_oferta values (?,?,?,?,?)";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getGraduado().getCodigo()));

        lstpar.add(new Parametro(2, obj.getOferta_laboral().getCodigo()));

//campos sin referencias
        lstpar.add(new Parametro(3, obj.getFecha_aplica()));
        lstpar.add(new Parametro(4, obj.getContrato()));
        lstpar.add(new Parametro(5, obj.getFecha_inicio()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean modificar(Aplicar_oferta obj) throws Exception {
        boolean band = false;
        String sql = "update aplicar_oferta set cod_graduado=?,cod_ofertalaboral=?,fecha_aplica=?,contrato=?,fecha_inicio=? where cod_graduado=? and cod_ofertalaboral=?  ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getGraduado().getCodigo()));

        lstpar.add(new Parametro(6, obj.getGraduado().getCodigo()));

        lstpar.add(new Parametro(2, obj.getOferta_laboral().getCodigo()));

        lstpar.add(new Parametro(7, obj.getOferta_laboral().getCodigo()));

//campos sin referencias
        lstpar.add(new Parametro(3, obj.getFecha_aplica()));
        lstpar.add(new Parametro(4, obj.getContrato()));
        lstpar.add(new Parametro(5, obj.getFecha_inicio()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }
    
     public static boolean actualizarRechazadas(Aplicar_oferta ofertaAceptada) throws Exception {
        boolean band = false;
        String sql = "update aplicar_oferta set contrato='no' where cod_graduado <> ? and cod_ofertalaboral=?  ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();


        lstpar.add(new Parametro(1, ofertaAceptada.getGraduado().getCodigo()));
        lstpar.add(new Parametro(2, ofertaAceptada.getOferta_laboral().getCodigo()));
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static boolean eliminar(Aplicar_oferta obj) throws Exception {
        boolean band = false;
        String sql = "delete from aplicar_oferta where cod_graduado=? and cod_ofertalaboral=? ";
        ArrayList<Parametro> lstpar = new ArrayList<Parametro>();

//campos con referencias
        lstpar.add(new Parametro(1, obj.getGraduado().getCodigo()));

        lstpar.add(new Parametro(2, obj.getOferta_laboral().getCodigo()));

//campos sin referencias
        try {
            band = AccesoDatos.ejecutaComando1(sql, lstpar);
        } catch (Exception ex) {
            throw ex;
        }
        return band;
    }

    public static Aplicar_oferta obtener(int pcod_graduado, int pcod_ofertalaboral) throws Exception {
        Aplicar_oferta miAplicar_oferta = null;
        try {
            String sql = "select cod_graduado,cod_ofertalaboral,fecha_aplica,contrato,fecha_inicio from aplicar_oferta where   cod_graduado=? and cod_ofertalaboral=? ";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, pcod_graduado));
            lstpar.add(new Parametro(2, pcod_ofertalaboral));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            ArrayList<Aplicar_oferta> lst = llenarAplicar_ofertas(rs);
            for (Aplicar_oferta c : lst) {
                miAplicar_oferta = c;
            }

        } catch (Exception ex) {
            throw ex;
        }
        return miAplicar_oferta;
    }

    public static ArrayList<Aplicar_oferta> obtener() throws Exception {
        ArrayList<Aplicar_oferta> lst = new ArrayList<>();
        try {
            String sql = "select cod_graduado,cod_ofertalaboral,fecha_aplica,contrato,fecha_inicio from aplicar_oferta; ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarAplicar_ofertas(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    public static ArrayList<Aplicar_oferta> obtener(Graduado item) throws Exception {
        ArrayList<Aplicar_oferta> lst = new ArrayList<>();
        try {
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, item.getCodigo()));
            String sql = "select cod_graduado,cod_ofertalaboral,fecha_aplica,contrato,fecha_inicio from aplicar_oferta WHERE cod_graduado=? ORDER BY cod_ofertalaboral desc; ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            lst = llenarAplicar_ofertas(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }
    public static ArrayList<Aplicar_oferta> obtener(Oferta_laboral item) throws Exception {
        ArrayList<Aplicar_oferta> lst = new ArrayList<>();
        try {
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, item.getCodigo()));
            String sql = "select cod_graduado,cod_ofertalaboral,fecha_aplica,contrato,fecha_inicio from aplicar_oferta WHERE cod_ofertalaboral=? ORDER BY cod_ofertalaboral desc; ";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            lst = llenarAplicar_ofertas(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

    private static ArrayList<Aplicar_oferta> llenarAplicar_ofertas(ConjuntoResultado cr) throws Exception {
        ArrayList<Aplicar_oferta> lst = new ArrayList<Aplicar_oferta>();
        Aplicar_oferta obj = null;
        try {
            while (cr.next()) {
                obj = new Aplicar_oferta();

//campos con referencias
                obj.setGraduado(FGraduado.obtener(cr.getInt(1)));

                obj.setOferta_laboral(FOferta_laboral.obtener(cr.getInt(2)));

//campos sin referencias
                obj.setFecha_aplica((cr.getObject(3) != null) ? cr.getLong(3) : null);
                obj.setContrato(cr.getString(4));
                obj.setFecha_inicio((cr.getObject(5) != null) ? cr.getLong(5) : null);
                lst.add(obj);

            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }

}
