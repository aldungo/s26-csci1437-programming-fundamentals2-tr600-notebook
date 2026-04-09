# JavaFX Setup Guide

This guide explains how to set up and run JavaFX applications in this repository for Chapter 14.

---

## Prerequisites

Before running JavaFX applications, you need at least:

1. **Java 21 (or later)** installed ✅ **(You have Java 22 - Good!)**
2. **ONE of the following:**
   - **OPTION A:** VS Code with Java Extension Pack (EASIEST)
   - **OPTION B:** Maven (for command-line running)
   - **OPTION C:** JavaFX SDK downloaded separately

### Verify What You Have:

```bash
# Check Java version
java -version
# ✅ You have: Java 22.0.1

# Check Maven version
mvn -version
# ❌ You don't have Maven installed
```

### What You Need to Install:

**RECOMMENDED for Teaching: Install Maven**
- **Via Chocolatey:** `choco install maven`
- **Manual:** Download from [Apache Maven](https://maven.apache.org/download.cgi)

**OR use VS Code's Run Java button** (no additional install needed)

---

## Quick Start

### 1. Navigate to Chapter 14 folder:

```bash
cd .instructor/chapter14
```

### 2. Install JavaFX dependencies:

```bash
mvn clean install
```

This downloads JavaFX libraries (may take a few minutes first time).

### 3. Run an example:

```bash
mvn clean javafx:run -Djavafx.mainClass=com.example.javafx.Example01_MinimalApp
```

A window should appear!

---

## Repository Structure

```
.instructor/chapter14/
├── pom.xml                          # Maven config with JavaFX dependencies
├── chapter14slides.txt              # Lecture slides content
├── chapter14code.java               # Original code snippets
├── chapter14 -textbook.txt          # Textbook reference
├── GAME_PLAN.md                     # Detailed lecture plan
├── README-SETUP.md                  # This file
└── examples/                        # Complete runnable examples
    ├── Example01_MinimalApp.java
    ├── Example02_LabelScene.java
    ├── Example03_CircleShape.java
    ├── Example04_FlowPaneLayout.java
    ├── Example05_GridPaneLayout.java
    ├── Example06_HBoxVBox.java
    ├── Example07_ImageDisplay.java
    ├── Example08_PropertyBinding.java
    ├── Example09_ColorFont.java
    ├── Example10_MultipleShapes.java
    └── README.md
```

---

## Running Examples

### Method 1: Maven JavaFX Plugin (Recommended)

```bash
# From .instructor/chapter14/ directory:
mvn clean javafx:run -Djavafx.mainClass=com.example.javafx.Example01_MinimalApp
```

Replace `Example01_MinimalApp` with any other example name.

### Method 2: VS Code (Easiest for Live Coding)

1. Open any example file (e.g., `Example01_MinimalApp.java`)
2. Right-click in the editor
3. Select **"Run Java"**

The Java Extension Pack will handle compilation and execution.

### Method 3: Update pom.xml Default

Edit `pom.xml` line ~58 to change the default main class:

```xml
<configuration>
    <mainClass>com.example.javafx.Example03_CircleShape</mainClass>
</configuration>
```

Then simply run:
```bash
mvn clean javafx:run
```

---

## For Live Coding During Class

### Recommended Workflow:

1. **Have Terminal Open:** Keep a PowerShell terminal in `.instructor/chapter14/`
2. **Open Examples Folder:** Reference working examples while coding
3. **Create New File:** Code alongside students in a new file like `LiveDemo.java`
4. **Run Frequently:** Run after each section to show progress

### Template for Live Coding:

```java
package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LiveDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Your code here during class
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

Then run:
```bash
mvn clean compile exec:java -Dexec.mainClass="com.example.javafx.LiveDemo"
```

---

## Understanding pom.xml

The `pom.xml` file includes:

### JavaFX Dependencies:
```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>21.0.1</version>
</dependency>
```

This pulls in:
- `javafx-base` - Core JavaFX classes
- `javafx-graphics` - Stage, Scene, Node, shapes
- `javafx-controls` - Button, Label, TextField, etc.

### JavaFX Maven Plugin:
```xml
<plugin>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-maven-plugin</artifactId>
    <version>0.0.8</version>
</plugin>
```

This handles:
- Module path configuration
- Native libraries for JavaFX
- Cross-platform compatibility

---

## Troubleshooting

### Issue: "Error: JavaFX runtime components are missing"

**Solution:** You're trying to run without Maven. Use one of the methods above.

### Issue: "Could not find or load main class"

**Solution:** Check that:
1. Package name is `com.example.javafx`
2. Class name matches exactly (case-sensitive)
3. File is in `examples/` folder
4. You've run `mvn clean compile` first

### Issue: "Window doesn't appear"

**Solution:** Make sure you called `primaryStage.show()` at the end of `start()` method.

### Issue: Maven is slow

**Solution:** First run downloads libraries. Subsequent runs are faster. Add `-o` (offline) flag if libraries are already downloaded:
```bash
mvn clean javafx:run -o
```

### Issue: "Module not found" errors

**Solution:** Delete `target/` folder and rebuild:
```bash
rm -r target
mvn clean install
```

### Issue: Display/graphics errors on remote desktop

**Solution:** JavaFX uses hardware acceleration. On some systems, set:
```bash
export PRISM_NO_DIRECT3D=true
# or on Windows:
set PRISM_NO_DIRECT3D=true
```

Then run normally.

---

## For Students (Codespaces / Cloud Setup)

If students are using GitHub Codespaces:

### 1. They need X11 forwarding for GUI:

Codespaces doesn't natively support GUI windows. Options:

**Option A: Use NoVNC (VNC in Browser)**
- Install VNC server in container
- Access via browser

**Option B: Use Swing2Web**
- Run JavaFX apps in browser via web wrapper
- Complex setup

**Option C: Run locally (Recommended)**
- Clone repo to local machine
- Run JavaFX there

### 2. Alternative: Provide Screenshots/Videos

If students can't run JavaFX:
- Show live demos during class
- Provide screenshots of each example
- Post screen recordings

---

## Teaching Setup Checklist

Before class:
- [ ] Verify `mvn javafx:run` works for Example01
- [ ] Have terminal open in `.instructor/chapter14/`
- [ ] Have examples folder open for reference
- [ ] Test screen sharing with GUI window visible
- [ ] Create blank `LiveDemo.java` file for coding along
- [ ] If on remote desktop, test JavaFX works
- [ ] Have backup plan if demo fails

During class:
- [ ] Start with working example first (builds confidence)
- [ ] Code NEW examples alongside students
- [ ] Run frequently to verify code works
- [ ] Keep completed examples open for reference
- [ ] If code breaks, copy from working example

After class:
- [ ] Commit any new live demos to `.instructor/chapter14/examples/`
- [ ] Note any technical issues for next time
- [ ] Update GAME_PLAN.md with timing adjustments

---

## Alternative: Run Without Maven

If Maven causes issues, you can run JavaFX directly with java command:

### 1. Download JavaFX SDK:
https://gluonhq.com/products/javafx/

### 2. Extract to a folder (e.g., `C:\javafx-sdk-21`)

### 3. Compile:
```bash
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls Example01_MinimalApp.java
```

### 4. Run:
```bash
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls Example01_MinimalApp
```

**Note:** Maven is easier! Use this only as last resort.

---

## Resources

- **JavaFX Documentation:** https://openjfx.io/
- **CSS Reference:** https://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html
- **JavaFX Tutorial:** https://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm
- **Maven JavaFX Plugin:** https://github.com/openjfx/javafx-maven-plugin

---

## Summary

**To run during class:**
```bash
cd .instructor/chapter14
mvn clean javafx:run -Djavafx.mainClass=com.example.javafx.Example01_MinimalApp
```

Replace `Example01_MinimalApp` with whichever example you want to show.

**For live coding:**
Create `LiveDemo.java` in `examples/` folder, code along with students, then run:
```bash
mvn clean compile exec:java -Dexec.mainClass="com.example.javafx.LiveDemo"
```

**That's it! You're ready to teach JavaFX!** 🎉
