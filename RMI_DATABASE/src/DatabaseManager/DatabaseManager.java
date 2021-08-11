package DatabaseManager;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


//package DatabaseManager;

public class DatabaseManager {
   

    
    //gym connection starts
	private static Connection con;
    
	static{
		try{
			init();
		}catch(Exception e){
		}
	}
	private static void init()throws Exception{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                String path="D:\\RMI\\RMI.accdb";
                String url = "jdbc:ucanaccess://"+path;      
                con=DriverManager.getConnection(url);
                System.out.println("Connection Successful");            
	}
        

	public static int add(String name,String fName,String surname)throws Exception{
	    
            String query="INSERT into registration (name,fname,surname) values ('"+name+"','"+fName+"','"+surname+"')";
		System.out.println(query);
		
		Statement st=null;
		try{
			st=con.createStatement();
			int rows=st.executeUpdate(query);
			return rows;
		}finally{
			if (st!=null)
			st.close();
		}
	}
        
        
}
     