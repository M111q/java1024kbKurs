package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {


    public static Product StringToProduct(String lineToParse, String productType) {

        if (productType.equals("PRODUCT")) {
            return convertToProduct(lineToParse);
        } else if (productType.equals("BOOTS")) {
            return convertToBoots(lineToParse);
        } else if (productType.equals("CLOTH")) {
            return convertToCloth(lineToParse);
        }
        return null;
    }

    private static Product convertToProduct(String lineToParse) {
        String[] productInfo = lineToParse.split(Product.PRODUCT_SEPARATOR);

        Product product = new Product(
                Long.parseLong(productInfo[0]),
                productInfo[1],
                Float.parseFloat(productInfo[2]),
                Float.parseFloat(productInfo[3]),
                productInfo[4],
                Integer.parseInt(productInfo[5]));

        return product;
    }

    private static Product convertToBoots(String lineToParse) {
        String[] productInfo = lineToParse.split(Product.PRODUCT_SEPARATOR);

        Boots boots = new Boots(
                Long.parseLong(productInfo[0]),
                productInfo[1],
                Float.parseFloat(productInfo[2]),
                Float.parseFloat(productInfo[3]),
                productInfo[4],
                Integer.parseInt(productInfo[5]),
                Integer.parseInt(productInfo[6]),
                Boolean.parseBoolean(productInfo[7]));

        return boots;

    }


    private static Product convertToCloth(String lineToParse) {

        String[] productInfo = lineToParse.split(Product.PRODUCT_SEPARATOR);

        Cloth cloth = new Cloth(
                Long.parseLong(productInfo[0]),
                productInfo[1],
                Float.parseFloat(productInfo[2]),
                Float.parseFloat(productInfo[3]),
                productInfo[4],
                Integer.parseInt(productInfo[5]),
                productInfo[6],
                productInfo[7]);

        return cloth;


    }


}
