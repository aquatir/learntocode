package learn_to_code.frameworks.hibernate.inheritance.single_table;

import learn_to_code.frameworks.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;

public class HibernateSingleTableRunner {
    public static void main(String[] args) throws IOException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            SingleTableGrassWorm ivanWorm = new SingleTableGrassWorm("GrassIvan", "Green grass");
            SingleTableGrassWorm marinaWorm = new SingleTableGrassWorm("GrassMarina", "Red grass");
            SingleTableBookWorm katyaWorm = new SingleTableBookWorm("Katya", "Hygge");
            SingleTableBookWorm joraWorm = new SingleTableBookWorm("Jora", "War and Peace");

            session.save(ivanWorm);
            session.save(marinaWorm);
            session.save(katyaWorm);
            session.save(joraWorm);
            session.getTransaction().commit();

            session.beginTransaction();
            System.out.println("Grass worms:");
            session.createQuery("from SingleTableGrassWorm").list().forEach(c -> System.out.println(c));

            System.out.println();
            System.out.println("Book worms:");
            session.createQuery("from SingleTableBookWorm").list().forEach(c -> System.out.println(c));

            System.out.println();
            System.out.println("All worms");
            session.createQuery("from SingleTableWorm").list().forEach(c -> System.out.println(c));

            session.getTransaction().commit();

            System.out.println();
            System.out.println("Waiting for your input to destroy DB");
            System.in.read();

        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}
