/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Estado_civil;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Historia_laboral;
import ec.edu.itsbolivar.www.rnegocio.clases.Historia_laboral;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_causa_salida;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_licencia;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEstado_civil;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FHistoria_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_causa_salida;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_licencia;
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
public class historiaLaboralController {

    Historia_laboral item = new Historia_laboral();
    ArrayList<Historia_laboral> lst_historia_laboral = new ArrayList<>();
    ArrayList<Graduado> lst_graduados = new ArrayList<>();
    ArrayList<Tipo_causa_salida> lst_causa_salida = new ArrayList<>();
    ArrayList<Tipo_cargo> lst_tipo_cargo = new ArrayList<>();
    String fechaInicio = "";
    String fechaFin = "";

    boolean modal = false;
    boolean edit = false;

    public historiaLaboralController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(historiaLaboralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void activeNew() {
        item = new Historia_laboral();
        edit = false;
    }

    public void insertar() throws Exception {
        item.setFechafin(convertStringToDateLong(fechaFin));
        item.setFechainicio(convertStringToDateLong(fechaInicio));
        FHistoria_laboral.insertar(item);

        modal = true;
        cargarDatos();
    }

    public void actualizar() throws Exception {
        modal = true;
        item.setFechafin(convertStringToDateLong(fechaFin));
        item.setFechainicio(convertStringToDateLong(fechaInicio));
        FHistoria_laboral.modificar(item);
    }

    public void eliminar(Historia_laboral e) throws Exception {
        System.err.println("eliminado");

        FHistoria_laboral.eliminar(e);
        cargarDatos();
    }

    public void ver(Historia_laboral e) throws Exception {
        edit = true;
        item = FHistoria_laboral.obtener(e.getCodigo());
        fechaFin = convertMillisecondsToString(item.getFechafin());
        fechaInicio = convertMillisecondsToString(item.getFechainicio());
//para que se carge los datos en los select
        for (Graduado ta : lst_graduados) {
            if (ta.getCodigo() == item.getGraduado().getCodigo()) {
                item.setGraduado(ta);
            }
        }
        for (Tipo_causa_salida ta : lst_causa_salida) {
            if (ta.getCodigo() == item.getTipo_causa_salida().getCodigo()) {
                item.setTipo_causa_salida(ta);
            }
        }
        for (Tipo_cargo ta : lst_tipo_cargo) {
            if (ta.getCodigo() == item.getTipo_cargo().getCodigo()) {
                item.setTipo_cargo(ta);
            }
        }

    }

    private void cargarDatos() throws Exception {

        lst_graduados.clear();
        lst_graduados = FGraduado.obtener();
        lst_causa_salida.clear();
        lst_causa_salida = FTipo_causa_salida.obtener();
        lst_tipo_cargo.clear();
        lst_tipo_cargo = FTipo_cargo.obtener();
        lst_historia_laboral.clear();
        lst_historia_laboral = FHistoria_laboral.obtener();
        fechaInicio = optenerfechaActual();
        fechaFin = optenerfechaActual();
        System.out.println("" + fechaFin);

    }
//fin S

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

    public Historia_laboral getItem() {
        return item;
    }

    public void setItem(Historia_laboral item) {
        this.item = item;
    }

    public ArrayList<Historia_laboral> getLst_historia_laboral() {
        return lst_historia_laboral;
    }

    public void setLst_historia_laboral(ArrayList<Historia_laboral> lst_historia_laboral) {
        this.lst_historia_laboral = lst_historia_laboral;
    }

    public ArrayList<Graduado> getLst_graduados() {
        return lst_graduados;
    }

    public void setLst_graduados(ArrayList<Graduado> lst_graduados) {
        this.lst_graduados = lst_graduados;
    }

    public ArrayList<Tipo_causa_salida> getLst_causa_salida() {
        return lst_causa_salida;
    }

    public void setLst_causa_salida(ArrayList<Tipo_causa_salida> lst_causa_salida) {
        this.lst_causa_salida = lst_causa_salida;
    }

    public ArrayList<Tipo_cargo> getLst_tipo_cargo() {
        return lst_tipo_cargo;
    }

    public void setLst_tipo_cargo(ArrayList<Tipo_cargo> lst_tipo_cargo) {
        this.lst_tipo_cargo = lst_tipo_cargo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
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
