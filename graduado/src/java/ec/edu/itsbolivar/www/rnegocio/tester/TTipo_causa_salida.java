package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_causa_salida;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_causa_salida;
import java.util.ArrayList;
public class TTipo_causa_salida{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Tipo_causa_salida obj = new Tipo_causa_salida(); 
 obj.setCodigo(1000);
 obj.setNombre("D");
 if (FTipo_causa_salida.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FTipo_causa_salida.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FTipo_causa_salida.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Tipo_causa_salida> lst= FTipo_causa_salida.obtener();
for(Tipo_causa_salida ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FTipo_causa_salida.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}