package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Cursado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FCursado;
import java.util.ArrayList;
public class TCursado{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Cursado obj = new Cursado(); 
//obj.setClase();
//obj.setClase();
 if (FCursado.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FCursado.obtener(1000,1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FCursado.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Cursado> lst= FCursado.obtener();
for(Cursado ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FCursado.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}