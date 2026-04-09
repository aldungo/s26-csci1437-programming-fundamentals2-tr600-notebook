# Lecture 18 Game Plan — Finish Ch15 (Event-Driven Programming) + Start Ch16 (UI Controls)
**Thursday, April 9, 2026 | Class Time (75 min)**

---

## Pre-Class Setup (5 min before)

- [ ] Open `.instructor/chapter15/examples/` in terminal — verify Examples 03–08 run
- [ ] Open `.instructor/chapter16/examples/` in terminal — verify CheckboxDemo and AddRadioButtons run
- [ ] Have `welcome_board.html` open in browser — show before class starts
- [ ] Have `.instructor/chapter15/chapter15slides.txt` open for quick reference
- [ ] Have `.instructor/chapter16/chapter16slides.txt` open for quick reference
- [ ] Test `run-Example03.bat` through `run-Example08.bat` — confirm all launch
- [ ] Test screen share — code AND JavaFX window both visible

---

## Context From Last Lecture (April 2)

On April 2 (lecture 17), we covered:
- **Ch14 close:** Image/ImageView demos, property binding briefly
- **Ch15 intro:** Event-driven programming concepts, source → event → handler triangle
- **Example 01:** Basic event handler with SEPARATE handler classes (OK/Cancel buttons)
- **Example 02:** Inner class handler (Increment/Decrement/Reset with click count)
- **Previewed** anonymous inner class output — but explicitly said "I'm not gonna get into anonymous inner classes just yet till Tuesday"
- **Tuesday April 7 was cancelled.** Students have NOT seen anonymous inner classes, lambdas, or anything beyond Example 02.

**Today's pickup point:** Anonymous inner classes (Example 03).

---

## Class Outcomes (What must happen today)

1. **Finish Chapter 15** — students confidently understand anonymous inner classes, lambda expressions, and when to use each handler style.
2. **See practical applications** — ControlCircle, mouse events, key events, animation.
3. **Start Chapter 16** — introduce UI controls (CheckBox, RadioButton) with live demos.
4. Students can articulate: *what a lambda expression is*, *why it works for event handlers*, and *when to choose which handler style*.

---

## Timeline

---

### 0:00–0:05 (5 min) — Welcome Back + Context Bridge

**Opening talking points:**
- Acknowledge: Tuesday was cancelled, it's been a full week since we met
- Quick recap: "Last time we introduced event-driven programming — the source, event, handler triangle"
- Reminder they saw Example 01 (separate classes) and Example 02 (inner classes)
- Today: "We pick up EXACTLY where we left off — I promised you anonymous inner classes and lambda expressions, and today you're getting all of it."
- Write today's agenda on board

**Board:**
```
TODAY:
  1. Anonymous Inner Classes (Ch15)
  2. Lambda Expressions (Ch15) ← THE modern way
  3. ControlCircle + Mouse/Key Events
  4. Animation preview
  5. Chapter 16 intro — UI Controls (CheckBox, RadioButton)
```

---

### 0:05–0:18 (13 min) — PART 1: Anonymous Inner Classes (Example 03)

> **This is a bridge segment — students saw separate classes and inner classes, now show the anonymous shortcut.**

#### 0:05–0:10 — Concept Explanation (5 min)

**Key teaching points:**
- Anonymous = no name. We define AND create the object in one expression.
- No separate class file. No inner class declaration. Just: `new Interface() { @Override ... }`
- Still implements `EventHandler<ActionEvent>`, still overrides `handle()` — just inline.
- This was THE standard way to handle events in Java before Java 8.

**Draw on board — the evolution:**
```
STYLE 1 (Separate):   class MyHandler implements EventHandler<ActionEvent> { ... }
                       btn.setOnAction(new MyHandler());

STYLE 2 (Inner):      private class MyHandler implements EventHandler<ActionEvent> { ... }
                       btn.setOnAction(new MyHandler());

STYLE 3 (Anonymous):  btn.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent e) { ... }
                       });
```

#### 0:10–0:18 — Run Example 03 + Code Walkthrough (8 min)

**Run `Example03_AnonymousInnerClass.java` first — show it works identically to Example 02.**

