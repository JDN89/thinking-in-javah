## Questions and answers:

- https://www.baeldung.com/java-interview-questions
- https://www.digitalocean.com/community/tutorials/java-programming-interview-questions
- https://www.geeksforgeeks.org/java-interview-questions/
- https://www.indeed.com/career-advice/interviewing/java-coding-interview-questions

- static: Static fields or methods are class members, whereas non-static ones are object members
    - Class Variable:  Class Variable variable can be declared anywhere at the class level using the keyword static.
      These variables can only have one value when applied to various objects. These variables can be shared by all
      class members since they are not connected to any specific object of the class.
- final: inal Variables: When a variable is declared with final keyword, its value can't be modified, essentially, a
  constant. This also means that you must initialize a final variable.
    - if the value is a `Reference` -> The var cannot be REOBUND TO REFERENCE ANOTHER VARIABLE
        - BUT: but the internal state of the object pointed to by that reference variable can be changed.

STACK: The stack is a place where the JVM reserves blocks for local variables and additional data. The stack is a LIFO (
last in first out) structure. It means that whenever a method is called, a new block is reserved for local variables and
object references

- In Java, primitive types (e.g., int, float, boolean) do not get put on the heap. Instead, they are stored on the
  stack. This is because primitive types are not objects in Java, they are simple values.
- references of objects get put on the stack
  HEAP: Every new object is created on the Java heap which is used for a dynamic allocation. There is a garbage
  collector
  which is responsible for erasing unused objects which are divided into young (nursery) and old spaces. Memory access
  to
  the heap is slower than access to the stack.

- Static Binding (also known as Early Binding): The binding which can be resolved at compile time by the compiler is
  known as static or early binding. Binding of all the `static, private and final` methods is done at COMPILE-TIME.
  Overloaded methods are also bonded using static binding.

- Dynamic Binding (also known as Late Binding): In Dynamic binding compiler doesn't decide the method to be called.
  Overriding is a perfect example of dynamic binding. In overriding both parent and child classes have the same method.
- Encapsulation:
  Encapsulation is the practice of keeping fields within a class private, then providing access to them via public
  methods. It's a protective barrier that keeps the data and code safe within the class itself
  -Dynamic method dispatch is a resolving mechanism for method overriding during the run time. Method overriding is the
  one where the method in a subclass has the same name, parameters, and return type as a method in the superclass. When
  the over-ridden method is called through a superclass reference, java determines which version (superclass or
  subclass) of that method is to be executed based upon the type of an object being referred to at the time the call
  occurs
- Method Overloading: It is also known as Compile Time Polymorphism. In method overloading two or more methods are
  shared in the same class with a different signature.
- When Abstract methods are used?

An abstract method is used when we want to use a method but want to child classes to decide the implementation in that
case we use Abstract methods with the parent classes.
. Explain the LinkedList class.

LinkedList class is Java that uses a doubly linked list to store elements. It inherits the AbstractList class and
implements List and Deque interfaces. Properties of the LinkedList Class are mentioned below:

    LinkedList classes are non-synchronized.
    Maintains insertion order.
    It can be used as a list, stack, or queue.

Checked Exception:

Checked Exceptions are the exceptions that are checked during compile time of a program. In a program, if some code
within a method throws a checked exception, then the method must either handle the exception or must specify the
exception using the throws keyword.

Checked exceptions are of two types:

    Fully checked exceptions: all its child classes are also checked, like IOException, and InterruptedException.
    Partially checked exceptions: some of its child classes are unchecked, like an Exception. 

Unchecked Exception:

Unchecked are the exceptions that are not checked at compile time of a program. Exceptions under Error and
RuntimeException classes are unchecked exceptions, everything else under throwable is checked.

-     Insertions and Deletions: If you frequently add or remove elements from the list, especially from the front or middle, a LinkedList would be a good choice. Insertions and deletions at a specific position in a LinkedList are generally faster than an ArrayList because it involves only changing the links in a node (constant time), while an ArrayList has to shift all elements (linear time).

- Memory: LinkedList uses more memory to store the elements because, in addition to storing the elements themselves, it
  also stores two references for each element to the next and previous element. However, LinkedList doesn't have to
  allocate memory in advance for future elements. On the other hand, ArrayList needs to periodically reallocate memory
  for growth, which can be expensive in terms of time and memory.

- Performance: If your application requires lots of access to elements in the list using the get method, an ArrayList is
  a better choice. Accessing an element in a LinkedList requires a sequence of next or previous references to get to the
  correct position (linear time), while accesses in an ArrayList are constant time.

- List Operations: If your application requires the use of advanced operations such as addFirst, addLast, removeFirst,
  removeLast, etc., LinkedList is a more natural choice because it implements the Deque interface, which provides these
  methods.
    - LinkedList: Iterating over a LinkedList is also efficient, because it involves following the links from one node
      to the next, which is a constant-time operation. However, random access (i.e., accessing an element at a specific
      index) in a LinkedList is slow because it requires traversing the list from the start or end to the desired
      positio
    - LinkedList: The underlying data structure of a LinkedList is a doubly-linked list. Each element in the LinkedList
      is stored as an individual Node object. Each Node contains the element itself and two references, one to the next
      Node in the list and one to the previous Node.

Set: no duplicates and unordered

THIS: current instance of a class
SUPER: current isntance of the parent class