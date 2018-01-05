/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.recursos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author XL
 */
public class SaveFile {

//get path real of de´proyect or where is the app running in tomcat  by example D:\proyect\app\web\
    public static String getPathSave(String subPath) throws URISyntaxException {

        // ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        // System.out.println(servletContext.getRealPath(""));
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        //String path = servletContext.getRealPath("/img/logo/");
        // String path = servletContext.getRealPath("/img/usuarios/");
        String path = servletContext.getRealPath(subPath);
        return path;
    }
//save the fille 
    //the subPath is for save files for example when:??
    //"/img/usuarios/" path for image perfil  
    //"/img/logo/" path for imagelogo of poll

    public static String copyFile(String fileName, InputStream in, String subPath) throws Exception {
        String rutaUrlFoto = "";
        try {
            String destination = getPathSave(subPath);//subdirectorio subPath
            OutputStream out = new FileOutputStream(new File(destination + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            System.out.println("the file  created with success!");
            Date dte = new Date();
            long milliSeconds = dte.getTime();

            String ruta1 = destination + fileName;
            String ruta2 = destination + milliSeconds + fileName;
            rutaUrlFoto = subPath + milliSeconds + fileName;//url for web

            System.out.println("File: " + ruta1 + " Rename to: " + ruta2);

            File archivo = new File(ruta1);
            archivo.renameTo(new File(ruta2));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            return rutaUrlFoto;
        }
    }

}
