package ec.edu.itsbolivar.www.rnegocio.clases;

import java.io.Serializable;

public class Graduado implements Serializable {

    private int codigo;
    private Estado_civil estado_civil;
    private Tipo_licencia tipo_licencia;
    private String nombre;
    private String ci;
    private long fecha_nac;
    private String ciudad_actual;
    private String direccion;
    private String telefono;
    private String celular1;
    private String celular2;
    private String email;
    private String facebook;
    private String clave;
    private String foto;

    public Graduado() {
        foto = "/img/graduado.png";//by default
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Estado_civil getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(Estado_civil estado_civil) {
        this.estado_civil = estado_civil;
    }

    public Tipo_licencia getTipo_licencia() {
        return tipo_licencia;
    }

    public void setTipo_licencia(Tipo_licencia tipo_licencia) {
        this.tipo_licencia = tipo_licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public long getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(long fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCiudad_actual() {
        return ciudad_actual;
    }

    public void setCiudad_actual(String ciudad_actual) {
        this.ciudad_actual = ciudad_actual;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular1() {
        return celular1;
    }

    public void setCelular1(String celular1) {
        this.celular1 = celular1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getClave() {
        return clave;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
