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

    Personal personal = new Personal();

    public templateAdminController() {
        try {
            cargardatos();
        } catch (Exception e) {
        }
    }

    public void cargardatos() throws IOException {
        personal = personalLogueado();

    }

    public Personal personalLogueado() throws IOException {
        Personal personal = (Personal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        if (personal != null) {

        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        }
        return personal;

    }

    public void Actualizar() throws Exception {
        FPersonal.modificar(personal);
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    

}
