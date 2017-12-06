/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Personal;
import ec.edu.itsbolivar.www.rnegocio.funciones.FPersonal;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author XL
 */
@ManagedBean
@ViewScoped
public class templateAdminController {

    boolean modal = false;
    Personal item = new Personal();

    public templateAdminController() {
        try {
            cargardatos();
        } catch (Exception e) {
        }
    }

    public void cargardatos() throws IOException {
        item = itemLogueado();

    }

    public Personal itemLogueado() throws IOException {
        Personal item = (Personal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        if (item != null) {

        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        }
        return item;

    }

    public void actualizar() throws Exception {
        modal = true;
        FPersonal.modificar(item);
    }

   

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public Personal getItem() {
        return item;
    }

    public void setItem(Personal item) {
        this.item = item;
    }
    

}
