package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Capacitacion;
import java.util.ArrayList;
public class FCapacitacion{


 public static boolean insertar(Capacitacion obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into capacitacion values (?,?,?,?,?,?)";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


lstpar.add(new Parametro(2,obj.getTipo_capacitacion().getCodigo()));

//campos sin referencias

 lstpar.add(new Parametro(1,obj.getCodigo()));
 lstpar.add(new Parametro(3,obj.getNombre()));
 lstpar.add(new Parametro(4,obj.getHoras()));
 lstpar.add(new Parametro(5,obj.getCaracteristica()));
 lstpar.add(new Parametro(6,obj.getFecha()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean modificar(Capacitacion obj ) throws  Exception { 
 boolean band= false;
 String sql = "update capacitacion set codigo=?,cod_tipocapacitacion=?,nombre=?,horas=?,caracteristica=?,fecha=? where codigo=?  ";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


lstpar.add(new Parametro(2,obj.getTipo_capacitacion().getCodigo()));

//campos sin referencias

 lstpar.add(new Parametro(1,obj.getCodigo()));
 lstpar.add(new Parametro(7,obj.getCodigo()));
 lstpar.add(new Parametro(3,obj.getNombre()));
 lstpar.add(new Parametro(4,obj.getHoras()));
 lstpar.add(new Parametro(5,obj.getCaracteristica()));
 lstpar.add(new Parametro(6,obj.getFecha()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean eliminar(Capacitacion obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from capacitacion where codigo=? ";
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



 public static Capacitacion obtener (int pcodigo) throws Exception  {  
 Capacitacion miCapacitacion = null;
try{ 
 String sql = "select codigo,cod_tipocapacitacion,nombre,horas,caracteristica,fecha from capacitacion where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Capacitacion> lst=llenarCapacitacions(rs);
 for (Capacitacion c : lst){
 miCapacitacion= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miCapacitacion;
}


 public static ArrayList<Capacitacion> obtener () throws Exception  {  
 ArrayList<Capacitacion> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,cod_tipocapacitacion,nombre,horas,caracteristica,fecha from capacitacion; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarCapacitacions(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Capacitacion> llenarCapacitacions(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Capacitacion> lst = new ArrayList<Capacitacion>();
 Capacitacion obj=null;
try { 
  while(cr.next()){
 obj = new Capacitacion();

//campos con referencias


obj.setTipo_capacitacion(FTipo_capacitacion.obtener(cr.getInt(2)));

//campos sin referencias

obj.setCodigo(cr.getInt(1));
obj.setNombre(cr.getString(3));
obj.setHoras(cr.getInt(4));
obj.setCaracteristica(cr.getString(5));
obj.setFecha(cr.getLong(6));
lst.add(obj);

 }
} catch (Exception ex) { 
throw ex;}
 return lst;}


}