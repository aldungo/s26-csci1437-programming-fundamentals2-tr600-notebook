# 📦 Lecture 4 Materials - Chapter 10 Part 2: Wrapper Classes & Strings
**Date**: Thursday, January 29, 2026  
**Topic**: Processing Primitives as Objects, String/StringBuilder

---

## 🎯 Today's Focus (Based on Your Slides)

### Core Topics:
1. **Wrapper Classes** - Integer, Double, Character, etc.
2. **Boxing & Unboxing** - Converting between primitives and objects
3. **String Class** - Immutable string processing
4. **StringBuilder** - Mutable string building
5. **Practical Examples** - Parsing, palindromes, regex basics

---

## 📂 Folder Contents

```
lecture_04_jan30_chapter10_part2/
├── instructor/
│   ├── WrapperClasses-COMPLETE.java        ← All wrapper demos
│   ├── StringProcessing-COMPLETE.java      ← String/StringBuilder demos
│   └── TEACHING_NOTES.md                   ← Your game plan (coming)
│
└── student/
    ├── WrapperClasses.java                  ← Skeleton with TODOs
    └── StringExercises.java                 ← Practice problems
```

---

## 🔑 Key Teaching Points (from Slides)

### 1. Why Wrapper Classes?
**The Problem**: Primitives are NOT objects
- No references, no methods
- More direct storage = faster, but limited features
- Can't use primitives where objects are needed (e.g., ArrayList<int> ❌)

**The Solution**: Wrapper classes
- `Byte, Short, Integer, Long, Float, Double, Boolean, Character`
- Each wraps a primitive value as an object
- Adds methods for conversion, comparison, parsing

**Real-world analogy**: 
"It's like putting a number in a box. The box (wrapper) gives you handles to manipulate it!"

---

### 2. Creating Wrapper Objects
**Two ways** (from slides):
```java
// Constructor (deprecated in newer Java)
Integer x1 = new Integer(32);

// valueOf (preferred - may intern!)
Integer x2 = Integer.valueOf(32);
```

**INTERNING** (memory optimization):
- Frequently used values (-128 to 127 for Integer) are cached
- `valueOf` reuses cached objects → memory efficient
- `x3 == x4` may be `true` if both are interned!

**Teaching point**: "Always use `.equals()` to compare VALUES, not `==`"

---

### 3. Boxing & Unboxing
**Boxing**: primitive → wrapper object
```java
int primitive = 42;
Integer wrapped = Integer.valueOf(primitive);  // Boxing
```

**Unboxing**: wrapper → primitive
```java
Integer wrapped = 42;
int primitive = wrapped.intValue();  // Unboxing
```

**AUTOBOXING** (Java magic!):
```java
Integer auto = 100;      // Autoboxing: int → Integer
int autoUnbox = auto;    // Autounboxing: Integer → int
```

**When it happens automatically**:
- Assignment: `Integer x = 5;`
- Method parameters: `void method(Integer i)` called with `method(5)`
- Return values: `Integer getValue() { return 10; }`

---

### 4. Parsing Strings to Numbers
**Super practical** - user input is always Strings!

```java
String input = "123";
int num = Integer.parseInt(input);  // String → int

String decimal = "3.14";
double pi = Double.parseDouble(decimal);  // String → double
```

**With bases** (from slides):
```java
int binary = Integer.parseInt("1010", 2);   // 10 in decimal
int hex = Integer.parseInt("FF", 16);       // 255 in decimal
```

**Demo idea**: Take user input, parse to number, do calculations

---

### 5. Comparison Methods
**compareTo** (from slides):
- Returns `1` if calling object > parameter
- Returns `-1` if calling object < parameter
- Returns `0` if equal

```java
Double d1 = 12.4;
Double d2 = 12.3;
d1.compareTo(d2);  // Returns 1 (12.4 > 12.3)
```

**Useful for sorting!**

---

### 6. Wrapper Constants
**Every numeric wrapper has**:
- `MAX_VALUE` - largest possible value
- `MIN_VALUE` - smallest possible value

```java
System.out.println(Integer.MAX_VALUE);  // 2147483647
System.out.println(Double.MIN_VALUE);   // 4.9E-324
```

---

### 7. String Immutability (CRITICAL!)
**Key concept** (from slides):
> "String objects are immutable (cannot be changed).  
> Modifying a String is actually constructing a new String object."

**Demo**:
```java
String s1 = "Java";
String s2 = s1;      // s2 → same object
s1 = s1 + " Fun";    // s1 → NEW object, s2 → original
```

