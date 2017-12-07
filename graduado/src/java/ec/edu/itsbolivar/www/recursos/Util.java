package ec.edu.itsbolivar.www.recursos;

import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class Util {

    public Util() {
    }
    
    public static void addErrorMessage(  String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Transacción errónea", msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addOKMessage( String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Transacción exitosa", msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static void addErrorFatalMessage( String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Transacción errónea", msg);
        FacesContext.getCurrentInstance().addMessage("fatalInfo", facesMsg);
    }

    public static void addWarningMessage( String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", msg);
        FacesContext.getCurrentInstance().addMessage("warningInfo", facesMsg);
    }
}
