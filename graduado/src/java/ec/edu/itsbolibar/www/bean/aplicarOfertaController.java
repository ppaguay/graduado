/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Aplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Aplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_causa_salida;
import ec.edu.itsbolivar.www.rnegocio.funciones.FAplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FOferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_causa_salida;
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
public class aplicarOfertaController {

    Aplicar_oferta item = new Aplicar_oferta();

    ArrayList<Aplicar_oferta> lst_aplica_oferta = new ArrayList<>();
    ArrayList<Graduado> lst_graduados = new ArrayList<>();
    ArrayList<Oferta_laboral> lst_oferta_laboral = new ArrayList<>();

    String fecha_aplica = "";
    String fecha_inicio = "";

    boolean modal = false;
    boolean edit = false;

    public aplicarOfertaController() {
        try {
            cargarDatos();
        } catch (Exception ex) {
            Logger.getLogger(historiaLaboralController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void activeNew() {
        item = new Aplicar_oferta();
        edit = false;
    }

    public void insertar() throws Exception {
        item.setFecha_inicio(convertStringToDateLong(fecha_inicio));
        item.setFecha_aplica(convertStringToDateLong(fecha_aplica));
        FAplicar_oferta.insertar(item);

        modal = true;
        cargarDatos();
    }

    public void actualizar() throws Exception {
        modal = true;
        item.setFecha_inicio(convertStringToDateLong(fecha_inicio));
        item.setFecha_aplica(convertStringToDateLong(fecha_aplica));
        System.out.println("Modificando"+item.getGraduado().getNombre()+item.getOferta_laboral().getEmpresa().getNombre());
        FAplicar_oferta.modificar(item);
    }

    public void eliminar(Aplicar_oferta e) throws Exception {
        System.err.println("eliminado");

        FAplicar_oferta.eliminar(e);
        cargarDatos();
    }

    public void ver(Aplicar_oferta e) throws Exception {
        edit = true;
        item = FAplicar_oferta.obtener(e.getGraduado().getCodigo(), e.getOferta_laboral().getCodigo());
        fecha_inicio = convertMillisecondsToString(item.getFecha_inicio());
        fecha_aplica = convertMillisecondsToString(item.getFecha_aplica());
//para que se carge los datos en los select
        for (Graduado ta : lst_graduados) {
            if (ta.getCodigo() == item.getGraduado().getCodigo()) {
                item.setGraduado(ta);
            }
        }
        for (Graduado ta : lst_graduados) {
            if (ta.getCodigo() == item.getGraduado().getCodigo()) {
                item.setGraduado(ta);
            }
        }
        for (Oferta_laboral ta : lst_oferta_laboral) {
            if (ta.getCodigo() == item.getOferta_laboral().getCodigo()) {
                item.setOferta_laboral(ta);
            }
        }

    }

    private void cargarDatos() throws Exception {

        lst_graduados.clear();
        lst_graduados = FGraduado.obtener();
        lst_oferta_laboral.clear();
        lst_oferta_laboral = FOferta_laboral.obtener();
        lst_aplica_oferta.clear();
        lst_aplica_oferta = FAplicar_oferta.obtener();
        fecha_aplica = optenerfechaActual();
        fecha_inicio = optenerfechaActual();
        System.out.println("" + fecha_inicio);

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

    public Aplicar_oferta getItem() {
        return item;
    }

    public void setItem(Aplicar_oferta item) {
        this.item = item;
    }

    public ArrayList<Aplicar_oferta> getLst_aplica_oferta() {
        return lst_aplica_oferta;
    }

    public void setLst_aplica_oferta(ArrayList<Aplicar_oferta> lst_aplica_oferta) {
        this.lst_aplica_oferta = lst_aplica_oferta;
    }

    public ArrayList<Graduado> getLst_graduados() {
        return lst_graduados;
    }

    public void setLst_graduados(ArrayList<Graduado> lst_graduados) {
        this.lst_graduados = lst_graduados;
    }

    public ArrayList<Oferta_laboral> getLst_oferta_laboral() {
        return lst_oferta_laboral;
    }

    public void setLst_oferta_laboral(ArrayList<Oferta_laboral> lst_oferta_laboral) {
        this.lst_oferta_laboral = lst_oferta_laboral;
    }

    public String getFecha_aplica() {
        return fecha_aplica;
    }

    public void setFecha_aplica(String fecha_aplica) {
        this.fecha_aplica = fecha_aplica;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
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
