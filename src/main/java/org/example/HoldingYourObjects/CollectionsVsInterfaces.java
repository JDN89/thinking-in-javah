package org.example.HoldingYourObjects;

import java.util.*;

public class CollectionsVsInterfaces {
}

// Example on how to write to the interface instead of the specific class
// display takes the Iterator or Collection interface and doesn't know the underlying impl (class)

class InterfaceVsIterator {
//    Both versions are decoupled from the underlying implementation of the container. This means that they don't need to know how the container is implemented, as they operate through the Collection interface or through the Iterator, which are abstractions.
// The use of Collection and Iterator both serve to decouple the code from the specific implementations of the underlying container, which is a good practice for writing code that is more maintainable and adaptable to changes.


    //    his version is more generic in the sense that it can be used to display elements from any kind of collection, as long as you can obtain an iterator from it.
    public static void display(Iterator<String> it) {
        while (it.hasNext()) {
            String p = it.next();
            System.out.print(p + " ");
        }
        System.out.println();
    }

    //    is version is specifically tailored for collections and leverages the fact that Collection implements Iterable.
    public static void display(Collection<String> pets) {
        for (String p : pets) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> petList = new ArrayList<>(
                Arrays.asList("Rat", "Manx", "Cymric", "Mutt", "Pug", "Cymric", "Pug", "Manx"));
        Set<String> petSet = new HashSet<>(petList);
        Map<String, String> petMap = new LinkedHashMap<>();

        String[] names = ("Ralph, Eric, Robin, Lacey, Britney, Sam, Spot, Fluffy").split(", ");
        for (int i = 0; i < names.length; i++) {
            petMap.put(names[i], petList.get(i));
        }


        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());
        System.out.println(petMap);
        System.out.println(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator());
    }
}


//    demonstrate a way to provide iteration capability without actually implementing the Collection interface.
//This example illustrates that you can provide an iterator for a class that does not naturally fit into the Collection hierarchy.
// This is useful in situations where you want the class to be usable in contexts that require iteration (such as in for-each loops), but where it doesn't make sense for the class to implement the full Collection interface.
class PetSequence {
    // In this example, I am assuming that Pet is just a String.
    // This array could contain pet names.
    protected String[] pets = {"Rat", "Manx", "Cymric", "Mutt", "Pug", "Cymric", "Pug", "Manx"};
}

class NonCollectionSequence extends PetSequence {

    // Providing an Iterator without implementing the Collection interface
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0; // index for iterating through 'pets'

            // hasNext returns true if there are more elements in the array
            public boolean hasNext() {
                return index < pets.length;
            }

            // next returns the next element in the array
            public String next() {
                return pets[index++];
            }

            // remove is an optional operation, and not implementing it here.
            // It throws an exception if called, which is a common practice for
            // optional operations which are not supported.
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();

        // Use iterator to display elements. Note that NonCollectionSequence is NOT a collection,
        // but we're still able to iterate through its elements in a generic way through an Iterator.
        InterfaceVsIterator.display(nc.iterator());
    }
}