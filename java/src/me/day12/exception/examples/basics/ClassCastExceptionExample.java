package me.day12.exception.examples.basics;

abstract class Animal {
    protected abstract String getName();
}

class Mammal extends Animal {
    @Override
    protected String getName() {
        return "Mammal";
    }
}
class Amphibian extends Animal {
    @Override
    protected String getName() {
        return "Amphibian";
    }
}

class Dog extends Mammal {
    @Override
    protected String getName() {
        return "Dog";
    }
}
class Frog extends Amphibian {
    @Override
    protected String getName() {
        return "Frog";
    }
}

public class ClassCastExceptionExample {
    public static void main(String[] args) {
        Frog frog = new Frog();
        try {
            birth(frog);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        System.out.println("main exit ...");
    }
    public static void birth (Animal animal) throws ClassCastException {
//        if (animal instanceof Mammal) {
//            Mammal mammal = (Mammal) animal;
//            System.out.println(mammal.getName() + " give birth to young");
//        } else if (animal instanceof Amphibian) {
//            Amphibian amphibian = (Amphibian) animal;
//            System.out.println(amphibian.getName() + " lay eggs");
//        }
        Mammal mammal = (Mammal) animal;
        System.out.println(mammal.getName() + " give birth to young");

        Amphibian amphibian = (Amphibian) animal;
        System.out.println(amphibian.getName() + " lay eggs");

    }
}