**Then show the code side-by-side with Example 02:**
- Point out: no class name, no separate declaration
- The `new EventHandler<ActionEvent>() { ... }` pattern
- Still has `@Override` and `handle(ActionEvent e)` — that structure hasn't changed
- Can access outer class fields (`clickCount`, `messageText`) — same as inner class

**Ask class:**
> "Functionally, does this behave any differently from Example 02?"
> (Answer: NO — same behavior, less code, no class names to manage.)

**Transition statement:**
> "Anonymous inner classes are more concise than inner classes. But Java 8 gave us something even better."

---

### 0:18–0:38 (20 min) — PART 2: Lambda Expressions (Example 04)

> **THIS IS THE KEY SECTION. The instructor needs to explain this confidently. Take your time here.**

#### 0:18–0:25 — The Concept: What Is a Lambda? (7 min)

**Build the bridge from anonymous inner class to lambda:**
1. Look at the anonymous inner class: most of the code is boilerplate (new, interface name, @Override, method signature, braces)
2. The only part that MATTERS is the code inside `handle()` — that's the action.
3. A **functional interface** = an interface with exactly ONE abstract method.
4. `EventHandler<ActionEvent>` has exactly one: `handle(ActionEvent e)`. So it IS a functional interface.
5. Java 8 said: if there's only ONE method, the compiler can INFER everything. You just provide: parameters → body.

**Draw on board — the reduction:**
```
ANONYMOUS:
  new EventHandler<ActionEvent>() {    ← boilerplate
      @Override                         ← boilerplate
      public void handle(ActionEvent e) {  ← boilerplate (except e)
          clickCount++;                 ← THE CODE
          messageText.setText(...);     ← THE CODE
      }                                ← boilerplate
  }                                    ← boilerplate

LAMBDA:
  e -> {
      clickCount++;
      messageText.setText(...);
  }
```

> "We threw away everything the compiler can figure out. What's left: the parameter, the arrow, and the body."

**Lambda syntax rules (write on board):**
```
Lambda Syntax:
  (params) -> expression        ← single statement, no braces
  (params) -> { statements; }   ← multiple statements, needs braces

Shortcuts:
  - One param, no type: e -> ...     (parentheses optional)
  - No params: () -> ...
  - One statement: e -> doThing()    (no braces, no semicolon after expression)
```

#### 0:25–0:32 — Run Example 04 + Code Walkthrough (7 min)

**Run `Example04_LambdaExpression.java` — show it works identically to Examples 02 and 03.**

**Walk through each lambda in the code:**

```java
// Multi-statement lambda:
btIncrement.setOnAction(e -> {
    clickCount++;
    messageText.setText("Click count: " + clickCount);
    System.out.println("Incremented to: " + clickCount);
});

// Single-statement lambda (no braces!):
btExit.setOnAction(e -> System.exit(0));
```

**Point out:**
- `e` = the ActionEvent parameter (compiler infers the type)
- `->` = the arrow operator (reads as "goes to" or "does")
- Braces required for multiple statements, optional for one
- Can still access `e.getSource()` — the event object is still there

**Ask class:**
> "Four examples. Different syntax each time. SAME functionality. Which one would you rather type?"
> (Expected: lambda — less code, cleaner, modern.)

#### 0:32–0:38 — Decision Guide: When to Use Which Style (6 min)

**Show the decision guide from the slides/textbook:**

| Style | Use When |
|---|---|
| Separate class | Handler is complex AND reused in multiple places |
| Inner class | Handler is complex but only used in ONE application |
| Anonymous inner class | Handler is moderate, used once |
| **Lambda expression** | Handler is simple to moderate — **PREFERRED DEFAULT** |

**Key points:**
- Lambda is the modern default. Use it unless you have a reason not to.
- The reason to use a separate or inner class: the handler logic is many lines, or it needs its own state.
- For Exam 3: students should know all four styles and be able to identify them.
- For semester projects: use lambdas.

---

### 0:38–0:48 (10 min) — PART 3: ControlCircle + Mouse/Key Events

#### 0:38–0:43 — ControlCircle Demo (Example 05) (5 min)

**Run `Example05_ControlCircle.java` — click Enlarge and Shrink.**

