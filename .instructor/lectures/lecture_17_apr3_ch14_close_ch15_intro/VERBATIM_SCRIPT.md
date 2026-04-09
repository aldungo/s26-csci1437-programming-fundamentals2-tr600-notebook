# Thursday April 3 Verbatim Script
# Ch14 Close: Property Binding + Ch15 Open: Event-Driven Programming

> **How to use this script:** Read the quoted lines aloud. Text in `[brackets]` is an action cue to you (draw, run code, wait). Do not read bracket text. Pauses are marked — actually pause, make eye contact.

---

## Opening — 0:00 (2–3 min)

"Good afternoon, everyone. Last Tuesday we put images onto the screen with `Image` and `ImageView`. You saw how the pipeline works: Image loads the data, ImageView is the visual node, Pane holds it, Scene wraps it, Stage shows it."

"Today we close out Chapter 14 with something I teased earlier — property binding. Then we open Chapter 15 — and that's where JavaFX goes from a pretty display to a real interactive program."

[Write on board:]
```
TODAY:
  Part 1 — Property Binding (Ch14 finish)
  Part 2 — Event-Driven Programming intro (Ch15 open)
  Part 3 — Handler styles: class → inner → anonymous → lambda
  Part 4 — ControlCircle demo
```

"Let's get into it."

---

## Part 1: The Problem — 0:05 (2 min)

"Quick question. When we displayed our circle earlier in Chapter 14, we had a problem. Does anyone remember what it was?"

[Wait 5 seconds for response. Accept any answer about the circle not staying centered.]

"Right. We hardcoded the circle center. Circle center X equals 100. Circle center Y equals 100. Works great when the window is 200 by 200. But the moment the user resizes the window — the circle doesn't move. It's stuck at 100, 100."

[Draw on board:]
```
Window 200x200 → circle at (100, 100) → CENTERED ✓
Window 400x300 → circle still at (100, 100) → OFF CENTER ✗
```

"The circle has no idea the window changed size. It doesn't know. We need to make it aware. That's property binding."

---

## Part 1: What is Property Binding? — 0:07 (8 min)

"Here's the core idea. In JavaFX, many objects don't just hold values. They hold something called a **binding property**. A binding property is an object that can watch another object and automatically update itself when that other object changes."

"There are two roles."

[Draw on board:]
```
TARGET ----------bind(SOURCE)----------> SOURCE
  ↑                                        ↑
binding property                     observable object

When SOURCE changes... TARGET auto-updates.
```

"Target is the thing that follows. Source is the thing being watched."

"And here's the part that trips students up. There are THREE methods on every binding property, not two."

[Write on board:]
```
Property: centerX

getCenterX()          → returns a double  (VALUE getter)
setCenterX(double)    → sets a double     (VALUE setter)
centerXProperty()     → returns DoubleProperty OBJECT  (PROPERTY getter)
```

"getCenterX gives you the number. centerXProperty gives you the object you can bind with. They sound similar but they are completely different things."

"Ask yourself: do I want to read the number? Use getCenterX. Do I want to bind or watch? Use centerXProperty."

[Pause 3 seconds.]

"Same convention for any property. If the property is named radius, then the property getter is radiusProperty(). If the property is named width, the property getter is widthProperty(). It always follows: property name plus the word Property."

"The types you'll see most often are:"

[Write:]
```
DoubleProperty   — for double values
IntegerProperty  — for int values
BooleanProperty  — for boolean values
StringProperty   — for String values
```

"These are abstract classes. For standalone use you create a SimpleDoubleProperty, SimpleIntegerProperty, and so on. When you're working with built-in JavaFX objects like Circle or Pane, they already provide these — you just call the property getter."

---

## Part 1: Live Code — Fix the Circle — 0:15 (10 min)

"Let me show you the fix. I'll type the broken version first, then we'll fix it with property binding."

[Open live coding environment. Type the BEFORE version:]

```java
// BROKEN — circle doesn't follow window resize
Circle circle = new Circle();
circle.setCenterX(100);     // ← hardcoded number
circle.setCenterY(100);     // ← hardcoded number
circle.setRadius(50);
circle.setStroke(Color.BLACK);
circle.setFill(Color.WHITE);

Pane pane = new Pane();
pane.getChildren().add(circle);
Scene scene = new Scene(pane, 200, 200);
```

"That's the broken version. Now watch very closely. I'm going to remove the two hardcoded lines and replace them with binding statements."

[Replace setCenterX and setCenterY with bind calls:]

