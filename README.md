# Thinking in Java - Bruce Eckel


## Reusing Classes

- adding Main to a class allows easy testing!
- toString allows easy testing -> String representation of an objects state;

- `public` and `protected`: if the fields in the base class are public or protected, you can access them in the derived
  class.
- `private`: you can only access then in the derived class through getter and setter methods.

- you can override a method from the super class and still call the super class method from within the overridden
  method via `super` keyword.
  `super is added because otherwise you would have recursive calls: page 169`
- When the base class constructor (also known as the superclass constructor) has arguments, you need to pass those
  arguments to the constructor of the derived class (also known as the subclass) using the "super" keyword. This ensures
  that the base class constructor is properly invoked during the initialization of the derived class.
- You are forced to initialize the ctor of the base class, but you're responsible for the initialization of the member
  objects/ `fields`, when they're not passed as parameters to the ctor
- cleanup with try-with resource AutoClosable -> close gets automatically called at end of try block -> exceptions
  passed to catch
- `protected` keyword ->
- `static final` fields are shared across all instances of a class and have the same value, while `final` fields are
  specific to each instance and can have different values.
    - blank final must be initialized before being accessed
        - advantage -> final field inside a class can be different for each object
    - 'final class' -> cannot be inherited from

## Polymorphism

In this chapter, you’ll learn about polymorphism (also called dynamic binding or late
binding or run-time binding) starting from the basics, with simple examples that strip away
everything but the polymorphic behavior of the program.

Wouldn’t it be much nicer if you could just write a single method that takes the base class as
its argument, and not any of the specific derived classes? That is, wouldn’t it be nice if you
could forget that there are derived classes, and write your code to talk only to the base class?
`see Upcaster class -> example `

- In a wel designed OOP program you communicate only with the base class interface. When you add data types that inherit
  from the base class, the right method calls will be made during runtime without you having to change the base class.
- @Override is optional but handy because:
    - It provides compile-time checks: The @Override annotation informs the compiler that you intend to override a
      method from a superclass or implement an interface method. If, for some reason, the annotated method does not
      actually override a superclass method or implement an interface method, the compiler will generate an error,
      allowing you to catch such mistakes early during compilation.
    - By using the @Override annotation, you make it clear to other developers that the annotated method is intended to
      override a superclass method or implement an interface method.
- You can't access the private method of base class.
    - use different name from private methods in base class, so you don't get the appearance that the method can be
      overridden
- Polymorphism relies on dynamic binding, which occurs at runtime, based on the actual type of the object. Static
  methods, on the other hand, are resolved at compile time based on the type of the variable or reference on which they
  are called.
- Initilize all member objects (Composition) at their point of definition -> ensure that all objects are constructed
  properly
    - all the base-class ctor has the proper knowledge to initialize its own elements -> super. in ctor (inheritance),
      initialize member object(composition)
    - order of initialization (see ctor and poly class for example):
        - The storage allocated for the object is initialized to binary zero before anything else
          happens.
        - The base-class constructors are called
        - Member initializers are called in the order of declaration. (composition)
        - The body of the derived-class constructor is called
- `upcasting`: when you upcast you can't access the new defined methods (not overridden) in the subclass
    - in order to access the methods in the subclass -> you need to rediscover the exact type of the object ->
      downCasting via casting or isntance of
        - example: DownAndUpcasting

## Interfaces

#### Abstract

- You can't instantiate an abstract class, you can only inherit from an abstract class
- when you inherit from an abstract class you must instantiate all it's abstract methods
- you can call public (non-abstract methods), that are defined in the abstract class, from the subclass
- `final methods` in an abstract class:
    - Providing a fixed implementation
    - Ensuring consistency:guarantees that the method will always behave in the same way
    - Preventing accidental overrides:
- `Template pattern` > temptation exmaple
- Reason for a ctor in abstract classes:
    - Initializing instance variables: A constructor is used to initialize the state of an object - to initialize the
      shared state
    - Enforcing initialization requirements: setting mandatory parameters or performing specific checks or validations
      during object creation.
    - Providing common setup logic
    - Interacting with abstract methods:

#### Interfaces

- can contain fields but they are static and final
- methods without bodies
- obligated to instantiate all the methods
- By using interface inheritance, you can add new method declarations to an interface and combine multiple interfaces
  into a new interface. This allows you to define more specialized interfaces that inherit and extend the behavior of
  existing interfaces. It promotes code reuse, modularity, and flexibility in designing your software components.
    - Multi inheritance chapter had some weird examples where you use Interface as an argument and the right method gets
      called
    - I added a less confusing example because I don't think that the example in the book gets used in real life? ask PF
    - `pg 230, ...`
- example of StrategyPattern
    - common methods applied implemented by different strategies
    - Concrete classes that implement the strategy interface
    - Context: class that contains a reference to the current strategy object -> set strategy
    - Used to be a handy way to define Constant static fields but nowadays, we use Enums (remind in case you see in code
      base)

###### DEFAULT METHODS EN RELATIES TSS INTERFACES EN LAMBADAS (FUNCTIONAL INTERFACES) -> ONDERZOEK EN GEEF VOORBEELD

