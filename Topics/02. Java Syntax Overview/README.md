<!-- section start -->

<!-- attr: {id: 'title', class: 'slide-title', hasScriptWrapper: true} -->
# Java Syntax Overview
##  Data types, conditionals, loops, arrays, functions
<div class="signature">
    <p class="signature-course">Mobile applications with Android</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>

<!-- section start -->
<!-- attr: { id:'table-of-contents', class:'table-of-contents', style:'font-size:0.9em'} -->
# Table of Contents

- Data Types
- Conditionals
- Operators
- Loops
- Methods


<!-- section start -->

<!-- attr: {class: 'slide-section', id: 'how-computing-works'} -->
# Data Types
## Primitive and Object Types

# Data Types in Java

- Java supports all the fundamental data types
  - `byte` (8 bits), `short` (16 bits), `int` (32 bits), `long` (64 bits)
    - There are no unsigned types
  - `float` (32 bits) and `double` (64 bits)
    - Not precise
  - `BigDecimal` (64 bits)
    - Precise
  - `String` is immutable string
  - `char` (8 bit)
  - `boolean` (1 bit)

# Data Types in Java

- `BigInteger`
  - For large numbers
  - Has no limit to size
  - `true` or `false`
- There are also object types for primitive types
  - `Integer`, `Double`, etc..
  - Are are of `Object` type and can be boxed/unboxed
  - Can have `null` value

<!-- attr: {style: "font-size: 0.7em"} -->
# Operators in Java

| Category             | Operators                                    |
| -------------------- | -------------------------------------------- |
| Arithmetic           | `+ - *  /  %  ++  --`                        |
| Logical              | `&&` II `^  !  `                             |
| Binary               | `& ^ ~ << >> >>> <<<` I                      |
| Comparison           | `== != < > <= >=`                            |
| Assignment           | `= += -= *= /= %=` <br/>`&= ^= <<= >>=` I`=` |
| String Concatenation | `+`                                          |
| Type Conversion      | `is as typeof`                               |
| Other                | `. [ ] ( ) ? : new`                          |


# Conditionals in Java
- Supports `if`, `if-else`, `if-else-if-else` constructs
  - Same as in any other language
  - The conditional must always be `boolean`
- Supports `switch-case`
  - Same as in any language
  - Has **fall through** rule

<!-- attr: {style: "font-size: 0.7em"} -->
# Loops in Java

- `while`, `do-while`
  - Repeats body while condition is true

    ```java
    while(condition) { }
    do { } while(condition);
    ```

- `for`
  - Repeats body prefined times

  ```java
  for(int i = 0; i < 10; i++) { }
  ```

- `for-in`
  - iterates though the elements of a collection (array, list, etc...)
  -
  ```java
  for(String name: names) { }
  ```

<!-- attr: {style: "font-size: 0.9em"} -->
# Arrays in Java?

- Arrays in Java are absolutely the same as in C#, C++, etc...
  - They have fixed size
  - They hold values of the same type

```java
int[] numbers = {1, 2, 3, 4, 5, 6};
int[] powers = new int[numbers.length];
for(int i = 0; i < numbers.length; i++) {
  powers[i] = numbers[i]*numbers[i];
}
```

- Multidimentional arrays are actually arrays of arrays:

```java
int[][] matrix = new int[5][];
int[][][] cube = new int[3][][];
```


# Methods

- Methods are named fractions of code
  - Can have parameters
  - Can return value
  - There are no default parameters

```java
int sum(int x, int y) {
  return x + y;
}
int sum(int... numbers) {
  return Arrays.stream(numbers)
    .sum();
}
```

<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section' } -->
# Questions
## Mobile Applications for Android
[link to the forum](http://telerikacademy.com/Forum/Category/64/android-mobile-apps)
