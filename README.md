# Thinking in Java - Bruce Eckel

## Reusing Classes
- adding Main to a class allows easy testing!
- toString allows easy testing -> String representation of an objects state;

- you can override a method from the super class and still call the super class method from withing the overrinden method via super. keyword.
`super is added because otherwise you would have recursive calls: page 169`
- When the base class has ctor has arguments you must call the ctor from the base class,form withing the child class, via the super keyword using the appropriate arguments. 
- You are forced to initialize the ctor of the base class, but you're responsible for the initialization of the member objects/ `fields`, when you're not passed as parameters to the ctor
- cleanup with try-with resource AutoClosable -> close gets automatically called at end of try block -> exceptions passed to catch
- `protected` keyword -> 