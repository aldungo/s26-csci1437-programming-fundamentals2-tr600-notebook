# 📖 Lecture 2 Teaching Notes
## Chapter 9: Advanced OOP Concepts (January 23, 2026)

---

## 🎯 Today's Mission
**Goal**: Finish Chapter 9 - Cover advanced topics you mentioned Tuesday  
**Time**: 75 minutes (3:30-4:45 PM)  
**Lab**: 5:00-6:30 PM (Lab 1 support)

---

## ⏰ Time Breakdown

| Time | Activity | Notes |
|------|----------|-------|
| 5 min | Quick recap | Review Tuesday's basics |
| 10 min | `this` keyword | HIGH PRIORITY - "big one" |
| 10 min | Visibility modifiers | Emphasize public/private |
| 10 min | Static members | Class vs instance |
| 10 min | Passing objects | Reference vs value |
| 10 min | Copying objects | Copy constructor |
| 5 min | Method chaining | Bonus if time permits |
| 10 min | Lab 1 check-in | Answer questions |
| 5 min | Week 2 preview | Set expectations |

---

## 🔑 Key Teaching Points

### 1. The `this` Keyword ⭐ HIGHEST PRIORITY
**You said**: "big one, you're going to be using this"

**Three uses to demonstrate**:
1. **Disambiguate** parameter from field
   ```java
   public Student(String name) {
       this.name = name;  // this.name = field, name = parameter
   }
   ```

2. **Call another constructor** (constructor chaining)
   ```java
   public Student() {
       this("Unknown");  // Calls Student(String name)
   }
   ```

3. **Return current object** (for method chaining)
   ```java
   public Student setName(String name) {
       this.name = name;
       return this;  // Enables s.setName("Alice").setAge(20);
   }
   ```

**💡 Teaching Tip**: Show confusing code WITHOUT `this` first, then fix it WITH `this`

---

### 2. Visibility Modifiers (Encapsulation)
**You emphasized**: "public versus private... emphasis"

**Core Message**: 
- **Private fields** = protect the data
- **Public methods** = controlled access to data
- **WHY?** Data validation, security, flexibility

**Live Demo Strategy**:
```java
public class BankAccount {
    private double balance;  // PRIVATE - students can't just set this!
    
    public void deposit(double amount) {
        if (amount > 0) {  // VALIDATION!
            balance += amount;
        }
    }
}
```

**Ask students**: "What if balance was public? Could I just write `account.balance = 1000000`?" 

**Answer**: YES! That's why we make it PRIVATE and use methods with validation.

---

### 3. Static vs Instance
**What students need to know**:
- **Static** = Belongs to the CLASS (shared by all objects)
- **Instance** = Belongs to each OBJECT (unique)
- Static methods can ONLY access static variables

**Example to code**:
```java
private static int numberOfObjects = 0;  // Class-level counter

public Student() {
    numberOfObjects++;  // Increments for ALL students
}

public static int getNumberOfObjects() {
    return numberOfObjects;  // Can't use 'this' here!
}
```

**Call from main**: `Student.getNumberOfObjects()` - called on the CLASS, not an object!

---

### 4. Passing Objects to Methods
**Key concept**: Objects are passed by REFERENCE (unlike primitives)

**Demo**:
```java
public static void changeRadius(Circle c) {
    c.setRadius(20.0);  // Changes the ACTUAL object
}

Circle myCircle = new Circle(5.0);
changeRadius(myCircle);
System.out.println(myCircle.getRadius());  // 20.0 - it changed!
```

**Compare to primitives**:
```java
public static void changeInt(int x) {
    x = 20;  // Only changes the LOCAL copy
}

int myInt = 5;
changeInt(myInt);
System.out.println(myInt);  // Still 5 - unchanged!
```

---

### 5. Copying Objects
**Problem**: Assignment creates an ALIAS, not a copy
```java
Circle c1 = new Circle(5);
Circle c2 = c1;  // ❌ Both point to SAME object!
c2.setRadius(10);
// c1 radius is now 10 too - they're linked!
```

**Solution**: Copy constructor
```java
Circle c2 = new Circle(c1);  // ✅ Creates a NEW object
```

---

## 🎨 Live Coding Strategy

### Your Screen Setup:
- **Left screen** (students see): Blank `Circle.java` and `CircleDemo.java` (student versions)
- **Right screen** (private): `Circle-COMPLETE.java` and teaching notes

### Coding Flow:
1. Start with student version (blank TODOs)
2. Code along WITH students - fill in TODOs together
3. Glance at complete version on right screen for reference
4. Run after each major section to show it works

### Engagement Techniques:
- **Ask before coding**: "What do you think happens if...?"
- **Pause for predictions**: "Guess what this will print?"
- **Common mistakes**: Deliberately forget `this`, show error, then fix
- **Check understanding**: "Can someone explain why this is private?"

---

## 🚨 Common Student Mistakes to Address

1. **Forgetting `this`**: 
   ```java
   public Student(String name) {
       name = name;  // ❌ Assigns parameter to itself!
   }
   ```

2. **Accessing private from outside**:
   ```java
   Circle c = new Circle(5);
   System.out.println(c.radius);  // ❌ Compile error!
   ```

3. **Trying to use instance variables in static methods**:
   ```java
   public static void method() {
       return radius;  // ❌ Can't access instance from static!
   }
   ```

4. **Aliasing instead of copying**:
   ```java
   Circle c2 = c1;  // ❌ Not a copy - same object!
   ```

---

## 📊 Quick Reference: What Tuesday Covered

✅ **Completed Tuesday**:
- OOP philosophy
- Classes vs Objects
- Constructors (basic)
- `new` keyword
- Dot operator
- UML diagrams

❌ **Not Yet Covered** (Today's focus):
- `this` keyword
- public/private
- static/instance
- Passing objects
- Copying objects
- Encapsulation benefits

---

## 🎓 Transition to Lab

**After lecture** (~4:45 PM):
1. "5-minute break, then Lab 1 time!"
2. "I'll be here for questions - use Zoom chat or raise hand"
3. "Lab 1 due TOMORROW night (Friday 11:59 PM)"
4. "If you're stuck, NOW is the time to ask!"

**Lab 1 reminder**:
- GitHub Classroom link in Blackboard
- Should take 30-60 minutes
- Warm-up lab (not graded harshly)
- Test your setup (Java, IDE, GitHub)

---

## 🔮 Week 2 Preview (Last 5 Minutes)

**Next Tuesday** (Jan 28):
- Chapter 10: Thinking in Objects
- More practice with class design
- Real-world examples

**Coming This Week**:
- Lab 2 posted (due next Friday)
- Assignment 1 posted (bigger project, due Feb 7)
- Gamification poll results

**Encouragement**:
"Week 1 was setup and fundamentals. Now we build REAL stuff!"

---

## ✅ Pre-Class Checklist

- [ ] Test both Java files compile and run
- [ ] Blackboard: Post student versions under "Week 1"
- [ ] Zoom: Start recording
- [ ] Screen: Student code on left, notes on right
- [ ] Chat: Monitor for questions during lecture
- [ ] Energy: Coffee ready, upbeat tone!

**You've got this!** 🎯
