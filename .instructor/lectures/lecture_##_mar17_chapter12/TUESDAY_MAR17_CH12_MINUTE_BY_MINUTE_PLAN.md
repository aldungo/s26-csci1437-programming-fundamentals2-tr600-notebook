# Tuesday March 17, 2026 - Chapter 12 Minute-by-Minute Plan
**Course:** CSCI 1437 PF2  
**Session Length:** 3:30 PM - 4:45 PM (75 min)  
**Instructional Strategy:** Slides first -> textbook reinforcement -> instructor code examples  
**Exam Context:** Exam 2 covers **Chapter 12 + Chapter 13 only** (review day: Tue Mar 24, exam: Thu Mar 26)

---

## 0) Pacing Targets (Now -> Mar 24)
- **Tue Mar 17:** Lock core exception model + try/catch flow + checked/unchecked + finally.
- **Thu Mar 19:** No class meeting (assign focused async reinforcement, not new content overload).
- **Tue Mar 24 (Review Day):** 50/50 review split between Ch12 and Ch13 with integrated practice questions.

**Result goal by Mar 24:** Students can explain and code Chapter 12 basics without confusing `throw`, `throws`, `try/catch`, propagation, and `finally`.

---

## 1) Source Map Used for This Plan
### Slides-first spine
- [data/courses/spring2026/CSCI1437_PF2/course_content/slides/ch12slides.md](data/courses/spring2026/CSCI1437_PF2/course_content/slides/ch12slides.md)

### Transcript pacing cues (old Chapter 12 delivery)
- [data/courses/spring2026/CSCI1437_PF2/transcripts/oldchapter12/27feb2024.vtt](data/courses/spring2026/CSCI1437_PF2/transcripts/oldchapter12/27feb2024.vtt)
- [data/courses/spring2026/CSCI1437_PF2/transcripts/oldchapter12/29feb2024.vtt](data/courses/spring2026/CSCI1437_PF2/transcripts/oldchapter12/29feb2024.vtt)
- [data/courses/spring2026/CSCI1437_PF2/transcripts/oldchapter12/5march2024.vtt](data/courses/spring2026/CSCI1437_PF2/transcripts/oldchapter12/5march2024.vtt)

### Your Chapter 12 code examples (primary demos)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithMethod.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithMethod.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithWhile.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithWhile.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/DivisionWithFinally.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/DivisionWithFinally.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InvalidRadiusException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InvalidRadiusException.java)
- [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/ReadInAndReplace.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/ReadInAndReplace.java)

### Textbook reinforcement
- [data/courses/spring2026/CSCI1437_PF2/course_content/textbook_chapters/chapter12.md](data/courses/spring2026/CSCI1437_PF2/course_content/textbook_chapters/chapter12.md)

---

## 2) Minute-by-Minute Plan (Tue Mar 17)

### 3:30-3:36 (6 min) - Re-entry + context reset
**Talk track (transcript-aligned):**
- Welcome back from Spring Break.
- We finished Ch13 before break and began Ch12.
- Today: clean up the **core exception system** so next week review feels easy.
- Reminder: Thu Mar 19 no class; Exam 2 is Thu Mar 26.

**Board prompt:**
- `Error happens -> exception thrown -> call stack search -> catch handler -> continue or terminate gracefully`

---

### 3:36-3:48 (12 min) - Slides: exception overview (no code yet)
Use slide sections from [ch12slides.md](data/courses/spring2026/CSCI1437_PF2/course_content/slides/ch12slides.md):
- Runtime error vs exception object
- Why unhandled exceptions terminate abnormally
- Caller handles, helper throws (cohesion + flexibility)

**Cold-call checks (fast):**
1. Why is `System.exit(1)` inside helper methods usually bad design?
2. What is the practical difference between a crash and graceful handling?

---

### 3:48-4:00 (12 min) - Demo 1: from bad flow to good flow
**Progression:**
1. Show [QuotientWithMethod.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithMethod.java) (forced exit model).
2. Refactor mentally to [QuotientWithException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java).

**Teach points:**
- `throw` creates and throws exception object.
- `try/catch` in caller gives control.
- Program can continue after handling.

