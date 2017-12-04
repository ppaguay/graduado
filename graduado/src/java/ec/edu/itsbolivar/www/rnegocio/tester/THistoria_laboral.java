package ec.edu.itsbolivar.www.rnegocio.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Historia_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FHistoria_laboral;
import java.util.ArrayList;
public class THistoria_laboral{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Historia_laboral obj = new Historia_laboral(); 
 obj.setCodigo(1000);
//obj.setClase();
//obj.setClase();
//obj.setClase();
//obj.setClase();
 //obj.setFechainicio("D");
 //obj.setFechafin("D");
 if (FHistoria_laboral.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FHistoria_laboral.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FHistoria_laboral.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Historia_laboral> lst= FHistoria_laboral.obtener();
for(Historia_laboral ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FHistoria_laboral.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}