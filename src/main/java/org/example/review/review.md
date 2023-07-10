# ACCESS CONTROL
- private
- protected
- package private (no keyword)
- public
- final
  - class
  - method : overriden
  - var 
    - primitive
    - reference to another object
    
# REUSING CLASSES
- public protected <-> final getters and setters
- override methods and super keyword -> recursion
- ctor base class had args -> pass to derived class -> proper initialization
- why would you pass args to a ctor?
- static final vs just final

# POLYMORPHISM
- dynamic or late binding -> runtime 
  - At runtime JVM checks which obj ref points to
- compile time
- talk to base class instead of derived classes -> algemene code
  - gemakkelijk om nieuwe derived classes te implementeren en zo funcitonaliteit van app uit te breiden
- @Override 
  - readability
  - compile time check
-  Order of initialization  
  - Don't call overriden methods from inside the base ctor -> can give problems
  - ContructorsAndPolymorphism 

# INTERFACES
## ABSTRACT
- methods
  - abstract
  - final -> use?
  - public
- use of ctor?
- initialize on itself?
- multiple inheritance?
## INTERFACE
- methods
- inheritance
- programming ot an interface
  - flexible -> can handle any object that handles that interface
- functional interfaces and lambdas
  - exactly one abstract method
  - how was it done before -> example in review package in case I forget impl

# Holding your objects

# Error handling and exceptions
- Checked vs unchecked
  - handle or throws
  - obligated to handle them?
- passing to next level
- catch and throw new exc
  - cause