**Checkpoint #1:**
- Students explain why throwing from helper + catching in caller is better than exiting.

---

### 4:00-4:10 (10 min) - Demo 2: recovery loops + input mismatch
Use:
- [QuotientWithWhile.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithWhile.java)
- [InputMismatchExceptionDemo.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java)

**Teach points:**
- Exceptions can support recovery loops, not just error prints.
- Distinguish `ArithmeticException` from `InputMismatchException`.
- Why consuming bad input (`nextLine()`) matters.

**Checkpoint #2:**
- Students predict output/flow for `5 0`, then `a`, then valid integer.

---

### 4:10-4:20 (10 min) - Slides + textbook: exception types and checked vs unchecked
Slides first, then reinforce with textbook language from [chapter12.md](data/courses/spring2026/CSCI1437_PF2/course_content/textbook_chapters/chapter12.md):
- `Throwable` hierarchy conceptually
- `RuntimeException`/`Error` = unchecked
- others under `Exception` = checked

**Instructor caution:**
- Keep this practical: "unchecked not required by compiler" does not mean "ignore it."

**Checkpoint #3:**
- Students classify 4 examples as checked/unchecked.

---

### 4:20-4:28 (8 min) - `finally` semantics
Use [DivisionWithFinally.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/DivisionWithFinally.java).

**Teach points:**
- `finally` runs whether exception occurs or not.
- Great for closeout/cleanup messaging and resource closure mindset.

**Checkpoint #4:**
- Ask: "If return happens in `try`, does `finally` still run?"

---

### 4:28-4:38 (10 min) - Custom exception intro (exam-safe depth)
Use:
- [InvalidRadiusException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InvalidRadiusException.java)
- [CircleWithCUSTOMException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/CircleWithCUSTOMException.java)

**Teach points:**
- Why custom exceptions exist (domain meaning + readability)
- Constructor with message + optional data (`radius`)
- `throws` in method signature communicates contract

**Note for class clarity:**
- Mention this is concept-heavy; implementation polish can be revisited in lab/review.

---

### 4:38-4:43 (5 min) - Text I/O bridge preview (do not deep-dive yet)
Use [ReadInAndReplace.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/ReadInAndReplace.java):
- Show where `try-with-resources` appears.
- Show `IOException` handling quickly.
- Connect to next week review: this is likely examinable at conceptual level.

---

### 4:43-4:45 (2 min) - Exit ticket and wrap
**Exit ticket (collect quickly):**
1. Difference between `throw` and `throws` in one sentence.
2. One checked and one unchecked exception example.
3. One reason `finally` exists.

---

## 3) Thursday Mar 19 (No Class) - Async reinforcement (30-45 min)
Post as focused checklist (no new lecture content):
1. Rewatch Tuesday recording sections on `throw`/`throws` and `finally`.
2. Run and modify [QuotientWithException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java):
   - change exception message
   - add one extra `catch` branch
3. Run and modify [InputMismatchExceptionDemo.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java):
   - test invalid input twice before valid input
4. Read textbook sections aligned to objectives in [chapter12.md](data/courses/spring2026/CSCI1437_PF2/course_content/textbook_chapters/chapter12.md).

---

## 4) Runway to Tue Mar 24 Review Day (Ch12 + Ch13)
**Review split recommendation (75 min):**
- 35 min Chapter 12 review and code tracing
- 35 min Chapter 13 review (abstract vs interface decisions)
- 5 min exam logistics

**Chapter 12 review must include:**
- Error flow tracing through call stack
- Checked vs unchecked classification
- `throw` vs `throws`
- `finally` behavior
- One custom exception read-and-explain question

**Chapter 13 integration prompt:**
- "Where would you use an interface + where would you throw an exception in the same design?"

---

## 5) Instructor Notes (important)
- Your 2024 transcripts show students respond best when:
  - you front-load schedule clarity,
  - anchor each concept with one concrete code case,
  - and repeatedly restate exam timing/coverage.
- Keep this Tuesday session thorough but bounded. Depth over breadth prevents Chapter 12 confusion.
- If time slips, cut File I/O depth first and preserve exception core model.
