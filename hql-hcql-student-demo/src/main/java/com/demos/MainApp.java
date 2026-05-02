package com.demos;
import com.demo.dao.StudentDao;
import com.demo.util.HibernateUtil;
import jakarta.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
public class MainApp {
 public static void main(String[] args) {
 StudentDao dao = new StudentDao();
 System.out.println("\n1) HQL Named Params: CSE, minCgpa=7.5");
 dao.findByDeptAndMinCgpa_Named("CSE", 7.5).forEach(System.out::println);
 System.out.println("\n2) HQL Positional Params: IT, minCgpa=7.0");
 dao.findByDeptAndMinCgpa_Positional("IT", 7.0).forEach(System.out::println);
 System.out.println("\n3) HQL Aggregates (Dept wise):");
 for (Tuple t : dao.deptWiseSummary_HQL()) {
 System.out.println(
 "Dept=" + t.get("dept") +
 ", Total=" + t.get("total") +
 ", AvgCgpa=" + String.format("%.2f", (Double) t.get("avgCgpa")) +
 ", MaxMarks=" + t.get("maxMarks")
 );
 }
 System.out.println("\n4) HQL Sorting + Paging: page=1, size=3 (Top Marks)");
 dao.topByMarks_Paged(1, 3).forEach(System.out::println);
 System.out.println("\n5) HCQL Criteria: ECE, minCgpa=7.0");
 dao.findByDeptAndMinCgpa_Criteria("ECE", 7.0).forEach(System.out::println);
 System.out.println("\n6) HCQL Aggregates (Dept wise):");
 for (Tuple t : dao.deptWiseSummary_Criteria()) {
 System.out.println(
 "Dept=" + t.get("dept") +
 ", Total=" + t.get("total") +
 ", AvgCgpa=" + String.format("%.2f", (Double) t.get("avgCgpa")) +
 ", MaxMarks=" + t.get("maxMarks")
 );
 }
 System.out.println("\n7) HCQL Paging: page=2, size=3 (Top Marks)");
 dao.topByMarks_Paged_Criteria(2, 3).forEach(System.out::println);
 HibernateUtil.shutdown();
 }
}