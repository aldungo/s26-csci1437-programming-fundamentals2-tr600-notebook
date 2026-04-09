# Lecture Game Plan - Chapter 14: JavaFX Basics
**Date: [TBD] | Time: [Class Time]**

---

## Pre-Class Setup (5 min before)

- [ ] Display welcome board HTML
- [ ] Open Chapter14.ipynb notebook (for prep reference)
- [ ] Have examples folder ready for live coding
- [ ] Test screen share works
- [ ] Start terminal for `mvn javafx:run` commands
- [ ] Have slides ready (optional - prefer live coding)

---

## Timeline

### Opening (3-5 min)

**Quick Transition Statement:**
"Alright! Up until now, we've been working in the console - text input, text output. Today we're doing something TOTALLY different - we're building actual GUI applications with windows, buttons, shapes, and more!"

**Learning Objectives** (briefly state):
1. Understand JavaFX application structure
2. Master the "theater analogy" (Stage → Scene → Nodes)
3. Create layouts with different Panes
4. Add shapes, images, colors, and fonts
5. Use property binding for responsive GUIs

---

## Part 1: JavaFX Structure (15-20 min)

### 1.1 The Basics (5 min)

**Conceptual Intro:**
"JavaFX uses a **theater metaphor** to organize GUI applications. Think about it:
- **Stage** = the theater stage (your application window)
- **Scene** = what's happening on the stage (all the visual elements)
- **Nodes** = the actors on the scene (buttons, labels, shapes, etc.)"

**Key Classes to Introduce:**
- `Application` - base class for all JavaFX apps
- `Stage` - the window
- `Scene` - the content
- `Node` - any visual component

### 1.2 Live Code: Example01_MinimalApp (5 min)

**Start with simplest possible JavaFX app:**

```java
import javafx.application.Application;
import javafx.stage.Stage;

public class Example01_MinimalApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First GUI Application");
        primaryStage.show();  // IMPORTANT: Must call show()!
    }

    public static void main(String[] args) {
        launch(args);  // Launches the JavaFX application
    }
}
```

**Key Points to Emphasize:**
- ✅ Inherit from `Application`
- ✅ Override `start(Stage primaryStage)` method
- ✅ Call `launch(args)` in main
- ✅ Must call `show()` or nothing appears!

**Run it:** `mvn clean javafx:run -Djavafx.mainClass=com.example.javafx.Example01_MinimalApp`

### 1.3 Live Code: Example02_LabelScene (5 min)

**Add actual content - a Label:**

```java
Label myLabel = new Label("Welcome to JavaFX!");
Scene scene = new Scene(myLabel);

primaryStage.setTitle("JavaFX Label Example");
primaryStage.setScene(scene);
primaryStage.show();
```

**Key Points:**
- Scene needs a **root node** (the Label)
- Must use `setScene()` before `show()`
- This is the **Theater Analogy** in action!

**Run it and show the label appears**

### 1.4 Check for Understanding (3-5 min)

**Quick Poll or Questions:**
- "What class do all JavaFX apps extend?"
- "What method do we override to create the GUI?"
- "What are the three main parts of the theater analogy?"

---

## Part 2: Shapes and Panes (15-20 min)

### 2.1 The JavaFX Pattern (3 min)

**Write this pattern on board/slide:**
```
1. Create individual nodes (shapes, controls)
2. Create containers (panes) and add nodes
3. Create scene object
4. Prepare and show stage
```

"This is the recipe for **every** JavaFX app. Memorize this!"

### 2.2 Live Code: Example03_CircleShape (10 min)

**Show the full pattern:**

```java
// 1. Create the node (Circle)
Circle circle = new Circle();
circle.setCenterX(100);
circle.setCenterY(100);
circle.setRadius(50);
circle.setStroke(Color.BLACK);
circle.setFill(Color.WHITE);

// 2. Create container and add node
Pane pane = new Pane();
pane.getChildren().add(circle);

// 3. Create scene
Scene scene = new Scene(pane, 200, 200);

// 4. Prepare stage
primaryStage.setScene(scene);
primaryStage.setTitle("Show Circle");
primaryStage.show();
```

**Key Points:**
- **Why do we need a Pane?** Because we want to position nodes freely!
- `getChildren()` returns an ObservableList - you can add/remove nodes
- Scene size is set with `new Scene(pane, width, height)`
- `Color.BLACK`, `Color.WHITE` are constants

**Run it and show the circle**

