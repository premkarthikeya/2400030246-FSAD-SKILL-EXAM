package com.mineops.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mineops.util.HibernateUtil;

public class MineOpsDAO {

    // Generic save
    public void save(Object obj) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(obj);
        tx.commit();
        s.close();
    }

    // UC-CRUD-02: Update Mine Status
    public void updateMineStatus(int mineId, String status) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        Query q = s.createQuery(
            "update MineSite set status=:st where mineId=:id");
        q.setParameter("st", status);
        q.setParameter("id", mineId);
        q.executeUpdate();

        tx.commit();
        s.close();
    }

    // UC-CRUD-04: Transfer Equipment Between Mines
    public void transferEquipment(int equipmentId, int newMineId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        Query q = s.createQuery(
            "update Equipment set mineId=:mid where equipmentId=:eid");
        q.setParameter("mid", newMineId);
        q.setParameter("eid", equipmentId);
        q.executeUpdate();

        tx.commit();
        s.close();
    }

    // UC-CRUD-10: Close Safety Incident
    public void closeIncident(int incidentId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        Query q = s.createQuery(
            "update SafetyIncident set status='CLOSED' where incidentId=:id");
        q.setParameter("id", incidentId);
        q.executeUpdate();

        tx.commit();
        s.close();
    }
}