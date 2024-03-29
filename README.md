# Thinking in Java - Bruce Eckel

## REVIEW:

- functional -> defineer interface en pas het toe
- LinkedList vs ArrayList wat is het verschil?
- Checked exceptions vs unchecked exceptions
- polymorphism: Write methods that implement the interface instead of being tied to a specific implementation
    - `List<Apple> apples = new LinkedList<Apple>()`
    - compile time -> method overloading
    - run time : interfaces and inheritance method overriding
- Dynamic Binding (Late Binding): The association of method call to the method body happens at runtime.
    - When your program runs new objects are created by the use and it's only when the object is created that you can
      infer the type of the object at RUNTIME (when the program is running!!)
    - At compile time you don't know yet what kind of object gets made, only when you run the program!!
    - at compile time you have the reference type which might be a super class or interface but not the actual object it
      referes to
    - Yes, it does involve runtime type identification. The Java VM looks up the appropriate method to call based on the
      object's type.

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

## Interfaces

- can contain fields but they are static and final
- methods without bodies
- obligated to instantiate all the methods
- By using interface inheritance, you can add new method declarations to an interface and combine multiple interfaces
  into a new interface. This allows you to define more specialized interfaces that inherit and extend the behavior of
  existing interfaces. It promotes code reuse, modularity, and flexibility in designing your software components.
    - Multi inheritance chapter had some weird examples where you use Interface as an argument and the right method gets
      called -> don;t know why i thought this was confusing -> we pass interfaces as arguments all the time and call the
      methods on those interfaces
        - via ctor
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

## Inner classes

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

## Holding your objects

- holding your objects or holding references to your objects via:  arrays, ArrayList, LinkedList, and HashMap.
- With `Generics` you’re prevented, at compile time, from putting the
  wrong type of object into a container.
- Set never has duplicates
- Collection vs List interface:
    - List adds unique index (access elements by their index), allows duplicate values and has ordering, Collections had
      random ordering.
- You’ll typically make an object of a concrete class, upcast it to the corresponding
  interface, and then use the interface throughout the rest of your
  code. `List<Apple> apples = new LinkedList<Apple>();`
- Lists
    - contains : in a list
    - indexof : discover index of element
    - inserting in the middle of a list is cheap operation for LinkedList but expensive for ArrayList
    - access is slower for a LinkedList
    - LinkedList also adds methods that allow it to be used as a `stack`, a `Queue` or a `double-
      ended queue` (deque).
- Iterator
    - example itterating class
- `Stack` LIFO
- `Queue` FIFO
    - see Queuy for queue specific methods
    - queues are extremely important in concurrent programming for safely transferring objects between tasks or threads.
      When multiple threads are involved, ensuring that data is transferred and processed safely is crucial to avoid
      issues such as data corruption, race conditions, or inconsistent states. Queues, particularly thread-safe queues,
      serve as the foundation for achieving this.
- `Map` has key value pairs
    - Stores key-value pairs in no particular order.
    - Provides fast insertion, deletion, and retrieval operations.
    - Does not implement Iterable, but you can itterate over the keyset and vlues
- The use of Collection Interface to write generic and reusalbe code -> see CollectionsVsInterfaces
    - Both Collection and Iterator offer flexibility with various container types.
    - `Collection` is slightly preferred for cleaner code via enhanced for-loops.
    - Decoupling through interfaces promotes maintainability and reusability.
    - Using the Collection interface allows you to write more generic code, as you can pass around collections without
      knowing their specific implementation. This is a form of polymorphism and is beneficial for writing flexible and
      extensible code.
- `Array` doesn't implement Iterable interface -> need to convert to List (or something els)
    - An array associates numerical indexes to objects. It holds objects of a known type so
      that you don’t have to cast the result when you’re looking up an object. It can be
      multidimensional, and it can hold primitives. However, its size cannot be changed
      once you create it.
- A container won’t hold primitives, but autoboxing takes
  care of translating primitives back and forth to the wrapper types held in the
  container.
- Use an ArrayList if you’re doing a lot of random accesses, but a LinkedList if you
  will be doing a lot of insertions and removals in the middle of the list.
- The behavior of `Queues` and `stacks` is provided via the LinkedList.

## Error Handling with exceptions

