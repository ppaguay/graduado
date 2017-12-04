package ec.edu.itsbolivar.www.rnegocio.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Aplicar_oferta;
import ec.edu.itsbolivar.www.rnegocio.funciones.FAplicar_oferta;
import java.util.ArrayList;
public class TAplicar_oferta{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Aplicar_oferta obj = new Aplicar_oferta(); 
//obj.setClase();
//obj.setClase();
 //obj.setFecha_aplica("D");
 obj.setContrato("D");
 //obj.setFecha_inicio("D");
 if (FAplicar_oferta.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FAplicar_oferta.obtener(1000,1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FAplicar_oferta.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Aplicar_oferta> lst= FAplicar_oferta.obtener();
for(Aplicar_oferta ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FAplicar_oferta.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}