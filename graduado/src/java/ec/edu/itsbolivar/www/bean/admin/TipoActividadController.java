/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.bean.admin;

import ec.edu.itsbolivar.www.recursos.Util;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_actividad;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_actividad;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TipoActividadController {

    private List<Tipo_actividad> lista;
    private Tipo_actividad tipoactividad;
    private boolean modal = false;
    private boolean edit = false;

    public TipoActividadController() {
        tipoactividad = new Tipo_actividad();
        cargardatos();
    }

    public void cargardatos() {
        try {
            tipoactividad = new Tipo_actividad();
            lista = FTipo_actividad.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void insertar() {

        try {
            if (FTipo_actividad.insertar(tipoactividad)) {
                boolean modal = true;
                Util.addOKMessage("Ingresado correctamente!!");
                cargardatos();
                tipoactividad = new Tipo_actividad();
                modal = true;
            } else {
                Util.addErrorMessage("No se pudo ingresar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoActividadController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorMessage("Error:" + e.getMessage());
        }
    }

    public void ver(Tipo_actividad e) throws Exception {
        edit = true;
        tipoactividad = FTipo_actividad.obtener(e.getCodigo());
    }

    public void eliminar(Tipo_actividad seleccionado) {

        try {
            if (FTipo_actividad.eliminar(seleccionado)) {
                Util.addOKMessage("Eliminado correctamente!!");
                cargardatos();
                seleccionado = new Tipo_actividad();
            } else {
                Util.addErrorMessage("No se pudo eliminar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoActividadController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public void actualizar() {
        modal = true;
        try {
            if (FTipo_actividad.modificar(tipoactividad)) {
                Util.addOKMessage("Modificado correctamente!!");
                cargardatos();
                tipoactividad = new Tipo_actividad();

            } else {
                Util.addErrorMessage("No se pudo modificar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoActividadController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public List<Tipo_actividad> getLista() {
        return lista;
    }

    public void setLista(List<Tipo_actividad> lista) {
        this.lista = lista;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public void activeNew() {
        tipoactividad = new Tipo_actividad();
        edit = false;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Tipo_actividad getTipoactividad() {
        return tipoactividad;
    }

    public void setTipoactividad(Tipo_actividad tipoactividad) {
        this.tipoactividad = tipoactividad;
    }

}
