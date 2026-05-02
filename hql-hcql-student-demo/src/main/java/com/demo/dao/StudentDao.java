package com.demo.dao;
import com.demo.entity.Student;
import com.demo.util.HibernateUtil;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.criteria.*;
import java.util.List;
public class StudentDao {
 // HQL: Named parameters
 public List<Student> findByDeptAndMinCgpa_Named(String dept, double minCgpa) {
 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 String hql = "from Student s where s.dept = :dept and s.cgpa >= :minCgpa order by s.cgpa desc";
 return session.createQuery(hql, Student.class)
 .setParameter("dept", dept)
 .setParameter("minCgpa", minCgpa)
 .getResultList();
 }
 }
 // HQL: Positional parameters (?1, ?2)
 public List<Student> findByDeptAndMinCgpa_Positional(String dept, double minCgpa) {
 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 String hql = "from Student s where s.dept = ?1 and s.cgpa >= ?2 order by s.cgpa desc";
 return session.createQuery(hql, Student.class)
 .setParameter(1, dept)
 .setParameter(2, minCgpa)
 .getResultList();
 }
 }
 // HQL: Aggregate functions + GROUP BY
 public List<Tuple> deptWiseSummary_HQL() {
 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 String hql ="select s.dept as dept, count(s.id) as total, avg(s.cgpa) as avgCgpa, max(s.marks) as maxMarks " +
 "from Student s group by s.dept order by avg(s.cgpa) desc";
 return session.createQuery(hql, Tuple.class).getResultList();
 }
 }
 // HQL: Sorting + Paging
 public List<Student> topByMarks_Paged(int pageNo, int pageSize) {
 int first = (pageNo - 1) * pageSize;
 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 String hql = "from Student s order by s.marks desc";
 return session.createQuery(hql, Student.class)
 .setFirstResult(first)
 .setMaxResults(pageSize)
 .getResultList();
 }
 }
 // HCQL (Criteria API): Dept + minCgpa
 public List<Student> findByDeptAndMinCgpa_Criteria(String dept, double minCgpa) {
 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 CriteriaBuilder cb = session.getCriteriaBuilder();
 CriteriaQuery<Student> cq = cb.createQuery(Student.class);
 Root<Student> s = cq.from(Student.class);
 Predicate p1 = cb.equal(s.get("dept"), dept);
 Predicate p2 = cb.greaterThanOrEqualTo(s.get("cgpa"), minCgpa);
 cq.select(s)
 .where(cb.and(p1, p2))
 .orderBy(cb.desc(s.get("cgpa")));
 return session.createQuery(cq).getResultList();
 }
 }
 // HCQL: Aggregates
 public List<Tuple> deptWiseSummary_Criteria() {
 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 CriteriaBuilder cb = session.getCriteriaBuilder();
 CriteriaQuery<Tuple> cq = cb.createTupleQuery();
 Root<Student> s = cq.from(Student.class);
 cq.multiselect(
 s.get("dept").alias("dept"),
 cb.count(s.get("id")).alias("total"),
 cb.avg(s.get("cgpa")).alias("avgCgpa"),
 cb.max(s.get("marks")).alias("maxMarks")
 )
 .groupBy(s.get("dept"))
 .orderBy(cb.desc(cb.avg(s.get("cgpa"))));
 return session.createQuery(cq).getResultList();
 }
 }
 // HCQL: Paging
 public List<Student> topByMarks_Paged_Criteria(int pageNo, int pageSize) {
 int first = (pageNo - 1) * pageSize;
 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 CriteriaBuilder cb = session.getCriteriaBuilder();
 CriteriaQuery<Student> cq = cb.createQuery(Student.class);
 Root<Student> s = cq.from(Student.class);
 cq.select(s).orderBy(cb.desc(s.get("marks")));
 TypedQuery<Student> q = session.createQuery(cq);
 q.setFirstResult(first);
 q.setMaxResults(pageSize);
 return q.getResultList();
 }
 }
 // Optional: insert from Java (if needed)
 public void save(Student student) {
 Transaction tx = null;
 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
 tx = session.beginTransaction();
 session.persist(student);
 tx.commit();
 } catch (Exception e) {
 if (tx != null) tx.rollback();
 throw e;
 }
 }
}