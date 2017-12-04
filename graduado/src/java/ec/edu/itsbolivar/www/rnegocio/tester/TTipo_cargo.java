package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_cargo;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_cargo;
import java.util.ArrayList;
public class TTipo_cargo{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Tipo_cargo obj = new Tipo_cargo(); 
 obj.setCodigo(1000);
 obj.setNombre("D");
 if (FTipo_cargo.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FTipo_cargo.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FTipo_cargo.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Tipo_cargo> lst= FTipo_cargo.obtener();
for(Tipo_cargo ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FTipo_cargo.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}