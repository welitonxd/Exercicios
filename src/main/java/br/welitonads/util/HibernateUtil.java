package br.welitonads.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";

    static {
        try {
            System.out.println("Tentando configurar a Fabrica de Sessoes");
            Configuration configuration = new Configuration().configure();

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).buildServiceRegistry();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            System.out.println("Fabrica de sessoes criada corretamente.");
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao inicar a SessionFactory" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
}
}
