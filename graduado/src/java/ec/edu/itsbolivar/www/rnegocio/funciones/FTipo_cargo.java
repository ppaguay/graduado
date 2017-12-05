package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_cargo;
import java.util.ArrayList;
public class FTipo_cargo{


 public static boolean insertar(Tipo_cargo obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into public.tipo_cargo values (?,?)";
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



 public static boolean modificar(Tipo_cargo obj ) throws  Exception { 
 boolean band= false;
 String sql = "update public.tipo_cargo set codigo=?,nombre=? where codigo=?  ";
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



 public static boolean eliminar(Tipo_cargo obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from public.tipo_cargo where codigo=? ";
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



 public static Tipo_cargo obtener (int pcodigo) throws Exception  {  
 Tipo_cargo miTipo_cargo = null;
try{ 
 String sql = "select codigo,nombre from public.tipo_cargo where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Tipo_cargo> lst=llenarTipo_cargos(rs);
 for (Tipo_cargo c : lst){
 miTipo_cargo= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miTipo_cargo;
}


 public static ArrayList<Tipo_cargo> obtener () throws Exception  {  
 ArrayList<Tipo_cargo> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,nombre from public.tipo_cargo; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarTipo_cargos(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Tipo_cargo> llenarTipo_cargos(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Tipo_cargo> lst = new ArrayList<Tipo_cargo>();
 Tipo_cargo obj=null;
try { 
  while(cr.next()){
 obj = new Tipo_cargo();

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