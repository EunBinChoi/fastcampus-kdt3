package me.day06.array2d;

import org.openjdk.jol.vm.VM;

public class Array2dAddressExample {
    public static void main(String[] args) {
        int[][] nums2d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Array: " + nums2d);
        System.out.println("Memory address: " + VM.current().addressOf(nums2d));
        System.out.println("toString: " + nums2d.toString()); // Integer.toHexString(hashCode())
        System.out.println("hashCode: " + nums2d.hashCode());
        System.out.println();

        System.out.println("nums1d[i]");
        for (int i = 0; i < nums2d.length; i++) {
            System.out.print("nums2d[i] = " + nums2d[i] + ", ");
            System.out.println("address of nums2d[i] = " + VM.current().addressOf(nums2d[i]));
        }
        System.out.println();

        System.out.println("nums2d[i][j]");
        for (int i = 0; i < nums2d.length; i++) {
            for (int j = 0; j < nums2d[i].length; j++) {
                System.out.print("nums2d[i][j] = " + nums2d[i][j] + ", ");
                System.out.println("address of nums2d[i] = " + VM.current().addressOf(nums2d[i][j]));
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("======================================");

        String[][] names2d = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}};
        System.out.println("Array: " + names2d);
        System.out.println("Memory address: " + VM.current().addressOf(names2d));
        System.out.println("toString: " + names2d.toString()); // Integer.toHexString(hashCode())
        System.out.println("hashCode: " + names2d.hashCode());

        System.out.println("names2d[i]");
        for (int i = 0; i < names2d.length; i++) {
            System.out.print("names2d[i] = " + names2d[i] + ", ");
            System.out.println("address of names2d[i] = " + VM.current().addressOf(names2d[i]));
        }
        System.out.println();

        System.out.println("names2d[i][j]");
        for (int i = 0; i < names2d.length; i++) {
            for (int j = 0; j < names2d[i].length; j++) {
                System.out.print("names2d[i][j] = " + names2d[i][j] + ", ");
                System.out.println("address of names2d[i] = " + VM.current().addressOf(names2d[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }
}
