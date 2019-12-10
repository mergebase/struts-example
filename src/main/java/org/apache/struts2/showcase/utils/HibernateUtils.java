package org.apache.struts2.showcase.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    public static Session getSession() {
        final Configuration configuration = new Configuration().configure();
        setPropIfEnv(configuration, "hibernate.connection.username", "db_username");
        setPropIfEnv(configuration, "hibernate.connection.password", "db_password");
        setPropIfEnv(configuration, "hibernate.connection.url", "db_url");

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
