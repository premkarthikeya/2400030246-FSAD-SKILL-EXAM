package courses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class InsertResult {
	private static final String URL="jdbc:mysql://localhost:3306/student_demo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
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

            System.out.print("Enter Subject: ");
            String subject = sc.nextLine();

            System.out.print("Enter Grade: ");
            String grade = sc.nextLine();

            System.out.print("Enter Total Marks: ");
            int totalMarks = sc.nextInt();

            String sql = "INSERT INTO result (id, name, subject, grade, total_marks) VALUES (?, ?, ?, ?, ?)";

            try (
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement ps = con.prepareStatement(sql);
            ) {

                ps.setLong(1, id);
                ps.setString(2, name);
                ps.setString(3, subject);
                ps.setString(4, grade);
                ps.setInt(5, totalMarks);

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
