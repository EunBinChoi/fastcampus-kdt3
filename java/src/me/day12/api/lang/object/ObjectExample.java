package me.day12.api.lang.object;

public class ObjectExample {
    public static void main(String[] args) {
        Person me    = new Person("a", Gender.MALE, "971212", "971212-1234567");
        Person clone = new Person("a", Gender.MALE, "971212", "971212-1234567");
        Person you   = new Person("a", Gender.FEMALE, "971212", "971212-2001234");
        System.out.println("me = " + me);
        System.out.println("clone = " + clone);
        System.out.println("you = " + you);
        System.out.println("me.toString() = " + me.toString());
        System.out.println("clone.toString() = " + clone.toString());
        System.out.println("you.toString() = " + you.toString());
        System.out.println();

        System.out.println("me.hashCode() = " + me.hashCode());
        System.out.println("me.hashCode() = " + me.hashCode());
        System.out.println("you.hashCode() = " + you.hashCode());
        System.out.println();
        
        System.out.println("me.equals(you) = " + me.equals(you));
        System.out.println("me.equals(clone) = " + me.equals(clone));
    }
}