```java
// FIXED — property binding
Circle circle = new Circle();
circle.setRadius(50);
circle.setStroke(Color.BLACK);
circle.setFill(Color.WHITE);

Pane pane = new Pane();

// Bind circle's centerX to half of pane's width
circle.centerXProperty().bind(pane.widthProperty().divide(2));

// Bind circle's centerY to half of pane's height
circle.centerYProperty().bind(pane.heightProperty().divide(2));

pane.getChildren().add(circle);
Scene scene = new Scene(pane, 200, 200);
```

"Let me read this out loud. Circle dot centerXProperty — that's the property getter, returning the DoubleProperty object. Dot bind — that connects it to a source. pane dot widthProperty — the observable source. Dot divide 2 — that's the math. Half of the width."

[Run it.]

"Now watch what happens when I resize the window."

[Resize the window. Circle stays centered.]

"There it is. The circle is watching the pane. Every time the pane's width changes, the binding recalculates. Half of the new width becomes the new center X. Automatically. No code to call. No manual recalculation. It just works."

"I want to point out the math methods. DoubleProperty and IntegerProperty give you four arithmetic methods you can chain."

[Write:]
```
.add(value)
.subtract(value)
.multiply(value)
.divide(value)
```

"Each one returns a new observable property. So you can write expressions like widthProperty().subtract(30).divide(2) and it creates a live expression that recalculates whenever width changes."

---

## Part 1: Unidirectional vs Bidirectional — 0:25 (7 min)

"What we just did has a name. It's called **unidirectional binding**. Changes flow in one direction. Source to target. The circle follows the pane. The pane does not follow the circle."

[Draw an arrow:]
```
pane.widthProperty()  ──→  circle.centerXProperty()
(source changes)             (target auto-updates)
```

"If you tried to set the circle's centerX manually now, while it's bound, JavaFX would actually throw a runtime exception. A bound property cannot be manually set. It's owned by the binding."

"To release a binding, you call unbind. And there's also a completely different mode — bidirectional binding."

"Bidirectional means both objects watch each other. Change one, the other updates. Change the other, the first one updates. You use bindBidirectional instead of bind."

[Write example:]
```java
textField1.textProperty().bindBidirectional(textField2.textProperty());
```

"Now if the user types in field one, field two updates. If they type in field two, field one updates. This is useful for syncing UI controls that represent the same data."

"Two constraints: both must be the same property type, and both must be writable binding properties — not just any observable value."

[Pause. Check for understanding. Ask:]

"Quick check. Three questions. Answer in your head or out loud."

"One: What does getCenterX return?"

[Wait 2 seconds.]

"A double — the number."

"Two: What does centerXProperty return?"

[Wait 2 seconds.]

"A DoubleProperty object — the binding property itself."

"Three: In this statement — circle.centerXProperty().bind(pane.widthProperty().divide(2)) — which is the target and which is the source?"

[Wait 3 seconds.]

"Circle's centerX is the target. It follows. Pane's width is the source. It drives the change."

"Good. Chapter 14 is done."

---

## Transition — 0:32 (1 min)

"Property binding is one of those concepts that feels abstract until you actually see something respond to a window resize without writing any resize handler. And we'll use it again when we do animations. But for now, we're opening Chapter 15."

"Chapter 15 is called Event-Driven Programming. And the key word is respond. So far our apps just display things. Chapter 15 is about what happens when the user does something — clicks, presses, moves the mouse. How do we make Java respond to those actions?"

---

## Part 2: What Is Event-Driven Programming? — 0:33 (5 min)

"In a normal console program, Java runs linear. Line 1 runs. Line 2 runs. Line 3 runs. When the method returns, it's done."

"In a GUI program, that model breaks down. The program launches, draws the window, and then just waits. It does nothing. It's waiting for the user to do something."

"When the user does something — clicks a button, presses a key, moves the mouse — Java creates an object called an event. That event is passed to a handler. The handler runs your response code. That's event-driven programming."

[Draw on board:]
```
USER CLICKS BUTTON
       ↓
SOURCE OBJECT       ← the Button (fires the event)
       ↓  creates
EVENT OBJECT        ← ActionEvent (holds info: source, timing, etc.)
       ↓  passed to
HANDLER OBJECT      ← your code that runs in response
```

"Three actors. Every GUI interaction in Java follows this triangle. Remember the triangle."

"The button is not the only source. Anywhere the user interacts with your app can be a source. Buttons fire ActionEvent. Mouse movements fire MouseEvent. Key presses fire KeyEvent. Text fields fire ActionEvent when you hit Enter. Check boxes fire ActionEvent when you check them."

"The source object fires the event. The event object carries information. The handler processes it."

---

## Part 2: Requirements to be a Handler — 0:38 (4 min)

"Now, you can't just write any class and say 'you're a handler.' Two specific requirements:"

[Write on board:]
```
Requirement 1:
  Implement EventHandler<ActionEvent>
  → must override handle(ActionEvent e)

Requirement 2:
  Register with the source using:
  button.setOnAction(handler)
```

