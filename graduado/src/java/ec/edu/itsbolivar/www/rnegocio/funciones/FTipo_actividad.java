package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_actividad;
import java.util.ArrayList;
public class FTipo_actividad{


 public static boolean insertar(Tipo_actividad obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into tipo_actividad values (?,?)";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


//campos sin referencias

 lstpar.add(new Parametro(1,obj.getCodigo()));
 lstpar.add(new Parametro(2,obj.getNombre()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean modificar(Tipo_actividad obj ) throws  Exception { 
 boolean band= false;
 String sql = "update tipo_actividad set codigo=?,nombre=? where codigo=?  ";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


//campos sin referencias

 lstpar.add(new Parametro(1,obj.getCodigo()));
 lstpar.add(new Parametro(3,obj.getCodigo()));
 lstpar.add(new Parametro(2,obj.getNombre()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean eliminar(Tipo_actividad obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from tipo_actividad where codigo=? ";
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



 public static Tipo_actividad obtener (int pcodigo) throws Exception  {  
 Tipo_actividad miTipo_actividad = null;
try{ 
 String sql = "select codigo,nombre from tipo_actividad where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Tipo_actividad> lst=llenarTipo_actividads(rs);
 for (Tipo_actividad c : lst){
 miTipo_actividad= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miTipo_actividad;
}


 public static ArrayList<Tipo_actividad> obtener () throws Exception  {  
 ArrayList<Tipo_actividad> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,nombre from tipo_actividad; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarTipo_actividads(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Tipo_actividad> llenarTipo_actividads(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Tipo_actividad> lst = new ArrayList<Tipo_actividad>();
 Tipo_actividad obj=null;
try { 
  while(cr.next()){
 obj = new Tipo_actividad();

//campos con referencias


//campos sin referencias

obj.setCodigo(cr.getInt(1));
obj.setNombre(cr.getString(2));
lst.add(obj);

 }
} catch (Exception ex) { 
throw ex;}
 return lst;}


}