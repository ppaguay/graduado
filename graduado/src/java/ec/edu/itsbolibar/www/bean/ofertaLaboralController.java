/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_actividad;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_sueldo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEmpresa;
import ec.edu.itsbolivar.www.rnegocio.funciones.FOferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_actividad;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_sueldo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author XL
 */
@ManagedBean
@ViewScoped
public class ofertaLaboralController {

    Oferta_laboral item = new Oferta_laboral();
    ArrayList<Oferta_laboral> lst_ofertaLaboral = new ArrayList<>();
    ArrayList<Empresa> lst_empresa = new ArrayList<>();
    ArrayList<Tipo_cargo> lst_tipoCargo = new ArrayList<>();
    ArrayList<Tipo_sueldo> lst_tipoSueldo = new ArrayList<>();

    boolean modal = false;
    boolean edit = false;

    public ofertaLaboralController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(ofertaLaboralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void activeNew() {
        item = new Oferta_laboral();
        edit = false;
    }

    public void insertar() throws Exception {
        FOferta_laboral.insertar(item);
        modal = true;
        cargarDatos();
    }

    public void actualizar() throws Exception {
        modal = true;
        FOferta_laboral.modificar(item);
    }

    public void eliminar(Oferta_laboral e) throws Exception {
        System.err.println("eliminado");
       
        FOferta_laboral.eliminar(e);
        cargarDatos();
    }

    public void ver(Oferta_laboral e) throws Exception {
        edit = true;
        item = FOferta_laboral.obtener(e.getCodigo());
//para que se carge los datos en los select
        for (Empresa ta : lst_empresa) {
            if (ta.getCodigo() == item.getEmpresa().getCodigo()) {
                item.setEmpresa(ta);
            }
        }
        for (Tipo_cargo ta : lst_tipoCargo) {
            if (ta.getCodigo() == item.getTipo_cargo().getCodigo()) {
                item.setTipo_cargo(ta);
            }
        }
        for (Tipo_sueldo ta : lst_tipoSueldo) {
            if (ta.getCodigo() == item.getTipo_sueldo().getCodigo()) {
                item.setTipo_sueldo(ta);
            }
        }
    }

    private void cargarDatos() throws Exception {
        lst_ofertaLaboral.clear();
        lst_ofertaLaboral = FOferta_laboral.obtener();
        lst_empresa.clear();
        lst_empresa = FEmpresa.obtener();
        lst_tipoCargo.clear();
        lst_tipoCargo = FTipo_cargo.obtener();
        lst_tipoSueldo.clear();
        lst_tipoSueldo = FTipo_sueldo.obtener();

    }

    
    //otros

    public Oferta_laboral getItem() {
        return item;
    }

    public void setItem(Oferta_laboral item) {
        this.item = item;
    }

    public ArrayList<Oferta_laboral> getLst_ofertaLaboral() {
        return lst_ofertaLaboral;
    }

    public void setLst_ofertaLaboral(ArrayList<Oferta_laboral> lst_ofertaLaboral) {
        this.lst_ofertaLaboral = lst_ofertaLaboral;
    }

    public ArrayList<Empresa> getLst_empresa() {
        return lst_empresa;
    }

    public void setLst_empresa(ArrayList<Empresa> lst_empresa) {
        this.lst_empresa = lst_empresa;
    }

    public ArrayList<Tipo_cargo> getLst_tipoCargo() {
        return lst_tipoCargo;
    }

    public void setLst_tipoCargo(ArrayList<Tipo_cargo> lst_tipoCargo) {
        this.lst_tipoCargo = lst_tipoCargo;
    }

    public ArrayList<Tipo_sueldo> getLst_tipoSueldo() {
        return lst_tipoSueldo;
    }

    public void setLst_tipoSueldo(ArrayList<Tipo_sueldo> lst_tipoSueldo) {
        this.lst_tipoSueldo = lst_tipoSueldo;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
}
