# Lecture 17 Game Plan — Ch14 Close (Property Binding) + Ch15 Intro (Event-Driven Programming)
**Thursday, April 3, 2026 | Class Time (75 min)**

---

## Pre-Class Setup (5 min before)

- [ ] Open `Chapter14.ipynb` to the "Tuesday 31 March" section — this is the visible student notebook
- [ ] Open `.instructor/chapter14/examples/` and `.instructor/chapter15/examples/` in terminal
- [ ] Verify `mvn javafx:run` (or the equivalent run script) works on your machine
- [ ] Have `.instructor/chapter14/chapter14slides.txt` open for quick reference
- [ ] Have `.instructor/chapter15/chapter15slides.txt` open for quick reference
- [ ] Confirm path to Ch15 examples (`run-Example01.bat` through `run-Example05.bat`)
- [ ] Test screen share

---

## Class Outcomes (What must happen today)

1. **Close Chapter 14** with a deep, hands-on understanding of property binding — unidirectional and bidirectional.
2. **Transition to Chapter 15** with a clear conceptual intro: what is event-driven programming?
3. **Show the three handler styles** (separate class → inner class → anonymous class → lambda), building intuition for *when* each one fits.
4. Students can articulate: *what a binding property is*, *how `.bind()` works*, and *why lambdas are the modern preferred style* for event handlers.

---

## Timeline

---

### 0:00–0:05 (5 min) — Warm Restart + Context Bridge

**Opening statement (nearly verbatim):**
> "Last Tuesday we covered Image and ImageView — loading pictures into JavaFX and displaying them. We closed with a mention of property binding. Today we go deep on that, finish Chapter 14, and then start something new and exciting: Chapter 15 — making things actually respond when you click them."

**Write on board (or show):**
```
TODAY:
  1. Property Binding (Ch14 close)
  2. What is Event-Driven Programming? (Ch15 open)
  3. Handler Styles: class → inner → anonymous → lambda
```

---

### 0:05–0:35 (30 min) — PART 1: Property Binding (Ch14 §14.5)

> **This is the emphasis segment. Take your time here. Use the live demo heavily.**

#### 0:05–0:10 — The Problem (5 min)

**Talk track:**
> "Here's something we saw — but didn't totally fix — with our centered circle. Watch what happens."

**Draw on board:**
```
Window: 200 x 200
Circle center: (100, 100)  ← hardcoded

User resizes window to 400 x 300...
Circle center is still (100, 100)  ← no longer centered
```

> "The circle has NO idea the window changed. We hardcoded the center. We need it to UPDATE automatically when the window resizes. This is exactly what property binding solves."

#### 0:10–0:20 — What is Property Binding? (10 min)

**Conceptual explanation:**

> "JavaFX objects — like Circle, Pane, Stage — have something called **binding properties**. These aren't just regular Java fields. They're objects that can **listen** to other objects and automatically update."

**Write on board:**
```
Target  ──── .bind(source) ──── Source
  ↑                               ↑
binding property            observable/bindable object

When source changes → target AUTOMATICALLY updates.
```

> "Two key terms from the slides:"
> - **Target** = the binding property — the thing that FOLLOWS  
> - **Source** = the observable object — the thing being WATCHED

**Key API points to cover:**
- `bind()` is defined in the `Property` interface
- Source must implement `ObservableValue`
- Common binding property types: `DoubleProperty`, `IntegerProperty`, `StringProperty`, `BooleanProperty`
- These are abstract — use `SimpleDoubleProperty`, `SimpleIntegerProperty`, etc. to create standalone instances

**Naming convention (critical to explain):**
```
For a property named centerX:
  - getCenterX()         → value getter  (returns double)
  - setCenterX(double)   → value setter  (sets double)
  - centerXProperty()    → property getter (returns DoubleProperty OBJECT)
```

> "Notice the difference. `getCenterX()` gives you the NUMBER. `centerXProperty()` gives you the OBJECT you can bind with."

**Ask the class:**
> "Before I write the fix — what do we want to bind? What's the target? What's the source?"
> *(Expected: target = circle's centerX, source = pane's width / 2)*

#### 0:20–0:30 — Live Code: ShowCircleCentered (10 min)

**Code to type live (from textbook §14.5 / slides):**

