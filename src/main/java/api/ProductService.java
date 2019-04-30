package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;

    int getProductsCount() throws IOException;//List<Product> productList);

    Product getProductByName(String productName) throws IOException;

    Boolean isMoreThanZeroProduct(String productName) throws IOException;

    Boolean isProductExist(String productName) throws IOException;

    Boolean isProductExist(Long id) throws IOException;

}
