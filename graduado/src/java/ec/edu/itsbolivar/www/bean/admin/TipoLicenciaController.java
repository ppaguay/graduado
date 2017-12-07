/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.bean.admin;

import ec.edu.itsbolivar.www.recursos.Util;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_licencia;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_licencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TipoLicenciaController {

    private List<Tipo_licencia> lista;
    private Tipo_licencia tipolicencia;
    private boolean modal = false;
    private boolean edit = false;

    public TipoLicenciaController() {
        tipolicencia = new Tipo_licencia();
        cargardatos();
    }

    public void cargardatos() {
        try {
            tipolicencia = new Tipo_licencia();
            lista = FTipo_licencia.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void insertar() {

        try {
            if (FTipo_licencia.insertar(tipolicencia)) {
                boolean modal = true;
                Util.addOKMessage("Ingresado correctamente!!");
                cargardatos();
                tipolicencia = new Tipo_licencia();
                modal = true;
            } else {
                Util.addErrorMessage("No se pudo ingresar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoLicenciaController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorMessage("Error:" + e.getMessage());
        }
    }

    public void ver(Tipo_licencia e) throws Exception {
        edit = true;
        tipolicencia = FTipo_licencia.obtener(e.getCodigo());
    }

    public void eliminar(Tipo_licencia seleccionado) {

        try {
            if (FTipo_licencia.eliminar(seleccionado)) {
                Util.addOKMessage("Eliminado correctamente!!");
                cargardatos();
                seleccionado = new Tipo_licencia();
            } else {
                Util.addErrorMessage("No se pudo eliminar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoLicenciaController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public void actualizar() {
        modal = true;
        try {
            if (FTipo_licencia.modificar(tipolicencia)) {
                Util.addOKMessage("Modificado correctamente!!");
                cargardatos();
                tipolicencia = new Tipo_licencia();

            } else {
                Util.addErrorMessage("No se pudo modificar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoLicenciaController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public List<Tipo_licencia> getLista() {
        return lista;
    }

    public void setLista(List<Tipo_licencia> lista) {
        this.lista = lista;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public void activeNew() {
        tipolicencia = new Tipo_licencia();
        edit = false;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Tipo_licencia getTipolicencia() {
        return tipolicencia;
    }

    public void setTipolicencia(Tipo_licencia tipolicencia) {
        this.tipolicencia = tipolicencia;
    }


    
}
