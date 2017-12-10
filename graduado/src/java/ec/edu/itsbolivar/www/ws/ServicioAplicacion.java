/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.ws;

import com.google.gson.Gson;
import ec.edu.itsbolivar.www.rnegocio.clases.Aplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FAplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FOferta_laboral;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("aplicacion")
public class ServicioAplicacion {

    @GET
    @Path("/listarporgraduado/{codigograduado}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Aplicar_oferta> listar(@PathParam("codigograduado") int codigograduado) {        
        List<Aplicar_oferta> lista = new ArrayList<>();
        
        try {
            Graduado graduado = new Graduado();
            graduado.setCodigo(codigograduado);
            lista = FAplicar_oferta.obtener(graduado);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return lista;
    }

   
   

    @POST
    @Path("/registrar/{codigograduado}/{codigooferta}")
    @Consumes("application/json")
    public int registrar(@PathParam("codigooferta")int codigograduado,@PathParam("codigooferta")int codigooferta) {        
        int respuesta=0; //0= no se ejecuto, 1=Ejecutado satisfactoriamente, 3 = Error
        try {
            Oferta_laboral oferta= FOferta_laboral.obtener(codigooferta);
            Graduado graduado = FGraduado.obtener(codigograduado);
            Aplicar_oferta aplicacion= new Aplicar_oferta();
            aplicacion.setGraduado(graduado);
            aplicacion.setOferta_laboral(oferta);
            aplicacion.setContrato("");
            aplicacion.setFecha_inicio(null);
            aplicacion.setFecha_aplica((new Date()).getTime());
            if (FAplicar_oferta.insertar(aplicacion)) {
                respuesta=1;
            }
        } catch (Exception ex) {
            respuesta =0;
            System.out.println("Error:" + ex.getMessage());
        }
        return respuesta;
    }
   
}
