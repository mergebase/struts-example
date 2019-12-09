package org.apache.struts2.showcase.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    public static Session getSession() {
        final Configuration configuration = new Configuration().configure();
        setPropIfEnv(configuration, "hibernate.connection.username", "db.username");
        setPropIfEnv(configuration, "hibernate.connection.password", "db.password");
        setPropIfEnv(configuration, "hibernate.connection.url", "db.url");
        setPropIfEnv(configuration, "hibernate.default_schema", "db.default_schema");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.openSession();
    }

    private static void setPropIfEnv(Configuration configuration, String propertyName, String envVar) {
        final String getenv = System.getenv(envVar);
        if (getenv != null) {
            configuration.setProperty(propertyName, getenv);
        }
    }
}