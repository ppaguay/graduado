/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Capacitacion;
import ec.edu.itsbolivar.www.rnegocio.clases.Cursado;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;

import ec.edu.itsbolivar.www.rnegocio.funciones.FCapacitacion;
import ec.edu.itsbolivar.www.rnegocio.funciones.FCursado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
public class cursandoController {

    Cursado item = new Cursado();
    ArrayList<Cursado> lst_cursado = new ArrayList<>();
    ArrayList<Capacitacion> lst_capacitacion = new ArrayList<>();
    ArrayList<Graduado> lst_graduado = new ArrayList<>();
    boolean modal = false;
    boolean edit = false;

    public cursandoController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(capacitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertar() throws Exception {
        FCursado.insertar(item);
        modal = true;
        cargarDatos();
    }

    public void actualizar() throws Exception {
        modal = true;
        FCursado.modificar(item);
    }

    public void eliminar(Cursado e) throws Exception {
        System.err.println("eliminado");
        FCursado.eliminar(e);
        cargarDatos();
    }

    public void ver(Cursado e) throws Exception {
        edit = true;
        item = FCursado.obtener(e.getGraduado().getCodigo(), e.getCapacitacion().getCodigo());

        //System.out.println("tipo:Actividad" + item.getTipo_capacitacion().getNombre());
        for (Capacitacion ta : lst_capacitacion) {
            if (ta.getCodigo() == item.getCapacitacion().getCodigo()) {
                item.setCapacitacion(ta);
            }

        }
        for (Graduado ta : lst_graduado) {
            if (ta.getCodigo() == item.getGraduado().getCodigo()) {
                item.setGraduado(ta);
            }

        }
    }

    private void cargarDatos() throws Exception {
        lst_cursado.clear();
        lst_cursado = FCursado.obtener();
        lst_capacitacion.clear();
        lst_capacitacion = FCapacitacion.obtener();
        lst_graduado.clear();
        lst_graduado = FGraduado.obtener();
        System.out.println("Datos Cargados");
    }

    public Cursado getCursado() {
        return item;
    }

    public void setCursado(Cursado item) {
        this.item = item;
    }

    public void activeNew() {
        item = new Cursado();
        edit = false;
    }
    public String convertMillisecondsToString(long fecha) throws ParseException {
        String dateFormat = "yyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(fecha);
        return simpleDateFormat.format(calendar.getTime());
    }
    
    //otros 

    public Cursado getItem() {
        return item;
    }

    public void setItem(Cursado item) {
        this.item = item;
    }

    public ArrayList<Cursado> getLst_cursado() {
        return lst_cursado;
    }

    public void setLst_cursado(ArrayList<Cursado> lst_cursado) {
        this.lst_cursado = lst_cursado;
    }

    public ArrayList<Capacitacion> getLst_capacitacion() {
        return lst_capacitacion;
    }

    public void setLst_capacitacion(ArrayList<Capacitacion> lst_capacitacion) {
        this.lst_capacitacion = lst_capacitacion;
    }

    public ArrayList<Graduado> getLst_graduado() {
        return lst_graduado;
    }

    public void setLst_graduado(ArrayList<Graduado> lst_graduado) {
        this.lst_graduado = lst_graduado;
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
