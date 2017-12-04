package ec.edu.itsbolivar.www.rnegocio.clases;
public class Oferta_laboral { 
	private  int codigo; 
	private  Empresa empresa; 
	private  Tipo_cargo tipo_cargo; 
	private  Tipo_sueldo tipo_sueldo; 
	private  String caract_cargo; 
	private  String experiencia; 

 public int getCodigo() {
return codigo;}

public void setCodigo(int codigo) {this.codigo= codigo;}

 public Empresa getEmpresa() {
return empresa;}

public void setEmpresa(Empresa empresa) {this.empresa= empresa;}

 public Tipo_cargo getTipo_cargo() {
return tipo_cargo;}

public void setTipo_cargo(Tipo_cargo tipo_cargo) {this.tipo_cargo= tipo_cargo;}

 public Tipo_sueldo getTipo_sueldo() {
return tipo_sueldo;}

public void setTipo_sueldo(Tipo_sueldo tipo_sueldo) {this.tipo_sueldo= tipo_sueldo;}

 public String getCaract_cargo() {
return caract_cargo;}

public void setCaract_cargo(String caract_cargo) {this.caract_cargo= caract_cargo;}

 public String getExperiencia() {
return experiencia;}

public void setExperiencia(String experiencia) {this.experiencia= experiencia;}
}
