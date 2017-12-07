/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.bean.admin;

import ec.edu.itsbolivar.www.recursos.Util;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_cargo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TipoCargoController {

    private List<Tipo_cargo> lista;
    private Tipo_cargo tipocargo;
    private boolean modal = false;
    private boolean edit = false;

    public TipoCargoController() {
        tipocargo = new Tipo_cargo();
        cargardatos();
    }

    public void cargardatos() {
        try {
            tipocargo = new Tipo_cargo();
            lista = FTipo_cargo.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void insertar() {

        try {
            if (FTipo_cargo.insertar(tipocargo)) {
                boolean modal = true;
                Util.addOKMessage("Ingresado correctamente!!");
                cargardatos();
                tipocargo = new Tipo_cargo();
                modal = true;
            } else {
                Util.addErrorMessage("No se pudo ingresar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoCargoController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorMessage("Error:" + e.getMessage());
        }
    }

    public void ver(Tipo_cargo e) throws Exception {
        edit = true;
        tipocargo = FTipo_cargo.obtener(e.getCodigo());
    }

    public void eliminar(Tipo_cargo seleccionado) {

        try {
            if (FTipo_cargo.eliminar(seleccionado)) {
                Util.addOKMessage("Eliminado correctamente!!");
                cargardatos();
                seleccionado = new Tipo_cargo();
            } else {
                Util.addErrorMessage("No se pudo eliminar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoCargoController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public void actualizar() {
        modal = true;
        try {
            if (FTipo_cargo.modificar(tipocargo)) {
                Util.addOKMessage("Modificado correctamente!!");
                cargardatos();
                tipocargo = new Tipo_cargo();

            } else {
                Util.addErrorMessage("No se pudo modificar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoCargoController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public List<Tipo_cargo> getLista() {
        return lista;
    }

    public void setLista(List<Tipo_cargo> lista) {
        this.lista = lista;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public void activeNew() {
        tipocargo = new Tipo_cargo();
        edit = false;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Tipo_cargo getTipocargo() {
        return tipocargo;
    }

    public void setTipocargo(Tipo_cargo tipocargo) {
        this.tipocargo = tipocargo;
    }

  

}
