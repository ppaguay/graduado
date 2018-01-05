/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.recursos.SaveFile;
import ec.edu.itsbolivar.www.rnegocio.clases.Estado_civil;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_licencia;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEstado_civil;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FPersonal;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_licencia;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.ocpsoft.pretty.faces.url.URL;
import com.sun.faces.facelets.util.Path;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author XL
 */
@ManagedBean
@ViewScoped
public class templateGraduadosController {

    boolean modal = false;
    Graduado item = new Graduado();

    ArrayList<Estado_civil> lst_estadoCivil = new ArrayList<>();
    ArrayList<Tipo_licencia> lst_TipoLicencia = new ArrayList<>();
    String fecha = "";

    public templateGraduadosController() {
        try {
            cargardatos();
        } catch (Exception e) {
        }
    }

    public void cargardatos() throws IOException, ParseException, Exception {
        item = itemLogueado();
        lst_estadoCivil.clear();
        lst_estadoCivil = FEstado_civil.obtener();
        lst_TipoLicencia.clear();
        lst_TipoLicencia = FTipo_licencia.obtener();

        fecha = convertMillisecondsToString(item.getFecha_nac());
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

    public Graduado itemLogueado() throws IOException {
        Graduado item = (Graduado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("graduado");

        if (item != null) {

        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login");
        }
        return item;

    }

    public void actualizar() throws Exception {
        modal = true;
        item.setFecha_nac(convertStringToDateLong(fecha));
        FGraduado.modificar(item);
    }

    public Graduado getItem() {
        return item;
    }

    public void setItem(Graduado item) {
        this.item = item;
    }

    public boolean isModal() {
        return modal;
    }

    public void setModal(boolean modal) {
        this.modal = modal;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    //for photo
    public void upload(FileUploadEvent event) throws IOException, Exception {
        //"/img/usuarios/" path for image perfil  
        //"/img/logo/" path for image logo of poll
        String urlFoto = SaveFile.copyFile(event.getFile().getFileName(), event.getFile().getInputstream(),"/img/foto/img");
        item.setFoto(urlFoto);
        FGraduado.modificar(item);
        System.out.println("correct");
        // FacesContext.getCurrentInstance().getExternalContext().redirect(router.admin);

    }

}
