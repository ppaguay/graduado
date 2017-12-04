package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Parametro;
import ec.edu.itsbolivar.www.rnegocio.funciones.FParametro;
import java.util.ArrayList;
public class TParametro{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Parametro obj = new Parametro(); 
 obj.setCodigo(1000);
 obj.setValor(1000);
 obj.setDescripcion("D");
 if (FParametro.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FParametro.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FParametro.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Parametro> lst= FParametro.obtener();
for(Parametro ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FParametro.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}