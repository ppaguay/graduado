package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Estado_civil;
import java.util.ArrayList;
public class FEstado_civil{


 public static boolean insertar(Estado_civil obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into public.estado_civil values (?,?)";
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



 public static boolean modificar(Estado_civil obj ) throws  Exception { 
 boolean band= false;
 String sql = "update public.estado_civil set codigo=?,nombre=? where codigo=?  ";
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



 public static boolean eliminar(Estado_civil obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from public.estado_civil where codigo=? ";
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



 public static Estado_civil obtener (int pcodigo) throws Exception  {  
 Estado_civil miEstado_civil = null;
try{ 
 String sql = "select codigo,nombre from public.estado_civil where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Estado_civil> lst=llenarEstado_civils(rs);
 for (Estado_civil c : lst){
 miEstado_civil= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miEstado_civil;
}


 public static ArrayList<Estado_civil> obtener () throws Exception  {  
 ArrayList<Estado_civil> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,nombre from public.estado_civil; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarEstado_civils(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Estado_civil> llenarEstado_civils(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Estado_civil> lst = new ArrayList<Estado_civil>();
 Estado_civil obj=null;
try { 
  while(cr.next()){
 obj = new Estado_civil();

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