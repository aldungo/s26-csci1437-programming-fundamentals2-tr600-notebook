# 📦 Lecture 2 Materials - Chapter 9 Advanced OOP
**Date**: January 22, 2026  
**Topic**: Finishing Chapter 9 - `this`, Encapsulation, Static, Passing/Copying Objects

---

## 📂 What's in This Folder

```
lecture_02_jan23_chapter9/
├── instructor/
│   ├── Circle-COMPLETE.java          ← Your reference (keep on second screen)
│   ├── CircleDemo-COMPLETE.java      ← Complete demo with all concepts
│   ├── TEACHING_NOTES.md             ← This file - your game plan
│   └── Chapter9-INSTRUCTOR.ipynb     ← Notebook with solutions (coming soon)
│
└── student/
    ├── Circle.java                    ← Skeleton with TODOs (students fill in)
    ├── CircleDemo.java                ← Starter code for live coding
    └── Chapter9-Exercises.ipynb       ← Practice exercises (coming soon)
```

---

## 🚀 Quick Start (Pre-Class)

1. **Open TWO editors**:
   - Left screen: `student/Circle.java` (what students see - share this screen)
   - Right screen: `instructor/Circle-COMPLETE.java` (your cheat sheet)

2. **Post to Blackboard** (students folder):
   - `Circle.java` - skeleton file
   - `CircleDemo.java` - demo starter

3. **Copy to Teaching Repo** (when ready):
   ```
   instructor/ → [teaching-repo]/.instructor/prep/lecture_02/
   student/    → [teaching-repo]/chapter09/
   ```

---

## 🎯 Today's Learning Objectives

Students will be able to:
1. Use the `this` keyword to disambiguate parameters and call constructors
2. Apply encapsulation with private fields and public methods
3. Distinguish between static and instance members
4. Understand how objects are passed by reference
5. Create copies of objects using copy constructors
6. Chain methods by returning `this`

---

## 🔑 Key Concepts Covered

### 1. The `this` Keyword ⭐ PRIORITY
- Disambiguate parameter from field: `this.name = name`
- Constructor chaining: `this(defaultValue)`
- Method chaining: `return this`

### 2. Encapsulation (public/private)
- Private fields protect data
- Public methods provide controlled access
- Validation in setters prevents invalid values

### 3. Static Members
- Static variables: Shared by all objects (class-level)
- Static methods: Called on class, not instances
- Static can only access static

### 4. Passing Objects
- Objects passed by reference (changes persist)
- Primitives passed by value (copies made)

### 5. Copying Objects
- Assignment creates alias: `c2 = c1` (same object!)
- Copy constructor creates new object: `new Circle(c1)`

### 6. Method Chaining
- Return `this` from methods
- Enables: `obj.method1().method2().method3()`

---

## 📋 Class Flow (75 minutes)

| Time | Section | File to Use |
|------|---------|-------------|
| 5 min | Recap Tuesday | (verbal) |
| 35 min | Live code Circle.java | `student/Circle.java` |
| 25 min | Live code CircleDemo.java | `student/CircleDemo.java` |
| 10 min | Q&A + Lab 1 check | (verbal) |

**Teaching style**: 
- Code WITH students (they follow along)
- Ask questions before coding: "What should we do here?"
- Show common mistakes, then fix them
- Run code after each major section

---

## 💡 Teaching Tips from Tuesday's Lecture

**Your style** (from transcript analysis):
- ✅ Welcoming, energetic, relatable
- ✅ Real-world examples (Dungo Digital, coffee, building PCs)
- ✅ Emphasis on community and helping students
- ✅ "You get what you put into it" mindset
- ✅ Transparent about this possibly being last semester

**What worked Tuesday**:
- 38/39 attendance - students engaged!
- Polls for interaction
- Clear syllabus walkthrough
- Mix of admin + content

**Apply today**:
- Quick poll at start: "Who finished Lab 1?" or "Coffee or tea?"
- Reference Tuesday: "Remember when we talked about constructors..."
- Encourage questions: "Zoom DM me or chat - fastest response!"

---

## 🎨 Live Coding Strategy

### Setup:
1. Open `student/Circle.java` (the one WITH TODOs)
2. Start at the top, work through each TODO
3. Compile and test after each method

### Example flow for `this` keyword:
```java
// SHOW THE PROBLEM FIRST:
public Circle(double newRadius) {
    radius = newRadius;  // Which radius? 🤔
}

// THEN THE SOLUTION:
public Circle(double newRadius) {
    this.radius = newRadius;  // this.radius = field!
}
```

**Ask**: "What happens if we don't use `this`?"  
**Answer**: "In this case it works, but when names are the SAME, we need `this`!"

---

## 🚨 Anticipated Questions

**Q**: "When do I use static vs instance?"  
**A**: "Ask yourself: Does this belong to the CLASS or to each OBJECT? Counter for all students? Static. Name of one student? Instance."

**Q**: "Why can't I access `radius` directly if I have the object?"  
**A**: "Because it's PRIVATE - encapsulation protects it. Use the getter!"

**Q**: "What's the difference between `c2 = c1` and `c2 = new Circle(c1)`?"  
**A**: "First is an ALIAS (same object). Second is a COPY (new object)."

**Q**: "Do I need `this` everywhere?"  
**A**: "No! Only when there's ambiguity (same names) or when you need to pass/return the current object."

---

## ✅ End of Class Actions

1. **Save and push student versions** to GitHub (teaching repo)
2. **Post to Blackboard**: "Lecture 2 code posted under Week 1"
3. **Remind about Lab 1**: Due tomorrow (Friday) night
4. **Preview next week**: Chapter 10 on Tuesday

**Quick announcement**:
> "Today's code is on Blackboard - both the skeleton and complete versions. Practice on your own! Lab 1 due tomorrow. See you in lab in 15 minutes!"

---

## 🔗 Related Resources

- [THURSDAY_PREP_JAN23.md](../THURSDAY_PREP_JAN23.md) - Original prep doc
- [Chapter 9 Overview](../../course_content/chapter_overviews/chapter_09_overview.md) - Student guide
- [Lecture 1 Analysis](../../transcripts/ANALYSIS_week1_lecture1_jan20.md) - What we covered Tuesday
- [Chapter 9 Textbook](../../course_content/textbook_chapters/chapter_09_objects_and_classes.md) - Full content

---

**Good luck! You've got everything you need. Trust your prep, engage the students, and have fun coding! 🎯☕**
