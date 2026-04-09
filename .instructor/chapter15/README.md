# Chapter 15: Event-Driven Programming and Animations

## Quick Start

All examples are in the `examples/` directory. Use `run.ps1` for easy compilation and execution.

```powershell
cd .instructor\chapter15\examples
.\run.ps1
```

## What's Included

### Examples Directory (`examples/`)
8 progressive examples covering event-driven programming:

1. **Example01_BasicEventHandler** - Separate handler classes (fundamental pattern)
2. **Example02_InnerClassHandler** - Inner class handlers (access outer class)
3. **Example03_AnonymousInnerClass** - Anonymous inner classes (more concise)
4. **Example04_LambdaExpression** - Lambda expressions (modern, preferred)
5. **Example05_ControlCircle** - Practical application (Enlarge/Shrink)
6. **Example06_MouseEvents** - Mouse interaction (click, move, drag)
7. **Example07_KeyEvents** - Keyboard controls (arrow keys, +/-)
8. **Example08_PathTransition** - Animation (rectangle moving along circle)

### Supporting Files
- **README.md** - Detailed guide with compile/run commands
- **run.ps1** - Interactive PowerShell script for compiling and running examples

## Key Topics Covered

### Event Handling Progression
- **Verbose → Concise**: Example01 → Example02 → Example03 → Example04
- Learn when to use: separate class, inner class, anonymous class, or lambda

### Event Types
- **ActionEvent**: Button clicks (Examples 1-5)
- **MouseEvent**: Click, press, release, move, drag, enter, exit (Example 6)
- **KeyEvent**: Key press, release, typed (Example 7)

### Animations
- **PathTransition**: Move objects along paths (Example 8)
- Duration, Timeline, auto-reverse
- Mouse event integration (pause/resume)

## Teaching Sequence

1. Start with examples 1-4 to show event handler evolution
2. Apply knowledge with Example 5 (ControlCircle)
3. Explore Examples 6-7 for mouse and keyboard handling
4. Finish with Example 8 for animations

## Source Materials

- **chapter15slides.txt** - Slide content (primary reference)
- **chapter15textbook.txt** - Textbook excerpts (supporting details)

## Prerequisites

Students should have completed Chapter 14 (JavaFX basics). Refer to Chapter 14's `COMPLETE-BEGINNER-SETUP.md` for initial setup instructions (VS Code, Java, JavaFX SDK, GitHub Desktop).

## Quick Reference

### Compile Pattern
```powershell
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls -d . ExampleFileName.java
```

### Run Pattern
```powershell
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "ABSOLUTE_PATH" com.example.javafx.ExampleClassName
```

**Note**: Use absolute path for `--class-path`, not relative paths like `.` or `.\examples`

---

**Chapter Focus**: Event-driven programming patterns, lambda expressions, mouse/key events, animations

**Previous Chapter**: Chapter 14 (JavaFX Basics) - `.instructor/chapter14/`

**Setup Guide**: See `.instructor/chapter14/COMPLETE-BEGINNER-SETUP.md` for first-time setup
