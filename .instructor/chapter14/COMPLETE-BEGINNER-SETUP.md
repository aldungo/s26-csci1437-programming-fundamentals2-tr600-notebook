# 🚀 Complete Beginner Setup Guide - Your JavaFX Playground
## CSCI 1437: Programming Fundamentals II

**Everything in this guide is 100% FREE!** No paid software required.

---

## 📝 Table of Contents

1. [Download Visual Studio Code (FREE!)](#step-1-download-visual-studio-code)
2. [Install Java Extensions](#step-2-install-java-extensions)
3. [Download Java SDK](#step-3-download-java-sdk)
4. [Download GitHub Desktop](#step-4-download-github-desktop)
5. [Clone the Course Repository](#step-5-clone-the-course-repository)
6. [Setup JavaFX SDK](#step-6-setup-javafx-sdk)
7. [Test Your Setup](#step-7-test-your-setup)
8. [Using Copilot for Help](#using-copilot-for-guidance)

---

## Step 1: Download Visual Studio Code

**Visual Studio Code (VS Code) is FREE and will be your main coding environment.**

1. Go to: **https://code.visualstudio.com/**
2. Click the big **"Download for Windows"** button (it's FREE!)
3. Run the installer
4. **IMPORTANT:** During installation, check these boxes:
   - ✅ "Add to PATH"
   - ✅ "Create a desktop icon"
   - ✅ "Add 'Open with Code'" action to context menu
5. Click "Install" and wait for it to finish
6. Launch VS Code

**Time needed:** 5 minutes

---

## Step 2: Install Java Extensions

**Extensions add Java superpowers to VS Code - all FREE!**

1. Open VS Code
2. Click the **Extensions** icon on the left sidebar (looks like four squares)
   - Or press `Ctrl+Shift+X`
3. In the search box, type: **Extension Pack for Java**
4. Look for "Extension Pack for Java" by **Microsoft** (it should be the first result)
5. Click the blue **"Install"** button
6. Wait for it to install (it will install several extensions automatically)
7. You should see these extensions installed:
   - ✅ Language Support for Java
   - ✅ Debugger for Java
   - ✅ Test Runner for Java
   - ✅ Maven for Java
   - ✅ Project Manager for Java
   - ✅ IntelliCode

**Optional but Recommended:**
- Search for **"GitHub Copilot"** and install it (you can get free access as a student!)
  - Go to: https://education.github.com/pack to get GitHub Student Developer Pack
  - This gives you FREE GitHub Copilot access for guidance (not to do your homework!)

**Time needed:** 3-5 minutes

---

## Step 3: Download Java SDK

**Java Development Kit (JDK) - FREE from Oracle**

1. Go to: **https://www.oracle.com/java/technologies/downloads/**
2. Scroll to **Java 21** or **Java 22** section
3. Under "Windows", download:
   - **x64 Installer** (ends in `.exe`)
4. Run the installer
5. Click "Next" through all the steps (default settings are fine)
6. Wait for installation to complete

**Verify Java is installed:**
1. Open PowerShell (search "PowerShell" in Windows Start menu)
2. Type: `java -version`
3. You should see something like: `java version "21.0.1"` or `"22.0.1"`

**Time needed:** 5-10 minutes (depending on download speed)

---

## Step 4: Download GitHub Desktop

**GitHub Desktop makes it SUPER EASY to clone and sync repositories - FREE!**

1. Go to: **https://desktop.github.com/**
2. Click **"Download for Windows"** (it's FREE!)
3. Run the installer
4. Sign in with your GitHub account
   - If you don't have one, click "Create your free account" (it's FREE!)
5. Complete the setup wizard

**Time needed:** 3-5 minutes

---

## Step 5: Clone the Course Repository

**This is where you get all the JavaFX examples and playground code!**

### Option A: Using GitHub Desktop (EASIEST!)

1. Open GitHub Desktop
2. Go to: **File → Clone Repository**
3. Click the **"URL"** tab
4. Your instructor will provide the repository URL, something like:
   ```
   https://github.com/YOUR-INSTRUCTOR/javafx-course-examples
   ```
5. Paste the URL
6. Choose where to save it (e.g., `C:\Users\YourName\Documents\CS1437`)
7. Click **"Clone"**
8. Wait for it to download (should be quick!)

### Option B: Using the GitHub Website

1. Go to the repository URL your instructor provides
2. Click the green **"Code"** button
3. Click **"Open with GitHub Desktop"**
4. This will launch GitHub Desktop and start the clone automatically

**After cloning:**
1. In GitHub Desktop, click **"Open in Visual Studio Code"**
2. VS Code will open with the entire project ready to go!

**Time needed:** 2-3 minutes

---

## Step 6: Setup JavaFX SDK

**JavaFX makes graphical user interfaces (GUIs) work - FREE!**

1. Go to: **https://gluonhq.com/products/javafx/**
2. Click **"Download"** (it's FREE!)
3. Choose:
   - **Version:** 21 or Latest LTS
   - **Type:** SDK
   - **Operating System:** Windows
4. Download the **ZIP file** (about 55 MB)
5. Once downloaded, **Extract** the zip file:
   - Right-click → "Extract All..."
6. **Move the extracted folder** to `C:\` drive
7. **Rename it** to: `javafx-sdk-21`
8. Final location should be: `C:\javafx-sdk-21\`

**Verify JavaFX is ready:**
```powershell
Test-Path "C:\javafx-sdk-21\lib"
```
Should return: `True`

**Time needed:** 5 minutes (depending on download speed)

---

## Step 7: Test Your Setup

**Let's make sure everything works!**

### Quick Test - Run a Sample Program

1. In VS Code, open the cloned repository folder
2. Navigate to: `.instructor\chapter14\examples\`
3. Open `SimpleTest.java`
4. Look for the **"Run"** button above the `public static void main` line
5. Click **"Run"**
6. A window should appear with title "Simple Test Window"!

**If the Run button doesn't work, use the terminal:**

1. In VS Code, open a new terminal: `View → Terminal` (or press `` Ctrl+` ``)
2. Navigate to examples folder:
   ```powershell
   cd .instructor\chapter14\examples
   ```
3. Run the helper script:
   ```powershell
   ..\run.ps1 SimpleTest
   ```

**If you see a window appear, YOU'RE ALL SET! 🎉**

**Time needed:** 2 minutes

---

## Step 8: Your JavaFX Playground is Ready!

**You now have a safe space to experiment with JavaFX!**

### Where to Find Examples:
- **Location:** `.instructor\chapter14\examples\`
- **Files:** Example01 through Example10, plus more!

### How to Run Examples:
1. Open any `.java` file
2. Click the green **"Run"** button above `main()`
3. See the GUI window appear!

### How to Create Your Own Programs:
1. Create a new `.java` file in the examples folder
2. Copy the structure from `SimpleTest.java`
3. Modify it to create your own GUI
4. Run it with the "Run" button or terminal commands

---

## 🤖 Using Copilot for Guidance

**GitHub Copilot can help you learn, but don't let it do all the work!**

### ✅ Good Uses for Copilot:
- **Explaining errors:** "Why am I getting this error?"
- **Understanding concepts:** "What does this JavaFX code do?"
- **Learning alternatives:** "What are other ways to create a circle?"
- **Debugging help:** "Why isn't my window showing up?"

### ❌ Don't Let Copilot:
- **Complete your homework** - You need to learn!
- **Write entire programs** - You won't understand them
- **Replace your thinking** - Use it as a tutor, not a do-it-for-you tool

### How to Use Copilot Chat:
1. In VS Code, open Copilot Chat (sidebar icon or `Ctrl+Shift+I`)
2. Ask questions about concepts you don't understand
3. Use it to learn "why" not just "what"

**Think of Copilot as a study buddy who can explain things, not someone to copy homework from!**

---

## 📚 Quick Reference - Running Your Programs

### The Easy Way (VS Code Run Button):
1. Open any `.java` file
2. Click green "Run" button above `main()`
3. Done!

### The Terminal Way (PowerShell):
```powershell
# Navigate to your program folder
cd path\to\your\project

# Compile
javac --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls YourProgram.java

# Run (use YOUR folder path!)
java --module-path "C:\javafx-sdk-21\lib" --add-modules javafx.controls --class-path "C:\path\to\your\project" YourProgram
```

### Using the Helper Script:
```powershell
cd .instructor\chapter14
.\run.ps1 YourProgramName
```

---

## 🐛 Troubleshooting

### "javac is not recognized"
**Problem:** Java not installed or not in PATH  
**Solution:** Reinstall Java from Step 3, make sure to use the installer

### "package javafx.application does not exist"
**Problem:** JavaFX SDK not found  
**Solution:** Verify `C:\javafx-sdk-21\lib` exists with .jar files inside

### Run button doesn't work
**Problem:** Java extensions not loaded properly  
**Solution:** Restart VS Code, or use terminal commands instead

### Can't clone repository
**Problem:** Repository URL wrong or private  
**Solution:** Ask your instructor for the correct public repository URL

### Window doesn't appear
**Problem:** Window might be hidden  
**Solution:** Check your taskbar or Task Manager for running `java.exe` processes

---

## ✨ You're Ready to Learn JavaFX!

**Setup Checklist - Make sure you have:**
- ✅ VS Code installed and running
- ✅ Java extensions installed in VS Code
- ✅ Java SDK installed (check with `java -version`)
- ✅ GitHub Desktop installed
- ✅ Course repository cloned
- ✅ JavaFX SDK at `C:\javafx-sdk-21\`
- ✅ Successfully ran SimpleTest.java (saw a window!)

**If all checkboxes are checked, you're ready for class! 🎉**

---

## 💡 Pro Tips

1. **Save your work often** - Press `Ctrl+S` frequently!
2. **Use Git commits** - Save your progress with GitHub Desktop
3. **Experiment freely** - This is YOUR playground, try things!
4. **Ask questions** - Use Copilot, ask classmates, ask your instructor
5. **Practice coding by hand first** - Then check with Copilot if you're stuck

---

## 🆘 Need More Help?

- **During Class:** Raise your hand and ask!
- **Office Hours:** Visit your instructor
- **Canvas:** Check course discussion boards
- **Discord/Slack:** Ask classmates (if your course uses it)
- **Documentation:** https://openjfx.io/

---

**Remember: Everything in this guide is FREE. You should not pay for any software for this course!**

---

*Last updated: March 30, 2026*  
*Verified on: Windows 10/11 with Java 21/22 and JavaFX 21*
