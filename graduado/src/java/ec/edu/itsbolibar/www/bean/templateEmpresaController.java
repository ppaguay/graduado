/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEmpresa;
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
public class templateEmpresaController {

    Empresa empresa = new Empresa();

    public templateEmpresaController() {
        try {
            cargardatos();
        } catch (Exception e) {
        }
    }

    public void cargardatos() throws IOException {
        empresa = empresaLogueado();

    }

    public Empresa empresaLogueado() throws IOException {
        Empresa empresa = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");

        if (empresa != null) {

        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        }
        return empresa;

    }

    public void Actualizar() throws Exception {
        FEmpresa.modificar(empresa);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    

}