**Why immutability**:
- Security (can't be changed after creation)
- Thread-safe (multiple threads can share)
- Enables interning (memory efficiency)

**Downside**: Lots of String concatenation = lots of new objects = slow!

---

### 8. String Interning
**All String literals are interned** (from slides):
```java
String s1 = "Welcome";
String s2 = "Welcome";
s1 == s2;  // true! Same interned object
```

**BAD practice** (creates unnecessary object):
```java
String s3 = new String("Welcome");  // ❌ Don't do this!
```

**Why bad**: Creates literal + explicit object (wasteful)

---

### 9. Common String Methods
**Must-know methods**:
- `length()` - number of characters
- `charAt(index)` - character at position
- `substring(start, end)` - extract substring
- `indexOf(char)` - find position
- `contains(str)` - check if contains
- `toUpperCase() / toLowerCase()` - case conversion
- `replace(old, new)` - replace characters
- `split(delimiter)` - split into array
- `trim()` - remove whitespace

**Live demo**: Show 5-6 of these with examples

---

### 10. StringBuilder (Mutable Alternative)
**When to use**:
- Building strings in loops
- Lots of modifications
- Performance matters

**Key methods** (from slides):
- `append(str)` - add to end
- `insert(index, str)` - insert at position
- `delete(start, end)` - remove range
- `deleteCharAt(index)` - remove one char
- `reverse()` - reverse the string
- `replace(start, end, str)` - replace range
- `setCharAt(index, ch)` - change one char

**Difference from String**:
```java
String s = "Hello";
s.concat(" World");     // Creates NEW string (s unchanged)

StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");    // Modifies SAME object
```

---

### 11. Palindrome Example (from Slides)
**Problem**: Check if alphanumeric characters form palindrome
```
Input: "1!aa?1"
Remove non-alphanumeric: "1aa1"
Reverse: "1aa1"
Compare: true (palindrome!)
```

**Implementation strategy**:
1. Filter to alphanumeric only (Character.isLetterOrDigit)
2. Convert to lowercase
3. Use StringBuilder.reverse()
4. Compare original to reversed

**Live code this!** - students love palindromes

---

### 12. Regular Expressions (Regex) - BONUS
**If time permits** (from slides):
- `.` (dot) = wildcard (any character)
- `*` = 0 or more of previous character
- `+` = 1 or more of previous character
- `{n}` = exactly n of previous character
- `?` = optional (0 or 1)
- `[abc]` = choice of a, b, or c
- `\\d` = any digit
- `\\w` = any word character
- `\\s` = any whitespace

**Example**:
```java
"Java".matches("Java");       // true
"Java is fun".matches("Java.*");  // true (* = any chars after)
```

**Phone number validation** (from slides):
```java
String phone = "123-456-7890";
boolean valid = phone.matches("\\d{3}-\\d{3}-\\d{4}");
```

**Keep it light** - regex can be overwhelming!

---

## 📊 Lecture Flow (75 minutes)

| Time | Section | Activity |
|------|---------|----------|
| 20 min | Wrapper Classes | Lecture + boxing/unboxing demo |
| 15 min | Parsing & Conversions | Live examples with user input |
| 20 min | String Methods | Demo 8-10 common methods |
| 15 min | StringBuilder | Build a string in a loop, show performance |
| 5 min | Palindrome Demo | Code the checker together |
| 5 min | Week 3 Preview | Lab 2, Assignment 1 reminders |

---

## 💡 Engagement Ideas

**Poll**: "How many have done String manipulation in other languages?"

**Challenge**: "Who can guess what `Integer.MAX_VALUE + 1` equals?"
- Answer: `Integer.MIN_VALUE` (overflow wraps around!)

**Live Exercise**: "Let's parse user input and calculate something"
- Take two numbers as Strings from Scanner
- Parse to int/double
- Do math, print result

---

## 🚨 Common Student Questions

**Q**: "Why does `Integer x = 5` work without `new Integer(5)`?"  
**A**: "Autoboxing! Java automatically wraps the primitive. Saves typing!"

**Q**: "When should I use String vs StringBuilder?"  
**A**: "Use String for simple stuff. Use StringBuilder when building strings in loops or doing lots of modifications."

**Q**: "Why is String immutable?"  
**A**: "Security, thread-safety, and memory efficiency (interning). It's a design choice that makes Java safer!"

**Q**: "Do I need to memorize all String methods?"  
**A**: "Nope! Know the common ones (length, charAt, substring, indexOf). Look up others in documentation when needed."

**Q**: "What's the difference between `==` and `.equals()` for Strings?"  
**A**: "`==` compares references (are they the SAME object?). `.equals()` compares content (same text?). Always use `.equals()` for Strings!"

---

## 🔗 Resources

- [Chapter 10 Slides](../../course_content/slides/ch10slides.md)
- [Chapter 10 Textbook](../../course_content/textbook_chapters/chapter_10_oop.md)
- [Lecture 3 Materials](../lecture_03_jan28_chapter10_part1/README.md)
- Java API Docs: [String](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)

---

## ✅ Pre-Class Checklist

- [ ] Test all wrapper examples
- [ ] Prepare palindrome demo
- [ ] Have String method examples ready
- [ ] StringBuilder performance comparison ready
- [ ] User input parsing example prepped
- [ ] Lab 2 assignment ready to post

---

**Next Week** (Feb 4): Chapter 11 - Inheritance! 🎉
