package service;


import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void getAllProductsTest(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L,"produkt1",100,10,"black",100));
        products.add(new Product(2L,"produkt2",10,1,"red",50));
        products.add(new Product(3L,"produkt3",1,11,"white",1));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();

        Assert.assertEquals(products, productsFromTestClass);
    }

    @Test
    public void getProductsCountTest(){
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L,"produkt1",100,10,"black",100));
        products.add(new Product(2L,"produkt2",10,1,"red",50));
        products.add(new Product(3L,"produkt3",1,11,"white",1));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        int productsFromTestClass = productService.getProductsCount();

        Assert.assertEquals(3,productsFromTestClass);
    }

    @Test
    public void getProductTest(){
        List<Product> products = new ArrayList<Product>();

        Product produktTest1 = new Product(1L,"produkt1",100,10,"black",100);
        products.add(produktTest1);
        Product produktTest2 =  new Product(2L,"produkt2",10,1,"red",50);
        products.add(produktTest2);
        Product produktTest3 = new Product(3L,"produkt3",1,11,"white",1);
        products.add(produktTest3);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product productFromTestClass = productService.getProduct("produkt2");

        Assert.assertEquals(produktTest2,productFromTestClass);
    }

    @Test
    public void getEmptyProductTest(){
        List<Product> products = new ArrayList<Product>();

        Product produktTest1 = new Product(1L,"produkt1",100,10,"black",100);
        products.add(produktTest1);
        Product produktTest2 =  new Product(2L,"produkt2",10,1,"red",50);

        Product produktTest3 = new Product(3L,"produkt3",1,11,"white",1);
        products.add(produktTest3);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        Product productFromTestClass = productService.getProduct("produkt2");

        Assert.assertEquals(null,productFromTestClass);
    }

    @Test
    public void isMoreThanZeroProductTest(){
        List<Product> products = new ArrayList<Product>();

        Product produktTest1 = new Product(1L,"produkt1",100,10,"black",100);
        products.add(produktTest1);
        Product produktTest2 =  new Product(2L,"produkt2",10,1,"red",50);
        products.add(produktTest2);
        Product produktTest3 = new Product(3L,"produkt3",1,11,"white",1);
        products.add(produktTest3);

        ProductServiceImpl productService = new ProductServiceImpl(products);
        Boolean result = productService.isMoreThanZeroProduct("produkt1");

        Assert.assertEquals(true,result);
        Assert.assertNotEquals(false,result);
    }




}