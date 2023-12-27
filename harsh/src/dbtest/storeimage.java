package dbtest;
	import java.io.*;
	import java.sql.*;

	public class storeimage {
		public static void main(String[] args) {
		
			String url = "jdbc:mysql://localhost:3306/sports";
			String user = "root";
			String password = "12345";
			
			String filepath = "C:\\harsh\\sirjadeja.jpg";
			try {
				Connection conn= DriverManager.getConnection(url, user, password);
				
				String sql = "INSERT INTO image1 (name,img) values (?,?)";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1,"sirjadeja");
				
				
				FileInputStream inputStream = new FileInputStream(new File(filepath));
				statement.setBlob(2,inputStream);
				
				int row = statement.executeUpdate();
				if (row>0) {
					System.out.println(" A contact was inserted with photo image.");
				}
				conn.close();
			}catch(IOException e1) {
				System.out.println(e1);
				
				
			}					
			 catch(SQLException ex) {
				ex.printStackTrace();
			}
			
				
				
				}
		}


