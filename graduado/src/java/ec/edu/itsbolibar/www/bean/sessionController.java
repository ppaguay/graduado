/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Personal;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author XL
 */
@ManagedBean
@ViewScoped
public class sessionController implements Serializable{

    /**
     * Creates a new instance of sessionController
     */
    public sessionController() {
    }

    public void closeSession() {
        System.out.println("salir");
        try {
            System.out.println("logOut");
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect(router.login);
        } catch (Exception e) {
        }
    }

    public void verificarLogeoAdmin() {
        try {
            //este metodo rerifica si hat session si no se redirecciona
            Personal personal = (Personal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (personal != null) {

                if (personal.getTipo_personal().getCodigo() != 1) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("login");
                }
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login");
            }

        } catch (Exception e) {
            System.out.println("error verificar");

        }

    }

    public void verificarLogeoGraduado() {
        try {
            //este metodo rerifica si hat session si no se redirecciona
            Personal personal = (Personal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (personal != null) {

                if (personal.getTipo_personal().getCodigo() != 2) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("login");
                }

            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login");
            }

        } catch (Exception e) {

        }
    }

    public void verificarLogeoEmpresa() {
        try {
            //este metodo rerifica si hat session si no se redirecciona

            Personal personal = (Personal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (personal != null) {

                if (personal.getTipo_personal().getCodigo() != 3) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("login");
                }
                System.out.println("correcto");
               
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login");
            }

        } catch (Exception e) {

        }
    }

    public void verificarSessionActivo() {
        try {
            //este metodo rerifica si hat session si no se redirecciona

            Personal personal = (Personal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

            if (personal != null) {
                if (personal.getTipo_personal().getCodigo() == 3) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("adminEmpresa");
                }
                if (personal.getTipo_personal().getCodigo() == 2) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("adminGraduado");
                }
                if (personal.getTipo_personal().getCodigo() == 1) {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("admin");
                }
            } 

        } catch (Exception e) {

        }
    }

}
