<!-- section start -->
<!-- attr: { class:'slide-title', hasScriptWrapper:true } -->
# OOP in Java
##  Classes, Interfaces, Abstract Classes, Interfaces, Anonymous Classes
<div class="signature">
    <p class="signature-course">Mobile applications for Android</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>


<!-- section start -->
# Table of Contents

- Classes
- Inheritance
- Abstract classes
- Interfaces
- Anonymous classes
- Emumerations

<!-- section start -->
<!-- attr: { class:'slide-section' } -->
# Classes in Java

<!-- attr: { showInPresentation:true, style:'font-size:0.7em' } -->
# Classes in Java

- Java has the standart classes:
    -   A model for combining and isolating state and behavior

```java
class Calculator {
    private double mResult;

    public Calculator() {
        mResult = 0;
    }

    public Calculator add(double value) {
        mResult += value;
        return this;
    }

    public Calculator multiply(double value) {
        mResult *= value;
        return this;                
    }

    /* More operations .... */

    public double getResult() {
        return mResult;
    }
}
```
<!-- section start -->

# Inheritance

- Class inheritance in Java is much like in other languages
    -   A class can inherit another class, extending it
    -   The inheritor has access only to `public`, `protected` and `package` members of the parent
    -   Each class inherits exactly one other class
        -   Multiple inheritance is available though interfaces
    -   Each class method can be overriden in an inheritor

# Abstract classes

- Classes can be marked `abstract`
    -   Can optionally contain abstract methods
        -   They have no body, and the inheritors must implement them
    -   Can contain constructors
    -   Cannot be instantiated
        -   i.e. objects cannot be created using the `new` operator

# Inheritance example

-   _Example:_

```java
class Calculator {
    // If it is private, it cannot be accessed though inheritors    
    protected mResult

    /* from before */
}

class ScientificCalculator extends Calculator {
    public sin() {
        /* ... */
    }
}
```

<!-- section start -->

<!-- attr: {class: 'slide-section'} -->
# Interfaces

# Interfaces

- Interfaces are contracts for behavior
    -   i.e. they say which methods their inheritor should implement
- Interfaces enable **multiple inheritance**
    -   One class can implement multiple interfaces and must implement them all
- Interfaces in Java can have default behavior
    -   i.e. methods that have body
- Interfaces in Java can have static methods

<!-- attr: {style: 'font-size: 0.8em'} -->
# Intervaces vs. Abstract Classes

| Interfaces | Abstract Classes |
| ---------- | ---------------- |
| Have default methods | Have normal Methods |
| Declare methods | Have abstract methods |
| Cannot be instantiated directly | Cannot be instantiated directly |
| NO constructors | Can have a constructor |
| Have static methods | Have static methods | 
| Multiple inheritance | Single inheritance |
| NO fields | Have fields |

<!-- section start -->

# Emunerations

# Emunerations

- With enumarations we can define a set of possible values
- _Example:_

```java
enum HttpStatusCodes {
    SUCCESS, ERROR, REDIRECTED
}
```

- Enums in Java are like classes
    -   Constructors
    -   Methods
    -   Fields

<!-- section start -->
<!-- attr: { class:'slide-title', showInPresentation:true, hasScriptWrapper:true, style:'' } -->

<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section' } -->
# Questions
## Defining Classes
[link to Telerik Academy Forum](http://telerikacademy.com/Forum/Category/12/telerik-school-academy)