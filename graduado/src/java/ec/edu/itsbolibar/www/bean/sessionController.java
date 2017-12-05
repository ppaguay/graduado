/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author XL
 */
@Named(value = "sessionController")
@Dependent
public class sessionController {

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
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        } catch (Exception e) {
        }
    }
}
