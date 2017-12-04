package ec.edu.itsbolivar.www.rnegocio.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Capacitacion;
import ec.edu.itsbolivar.www.rnegocio.funciones.FCapacitacion;
import java.util.ArrayList;
public class TCapacitacion{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Capacitacion obj = new Capacitacion(); 
 obj.setCodigo(1000);
//obj.setClase();
 obj.setNombre("D");
 obj.setHoras(1000);
 obj.setCaracteristica("D");
//obj.setFecha("D");
 if (FCapacitacion.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FCapacitacion.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FCapacitacion.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Capacitacion> lst= FCapacitacion.obtener();
for(Capacitacion ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FCapacitacion.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}