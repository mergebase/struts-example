package org.apache.struts2.showcase.application;

import org.apache.struts2.showcase.exception.CreateException;
import org.apache.struts2.showcase.exception.StorageException;
import org.apache.struts2.showcase.exception.UpdateException;
import org.apache.struts2.showcase.model.CreditReport;
import org.apache.struts2.showcase.model.IdEntity;
import org.apache.struts2.showcase.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Repository
@Scope("singleton")
public class DatabaseStorage {

    Session session;


    public IdEntity get(Class entityClass, Serializable id) {

        try {

            session = HibernateUtils.getSession();
            Transaction tx = session.beginTransaction();

            String name = entityClass.getName();

            Query q = session.createQuery("from CreditReport where id = :id");

            q.setParameter("id", id);

            List list = q.list();
            tx.commit();
            return (IdEntity) list.get(0);

        } catch (Exception e) {

        }
        return null;
    }


    public Serializable create(IdEntity object) throws CreateException {

        try {
            session = HibernateUtils.getSession();
            Transaction tx = session.beginTransaction();
            if(object instanceof CreditReport) {
                session.persist((CreditReport) object);
            }

            tx.commit();
        } catch (Exception e) {
            return object;
        }
        return object;


    }


    public IdEntity update(IdEntity object) throws UpdateException {
        try {
            session = HibernateUtils.getSession();
            Transaction tx = session.beginTransaction();
            if(object instanceof CreditReport) {
                session.update((CreditReport) object);
            }

            tx.commit();
        } catch (Exception e) {
            return object;
        }
        return object;
    }


    public Serializable merge(IdEntity object) throws StorageException {
        try {
            session = HibernateUtils.getSession();
            Transaction tx = session.beginTransaction();
            if(object instanceof CreditReport) {
                session.saveOrUpdate((CreditReport) object);
            }

            tx.commit();
        } catch (Exception e) {
            return object;
        }
        return object;
    }


    public int delete(Class entityClass, Serializable id) throws CreateException {
        try {
            session = HibernateUtils.getSession();
            Transaction tx = session.beginTransaction();
            if(entityClass == CreditReport.class) {
                session.delete((String) id, CreditReport.class);
            }

            tx.commit();
        } catch (Exception e) {
            return 1;
        }
        return 0;
    }


    public int delete(IdEntity object) throws CreateException {
        try {
            session = HibernateUtils.getSession();
            Transaction tx = session.beginTransaction();
            if(object instanceof CreditReport) {
                session.delete((CreditReport) object);
            }

            tx.commit();
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }


    public Collection findAll(Class entityClass) {
        try {

            session = HibernateUtils.getSession();
            Transaction tx = session.beginTransaction();

            String name = entityClass.getName();

            Query q = session.createQuery("from CreditReport");

            List list = q.list();
            tx.commit();
            return list;

        } catch (Exception e) {

        }
        return null;

    }
}
