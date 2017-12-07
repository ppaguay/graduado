/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.bean.admin;

import ec.edu.itsbolivar.www.recursos.Util;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_sueldo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_sueldo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TipoSueldoController {

    private List<Tipo_sueldo> lista;
    private Tipo_sueldo tiposueldo;
    private boolean modal = false;
    private boolean edit = false;

    public TipoSueldoController() {
        tiposueldo  = new Tipo_sueldo();
        cargardatos();
    }

    public void cargardatos() {
        try {
            tiposueldo = new Tipo_sueldo();
            lista = FTipo_sueldo.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void insertar() {

        try {
            if (FTipo_sueldo.insertar(tiposueldo)) {
                boolean modal = true;
                Util.addOKMessage("Ingresado correctamente!!");
                cargardatos();
                tiposueldo = new Tipo_sueldo();
                modal = true;
            } else {
                Util.addErrorMessage("No se pudo ingresar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoSueldoController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorMessage("Error:" + e.getMessage());
        }
    }

    public void ver(Tipo_sueldo e) throws Exception {
        edit = true;
        tiposueldo = FTipo_sueldo.obtener(e.getCodigo());
    }

    public void eliminar(Tipo_sueldo seleccionado) {

        try {
            if (FTipo_sueldo.eliminar(seleccionado)) {
                Util.addOKMessage("Eliminado correctamente!!");
                cargardatos();
                seleccionado = new Tipo_sueldo();
            } else {
                Util.addErrorMessage("No se pudo eliminar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoSueldoController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public void actualizar() {
        modal = true;
        try {
            if (FTipo_sueldo.modificar(tiposueldo)) {
                Util.addOKMessage("Modificado correctamente!!");
                cargardatos();
                tiposueldo = new Tipo_sueldo();

            } else {
                Util.addErrorMessage("No se pudo modificar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoSueldoController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public List<Tipo_sueldo> getLista() {
        return lista;
    }

    public void setLista(List<Tipo_sueldo> lista) {
        this.lista = lista;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public void activeNew() {
        tiposueldo = new Tipo_sueldo();
        edit = false;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Tipo_sueldo getTiposueldo() {
        return tiposueldo;
    }

    public void setTiposueldo(Tipo_sueldo tiposueldo) {
        this.tiposueldo = tiposueldo;
    }

   

}
