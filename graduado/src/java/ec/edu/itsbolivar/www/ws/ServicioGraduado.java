/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.ws;

import com.google.gson.Gson;
import ec.edu.itsbolivar.www.rnegocio.clases.Aplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.clases.AppJson;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FAplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FOferta_laboral;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author XL
 */
@Path("graduado")
public class ServicioGraduado {

    @GET
    @Path("/login")
    @Produces({MediaType.APPLICATION_JSON})
    public String login(@QueryParam("user") String user, @QueryParam("password") String password) throws Exception {
        AppJson<Graduado> appJson = new AppJson<>();

        Graduado g = new Graduado();
        Graduado g_res = new Graduado();
        g.setCi(user);
        g.setClave(password);

        boolean correct = false;
        ArrayList<Graduado> lst = new ArrayList<>();

        for (Graduado item : FGraduado.obtener()) {
            if (item.getClave().equals(g.getClave()) && item.getCi().equals(g.getCi())) {
                correct = true;
                g_res = item;
            }
        }
        if (correct) {
            appJson.setSuccess(1);
            appJson.setMessage("Success..");
            lst.add(g_res);
            appJson.setData(lst);
        } else {
            appJson.setSuccess(0);
            appJson.setMessage("Error De Usuario O contraseña");

        }
        String json = new Gson().toJson(appJson);
        return json;
    }

    @GET
    @Path("/ofertasAplicadas")
    @Produces({MediaType.APPLICATION_JSON})
    public String ofertasAplicadas(@QueryParam("codigo") int codigo) {
        ArrayList<Aplicar_oferta> lst_aplica_oferta = new ArrayList<>();
        try {
            Graduado g = new Graduado();
            g.setCodigo(codigo);
            lst_aplica_oferta = FAplicar_oferta.obtener(g);
        } catch (Exception e) {
            System.out.println("error:"+e.getMessage());
        }
        String json = new Gson().toJson(lst_aplica_oferta);
        return json;
    }

    @GET
    @Path("/ofertasNoAplicadas")
    @Produces({MediaType.APPLICATION_JSON})
    public String OfertaNoAplicadas(@QueryParam("codigo") int codigo) throws Exception {

        Graduado graduado = new Graduado();
        graduado.setCodigo(codigo);
        ArrayList<Aplicar_oferta> lst_aplica_oferta = new ArrayList<>();
        lst_aplica_oferta = FAplicar_oferta.obtener(graduado);
        ArrayList<Oferta_laboral> lst = new ArrayList<>();
        ArrayList<Oferta_laboral> lst_return = new ArrayList<>();
        lst = FOferta_laboral.obtener();

        for (Oferta_laboral item : lst) {
            boolean existe = false;
            for (Aplicar_oferta a : lst_aplica_oferta) {
                if (a.getOferta_laboral().getCodigo() == item.getCodigo()) {
                    existe = true;
                    System.out.println("ao:" + a.getOferta_laboral().getCodigo() + "o:" + item.getCodigo());
                }

            }
            if (existe == false) {
                lst_return.add(item);
            }

        }
        String json = new Gson().toJson(lst_return);
        return json;

    }
}
