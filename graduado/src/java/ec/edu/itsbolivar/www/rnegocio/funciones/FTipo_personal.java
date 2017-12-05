package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_personal;
import java.util.ArrayList;
public class FTipo_personal{


 public static boolean insertar(Tipo_personal obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into public.tipo_personal values (?,?)";
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



 public static boolean modificar(Tipo_personal obj ) throws  Exception { 
 boolean band= false;
 String sql = "update public.tipo_personal set codigo=?,nombre=? where codigo=?  ";
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



 public static boolean eliminar(Tipo_personal obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from public.tipo_personal where codigo=? ";
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



 public static Tipo_personal obtener (int pcodigo) throws Exception  {  
 Tipo_personal miTipo_personal = null;
try{ 
 String sql = "select codigo,nombre from public.tipo_personal where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Tipo_personal> lst=llenarTipo_personals(rs);
 for (Tipo_personal c : lst){
 miTipo_personal= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miTipo_personal;
}


 public static ArrayList<Tipo_personal> obtener () throws Exception  {  
 ArrayList<Tipo_personal> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,nombre from public.tipo_personal; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarTipo_personals(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Tipo_personal> llenarTipo_personals(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Tipo_personal> lst = new ArrayList<Tipo_personal>();
 Tipo_personal obj=null;
try { 
  while(cr.next()){
 obj = new Tipo_personal();

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