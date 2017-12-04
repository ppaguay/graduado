package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Estado_civil;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEstado_civil;
import java.util.ArrayList;
public class TEstado_civil{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Estado_civil obj = new Estado_civil(); 
 obj.setCodigo(1000);
 obj.setNombre("D");
 if (FEstado_civil.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FEstado_civil.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FEstado_civil.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Estado_civil> lst= FEstado_civil.obtener();
for(Estado_civil ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FEstado_civil.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}