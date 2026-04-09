# Thursday April 9 Verbatim Script
# Finish Ch15: Event-Driven Programming + Start Ch16: UI Controls

> **How to use this script:** Read the quoted lines aloud. Text in `[brackets]` is an action cue to you (draw, run code, wait). Do not read bracket text. Pauses are marked — actually pause, make eye contact.

---

## Opening — 0:00 (5 min)

"Good afternoon, everyone. Welcome back. I know Tuesday's class was cancelled, so it's been a full week since we last met. I appreciate you all being here."

"Let me get us back on track. On April second — last Thursday — we covered two big things."

"First, we wrapped up Chapter 14 with images, property binding, all the visual fundamentals of JavaFX."

"Second, we STARTED Chapter 15 — event-driven programming. We talked about what an event is, what a source object is, what a handler is. That source, event, handler triangle."

[Draw on board:]
```
SOURCE → EVENT → HANDLER
```

"And we looked at two ways to write handlers. Example 1 was the separate class approach — you create a whole new class that implements EventHandler, then you instantiate it and pass it to setOnAction. Example 2 was the inner class approach — same idea but the handler class lives INSIDE your main application class."

"I told you that day — I'm not going to get into anonymous inner classes just yet, I'll save that for Tuesday. Well… Tuesday got cancelled. So today I owe you that, and a lot more."

[Write on board:]
```
TODAY:
  1. Anonymous Inner Classes (Ch15)
  2. Lambda Expressions (Ch15) ← THE modern way
  3. ControlCircle + Mouse/Key Events
  4. Animation preview
  5. Chapter 16 intro — UI Controls
```

"By the end of today, you will know four different ways to write an event handler, you'll understand why lambda expressions are the preferred modern style, and we'll start looking at the actual controls — checkboxes, radio buttons — that make real GUI applications."

"Let's pick up exactly where we left off."

---

## Part 1: Anonymous Inner Classes — 0:05 (13 min)

### Concept — 0:05 (5 min)

"All right. Last time we had two styles. Separate class — handler lives outside. Inner class — handler lives inside. Both of those required you to give the handler class a name. IncrementHandler. ResetHandler. ExitHandler. You had to name each one."

"Anonymous inner class says: what if we skip the name? What if we define the class AND create the object at the same time, right where we need it?"

"Here is what the syntax looks like."

[Write on board:]
```
INNER CLASS (Example 02):
  private class IncrementHandler implements EventHandler<ActionEvent> {
      @Override
      public void handle(ActionEvent e) {
          // your code here
      }
  }

  btIncrement.setOnAction(new IncrementHandler());


ANONYMOUS INNER CLASS (Example 03):
  btIncrement.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
          // your code here
      }
  });
```

"Look at the anonymous version. We're calling setOnAction, and right there — inside the parentheses — we're saying: give me a new EventHandler, and here's the implementation."

"No class name. No separate declaration. We define the class and create the object in one shot."

[Pause 3 seconds.]

"Let me break down the syntax piece by piece."

[Point to each part on the board:]

"First: `new EventHandler<ActionEvent>()` — this says we're creating a new object of a class that implements EventHandler. The parentheses at the end are the constructor call."

"Second: the curly braces `{ ... }` — this is the body of the anonymous class. Inside here, we override the handle method, just like before."

"Third: `@Override public void handle(ActionEvent e)` — same method signature. Same interface requirement. Nothing has changed about WHAT we're implementing."

"Fourth: and this is the tricky part — the whole expression ends with `);` — that's the closing parenthesis of setOnAction and the semicolon to end the statement."

"So to recap: we define a class, create an object of that class, and pass it to setOnAction — all in one expression. No name. That's why it's called anonymous."

### Live Demo — 0:10 (8 min)

"Let me run it so you can see it works exactly the same as the inner class version."

[Run Example03_AnonymousInnerClass.java]

"Increment. Increment. Increment. Reset. Same behavior as Example 02. Functionally identical."

[Close the running app.]

"Now let me show you the code."

[Open Example03_AnonymousInnerClass.java — show on screen.]

"Look at this. The increment button handler."

```java
btIncrement.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        clickCount++;
        messageText.setText("Click count: " + clickCount);
        System.out.println("Incremented to: " + clickCount);
    }
});
```

"See? No IncrementHandler class. No inner class. It's all right here, inline, inside the setOnAction call."

"And notice — it can still access `clickCount` and `messageText`. Those are fields of the outer class. Anonymous inner classes have the same access as inner classes. They can see everything in the enclosing class."

