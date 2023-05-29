# Thinking in Java - Bruce Eckel

## Reusing Classes

- adding Main to a class allows easy testing!
- toString allows easy testing -> String representation of an objects state;

- public and protected: if the fields in the base class are public or protected, you can access them in the derived class.
- private: you can only access then in the derived class through getter and setter methods.

- you can override a method from the super class and still call the super class method from withing the overridden
  method via super. keyword.
  `super is added because otherwise you would have recursive calls: page 169`
- When the base class has ctor has arguments you must call the ctor from the base class,form withing the child class,
  via the super keyword using the appropriate arguments.
- You are forced to initialize the ctor of the base class, but you're responsible for the initialization of the member
  objects/ `fields`, when they're not passed as parameters to the ctor
- cleanup with try-with resource AutoClosable -> close gets automatically called at end of try block -> exceptions
  passed to catch
- `protected` keyword ->
- `final`
    - final object 
      - reference is final but the state of the object itself can be changed
    - to field you can via getters and setters
    - Compile time constant -> folding
      - `final int MY_CONSTANT = 10;
        int result = 5 * MY_CONSTANT;`
      - In this case, MY_CONSTANT is a compile-time constant. During compilation, the compiler can fold the constant value 10 into the expression 5 * MY_CONSTANT and replace it with 5 * 10, resulting in 50. As a result, at runtime, the calculation 5 * 10 doesn't need to be performed since the value is already known.

    - Value initialized at `runtime` that you don't want to change - `final`
      - static final variable is assigned a value determined at runtime (e.g., through computation or method invocation), it is not considered a compile-time constant. The value is still constant once assigned, but it is determined and assigned during runtime. 
      - more flexibility
    - `static final` -> associated with a class
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

- In a wel designed  OOP program you communicate only with the base class interface. When you add data types that inherit from the base class, the right method calls will be made during runtime without you having to change the base class.
- @Override is optional but handy because:
  - It provides compile-time checks: The @Override annotation informs the compiler that you intend to override a method from a superclass or implement an interface method. If, for some reason, the annotated method does not actually override a superclass method or implement an interface method, the compiler will generate an error, allowing you to catch such mistakes early during compilation.
  -  By using the @Override annotation, you make it clear to other developers that the annotated method is intended to override a superclass method or implement an interface method.
- You can't access the private method of base class.
  - use different name from private methods in base class, so you don't get the appearance that the method can be overridden
- Polymorphism relies on dynamic binding, which occurs at runtime, based on the actual type of the object. Static methods, on the other hand, are resolved at compile time based on the type of the variable or reference on which they are called.