/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author XL
 */
@ManagedBean
@RequestScoped
public class authentication {

    String user;
    String password;
    boolean correct;

    /**
     * Creates a new instance of authentication
     */
    public authentication() {
    }
// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user_res);

    public void logear() {
        if (user.equals("alex") && password.equals("12345")) {
            System.out.println("correct");
            /*
            if(1){//administrator
            }
            
            if(2){//graduados
            }
            
            if(3){//empresas
            }
            */

        } else {
            FacesContext.getCurrentInstance().addMessage("Warning ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Error de Usuario o Contraseña "));
        }
    }

    public void register() {

        FacesContext.getCurrentInstance().addMessage("Warning ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Correcto "));
        //correct
        System.out.println("Correct");
        correct = true;
    }
    
    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
    
 

}
