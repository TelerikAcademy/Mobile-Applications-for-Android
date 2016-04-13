<!-- section start -->
<!-- attr: {id: 'title', class: 'slide-title', hasScriptWrapper: true} -->
# Introduction to Java
<div class="signature">
    <p class="signature-course">Android Applications</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>


<!-- section start -->
<!-- attr: { id:'table-of-contents', class:'table-of-contents', style:'font-size:0.95em' } -->
# Table of Contents
- Basics
  - Data types and variables
  - Operations and expressions
  - Conditional statements
  - Loops
  - Arrays
- OOP
  - Defining Classes
  - Methods
  - Inheritance
  - Enumerations
  - Interfaces


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
# Data types and variables

# Primitive Data Types
- Integer data types
  - `byte`, `short`, `int`, `long`
  - no unsigned version of the types
- Floating point data types
  - `float`, `double`
- Boolean data type `boolean`
- _Example_:

```java
int num = 123;
float fNum = 1.234f;
boolean isTrue = true;
```

# Relational Data Types
- For each of the primitive types there is a Class (Relational) type
  - `Integer`, `Byte`, `Double`, ecc.
- The compiler **boxes the primitive** or **unboxes the object** when needed
- _Example_:

```java
Integer intNum = 10;
intNum = Integer.valueOf(10);
intNum = new Integer(10);
```

