package org.example.HoldingYourObjects;

import java.util.*;

public class Iterators {
}
class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();

        // A simpler approach, when possible:
        for (Pet p : pets)
            System.out.print(p.id() + ":" + p + " ");
        System.out.println();

        // An Iterator can also remove elements:
        it = pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
}

class Pet {
    private int id;
    private String name;

    public Pet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int id() {
        return id;
    }

    public String toString() {
        return name;
    }
}

class Pets {
    public static List<Pet> arrayList(int size) {
        List<Pet> pets = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            pets.add(new Pet(i, generateName(i)));
        }
        return pets;
    }

    private static String generateName(int index) {
        // Logic to generate pet names
        return "Pet" + index;
    }
}

class CrossContainerIteration {

    public static void display(Iterator<Pet> it) {
        while(it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Pet> pets = (ArrayList<Pet>) Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<Pet>(pets);
        HashSet<Pet> petsHS = new HashSet<Pet>(pets);
        TreeSet<Pet> petsTS = new TreeSet<Pet>(pets);
        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator());
    }
}
