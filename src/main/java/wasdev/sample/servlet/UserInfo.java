package wasdev.sample.servlet;


import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<UserInformation> listOfUsers = new ArrayList<UserInformation>();
        try{
            conn = DataBaseConnector.Connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("Select * from userinfo");
            
            while(rs.next()){
            	String name = rs.getString("user_name");
            	int age = rs.getInt("user_age");
            	listOfUsers.add(new UserInformation(name, age));
            }            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error Trace in getConnection() : " + e.getMessage());
        }
        finally{
        	if(conn != null){
        		try{
                	conn.close();
                	stmt.close();
                	rs.close();
        		}
        		catch(SQLException ex){
        			ex.printStackTrace();
        		}
        	}
        }
        PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<script type=\"text/javascript\">");  
        out.println("alert('deadbeef');");  
        out.println("</script>");
        response.getWriter().print("Hello from user info!" );//+ listOfUsers.get(0).Name);
    }
    
}
