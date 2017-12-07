/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.bean.admin;

import ec.edu.itsbolivar.www.recursos.Util;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_causa_salida;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_causa_salida;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TipoCausaSalidaController {

    private List<Tipo_causa_salida> lista;
    private Tipo_causa_salida tipocausasalida;
    private boolean modal = false;
    private boolean edit = false;

    public TipoCausaSalidaController() {
        tipocausasalida = new Tipo_causa_salida();
        cargardatos();
    }

    public void cargardatos() {
        try {
            tipocausasalida = new Tipo_causa_salida();
            lista = FTipo_causa_salida.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void insertar() {

        try {
            if (FTipo_causa_salida.insertar(tipocausasalida)) {
                boolean modal = true;
                Util.addOKMessage("Ingresado correctamente!!");
                cargardatos();
                tipocausasalida = new Tipo_causa_salida();
                modal = true;
            } else {
                Util.addErrorMessage("No se pudo ingresar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoCausaSalidaController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorMessage("Error:" + e.getMessage());
        }
    }

    public void ver(Tipo_causa_salida e) throws Exception {
        edit = true;
        tipocausasalida = FTipo_causa_salida.obtener(e.getCodigo());
    }

    public void eliminar(Tipo_causa_salida seleccionado) {

        try {
            if (FTipo_causa_salida.eliminar(seleccionado)) {
                Util.addOKMessage("Eliminado correctamente!!");
                cargardatos();
                seleccionado = new Tipo_causa_salida();
            } else {
                Util.addErrorMessage("No se pudo eliminar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoCausaSalidaController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public void actualizar() {
        modal = true;
        try {
            if (FTipo_causa_salida.modificar(tipocausasalida)) {
                Util.addOKMessage("Modificado correctamente!!");
                cargardatos();
                tipocausasalida = new Tipo_causa_salida();

            } else {
                Util.addErrorMessage("No se pudo modificar");
            }
        } catch (Exception e) {
            Logger.getLogger(TipoCausaSalidaController.class.getName()).log(Level.SEVERE, null, e);
            Util.addErrorFatalMessage("Error:" + e.getMessage());
        }
    }

    public List<Tipo_causa_salida> getLista() {
        return lista;
    }

    public void setLista(List<Tipo_causa_salida> lista) {
        this.lista = lista;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public void activeNew() {
        tipocausasalida = new Tipo_causa_salida();
        edit = false;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public Tipo_causa_salida getTipocausasalida() {
        return tipocausasalida;
    }

    public void setTipocausasalida(Tipo_causa_salida tipocausasalida) {
        this.tipocausasalida = tipocausasalida;
    }

  

}