[Scroll down to the reset handler.]

"Same pattern for reset. Same pattern for exit. Each one is its own anonymous class, defined right where it's used."

[Pause.]

"Now, let me be honest with you. This syntax? It works. Java developers used this for years. But look at how much of this code is what I'll call boilerplate."

[Point to the anonymous handler on screen:]

"new EventHandler, angle bracket ActionEvent, angle bracket, parenthesis, curly brace, at Override, public void handle, parenthesis ActionEvent e, parenthesis, curly brace… all of THAT just to get to the two or three lines of code that actually do something."

"What if I told you there's a way to write just the important part and throw away all the rest?"

[Pause 3 seconds.]

"That brings us to lambda expressions."

---

## Part 2: Lambda Expressions — 0:18 (20 min)

### The Big Idea — 0:18 (7 min)

"This is the section I really want you to pay attention to, because lambda expressions are the way you're going to write event handlers going forward. This is the modern Java style. Java 8 introduced this in 2014, and it changed how everyone writes event-driven code."

"Here's the core idea. Look at this anonymous inner class one more time."

[Write on board:]
```
btIncrement.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        clickCount++;
        messageText.setText("Click count: " + clickCount);
    }
});
```

"I'm going to highlight what the compiler already knows and what it doesn't."

"The compiler knows we're calling setOnAction. setOnAction expects an EventHandler. EventHandler is an interface with exactly ONE method — handle. The method takes exactly ONE parameter of type ActionEvent."

"So what does the compiler NOT know? Just two things: the name you want to use for the parameter, and the code you want to run."

[Draw arrows on board — cross out the boilerplate:]
```
btIncrement.setOnAction(new EventHandler<ActionEvent>() {  ← compiler knows
    @Override                                                ← compiler knows
    public void handle(ActionEvent e) {                      ← compiler knows (except 'e')
        clickCount++;                                        ← YOUR CODE
        messageText.setText("Click count: " + clickCount);   ← YOUR CODE
    }                                                        ← compiler knows
});                                                          ← compiler knows
```

"If the compiler can figure out all of that, why are we writing it? The answer is: we don't have to."

"A lambda expression is the shortcut. You provide: the parameter, an arrow, and the body."

[Write on board:]
```
btIncrement.setOnAction(e -> {
    clickCount++;
    messageText.setText("Click count: " + clickCount);
});
```

"That's it. That replaced the entire anonymous inner class."

[Pause 3 seconds. Let it sink in.]

"Let me walk you through the syntax."

"`e` — that's the parameter. It's the ActionEvent object. We don't have to write ActionEvent, because the compiler already knows the type from setOnAction's signature."

"`->` — that's the arrow operator. You can read it as 'goes to' or 'does' or just 'arrow.' It separates the parameter from the body."

"`{ ... }` — that's the body. The code that runs when the event fires. Same code as before. Nothing changed about what happens."

"Now, here's an important detail. If your body is just a single statement, you don't even need the braces."

[Write on board:]
```
MULTIPLE STATEMENTS — braces required:
  e -> {
      clickCount++;
      messageText.setText("...");
  }

SINGLE STATEMENT — no braces needed:
  e -> System.exit(0)
```

"One statement? Arrow, then the statement. Done. Multiple statements? Arrow, braces, your statements, close braces."

[Pause.]

"Let me give you the rule that makes this all possible. The technical term is **functional interface**. A functional interface is an interface that has exactly ONE abstract method."

"EventHandler has one abstract method: handle. That makes it a functional interface. And any functional interface can be replaced by a lambda expression."

"You've actually seen functional interfaces before. Remember Comparable? It has one method — compareTo. Comparable is a functional interface too. The same lambda shortcut works for it."

### Live Demo — 0:25 (7 min)

"Let me run the lambda version so you can see it's the same behavior."

[Run Example04_LambdaExpression.java]

"Increment. Increment. Double. Double. Reset. Exit."

[Close the running app.]

"Now let's look at the code."

[Open Example04_LambdaExpression.java — show on screen.]

"Button increment — lambda with braces, because we have multiple statements."

```java
btIncrement.setOnAction(e -> {
    clickCount++;
    messageText.setText("Click count: " + clickCount);
    System.out.println("Incremented to: " + clickCount);
});
```

"Button exit — lambda without braces, single statement."

```java
btExit.setOnAction(e -> System.exit(0));
```

"One line. That entire handler is one line of code. Compare that to the twelve or thirteen lines from Example 01 with the separate class."

[Scroll to btDouble:]