**Highlight:**
- `CirclePane` extends `StackPane` — custom node (OOP from Ch9–11 in action)
- Two lambdas: `btEnlarge.setOnAction(e -> circlePane.enlarge());`
- Separates VIEW (CirclePane draws the circle) from CONTROL (buttons call methods)
- This pattern (custom pane + lambda handlers) is what they'll use in projects

#### 0:43–0:48 — Mouse and Key Events Quick Demo (5 min)

**Run `Example06_MouseEvents.java`:**
- Click around — circle follows mouse
- Drag — circle follows drag
- Show coordinates updating
- Point out: `setOnMouseClicked`, `setOnMouseDragged` — same lambda pattern, different event type

**Run `Example07_KeyEvents.java`:**
- Arrow keys move circle, +/- resize
- Point out: `setOnKeyPressed(e -> { switch(e.getCode()) { ... } })`
- Mention: key events require `requestFocus()` — the node must have focus

> "Same event triangle. Same lambda syntax. Different event types: ActionEvent for buttons, MouseEvent for mouse, KeyEvent for keyboard."

---

### 0:48–0:55 (7 min) — PART 4: Animation Preview (Example 08)

**Run `Example08_PathTransition.java` — let it animate.**

**Talk through key points:**
- `PathTransition` — moves a node along a path
- `Duration.millis(4000)` — how long per cycle
- `Timeline.INDEFINITE` — loops forever
- `setAutoReverse(true)` — bounces back
- Click to pause, release to resume — that's mouse events + animation combined

> "This is the icing on the cake for Chapter 15. You now have the tools to make things that move, respond to clicks, respond to keys, and animate. That's a real application."

**Chapter 15 summary statement:**
> "Chapter 15 gave us: event-driven programming, four handler styles (lambda is preferred), mouse events, key events, and animations. This is the backbone of every interactive JavaFX app you'll write — including your semester projects."

---

### 0:55–1:12 (17 min) — PART 5: Chapter 16 Introduction — UI Controls

#### 0:55–1:00 — Chapter 16 Overview (5 min)

**Transition:**
> "Chapter 14 taught us to display things. Chapter 15 taught us to respond to things. Chapter 16 gives us the building blocks — the actual controls users interact with."

**Write on board:**
```
Chapter 16 UI Controls:
  - Label (review)
  - Button (review)
  - CheckBox      ← new
  - RadioButton   ← new
  - TextField     ← new
  - TextArea      ← new
  - ComboBox      ← new
  - Slider        ← new
```

> "You already know Label and Button from Chapter 14. Chapter 16 expands the toolkit. All of these use the same event handling from Chapter 15 — setOnAction with a lambda."

#### 1:00–1:06 — CheckBox Demo (6 min)

**Show `CheckboxDemo.java` from `.instructor/chapter16/examples/`**

**Key points:**
- `CheckBox chkBold = new CheckBox("Bold");`
- `chkBold.isSelected()` — boolean check
- `chkBold.setOnAction(handler)` — same pattern!
- CheckBoxes are INDEPENDENT — checking one doesn't affect others
- Demo: check Bold → text becomes bold. Check Italic → text becomes italic. Both → bold italic.

**Code highlight:**
```java
EventHandler<ActionEvent> handler = e -> {
    if (chkBold.isSelected() && chkItalic.isSelected()) {
        text.setFont(fontBoldItalic);
    } else if (chkBold.isSelected()) {
        text.setFont(fontBold);
    } // ...
};
chkBold.setOnAction(handler);
chkItalic.setOnAction(handler);
```

> "Notice — same handler for both checkboxes. Lambda stored in a variable. Clean."

#### 1:06–1:12 — RadioButton Demo (6 min)

**Show `AddRadioButtons.java` from `.instructor/chapter16/examples/`**

**Key points:**
- `RadioButton rbRed = new RadioButton("Red");`
- key difference: RadioButtons go in a `ToggleGroup` — only ONE can be selected
- `rbRed.setToggleGroup(group);`
- `rbRed.isSelected()` — same as CheckBox
- `rbRed.setOnAction(e -> { ... })` — same lambda pattern

