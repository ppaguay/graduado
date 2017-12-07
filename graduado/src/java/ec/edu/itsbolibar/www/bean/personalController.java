/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Personal;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_capacitacion;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_personal;
import ec.edu.itsbolivar.www.rnegocio.funciones.FPersonal;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_capacitacion;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_personal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author XL
 */
@ManagedBean
@ViewScoped
public class personalController {

    Personal item = new Personal();
    ArrayList<Personal> lst_personal = new ArrayList<>();
    ArrayList<Tipo_personal> lst_tipo_personal = new ArrayList<>();
    boolean modal = false;
    boolean edit = false;

    public personalController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(capacitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertar() throws Exception {
        boolean existe = false;
        for (Personal p : FPersonal.obtener()) {

            if (p.getNombre().equals(item.getNombre())) {
                existe = true;
            }

        }
        if (existe == false) {

            FPersonal.insertar(item);
            modal = true;
            cargarDatos();
        } else {
            FacesContext.getCurrentInstance().addMessage("Warning ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Usuario Ya Existe"));
        }
    }

    public void actualizar() throws Exception {
        modal = true;
        FPersonal.modificar(item);
    }

    public void eliminar(Personal e) throws Exception {
        System.err.println("eliminado");
        FPersonal.eliminar(e);
        cargarDatos();
    }

    public void ver(Personal e) throws Exception {
        edit = true;
        item = FPersonal.obtener(e.getCodigo());

        //System.out.println("tipo:Actividad" + item.getTipo_capacitacion().getNombre());
        for (Tipo_personal ta : lst_tipo_personal) {
            if (ta.getCodigo() == item.getTipo_personal().getCodigo()) {
                item.setTipo_personal(ta);
            }

        }
    }

    private void cargarDatos() throws Exception {
        lst_personal.clear();
        lst_personal = FPersonal.obtener();
        lst_tipo_personal.clear();
        lst_tipo_personal = FTipo_personal.obtener();
        System.out.println("Datos Cargados");
    }

    public Personal getPersonal() {
        return item;
    }

    public void setPersonal(Personal item) {
        this.item = item;
    }

    public void activeNew() {
        item = new Personal();
        edit = false;
    }
    //otros

    public Personal getItem() {
        return item;
    }

    public void setItem(Personal item) {
        this.item = item;
    }

    public ArrayList<Personal> getLst_personal() {
        return lst_personal;
    }

    public void setLst_personal(ArrayList<Personal> lst_personal) {
        this.lst_personal = lst_personal;
    }

    public ArrayList<Tipo_personal> getLst_tipo_personal() {
        return lst_tipo_personal;
    }

    public void setLst_tipo_personal(ArrayList<Tipo_personal> lst_tipo_personal) {
        this.lst_tipo_personal = lst_tipo_personal;
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

}
