package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Parametro;
import java.util.ArrayList;
public class FParametro{


 public static boolean insertar(Parametro obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into parametro values (?,?,?)";
ArrayList<ec.edu.itsbolivar.www.accesodatos.Parametro> lstpar= new ArrayList<ec.edu.itsbolivar.www.accesodatos.Parametro>();

//campos con referencias


//campos sin referencias

 lstpar.add(new ec.edu.itsbolivar.www.accesodatos.Parametro(1,obj.getCodigo()));
 lstpar.add(new ec.edu.itsbolivar.www.accesodatos.Parametro(2,obj.getValor()));
 lstpar.add(new ec.edu.itsbolivar.www.accesodatos.Parametro(3,obj.getDescripcion()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean modificar(Parametro obj ) throws  Exception { 
 boolean band= false;
 String sql = "update parametro set codigo=?,valor=?,descripcion=? where codigo=?  ";
ArrayList<ec.edu.itsbolivar.www.accesodatos.Parametro> lstpar= new ArrayList<ec.edu.itsbolivar.www.accesodatos.Parametro>();

//campos con referencias


//campos sin referencias

 lstpar.add(new ec.edu.itsbolivar.www.accesodatos.Parametro(1,obj.getCodigo()));
 lstpar.add(new ec.edu.itsbolivar.www.accesodatos.Parametro(4,obj.getCodigo()));
 lstpar.add(new ec.edu.itsbolivar.www.accesodatos.Parametro(2,obj.getValor()));
 lstpar.add(new ec.edu.itsbolivar.www.accesodatos.Parametro(3,obj.getDescripcion()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean eliminar(Parametro obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from parametro where codigo=? ";
ArrayList<ec.edu.itsbolivar.www.accesodatos.Parametro> lstpar= new ArrayList<>();

//campos con referencias


//campos sin referencias

 lstpar.add(new ec.edu.itsbolivar.www.accesodatos.Parametro(1,obj.getCodigo()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static Parametro obtener (int pcodigo) throws Exception  {  
 Parametro miParametro = null;
try{ 
 String sql = "select codigo,valor,descripcion from parametro where   codigo=? ";
ArrayList<ec.edu.itsbolivar.www.accesodatos.Parametro> lstpar = new ArrayList<>();
 lstpar.add(new ec.edu.itsbolivar.www.accesodatos.Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Parametro> lst=llenarParametros(rs);
 for (Parametro c : lst){
 miParametro= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miParametro;
}


 public static ArrayList<Parametro> obtener () throws Exception  {  
 ArrayList<Parametro> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,valor,descripcion from parametro; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarParametros(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Parametro> llenarParametros(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Parametro> lst = new ArrayList<>();
Parametro obj=null;
try { 
  while(cr.next()){
 obj = new Parametro();

//campos con referencias


//campos sin referencias

obj.setCodigo(cr.getInt(1));
obj.setValor(cr.getInt(2));
obj.setDescripcion(cr.getString(3));
lst.add(obj);

 }
} catch (Exception ex) { 
throw ex;}
 return lst;}


}