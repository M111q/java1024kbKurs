package api;

import entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    int getProductsCount();//List<Product> productList);

    Product getProduct(String productName);

    Boolean isMoreThanZeroProduct(String productName);

    Boolean isProductExiste(String productName);

    Boolean isProductExiste(Long id);

}