```java
// BEFORE — broken (circle doesn't follow window resize)
Circle circle = new Circle();
circle.setCenterX(100);   // hardcoded!
circle.setCenterY(100);   // hardcoded!
circle.setRadius(50);
circle.setStroke(Color.BLACK);
circle.setFill(Color.WHITE);

Pane pane = new Pane();
pane.getChildren().add(circle);
Scene scene = new Scene(pane, 200, 200);
```

> "Now the fix. Watch how this changes:"

```java
// AFTER — property binding (circle stays centered!)
Circle circle = new Circle();
circle.setRadius(50);
circle.setStroke(Color.BLACK);
circle.setFill(Color.WHITE);

Pane pane = new Pane();

// Bind centerX to half of pane's width
circle.centerXProperty().bind(pane.widthProperty().divide(2));
// Bind centerY to half of pane's height
circle.centerYProperty().bind(pane.heightProperty().divide(2));

pane.getChildren().add(circle);
Scene scene = new Scene(pane, 200, 200);
```

**Run it. Resize the window. Circle stays centered.**

> "THAT is property binding. The circle is now WATCHING the pane. Every time pane width changes, the circle recalculates its center."

**Highlight the math methods:**
> "Notice `.divide(2)`. DoubleProperty and IntegerProperty give you:"
```
.add(value)
.subtract(value)
.multiply(value)
.divide(value)
```
> "These return a new observable property — meaning you can chain math into your binding expression."

#### 0:30–0:35 — Unidirectional vs Bidirectional (5 min)

**Explain:**
> "What we just did is called **unidirectional binding**. Changes flow ONE direction: source → target. The target follows the source."

```
pane.widthProperty()  ──→  circle.centerXProperty()
(source changes)            (target auto-updates)
```

> "But sometimes you want two-way sync. If either one changes, the other follows. That's **bidirectional binding**."

**Bidirectional example (conceptual — no full app needed):**
```java
textField1.textProperty().bindBidirectional(textField2.textProperty());
// Now: type in either field → the other updates too
```

> "Use `.bindBidirectional()` instead of `.bind()`. Both properties must be the same type."

**Quick concept check (ask verbally):**
> "1. What's the difference between `getCenterX()` and `centerXProperty()`?"  
> "2. If I call `.bind()`, which direction do changes flow?"  
> "3. When would I use `.bindBidirectional()`?"

---

### 0:35–0:37 (2 min) — Chapter 14 Close + Chapter 15 Bridge

**Say:**
> "Excellent. That wraps up Chapter 14. Property binding is one of those things that feels abstract until you actually see the circle following your window resize — and then it clicks. We'll use this again when we do animations."

**Transition:**
> "Chapter 15 is where JavaFX gets interactive. So far, our apps just display things. Chapter 15 is about making them *respond*. We're moving into **event-driven programming**."

---

### 0:37–0:55 (18 min) — PART 2: Chapter 15 Intro — Events and Handler Styles (§15.1–15.3)

#### 0:37–0:42 — What Is Event-Driven Programming? (5 min)

**The mental model:**
> "In a regular console program, Java runs top-to-bottom. Line 1, line 2, line 3. Done."

> "In a GUI program, the program WAITS. It sits there. Then the user does something — clicks a button, presses a key, moves the mouse. That action creates an **event**. The event triggers code to run. This is event-driven programming."

**The three actors in every event (draw on board):**
```
[User clicks button]
       ↓
  SOURCE OBJECT     ← the button (fires the event)
       ↓ creates
  EVENT OBJECT      ← ActionEvent (holds info about what happened)
       ↓ passed to
  HANDLER OBJECT    ← your code that runs in response
```

> "Every GUI interaction follows this triangle: source fires → event is created → handler responds."

**Key terms from slides:**
- **Event source object** — where the action comes from (Button, TextField, etc.)
- **Event object** — instance of `ActionEvent`, `MouseEvent`, `KeyEvent`, etc.
- **Handler/Listener** — the object that processes the event

**Two requirements to be a handler (from slides):**
1. Must implement `EventHandler<T extends Event>` interface (specifically `handle(T event)` method)
2. Must be **registered** with the source using `setOnAction(handler)`

#### 0:42–0:55 — Live Code: Handler Evolution (13 min)

