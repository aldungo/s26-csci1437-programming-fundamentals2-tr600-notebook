# Quick Start: Run JavaFX Examples

## You have 3 options:

### ⭐ OPTION 1: VS Code (EASIEST - Recommended for Teaching)

1. Open any example file (e.g., `Example01_MinimalApp.java`)
2. Right-click in editor
3. Select **"Run Java"**
4. Done! ✅

No setup needed if you have Java Extension Pack installed.

---

### OPTION 2: Install Maven (5 min setup)

**Using Chocolatey:**
```powershell
choco install maven
```

**Or download manually:**
1. https://maven.apache.org/download.cgi
2. Extract to C:\apache-maven
3. Add to PATH
4. Restart terminal
5. Run: `mvn clean javafx:run -Djavafx.mainClass=com.example.javafx.Example01_MinimalApp`

---

### OPTION 3: Java Command (No Maven)

1. Download JavaFX SDK: https://gluonhq.com/products/javafx/
2. Extract to `C:\javafx-sdk-21`
3. Run:
```powershell
$env:PATH_TO_FX = "C:\javafx-sdk-21\lib"
javac --module-path $env:PATH_TO_FX --add-modules javafx.controls Example01_MinimalApp.java
java --module-path $env:PATH_TO_FX --add-modules javafx.controls com.example.javafx.Example01_MinimalApp
```

See `RUN-WITHOUT-MAVEN.md` for full details.

---

## For Class Demos:

**Best choice: Use VS Code's "Run Java" button**  
- One click
- No terminal commands
- Students can see it clearly
- Works immediately
