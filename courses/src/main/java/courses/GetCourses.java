package courses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class GetCourses {
	private static final String URL="jdbc:mysql://localhost:3306/student_demo?useSSl=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER="root";
	private static final String PASS="123456789";
	  public static void getCourseByCode(String code) {
	        Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            con = DriverManager.getConnection(URL, USER, PASS);

	            String sql = "SELECT id, coursecode, coursename FROM courses WHERE coursecode = ?";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, code);

	            rs = ps.executeQuery();

	            if (rs.next()) {
	                System.out.println("Course ID   : " + rs.getInt("id"));
	                System.out.println("Course Code : " + rs.getString("coursecode"));
	                System.out.println("Course Name : " + rs.getString("coursename"));
	            } else {
	                System.out.println("No course found with code: " + code);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try { if (rs != null) rs.close(); } catch (Exception e) {}
	            try { if (ps != null) ps.close(); } catch (Exception e) {}
	            try { if (con != null) con.close(); } catch (Exception e) {}
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter Course Code: ");
	        String code = sc.nextLine();

	        getCourseByCode(code);

	        sc.close();
	    }
	}