<!-- attr: { style:'font-size:0.85em' } -->
# BigInteger and BigDecimal
- `BigInteger` - [documentation](http://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html)
  - Immutable, arbitrary-precision signed integer numbers

```java
import java.math.BigInteger;
...
BigInteger bigInt;
bigInt = BigInteger.valueOf(10);
bigInt = new BigInteger("10");
```
 
- `BigDecimal` - [documentation](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html)
  - Immutable, arbitrary-precision signed decimal numbers
  - Consists of `unscaled` value and a 32-bit integer `scale`

```java
import java.math.BigDecimal;
...
BigDecimal bigDec;
bigDec = BigDecimal.valueOf(1.2345);
bigDec = new BigDecimal("1.234");
```

# String Data Type
- The string data type:
  - Represents a sequence of characters
  - Is declared by the `String` keyword
  - Has a default value `null` (no value)
- Strings are enclosed in quotes:

```java
string text = "Hello, I'm Java";
```
- Strings can be concatenated
  - Using the `+` operator

```java
string text = "John" + " " + "Doe"; // "John Doe"
```

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
# Operations and expressions

<!-- attr: { hasScriptWrapper:true, style:'font-size:0.75em' } -->
# Categories of Operators in Java
| Category             | Operators                         |
| -------------------- | --------------------------------- |
| Arithmetic           | `+ - *  /  %  ++  --`               |
| Logical              | `&&` II `^  !  `                    |
| Binary               | `& ^ ~ << >>` I                     |
| Comparison           | `== != < > <= >=`                   |
| Assignment           | `= += -= *= /= %=` <br/>`&= ^= <<= >>=` I`=` |
| String Concatenation | `+`                                 |
| Type Conversion      | `is as typeof`                      |
| Other                | `. [ ] ( ) ? : new`                 |

# Type Conversions
- Example of implicit and explicit conversions:

```java
float heightInMeters = 1.74f; // Explicit conversion
double maxHeight = heightInMeters; // Implicit

double minHeight = (double) heightInMeters; // Explicit

float actualHeight = (float) maxHeight; // Explicit

float maxHeightFloat = maxHeight; // Compilation error!
```

- _Note_: Explicit conversion may be used even if not required by the compiler

# Expressions
- Expressions are sequences of operators, literals and variables that are evaluated to some value
- _Examples_:

```java
int r = (150-20) / 2 + 5; // r=70
// Expression for calculation of circle area
double surface = Math.PI * r * r;
// Expression for calculation of circle perimeter
double perimeter = 2 * Math.PI * r;
```

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
# Conditional statements

# The `if` Statement
- The most simple conditional statement
- Enables you to test for a condition
- Branch to different parts of the code depending on the result
- The simplest form of an `if` statement:

```java
if (condition) {
    statements;
}
```

# The `if-else` Statement
- The `if-else` statement is more complex and useful
  - Executes one branch if the condition is true, and another if it is false 
- The simplest form of an `if-else` statement:

```java
if (expression) {
    statement1; 
} else {
    statement2; 
}
```

#   The `if-else-if` Statement
- Java supports evaluating more than one `if` statements
    - If the first `if` statement is `false`, evaluate the second `if` statement, etc..
    
```java
if (condition1) {
  statement1;
} else if (condition2) {
  //condition1 is false
  statement2;
} else {
  //condition1 and condition2 are false
  statement3;
}
```

<!-- attr: { style:'font-size:0.9em' } -->
# The `switch-case` Statement
- The `switch-case` statement **selects for execution a statement from a list** depending on the value of the switch expression
- In Java there is a **fall through** rule if no **break**

```java
int day = scanner.nextInt();;
switch (day) {
  case 1: System.out.println("Monday"); break;
  case 2: System.out.println("Tuesday"); break;
  case 3: System.out.println("Wednesday"); break;
  case 4: System.out.println("Thursday"); break;
  case 5: System.out.println("Friday"); break;
  case 6: System.out.println("Saturday"); break;
  case 7: System.out.println("Sunday"); break;
  default: System.out.println("Error!"); break;
}
```


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
# Loops

# The `while` Loop

- The simplest and most frequently used loop

```java
while (condition) {
    statements;
}
```
- The repeat condition
  - Returns a boolean result of `true` or `false`
  - Also called loop condition

# The `do-while` Loop
- Another loop structure is:

```java
do {
    statements;
} while (condition);

```

- The block of statements is repeated
  - While the boolean loop condition holds
- The loop is executed at least once

# The `for` loop
- The typical `for` loop syntax is:

```java
for (initialization; test; update) {
  statements;
}
```

- Consists of:
  - Initialization statement
  - Boolean test expression
  - Update statement
  - Loop body block

# The `for-in` loop
- The `for-in` loop is used to iterate collections
  - Collections are arrays, lists, etc..
  - Everything that inherits `Iteratable`
  - _Example:_

```java
String[] names = {"Doncho", "Niki", "Evlogi", "Cuki",
    "Martin", "Konstantin"};

for(String name: names){
  System.out.println(name);
}
```

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Arrays -->

<!-- attr: { style:'font-size:0.9em' } -->
# Declaring Arrays
- Declaring arrays

```java
int[] myIntArray = new int[5]; 
String[] myStringArray;
```
- Initializing

```java
myIntArray = {1, 2, 3, 4, 5};
String[] daysOfWeek = {
    "Monday", "Tuesday", "Wednesday", "Thursday",
    "Friday", "Saturday", "Sunday"
};
```
- Accessing elements

```java
System.out.println("Element at index 0: " + daysOfWeek[0]);
```

<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Resizable Arrays
## `List` and `ArrayList` -->

<!-- attr: { hasScriptWrapper:true, style:'font-size:0.9em' } -->
# `List` and `ArrayList`
- `List` is an **interface**!
- `ArrayList<T>` - implementation of `List`
  - Array that can resize dynamically
  - When adding or removing elements
  - `T` is the type that the list will hold
    - Has to be a **reference type** (`Class`)
    - E.g. `ArrayList<Integer>`
- Basic methods and properties
  - `add(T element)` – adds new element to the end
  - `get(index)` - get the element at that index
  - `size()` – returns the current size of the list

# The `Arrays` class
- Utility class for working with arrays
- Useful methods:
  - `Arrays.sort(T[])` - sorts the array of elements
  - `Arrays.asList(T[])` - returns a fixed-size list backed by the specified array
  - `Arrays.copyOf(T[])`
  - `Arrays.binarySearch(T[], key)`


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Defining Classes -->

# Classes in Java
- Classes in Java can have `members`:
  - Fields, constants, methods, properties, events, constructors, destructors, …
  - Inner types (inner classes, interfaces, delegates, ...)
- Members can have access modifiers (scope)
  - `public`, `private`, `protected`
- Members can be
  - `static` (common) or `specific` for a given object

<!-- attr: { showInPresentation:true, hasScriptWrapper:true, style:'' } -->
# Simple Class Definition

```java
public class Cat extends Animal {
    private String name;
    private String owner;

    public Cat(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    ...
```
<div class="fragment balloon" style="width:250px; top:11%; left:10%">Begin of class definition</div>
<div class="fragment balloon" style="width:230px; top:16%; left:55%">Inherited (base) class</div>
<div class="fragment balloon" style="width:65px; top:23%; left:43%">Fields</div>
<div class="fragment balloon" style="width:120px; top:39%; left:46%">Constructor</div>
<div class="fragment balloon" style="width:70px; top:54%; left:49%">Getter</div>
<div class="fragment balloon" style="width:70px; top:70%; left:62%">Setter</div>


<!-- attr: { showInPresentation:true, hasScriptWrapper:true, style:'' } -->
# Simple Class Definition
```java
    ...
    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String makeSound() {
        return "Miauuuuuu!";
    }
}
```
<div class="fragment balloon" style="width:150px; top:54%; left:52%">Method</div>
<div class="fragment balloon" style="width:230px; top:67%; left:9%">End of class definition</div>

# Class Definition and Members
- `Class definition` consists of:
  - Class declaration
  - Extended/Inherited class or `implemented` interfaces
  - Fields (static or not)
  - Constructors (static or not)
  - Properties (static or not)
  - Methods (static or not)
  - Events, inner types, etc.

<!-- attr: { showInPresentation:true, style:'font-size:0.95em' } -->
# Static Members

```java
class SqrtPrecalculated {
   public static final int MAX_VALUE = 10000;

  // Static field
  private static double[] sqrtValues;

  // Static initializer
  static {
    sqrtValues = new double[MAX_VALUE + 1];
    for (int i = 0; i < sqrtValues.length; i++) {
      sqrtValues[i] = Math.sqrt(i);
    }
  }

  // Static method
  public static double GetSqrt(int value) {
    return sqrtValues[value];
  }
}
```

# Access Modifiers
- Class members can have access modifiers
- Restrict the access to them from outer sources
- Class members can be:
  - `public` – accessible from **any** class
  - `protected` – accessible within its **own package** and by a **subclass** in another package
  - _`no modifier`_ - **package-private** (default)
  - `private` – accessible **only** from the class itself


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Methods -->

# Methods
- `Methods` are class members that execute some action (some code, some algorithm)
  - Could be `static` / per instance
  - Could be `public` / `private` / `protected` / …

```java
public class Point {
  private int xCoord;
  private int yCoord;

  public double calcDistance(Point p) {
    return Math.sqrt(
      (p.xCoord - this.xCoord) * (p.xCoord - this.xCoord)
      + (p.yCoord - this.yCoord) * (p.yCoord - this.yCoord));
  }
}
```

# Overloading Methods
```java
public class DataArtist {
    ...
    public void draw(String s) {
        ...
    }
    public void draw(int i) {
        ...
    }
    public void draw(double f) {
        ...
    }
    public void draw(int i, double f) {
        ...
    }
}
```

# Getters and Setters
- **Getters** and **Setters** expose object's data
  - Control how the data is manipulated
    - Ensure the internal object state is correct
    - E.g. price should always be kept positive
- **Getters** and **Setters** should have:
  - Access modifier - `public`, `protected`, `private`
  - Return type - `int`, `String`, etc.
  - Unique name
  - Can contain code processing data in specific way, e.g. apply **validation**

<!-- attr: { style:'font-size:0.9em' } -->
# Defining Getter and Setter
```java
public class Point {
  private int x;
  private int y;

  public int getX() {
    return this.x;
  }

  public void setX(int value) {
    this.x = value;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int value) {
    this.y = value;
  }
}
```

# Constructors
- Reusing constructors (chaining)

```java
public class Point {
    private int xCoord;
    private int yCoord;
	
    public Point() { 
        this(0, 0); // Reuse the constructor
    }

    public Point(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    // More code …
} 
```


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
# Inheritance

# How to Define Inheritance?
* Specify the name of the base class after the name of the derived using keyword `extends`

```java
public class Shape { … }

public class Circle extends Shape { … }

```
* Use the keyword `super` to invoke the parent constructor

```java
public Circle (int x, int y) { 
  super(x);
}

```

# Nested classes
* The Java programming language allows you to define a **class within another class**
  * Such a class is called a **nested class**

```java
class OuterClass {
    ...
    static class StaticNestedClass {
        ...
    }
    class InnerClass {
        ...
    }
}
```

<!-- attr: { style:'font-size:0.95em' } -->
# Nested classes
* Two categories of nested classes
  * `Non-static nested classes` (inner classes) have access to other members of the enclosing class
    * Even if they are declared private
  * `Static nested classes` do not have access to other members of the enclosing class
* A nested class can be declared
  * **private**, **public**, **protected**, or _**package private**_
* Outer classes can only be declared
  * **public** or _**package private**_

<!-- attr: { style:'font-size:0.95em' } -->
# Why Use Nested Classes?
* Reasons for using nested classes:
  * Logically grouping classes used in one place
    * If a class is useful to only one other class
  * It can lead to more readable and maintainable code
    * Nesting small classes within top-level classes places the code closer to where it is used
  * It increases encapsulation
  * Only nested classes can be declared `static`


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Enumerations -->

<!-- attr: { style:'font-size:0.85em' } -->
# The Power of Java Enumerations
* Much more **powerful** than in other languages
* The enum class body can include **methods**, **constructors** and other **fields**
* All `enums` implicitly extend `java.lang.Enum`
  * They have a static `values()` method that returns an array containing all of the values of the enum

```java
for (Day d : Day.values()) {
  System.out.println(String.format("Days of the week %s", d));
}
```

<!-- attr: { showInPresentation:true, style:'font-size:0.85em' } -->
<!-- # The Power of Java Enumerations -->
```java
public enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() { return mass; }
    private double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;
    ...
```

<!-- attr: { showInPresentation:true, hasScriptWrapper:true, style:'font-size:0.85em' } -->
<!-- # The Power of Java Enumerations -->
```
    ...
    double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
}
```
```
public static void main(String[] args) {
    if (args.length != 1) {
        System.err.println("Usage: java <class_name> <earth_weight>");
        System.exit(-1);
    }
    double earthWeight = Double.parseDouble(args[0]);
    double mass = earthWeight / Planet.EARTH.surfaceGravity();
    for (Planet p : Planet.values())
       System.out.printf("Your weight on %s is %f%n",
                         p, p.surfaceWeight(mass));
}
```

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Interfaces -->

# Interfaces
* In Java an `interface` is a reference type
  * Similar to a `class`
* Can contain only
  * **constants**, **method signatures**, **nested types**
  * **default methods**, **static methods**
    * Method bodies exist only for default methods and static methods
* Interfaces **cannot be instantiated**
  * They can only be `implemented` by classes or `extended` by other interfaces

# The Interface Body
```java
public interface GroupedInterface
    extends Interface1, Interface2, Interface3 {
    // constant declarations    
    // base of natural logarithms
    double E = 2.718282;
 
    // method signatures
    void doSomething (int i, double x);
    int doSomethingElse(String s);

    default boolean didItWork(int i, double x, String s) {
      // Method body 
    }

    static ZoneId getZoneId (String zoneString) {
      // Method body
    }
}
```

# Default and Static Methods
* Default methods enable you to add **new functionality** to the interfaces of your libraries and ensure binary **compatibility** with code written for **older versions** of those interfaces

<!-- attr: { class:'slide-section', showInPresentation:true, hasScriptWrapper:true, style:'' } -->
<!-- # Abstract classes -->

# Abstract classes
* An `abstract class` is a class that is declared abstract
  * It may or may not include `abstract` methods
* Abstract classes **cannot be instantiated**, but they can be subclassed
* When an abstract class is subclassed, the **subclass usually provides implementations** for all of the `abstract` methods in its parent class
  * If it does not, then the **subclass** must also be declared `abstract`

<!-- attr: { showInPresentation:true } -->
<!-- # Abstract classes -->
* _Example_:

```java
abstract class GraphicObject {
    int x, y;
    ...
    void moveTo(int newX, int newY) {
        ...
    }
    abstract void draw();
    abstract void resize();
}
```

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Additional Resources -->

# Additional Resources
- Telerik School Academy 2015/2016
  - [Introduction to Java](http://telerikacademy.com/Courses/Courses/Details/261)
  - [OOP in Java](http://telerikacademy.com/Courses/Courses/Details/295)
  - [Data Structures and Algorithms](http://telerikacademy.com/Courses/Courses/Details/302)
- Java [Documentation](https://docs.oracle.com/javase/7/docs/api/)
- Java [Tutorials](https://docs.oracle.com/javase/tutorial/)
- [Java in 30 minutes video](https://www.youtube.com/watch?v=WPvGqX-TXP0)


<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section', showInPresentation:true } -->
# Questions
<!-- ## Android Applications -->
[link to TelerikAcademy Forum]()