"And look at the double button. It even accesses the event object itself."

```java
btDouble.setOnAction(e -> {
    clickCount *= 2;
    messageText.setText("Doubled! Count: " + clickCount);
    System.out.println("Event source: " + e.getSource());
});
```

"See? `e.getSource()`. The event object is still there. The lambda parameter `e` IS the ActionEvent. You can call any method on it."

[Pause.]

"Let me ask you to look at all four examples side by side in your head."

[Write on board:]
```
Example 01: Separate class       → ~15 lines per handler
Example 02: Inner class          → ~10 lines per handler
Example 03: Anonymous inner class → ~7 lines per handler
Example 04: Lambda expression    → 1–4 lines per handler
```

"Same functionality. Every single time. The behavior never changed. Only the amount of code we wrote changed."

### The Decision Guide — 0:32 (6 min)

"So the obvious question is: if lambdas are so short, why did I even show you the other three?"

"Two reasons. One: you WILL see the other styles in existing codebooks, online examples, and this textbook. You need to recognize them. Two: there are situations — rare, but real — where a separate or inner class is the better choice."

[Write on board:]
```
WHEN TO USE EACH:

Lambda expression     → DEFAULT. Use this unless you have a reason not to.
Anonymous inner class → Handler is moderate complexity, but still one-off.
Inner class          → Handler is complex, has its own state, used in one app.
Separate class       → Handler is complex AND reused across multiple classes.
```

"For your semester projects: lambdas. For Lab 11: lambdas. For 90 percent of everything you write in JavaFX: lambdas."

"On the exam, I WILL ask you to identify handler styles. I might show you an anonymous inner class and ask what it is. I might show you a lambda and ask you to convert it to an anonymous inner class. Know all four. Use lambda."

[Pause. Check for questions.]

"Any questions before we move on? This is important stuff, and I want you to feel solid on it."

[Wait 5–8 seconds. Address any questions.]

---

## Part 3: ControlCircle + Mouse/Key Events — 0:38 (10 min)

### ControlCircle — 0:38 (5 min)

"Now let's see lambdas in a real application. This is the ControlCircle example from Section 15.3 of the textbook."

[Run Example05_ControlCircle.java]

"Two buttons: Enlarge and Shrink. Watch."

[Click Enlarge several times. Click Shrink several times.]

"The circle grows and shrinks. Let me show you the code."

[Open Example05_ControlCircle.java — show on screen.]

"First — look at CirclePane. It's a custom class that extends StackPane."

```java
class CirclePane extends StackPane {
    private Circle circle = new Circle(50);

    public CirclePane() {
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        getChildren().add(circle);
    }

    public void enlarge() {
        circle.setRadius(circle.getRadius() + 5);
    }

    public void shrink() {
        if (circle.getRadius() > 5) {
            circle.setRadius(circle.getRadius() - 5);
        }
    }
}
```

"This is object-oriented design. CirclePane has a circle. It knows how to enlarge. It knows how to shrink. It doesn't know anything about buttons or events. It just manages itself."

"Now look at the application — the handler registration:"

```java
btEnlarge.setOnAction(e -> circlePane.enlarge());
btShrink.setOnAction(e -> circlePane.shrink());
```

"Two lines. Two lambdas. That's the entire event handling. Lambda calls a method on the CirclePane. Clean. Readable. No boilerplate."

"This is the pattern you're going to use in your projects. Build a custom pane class for your visual logic. Wire it up with lambdas for the event handling."

### Mouse and Key Events — 0:43 (5 min)

"Events aren't just button clicks. Any user input is an event. Mouse movements, mouse clicks, keyboard presses — same pattern, different event types."

[Run Example06_MouseEvents.java]

"Watch. I click in the pane, and the circle jumps to where I clicked. I drag, the circle follows. I move the mouse, the coordinates update."

[Demonstrate: click in different spots, drag the circle around.]

"All of this is the same pattern. Lambda handlers. But instead of setOnAction, it's setOnMouseClicked, setOnMouseDragged, setOnMouseMoved."

[Close MouseEvents. Run Example07_KeyEvents.java]

"Arrow keys to move the ball. Plus to enlarge. Minus to shrink. R to reset."

[Demo: press arrow keys, press + and -, press R.]

"Same idea — setOnKeyPressed with a lambda. Inside the lambda, a switch statement on e.getCode(). UP, DOWN, LEFT, RIGHT — those are the KeyCode values."

"One thing to remember about key events — and this WILL trip you up: the node must have focus. If you're not getting key events, call requestFocus on the node. That tells JavaFX: this is the node that should receive keyboard input."

