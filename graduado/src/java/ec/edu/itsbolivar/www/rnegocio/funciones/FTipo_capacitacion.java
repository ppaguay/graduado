package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_capacitacion;
import java.util.ArrayList;
public class FTipo_capacitacion{


 public static boolean insertar(Tipo_capacitacion obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into public.tipo_capacitacion values (?,?)";
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



 public static boolean modificar(Tipo_capacitacion obj ) throws  Exception { 
 boolean band= false;
 String sql = "update public.tipo_capacitacion set codigo=?,nombre=? where codigo=?  ";
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



 public static boolean eliminar(Tipo_capacitacion obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from public.tipo_capacitacion where codigo=? ";
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



 public static Tipo_capacitacion obtener (int pcodigo) throws Exception  {  
 Tipo_capacitacion miTipo_capacitacion = null;
try{ 
 String sql = "select codigo,nombre from public.tipo_capacitacion where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Tipo_capacitacion> lst=llenarTipo_capacitacions(rs);
 for (Tipo_capacitacion c : lst){
 miTipo_capacitacion= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miTipo_capacitacion;
}


 public static ArrayList<Tipo_capacitacion> obtener () throws Exception  {  
 ArrayList<Tipo_capacitacion> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,nombre from public.tipo_capacitacion; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarTipo_capacitacions(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Tipo_capacitacion> llenarTipo_capacitacions(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Tipo_capacitacion> lst = new ArrayList<Tipo_capacitacion>();
 Tipo_capacitacion obj=null;
try { 
  while(cr.next()){
 obj = new Tipo_capacitacion();

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