/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEmpresa;
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
    boolean modal =false;

    public empresasController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(empresasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertar() throws Exception {
       // FEmpresa.insertar(empresa);
    }

    public void actualizar() throws Exception {
        FEmpresa.modificar(empresa);
    }

    public void eliminar() throws Exception {
        FEmpresa.eliminar(empresa);
    }

    private void cargarDatos() throws Exception {
        lst_empresa = FEmpresa.obtener();
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

}
