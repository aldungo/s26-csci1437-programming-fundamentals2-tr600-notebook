# Lecture 12 Game Plan - Chapter 13 Interfaces
**Thursday, February 26, 2026 | 3:30-4:45 PM**

---

## Pre-Class Setup (3:25-3:30)

- [ ] Display welcome board HTML
- [ ] Open code examples file (ready to type live)
- [ ] Have Chapter 13 slides/diagrams ready
- [ ] Test screen share/mic

---

## Timeline

### 3:30-3:35 (5 min) - Opening + Polls

**Launch 2 Quick Polls:**

**Poll 1: Abstract Classes Recap**
"Which statement about abstract classes is TRUE?"
- A) You can create objects directly from abstract classes
- B) Abstract classes can have both abstract AND concrete methods
- C) All methods in an abstract class must be abstract
- D) Abstract classes can't have constructors

**Poll 2: Weather Poll (FUN)**
"Quick fun question: Warm weather or cold weather?"
- A) ☀️ Warm weather - bring the sunshine!
- B) ❄️ Cold weather - cozy vibes!

Close polls, briefly react to results (30 sec), transition:
"Alright! Today we're making interfaces REAL with actual code examples. Let's dive in!"

---

### 3:35-3:50 (15 min) - Part 1: Edible Interface

**Start with Relatable Example:**
"What do apples and chicken have in common? They're both edible! But they're completely different - one's a fruit, one's an animal. This is PERFECT for interfaces."

**Live Code (from textbook Ch 13):**

```java
// 1. Define the Edible interface
public interface Edible {
    public abstract String howToEat();
}

// 2. Animal abstract class (NOT all animals are edible!)
abstract class Animal {
    public abstract String sound();
}

// 3. Tiger extends Animal (NOT edible)
class Tiger extends Animal {
    @Override
    public String sound() {
        return "Tiger: RROOAARR";
    }
}

// 4. Chicken extends Animal AND implements Edible
class Chicken extends Animal implements Edible {
    @Override
    public String howToEat() {
        return "Chicken: Fry it";
    }
    
    @Override
    public String sound() {
        return "Chicken: cock-a-doodle-doo";
    }
}

// 5. Fruit abstract class implements Edible
abstract class Fruit implements Edible { }

// 6. Apple extends Fruit
class Apple extends Fruit {
    @Override
    public String howToEat() {
        return "Apple: Make apple cider";
    }
}

// 7. Test with Object array (polymorphism!)
Object[] objects = {new Tiger(), new Chicken(), new Apple()};
for (Object obj : objects) {
    if (obj instanceof Edible)
        System.out.println(((Edible)obj).howToEat());
    if (obj instanceof Animal)
        System.out.println(((Animal)obj).sound());
}
```

**Key Points to Emphasize:**
- Interface = pure contract (no body)
- Tiger is Animal but NOT Edible
- Chicken is BOTH Animal AND Edible (multiple inheritance!)
- Apple is Edible but NOT Animal
- Polymorphism works with interfaces

---

### 3:50-4:10 (20 min) - Part 2: Comparable Interface

**The Problem:**
"How do we sort custom objects? Arrays.sort() works on ints, Strings... but what about Rectangles?"

**Live Code (using GeometricObject from Tuesday!):**

```java
// 1. Start with GeometricObject abstract class (from Tuesday)
public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }
    
    // Abstract methods - subclasses MUST implement
    public abstract double getArea();
    public abstract double getPerimeter();
}

// 2. Rectangle extends GeometricObject AND implements Comparable
public class Rectangle extends GeometricObject 
                        implements Comparable<Rectangle> {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    // From Comparable interface - sort by AREA
    @Override
    public int compareTo(Rectangle o) {
        if (getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
        else
            return 0;
    }
}

// 3. Now we can sort Rectangles!
Rectangle[] rectangles = {
    new Rectangle(3.4, 5.4),    // area = 18.36
    new Rectangle(13.24, 55.4), // area = 733.50
    new Rectangle(7.4, 35.4)    // area = 261.96
};

java.util.Arrays.sort(rectangles);  // Uses compareTo!
for (Rectangle r : rectangles) {
    System.out.println(r);  // Sorted by area!
}
```