Accepting interfaces as arguments is a common use case in Java programming and is often used to achieve flexibility and
extensibility in code. Here are a few scenarios where accepting interfaces as arguments can be beneficial:

    Callback mechanisms: When implementing callback mechanisms, interfaces can be used to define the contract for callback methods. By accepting an interface as an argument, you allow the caller to pass an object that implements the interface and provides the desired behavior. This allows for loose coupling and dynamic behavior.

    Dependency injection: In the context of dependency injection, interfaces are commonly used to define the dependencies of a class. By accepting an interface as an argument, you allow the caller or an external dependency injection framework to provide an implementation of that interface. This promotes decoupling and allows for easier testing and swapping of implementations.

    Strategy pattern: The strategy pattern involves encapsulating different algorithms or strategies behind a common interface. By accepting an interface representing the strategy as an argument, you can dynamically change the behavior of a method or class by providing different implementations of the interface. This allows for flexible and interchangeable algorithms.

    Event handling: When dealing with events and event listeners, interfaces are often used to define the contract for event handling methods. By accepting an interface representing an event listener as an argument, you can register listeners that implement the interface to handle specific events. This enables modular and customizable event handling.
 
    Polymorphism and abstraction: Accepting interfaces as arguments promotes polymorphism and abstraction in your code. By relying on interfaces rather than concrete implementations, you allow for a wider range of objects to be passed as arguments, as long as they conform to the interface contract. This enhances code reusability and maintainability.

#### Inner classes

- The inner class can access both the instance variables and the methods of the enclosing class as if they were its own.
  This includes private members of the enclosing class, which are normally not accessible to other classes.
- Create an object of an anonymous class that’s inherited
  from Contents. The reference returned by the new expression is automatically upcast to a
  Contents reference.
    - the class is anonymous; it has no name.

    1. A class defined within a method
    2. A class defined within a scope inside a method
    3. An anonymous class implementing an interface
    4. An anonymous class extending a class that has a non-default constructor
    5. An anonymous class that performs field initialization
    6. An anonymous class that performs construction using instance initialization
       (anonymous inner classes cannot have constructors)
- Nested class: when you don't need a connection between the inner and outer class
  - You don’t need an outer-class object in order to create an object of a nested class.
  - You can’t access a non-static outer-class object from an object of a nested class.
  - A nested class inside an interface is automatically public and static

#### Holding your objects

- holding your objects or holding references to your objects via:  arrays, ArrayList, LinkedList, and HashMap.
- With `Generics` you’re prevented, at compile time, from putting the
  wrong type of object into a container.
- Set never has duplicates
- Collection vs List interface:
  - List adds unique index (access elements by their index), allows duplicate values and has ordering, Collections had random ordering.
- You’ll typically make an object of a concrete class, upcast it to the corresponding
  interface, and then use the interface throughout the rest of your code. `List<Apple> apples = new LinkedList<Apple>();`


## Overview Most used Collections and Maps:
    ArrayList:
        ArrayList is an implementation of the List interface, backed by a dynamic array.
        Elements in an ArrayList are stored in contiguous memory locations.
        Provides fast access to elements by index.
        Insertion and deletion operations at the end of the list are efficient.
        Insertion and deletion operations at the beginning or middle of the list are slower because existing elements may need to be shifted.
        Allows duplicate elements and maintains the insertion order.
        Suitable for scenarios where random access and fast iteration are required.

    LinkedList:
        LinkedList is an implementation of the List interface, backed by a doubly-linked list.
        Elements in a LinkedList are stored in separate nodes, each containing a reference to the previous and next node.
        Provides fast insertion and deletion operations at any position in the list.
        Random access to elements by index is slower compared to ArrayList.
        Allows duplicate elements and maintains the insertion order.
        Suitable for scenarios that involve frequent insertion and deletion operations in the middle of the list.

    HashSet:
        HashSet is an implementation of the Set interface, backed by a hash table (using HashMap internally).
        Stores elements in no particular order.
        Provides fast insertion, deletion, and retrieval operations.
        Does not allow duplicate elements (based on the elements' hashCode and equals methods).
        Does not maintain the insertion order of elements.
        Suitable for scenarios that require uniqueness of elements and efficient retrieval.

    TreeSet:
        TreeSet is an implementation of the SortedSet interface, backed by a self-balancing binary search tree (Red-Black Tree).
        Stores elements in sorted order.
        Provides fast insertion, deletion, and retrieval operations.
        Does not allow duplicate elements (based on the elements' compareTo or Comparator implementation).
        Suitable for scenarios that require sorted elements and efficient operations for maintaining sorted order.

    LinkedHashSet:
        LinkedHashSet is an implementation of the Set interface, backed by a hash table with a linked list (using LinkedHashMap internally).
        Maintains the insertion order of elements while also providing fast access and removal.
        Provides fast insertion, deletion, and retrieval operations.
        Does not allow duplicate elements (based on the elements' hashCode and equals methods).
        Suitable for scenarios that require both uniqueness of elements and maintenance of insertion order.

    HashMap:
        HashMap is an implementation of the Map interface, backed by a hash table.
        Stores key-value pairs in no particular order.
        Provides fast insertion, deletion, and retrieval operations.
        Allows duplicate values but not duplicate keys (based on the keys' hashCode and equals methods).
        Suitable for scenarios that require efficient key-value lookups.

    TreeMap:
        TreeMap is an implementation of the SortedMap interface, backed by a self-balancing binary search tree (Red-Black Tree).
        Stores key-value pairs in sorted order of keys.
        Provides fast insertion, deletion, and retrieval operations based on keys.
        Does not allow duplicate keys (based on the keys' compareTo or Comparator implementation).
        Suitable for scenarios that require key-value pairs to be maintained in sorted order.

    LinkedHashMap:
        LinkedHashMap is an implementation of the Map interface, backed by a hash table with a linked list.
        Maintains the insertion order of key-value pairs while also providing fast access and removal.
        Provides fast insertion, deletion, and retrieval operations.
        Allows duplicate values but not duplicate keys (based on the keys' hashCode and equals methods).
        Suitable for scenarios that require both key-value lookups and maintenance of insertion order