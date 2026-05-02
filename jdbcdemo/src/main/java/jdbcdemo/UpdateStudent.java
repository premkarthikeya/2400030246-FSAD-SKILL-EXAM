package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateStudent {
	private static final String URL="jdbc:mysql://localhost:3306/student_demo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER="root";
	private static final String PASS="123456789";

	public static void main(String[] args) {
		int id=1;
		String email="rr@gmail.com";
		String sql="UPDATE students SET email=? WHERE id=?";
		try(Connection con=DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement ps=con.prepareStatement(sql))
		{
			
			ps.setString(1,email);
			ps.setInt(2,id);
			int rows=ps.executeUpdate();
			System.out.println("Updated Rows="+rows);
		}
		catch(Exception e)
		{
			e.fillInStackTrace();
		}

	}

}
