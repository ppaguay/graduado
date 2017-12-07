/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Resultado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FResultado;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author XL
 */
@ManagedBean
@ViewScoped
public class resultadoAllController {

    String grafico_selected_oferta_laboral = "bar";
    String grafico_selected_historia_laboral = "bar";
    String grafico_selected_graduados = "bar";
    String grafico_selected_capacitacion = "bar";
    ArrayList<Resultado> lst_restultado_oferta_laboral = new ArrayList();
    ArrayList<Resultado> lst_restultado_historia_laboral = new ArrayList();
    ArrayList<Resultado> lst_restultado_graduados = new ArrayList();
    ArrayList<Resultado> lst_restultado_capacitacion = new ArrayList();

    public resultadoAllController() {
        try {
            cargarDatos();

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    }

    public void cargarDatos() throws Exception {
        lst_restultado_oferta_laboral = FResultado.obtenerOfertaLaboral();
        lst_restultado_historia_laboral = FResultado.obtenerHistoriaLaboral();
        lst_restultado_graduados = FResultado.obteneroOfertaLaboralAplicados();
        lst_restultado_capacitacion = FResultado.obtenerocapacitaciones();
    }

    public String getGrafico_selected_oferta_laboral() {
        return grafico_selected_oferta_laboral;
    }

    public void setGrafico_selected_oferta_laboral(String grafico_selected_oferta_laboral) {
        this.grafico_selected_oferta_laboral = grafico_selected_oferta_laboral;
    }

    public String getGrafico_selected_historia_laboral() {
        return grafico_selected_historia_laboral;
    }

    public void setGrafico_selected_historia_laboral(String grafico_selected_historia_laboral) {
        this.grafico_selected_historia_laboral = grafico_selected_historia_laboral;
    }

    public String getGrafico_selected_graduados() {
        return grafico_selected_graduados;
    }

    public void setGrafico_selected_graduados(String grafico_selected_graduados) {
        this.grafico_selected_graduados = grafico_selected_graduados;
    }

    public String getGrafico_selected_capacitacion() {
        return grafico_selected_capacitacion;
    }

    public void setGrafico_selected_capacitacion(String grafico_selected_capacitacion) {
        this.grafico_selected_capacitacion = grafico_selected_capacitacion;
    }

    public ArrayList<Resultado> getLst_restultado_oferta_laboral() {
        return lst_restultado_oferta_laboral;
    }

    public void setLst_restultado_oferta_laboral(ArrayList<Resultado> lst_restultado_oferta_laboral) {
        this.lst_restultado_oferta_laboral = lst_restultado_oferta_laboral;
    }

    public ArrayList<Resultado> getLst_restultado_historia_laboral() {
        return lst_restultado_historia_laboral;
    }

    public void setLst_restultado_historia_laboral(ArrayList<Resultado> lst_restultado_historia_laboral) {
        this.lst_restultado_historia_laboral = lst_restultado_historia_laboral;
    }

    public ArrayList<Resultado> getLst_restultado_graduados() {
        return lst_restultado_graduados;
    }

    public void setLst_restultado_graduados(ArrayList<Resultado> lst_restultado_graduados) {
        this.lst_restultado_graduados = lst_restultado_graduados;
    }

    public ArrayList<Resultado> getLst_restultado_capacitacion() {
        return lst_restultado_capacitacion;
    }

    public void setLst_restultado_capacitacion(ArrayList<Resultado> lst_restultado_capacitacion) {
        this.lst_restultado_capacitacion = lst_restultado_capacitacion;
    }
    
    

}