[Close Example 07.]

"So to summarize: ActionEvent for buttons. MouseEvent for mouse interactions. KeyEvent for keyboard. Same source, event, handler pattern. Same lambda syntax. Different event class."

---

## Part 4: Animation Preview — 0:48 (7 min)

"One more piece from Chapter 15, and this one's fun."

[Run Example08_PathTransition.java]

"Watch the orange rectangle. It's moving around the circle path automatically."

[Let it animate for a few seconds.]

"Click on the circle to pause."

[Click to pause.]

"Release to resume."

[Release to resume.]

"That's the PathTransition class. Let me show you the key lines."

[Open Example08_PathTransition.java — show on screen.]

```java
PathTransition pathTransition = new PathTransition();
pathTransition.setDuration(Duration.millis(4000));
pathTransition.setPath(circlePath);
pathTransition.setNode(rectangle);
pathTransition.setCycleCount(Timeline.INDEFINITE);
pathTransition.setAutoReverse(true);
pathTransition.play();
```

"Duration — how long one cycle takes. Four thousand milliseconds, which is four seconds."

"Path — the shape the object follows. We used a circle."

"Node — the thing that moves. Our orange rectangle."

"CycleCount set to Timeline.INDEFINITE — it loops forever."

"AutoReverse — it bounces back instead of jumping to the start."

"And then play starts the animation."

"The pause and resume? That's mouse events."

```java
circlePath.setOnMousePressed(e -> pathTransition.pause());
circlePath.setOnMouseReleased(e -> pathTransition.play());
```

"Two one-line lambdas. Mouse pressed: pause. Mouse released: play. This is what we've been building to. Events, handlers, animation — all working together."

[Close Example 08.]

"And that wraps up Chapter 15. Let me put a bow on it."

"Chapter 15 gave us event-driven programming. Four handler styles — separate class, inner class, anonymous inner class, lambda expression. Lambda is preferred. We handle button clicks with ActionEvent, mouse interactions with MouseEvent, keyboard with KeyEvent. And we can animate objects with PathTransition and other animation classes."

"That is the backbone of every interactive JavaFX application you will write."

[Pause 3 seconds.]

---

## Part 5: Chapter 16 Introduction — UI Controls — 0:55 (17 min)

### Overview — 0:55 (5 min)

"All right. Let's shift gears."

"Chapter 14 taught us: how to display visual elements. Chapter 15 taught us: how to make them respond to user actions. Chapter 16 answers the question: what are the actual controls that users interact with?"

"Think about any application you use. You see checkboxes, radio buttons, text fields, drop-down menus, sliders. These are all UI controls, and Chapter 16 teaches you how to use every single one of them in JavaFX."

[Write on board:]
```
Chapter 16 — UI Controls:
  Label        (review — Ch14)
  Button       (review — Ch14/Ch15)
  CheckBox     ← NEW today
  RadioButton  ← NEW today
  TextField / PasswordField  ← Tuesday
  TextArea                   ← Tuesday
  ComboBox                   ← Tuesday
  Slider                     ← Tuesday
```

"You already know Label and Button. Those exist in the class hierarchy right here."

[Draw on board:]
```
Control
  └── Labeled
        ├── Label
        └── ButtonBase
              ├── Button
              ├── CheckBox
              └── ToggleButton
                    └── RadioButton
```

"See how CheckBox extends ButtonBase? That means it inherits setOnAction, just like Button. Same event handling you already know."

"RadioButton extends ToggleButton, which extends ButtonBase. Also has setOnAction."

"The takeaway: everything you learned in Chapter 15 about event handling applies directly to every control in Chapter 16. Lambda handlers. setOnAction. Same pattern. Different control."

### CheckBox Demo — 1:00 (6 min)

"Let me show you CheckBox first."

[Run CheckboxDemo.java from .instructor/chapter16/examples/]

"We have text on the screen: JavaFX Programming. Two checkboxes on the right: Bold and Italic."

[Check Bold.]

"Text becomes bold."

[Check Italic.]

"Text becomes bold italic."

[Uncheck Bold.]

"Text is now italic only."

[Uncheck Italic.]

"Back to normal."

"Let me show you the code."

[Open CheckboxDemo.java — show on screen.]

"Creating a CheckBox is simple."

```java
CheckBox chkBold = new CheckBox("Bold");
CheckBox chkItalic = new CheckBox("Italic");
```

"That's it. The string is the label next to the checkbox."

