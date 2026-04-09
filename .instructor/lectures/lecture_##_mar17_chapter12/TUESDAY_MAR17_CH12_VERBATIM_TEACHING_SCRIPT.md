# Tuesday Mar 17 - Chapter 12 Verbatim Teaching Script
**Course:** CSCI 1437 PF2  
**Class Time:** 3:30 PM - 4:45 PM  
**Use with:** slides as point-hits, your Java examples as live demos, textbook as emphasis anchor

---

## 3:30-3:36 | Opening (word-for-word)
"Good afternoon everyone, welcome back from Spring Break. I hope you had a chance to rest and reset."

"Today we are continuing exactly where we left off: Chapter 12, exception handling and text I/O foundations."

"Quick logistics first: we meet today, there is no class meeting on Thursday March 19, and Exam 2 is Thursday March 26."

"Exam 2 only covers Chapters 12 and 13, so our goal this week is clarity and confidence, not speed."

"On Tuesday March 24, we will do a full review day for both chapters before the exam."

"Today, I want you to leave with five things completely clear:"
1. "What an exception is"
2. "Difference between throw and throws"
3. "How try/catch flow works"
4. "Checked vs unchecked exceptions"
5. "What finally guarantees"

"If those five are clear, Chapter 12 becomes much easier."

---

## 3:36-3:48 | Slides-first concept block
### Slide point: runtime errors and exception objects
"Start with the big idea: runtime errors happen while the program is running, and Java represents those as exception objects."

"If exceptions are not handled, your program terminates abnormally."

"In beginner code, a crash feels normal. In real software, crashing is expensive and unacceptable."

### Slide point: design model
"Our design model is this: helper methods detect problems and throw exceptions; calling methods decide how to handle them."

"That preserves cohesion: each method does one job well."

### Textbook emphasis cue
"Textbook emphasis: Chapter 12 introduction and 12.2 focus on this exact architecture: throw in called method, handle in caller."

"I want that sentence in your notes because it appears all over exam-style reasoning questions."

Transition line:
"Now let me show you exactly what this looks like in your code examples."

---

## 3:48-4:00 | Demo sequence 1 (bad -> better)
### Demo file 1
Use: [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithMethod.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithMethod.java)

Say:
"Here is the older pattern: if divisor is zero, print a message and terminate."

"Why is this weak? Because the helper method is making global control decisions."

"That removes flexibility from the caller."

### Demo file 2
Use: [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithException.java)

Say:
"Now compare this version. The helper method throws ArithmeticException."

"Main owns the try/catch and decides what to do."

"Notice the line 'Execution continues ...' - this is the exact behavior we want in robust programs."

Mini-check (ask students):
"Who can tell me in one sentence why version 2 is better design than version 1?"

Expected answer you can reinforce:
"Because it separates detection from response and gives the caller control."

---

## 4:00-4:10 | Demo sequence 2 (recovery loops)
### Demo file 3
Use: [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithWhile.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/QuotientWithWhile.java)

Say:
"Now we add recovery, not just handling."

"When bad input appears, we catch it and reprompt instead of dying."

"This is a real software pattern: fail safely, recover, continue."

### Demo file 4
Use: [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InputMismatchExceptionDemo.java)

Say:
"This one demonstrates InputMismatchException and a classic fix: consume invalid input, then retry."

"On exams, if you see repeated user input after invalid type, think try/catch + loop."

Textbook emphasis cue:
"Textbook Chapter 12 section on handling with try/catch maps directly to this pattern."

---

## 4:10-4:20 | Checked vs unchecked (high-yield exam section)
Say:
"Now let's cleanly separate checked and unchecked exceptions."

"Unchecked exceptions are RuntimeException and Error families - compiler does not force handling."

"Checked exceptions are other Exception types - compiler requires catch or throws."

"Important: unchecked does not mean optional engineering quality. It only means compiler policy."

"Checked means Java enforces a handling contract at compile time."

Textbook emphasis cue:
"Textbook objective language explicitly calls out this distinction, so this is exam priority content."

Quick verbal drill:
"ArithmeticException: checked or unchecked?"
"IOException: checked or unchecked?"
"InputMismatchException: checked or unchecked?"

---

## 4:20-4:28 | finally block clarity
### Demo file 5
Use: [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/DivisionWithFinally.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/DivisionWithFinally.java)

