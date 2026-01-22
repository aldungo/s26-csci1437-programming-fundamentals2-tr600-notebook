# Managing Multi-File Chapters in Jupyter Notebooks

## The Problem
Programming Fundamentals II has more complex projects with multiple `.java` files per chapter, making it harder to keep everything in one notebook.

## Recommended Solution: Hybrid Approach

### Structure per Chapter
```
chapter9/
  ├── README.md                    ← Quick navigation for students
  ├── Chapter9-Notes.ipynb         ← Your lecture notes/theory
  ├── src/                         ← Runnable code
  │   ├── Circle.java
  │   ├── Rectangle.java
  │   └── TestShapes.java
  └── .instructor/                 ← Your prep (gitignored)
      ├── Chapter9-ANSWER-KEY.ipynb
      └── prep-notes.md
```

### In Your Notebook

**Option 1: Reference with explanations**
````markdown
# Chapter 9: OOP and Classes

## 1. Creating the Circle Class
See [Circle.java](src/Circle.java) for the full implementation.

Key concepts:
- Instance variables
- Constructors
- Getters/setters

```java
// Quick reference (full code in Circle.java)
public class Circle {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    // ... more code in file
}
```
````

**Option 2: Embed code with file links**
````markdown
## Circle Class Implementation

Full file: [src/Circle.java](src/Circle.java)

```java
[paste full code here for notebook view]
```

**Run it:** 
- Open terminal in chapter9/src/
- Compile: `javac Circle.java`
- Test: `javac TestShapes.java && java TestShapes`
````

**Option 3: Multiple notebooks per concept**
```
chapter9/
  ├── 01-Classes-Intro.ipynb       ← Basic class structure
  ├── 02-Constructors.ipynb        ← Constructor details
  ├── 03-Methods.ipynb             ← Methods and behavior
  └── src/                         ← All .java files together
```

## For Teaching
1. **Before class**: Prep code in `src/` folder, notes in `.instructor/`
2. **During class**: Open notebook for theory, switch to VS Code for live coding
3. **After class**: Update notebook with what you actually covered
4. **Backfill**: Run `.\sync-to-students.ps1 "Week 10 OOP complete"`

## Benefits
- ✅ Students get runnable `.java` files (better for IDEs)
- ✅ Notebook stays focused on concepts/theory
- ✅ You can still use Copilot to prep `.java` files
- ✅ Less clutter in notebooks (no massive code blocks)

## Example README.md for Students
```markdown
# Chapter 9: Object-Oriented Programming

## Files in this chapter
- **Chapter9-Notes.ipynb** - Lecture notes and concepts
- **src/Circle.java** - Circle class implementation
- **src/Rectangle.java** - Rectangle class implementation  
- **src/TestShapes.java** - Driver/test program

## How to use
1. Read through the notebook for theory
2. Code along using the src/ files
3. Run: `cd src && javac *.java && java TestShapes`
```
