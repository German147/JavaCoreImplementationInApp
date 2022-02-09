# <h1> Interface in java</h1>
#### Interface in java is a "mechanism" to achieve abstraction.
<br/>

### What I understand...
* [Here in the person service java interface I will be writing the theory and its examples as I understand]()


There are mainly three reasons why to use interface:

* To achieve abstraction (it is a process of hiding the implementation
  details and showing only functionality to the user- Abstraction lets you focus on what
  the object does instead of how it does it)
* To support the functionality of multiple inheritance.
* To achieve loose coupling between classes (What means they are mostly independent classes from each other)

### Relationship between classes and interfaces
* A class EXTENDS another class
* An interface EXTENDS another interface
######BUT
* [A CLASS IMPLEMENTS AN INTERFACE]()

### Multiple inheritance in Java By Interface
 If a class implements multiple interface, or an interface extends multiple interfaces, 
it is known as MULTIPLE INHERITANCE.
###I have created an example of these case of study using the Interface PersonService in the service package in this app

### Abstract and final

In java, you will never see a class or method declared with both final and abstract keywords. For classes, final is used 
to prevent inheritance whereas abstract classes depends upon their child classes for complete implementation. In cases 
of methods, final is used to prevent overriding whereas abstract methods needs to be overridden in sub-classes.

From https://www.geeksforgeeks.org/abstract-keyword-in-java/

### Polymorphism shown through Method Overloading and Method Overriding

https://www.geeksforgeeks.org/overloading-in-java/?ref=gcse