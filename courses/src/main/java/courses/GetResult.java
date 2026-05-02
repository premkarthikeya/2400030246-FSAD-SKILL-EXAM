package courses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class GetResult {
	private static final String URL="jdbc:mysql://localhost:3306/student_demo?useSSl=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER="root";
	private static final String PASS="123456789";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student ID: ");
            long id = sc.nextLong();

            String sql = "SELECT id, name, subject, grade, total_marks FROM result WHERE id = ?";

            try (
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement ps = con.prepareStatement(sql);
            ) {

                ps.setLong(1, id);
                ResultSet rs = ps.executeQuery();

                boolean found = false;

                while (rs.next()) {
                    if (!found) {
                        System.out.println("----- Student Result -----");
                        System.out.println("Student ID : " + rs.getLong("id"));
                        System.out.println("Name       : " + rs.getString("name"));
                        found = true;
                    }

                    System.out.println("Subject    : " + rs.getString("subject"));
                    System.out.println("Grade      : " + rs.getString("grade"));
                    System.out.println("Marks      : " + rs.getInt("total_marks"));
                    System.out.println("--------------------------");
                }

                if (!found) {
                    System.out.println("No result found for this Student ID.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }

	}

}
