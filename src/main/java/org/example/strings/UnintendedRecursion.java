package org.example.strings;

public class UnintendedRecursion {
}

//    In the main() method, an instance of Person named Alice is created,
//    and her bestFriend property is set to herself.
//    When attempting to print the alice object using System.out.println(),
//    it implicitly calls the toString() method on that object.
//    Since the bestFriend is Alice herself, it ends up calling alice.toString()
//    again and again, resulting in infinite recursion.

class Person {

    private String name;
    private Person bestFriend;

    public Person(String name) {
        this.name = name;
    }

    public void setBestFriend(Person bestFriend) {
        this.bestFriend = bestFriend;
    }

    // FIX
//   @Override
//   String toString() {
//       // Check to avoid unintended recursion
//       if (this == bestFriend) {
//           return "Person [name=" + name + ", bestFriend=Self]";
//       }
//       return "Person [name=" + name + ", bestFriend=" + bestFriend + "]";
//   }

    @Override
    public String toString() {
        // Unintended recursion if this person's best friend is set to this person itself
        return "Person [name=" + name + ", bestFriend=" + bestFriend + "]";
    }

    public static void main(String[] args) {
        Person alice = new Person("Alice");
        // Setting Alice as her own best friend (circular reference)
        alice.setBestFriend(alice);

        // Calling toString() method causes unintended recursion
        System.out.println(alice);
    }



}