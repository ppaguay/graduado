package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_licencia;
import java.util.ArrayList;
public class FTipo_licencia{


 public static boolean insertar(Tipo_licencia obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into public.tipo_licencia values (?,?)";
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



 public static boolean modificar(Tipo_licencia obj ) throws  Exception { 
 boolean band= false;
 String sql = "update public.tipo_licencia set codigo=?,nombre=? where codigo=?  ";
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



 public static boolean eliminar(Tipo_licencia obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from public.tipo_licencia where codigo=? ";
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



 public static Tipo_licencia obtener (int pcodigo) throws Exception  {  
 Tipo_licencia miTipo_licencia = null;
try{ 
 String sql = "select codigo,nombre from public.tipo_licencia where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Tipo_licencia> lst=llenarTipo_licencias(rs);
 for (Tipo_licencia c : lst){
 miTipo_licencia= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miTipo_licencia;
}


 public static ArrayList<Tipo_licencia> obtener () throws Exception  {  
 ArrayList<Tipo_licencia> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,nombre from public.tipo_licencia; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarTipo_licencias(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Tipo_licencia> llenarTipo_licencias(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Tipo_licencia> lst = new ArrayList<Tipo_licencia>();
 Tipo_licencia obj=null;
try { 
  while(cr.next()){
 obj = new Tipo_licencia();

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