**BONUS:** Show CSS styling:
```java
circle.setStyle("-fx-stroke: black; -fx-fill: red;");
```

### 2.3 Quick Overview: Other Shapes (3 min)

**Mention briefly (don't code yet):**
- `Rectangle`
- `Line`
- `Ellipse`
- `Arc`
- `Polygon`

"We'll see a full example with multiple shapes later!"

---

## Part 3: Layout Panes (20-25 min)

### 3.1 Why Layout Panes? (2 min)

"So far we've used `Pane` which lets us position things manually. But what if we want JavaFX to do the layout for us? That's where **layout panes** come in!"

**Four main types:**
- **FlowPane** - wraps to next row automatically
- **GridPane** - organized in rows and columns
- **HBox** - horizontal arrangement
- **VBox** - vertical arrangement

### 3.2 Live Code: Example04_FlowPaneLayout (5-7 min)

```java
FlowPane pane = new FlowPane();
pane.setPadding(new Insets(11, 12, 13, 14));
pane.setHgap(5);  // horizontal gap
pane.setVgap(5);  // vertical gap

pane.getChildren().addAll(
    new Label("First Name:"),
    new TextField(),
    new Label("MI:"),
    new TextField(),
    new Label("Last Name:"),
    new TextField()
);

Scene scene = new Scene(pane, 300, 100);
```

**Key Points:**
- FlowPane **wraps** to next row when out of space
- `Insets(top, right, bottom, left)` for padding
- Try resizing the window! Elements reflow!

### 3.3 Live Code: Example05_GridPaneLayout (7-10 min)

```java
GridPane pane = new GridPane();
pane.setAlignment(Pos.CENTER);
pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
pane.setHgap(5.5);
pane.setVgap(5.5);

// Add nodes at specific (column, row) positions
pane.add(new Label("First Name:"), 0, 0);  // column 0, row 0
pane.add(new TextField(), 1, 0);

pane.add(new Label("MI:"), 0, 1);
pane.add(new TextField(), 1, 1);

pane.add(new Label("Last Name:"), 0, 2);
pane.add(new TextField(), 1, 2);

Button btAdd = new Button("Add Name");
pane.add(btAdd, 1, 3);
GridPane.setHalignment(btAdd, HPos.RIGHT);  // Align right in cell
```

**Key Points:**
- GridPane gives you **precise control** with rows/columns
- `add(node, column, row)` - column first, row second
- You can skip cells!
- Can align within cells using `setHalignment()`

**Compare to FlowPane**: "Which one would you use for a form?"

### 3.4 Live Code: Example06_HBoxVBox (5-7 min)

```java
// HBox - horizontal layout
HBox hBox = new HBox(15);  // 15 pixels spacing
hBox.setPadding(new Insets(15, 15, 15, 15));
hBox.getChildren().add(new Button("Computer Science"));
hBox.getChildren().add(new Button("Chemistry"));
hBox.getChildren().add(new Button("Mathematics"));

// VBox - vertical layout
VBox vBox = new VBox(15);  // 15 pixels spacing
vBox.setPadding(new Insets(15, 5, 5, 5));
vBox.getChildren().add(new Label("Courses"));
vBox.getChildren().add(new Label("CSCI 1301"));
vBox.getChildren().add(new Label("CSCI 1302"));
vBox.getChildren().add(new Label("CSCI 2410"));

// Combine with BorderPane
BorderPane pane = new BorderPane();
pane.setTop(hBox);
pane.setLeft(vBox);
```

**Key Points:**
- HBox = horizontal, left to right
- VBox = vertical, top to bottom
- Can **combine** panes using BorderPane (top, bottom, left, right, center)

---

## Part 4: Colors, Fonts, and Styling (10-15 min)

### 4.1 Colors (5 min)

**Show different ways to create colors:**

```java
// Method 1: Color constants
Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.WHITE

// Method 2: RGB
Color.rgb(255, 0, 0, 1.0);  // Red with full opacity

// Method 3: Web color
Color.web("#00FF00");  // Green
```

**Apply to nodes:**
```java
Label myLabel = new Label("Colorful Text");
myLabel.setTextFill(Color.rgb(255, 0, 0, 1.0));

Circle circle = new Circle(50);
circle.setFill(Color.BLUE);
circle.setStroke(Color.BLACK);
```

### 4.2 Fonts (5 min)

```java
Font font = new Font("SansSerif", 16);

Label label = new Label("Custom Font");
label.setFont(font);

// Or with font weight
Font boldFont = Font.font("Arial", FontWeight.BOLD, 20);
```

**Show font families:**
```java
List<String> fontNames = Font.getFontNames();
fontNames.forEach(System.out::println);
```

### 4.3 CSS Styling (2-3 min)

"You can also use CSS syntax directly in Java:"

```java
label.setStyle("-fx-text-fill: rgb(255, 0, 0); -fx-font-size: 26px;");
```

**Point to CSS reference:** https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html

---

## Part 5: Property Binding (10-15 min) [ADVANCED]

### 5.1 The Problem (2 min)

"Let's say we want a circle to stay **centered** in the window even when we resize it. How do we do that?"

**Show the problem:** Circle at fixed position (100, 100) - doesn't move when resizing.

### 5.2 The Solution: Property Binding (5 min)

```java
Circle circle = new Circle();
circle.setRadius(50);

Pane pane = new Pane();
pane.getChildren().add(circle);

// BIND circle center to pane dimensions!
circle.centerXProperty().bind(pane.widthProperty().divide(2));
circle.centerYProperty().bind(pane.heightProperty().divide(2));
```

**Key Concepts:**
- **Property getter** vs **Value getter**
  - `getCenterX()` → returns `double` value
  - `centerXProperty()` → returns `DoubleProperty` object
- **Observable properties** automatically update when source changes
- Can do math: `divide()`, `multiply()`, `add()`, `subtract()`

**Run and resize window - circle stays centered!**

### 5.3 Unidirectional vs Bidirectional (3-5 min)

**Unidirectional:**
```java
circle.centerXProperty().bind(pane.widthProperty().divide(2));
// Changes in pane width → update circle center
// Changes in circle center → NO effect on pane
```

**Bidirectional:**
```java
textField1.textProperty().bindBidirectional(textField2.textProperty());
// Changes in either text field update the other!
```

---

## Part 6: Wrap-Up and Multiple Shapes Demo (5-10 min)

### 6.1 Show Example10_MultipleShapes

**Run the complete example with:**
- Circle
- Rectangle
- Line
- Ellipse
- Arc
- Polygon

"This shows you can create complex, colorful UIs by combining shapes!"

### 6.2 Recap Key Points

**Write on board:**
```
✅ Extend Application, override start()
✅ Theater Analogy: Stage → Scene → Nodes
✅ Pattern: nodes → container → scene → stage
✅ Layout Panes: FlowPane, GridPane, HBox, VBox
✅ Colors: constants, rgb(), web()
✅ Fonts: new Font("family", size)
✅ Property Binding: .property().bind()
```

### 6.3 Next Steps

"In the next chapter, we'll learn about:
- Event handling (button clicks!)
- Animations
- More advanced UI controls
- Building interactive applications"

---

## Homework/Practice

**Assign:**
1. Modify Example03 to create multiple colored circles
2. Create a simple form using GridPane with at least 4 fields
3. Experiment with property binding - try binding text field width to window width

**Optional Challenge:**
Create a "face" using shapes (2 circles for eyes, arc for smile, circle for head)

---

## Teaching Notes

### What to Emphasize:
- ✅ The JavaFX pattern is **consistent** - follow it every time
- ✅ Theater analogy helps organize thinking
- ✅ Property binding is powerful but can wait for later
- ✅ Start simple, build complexity gradually

### Common Student Mistakes:
- ❌ Forgetting to call `show()` on stage
- ❌ Not setting scene on stage before showing
- ❌ Confusing rows and columns in GridPane
- ❌ Trying to add multiple root nodes to Scene (use Pane!)
- ❌ Mixing up property getter and value getter

### If Running Short on Time:
- Skip property binding (save for next class)
- Skip images example
- Focus on: basic structure, one layout pane (GridPane), colors

### If Extra Time:
- Show CSS external files
- Demonstrate more shapes
- Let students experiment with fonts and colors
- Show image loading example

---

## Resources

- **Examples Folder:** `.instructor/chapter14/examples/`
- **Notebook:** `.instructor/notebooks/Chapter14.ipynb`
- **CSS Reference:** https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html
- **JavaFX Docs:** https://openjfx.io/

---

## Backup Plan (If JavaFX Setup Issues)

If students have JavaFX installation issues:

1. **Use codespaces/cloud IDE** - JavaFX already configured
2. **Share your screen** - they follow along
3. **Provide pre-compiled examples** - they can run JARs
4. **Office hours** - help with individual setup

**Don't let setup issues derail the lesson!** Focus on concepts, fix individual setups later.
