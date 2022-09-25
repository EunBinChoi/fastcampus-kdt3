package me.day06.array;

import org.openjdk.jol.vm.VM;

public class ArrayAddressExample {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("Array: " + nums);
        System.out.println("Memory address: " + VM.current().addressOf(nums));
        System.out.println("toString: " + nums.toString()); // Integer.toHexString(hashCode())
        System.out.println("hashCode: " + nums.hashCode());
        System.out.println();

        for (int i = 0; i < nums.length; i++) {
            System.out.print("nums[i] = " + nums[i] + ", ");
            System.out.println("address of nums[i] = " + VM.current().addressOf(nums[i]));
        }
        System.out.println();
        System.out.println("======================================");

        String[] names = {"Sally", "John", "Jacob", "Kelly", "Minna"};
        System.out.println("Array: " + names);
        System.out.println("Memory address: " + VM.current().addressOf(names));
        System.out.println("toString: " + names.toString()); // Integer.toHexString(hashCode())
        System.out.println("hashCode: " + names.hashCode());
        for (int i = 0; i < names.length; i++) {
            System.out.print("names[i] = " + names[i] + ", ");
            System.out.println("address of names[i] = " + VM.current().addressOf(names[i]));
        }
        System.out.println();
    }
}