> "We're going to write the same functionality FOUR ways — from most verbose to most concise. You'll use all of these; the last one (lambda) is the preferred modern style."

**Setup — build the UI first (takes ~2 min):**
```java
// shared UI you'll reuse across all four versions
Button btColor = new Button("Change Color");
CirclePane circlePane = new CirclePane(); // small custom pane with a circle

HBox hbox = new HBox(10);
hbox.getChildren().addAll(circlePane, btColor);
Scene scene = new Scene(hbox, 300, 200);
```

---

**Style 1: Separate Handler Class**

> "The most explicit approach. Define a brand new class that implements `EventHandler<ActionEvent>`."

```java
// Completely separate class (outside your main app class)
class ColorHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        circlePane.setFill(Color.GREEN);
    }
}

// In start():
btColor.setOnAction(new ColorHandler());
```

> "This is clean and structured. But notice — `ColorHandler` needs access to `circlePane`. If it's a separate class, we have to pass that reference in. That's why the next style is often better."

---

**Style 2: Inner Class Handler**

> "Define the handler INSIDE your main application class. Now it can directly access the outer class's fields."

```java
public class MyApp extends Application {
    private CirclePane circlePane = new CirclePane(); // field

    public void start(Stage primaryStage) {
        Button btColor = new Button("Change Color");
        btColor.setOnAction(new ColorHandler()); // register
        // ...
    }

    // Inner class — can access circlePane directly
    class ColorHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.setFill(Color.GREEN); // works! circlePane is in outer class
        }
    }
}
```

> "Inner classes are compiled as `OuterClass$InnerClass.class`. The key win: access to outer class fields without passing anything."

---

**Style 3: Anonymous Inner Class**

> "Same idea, but we skip naming the class. We define AND instantiate it in one expression."

```java
btColor.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        circlePane.setFill(Color.GREEN);
    }
});
```

> "Anonymous classes combine defining + constructing. No class name. No separate file. One fewer thing to name. This was *the* standard style before Java 8."

---

**Style 4: Lambda Expression (Modern Preferred)**

> "EventHandler has exactly ONE abstract method — `handle()`. That makes it a **functional interface**. And functional interfaces can be replaced by **lambda expressions**."

```java
btColor.setOnAction(e -> circlePane.setFill(Color.GREEN));
```

> "One line. That's it. The compiler knows: we're in a `setOnAction` call, so `e` is an `ActionEvent`, and this is the body of `handle()`. Everything else is inferred."

**Lambda syntax rules (write on board):**
```
(params) -> expression
(params) -> { statements; }

// Parentheses optional if single param with no declared type:
e -> doSomething()

// Braces optional if body is one statement:
e -> circlePane.setFill(Color.GREEN)
```

**Decision guide (from slides — read this aloud):**
| Style | Best for |
|---|---|
| Separate class | Single complex handler reused across multiple places |
| Inner class | Single complex handler tied to ONE application |
| Anonymous inner class | Few simpler handlers |
| Lambda expression | One or several very simple handlers (preferred) |

---

### 0:55–1:05 (10 min) — PART 3: ControlCircle Demo (§15.3 applied)

> "Let's see everything together in a real example. This is the ControlCircle from textbook §15.3."

**Show/run `Example05_ControlCircle.java` from `.instructor/chapter15/examples/`:**

```java
// CirclePane — custom node with enlarge/shrink
class CirclePane extends StackPane {
    private Circle circle = new Circle(50);

    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void enlarge() {
        circle.setRadius(circle.getRadius() + 2);
    }

    public void shrink() {
        circle.setRadius(circle.getRadius() > 2 
                         ? circle.getRadius() - 2 
                         : circle.getRadius());
    }
}

// Main app using lambda handlers
public class ControlCircle extends Application {
    private CirclePane circlePane = new CirclePane();

    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink  = new Button("Shrink");

        // Lambda handlers — clean and direct
        btEnlarge.setOnAction(e -> circlePane.enlarge());
        btShrink.setOnAction(e -> circlePane.shrink());

        hBox.getChildren().addAll(btEnlarge, btShrink);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 250, 175);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
```

**Run it. Click Enlarge and Shrink.**

> "Notice `circlePane` is a data field of the app class. Both lambda handlers can reference it directly — same reason inner classes work. The lambda captures the outer scope."

