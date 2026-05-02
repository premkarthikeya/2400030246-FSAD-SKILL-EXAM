package courses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertFees {
	private static final String URL="jdbc:mysql://localhost:3306/student_demo?useSSl=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER="root";
	private static final String PASS="123456789";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 try {
	            System.out.print("Enter Student ID: ");
	            long id = sc.nextLong();
	            sc.nextLine();

	            System.out.print("Enter Student Name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter Fee Paid: ");
	            int feePaid = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter Status (Paid / Pending): ");
	            String status = sc.nextLine();

	            String sql = "INSERT INTO fees (id, name, feepaid, status) VALUES (?, ?, ?, ?)";

	            try (
	                Connection con = DriverManager.getConnection(URL, USER, PASS);
	                PreparedStatement ps = con.prepareStatement(sql);
	            ) {

	                ps.setLong(1, id);
	                ps.setString(2, name);
	                ps.setInt(3, feePaid);
	                ps.setString(4, status);

	                int rows = ps.executeUpdate();
	                System.out.println("Inserted Rows = " + rows);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            sc.close();
	        }

	}

}