**Key Points:**
- Rectangle extends GeometricObject (inheritance from Tuesday)
- Rectangle implements Comparable (new interface today)
- compareTo returns: negative (this < other), zero (equal), positive (this > other)
- Arrays.sort() uses compareTo under the hood

---

### 4:10-4:25 (15 min) - Part 3: Cloneable Interface

**The Problem:**
"How do we copy objects? Variable assignment doesn't work!"

```java
Rectangle r1 = new Rectangle(5, 10);
Rectangle r2 = r1;  // NOT A COPY! Same object, two references
r2.setWidth(20);
System.out.println(r1.getWidth());  // 20 (BOTH changed!)
```

**Show Built-in Examples First:**

```java
// Calendar is Cloneable
java.util.Calendar cal1 = new java.util.GregorianCalendar(2013, 2, 1);
java.util.Calendar cal2 = (java.util.Calendar)cal1.clone();
System.out.println(cal1 == cal2);  // false (different objects!)

// ArrayList is Cloneable
java.util.ArrayList<Double> list1 = new java.util.ArrayList<>();
list1.add(1.5);
list1.add(2.5);
java.util.ArrayList<Double> list2 = (java.util.ArrayList<Double>)list1.clone();
list2.add(3.5);  // Only added to list2!
```

**Now Add to Our Rectangle:**

```java
// Rectangle now implements BOTH Comparable AND Cloneable!
public class Rectangle extends GeometricObject 
                        implements Comparable<Rectangle>, Cloneable {
    private double width;
    private double height;
    
    // ... getArea(), compareTo() from before ...
    
    // Add clone method
    @Override
    public Object clone() {
        try {
            Rectangle rectangleClone = (Rectangle) super.clone();
            return rectangleClone;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}

// Usage:
Rectangle r1 = new Rectangle(3, 5);
Rectangle r2 = (Rectangle)r1.clone();  // ACTUAL COPY!
r1.setWidth(4);
r2.setWidth(6);
System.out.println(r1);  // 4x5
System.out.println(r2);  // 6x5 (independent!)
```

**Key Point:**
- Cloneable is a "marker interface" (empty)
- Rectangle now has TWO interfaces: Comparable AND Cloneable
- Shallow vs deep copy (mention briefly if time)

---

### 4:25-4:35 (10 min) - Part 4: Putting It All Together

**Show the Big Picture:**

```java
// Rectangle is the ULTIMATE example:
// 1. EXTENDS one abstract class (GeometricObject)
// 2. IMPLEMENTS two interfaces (Comparable, Cloneable)

public class Rectangle extends GeometricObject 
                        implements Comparable<Rectangle>, Cloneable {
    // Inheritance: gets color, filled, dateCreated from GeometricObject
    // Must implement: getArea(), getPerimeter() (abstract methods)
    // Must implement: compareTo() (from Comparable)
    // Must implement: clone() (from Cloneable)
}
```

**Quick Decision Guide (show on screen):**

| Question | Use This |
|----------|----------|
| "Is this a more specific type?" | Extend abstract class (Circle IS-A GeometricObject) |
| "Can it do this action?" | Implement interface (Rectangle CAN-BE-COMPARED) |
| "Share common implementation?" | Abstract class (color/filled methods) |
| "Pure capability, no shared code?" | Interface (compareTo is different for each class) |

**Real Examples from Today:**
- **Chicken:** extends Animal, implements Edible (inheritance + capability)
- **Rectangle:** extends GeometricObject, implements Comparable + Cloneable (inheritance + 2 capabilities)
- **Apple:** extends Fruit, implements Edible (through Fruit)

