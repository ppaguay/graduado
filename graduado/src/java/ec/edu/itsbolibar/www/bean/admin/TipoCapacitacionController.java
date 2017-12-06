/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean.admin;

import ec.edu.itsbolibar.www.recursos.Util;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_capacitacion;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_capacitacion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class TipoCapacitacionController {

    private List<Tipo_capacitacion> lista;
    private Tipo_capacitacion tipocapacitacion;
    private boolean modal = false;
    private boolean edit = false;

    public TipoCapacitacionController() {
        tipocapacitacion = new Tipo_capacitacion();
        cargardatos();
    }

    public void cargardatos() {
        try {
            tipocapacitacion = new Tipo_capacitacion();
            lista = FTipo_capacitacion.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void insertar() {

        try {
            if (FTipo_capacitacion.insertar(tipocapacitacion)) {
                boolean modal = true;
                Util.addOKMessage("Ingresado correctamente!!");
                cargardatos();
                tipocapacitacion = new Tipo_capacitacion();
                modal = true;
            } else {
                Util.addErrorMessage("No se pudo ingresar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoCapacitacionController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorMessage("Error:" + e.getMessage());
        }
    }

    public void ver(Tipo_capacitacion e) throws Exception {
        edit = true;
        tipocapacitacion = FTipo_capacitacion.obtener(e.getCodigo());
    }

    public void eliminar(Tipo_capacitacion seleccionado) {

        try {
            if (FTipo_capacitacion.eliminar(seleccionado)) {
                Util.addOKMessage("Eliminado correctamente!!");
                cargardatos();
                seleccionado = new Tipo_capacitacion();
            } else {
                Util.addErrorMessage("No se pudo eliminar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoCapacitacionController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public void actualizar() {
        modal = true;
        try {
            if (FTipo_capacitacion.modificar(tipocapacitacion)) {
                Util.addOKMessage("Modificado correctamente!!");
                cargardatos();
                tipocapacitacion = new Tipo_capacitacion();

            } else {
                Util.addErrorMessage("No se pudo modificar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoCapacitacionController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public List<Tipo_capacitacion> getLista() {
        return lista;
    }

    public void setLista(List<Tipo_capacitacion> lista) {
        this.lista = lista;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public void activeNew() {
        tipocapacitacion = new Tipo_capacitacion();
        edit = false;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Tipo_capacitacion getTipocapacitacion() {
        return tipocapacitacion;
    }

    public void setTipocapacitacion(Tipo_capacitacion tipocapacitacion) {
        this.tipocapacitacion = tipocapacitacion;
    }

}
