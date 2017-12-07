/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.clases.Estado_civil;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Personal;

import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_licencia;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_sueldo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEstado_civil;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FPersonal;

import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_licencia;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_sueldo;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author XL
 */
@ManagedBean
@ViewScoped
public class graduadosController {

    Graduado item = new Graduado();
    ArrayList<Graduado> lst_graduados = new ArrayList<>();
    ArrayList<Estado_civil> lst_estadoCivil = new ArrayList<>();
    ArrayList<Tipo_licencia> lst_TipoLicencia = new ArrayList<>();
    String fecha = "";

    boolean modal = false;
    boolean edit = false;

    public graduadosController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(ofertaLaboralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void activeNew() {
        item = new Graduado();
        edit = false;
    }

    public void insertar() throws Exception {

        boolean existe = false;
        for (Graduado p : FGraduado.obtener()) {

            if (p.getCi().equals(item.getCi())) {
                existe = true;
            }

        }
        if (existe == false) {
            item.setFecha_nac(convertStringToDateLong(fecha));
            FGraduado.insertar(item);

            modal = true;
            cargarDatos();
            
        } else {
            FacesContext.getCurrentInstance().addMessage("Warning ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Usuario Ya Existe"));
        }
    }

    public void actualizar() throws Exception {
        modal = true;
        item.setFecha_nac(convertStringToDateLong(fecha));
        FGraduado.modificar(item);
    }

    public void eliminar(Graduado e) throws Exception {
        System.err.println("eliminado");

        FGraduado.eliminar(e);
        cargarDatos();
    }

    public void ver(Graduado e) throws Exception {
        edit = true;
        item = FGraduado.obtener(e.getCodigo());
        fecha = convertMillisecondsToString(item.getFecha_nac());
//para que se carge los datos en los select
        for (Estado_civil ta : lst_estadoCivil) {
            if (ta.getCodigo() == item.getEstado_civil().getCodigo()) {
                item.setEstado_civil(ta);
            }
        }
        for (Tipo_licencia ta : lst_TipoLicencia) {
            if (ta.getCodigo() == item.getTipo_licencia().getCodigo()) {
                item.setTipo_licencia(ta);
            }
        }

    }

    private void cargarDatos() throws Exception {

        lst_graduados.clear();
        lst_graduados = FGraduado.obtener();
        lst_estadoCivil.clear();
        lst_estadoCivil = FEstado_civil.obtener();
        lst_TipoLicencia.clear();
        lst_TipoLicencia = FTipo_licencia.obtener();
        fecha = optenerfechaActual();
        System.out.println("" + fecha);

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

    private String convertMillisecondsToString(long fecha) throws ParseException {
        String dateFormat = "yyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(fecha);
        return simpleDateFormat.format(calendar.getTime());
    }

    //otros
    public Graduado getItem() {
        return item;
    }

    public void setItem(Graduado item) {
        this.item = item;
    }

    public ArrayList<Graduado> getLst_graduados() {
        return lst_graduados;
    }

    public void setLst_graduados(ArrayList<Graduado> lst_graduados) {
        this.lst_graduados = lst_graduados;
    }

    public ArrayList<Estado_civil> getLst_estadoCivil() {
        return lst_estadoCivil;
    }

    public void setLst_estadoCivil(ArrayList<Estado_civil> lst_estadoCivil) {
        this.lst_estadoCivil = lst_estadoCivil;
    }

    public ArrayList<Tipo_licencia> getLst_TipoLicencia() {
        return lst_TipoLicencia;
    }

    public void setLst_TipoLicencia(ArrayList<Tipo_licencia> lst_TipoLicencia) {
        this.lst_TipoLicencia = lst_TipoLicencia;
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