"First: your handler class must implement the EventHandler interface. Specifically, EventHandler of ActionEvent for button clicks. That interface has one method: handle, which takes the event as a parameter and returns void."

"Second: you must register the handler with its source. The button has to know about your handler. You connect them by calling setOnAction and passing your handler object."

"If you define a handler but forget to register it, nothing happens. Define and register. Both are required."

---

## Part 3: Handler Style 1 — Separate Class — 0:42 (3 min)

"Now I want to show you the same functionality written four different ways. This is important because you'll see all four in code, in examples, and in your future work. Each has tradeoffs."

"Style one: a completely separate class."

[Type or show:]
```java
// Separate class — defined outside your main app
class ColorHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        // do something
        System.out.println("Color button clicked");
    }
}

// In start():
Button btColor = new Button("Change Color");
btColor.setOnAction(new ColorHandler());
```

"Clean structure. Very clear. Perfect for complex handlers that need their own file or methods. The downside: if this handler needs access to other parts of your app — like a circle inside your main class — it can't get there easily. It would need a reference passed to it."

"Best fit: one handler that does something complex and is reused in multiple places."

---

## Part 3: Handler Style 2 — Inner Class — 0:45 (3 min)

"Style two: an inner class. Defined inside your main application class."

[Type or show:]
```java
public class MyApp extends Application {
    private CirclePane circlePane = new CirclePane(); // field in outer class

    public void start(Stage primaryStage) {
        Button btColor = new Button("Change Color");
        btColor.setOnAction(new ColorHandler()); // register
        // ...
    }

    // Inner class — can directly access outer class fields
    class ColorHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.setFill(Color.GREEN); // works — circlePane is in outer class
        }
    }
}
```

"The inner class is compiled as MyApp dollar sign ColorHandler. You can see why this is powerful: the handler lives inside the app and has direct access to circlePane without needing anything passed to it."

"Inner classes are great when your handler is closely tied to one specific application and needs to touch the application's state."

---

## Part 3: Handler Style 3 — Anonymous Inner Class — 0:48 (3 min)

"Style three: an anonymous inner class. Same idea as an inner class — but we skip naming the class entirely."

[Type or show:]
```java
btColor.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        circlePane.setFill(Color.GREEN);
    }
});
```

"We define AND instantiate the class in one expression. No class name. The syntax says: new EventHandler of ActionEvent, open brace, implement handle, close brace. The object is created right there and passed directly to setOnAction."

"Before Java 8, this was the standard. You'll see this often in older code. It reduces the number of named classes in your file while still being fairly explicit about what you're doing."

---

## Part 3: Handler Style 4 — Lambda Expression — 0:51 (5 min)

"Style four is the modern way. Lambda expressions. This is what you should default to for simple handlers."

[Write:]
```java
btColor.setOnAction(e -> circlePane.setFill(Color.GREEN));
```

"One line. The compiler looks at setOnAction and knows it expects an EventHandler of ActionEvent. That interface has exactly one method. So the lambda is understood as: e is the ActionEvent parameter, and the right side is the body of handle."

"EventHandler has exactly one abstract method. That makes it a **functional interface** — also called a SAM interface, Single Abstract Method. Lambda expressions work with functional interfaces. If the interface has one method, the compiler can match your lambda to it."

"Lambda syntax — let me be precise."

[Write on board:]
```
One parameter, no declared type, one-line body:
  e -> doSomething()

One parameter, with declared type:
  (ActionEvent e) -> doSomething()

Multiple parameters:
  (e1, e2) -> doSomething()

Multi-line body:
  e -> {
      doThis();
      doThat();
  }
```

"Parentheses around the parameter are optional when there's one parameter with no declared type. Braces are optional when the body is one statement."

"This is the style you'll use most. Get comfortable with it."

[Pause. Then say:]

"So four styles. One-sentence summary for each:"

"Separate class — most structure, least access to outer context."
"Inner class — structure plus access to outer fields."
"Anonymous inner class — less code, same access."
"Lambda — minimum code, same access, preferred when the logic is simple."

---

## Part 4: ControlCircle Live Demo — 0:56 (10 min)

"Let me show you a complete example. We'll run the ControlCircle from the Chapter 15 examples. This has a circle in the window, and two buttons — Enlarge and Shrink."

[Navigate to `.instructor/chapter15/examples/` and run Example05, or show the code:]

