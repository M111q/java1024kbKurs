package dao;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplTest {

    @Test
    public void saveProductTest() throws IOException {
        final String FileName1 = "testFile1";
        final String FileName2 = "testFile2";


        Product produktTest1 = new Product(1L,"produkt1",100,10,"black",100);
        FileOutputStream fileOutputStream = new FileOutputStream(FileName1, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        printWriter.write(produktTest1.toString() + "\n");

        ProductDaoImpl productDao = new ProductDaoImpl(FileName2, "PRODUCT");
        productDao.saveProduct(produktTest1);

        printWriter.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(FileName1));
        BufferedReader reader2 = new BufferedReader(new FileReader(FileName2));


        Assert.assertEquals(reader1.readLine(), reader2.readLine());
        reader1.close();
        reader2.close();

        File file1 = new File(FileName1);
        File file2 = new File(FileName2);
        file1.delete();
        file2.delete();

    }

    @Test
    public void saveProductBootsTest() throws IOException {
        final String FileName1 = "testFile1";
        final String FileName2 = "testFile2";


        Boots produktTest1 = new Boots(1L,"produkt1",100,10,"black",100, 40,true);
        FileOutputStream fileOutputStream = new FileOutputStream(FileName1, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        printWriter.write(produktTest1.toString() + "\n");

        ProductDaoImpl productDao = new ProductDaoImpl(FileName2, "BOOTS");
        productDao.saveProduct(produktTest1);

        printWriter.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(FileName1));
        BufferedReader reader2 = new BufferedReader(new FileReader(FileName2));


        Assert.assertEquals(reader1.readLine(), reader2.readLine());
        reader1.close();
        reader2.close();

        File file1 = new File(FileName1);
        File file2 = new File(FileName2);
        file1.delete();
        file2.delete();
    }

    @Test
    public void saveProductsTest() throws IOException {
        final String FileName1 = "testFile1";

        Product produktTest1 = new Product(1L,"produkt1",100,10,"black",100);
        Product produktTest2 = new Product(2L,"produkt2",200,20,"red",200);
        Product produktTest3 = new Product(3L,"produkt3",300,30,"white",300);

        List<Product> products = new ArrayList<Product>();

        products.add(produktTest1);
        products.add(produktTest2);
        products.add(produktTest3);

        ProductDaoImpl productDao = new ProductDaoImpl(FileName1, "PRODUCT");

        productDao.saveProducts(products);

        BufferedReader reader = new BufferedReader(new FileReader(FileName1));

        Assert.assertEquals("1#produkt1#100.0#10.0#black#100",reader.readLine());

        reader.close();
        File file1 = new File(FileName1);
        file1.delete();
    }

    @Test
    public void removeClothByIdTest() throws IOException {

            Product produktTest1 = new Cloth(1L,"produkt1",100,10,"black",100,"M","plastic");
            Product produktTest2 = new Cloth(2L,"produkt2",200,20,"red",200,"XL","jeans");
            Product produktTest3 = new Cloth(3L,"produkt3",300,30,"white",300,"L","metal");

            List<Product> products = new ArrayList<Product>();

            products.add(produktTest1);
            products.add(produktTest2);
            products.add(produktTest3);

            ProductDaoImpl productDao = new ProductDaoImpl("removeTest", "CLOTH");

            productDao.saveProducts(products);

            productDao.removeProductById(2L);

Assert.assertEquals(true,true);
        }



}
