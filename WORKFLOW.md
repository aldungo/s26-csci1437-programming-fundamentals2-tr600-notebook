# 🎓 Teaching Workflow Guide

## Your Two-Branch System

### **`instructor` branch** (private - your working branch)
- This is where YOU work and prep
- Contains `.instructor/` folder with all your private materials
- Has answer keys, solutions, prep notes
- Safe to use Copilot for prep work

### **`main` branch** (public - student-facing)
- Clean, student-safe content only
- `.gitignore` prevents instructor materials from syncing here
- This is the branch students see on GitHub
- **Blackboard link always points to main branch**

---

## 📅 Weekly Workflow (After Your 2 Lectures)

### 1️⃣ **Work on `instructor` branch** (default)
```bash
# Make sure you're on instructor branch
git checkout instructor

# After each lecture, save your work
git add .
git commit -m "Mon lecture: Chapter 9 OOP intro"
git push origin instructor
```

### 2️⃣ **Backfill to students** (when ready)
```bash
# Still on instructor branch, add student-safe content
git add lectures/week10/
git add chapter9/Chapter9.ipynb
git commit -m "Add week 10 lecture code"

# Switch to main and merge
git checkout main
git merge instructor --no-commit

# Review what's being merged (optional)
git status

# Commit and push to students
git commit -m "Week 10: OOP and classes"
git push origin main

# Go back to working on instructor
git checkout instructor
```

### 3️⃣ **Quick Sync Script** (coming next!)
I'll create a script so you just run: `.\sync-to-students.ps1`

---

## 🔒 What Students NEVER See
- Anything in `.instructor/` folder
- Files with `-KEY`, `-TEACHER`, `-SOLUTION` in the name
- Files starting with `old*`
- The instructor branch itself

---

## 📓 Multi-File .ipynb Solution
For chapters with multiple `.java` files:

**Option A:** Keep using notebooks for notes + reference the .java files
```
chapter9/
  ├── Chapter9.ipynb          ← Your teaching notes/demos
  ├── Circle.java             ← Student-accessible class
  └── Chapter9_pt1.java       ← Student-accessible driver
```

**Option B:** Use notebook cells with `%load` magic (if using IJava kernel)
**Option C:** Create a "code" subdirectory structure per chapter

Which feels most natural for you?

---

## 🚀 One-Command Sync (coming up!)
After this setup, you'll just run:
```powershell
.\sync-to-students.ps1 "Week 10 complete"
```

And it handles everything automatically!