```java
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
        circle.setRadius(
            circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius()
        );
    }
}

public class ControlCircle extends Application {
    private CirclePane circlePane = new CirclePane();

    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink  = new Button("Shrink");

        // Lambda event handlers
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

[Run it. Click Enlarge several times. Click Shrink.]

"Look at how short the handlers are. One line each. btEnlarge.setOnAction — lambda — circlePane.enlarge. That's the whole handler."

"I want to highlight three things here."

"One: CirclePane extends StackPane. We created a custom node by extending an existing pane class. The circle lives inside it, and we expose enlarge and shrink as public methods. This is clean object-oriented design — the data and the behavior that modifies it are packaged together."

"Two: circlePane is a data field of the ControlCircle application class. Both lambda handlers can access it directly because they capture the enclosing scope. This is the same reason inner classes work."

"Three: the pattern of registering handlers — btEnlarge.setOnAction — is always the same regardless of whether you use a separate class, an inner class, or a lambda. You always call setOnAction and pass the handler."

---

## Part 4: Mouse and Key Preview — 1:06 (6 min)

"One more preview before we close. Button clicks aren't the only kind of event. The same pattern — source fires, event is created, handler responds — applies to mouse events and key events."

"For mouse events, any node can fire them. Mouse pressed. Mouse released. Mouse clicked. Mouse moved. Mouse dragged. Each has its own registration method."

[Show but don't build — just read aloud and point to:]
```java
// Drag a text node around with the mouse
text.setOnMouseDragged(e -> {
    text.setX(e.getX());
    text.setY(e.getY());
});
```

"The MouseEvent object carries the x and y of where the mouse is right now. So when you drag, the handler reads the mouse position and sets the text to that position. Simple and immediate."

"For key events:"

[Show:]
```java
text.setOnKeyPressed(e -> {
    switch (e.getCode()) {
        case UP:    text.setY(text.getY() - 10); break;
        case DOWN:  text.setY(text.getY() + 10); break;
        case LEFT:  text.setX(text.getX() - 10); break;
        case RIGHT: text.setX(text.getX() + 10); break;
    }
});
text.requestFocus();
```

"The KeyEvent object carries the key code — a constant like KeyCode.UP, KeyCode.DOWN, KeyCode.ENTER, KeyCode.A through Z."

"Critical note: a node only receives key events if it has focus. You have to call requestFocus after the stage is shown. If you forget requestFocus, your key handler will never fire. That's a frequent bug."

"We'll build both of these in full on Tuesday."

---

## Wrap-Up — 1:12 (3 min)

"Quick recap. Fill in the blank."

"To bind a property, the target calls dot blank on the source."
[Wait.]
"dot bind."

"Property getter method for centerX is called blank."
[Wait.]
"centerXProperty — property name plus Property."

"getCenterX returns a blank. centerXProperty returns a blank."
[Wait.]
"getCenterX returns a double. centerXProperty returns a DoubleProperty object."

"Two requirements to be a handler: implement blank, and blank with the source."
[Wait.]
"Implement EventHandler. Register with setOnAction."

"The modern preferred handler style for simple handlers is blank."
[Wait.]
"Lambda expression."

"EventHandler is a blank interface because it has exactly blank abstract method."
[Wait.]
"Functional interface. One abstract method."

"Good work today. On Tuesday we go deeper into Chapter 15: full mouse events, full key events, and we start animations with PathTransition. That's where a shape moves along a path on its own, smooth animation, on a timer. See you Tuesday."

---

## If Students Ask About Observers vs Binding

"Property binding is a specific mechanism in JavaFX. There's also a more general concept called the Observer pattern — where objects register to receive notifications of changes. Binding is built on top of that. Chapter 15 section 15.10 shows `InvalidationListener` and `addListener` which is the lower-level version of what we just used with `bind`. For now, `bind` is the tool. If you're curious about the underlying mechanism, that's in section 15.10."

---

## If Students Ask: "Can I bind to a non-JavaFX value?"

"Good question. For the source to work with bind, it must implement ObservableValue. Regular Java fields don't do that. If you want to make a plain field observable, you'd wrap it in one of the property classes — like SimpleDoubleProperty. You create the property, expose its value getter and setter, and now it participates in binding."

---

## If Running Behind — Cut List (in order of what to drop)

1. Drop the explicit inner class style (Style 2) mention — go straight from separate class to anonymous class
2. Shorten the mouse/key preview to 2 minutes
3. Compress the bidirectional binding section to one sentence
4. Keep: property binding live demo, lambda style, ControlCircle demo — these are non-negotiable

---

## If Running Ahead — Expansion Options

1. Show `Example06_MouseEvents.java` live — draggable text is very satisfying
2. Ask students: "How would you modify ControlCircle to also respond to mouse clicks on the circle?"
3. Show `BindingDemo.java` — SimpleDoubleProperty standalone example from textbook §14.5
4. Ask: "If you wanted to bind a label's text to a text field's content (so the label always shows what the user is typing), how would that work?"
