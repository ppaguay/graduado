/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.edu.itsbolivar.www.accesodatos;
import java.sql.*;
  
/**
 *
 * @author ULVIER
 */
public  class Conexion
{
    public  String driver;  
    public  String url;
    public  String user;
    public String pass;
    public Connection con;
    public PreparedStatement prStm;
    public ResultSet rs;

	

	public String getDriver(){	
		return this.driver;
	}

	public String getUrl(){	
		return this.url;
	}
	public String getUser(){
		return this.user;
	}

	public void setUser(String user){
		this.user=user;
	}

	public void setPassword(String pass){
		this.pass=pass;
	}

	public  Conexion() throws Exception{
    Global global = new Global();
        try {
            Class.forName(global.getDRIVER());//    donde wsta el driver a cargar
         con = DriverManager.getConnection(global.getURL(),global.getUSER(),global.getPASS());
        } catch (Exception e) {
            throw  e; 
        }
	} 
//ResultSet
// contiene todas las filas que satisfacen las condiciones de una sentencia SQL y proporciona el acceso a los datos de estas filas mediante un conjunto de métodos get que permiten el acceso a las diferentes columnas de la filas
    public ResultSet ejecutaQuery(String sql) throws SQLException, ClassNotFoundException
    {
         rs = null;      
            try {
                // sirve para procesar una sentencia SQL estática y obtener los resultados producidos por ella
             Statement st = con.createStatement();           
             rs = st.executeQuery(sql);
         

        } catch (SQLException exConec) {
              throw  exConec;
            }
      
         return rs;
    }

     public int ejecutaQueryEscalar(String sql) throws Exception
      {
        int res=0;
       
            try {       
             Statement st = con.createStatement();
             res = st.executeUpdate(sql);
           
        } catch (SQLException exConec) {
                throw  exConec;
            }
      
       
         return res;
      }
         public boolean ejecutaPreparedComando(PreparedStatement prStm) throws Exception
        {
            //La sentencia SQL contenida en un objeto PreparedStatement pueden tener uno o más parámetros IN. Un parámetro IN es aquel cuyo valor no se especifica en la sentencia SQL cuando se crea. En vez de ello la sentencia tiene un interrogante (‘?’)
       int i=-1;
            try {
            i= prStm.executeUpdate();
        } catch (SQLException exConec) {
               throw  exConec;

        }
       if(i>0)
           return true;
       else
           return false;
        }

          public int ejecutaPreparedInt(PreparedStatement prStm) throws Exception
        {
       int i=-1;
            try {

             rs= prStm.executeQuery();
             while(rs.next())
            {
                i=rs.getInt(1);

             }
           

        } catch (SQLException exConec) {
               throw  exConec;

        }
        return i;
        }

       public ResultSet ejecutaPrepared(PreparedStatement prStm) throws Exception
        {
        rs=null;
            try {
              rs =prStm.executeQuery();

        } catch (SQLException exConec) {
                throw exConec;
        }
        return rs;
        }


         public PreparedStatement creaPreparedSmt(String sql) throws Exception
        {
       prStm=null;
    
       
            try {
              prStm = con.prepareStatement(sql);
          } catch (SQLException exConec) {
           throw  exConec;
            }
    
         return prStm;
        }

         public void desconectar () throws Exception
         {
             try
             {           
            con.close();
            con=null;
             }
             catch(Exception ex)
             {
                 throw ex;
             }
         }




}

