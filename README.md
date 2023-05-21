# Thinking in Java - Bruce Eckel

## Reusing Classes

- adding Main to a class allows easy testing!
- toString allows easy testing -> String representation of an objects state;

- public and protected: if the fields in the base class are public or protected, you can access them in the derived class.
- private: you can only access then in the derived class through getter and setter methods.

- you can override a method from the super class and still call the super class method from withing the overrinden
  method via super. keyword.
  `super is added because otherwise you would have recursive calls: page 169`
- When the base class has ctor has arguments you must call the ctor from the base class,form withing the child class,
  via the super keyword using the appropriate arguments.
- You are forced to initialize the ctor of the base class, but you're responsible for the initialization of the member
  objects/ `fields`, when you're not passed as parameters to the ctor
- cleanup with try-with resource AutoClosable -> close gets automatically called at end of try block -> exceptions
  passed to catch
- `protected` keyword ->
- `final`
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
    - 