- The try block contains the code that might throw an exception.
- The catch block contains the code that is executed if an exception occurs in the try block.
    - Takes only `one` argument
    - If an exception is thrown, the
      exception-handling mechanism goes hunting for the first handler with an argument that
      matches the type of the exception
- The finally block contains code that is executed regardless of whether an exception was thrown or not.
- `e.printStackTrace();` You can send exceptions to the error stream -> example CreatingYourOwnExceptions
- You can Log your exceptions via java.util.logging
    - lots of examples of the above in CreatingYourOwnExceptions
- `Exception specification` : public void readFile(String filePath) throws IOException
    - the caller of readfile is obligated to
        - `Catch` the excecption in a try catch block
        - `Propagate` the exception -> propagate the exception up the call stack by declaring the same exception(s) in
          its own exception specification
        - example of both in TheExceptionSpecification
- You can retrhow an exception in the catch block catch (Exception e) throw e;
    - rethrown exc will contain the excpetion origin info
    - You can also rethrow differenct exceptions
    - catch one exception and throw another, but still keep the information
      about the originating exception -> catch lower level and add higher level exception as the `cause`
- `finally` : executes everytime.
    - Java has garbage collection so why use finally?
        - `Logging`
        - `Cleanup`:
            - close resources like files, network connections, or database connections.
        - `Restoring State`: If a piece of code changes some global state
        - `Unlocking`: In concurrent programming, you might use locks to protect shared resources.
- `Checked exceptions`: These exceptions must be either caught or declared to be thrown in the method signature. The
  compiler checks this rule and will give an error if you don’t handle them or declare them using the throws keyword.
  Common examples of checked exceptions are IOException, SQLException, etc. Checked exceptions are usually used for
  recoverable conditions that client code can reasonably be expected to catch.

- `Unchecked exceptions`: These exceptions are not checked at compile-time, meaning the compiler doesn't force you to
  catch them or declare them in the method signature. Unchecked exceptions are subclasses of RuntimeException, and
  include exceptions like ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, etc. Unchecked
  exceptions usually represent programming errors and it's assumed that the application cannot be expected to recover
  from them.
- RuntimeException is itself a subclass of Exception. However, the Java language specification treats any exceptions
  that are subclasses of RuntimeException as unchecked exceptions. This means you don’t have to explicitly handle them,
  though it's often a good practice to do so, especially when you can take specific actions based on the exception.

## Strings

show text blocks and how it has changed during java 8

- Objects of String class are immutable
- bestaande String aanpassen is nieuw String object aanmaken -> referen naar dit object en dan wordt oud object
  opgekuist door garbage collecter
    - zie StringsAreImmutable
- String vs StringBuilder:
    - `String`: Should be used when you are dealing with string constants or when you don't need to perform repeated
      modifications to strings.
    - `StringBuilder`: Should be used when you need to construct or modify strings repeatedly, especially in loops or
      when performing concatenation many times.
    - Performance
        - String: Concatenating or modifying strings using the String class can be inefficient, especially in loops,
          because a new object is created every time the string is modified.
          StringBuilder: Operations like concatenation are much faster with StringBuilder because it modifies the
          object's content in-place without creating new objects. This makes StringBuilder preferable when you need to
          perform repeated modifications to strings.
    - Uninteded Recursion ZOEK NAAR EEN GEPAST VOORBEELDJJ:
    - In Java, when working with strings, it's possible to accidentally cause unintended recursion if a method calls
      itself either directly or indirectly through a series of other method calls, without a proper termination
      condition.
- String operations page 361: maybe give examples in Main class tijdens bespreking
- You can Format your output: see formatting output
    - Formatter util class: % format specifiers
    - page 366 for a list of formatting conversions ex:
        - f:   Floating point (as decimal)
- Regular expression and string split -> split String around matches of the given regular expression.
    - split( ) divides an input string into an array of String objects, delimited by the regular
      expression.
        - Example: RegularExpressionStringSplit
        - page 372 for regular expressions table
- regular expressions are especially useful to replace text -> replaceAll()
    - Example in RegularExpressionStringSplit
- 'Pattern' and 'Matcher'
- You can scan input or txt files,... for regex expressions -> RegexAndIo good example
    - `Scanner` scanner = new Scanner(input)
    - `String` pattern = regex
    - while scanner hasnext pattern
    - `Matchresult` match = scanner.match()

