package ec.edu.itsbolivar.www.rnegocio.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import ec.edu.itsbolivar.www.rnegocio.funciones.FGraduado;
import java.util.ArrayList;
public class TGraduado{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Graduado obj = new Graduado(); 
 obj.setCodigo(1000);
//obj.setClase();
//obj.setClase();
 obj.setNombre("D");
 obj.setCi("D");
 //obj.setFecha_nac("D");
 obj.setCiudad_actual("D");
 obj.setDireccion("D");
 obj.setTelefono("D");
 obj.setCelular1("D");
 obj.setCelular2("D");
 obj.setEmail("D");
 obj.setFacebook("D");
 if (FGraduado.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FGraduado.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FGraduado.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Graduado> lst= FGraduado.obtener();
for(Graduado ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FGraduado.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}