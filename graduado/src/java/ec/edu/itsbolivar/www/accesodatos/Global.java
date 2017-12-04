/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolivar.www.accesodatos;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author root
 */
public final  class Global {   
   //java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("evaluacion.accesodatos.database"); 
    java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("ec.edu.itsbolivar.www.accesodatos.database");  
    private String URL=Configuracion.getString("url");
    private String DRIVER = Configuracion.getString("driver");
    private String USER = Configuracion.getString("user");
    private String PASS = Configuracion.getString("password");

    /**
     * @return the URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * @return the DRIVER
     */
    public String getDRIVER() {
        return DRIVER;
    }

    /**
     * @param DRIVER the DRIVER to set
     */
    public void setDRIVER(String DRIVER) {
        this.DRIVER = DRIVER;
    }

    /**
     * @return the USER
     */
    public String getUSER() {
        return USER;
    }

    /**
     * @param USER the USER to set
     */
    public void setUSER(String USER) {
        this.USER = USER;
    }

    /**
     * @return the PASS
     */
    public String getPASS() {
        return PASS;
    }

    /**
     * @param PASS the PASS to set
     */
    public void setPASS(String PASS) {
        this.PASS = PASS;
    }
}
