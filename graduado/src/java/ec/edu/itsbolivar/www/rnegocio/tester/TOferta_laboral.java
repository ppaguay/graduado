package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Oferta_laboral;
import ec.edu.itsbolivar.www.rnegocio.funciones.FOferta_laboral;
import java.util.ArrayList;
public class TOferta_laboral{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Oferta_laboral obj = new Oferta_laboral(); 
 obj.setCodigo(1000);
//obj.setClase();
//obj.setClase();
//obj.setClase();
 obj.setCaract_cargo("D");
 obj.setExperiencia("D");
 if (FOferta_laboral.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FOferta_laboral.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FOferta_laboral.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Oferta_laboral> lst= FOferta_laboral.obtener();
for(Oferta_laboral ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FOferta_laboral.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}