package wasdev.sample.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DataBaseConnector {
   
   public static java.sql.Connection Connect(){

		String connectionUrl = "jdbc:postgresql://echo-01.db.elephantsql.com:5432/mvyxtiao";
		String userName = "mvyxtiao";
		String password = "hWaNiH-BX20jn6DS4cytcb5M9fgWdQAc";
	   Connection con = null;
       try{
            Class.forName("org.postgresql.Driver"); 
            con = java.sql.DriverManager.getConnection(connectionUrl,userName,password);
            if(con!=null) System.out.println("Connection Successful!");           
            
       }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
      }
       return con;
   }
   
}