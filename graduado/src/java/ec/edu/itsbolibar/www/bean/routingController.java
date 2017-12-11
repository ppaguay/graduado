/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itsbolibar.www.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author XL
 */
@ManagedBean
@RequestScoped
public class routingController {

    /**
     * Creates a new instance of routingController
     */
    public routingController() {
    }

    public String getPathProyect() {
        return router.pathProyect;
    }

    public String getError404() {
        return router.error404;
    }

    public String getError500() {
        return router.error500;
    }

    public String getLogout() {
        return router.logout;
    }
    public String getEmpresas () {
        return router.empresas ;
    }
    public String getOfertaLaboral () {
        return router.ofertaLaboral ;
    }
    public String getGraduados () {
        return router.graduados ;
    }
    public String getHistoriaLaboral () {
        return router.historiaLaboral ;
    }
    public String getAplicarOferta () {
        return router.aplicarOferta ;
    }
    public String getCapacitacion () {
        return router.capacitacion ;
    }
    public String getCursado () {
        return router.cursado ;
    }
    public String getPersonal () {
        return router.personal ;
    }
    public String getResultadoAll () {
        return router.resultadoAll ;
    }
    public String getTipoactividad () {
        return router.tipoactividad ;
    }
    public String getTipocapacitacion () {
        return router.tipocapacitacion;
    }
    public String getTipocargo  () {
        return router.tipocargo ;
    }
    public String getTipocausasalida () {
        return router.tipocausasalida ;
    }
    public String getTipolicencia () {
        return router.tipolicencia ;
    }
    public String getTipopersonal () {
        return router.tipopersonal ;
    }
    public String getTiposueldo () {
        return router.tiposueldo ;
    }
    public String getAdminEmpresa () {
        return router.adminEmpresa ;
    }
    public String getOfertaTrabajo () {
        return router.ofertaTrabajo ;
    }
    public String getResultadoOfertaTrabajo  () {
        return router.resultadoOfertaTrabajo  ;
    }
    public String getRevisarOfertas  () {
        return router.revisarOfertas  ;
    }
    public String getAdminGraduado  () {
        return router.adminGraduado  ;
    }
    //graduado
    
    public String getGraduadoAplicarOferta  () {
        return router.graduadoAplicarOferta  ;
    }
    public String getgraduadoCapacitacion  () {
        return router.graduadoCapacitacion  ;
    }
    public String getGraduadoHistoriaLaboral  () {
        return router.graduadoHistoriaLaboral  ;
    }
    public String getGraduadoResultados  () {
        return router.graduadoResultados  ;
    }


}
