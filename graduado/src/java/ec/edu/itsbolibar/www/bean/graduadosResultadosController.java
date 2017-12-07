/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Resultado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FAplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.funciones.FCapacitacion;
import ec.edu.itsbolivar.www.rnegocio.funciones.FHistoria_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FOferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FResultado;
import java.io.IOException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;

/**
 *
 * @author XL
 */
@ManagedBean
@ViewScoped
public class graduadosResultadosController {
    
    String grafico_selected = "bar";
    Graduado item = new Graduado();
    ArrayList<Resultado> lst_restultado = new ArrayList();

    public graduadosResultadosController() throws Exception {
        try {
            cargarDatos();

        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }

    public void cargarDatos() throws Exception {
        item = itemLogueado();
        Resultado r1= new Resultado();
        r1.setDescripcion("Capacitaciones");
        r1.setCantidad(FCapacitacion.obtener(item).size());
        Resultado r2= new Resultado();
        r2.setDescripcion("Historial Laboral");
        r2.setCantidad(FHistoria_laboral.obtener(item).size());
        Resultado r3= new Resultado();
        r3.setDescripcion("Ofertas Aplicadas");
        r3.setCantidad(FAplicar_oferta.obtener(item).size());
        lst_restultado.add(r1);
        lst_restultado.add(r2);
        lst_restultado.add(r3);
    }

    public Graduado itemLogueado() throws IOException {
        Graduado item = (Graduado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduado");

        if (item != null) {

        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        }
        System.out.println("usuario encontrado" + item.getNombre());
        return item;

    }

    public String getGrafico_selected() {
        return grafico_selected;
    }

    public void setGrafico_selected(String grafico_selected) {
        this.grafico_selected = grafico_selected;
    }

    public Graduado getItem() {
        return item;
    }

    public void setItem(Graduado item) {
        this.item = item;
    }

    public ArrayList getLst_restultado() {
        return lst_restultado;
    }

    public void setLst_restultado(ArrayList lst_restultado) {
        this.lst_restultado = lst_restultado;
    }
    
}
