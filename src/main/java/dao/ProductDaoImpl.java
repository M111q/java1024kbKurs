package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {


    private String fileName;
    private String productType;

    public ProductDaoImpl(String fileName, String productType) throws IOException {

        this.fileName = fileName;
        this.productType = productType;
        File file = new File(fileName);
        file.createNewFile();
    }

    public void saveProduct(Product product) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        printWriter.write(product.toString() + "\n");

        printWriter.close();
    }

    public void saveProducts(List<Product> products) throws IOException {

        for (Product product: products) {
            saveProduct(product);
        }

    }

    public void removeProductById(Long productId) throws IOException {
        List<Product> productList = new ArrayList<Product>();

        productList = getAllProducts();

        for (Product product:productList) {
            if (product.getId().equals(productId)){
                productList.remove(product);
                break;
            }
        }

        saveListToFile(productList);

    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> productList = new ArrayList<Product>();

        productList = getAllProducts();

        for (Product product:productList) {
            if (product.getProductName().equals(productName)){
                productList.remove(product);
                break;
            }
        }

        saveListToFile(productList);
    }

    //nadpisuje
    private void saveListToFile(List<Product> listToSaveToFile) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(fileName);

        for (Product product:listToSaveToFile) {
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();

    }


    public List<Product> getAllProducts() throws IOException {

        List<Product> productList = new ArrayList<Product>();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        String oneLineFromFile = reader.readLine();
        //if (oneLineFromFile != null){
        //    productList.add(ProductParser.StringToProduct(oneLineFromFile, productType));
        //}

        while(oneLineFromFile != null) {
            if (oneLineFromFile != null) {
                productList.add(ProductParser.StringToProduct(oneLineFromFile, productType));
            }
            oneLineFromFile = reader.readLine();
            //if (oneLineFromFile != null) {
            //    productList.add(ProductParser.StringToProduct(oneLineFromFile, productType));
            //}
            }

        reader.close();
        return productList;
    }

    public Product getProductById(Long productId) throws IOException {
        List<Product> productList = new ArrayList<Product>();

        productList = getAllProducts();

        for (Product product:productList) {
            if (product.getId().equals(productId)){
                return product;
            }
        }
        return null;
    }

    public Product getProductByProductName(String productName) throws IOException {

        List<Product> productList = new ArrayList<Product>();

        productList = getAllProducts();

        for (Product product:productList) {
            if (product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }

}
