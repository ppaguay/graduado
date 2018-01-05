/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.bean.admin;

import ec.edu.itsbolivar.www.recursos.SaveFile;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Alex
 */
@ManagedBean
@ViewScoped
public class testBean {
   
    public void upload(FileUploadEvent event) throws IOException, Exception {
        //"/img/usuarios/" path for image perfil  
        //"/img/logo/" path for image logo of poll
        String urlFoto = SaveFile.copyFile(event.getFile().getFileName(), event.getFile().getInputstream(), "/img/foto/img");
     
        System.out.println(urlFoto);
        // FacesContext.getCurrentInstance().getExternalContext().redirect(router.admin);

    }
}
