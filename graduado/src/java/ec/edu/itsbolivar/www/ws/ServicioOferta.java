/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.ws;

import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FOferta_laboral;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("oferta")
public class ServicioOferta {

    @GET
    @Path("/listar")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Oferta_laboral> listar() {
        List<Oferta_laboral> lista = new ArrayList<>();       
        try {
            lista = FOferta_laboral.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return lista;
    }

    @GET
    @Path("/obtener/{codigo}")
    @Produces({MediaType.APPLICATION_JSON})
    public Oferta_laboral obtener(@PathParam("codigo") int codigo) {
        Oferta_laboral oferta = null;        
        try {
            oferta = FOferta_laboral.obtener(codigo);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return oferta;
    }
}