**Code highlight:**
```java
ToggleGroup group = new ToggleGroup();
rbRed.setToggleGroup(group);
rbGreen.setToggleGroup(group);
rbBlue.setToggleGroup(group);

rbRed.setOnAction(e -> {
    if (rbRed.isSelected()) text.setFill(Color.RED);
});
```

> "CheckBox = independent selections (Bold AND Italic). RadioButton = mutually exclusive (Red OR Green OR Blue). ToggleGroup enforces that."

---

### 1:12–1:15 (3 min) — Wrap-Up + Tuesday Preview

**Quick recap (call and response):**
> "Anonymous inner class: define + instantiate in _____" → *one expression*
> "Lambda arrow operator: _____" → *->*
> "A functional interface has exactly _____ abstract method" → *one*
> "The modern preferred handler style is _____" → *lambda*
> "CheckBox selections are _____, RadioButton selections are _____" → *independent, mutually exclusive*

**Tuesday preview:**
> "Tuesday we continue Chapter 16 — TextField, TextArea, ComboBox, and Slider. These are the input controls. And if you think about Lab 11: file handler buttons, text input, reading and writing — that's Chapter 15 events plus Chapter 16 controls. It all connects."

**Reminders:**
- Lab 11 is a two-week lab — use the time wisely
- Semester project: start implementing if you haven't
- Exam 3 covers Chapters 14, 15, 16

---

## Teaching Notes

### What to Emphasize Most:
- ✅ The REDUCTION from anonymous inner class → lambda. Show the boilerplate being stripped away.
- ✅ Lambda syntax — `e -> expression` vs `e -> { statements; }`. Students WILL confuse when to use braces.
- ✅ Functional interface = one abstract method = lambda eligible. This is the "why."
- ✅ Decision guide for handler styles — they need this for the exam and projects.
- ✅ CheckBox vs RadioButton — independent vs mutually exclusive. Draw the parallel.

### Common Student Mistakes:
- ❌ Missing `->` in lambda (writing `e { ... }` instead of `e -> { ... }`)
- ❌ Adding semicolon after single-expression lambda: `e -> doThing();` inside `setOnAction()` — this is actually fine, but braces change the rules
- ❌ Confusing anonymous inner class syntax — forgetting the `new EventHandler<ActionEvent>()` part
- ❌ Forgetting `@Override` in anonymous inner class (still required!)
- ❌ RadioButton without ToggleGroup — all buttons become independent (acts like CheckBox)
- ❌ Forgetting `requestFocus()` for key events

### If Running Short on Time:
- SHORT CUT 1: Abbreviate mouse/key events to "run and show, but skip code walkthrough" (saves 3 min)
- SHORT CUT 2: Skip animation/Example 08 entirely — just mention it exists (saves 5 min)
- SHORT CUT 3: Show RadioButton code but skip running it (saves 3 min)
- ALWAYS KEEP: Anonymous → Lambda progression (Parts 1–2) and ControlCircle demo (Part 3)

### If Extra Time:
- Live-code a CheckBox from scratch instead of just showing the prepared example
- Ask students to predict what happens when you modify a lambda handler
- Show ComboBox or Slider from Ch16 slides as a further preview

---

## Resources

- **Ch15 Slides:** `.instructor/chapter15/chapter15slides.txt`
- **Ch15 Textbook:** `.instructor/chapter15/chapter15textbook.txt` (§15.3–15.10)
- **Ch15 Examples:** `.instructor/chapter15/examples/Example03–08`
- **Ch16 Slides:** `.instructor/chapter16/chapter16slides.txt`
- **Ch16 Textbook:** `.instructor/chapter16/chapter16textbook.txt` (§16.1–16.5)
- **Ch16 Examples:** `.instructor/chapter16/examples/CheckboxDemo.java`, `AddRadioButtons.java`

---

## Chapter 15 Examples Run Reference

```powershell
cd .instructor\chapter15\examples
.\run-Example03.bat   # Anonymous inner class
.\run-Example04.bat   # Lambda expression
.\run-Example05.bat   # ControlCircle
.\run-Example06.bat   # Mouse events
.\run-Example07.bat   # Key events
.\run-Example08.bat   # PathTransition animation
```
