/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_actividad;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEmpresa;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_actividad;
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
public class empresasController {

    Empresa empresa = new Empresa();
    ArrayList<Empresa> lst_empresa = new ArrayList<>();
    ArrayList<Tipo_actividad> lst_tipo_actividad = new ArrayList<>();
    boolean modal = false;
    boolean edit = false;

    public empresasController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(empresasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertar() throws Exception {
        FEmpresa.insertar(empresa);
        modal = true;
        cargarDatos();
    }

    public void actualizar() throws Exception {
        modal=true;
        FEmpresa.modificar(empresa);
    }

    public void eliminar(Empresa e) throws Exception {
        System.err.println("eliminado");
        FEmpresa.eliminar(e);
        cargarDatos();
    }

    public void ver(Empresa e) throws Exception {
        edit = true;
        empresa = FEmpresa.obtener(e.getCodigo());
        
        System.out.println("tipo:Actividad"+empresa.getTipo_actividad().getNombre());
        for ( Tipo_actividad ta: lst_tipo_actividad ) {
            if(ta.getCodigo()==empresa.getTipo_actividad().getCodigo()){
                empresa.setTipo_actividad(ta);
            }
            
        }
    }

    private void cargarDatos() throws Exception {
        lst_empresa.clear();
        lst_empresa = FEmpresa.obtener();
        lst_tipo_actividad.clear();
        lst_tipo_actividad = FTipo_actividad.obtener();
        System.out.println("Datos Cargados");
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ArrayList<Empresa> getLst_empresa() {
        return lst_empresa;
    }

    public void setLst_empresa(ArrayList<Empresa> lst_empresa) {
        this.lst_empresa = lst_empresa;
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

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public void activeNew() {
        empresa= new Empresa();
        edit = false;
    }

}
