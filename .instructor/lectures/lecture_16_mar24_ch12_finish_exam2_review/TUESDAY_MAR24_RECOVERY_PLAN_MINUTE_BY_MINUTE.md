# Tuesday Mar 24 Recovery Plan - Finish Chapter 12 + Exam 2 Review
**Course:** CSCI 1437 PF2  
**Time:** 3:30 PM - 4:45 PM (75 min)  
**Exam 2:** Thursday, Mar 26 (Chapters 12 and 13)

---

## Why this plan exists
This session is designed to correct Week 9 delivery friction and guarantee:
- Chapter 12 is fully closed by end of class
- students get a focused review of both Chapters 12 and 13
- students leave with exam-ready confidence and a clear study map

---

## Week 9 breakdown to avoid repeating
Observed from transcript:
- too much opening logistics before concept lock
- live coding detours and compile/debug interruptions
- concept explanation drift before concrete anchor
- not enough structured checkpointing

Fixes in this plan:
- strict time boxes
- pre-selected demos only (no exploration coding)
- concept -> short demo -> quick check cycle
- guaranteed review block at end

---

## Minute-by-minute

### 3:30-3:35 (5 min) | Fast opening and exam framing
- 60-second welcome
- 60-second schedule statement
- 3-minute objective: "finish Ch12 + review Ch12/13"

Script line:
"Today is a mission class: we close Chapter 12 first, then run focused review for both chapters because your exam is Thursday."

---

### 3:35-3:55 (20 min) | Chapter 12 closure block A (exceptions core)
Use only these prepared files:
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithWhile.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithWhile.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java)

Targets:
- throw vs throws
- caller handles, helper throws
- recovery loops
- checked vs unchecked recap (verbal)

Checkpoint prompt:
"In this file, where is the exception created, where is it caught, and what continues afterward?"

Slide anchors to hit in this block:
- Exception-Handling Overview
- Exception Types (intro only here)
- Declaring, Throwing, and Catching Exceptions (intro)

---

### 3:55-4:10 (15 min) | Chapter 12 closure block B (finally + custom exceptions + I/O bridge)
Use:
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/DivisionWithFinally.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/DivisionWithFinally.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InvalidRadiusException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InvalidRadiusException.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/CircleWithCUSTOMException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/CircleWithCUSTOMException.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/ReadInAndReplace.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/ReadInAndReplace.java)

Targets:
- finally guarantees execution
- why custom exceptions improve meaning
- file I/O attaches to checked exceptions (conceptual depth only)

Closure line:
"At this point, Chapter 12 is complete for exam scope."

Slide anchors to hit in this block:
- The finally Clause
- Rethrowing and Chained Exceptions (brief, concept level)
- Defining Custom Exception Classes
- The File Class
- File Input and Output

---

### 4:10-4:25 (15 min) | Chapter 13 high-yield review
Review points only (no long coding):
- abstract class vs interface decision rules
- common supertype and polymorphism use
- Comparable and Cloneable meaning in practice
- weak is-a with interfaces

Prompt set:
1. When do you prefer interface over abstract class?
2. Can a class implement multiple interfaces but extend multiple classes?
3. Why is polymorphism central to Chapter 13 design questions?

---

### 4:25-4:40 (15 min) | Mixed exam drill (Ch12 + Ch13)
Run rapid review prompts that directly map to exam checklist (see matrix below).

Format:
- 60-90 seconds think time per question
- call on 2 students
- instructor confirms and reframes

Goal:
- active retrieval before exam day

---

### 4:40-4:45 (5 min) | Final exam briefing and study map
- restate exam format and timing
- list exactly what to review tonight and Wednesday

Required study checklist:
1. Trace QuotientWithException and InputMismatchExceptionDemo by hand.
2. Memorize throw vs throws and checked vs unchecked definitions with examples.
3. Practice 3 abstract class vs interface decisions.
4. Re-read textbook objective list for Chapter 12 and section summary for Chapter 13.

---

## Non-negotiables for this class
- no spontaneous coding rabbit holes
- no more than 5 minutes on logistics
- each concept ends with one explicit checkpoint question
- Chapter 12 closure statement must happen by 4:10 PM

---

## Exact Exam 2 Review Coverage Matrix (your checklist)

### Chapter 13 items (covered in 4:10-4:25 and 4:25-4:40)
- Number class
- Abstract class vs abstract method
- Abstract classes/interfaces relationship with subclasses
- Possible inheritance
- Understand method matching/method binding
- Hint: Assignment 3 (design language + chapter 13 term mapping)
- Cloneable interface
- compareTo method from Comparable
- Marker interfaces
- Lab 7 tie-in question

### Chapter 12 items (finished by 4:10 and reinforced in 4:25-4:40)
- Order of multiple catch blocks
- Throwable class methods
- Exception class hierarchy
- PrintWriter class
- File class
- Checked vs unchecked exceptions
- Know which exception classes correspond
- Parts of declaring, throwing, and catching exceptions
- try block, catch block, finally clause
- Proper try/catch when reading in input
- try-with-resources

### Fast prompt set for 4:25-4:40 (use in order)
1. What is Number in Java and why does it matter in Chapter 13?
2. Difference between abstract class and abstract method.
3. How do interfaces and abstract classes relate to subclasses?
4. What inheritance combinations are legal in Java?
5. Explain method matching vs method binding in one sentence each.
6. Where did Assignment 3 force Chapter 13 vocabulary?
7. What is Cloneable and what does it indicate?
8. What does compareTo return and why is it useful?
9. Define marker interface and give one example.
10. One Lab 7 design or debugging lesson tied to Ch12/13.
11. Why must catch blocks go most-specific to most-general?
12. Name 2 Throwable methods and what they provide.
13. Sketch Exception hierarchy: Throwable -> Error/Exception -> RuntimeException.
14. Difference between File and PrintWriter responsibilities.
15. Checked vs unchecked + one class example each.
16. Distinguish throw, throws, try, catch, finally.
17. Show safe input pattern with try/catch for user input.
18. Why is try-with-resources preferred for file handles?
