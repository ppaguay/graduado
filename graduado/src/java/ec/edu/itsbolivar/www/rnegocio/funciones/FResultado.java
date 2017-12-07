/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.rnegocio.funciones;

import ec.edu.itsbolivar.www.accesodatos.AccesoDatos;
import ec.edu.itsbolivar.www.accesodatos.ConjuntoResultado;
import ec.edu.itsbolivar.www.accesodatos.Parametro;
import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Resultado;
import java.util.ArrayList;

/**
 *
 * @author XL
 */
public class FResultado {

    public static ArrayList<Resultado> obtener(Empresa item) throws Exception {
        ArrayList<Resultado> miResultado = null;
        try {
            String sql = "select CONCAT( res.tipo, ' ', res.cargo),res.cantidad from (SELECT em.codigo,em.nombre as empresa,ola.caract_cargo as cargo,tc.nombre as tipo,count(*) as cantidad FROM aplicar_oferta as ao inner join graduado as g on g.codigo=ao.cod_graduado inner join oferta_laboral as ola on ola.codigo=ao.cod_ofertalaboral INNER join empresa as em on em.codigo=ola.cod_empresa inner join tipo_cargo as tc on tc.codigo=ola.cod_tipocargo WHERE em.codigo=? group by em.codigo,em.nombre,ola.caract_cargo,tc.nombre)as res ";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, item.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            miResultado = llenarResultados(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return miResultado;
    }

    public static ArrayList<Resultado> obtenerOfertaLaboral() throws Exception {
        ArrayList<Resultado> miResultado = null;
        try {
            String sql = "select res.name,res.cantidad from (SELECT e.codigo,e.nombre as name,count(*) as cantidad from empresa as e INNER join oferta_laboral ola on ola.cod_empresa=e.codigo GROUP by e.codigo,e.nombre) as res";

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            miResultado = llenarResultados(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return miResultado;
    }

    public static ArrayList<Resultado> obtenerOfertaLaboral(Graduado item) throws Exception {
        ArrayList<Resultado> miResultado = null;
        try {
            String sql = "select res.name,res.cantidad from (SELECT e.codigo,e.nombre as name,count(*) as cantidad from empresa as e INNER join oferta_laboral ola on ola.cod_empresa=e.codigo  INNER join aplicar_oferta as apli on apli.cod_ofertalaboral=ola.codigo  INNER JOIN graduado as gradu on gradu.codigo=apli.cod_graduado WHERE gradu.codigo=? GROUP by e.codigo,e.nombre ) as res";
            ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
            lstpar.add(new Parametro(1, item.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstpar);
            miResultado = llenarResultados(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return miResultado;
    }

    public static ArrayList<Resultado> obtenerHistoriaLaboral() throws Exception {
        ArrayList<Resultado> miResultado = null;
        try {
            String sql = "select res.nombre,res.cantidad from (SELECT g.codigo,g.nombre,count(*) as cantidad from historia_laboral as h inner join graduado AS g on g.codigo=h.cod_graduado GROUP by g.codigo,g.nombre) as res";

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            miResultado = llenarResultados(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return miResultado;
    }

    public static ArrayList<Resultado> obteneroOfertaLaboralAplicados() throws Exception {
        ArrayList<Resultado> miResultado = null;
        try {
            String sql = "select res.nombre,res.cantidad from(SELECT g.codigo,g.nombre ,count(*) as cantidad FROM aplicar_oferta as ao inner join graduado as g on g.codigo=ao.cod_graduado inner join oferta_laboral as ola on ola.codigo=ao.cod_ofertalaboral INNER join empresa as em on em.codigo=ola.cod_empresa inner join tipo_cargo as tc on tc.codigo=ola.cod_tipocargo group by g.codigo,g.nombre)as res";

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            miResultado = llenarResultados(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return miResultado;
    }

    public static ArrayList<Resultado> obtenerocapacitaciones() throws Exception {
        ArrayList<Resultado> miResultado = null;
        try {
            String sql = "select res.nombre,res.cantidad from(SELECT g.codigo,g.nombre ,count(*)as cantidad from graduado as g inner join cursado as cu on cu.cod_graduado=g.codigo  GROUP by  g.codigo,g.nombre)res";

            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            miResultado = llenarResultados(rs);

        } catch (Exception ex) {
            throw ex;
        }
        return miResultado;
    }

    private static ArrayList<Resultado> llenarResultados(ConjuntoResultado cr) throws Exception {
        ArrayList<Resultado> lst = new ArrayList<Resultado>();
        Resultado obj = null;
        try {
            while (cr.next()) {
                obj = new Resultado();
                obj.setDescripcion(cr.getString(1));
                obj.setCantidad(cr.getInt(2));
                lst.add(obj);

            }
        } catch (Exception ex) {
            throw ex;
        }
        return lst;
    }
}
