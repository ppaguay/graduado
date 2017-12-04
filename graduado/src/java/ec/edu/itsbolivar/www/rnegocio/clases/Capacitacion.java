package ec.edu.itsbolivar.www.rnegocio.clases;
public class Capacitacion { 
	private  int codigo; 
	private  Tipo_capacitacion tipo_capacitacion; 
	private  String nombre; 
	private  int horas; 
	private  String caracteristica; 
	private  Long fecha; 

 public int getCodigo() {
return codigo;}

public void setCodigo(int codigo) {this.codigo= codigo;}

 public Tipo_capacitacion getTipo_capacitacion() {
return tipo_capacitacion;}

public void setTipo_capacitacion(Tipo_capacitacion tipo_capacitacion) {this.tipo_capacitacion= tipo_capacitacion;}

 public String getNombre() {
return nombre;}

public void setNombre(String nombre) {this.nombre= nombre;}

 public int getHoras() {
return horas;}

public void setHoras(int horas) {this.horas= horas;}

 public String getCaracteristica() {
return caracteristica;}

public void setCaracteristica(String caracteristica) {this.caracteristica= caracteristica;}

 public Long getFecha() {
return fecha;}

public void setFecha(Long fecha) {this.fecha= fecha;}
}
