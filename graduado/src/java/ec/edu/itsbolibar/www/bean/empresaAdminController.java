/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.clases.Resultado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEmpresa;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FOferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FPersonal;
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

public class empresaAdminController {

    String grafico_selected_oferta_laboral = "pie";
    ArrayList<Resultado> lst_restultado_oferta_laboral = new ArrayList();
    Empresa item = new Empresa();
    int personal = 0;
    int empresas = 0;
    int graduados = 0;
    int oferta_laboral = 0;

    public empresaAdminController() {
        try {
            cargarDatos();
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
    }

    public void cargarDatos() throws Exception {
        item = itemLogueado();
        lst_restultado_oferta_laboral = FResultado.obtener(item);
        personal = FPersonal.obtener().size();
        empresas = FEmpresa.obtener().size();
        
        for(Resultado r :lst_restultado_oferta_laboral){
            graduados+=r.getCantidad();
        }
        
        oferta_laboral = FOferta_laboral.obtener(item).size();

    }

    public Empresa itemLogueado() throws IOException {
        Empresa item = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");

        if (item != null) {

        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        }
        System.out.println("usuario encontrado" + item.getNombre());
        return item;

    }

    public String getGrafico_selected_oferta_laboral() {
        return grafico_selected_oferta_laboral;
    }

    public void setGrafico_selected_oferta_laboral(String grafico_selected_oferta_laboral) {
        this.grafico_selected_oferta_laboral = grafico_selected_oferta_laboral;
    }

    public ArrayList<Resultado> getLst_restultado_oferta_laboral() {
        return lst_restultado_oferta_laboral;
    }

    public void setLst_restultado_oferta_laboral(ArrayList<Resultado> lst_restultado_oferta_laboral) {
        this.lst_restultado_oferta_laboral = lst_restultado_oferta_laboral;
    }

    public Empresa getItem() {
        return item;
    }

    public void setItem(Empresa item) {
        this.item = item;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public int getEmpresas() {
        return empresas;
    }

    public void setEmpresas(int empresas) {
        this.empresas = empresas;
    }

    public int getGraduados() {
        return graduados;
    }

    public void setGraduados(int graduados) {
        this.graduados = graduados;
    }

    public int getOferta_laboral() {
        return oferta_laboral;
    }

    public void setOferta_laboral(int oferta_laboral) {
        this.oferta_laboral = oferta_laboral;
    }

}
