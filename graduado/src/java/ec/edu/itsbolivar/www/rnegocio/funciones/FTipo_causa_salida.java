package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Tipo_causa_salida;
import java.util.ArrayList;
public class FTipo_causa_salida{


 public static boolean insertar(Tipo_causa_salida obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into tipo_causa_salida values (?,?)";
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



 public static boolean modificar(Tipo_causa_salida obj ) throws  Exception { 
 boolean band= false;
 String sql = "update tipo_causa_salida set codigo=?,nombre=? where codigo=?  ";
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



 public static boolean eliminar(Tipo_causa_salida obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from tipo_causa_salida where codigo=? ";
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



 public static Tipo_causa_salida obtener (int pcodigo) throws Exception  {  
 Tipo_causa_salida miTipo_causa_salida = null;
try{ 
 String sql = "select codigo,nombre from tipo_causa_salida where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Tipo_causa_salida> lst=llenarTipo_causa_salidas(rs);
 for (Tipo_causa_salida c : lst){
 miTipo_causa_salida= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miTipo_causa_salida;
}


 public static ArrayList<Tipo_causa_salida> obtener () throws Exception  {  
 ArrayList<Tipo_causa_salida> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,nombre from tipo_causa_salida; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarTipo_causa_salidas(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Tipo_causa_salida> llenarTipo_causa_salidas(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Tipo_causa_salida> lst = new ArrayList<Tipo_causa_salida>();
 Tipo_causa_salida obj=null;
try { 
  while(cr.next()){
 obj = new Tipo_causa_salida();

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