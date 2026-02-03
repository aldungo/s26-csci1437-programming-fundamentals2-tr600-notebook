# Week 3 Catch-Up: Organizing Your Teaching Repository

## Current Situation
You're on `instructor` branch with:
- ✅ New lecture folders for weeks 1-3
- ✅ Chapter 9 & 10 materials
- ✅ Teaching examples in `.instructor/prep/`
- ⚠️ Not yet synced to students

## Your Workflow Benefits

### 1. **Multiple Class Compilations**
Yes! This setup is PERFECT for compiling different views:

**Instructor view** (what YOU see):
```
lectures/
  ├── lecture_02_jan22_chapter9/
  ├── lecture_03_jan27_chapter10_part1/
  └── lecture_04_jan29_chapter10_part2/
        ├── instructor/          ← Your prep, answers
        └── student/             ← Student-facing
```

**Student view** (what THEY see):
```
lectures/
  └── lecture_04_jan29_chapter10_part2/
        └── student/             ← Only this!
```

### 2. **Live Demo from `.instructor/`**
You can:
- Prep in `.instructor/prep/` (students never see it)
- Demo live in class from your instructor folder
- Copy finished examples to student folders when ready
- Students get clean, tested code

### 3. **Continuous Sync**
After each class:
```powershell
.\save-work.ps1 "Week 3 Day 1 complete"
.\sync-to-students.ps1 "Week 3: Chapter 10 Part 2"
```
Students instantly get updated materials on GitHub!

---

## Quick Setup Steps

### Step 1: Organize Your Current Work
Move root-level demo files to appropriate places:
- `StringDemo.java` → `.instructor/prep/` (your scratch)
- `WrapperClassesDemo.java` → `.instructor/prep/`
- `S26_C10.java` → `.instructor/prep/`

Student-ready files stay in `lectures/` folders.

### Step 2: Commit Your Instructor Work
```powershell
.\save-work.ps1 "Weeks 1-3 organized with new structure"
```

### Step 3: Set Up Student Branch (ONE TIME)
```powershell
# Switch to main (student branch)
git checkout main

# Merge student-safe content
git merge instructor

# Push to GitHub
git push origin main

# Back to your workspace
git checkout instructor
```

### Step 4: Daily Workflow
**Before class:**
- Prep in `.instructor/prep/`
- Test examples
- Save: `.\save-work.ps1 "Prepped Chapter 11"`

**After class:**
- Update with what you covered
- Save: `.\save-work.ps1 "Chapter 11 Monday complete"`
- Push to students: `.\sync-to-students.ps1 "Week 4 materials"`

---

## Multi-Compilation Benefits

### Benefit 1: Testing
Compile from `.instructor/prep/` without affecting student view

### Benefit 2: Versions
Keep multiple versions:
- Starter code (students)
- Complete solution (instructor)
- Alternative approaches (.instructor/solutions/)

### Benefit 3: Jupyter Integration
Your Chapter10.ipynb can reference both:
- Student code examples (they can run)
- Instructor notes (they never see)

---

## Ready to Organize?

Want me to:
1. Move your demo files to `.instructor/prep/`?
2. Create student-facing README files for each lecture?
3. Set up the initial student branch sync?
4. Create a lecture template for future weeks?

Just say which and I'll make it happen!
