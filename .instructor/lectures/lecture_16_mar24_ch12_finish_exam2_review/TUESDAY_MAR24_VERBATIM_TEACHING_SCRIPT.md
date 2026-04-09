# Tuesday Mar 24 Verbatim Script - Finish Chapter 12 + Review for Exam 2
**Course:** CSCI 1437 PF2  
**Class window:** 3:30 PM - 4:45 PM  
**Exam:** Thursday Mar 26 (Chapters 12 and 13)

---

## 3:30-3:35 | Opening (say this directly)
"Good afternoon everyone. Today is a mission class."

"By the end of this session, Chapter 12 will be finished, and we will complete review for Chapters 12 and 13 for Exam 2 on Thursday."

"I will keep this class very structured: short concept, direct demo, quick checkpoint."

"If you stay engaged for these 75 minutes, your exam prep becomes much easier."

---

## 3:35-3:55 | Chapter 12 closeout part 1
"First anchor: throw vs throws."

"throw creates and sends an exception object at the point of failure."

"throws appears in a method header and declares possible exceptions to callers."

"Second anchor: helper methods throw, calling methods handle."

"That is good design because it keeps responsibility clear."

Use and narrate:
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithWhile.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithWhile.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java)

Checkpoint prompt to class:
"Tell me: where is the exception thrown, where is it caught, and how does the program continue?"

---

## 3:55-4:10 | Chapter 12 closeout part 2
"Third anchor: checked vs unchecked exceptions."

"Unchecked: RuntimeException and Error families, compiler does not force handling."

"Checked: other Exception types, compiler requires catch or throws."

"Fourth anchor: finally always runs, which is why we use it for reliable cleanup."

"Fifth anchor: custom exceptions give domain-specific meaning and better feedback."

Use and narrate:
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/DivisionWithFinally.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/DivisionWithFinally.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InvalidRadiusException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InvalidRadiusException.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/CircleWithCUSTOMException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/CircleWithCUSTOMException.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/ReadInAndReplace.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/ReadInAndReplace.java)

Chapter-close line:
"At this point, Chapter 12 exam scope is complete."

---

## 4:10-4:25 | Chapter 13 review (high-yield only)
"Now we switch to Chapter 13 review."

"Question 1: When do we prefer an interface over an abstract class?"

"Question 2: Why can interfaces model capabilities across unrelated classes?"

"Question 3: What is the practical limit with class inheritance that interfaces avoid?"

"Question 4: How does polymorphism connect directly to Chapter 13 design?"

"Also make sure you can explain Number class, Cloneable, Comparable and compareTo, and marker interfaces in plain language."

"Use Assignment 3 terms as a memory anchor for Chapter 13 vocabulary and design expectations."

Instructor wrap line:
"If you can answer these clearly, you are ready for the design-style Chapter 13 exam questions."

---

## 4:25-4:40 | Mixed exam drill (rapid retrieval)
"We will now do a fast full-checklist sprint so every exam review target is touched."

"Do not overthink wording. Focus on control flow and design reasoning."

Drill prompts:
1. "What is Number class and where did you see it in Chapter 13 context?"
2. "Difference between abstract class and abstract method."
3. "How do abstract classes/interfaces connect to subclasses?"
4. "Can Java do multiple class inheritance? What can be multiple instead?"
5. "Method matching vs method binding: one sentence each."
6. "How did Assignment 3 reflect Chapter 13 ideas?"
7. "What does Cloneable indicate?"
8. "What does compareTo from Comparable return and why?"
9. "What is a marker interface?"
10. "Name one Lab 7 lesson that connects to exam concepts."
11. "Order of multiple catch blocks and why that order matters."
12. "Name two Throwable methods and what they provide."
13. "Describe the exception hierarchy from Throwable downward."
14. "Difference between File class and PrintWriter class."
15. "Checked vs unchecked: definition plus one class each."
16. "Parts of declaring, throwing, and catching exceptions."
17. "Role of try block, catch block, finally clause."
18. "Show proper try/catch for reading user input."
19. "What does try-with-resources guarantee?"

---

## 4:40-4:45 | Exam briefing close
"Final reminders: Exam 2 is Thursday March 26, covers Chapters 12 and 13 only."

"Tonight and tomorrow, prioritize these exact items:"
1. "Trace QuotientWithException and InputMismatchExceptionDemo by hand."
2. "Review throw vs throws, checked vs unchecked, finally behavior."
3. "Practice interface vs abstract class decisions with examples."

"You are in good shape if you can explain flow clearly, not just memorize syntax."

"Reach out today if anything still feels fuzzy so we can clear it before exam day."

---

## Backup recovery lines (if class energy dips)
- "Pause. We only need control flow clarity, not perfect syntax memorization."
- "Track three locations: where error is created, where it travels, where it is handled."
- "If a method can fail, ask who should own the response decision."
