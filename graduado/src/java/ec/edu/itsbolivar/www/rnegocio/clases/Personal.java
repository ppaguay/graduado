package ec.edu.itsbolivar.www.rnegocio.clases;

import java.io.Serializable;

public class Personal implements Serializable{

    private int codigo;
    private Tipo_personal tipo_personal;
    private String nombre;
    private String clave;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Tipo_personal getTipo_personal() {
        return tipo_personal;
    }

    public void setTipo_personal(Tipo_personal tipo_personal) {
        this.tipo_personal = tipo_personal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
