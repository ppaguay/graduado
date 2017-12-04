package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Personal;
import ec.edu.itsbolivar.www.rnegocio.funciones.FPersonal;
import java.util.ArrayList;
public class TPersonal{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Personal obj = new Personal(); 
 obj.setCodigo(1000);
//obj.setClase();
 obj.setNombre("D");
 obj.setClave("D");
 if (FPersonal.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FPersonal.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FPersonal.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Personal> lst= FPersonal.obtener();
for(Personal ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FPersonal.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}