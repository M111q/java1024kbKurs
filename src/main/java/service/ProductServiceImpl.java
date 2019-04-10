package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(String productName) {
        for (Product product: products) {
            if (product.getProductName() == productName){
                return product;
            }
        }
        return null;
    }

    public Boolean isMoreThanZeroProduct(String productName) {
        return null;
    }

    public Boolean isProductExiste(String productName) {
        return null;
    }

    public Boolean isProductExiste(Long id) {
        return null;
    }
}
