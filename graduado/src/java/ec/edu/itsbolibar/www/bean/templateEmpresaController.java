/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_actividad;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEmpresa;
import ec.edu.itsbolivar.www.rnegocio.funciones.FPersonal;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_actividad;
import java.io.IOException;
import java.util.ArrayList;
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

    boolean modal = false;
    Empresa item = new Empresa();
    ArrayList<Tipo_actividad> lst_tipo_actividad = new ArrayList<>();

    public templateEmpresaController() {
        try {
            cargardatos();
        } catch (Exception e) {
        }
    }

    public void cargardatos() throws IOException, Exception {
        item = itemLogueado();
        item=FEmpresa.obtener(item.getCodigo());
        lst_tipo_actividad.clear();
        lst_tipo_actividad = FTipo_actividad.obtener();
        for (Tipo_actividad ta : lst_tipo_actividad) {
            if (ta.getCodigo() == item.getTipo_actividad().getCodigo()) {
                item.setTipo_actividad(ta);
            }

        }

    }

    public Empresa itemLogueado() throws IOException {
        Empresa item = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");

        if (item != null) {

        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        }
        System.out.println("usuario encontrado"+item.getNombre());
        return item;

    }

    public void actualizar() throws Exception {
        modal = true;
        FEmpresa.modificar(item);
        System.out.println("actualizado");
    }

    public Empresa getItem() {
        return item;
    }

    public void setItem(Empresa item) {
        this.item = item;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public ArrayList<Tipo_actividad> getLst_tipo_actividad() {
        return lst_tipo_actividad;
    }

    public void setLst_tipo_actividad(ArrayList<Tipo_actividad> lst_tipo_actividad) {
        this.lst_tipo_actividad = lst_tipo_actividad;
    }

}
