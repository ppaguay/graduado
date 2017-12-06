/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
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
public class templateGraduadosController {
    Graduado graduado = new Graduado();

    public templateGraduadosController() {
        try {
            cargardatos();
        } catch (Exception e) {
        }
    }

    public void cargardatos() throws IOException {
        graduado = graduadoLogueado();

    }

    public Graduado graduadoLogueado() throws IOException {
        Graduado graduado = (Graduado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduado");

        if (graduado != null) {
            
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        }
        return graduado;

    }
     public void Actualizar() throws Exception {
        FGraduado.modificar(graduado);
    }

    public Graduado getGraduado() {
        return graduado;
    }

    public void setGraduado(Graduado graduado) {
        this.graduado = graduado;
    }
     
    
}