Say:
"finally is a guarantee block."

"Whether exception happens or not, finally executes."

"This is why finally is used for cleanup and consistent close-out behavior."

"If you return in try or catch, finally still runs before method fully exits."

Ask:
"What is one thing you would put in finally in real applications?"

Reinforce common answers:
"Close files, close streams, logging, release resources."

---

## 4:28-4:38 | Custom exceptions (concept + practical)
### Demo file 6
Use: [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InvalidRadiusException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/InvalidRadiusException.java)

### Demo file 7
Use: [data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/CircleWithCUSTOMException.java](data/courses/spring2026/CSCI1437_PF2/course_content/chapter12/CircleWithCUSTOMException.java)

Say:
"Custom exceptions are about semantic clarity."

"Instead of generic failure, we can express domain meaning: invalid radius, invalid order, invalid account state, etc."

"Notice the constructor message and stored value; this makes debugging and user feedback much stronger."

"Also notice throws in signatures: this communicates the method contract to all callers."

Textbook emphasis cue:
"Textbook objective explicitly includes defining custom exception classes, so know the pattern even if implementation varies."

---

## 4:38-4:45 | Lab 8 Applicability Workshop (verbatim)
"Since we do not meet Thursday, we are going to use these final minutes to map today's exception concepts directly into Lab 8 so you can build it yourselves."

"Your Lab 8 problem is User Sign Up: validate username and validate password with exception handling."

"This is exactly what exceptions are for: input validation rules, clean method contracts, and clear feedback to users."

### Step 1 script (method responsibility)
"Method one is validateUsername. It takes a String, returns nothing, and can throw IllegalArgumentException."

"Your required pattern is name@phrase.com. If it does not match your regex, throw new IllegalArgumentException with message 'Invalid username'."

"Notice how this matches today's architecture: helper method validates, helper method throws, caller handles."

### Step 2 script (password rules)
"Method two is validatePassword. Also takes a String, returns nothing, throws IllegalArgumentException when rules fail."

"You will track four booleans initialized to false: has uppercase, has lowercase, has digit, has special."

"Loop through each character using Character.isUpperCase, Character.isLowerCase, Character.isDigit."

"If it is not uppercase, lowercase, or digit, count it as special character."

"After loop, if any boolean is false, throw IllegalArgumentException with the exact missing-rule message."

### Step 3 script (main method try/catch)
"In main, create Scanner, prompt for username and password, then call both validation methods inside a try block."

"If no exception occurs, print 'Successfully signed up'."

"If exception occurs, catch IllegalArgumentException and print ex.getMessage()."

"That is textbook Chapter 12 in one practical lab flow."

### Quick in-class transfer prompt (radius mini-case)
"Connect this to our radius validation example: bad type or bad value throws exception, caller prints clear message, execution stays controlled."

"Same pattern, different domain."

### Exit ticket + close (word-for-word)
"Before you leave, answer these three quickly:"
1. "What line in your program should throw 'Invalid username'?"
2. "Which method should catch IllegalArgumentException in Lab 8?"
3. "What output appears when both username and password pass validation?"

Close:
"Excellent work today. This was a thorough Chapter 12 application day, not just theory."

"No class Thursday March 19, so your task is to start Lab 8 using this exact architecture while it is fresh."

"On Tuesday March 24, we do full review for Chapters 12 and 13, then Exam 2 is Thursday March 26."

"If you can explain throw vs throws and build validateUsername plus validatePassword cleanly, you are in great shape."

---

## Optional 1-minute recovery lines (if class gets confused)
- "Pause. Let's separate syntax from logic: syntax is the code shape, logic is where control moves after throw."
- "If you're lost, track only three things: where exception is created, where it travels, where it is caught."
- "Do not memorize blocks blindly; always ask who owns recovery decisions."

---

## Suggested after-class student checklist (post to LMS)
1. Run and modify QuotientWithException.
2. Run InputMismatchExceptionDemo with bad input twice, then valid input.
3. Build `validateUsername(String username)` with regex check and `IllegalArgumentException("Invalid username")`.
4. Build `validatePassword(String password)` with four booleans and character checks.
5. In main, wrap both validation calls in try/catch and print either error message or "Successfully signed up".
