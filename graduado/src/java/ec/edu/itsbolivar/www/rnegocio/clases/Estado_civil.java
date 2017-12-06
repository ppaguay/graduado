package ec.edu.itsbolivar.www.rnegocio.clases;

import java.io.Serializable;

public class Estado_civil implements Serializable{ 
	private  int codigo; 
	private  String nombre; 

 public int getCodigo() {
return codigo;}

public void setCodigo(int codigo) {this.codigo= codigo;}

 public String getNombre() {
return nombre;}

public void setNombre(String nombre) {this.nombre= nombre;}
}