## Type Information:

To summarize, .class files are created at compile-time, and RTTI and Reflection are techniques used at runtime to
interact with these loaded classes.

- Java's compile-time process involves converting .java source code into bytecode (.class files). The compiler doesn't
  examine .class files during the compilation. Rather, it produces these .class files.

chapter overview:

all the things below are to show how the JVM finds the right object at runtime.

- Enhanced instanceof with Pattern Matching (Java 16 onwards):
    - Java 16 introduced a new feature called "Pattern Matching for instanceof". This allows you to not only check the
      type but also declare a variable in the same expression. This can reduce verbosity and make the code cleaner.
- Class object:
    - Contains type information of the class
    - loaded when the first reference to a static member of the class is made - ctor is static
    - Anytime you want to use type information at run time, you must first get a reference to the
      appropriate Class object.
        - EXAMPLE InstancethisBiatch!!
            - Animal extends cats and dogs -> put animal of type Animal in array
                - you can only call the overriden methods and not the class specicif methdos
                - because upcasting from Class object to class specific object stops at Animal
            -
- Class literal:
    - a class literal is a reference to the Class object that represents a specific type (i.e., a class, an interface,
      an array, a primitive, or void). A class literal is written as TypeName.class.
    - `This is used to pass type information around without the overhead of creating individual objects.`
        - https://stackoverflow.com/questions/2160788/what-is-a-class-literal-in-java
        - show real life examples of how to use class literals ASK CHAT GPT!! explains a lot
        -     `private static Logger log = Logger.getLogger(YourClassHere.class);`
        - this is a line where we're initialising a logging framework
        - The getLogger() method requires a class literal so it knows what it's logging (i.e. the current object's
          class).
            - getting a reference via .class doesn't initialize the class -> handy to pass type information about a
              class
              without having to initialize it
            - However, Class.forName( ) initializes the class immediately in order to
              produce the Class reference
- Generics
    - The reason for adding the generic syntax to Class references is only to provide compile-time
      type checking, so that if you do something wrong you find out about it a little sooner
    - Bounded Type Parameters: You can restrict the types that can be used as type arguments in a parameterized type.
      For example:
        - public class Box<T extends Number> {
        - T can be any type that extends Number, such as Integer, Double, Float, etc.
    - Code Reusability: Generics promote code reusability as you can write a method or class which can work with
      different types of data.
- Instanceof or isInstance vs ==
    - instanceOf or isInstance: are you this class or a class derived from this class
    - == : not concerned with inheritance -> exact type, or it isn't
- For RTTI (detecting the type of a class) the type of the class must be known at compile time in
    - what if you don't know the type at compile time? REFLECTION -> the .class is opened at runtime

## GENERICS

- Java generics do not support primitive types such as int, char, or boolean. Instead, their wrapper classes (Integer,
  Character, Boolean, etc.) must be used. This is considered one of the limitations of Java generics.
    - Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their
      corresponding object wrapper classes. For example, converting an int to an Integer automatically when an object is
      required.
    - Unboxing is the reverse process of autoboxing. Automatically converting an object of a wrapper type to its
      corresponding primitive type. For example, converting an Integer to an int.
- public class Box<T extends Number>
    - `bounded` type
- Lower Bounded Wildcards: To declare a lower-bounded wildcard, you use the wildcard character ('?'), followed by the
  super keyword, followed by its lower bound: ? super A.
- Upper Bounded Wildcards: To declare an upper-bounded wildcard, you use the wildcard character ('?'), followed by the
  extends keyword, followed by its upper bound.
- ERASURE:
    - Generic types cannot be used in operations that explicitly
      refer to runtime types, such as casts, instanceof operations, and new expressions. Because
      all the type information about the parameters is lost, whenever you’re writing generic code
      you must constantly be reminding yourself that it only appears that you have type
      information about a parameter
    - Type Erasure: Type erasure is a compromise in the implementation of Java generics. It was necessary to maintain
      backward compatibility because generics were not a part of Java from the beginning. If generics were part of Java
      1.0, they would have used reification to retain the type parameters as first-class entities. But, due to type
      erasure, generics are treated as second-class types that cannot be used in some important contexts. Every generic
      type in the program is erased by replacing it with a non-generic upper bound.
      -The issue here is that when you use an upper-bounded wildcard (List<? extends Fruit>), you can't put anything
      into the collection (with the exception of null). This is because Java can't guarantee what the actual type of the
      elements in the collection is.
        - If you need to get values out of a structure and you don't know its exact type parameter, use extends (
          producer).
        - If you need to put values into a structure and you don't know its exact type parameter, use super (consumer).
        - If you need to do both things, don't use wildcards.
        - So, if you want to add elements to your list, you should either declare it with a specific type, or use a
          lower-bounded wildcard (List<? super Apple>), which allows you to add Apple and its subtypes to the list.
    - No, you won't have the same issues with a list of String because String is a specific type, not a generic
      placeholder like T.
    - In the case of String, the type is known at compile-time and does not get erased. Therefore, you can create a
      List<String> and add new String objects to it without any problems.
        - The problem arises when you use a type parameter T because due to type erasure, the JVM doesn't know what T is
          at runtime and hence can't instantiate it.

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

