import entites.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.ProductDao;

public class MainApp {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
//        productDao.create("screwDriver", 50);
//        System.out.println(productDao.findById(8L));
//        Product product = new Product("screwDriver", 100);
//        product.setId(8L);
//        System.out.println(productDao.saveOrUpdate(product));


    }
}
