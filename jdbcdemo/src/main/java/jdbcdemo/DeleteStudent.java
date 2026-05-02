package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteStudent {
	private static final String URL="jdbc:mysql://localhost:3306/student_demo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER="root";
	private static final String PASS="123456789";
	public static void main(String[] args) {
		int id=2;
		String sql="DELETE FROM students WHERE id=?";
		try(Connection con=DriverManager.getConnection(URL,USER,PASS);
				PreparedStatement ps=con.prepareStatement(sql)){
			ps.setInt(1,id);
			int rows=ps.executeUpdate();
			System.out.println("Deleted Rows="+rows);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
