package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Cursado;
import java.util.ArrayList;
public class FCursado{


 public static boolean insertar(Cursado obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into public.cursado values (?,?)";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


lstpar.add(new Parametro(1,obj.getGraduado().getCodigo()));

lstpar.add(new Parametro(2,obj.getCapacitacion().getCodigo()));

//campos sin referencias

try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean modificar(Cursado obj ) throws  Exception { 
 boolean band= false;
 String sql = "update public.cursado set cod_graduado=?,cod_capacitacion=? where cod_graduado=? and cod_capacitacion=?  ";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


lstpar.add(new Parametro(1,obj.getGraduado().getCodigo()));

lstpar.add(new Parametro(3,obj.getGraduado().getCodigo()));

lstpar.add(new Parametro(2,obj.getCapacitacion().getCodigo()));

lstpar.add(new Parametro(4,obj.getCapacitacion().getCodigo()));

//campos sin referencias

try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean eliminar(Cursado obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from public.cursado where cod_graduado=? and cod_capacitacion=? ";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


lstpar.add(new Parametro(1,obj.getGraduado().getCodigo()));

lstpar.add(new Parametro(2,obj.getCapacitacion().getCodigo()));

//campos sin referencias

try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static Cursado obtener (int pcod_graduado,int pcod_capacitacion) throws Exception  {  
 Cursado miCursado = null;
try{ 
 String sql = "select cod_graduado,cod_capacitacion from public.cursado where   cod_graduado=? and cod_capacitacion=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcod_graduado));
 lstpar.add(new Parametro(2,pcod_capacitacion));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Cursado> lst=llenarCursados(rs);
 for (Cursado c : lst){
 miCursado= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miCursado;
}


 public static ArrayList<Cursado> obtener () throws Exception  {  
 ArrayList<Cursado> lst=new ArrayList<>();
try{ 
 String sql = "select cod_graduado,cod_capacitacion from public.cursado; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarCursados(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Cursado> llenarCursados(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Cursado> lst = new ArrayList<Cursado>();
 Cursado obj=null;
try { 
  while(cr.next()){
 obj = new Cursado();

//campos con referencias


obj.setGraduado(FGraduado.obtener(cr.getInt(1)));

obj.setCapacitacion(FCapacitacion.obtener(cr.getInt(2)));

//campos sin referencias

lst.add(obj);

 }
} catch (Exception ex) { 
throw ex;}
 return lst;}


}