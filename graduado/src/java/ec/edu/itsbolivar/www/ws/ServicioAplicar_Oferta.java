/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.ws;

import com.google.gson.Gson;
import ec.edu.itsbolivar.www.recursos.Tools;
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
@Path("aplicarOferta")
public class ServicioAplicar_Oferta {

    @GET
    @Path("/AplicarNuevaOferta")
    @Produces({MediaType.APPLICATION_JSON})
    public String aplicarNuevaOferya(@QueryParam("cod_graduado") int cod_graduado, @QueryParam("cod_ofertalaboral") int cod_ofertalaboral) {
        AppJson<Aplicar_oferta> appJson = new AppJson<>();
        Graduado graduado = new Graduado();
        graduado.setCodigo(cod_graduado);
        Oferta_laboral oferta_laboral = new Oferta_laboral();
        oferta_laboral.setCodigo(cod_ofertalaboral);
       
        Aplicar_oferta aplicar_oferta = new Aplicar_oferta();
        String fecha = "";
        try {
            fecha = Tools.optenerfechaActual();
            System.out.println("fecha:" + fecha);
            aplicar_oferta.setFecha_inicio(Tools.convertStringToDateLong(fecha));
            aplicar_oferta.setFecha_aplica(Tools.convertStringToDateLong(fecha));
            aplicar_oferta.setContrato("");
            aplicar_oferta.setGraduado(graduado);
            aplicar_oferta.setOferta_laboral(oferta_laboral);
            appJson.setSuccess(FAplicar_oferta.insertar(aplicar_oferta) ? 1 : 0);
            if (appJson.getSuccess() == 1) {
                appJson.setMessage("Success");
            } else {
                appJson.setMessage("Error");

            }
        } catch (Exception e) {
            appJson.setSuccess(0);
            appJson.setMessage(e.getMessage());
        }

        String json = new Gson().toJson(appJson);
        return json;
    }
}
