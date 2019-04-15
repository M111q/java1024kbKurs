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
            if (product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }

    public Boolean isMoreThanZeroProduct(String productName) {
        Product product = getProduct(productName);
        if (isProductExiste(productName) && product.getProductCount() > 0){
            return true;
        }
        return false;
    }

    public Boolean isProductExiste(String productName) {
        for (Product product: products) {
            if (product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }

    public Boolean isProductExiste(Long id) {
        for (Product product: products) {
            if (product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
