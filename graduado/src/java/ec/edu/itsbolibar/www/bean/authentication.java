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
        Empresa empresaLog= new Empresa();
        Graduado graduadoLog= new Graduado();
        Tipo_personal tipo_personal = new Tipo_personal();//1 admin /2graduado //3 empresa
        if (tipo_usuario == 1) {//administrador
            Personal personal = new Personal();
            personal.setNombre(user);
            personal.setClave(password);
            boolean correct = false;
            ArrayList<Personal> lst = new ArrayList<>();
            lst = FPersonal.obtener();
            for (Personal item : lst) {
                if (item.getClave().equals(personal.getClave()) && item.getNombre().equals(personal.getNombre())) {
                    correct = true;
                    userLog.setCodigo(item.getCodigo());
                }
            }
            if (correct) {
                userLog.setClave(password);
                userLog.setNombre(user);
                tipo_personal.setCodigo(1);
                userLog.setTipo_personal(tipo_personal);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userLog);

                FacesContext.getCurrentInstance().getExternalContext().redirect("admin");
            } else {
                FacesContext.getCurrentInstance().addMessage("Warning ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Error de Usuario o Contraseña "));
            }
        }
        if (tipo_usuario == 2) {//graduado
            Graduado g = new Graduado();
            g.setCi(user);
            g.setClave(password);

            boolean correct = false;
            ArrayList<Graduado> lst = new ArrayList<>();
            lst = FGraduado.obtener();
            for (Graduado item : lst) {
                if (item.getClave().equals(g.getClave()) && item.getCi().equals(g.getCi())) {
                    correct = true;
                    graduadoLog=item;
                    userLog.setCodigo(item.getCodigo());
                }
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
            ArrayList<Empresa> lst = new ArrayList<>();
            lst = FEmpresa.obtener();
            for (Empresa item : lst) {
                if (item.getClave().equals(empresa.getClave()) && item.getUsuario().equals(empresa.getUsuario())) {
                    correct = true;
                    empresaLog=item;
                    userLog.setCodigo(item.getCodigo());
                }
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
                FacesContext.getCurrentInstance().addMessage("Warning ", new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Error de Usuario o Contraseña "));
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
