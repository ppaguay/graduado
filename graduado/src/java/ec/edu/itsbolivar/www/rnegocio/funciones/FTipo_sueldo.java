package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_sueldo;
import java.util.ArrayList;
public class FTipo_sueldo{


 public static boolean insertar(Tipo_sueldo obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into tipo_sueldo values (?,?)";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


//campos sin referencias

 lstpar.add(new Parametro(1,obj.getCodigo()));
 lstpar.add(new Parametro(2,obj.getRango()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean modificar(Tipo_sueldo obj ) throws  Exception { 
 boolean band= false;
 String sql = "update tipo_sueldo set codigo=?,rango=? where codigo=?  ";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


//campos sin referencias

 lstpar.add(new Parametro(1,obj.getCodigo()));
 lstpar.add(new Parametro(3,obj.getCodigo()));
 lstpar.add(new Parametro(2,obj.getRango()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean eliminar(Tipo_sueldo obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from tipo_sueldo where codigo=? ";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


//campos sin referencias

 lstpar.add(new Parametro(1,obj.getCodigo()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static Tipo_sueldo obtener (int pcodigo) throws Exception  {  
 Tipo_sueldo miTipo_sueldo = null;
try{ 
 String sql = "select codigo,rango from tipo_sueldo where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Tipo_sueldo> lst=llenarTipo_sueldos(rs);
 for (Tipo_sueldo c : lst){
 miTipo_sueldo= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miTipo_sueldo;
}


 public static ArrayList<Tipo_sueldo> obtener () throws Exception  {  
 ArrayList<Tipo_sueldo> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,rango from tipo_sueldo; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarTipo_sueldos(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Tipo_sueldo> llenarTipo_sueldos(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Tipo_sueldo> lst = new ArrayList<Tipo_sueldo>();
 Tipo_sueldo obj=null;
try { 
  while(cr.next()){
 obj = new Tipo_sueldo();

//campos con referencias


//campos sin referencias

obj.setCodigo(cr.getInt(1));
obj.setRango(cr.getString(2));
lst.add(obj);

 }
} catch (Exception ex) { 
throw ex;}
 return lst;}


}