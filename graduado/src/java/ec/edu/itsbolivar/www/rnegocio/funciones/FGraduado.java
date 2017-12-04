package ec.edu.itsbolivar.www.rnegocio.funciones;
import ec.edu.itsbolivar.www.accesodatos.*;
import ec.edu.itsbolivar.www.rnegocio.clases.Graduado;
import java.util.ArrayList;
public class FGraduado{


 public static boolean insertar(Graduado obj ) throws  Exception { 
 boolean band= false;
 String sql = "insert into graduado values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


lstpar.add(new Parametro(2,obj.getEstado_civil().getCodigo()));

lstpar.add(new Parametro(3,obj.getTipo_licencia().getCodigo()));

//campos sin referencias

 lstpar.add(new Parametro(1,obj.getCodigo()));
 lstpar.add(new Parametro(4,obj.getNombre()));
 lstpar.add(new Parametro(5,obj.getCi()));
 lstpar.add(new Parametro(6,obj.getFecha_nac()));
 lstpar.add(new Parametro(7,obj.getCiudad_actual()));
 lstpar.add(new Parametro(8,obj.getDireccion()));
 lstpar.add(new Parametro(9,obj.getTelefono()));
 lstpar.add(new Parametro(10,obj.getCelular1()));
 lstpar.add(new Parametro(11,obj.getCelular2()));
 lstpar.add(new Parametro(12,obj.getEmail()));
 lstpar.add(new Parametro(13,obj.getFacebook()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean modificar(Graduado obj ) throws  Exception { 
 boolean band= false;
 String sql = "update graduado set codigo=?,cod_estadocivil=?,cod_tipolicencia=?,nombre=?,ci=?,fecha_nac=?,ciudad_actual=?,direccion=?,telefono=?,celular1=?,celular2=?,email=?,facebook=? where codigo=?  ";
ArrayList<Parametro> lstpar= new ArrayList<Parametro>();

//campos con referencias


lstpar.add(new Parametro(2,obj.getEstado_civil().getCodigo()));

lstpar.add(new Parametro(3,obj.getTipo_licencia().getCodigo()));

//campos sin referencias

 lstpar.add(new Parametro(1,obj.getCodigo()));
 lstpar.add(new Parametro(14,obj.getCodigo()));
 lstpar.add(new Parametro(4,obj.getNombre()));
 lstpar.add(new Parametro(5,obj.getCi()));
 lstpar.add(new Parametro(6,obj.getFecha_nac()));
 lstpar.add(new Parametro(7,obj.getCiudad_actual()));
 lstpar.add(new Parametro(8,obj.getDireccion()));
 lstpar.add(new Parametro(9,obj.getTelefono()));
 lstpar.add(new Parametro(10,obj.getCelular1()));
 lstpar.add(new Parametro(11,obj.getCelular2()));
 lstpar.add(new Parametro(12,obj.getEmail()));
 lstpar.add(new Parametro(13,obj.getFacebook()));
try { 
   band = AccesoDatos.ejecutaComando1(sql, lstpar);
} catch (Exception ex) { 
throw ex;}
 return band; 
}



 public static boolean eliminar(Graduado obj ) throws  Exception { 
 boolean band= false;
 String sql = "delete from graduado where codigo=? ";
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



 public static Graduado obtener (int pcodigo) throws Exception  {  
 Graduado miGraduado = null;
try{ 
 String sql = "select codigo,cod_estadocivil,cod_tipolicencia,nombre,ci,fecha_nac,ciudad_actual,direccion,telefono,celular1,celular2,email,facebook from graduado where   codigo=? ";
ArrayList<Parametro> lstpar = new ArrayList<Parametro>();
 lstpar.add(new Parametro(1,pcodigo));
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql,lstpar);
ArrayList<Graduado> lst=llenarGraduados(rs);
 for (Graduado c : lst){
 miGraduado= c;
 } 

} catch (Exception ex) { 
throw ex; }
return  miGraduado;
}


 public static ArrayList<Graduado> obtener () throws Exception  {  
 ArrayList<Graduado> lst=new ArrayList<>();
try{ 
 String sql = "select codigo,cod_estadocivil,cod_tipolicencia,nombre,ci,fecha_nac,ciudad_actual,direccion,telefono,celular1,celular2,email,facebook from graduado; ";
ConjuntoResultado rs= AccesoDatos.ejecutaQuery(sql);
 lst=llenarGraduados(rs);

} catch (Exception ex) { 
throw ex; }
return  lst;
}


 private static ArrayList<Graduado> llenarGraduados(ConjuntoResultado cr)  throws  Exception { 
 ArrayList<Graduado> lst = new ArrayList<Graduado>();
 Graduado obj=null;
try { 
  while(cr.next()){
 obj = new Graduado();

//campos con referencias


obj.setEstado_civil(FEstado_civil.obtener(cr.getInt(2)));

obj.setTipo_licencia(FTipo_licencia.obtener(cr.getInt(3)));

//campos sin referencias

obj.setCodigo(cr.getInt(1));
obj.setNombre(cr.getString(4));
obj.setCi(cr.getString(5));
obj.setFecha_nac(cr.getLong(6));
obj.setCiudad_actual(cr.getString(7));
obj.setDireccion(cr.getString(8));
obj.setTelefono(cr.getString(9));
obj.setCelular1(cr.getString(10));
obj.setCelular2(cr.getString(11));
obj.setEmail(cr.getString(12));
obj.setFacebook(cr.getString(13));
lst.add(obj);

 }
} catch (Exception ex) { 
throw ex;}
 return lst;}


}