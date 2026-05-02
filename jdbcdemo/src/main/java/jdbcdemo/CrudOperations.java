package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CrudOperations {
	private static final String URL="jdbc:mysql://localhost:3306/student_demo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER="root";
	private static final String PASS="123456789";

	public static void main(String[] args) {
		String sql="INSERT INTO students(name,email) VALUES (?,?)";
		try(
				Connection con=DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement ps=con.prepareStatement(sql);
				)
		{
			ps.setString(1,"kohli");
			ps.setString(2,"kohli18@kluniversity.in");
			int row=ps.executeUpdate();
			System.out.println("Inserted Rows="+row);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
