package ec.edu.itsbolivar.www.rnegocio.clases;
public class Historia_laboral { 
	private  int codigo; 
	private  Graduado graduado; 
	private  Tipo_causa_salida tipo_causa_salida; 
	private  Tipo_cargo tipo_cargo; 
	private  Empresa empresa; 
	private  Long fechainicio; 
	private  Long fechafin; 

 public int getCodigo() {
return codigo;}

public void setCodigo(int codigo) {this.codigo= codigo;}

 public Graduado getGraduado() {
return graduado;}

public void setGraduado(Graduado graduado) {this.graduado= graduado;}

 public Tipo_causa_salida getTipo_causa_salida() {
return tipo_causa_salida;}

public void setTipo_causa_salida(Tipo_causa_salida tipo_causa_salida) {this.tipo_causa_salida= tipo_causa_salida;}

 public Tipo_cargo getTipo_cargo() {
return tipo_cargo;}

public void setTipo_cargo(Tipo_cargo tipo_cargo) {this.tipo_cargo= tipo_cargo;}

 public Empresa getEmpresa() {
return empresa;}

public void setEmpresa(Empresa empresa) {this.empresa= empresa;}

 public Long getFechainicio() {
return fechainicio;}

public void setFechainicio(Long fechainicio) {this.fechainicio= fechainicio;}

 public Long getFechafin() {
return fechafin;}

public void setFechafin(Long fechafin) {this.fechafin= fechafin;}
}
