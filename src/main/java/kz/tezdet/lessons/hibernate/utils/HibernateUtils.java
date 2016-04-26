package kz.tezdet.lessons.hibernate.utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory factory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        try{
            return new AnnotationConfiguration().configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }catch (Throwable ex){
            System.err.println("Ошибка создания сеанса: " + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex) ;
        }
    }

    public static SessionFactory getSessionFactory(){
        return factory ;
    }
}
