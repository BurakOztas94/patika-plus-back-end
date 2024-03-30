import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main (String[] args)
        {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory ("market");
            EntityManager entityManager = entityManagerFactory.createEntityManager ();
            EntityTransaction transaction = entityManager.getTransaction ();


            transaction.begin ();

            Supplier supplier = new Supplier ();
            supplier.setAddress ("Bursa");
            supplier.setCompany ("Hi dro");
            supplier.setContact ("+90654654654");
            supplier.setMail ("aıudgasdn@gmail.com");
            supplier.setPerson ("Burak Öztaş");
            entityManager.persist (supplier);


            //Code add
            Code code = new Code ();
            code.setGroup ("123123");
            code.setSerial ("445566");
            entityManager.persist (code);

            //product add
            Product product = new Product ();
            product.setName ("Myphone Master");
            product.setPrice (10500);
            product.setStock (100);
            product.setCode (code);
            product.setSupplier (supplier);
            entityManager.persist (product);






            // Product product=entityManager.find (Product.class,1);
            // System.out.println (product.toString ());


            transaction.commit ();








                                                                                                                                        /* transaction.begin ();

                                                                                                                                        Customer c1 =new Customer ();

                                                                                                                                        c1.setOnDate (LocalDate.now ());
                                                                                                                                        c1.setName ("patika");
                                                                                                                                        c1.setMail ("info@patika.dev");
                                                                                                                                        c1.setGender (Customer.GENDER.FEMALE);

                                                                                                                                        entityManager.persist (c1);
                                                                                                                                        transaction.commit ();

                                                                                                                                        transaction.begin ();
                                                                                                                                        Customer customer = new Customer ();

                                                                                                                                        customer.setName ("Burak");
                                                                                                                                        customer.setMail ("test@burakoztas.io");
                                                                                                                                        customer.setGender (Customer.GENDER.MALE);
                                                                                                                                        customer.setOnDate (LocalDate.now ());

                                                                                                                                        entityManager.persist (customer);
                                                                                                                                        transaction.commit ();*/


        }
}
