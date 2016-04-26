package kz.tezdet.lessons.hibernate.main;


import kz.tezdet.lessons.hibernate.models.MarkDetails;
import kz.tezdet.lessons.hibernate.models.Student;
import kz.tezdet.lessons.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Student student = new Student("Дәулет", "Баймбетов",
                "daucloudlab@gmail.com", "87078914322");
        session.save(student);

        MarkDetails marksDetails1 = new MarkDetails("Maths", "100", "87",
                "Passed");
        MarkDetails marksDetails2 = new MarkDetails("Science", "100", "90",
                "Passed");
        MarkDetails marksDetails3 = new MarkDetails("English", "100", "85",
                "Passed");

        marksDetails1.setStudent(student);
        marksDetails2.setStudent(student);
        marksDetails3.setStudent(student);

        session.save(marksDetails1);
        session.save(marksDetails2);
        session.save(marksDetails3);

        session.getTransaction().commit();
        session.close();
    }
}
