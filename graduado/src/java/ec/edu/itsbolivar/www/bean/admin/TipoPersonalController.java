/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.bean.admin;

import ec.edu.itsbolivar.www.recursos.Util;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_personal;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_personal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TipoPersonalController {

    private List<Tipo_personal> lista;
    private Tipo_personal tipopersonal;
    private boolean modal = false;
    private boolean edit = false;

    public TipoPersonalController() {
        tipopersonal = new Tipo_personal();
        cargardatos();
    }

    public void cargardatos() {
        try {
            tipopersonal = new Tipo_personal();
            lista = FTipo_personal.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void insertar() {

        try {
            if (FTipo_personal.insertar(tipopersonal)) {
                boolean modal = true;
                Util.addOKMessage("Ingresado correctamente!!");
                cargardatos();
                tipopersonal = new Tipo_personal();
                modal = true;
            } else {
                Util.addErrorMessage("No se pudo ingresar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoPersonalController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorMessage("Error:" + e.getMessage());
        }
    }

    public void ver(Tipo_personal e) throws Exception {
        edit = true;
        tipopersonal = FTipo_personal.obtener(e.getCodigo());
    }

    public void eliminar(Tipo_personal seleccionado) {

        try {
            if (FTipo_personal.eliminar(seleccionado)) {
                Util.addOKMessage("Eliminado correctamente!!");
                cargardatos();
                seleccionado = new Tipo_personal();
            } else {
                Util.addErrorMessage("No se pudo eliminar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoPersonalController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public void actualizar() {
        modal = true;
        try {
            if (FTipo_personal.modificar(tipopersonal)) {
                Util.addOKMessage("Modificado correctamente!!");
                cargardatos();
                tipopersonal = new Tipo_personal();

            } else {
                Util.addErrorMessage("No se pudo modificar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoPersonalController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public List<Tipo_personal> getLista() {
        return lista;
    }

    public void setLista(List<Tipo_personal> lista) {
        this.lista = lista;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public void activeNew() {
        tipopersonal = new Tipo_personal();
        edit = false;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Tipo_personal getTipopersonal() {
        return tipopersonal;
    }

    public void setTipopersonal(Tipo_personal tipopersonal) {
        this.tipopersonal = tipopersonal;
    }



}
