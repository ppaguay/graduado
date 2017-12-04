package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_capacitacion;
import ec.edu.itsbolivar.www.rnegocio.funciones.FTipo_capacitacion;
import java.util.ArrayList;
public class TTipo_capacitacion{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Tipo_capacitacion obj = new Tipo_capacitacion(); 
 obj.setCodigo(1000);
 obj.setNombre("D");
 if (FTipo_capacitacion.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FTipo_capacitacion.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FTipo_capacitacion.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Tipo_capacitacion> lst= FTipo_capacitacion.obtener();
for(Tipo_capacitacion ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FTipo_capacitacion.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}