package service;

import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    //List<Product> products;

    private static  ProductServiceImpl instance = null;
    private ProductDaoImpl productDao = null;

    private ProductServiceImpl() {
        try {
            productDao = new ProductDaoImpl("products.data", "PRODUCT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProductServiceImpl getInstance(){
        if (instance == null){
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    public int getProductsCount() throws IOException {

        return productDao.getAllProducts().size();
    }

    public Product getProductByName(String productName) throws IOException {

        return productDao.getProductByProductName(productName);
    }

    public Boolean isMoreThanZeroProduct(String productName) throws IOException {
        return isProductExist(productName) && productDao.getAllProducts().size() > 0;
    }

    public Boolean isProductExist(String productName) throws IOException {
        return !productDao.getProductByProductName(productName).equals(null);
    }

    public Boolean isProductExist(Long id) throws IOException {
        return !productDao.getProductById(id).equals(null);
    }
}
