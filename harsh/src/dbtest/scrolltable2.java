package dbtest;

import java.sql.*;

public class scrolltable2 {

	public static void main(String[]args) {
		String url="jdbc:mysql://localhost:3306/employeesdb";
		String username="root";
		String password="12345";
		
		try (Connection conn = DriverManager.getConnection(url,username,password)) {
			
			String sql="SELECT * FROM employee";
			Statement statement =conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet result = statement.executeQuery(sql);
			result.first();
			readempInfo("first",result);
			result.relative(3);
			readempInfo("relative(3)",result);
			result.previous();
			readempInfo("previous",result);
			result.absolute(4);
			readempInfo("absolute(4)",result);
			result.last();
			readempInfo("last",result);
			result.relative(-2);
			readempInfo("relative(-2)",result);
			
			
		}catch( SQLException e) {
			e.printStackTrace();
			
		}
	}

	private static void readempInfo(String position, ResultSet result)  
		// TODO Auto-generated method stub
		throws SQLException{
			String id= result.getString("id");
			String name=result.getString("name");
			String occupation=result.getString("occupation");
			String  age=result.getString("age");
			
			
			String empInfo="%s: %s- %s- %s- %s\n";
			System.out.format(empInfo,position,id,name,occupation,age);
		}
		
	}
   
