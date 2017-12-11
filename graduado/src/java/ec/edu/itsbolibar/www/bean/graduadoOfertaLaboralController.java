/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Aplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_sueldo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FAplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEmpresa;
import ec.edu.itsbolivar.www.rnegocio.funciones.FOferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_sueldo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class graduadoOfertaLaboralController {

    Oferta_laboral item = new Oferta_laboral();
    ArrayList<Oferta_laboral> lst_ofertaLaboral = new ArrayList<>();
    private Aplicar_oferta aplicacion;
    Graduado graduado;

    boolean modal = false;
    boolean edit = false;

    @PostConstruct
    public void init() {
        try {
            graduado = (Graduado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduado");
            if (graduado == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login");
            }
        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }

    public graduadoOfertaLaboralController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(ofertaLaboralController.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage("Error ", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al cargar los datos "));
        }
    }

    public void activeNew() {
        item = new Oferta_laboral();
        aplicacion.setOferta_laboral(item);
        edit = false;
    }

    public void aplicar() throws Exception {
        aplicacion.setOferta_laboral(item);
        aplicacion.setGraduado(graduado);
        aplicacion.setFecha_aplica((new Date()).getTime());
        Aplicar_oferta tmp = FAplicar_oferta.obtener(aplicacion.getGraduado().getCodigo(), aplicacion.getOferta_laboral().getCodigo());
        if (tmp == null) {
            FAplicar_oferta.insertar(aplicacion);
            modal = true;
            cargarDatos();
            FacesContext.getCurrentInstance().addMessage("Completado ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Completado", "Aplicación registrada correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage("Error ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Ya aplicó previamente a esta oferta "));
        }
    }
    
   

    public void ver(Oferta_laboral e) throws Exception {
        
        item = e;

    }

    private void cargarDatos() throws Exception {
        aplicacion = new Aplicar_oferta();
        aplicacion.setGraduado(graduado);
        aplicacion.setContrato("");
        aplicacion.setFecha_inicio(null);
        aplicacion.setOferta_laboral(new Oferta_laboral());
        lst_ofertaLaboral.clear();
        lst_ofertaLaboral = FOferta_laboral.obtener();
    }

    //otros
    public Oferta_laboral getItem() {
        return item;
    }

    public void setItem(Oferta_laboral item) {
        this.item = item;
    }

    public ArrayList<Oferta_laboral> getLst_ofertaLaboral() {
        return lst_ofertaLaboral;
    }

    public void setLst_ofertaLaboral(ArrayList<Oferta_laboral> lst_ofertaLaboral) {
        this.lst_ofertaLaboral = lst_ofertaLaboral;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Aplicar_oferta getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(Aplicar_oferta aplicacion) {
        this.aplicacion = aplicacion;
    }

}
