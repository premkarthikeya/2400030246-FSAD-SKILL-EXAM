package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertStudent {
	private static final String URL="jdbc:mysql://localhost:3306/student_demo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER="root";
	private static final String PASS="123456789";

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Course Code:");
		String courseCode=sc.nextLine();
		System.out.print("Enter Course Name:");
		String courseName=sc.nextLine();
		String sql="INSERT INTO courses(coursecode,coursename) VALUES (?,?)";
		try

	}

}
