package ec.edu.itsbolivar.www.tester;
import ec.edu.itsbolivar.www.rnegocio.clases.Empresa;
import ec.edu.itsbolivar.www.rnegocio.funciones.FEmpresa;
import java.util.ArrayList;
public class TEmpresa{


 public static void main(String[] args ) throws  Exception { 
	//Prueba de insertado
 Empresa obj = new Empresa(); 
 obj.setCodigo(1000);
//obj.setClase();
 obj.setNombre("D");
 obj.setDireccion("D");
 obj.setTelefono("D");
 obj.setUsuario("D");
 obj.setPertenece("D");
 if (FEmpresa.insertar(obj)) {
     System.out.println("Insertado correctamente");
 } else {
     System.out.println("Error al insertar");
 }
	//prueba obtener por codigo
obj=FEmpresa.obtener(1000);
if(obj!=null){
    System.out.println("Correcto obtener por codigo:"+obj.toString());
}else{
    System.out.println("Error obtener por codigo");}
	//Prueba de modificado
//Atributo a modificar
//obj.setAtributo();
if(FEmpresa.modificar(obj))
   System.out.println("Modificacion correcta");
else
    System.out.println("Error al modificar");
	//Prueba de listar
System.out.println("Listar");
ArrayList<Empresa> lst= FEmpresa.obtener();
for(Empresa ob: lst){
  //Atributos a imprimir 
  //System.out.println(ob.getNombre());
};
	//Prueba de eliminar
if(FEmpresa.eliminar(obj))
System.out.println("Eliminacion correcta");
 else
 System.out.println("Error al eliminar");
}

}