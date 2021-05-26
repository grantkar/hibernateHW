package repository;

import entites.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDao {

    private Product product;
    private List<Product> products;

    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

    Session session = null;

    // CRUD

    //CREATE
    public Product create(String title, int price) {
        session = sessionFactory.getCurrentSession();
        product = new Product(title, price);
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        sessionFactory.close();
        return product;
    }

    //READ
    public Product findById(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, id);
        session.getTransaction().commit();
        sessionFactory.close();
        return product;
    }

    public List<Product> findAll() {
        return products;
    }

    //DELETE
    public void deleteById(Long id) {
        System.out.println(product);
    }

    //UPDATE
    public Product saveOrUpdate(Product productUpdate) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        product = session.get(Product.class, productUpdate.getId());
        product.setTitle(productUpdate.getTitle());
        product.setPrice(productUpdate.getPrice());
        session.getTransaction().commit();
        sessionFactory.close();
        return product;
    }
}