## EXTRA info about how queues facilitate safe object transfer in concurrent environments:

Here's a breakdown of how queues facilitate safe object transfer in concurrent environments:

    - `Producer-Consumer Pattern`: One of the most common use cases for queues in concurrent programming is the Producer-Consumer pattern. Producers are tasks that generate data or results, and consumers are tasks that process this data. A queue serves as the buffer for holding this data in between. The producer adds elements to the queue, and the consumer takes elements from the queue for processing.

    `Decoupling of Components`: Queues decouple the producing and consuming components. This means that the producer doesn’t need to wait for the consumer to be ready. Similarly, the consumer doesn't need to wait for the producer to produce data. The queue acts as a buffer that can store data until the consumer is ready to process it.

    `Thread Safety`: In Java, you can use thread-safe queue implementations, such as BlockingQueue, LinkedBlockingQueue, or ArrayBlockingQueue. These implementations ensure that the operations of adding and removing elements from the queue are atomic and thread-safe. This eliminates race conditions and ensures that data integrity is maintained.

    `Flow Control`: Queues can help in controlling the flow of data between threads. For instance, if the producer is generating data faster than the consumer can process, the queue will start to fill up. You can set a maximum size for the queue, and once it's full, the producer will be forced to wait. This can help in preventing resource exhaustion and ensuring a balanced workload.

    `Ordering`: In some cases, the order of processing matters. Queues inherently maintain the order of elements as they are added and removed, ensuring that elements are processed in the order they were added (FIFO - First In First Out).

## Class object

    - Class Object: In Java, for every type (class or interface), there is a unique instance of java.lang.Class that represents that type. This Class instance holds metadata about the type such as its name, methods, fields, constructors, and more. This object is essential for Java's RTTI because it allows you to inspect and interact with class information at runtime.

    - Creation of Regular Objects: When you create an instance of your class (a "regular" object), it's actually created through the associated Class object. This means the JVM uses the Class object's information to allocate memory and initialize the object.

    - Class Files: When you compile a Java class, a .class file is created. This file contains bytecode and metadata for that class. The Class object is created based on this .class file.

    - Class Loaders: In Java, class loaders are responsible for loading classes into the JVM at runtime. There is a hierarchy of class loaders, with the primordial (or bootstrap) class loader at the top. The bootstrap class loader loads the core Java classes. You can also have custom class loaders (for example, to load classes over a network or from unconventional sources).

    - Dynamic Class Loading: Java classes are loaded dynamically, which means they are not loaded all at once when the application starts, but rather as they are needed. This happens when the program makes its first reference to a static member of the class. Constructors are considered static members for this purpose (even though they don’t have the static keyword). This dynamic behavior enables more flexible and extensible programs compared to statically loaded languages.

    - RTTI Usage: RTTI in Java is not just about inspecting class information. It's also used internally by the JVM, for example, during type casting to ensure that the cast is valid.

    - Differences with Statically Loaded Languages: Unlike languages like C++ where typically the whole program is loaded into memory before execution begins, Java's approach of loading classes dynamically allows for more adaptable and scalable applications, especially in environments where classes might be remotely sourced or loaded in unconventional ways.

In summary, the Class object is central to how Java handles RTTI, and it's intimately tied to the dynamic loading of
classes through the class loader subsystem. This combination enables powerful runtime behaviors including reflection,
dynamic extension, and type safety.