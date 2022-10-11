package me.day13.generic.multiparam;


import me.day13.generic.multiparam.product.Product;
import me.day13.generic.multiparam.product.ProductMap;
import me.day13.generic.multiparam.product.SmartPhone;
import me.day13.generic.multiparam.product.Tablet;

public class GenericMultiParamExample {
    public static void main(String[] args) {

        ProductMap<String, Product> productMap1 = new ProductMap<>();
        productMap1.put("0001", new SmartPhone("Z-FILP", "SAMSUNG", 20, 3));
        productMap1.put("0002", new Tablet("IPAD-PRO5", "APPLE", true));
        System.out.println("productMap1.get(\"0001\") = " + productMap1.get("0001"));
        System.out.println("productMap1.get(\"0002\") = " + productMap1.get("0002"));
        System.out.println();

        ProductMap<Integer, Product> productMap2 = new ProductMap<>();
        productMap2.put(1, new SmartPhone("Z-FILP", "SAMSUNG", 20, 3));
        productMap2.put(2, new Tablet("IPAD-PRO5", "APPLE", true));
        System.out.println("productMap2.get(1) = " + productMap2.get(1));
        System.out.println("productMap2.get(2) = " + productMap2.get(2));

    }
}
