import api.ProductDao;
import dao.ProductDaoImpl;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.User;
import service.UserServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Product produktTest1 = new Product(1L,"produkt1",100,10,"black",100);
        Product produktTest2 = new Product(2L,"produkt2",200,20,"red",200);
        Product produktTest3 = new Product(3L,"produkt3",300,30,"white",300);



        List<Product> products = new ArrayList<Product>();
        List<Product> products2 = new ArrayList<Product>();

        products.add(produktTest1);
        products.add(produktTest2);
        products.add(produktTest3);
        products.add(new Product(4L,"produkcik",400,40,"yellow",400));



        ProductDaoImpl productDao = new ProductDaoImpl("removeTest", "PRODUCT");

        productDao.saveProducts(products);

        products2 = productDao.getAllProducts();

        for (Product product: products2
             ) {
            System.out.println(product.getProductName());
        }

        productDao.removeProductById(2L);
        productDao.removeProductByName("produkcik");
        productDao.saveProduct(new Product(5L,"dodany",100,20,"zielony",30));

        products2 = productDao.getAllProducts();

        System.out.println("p[o");
        for (Product product: products2
        ) {
            System.out.println(product.getProductName());
        }


    }
}
