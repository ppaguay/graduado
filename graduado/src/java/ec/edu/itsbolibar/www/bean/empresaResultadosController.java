/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;


import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.clases.Resultado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FResultado;
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
public class empresaResultadosController {

    String grafico_selected = "bar";
    Empresa item = new Empresa();
    ArrayList<Resultado> lst_restultado = new ArrayList();

    public empresaResultadosController() throws Exception {
        try {
            cargarDatos();

        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }

    public void cargarDatos() throws Exception {
        item = itemLogueado();
        lst_restultado = FResultado.obtener(item);
    }

    public Empresa itemLogueado() throws IOException {
        Empresa item = (Empresa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");

        if (item != null) {

        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        }
        System.out.println("usuario encontrado" + item.getNombre());
        return item;

    }

    public String getGrafico_selected() {
        return grafico_selected;
    }

    public void setGrafico_selected(String grafico_selected) {
        this.grafico_selected = grafico_selected;
    }

    public Empresa getItem() {
        return item;
    }

    public void setItem(Empresa item) {
        this.item = item;
    }

    public ArrayList getLst_restultado() {
        return lst_restultado;
    }

    public void setLst_restultado(ArrayList lst_restultado) {
        this.lst_restultado = lst_restultado;
    }

}
