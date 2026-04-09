# Chapter 14 JavaFX Examples

This folder contains complete, runnable JavaFX examples organized by concept.

## Examples Overview

| Example | Topic | Key Concepts |
|---------|-------|--------------|
| **Example01_MinimalApp** | Basic Structure | Application class, launch(), start(), Stage |
| **Example02_LabelScene** | Scene with Node | Scene creation, Label, theater analogy |
| **Example03_CircleShape** | Drawing Shapes | Circle, Pane, Color, typical JavaFX pattern |
| **Example04_FlowPaneLayout** | FlowPane | Automatic wrapping, gaps, padding |
| **Example05_GridPaneLayout** | GridPane | Row/column positioning, alignment |
| **Example06_HBoxVBox** | HBox/VBox | Horizontal/vertical layout, BorderPane |
| **Example07_ImageDisplay** | Images | Image, ImageView, sizing, rotation |
| **Example08_PropertyBinding** | Property Binding | bind(), observable properties, centering |
| **Example09_ColorFont** | Colors & Fonts | Color.rgb(), font families, CSS styling |
| **Example10_MultipleShapes** | Various Shapes | Circle, Rectangle, Line, Ellipse, Arc, Polygon |

## How to Run

### Prerequisites
- Java 21 installed
- Maven installed
- JavaFX libraries (handled by pom.xml)

### Running Examples

Navigate to the chapter14 directory, then:

```bash
cd .instructor/chapter14
```

#### Run specific example:
```bash
# Method 1: Using Maven JavaFX plugin (recommended)
mvn clean javafx:run -Djavafx.mainClass=com.example.javafx.Example01_MinimalApp

# Method 2: Using Maven exec plugin
mvn clean compile exec:java -Dexec.mainClass="com.example.javafx.Example01_MinimalApp"
```

#### Run from VS Code:
1. Open any example file
2. Right-click in editor
3. Select "Run Java" (requires Java extension pack)

**Note:** Make sure to update the `mainClass` in pom.xml if you want to run a specific example by default.

## Directory Structure

```
chapter14/
├── pom.xml                    # Maven configuration for JavaFX
├── examples/
│   ├── Example01_MinimalApp.java
│   ├── Example02_LabelScene.java
│   ├── Example03_CircleShape.java
│   ├── Example04_FlowPaneLayout.java
│   ├── Example05_GridPaneLayout.java
│   ├── Example06_HBoxVBox.java
│   ├── Example07_ImageDisplay.java
│   ├── Example08_PropertyBinding.java
│   ├── Example09_ColorFont.java
│   └── Example10_MultipleShapes.java
└── README.md
```

## Teaching Notes

### Suggested Presentation Order:
1. **Example01** - Show basic JavaFX structure
2. **Example02** - Add simple content (Label)
3. **Example03** - Introduce shapes and Pane
4. **Example04** - Show FlowPane layout
5. **Example05** - Compare with GridPane layout
6. **Example06** - Demonstrate HBox/VBox
7. **Example09** - Show colors and fonts
8. **Example10** - Show variety of shapes
9. **Example08** - Demonstrate property binding (advanced)
10. **Example07** - Images (if time permits)

### Live Coding Tips:
- Start with Example01 and gradually build complexity
- Copy/paste scaffolding, but type out the JavaFX-specific parts
- Have examples open to reference while live coding
- Emphasize the pattern: nodes → container → scene → stage

## Troubleshooting

### JavaFX not found:
```bash
mvn clean install
```

### Wrong main class error:
Edit pom.xml and update the `<mainClass>` in the javafx-maven-plugin configuration.

### Window doesn't appear:
Make sure you call `primaryStage.show()` at the end of `start()` method.

### Compilation errors:
Verify that:
- Java 21 is installed: `java -version`
- Maven is installed: `mvn -version`
- All imports are correct in the Java file

