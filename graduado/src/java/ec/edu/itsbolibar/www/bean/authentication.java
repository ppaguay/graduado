/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.clases.Personal;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_personal;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEmpresa;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FPersonal;
import java.io.IOException;
import java.util.ArrayList;
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
    int tipo_usuario = 1;

    /**
     * Creates a new instance of authentication
     */
    public authentication() {
    }
// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user_res);

    public void logear() throws Exception {
        Personal userLog = new Personal();
        Empresa empresaLog = new Empresa();
        Graduado graduadoLog = new Graduado();
        Tipo_personal tipo_personal = new Tipo_personal();//1 admin /2graduado //3 empresa
        try {
            if (tipo_usuario == 1) {//administrador
                Personal personal = new Personal();
                personal.setNombre(user);
                personal.setClave(password);
                boolean correct = false;
                Personal tmp = FPersonal.autenticar(user, password);
                if (tmp != null) {
                    System.out.println("Usuario validado!!");
                    correct = true;
                    userLog.setCodigo(tmp.getCodigo());
                }
                if (correct) {
                    userLog.setClave(password);
                    userLog.setNombre(user);
                    tipo_personal.setCodigo(1);
                    userLog.setTipo_personal(tipo_personal);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userLog);

                    FacesContext.getCurrentInstance().getExternalContext().redirect("admin");
                } else {
                    FacesContext.getCurrentInstance().addMessage("Warning ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Error de Usuario o ContraseÃ±a "));
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        if (tipo_usuario == 2) {//graduado
            Graduado g = new Graduado();
            g.setCi(user);
            g.setClave(password);

            boolean correct = false;

            Graduado tmp = FGraduado.autenticar(user, password);

            if (tmp != null) {
                correct = true;
                graduadoLog = tmp;
                userLog.setCodigo(tmp.getCodigo());
            }

            if (correct) {
                userLog.setClave(password);
                userLog.setNombre(user);
                tipo_personal.setCodigo(2);
                userLog.setTipo_personal(tipo_personal);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userLog);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("graduado", graduadoLog);

                FacesContext.getCurrentInstance().getExternalContext().redirect("adminGraduado");
            } else {
                FacesContext.getCurrentInstance().addMessage("Warning ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Error de Usuario o Contraseña "));
            }
        }
        if (tipo_usuario == 3) {//empresa
            Empresa empresa = new Empresa();
            empresa.setUsuario(user);
            empresa.setClave(password);
            boolean correct = false;
            Empresa tmp = FEmpresa.autenticar(user, password);
            if (tmp != null) {
                correct = true;
                empresaLog = tmp;
                userLog.setCodigo(tmp.getCodigo());
            }
            if (correct) {
                userLog.setClave(password);
                userLog.setNombre(user);
                tipo_personal.setCodigo(3);
                userLog.setTipo_personal(tipo_personal);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userLog);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empresa", empresaLog);

                FacesContext.getCurrentInstance().getExternalContext().redirect("adminEmpresa");
            } else {
                FacesContext.getCurrentInstance().addMessage("Warning ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Error de Usuario o ContraseÃ±a "));
            }
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

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

}
