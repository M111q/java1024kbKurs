package entity.parser;

import entity.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductParserTest {

    @Test
    public void parseTest(){

        Product produktTest1 = new Product(1L,"produkt1",100,10,"black",100);

        String parseLine = "1#produkt1#100#10#black#100";

        Product productFromParser = ProductParser.StringToProduct(parseLine, "PRODUCT");

        Assert.assertEquals(produktTest1.toString() , productFromParser.toString());

    }
}