"To check whether a checkbox is selected, you call isSelected. It returns a boolean."

```java
if (chkBold.isSelected()) {
    // it's checked
}
```

"Now look at the event handling. This is the clever part."

```java
EventHandler<ActionEvent> handler = e -> {
    if (chkBold.isSelected() && chkItalic.isSelected()) {
        text.setFont(fontBoldItalic);
    } else if (chkBold.isSelected()) {
        text.setFont(fontBold);
    } else if (chkItalic.isSelected()) {
        text.setFont(fontItalic);
    } else {
        text.setFont(fontNormal);
    }
};

chkBold.setOnAction(handler);
chkItalic.setOnAction(handler);
```

"Notice what we did. We stored the lambda in a variable called handler. Then we registered that same handler for BOTH checkboxes. When either checkbox changes, the same logic runs: check the state of both boxes, set the font accordingly."

"This is a good pattern to remember. If multiple controls should trigger the same logic, create the handler once and register it with all of them."

"Key point about CheckBox: checkboxes are INDEPENDENT. Checking Bold has no effect on Italic. They work independently of each other. Each one has its own checked or unchecked state."

### RadioButton Demo — 1:06 (6 min)

"Now let's look at RadioButton. Different concept."

[Show AddRadioButtons.java code on screen.]

"RadioButtons are for when the user should pick exactly ONE option from a group. Like: Red, Green, or Blue. Not Red AND Green. Just one."

"Here's how you create them."

```java
RadioButton rbRed = new RadioButton("Red");
RadioButton rbGreen = new RadioButton("Green");
RadioButton rbBlue = new RadioButton("Blue");
```

"Looks just like CheckBox, right? But there's one critical extra step."

```java
ToggleGroup group = new ToggleGroup();
rbRed.setToggleGroup(group);
rbGreen.setToggleGroup(group);
rbBlue.setToggleGroup(group);
```

"ToggleGroup. You create a group and assign each radio button to it. The group enforces: only one button in this group can be selected at a time. When you click Red, Green and Blue automatically deselect."

"If you forget the ToggleGroup, the radio buttons act like checkboxes — you can select all three. That's almost certainly a bug."

"Event handling — same lambda pattern."

```java
rbRed.setOnAction(e -> {
    if (rbRed.isSelected()) {
        text.setFill(Color.RED);
    }
});
```

"setOnAction with a lambda. Check isSelected. Change the text color."

"So the comparison is:"

[Write on board:]
```
CheckBox:     Independent selections (Bold AND Italic)
              No ToggleGroup needed

RadioButton:  Mutually exclusive (Red OR Green OR Blue)
              MUST use ToggleGroup
```

"Both use setOnAction. Both use isSelected. The difference is independence versus mutual exclusivity."

[Pause.]

---

## Wrap-Up — 1:12 (3 min)

"All right, let me do a quick recap."

"Anonymous inner class — define and instantiate in one expression. No class name. Was the standard before Java 8."

"Lambda expression — the modern shortcut. Parameter, arrow, body. Works because EventHandler is a functional interface — exactly one abstract method."

"ControlCircle — separate your visual pane from your control logic. Wire them up with lambdas."

"Mouse events, key events — same handler pattern, different event types. Remember requestFocus for key events."

"Animation — PathTransition moves a node along a path. Duration, cycle count, auto reverse, play."

"Chapter 16 — UI controls inherit from Labeled and ButtonBase. CheckBox for independent selections. RadioButton plus ToggleGroup for mutually exclusive selections."

"On Tuesday, we continue Chapter 16 with TextField, TextArea, ComboBox, and Slider. Those are the input controls that round out your toolbox."

[Pause.]

"Reminders. Lab 11 is a two-week lab — use that time wisely. Semester projects — start implementing if you haven't already. Exam 3 will cover Chapters 14, 15, and 16."

"Thank you for being here today, everyone. Good work. See you Tuesday."

---

## FALLBACK CUTS (if running behind)

| Time Check | What to Cut | Time Saved |
|---|---|---|
| 0:42 and not at mouse/key yet | Skip mouse/key CODE walkthrough — just run Examples 06 and 07, show output only | 3 min |
| 0:50 and not at animation | Skip animation entirely — mention PathTransition exists, name the key methods, move to Ch16 | 5 min |
| 1:02 and not at RadioButton | Show RadioButton code on screen, explain ToggleGroup verbally, skip running | 3 min |
| 1:08 and not at wrap-up | Skip call-and-response recap — just state the key takeaways as bullet points | 2 min |
