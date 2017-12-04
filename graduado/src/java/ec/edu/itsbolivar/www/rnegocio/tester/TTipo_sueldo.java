package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_sueldo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_sueldo;
import java.util.ArrayList;
public class TTipo_sueldo{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Tipo_sueldo obj = new Tipo_sueldo(); 
 obj.setCodigo(1000);
 obj.setRango("D");
 if (FTipo_sueldo.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FTipo_sueldo.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FTipo_sueldo.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Tipo_sueldo> lst= FTipo_sueldo.obtener();
for(Tipo_sueldo ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FTipo_sueldo.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}