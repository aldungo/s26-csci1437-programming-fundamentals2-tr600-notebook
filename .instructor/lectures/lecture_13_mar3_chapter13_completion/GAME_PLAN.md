# Lecture 13 Game Plan - Ch13 Closeout + Ch12 Exception IDEA Bridge
**Tuesday, March 3, 2026 | 3:30-4:45 PM**

---

## Pre-Class Setup (3:25-3:30)

- [ ] Open welcome board HTML
- [ ] Open `CODE_EXAMPLES.java`
- [ ] Open Chapter 13 slides (`ch13slides.md`)
- [ ] Keep Chapter 12 slides (`ch12slides.md`) ready for final segue
- [ ] Launch Zoom poll panel

---

## Class Outcomes (What must happen today)

1. Finish the remaining Chapter 13 gap from Thursday: abstract class vs interface differences.
2. Practice when-to-use decision making with short scenarios.
3. Mention Rational as optional self-investigation only (not a full in-class build).
4. Briefly segue into Chapter 12 before break.
5. End with a clear Thursday handoff for the full Chapter 12 deep dive.

---

## Timeline (75 minutes max, flexible early dismissal)

### 3:30-3:36 (6 min) — Warm Start + Polls
- Poll 1: abstract class vs interface choice
- Poll 2: quick “which design fits?” scenario
- 30-second bridge: “We’re closing the exact gap we left Thursday, then previewing Ch12.”

### 3:36-3:54 (18 min) — Ch13 Exact Carry-Over (From Thu 2/26)
- Quick anchor: Thursday ended on Cloneable marker-interface and “we’ll compare interfaces vs abstract classes Tuesday.”
- Teach only the remaining target:
  - abstract class = shared state/implementation for related hierarchy
  - interface = capability contract across possibly unrelated classes
  - extends (single class) vs implements (multiple interfaces)
- Board prompt: “Is this IS-A identity or CAN-DO capability?”

### 3:54-4:12 (18 min) — Live Coding: Decision-Focused Mini Demo
Use `CODE_EXAMPLES.java` Part A:
- small abstract class + interface contrast
- one class that extends abstract parent
- one class that implements capability interface
- optional quick peek at class implementing multiple interfaces

**Checkpoint question:**
- “What would break if we swapped this abstract class with an interface?”

### 4:12-4:24 (12 min) — Design Decision Sprint (Active Learning)
- 4 quick scenarios (student vote): interface or abstract class?
- Call on 2-3 students for rationale
- Rational mention only: “Rational extends Number and implements Comparable — investigate this example independently.”

### 4:24-4:33 (9 min) — Chapter 12 IDEA-Only Bridge
Use `CODE_EXAMPLES.java` Part B (idea-only version):
- one concrete runtime problem (`divide` with zero)
- method throws, caller catches (separation of responsibility)
- `finally` always runs
- 60-second checked vs unchecked distinction (concept only, no deep taxonomy)

**Talk track (say this almost verbatim):**
- “An exception is Java’s way of signaling: normal flow cannot continue here.”
- “The method that detects the problem can throw; the caller decides how to respond.”
- “Today is just the mental model. Thursday is full Chapter 12 implementation details.”

### 4:33-4:38 (5 min) — Thursday Handoff + Optional Early Dismiss
- Post 3 prep targets for Thursday:
  1. Declare vs throw vs catch
  2. Exception propagation (call stack)
  3. File I/O with try-with-resources
- Optional exit check in chat:
  - “One sentence: what is an exception?”
  - “One sentence: why not just `System.exit()` in helper methods?”
- If understanding is solid, dismiss early.

### 4:38-4:45 (7 min) — Buffer (Only if needed)
- Use this block only if Ch13 or Q&A runs long.
- Otherwise, class can end at ~4:33-4:38 after the Ch12 idea bridge.

---

## Instructor Talk Track (short)

- “Thursday we reached Cloneable and paused right before the decision framework.”
- “Today we finish exactly that gap: identity vs capability design.”
- “Then we open Chapter 12 so you’re not cold-starting after break.”
- “Today for exceptions: concept clarity over coverage volume.”

---

## If Running Behind (Fallback)

- Keep only Ch13 decision framework + one scenario vote (must-do)
- Mention Rational as self-investigation, skip any code for it
- Keep only one Ch12 demo (`divide` + `try/catch`)
- Push file I/O preview fully to Thursday

---

## Chapter 12 Concept Targets (Today Only)

- Runtime error becomes an exception object.
- `throw` reports a problem; `catch` handles response; `finally` runs regardless.
- Caller-handles strategy is cleaner than terminating inside a helper method.
- Checked vs unchecked is a preview only today.

---

## Thursday Full Ch12 Preview (say at end)

- Full exception hierarchy and ordering of multiple catch blocks
- Exception propagation through method calls
- `throws` in method headers and when to use it
- File handling with `File`, `Scanner`, `PrintWriter`, try-with-resources
- Common scanner pitfalls (`nextInt()` then `nextLine()`)

---

## Ready-to-Post Summary (copy)

Today we close Chapter 13 by finishing abstract-class vs interface decisions we paused on Thursday. Then we do a short Chapter 12 bridge focused only on the IDEA of exceptions (throw/catch/finally + checked vs unchecked preview), with the full Chapter 12 deep dive scheduled for Thursday.
