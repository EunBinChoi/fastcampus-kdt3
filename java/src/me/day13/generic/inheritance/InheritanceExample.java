package me.day13.generic.inheritance;

class TV {

    @Override
    public String toString() {
        return "TV";
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        ChildProduct<TV, String, String> childProduct = new ChildProduct<TV, String, String>();
        childProduct.setKind(new TV());
        childProduct.setModel("SmartTV");
        childProduct.setCompany("LG");

        System.out.println("childProduct = " + childProduct);
    }
}
