package codesample.frameworks.hibernate;


import codesample.frameworks.hibernate.crud_operations_example.Town;
import codesample.frameworks.hibernate.element_collection.Ingredient;
import codesample.frameworks.hibernate.element_collection.Pizza;
import codesample.frameworks.hibernate.embedded_and_enum_and_super_class.Hero;
import codesample.frameworks.hibernate.inheritance.joined.JoinedBookWorm;
import codesample.frameworks.hibernate.inheritance.joined.JoinedGrassWorm;
import codesample.frameworks.hibernate.inheritance.joined.JoinedWorm;
import codesample.frameworks.hibernate.inheritance.mapped_super_class.MappedSuperBookWorm;
import codesample.frameworks.hibernate.inheritance.mapped_super_class.MappedSuperGrassWorm;
import codesample.frameworks.hibernate.inheritance.mapped_super_class.MappedSuperWorm;
import codesample.frameworks.hibernate.inheritance.single_table.SingleTableBookWorm;
import codesample.frameworks.hibernate.inheritance.single_table.SingleTableGrassWorm;
import codesample.frameworks.hibernate.inheritance.single_table.SingleTableWorm;
import codesample.frameworks.hibernate.inheritance.table_per_class.TablePerClassBookWorm;
import codesample.frameworks.hibernate.inheritance.table_per_class.TablePerClassGrassWorm;
import codesample.frameworks.hibernate.inheritance.table_per_class.TablePerClassWorm;
import codesample.frameworks.hibernate.many_to_many.biridectional.Concert;
import codesample.frameworks.hibernate.many_to_many.biridectional.Visitor;
import codesample.frameworks.hibernate.many_to_many.unidirectional.Option;
import codesample.frameworks.hibernate.many_to_many.unidirectional.OurUser;
import codesample.frameworks.hibernate.many_to_one.Item;
import codesample.frameworks.hibernate.many_to_one.Shipping;
import codesample.frameworks.hibernate.many_to_one_to_many_with_map.Company;
import codesample.frameworks.hibernate.many_to_one_to_many_with_map.CompanyContract;
import codesample.frameworks.hibernate.many_to_one_to_many_with_map.CompanyWorker;
import codesample.frameworks.hibernate.one_to_many.Production;
import codesample.frameworks.hibernate.one_to_many.Worker;
import codesample.frameworks.hibernate.one_to_one_relation.bidirectional.DogBidirectional;
import codesample.frameworks.hibernate.one_to_one_relation.bidirectional.OwnerBidirectional;
import codesample.frameworks.hibernate.one_to_one_relation.unidirectional.DogUni;
import codesample.frameworks.hibernate.one_to_one_relation.unidirectional.OwnerUni;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * It is recommended to create hibernate SessionFactory once for each of your databases so we use a singleton here.
 *
 * You can also replace call to {@link HibernateUtil#getSessionFactory()} with something like getSession().
 * But then you would need to create and extra method for getStatelessSession() if needed.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration()
                    .addPackage("codesample.frameworks.hibernate")
                    .addAnnotatedClass(Town.class)
                    .addAnnotatedClass(Item.class)
                    .addAnnotatedClass(Shipping.class)
                    .addAnnotatedClass(Option.class)
                    .addAnnotatedClass(OurUser.class)
                    .addAnnotatedClass(Production.class)
                    .addAnnotatedClass(Worker.class)
                    .addAnnotatedClass(Hero.class)
                    .addAnnotatedClass(DogUni.class)
                    .addAnnotatedClass(OwnerUni.class)
                    .addAnnotatedClass(DogBidirectional.class)
                    .addAnnotatedClass(OwnerBidirectional.class)
                    .addAnnotatedClass(Concert.class)
                    .addAnnotatedClass(Visitor.class)
                    .addAnnotatedClass(Company.class)
                    .addAnnotatedClass(CompanyContract.class)
                    .addAnnotatedClass(CompanyWorker.class)
                    .addAnnotatedClass(Pizza.class)
                    .addAnnotatedClass(Ingredient.class)

                    .addAnnotatedClass(JoinedWorm.class)
                    .addAnnotatedClass(JoinedBookWorm.class)
                    .addAnnotatedClass(JoinedGrassWorm.class)
                    .addAnnotatedClass(SingleTableWorm.class)
                    .addAnnotatedClass(SingleTableBookWorm.class)
                    .addAnnotatedClass(SingleTableGrassWorm.class)
                    .addAnnotatedClass(MappedSuperWorm.class)
                    .addAnnotatedClass(MappedSuperBookWorm.class)
                    .addAnnotatedClass(MappedSuperGrassWorm.class)
                    .addAnnotatedClass(TablePerClassWorm.class)
                    .addAnnotatedClass(TablePerClassBookWorm.class)
                    .addAnnotatedClass(TablePerClassGrassWorm.class)

                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

}
