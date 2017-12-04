package ec.edu.itsbolivar.www.rnegocio.clases;
public class Empresa { 
	private  int codigo; 
	private  Tipo_actividad tipo_actividad; 
	private  String nombre; 
	private  String direccion; 
	private  String telefono; 
	private  String usuario; 
	private  String pertenece; 

 public int getCodigo() {
return codigo;}

public void setCodigo(int codigo) {this.codigo= codigo;}

 public Tipo_actividad getTipo_actividad() {
return tipo_actividad;}

public void setTipo_actividad(Tipo_actividad tipo_actividad) {this.tipo_actividad= tipo_actividad;}

 public String getNombre() {
return nombre;}

public void setNombre(String nombre) {this.nombre= nombre;}

 public String getDireccion() {
return direccion;}

public void setDireccion(String direccion) {this.direccion= direccion;}

 public String getTelefono() {
return telefono;}

public void setTelefono(String telefono) {this.telefono= telefono;}

 public String getUsuario() {
return usuario;}

public void setUsuario(String usuario) {this.usuario= usuario;}

 public String getPertenece() {
return pertenece;}

public void setPertenece(String pertenece) {this.pertenece= pertenece;}
}
