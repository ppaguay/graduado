/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Capacitacion;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_actividad;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_capacitacion;
import ec.edu.itsbolivar.www.rnegocio.funciones.FCapacitacion;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_actividad;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_capacitacion;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class capacitacionController {

    Capacitacion item = new Capacitacion();
    ArrayList<Capacitacion> lst_capacitacion = new ArrayList<>();
    ArrayList<Tipo_capacitacion> lst_tipo_capacitacion = new ArrayList<>();
    boolean modal = false;
    boolean edit = false;
    String fecha = "";

    public capacitacionController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(capacitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertar() throws Exception {
        item.setFecha(convertStringToDateLong(fecha));
        FCapacitacion.insertar(item);
        modal = true;
        cargarDatos();
    }

    public void actualizar() throws Exception {
        modal = true;
        item.setFecha(convertStringToDateLong(fecha));
        FCapacitacion.modificar(item);
    }

    public void eliminar(Capacitacion e) throws Exception {
        System.err.println("eliminado");
        FCapacitacion.eliminar(e);
        cargarDatos();
    }

    public void ver(Capacitacion e) throws Exception {
        edit = true;
        item = FCapacitacion.obtener(e.getCodigo());
        fecha = convertMillisecondsToString(item.getFecha());
        System.out.println("tipo:Actividad" + item.getTipo_capacitacion().getNombre());
        for (Tipo_capacitacion ta : lst_tipo_capacitacion) {
            if (ta.getCodigo() == item.getTipo_capacitacion().getCodigo()) {
                item.setTipo_capacitacion(ta);
            }

        }
    }

    private void cargarDatos() throws Exception {
        lst_capacitacion.clear();
        lst_capacitacion = FCapacitacion.obtener();
        lst_tipo_capacitacion.clear();
        lst_tipo_capacitacion = FTipo_capacitacion.obtener();
        fecha = optenerfechaActual();
        System.out.println("Datos Cargados");
    }

    public Capacitacion getCapacitacion() {
        return item;
    }

    public void setCapacitacion(Capacitacion item) {
        this.item = item;
    }

    public void activeNew() {
        item = new Capacitacion();
        edit = false;
    }
    
    
    public String optenerfechaActual() throws ParseException {
        LocalDate localDate = LocalDate.now();
        return DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate).toString();

    }

    public String convertDateToString(Date fecha) {

        Format formatter = new SimpleDateFormat("yyyy-mm-dd");
        String s = formatter.format(fecha);
        return s;

    }

    private Long convertStringToDateLong(String fecha) throws ParseException {

        DateFormat format = new SimpleDateFormat("yyy-MM-dd");
        Date date = format.parse(fecha);
        return date.getTime();
    }

    public String convertMillisecondsToString(long fecha) throws ParseException {
        String dateFormat = "yyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(fecha);
        return simpleDateFormat.format(calendar.getTime());
    }

    //otros
    public Capacitacion getItem() {
        return item;
    }

    public void setItem(Capacitacion item) {
        this.item = item;
    }

    public ArrayList<Capacitacion> getLst_capacitacion() {
        return lst_capacitacion;
    }

    public void setLst_capacitacion(ArrayList<Capacitacion> lst_capacitacion) {
        this.lst_capacitacion = lst_capacitacion;
    }

    public ArrayList<Tipo_capacitacion> getLst_tipo_capacitacion() {
        return lst_tipo_capacitacion;
    }

    public void setLst_tipo_capacitacion(ArrayList<Tipo_capacitacion> lst_tipo_capacitacion) {
        this.lst_tipo_capacitacion = lst_tipo_capacitacion;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