**Key observation:**
> "Did you catch how `CirclePane` extends `StackPane`? We're building our own custom node by extending an existing pane. This is object-oriented design in action — combining Chapter 14 (JavaFX) with everything we learned in Chapters 9–13."

---

### 1:05–1:12 (7 min) — PART 4: Preview — Mouse Events and Key Events (§15.8–15.9, Optional)

> "There's more than button clicks. Any time the user moves the mouse, drags it, presses a key — that's also an event. Same pattern. Different event type."

**Quick tease — show but don't build:**

```java
// MouseEvent: drag text around the window
text.setOnMouseDragged(e -> {
    text.setX(e.getX());
    text.setY(e.getY());
});

// KeyEvent: move a character with arrow keys
text.setOnKeyPressed(e -> {
    switch (e.getCode()) {
        case UP:    text.setY(text.getY() - 10); break;
        case DOWN:  text.setY(text.getY() + 10); break;
        case LEFT:  text.setX(text.getX() - 10); break;
        case RIGHT: text.setX(text.getX() + 10); break;
    }
});
text.requestFocus(); // IMPORTANT: node must have focus to receive key events
```

> "Key events require `.requestFocus()`. A node only receives key events when it has focus."

> "We'll do the full mouse and key examples Tuesday. For now, understand the concept — it's the same triangle: source fires an event, event object carries info, handler responds."

---

### 1:12–1:15 (3 min) — Wrap-Up + Tuesday Preview

**Quick recap (say each item, have students complete it):**
> "Property binding: target calls `.____()` — *bind*"  
> "The property getter method naming convention: `centerXProperty()` returns a `__________` — *DoubleProperty object*"  
> "Handler requirement 1: implement `__________` — *EventHandler interface*"  
> "Handler requirement 2: __________ with the source — *register*"  
> "The modern preferred handler style: __________ — *lambda expression*"

**Tuesday preview:**
> "Tuesday we finish Chapter 15 — full Mouse events, Key events, and we start Animations with PathTransition. That's where your circle will start MOVING on its own."

---

## Teaching Notes

### What to Emphasize Most:
- ✅ Property binding conceptual model (target watches source, auto-updates)
- ✅ The THREE method types: value getter, value setter, property getter — students confuse `getCenterX()` vs `centerXProperty()`
- ✅ Lambda expressions — this is the *daily driver* they'll use. The others are context.
- ✅ Handler evolution from Style 1 → 4 — tie each step to "why"

### Common Student Mistakes:
- ❌ Calling `getCenterX()` when they need `centerXProperty()` for binding
- ❌ Forgetting to register the handler with `setOnAction` (defines the handler but never connects it)
- ❌ Lambda syntax confusion — missing `->`, putting braces when not needed
- ❌ Passing the wrong generic type: `EventHandler<ActionEvent>` vs just `EventHandler`
- ❌ Forgetting `requestFocus()` for key event handlers

### If Running Short on Time:
- Skip bidirectional binding detail (mention it exists, move on)
- Skip the explicit inner class (Style 2) if pace is slow — go directly from separate class to lambda
- Skip mouse/key preview (0:55-1:05 safe to abbreviate)
- Always keep the ControlCircle live demo — it ties everything together

### If Extra Time:
- Run `Example06_MouseEvents.java` live — students love the draggable text
- Show `Example07_KeyEvents.java` — arrow-key character movement
- Ask students: "How would you modify ControlCircle to also respond to mouse clicks?"

---

## Resources

- **Slides primary reference:** `.instructor/chapter14/chapter14slides.txt` (Property Binding section)
- **Slides primary reference:** `.instructor/chapter15/chapter15slides.txt`
- **Textbook §14.5:** Property Binding (ShowCircleCentered, BindingDemo)
- **Textbook §15.1–15.6:** Event handling through lambda expressions
- **Live demo examples:** `.instructor/chapter15/examples/Example01–05`
- **Run script:** `.instructor/chapter15/examples/run.ps1`

---

## Chapter 15 Examples Run Reference

```powershell
cd .instructor\chapter15\examples
.\run-Example01.bat   # Separate handler class
.\run-Example02.bat   # Inner class handler
.\run-Example03.bat   # Anonymous inner class
.\run-Example04.bat   # Lambda expression
.\run-Example05.bat   # ControlCircle (full)
```
