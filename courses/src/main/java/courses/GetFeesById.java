package courses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class GetFeesById {
	private static final String URL="jdbc:mysql://localhost:3306/student_demo?useSSl=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER="root";
	private static final String PASS="123456789";

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        try {
	            System.out.print("Enter Student ID: ");
	            long id = sc.nextLong();   // BIGINT → long

	            String sql = "SELECT id, name, feepaid, status FROM fees WHERE id = ?";

	            try (
	                Connection con = DriverManager.getConnection(URL, USER, PASS);
	                PreparedStatement ps = con.prepareStatement(sql);
	            ) {

	                ps.setLong(1, id);
	                ResultSet rs = ps.executeQuery();

	                if (rs.next()) {
	                    System.out.println("----- Student Fee Details -----");
	                    System.out.println("Student ID : " + rs.getLong("id"));
	                    System.out.println("Name       : " + rs.getString("name"));
	                    System.out.println("Fee Paid   : " + rs.getInt("feepaid"));
	                    System.out.println("Status     : " + rs.getString("status"));
	                } else {
	                    System.out.println("No fee record found for this Student ID.");
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            sc.close();
	        }

	}

}