**Multiple Interfaces Example:**
```java
public class Rectangle extends GeometricObject 
                        implements Comparable<Rectangle>, Cloneable {
    // Can do BOTH: sortable AND copyable!
}

Rectangle[] rects = {r1, r2, r3};
Arrays.sort(rects);  // Uses Comparable
Rectangle copy = (Rectangle)r1.clone();  // Uses Cloneable
```

**Key Insight:**
- Java allows ONE parent class (extends)
- Java allows MANY interfaces (implements)
- This is how Java does "multiple inheritance"

---

### 4:35-4:45 (10 min) - Wrap-Up + Lab Preview

**Quick Recap (hit these 4 things):**
1. **Edible:** Tiger/Chicken/Apple - unrelated classes sharing capability
2. **Comparable:** Rectangle sorting by area - make custom objects sortable
3. **Cloneable:** Rectangle copying - make objects copyable (Calendar, ArrayList examples)
4. **Key difference:** 
   - Abstract classes (GeometricObject, Animal) = shared implementation
   - Interfaces (Edible, Comparable, Cloneable) = pure contracts
   - Can extend ONE class, implement MANY interfaces

**Lab 6 Preview:**
"Lab 6 is posted! You'll build an Inventory System using abstract classes and ArrayList."

**What to expect:**
- Create an **abstract Inventory class** with an abstract method
- Build ItemInventory subclass that implements the abstract method
- Use ArrayList<Item> to manage collections
- Practice with abstract classes (connects to GeometricObject we've been using!)
- Due Tuesday 3/4 at 11:59 PM

**Connection to Today's Lecture:**
"We're covering interfaces today (Edible, Comparable). Lab focuses on abstract classes (like GeometricObject). Both are Chapter 13 - different tools for different jobs!"

**Questions:**
- Open floor for 2-3 quick questions
- "What clicked today? What's still fuzzy?"

**If Time Permits (BONUS):**
Show Rational class: extends Number (abstract) AND implements Comparable
"This is advanced - Rational fractions that can be added, compared, sorted!"

**Dismiss to Lab (5:00 PM)**

---

## Teaching Notes

**Example Progression (building complexity):**
1. Start simple: Edible interface (Tiger/Chicken/Apple)
2. Add sorting: Rectangle implements Comparable (uses GeometricObject from Tuesday)
3. Add copying: Rectangle implements Cloneable (now has TWO interfaces!)
4. Show polymorphism: GeometricObject array with Circle/Rectangle

**All examples match Chapter 13 textbook code** - students can reference book examples

**If Running Behind:**
- Shorten Edible example (skip Tiger, just show Chicken/Apple)
- Part 3: Show Calendar/ArrayList clone quickly, focus on Rectangle clone
- Part 4: Just show the decision table, skip extra examples

**If Running Ahead:**
- Show Rational class (extends Number, implements Comparable) - advanced bonus
- Demonstrate Number abstract class with ArrayList<Number>
- Show equals() override in Rectangle

**Energy Check:**
- After Part 2 (4:10): "Everyone good? Questions so far?"
- Keep energy up - interfaces can feel abstract, make them REAL with examples

**Common Student Struggles:**
- "Why can't I just use abstract class for everything?" → Show Chicken (extends Animal, implements Edible) - can't extend two classes!
- "What's the difference between implements and extends?" → extends = class inheritance, implements = interface contract
- "Do I need @Override?" → Not required but HIGHLY recommended (catches typos)
- "Why does clone() return Object?" → Historical Java design, need to cast

---

## Success Criteria

✅ Students can explain difference between abstract class and interface
✅ Students understand Comparable, Cloneable, and Edible interfaces
✅ Students see how interfaces enable polymorphism with unrelated classes
✅ Students feel confident about Chapter 13 concepts (both abstract classes and interfaces)
✅ Students ready to implement abstract classes in Lab 6

---

**Key Message:** "Interfaces are contracts. Classes sign the contract by implementing them. That's it. Simple concept, powerful tool!"
