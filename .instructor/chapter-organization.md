# 📋 Instructor Reference: Chapter Organization

## Current Chapter 9 Setup
```
chapter9/
├── README.md              ← Navigation for students  
├── Circle.java            ← Student-accessible
├── Chapter9_pt1.java      ← Student-accessible
└── (Chapter9.ipynb is in root)
```

## Recommended Future Structure
```
chapter10/
├── README.md
├── Chapter10-Notes.ipynb     ← Or keep at root
├── src/                      ← All .java files
│   ├── ClassName.java
│   ├── TestClass.java
│   └── AnotherExample.java
└── exercises/                ← Optional
    └── practice1.java
```

## Your Teaching Flow

### 📝 Before Lecture
1. Prep `.java` files in `chapter##/src/` (or chapter root)
2. Create/update answer keys in `.instructor/answer-keys/`
3. Use Copilot to generate variations/examples
4. Update notebook with lecture plan

### 🎤 During Lecture
1. Open notebook for theory/concepts
2. Live code in `.java` files
3. Run code to demonstrate

### 💾 After Lecture
1. Update notebook with what you actually covered
2. Save: `.\save-work.ps1 "Chapter 10 lecture 1"`
3. Clean up code if needed
4. When ready for students: `.\sync-to-students.ps1 "Chapter 10 Week 11"`

## Notebook Best Practices

### Keep Notebooks for:
- ✅ Concepts and theory
- ✅ Quick code snippets/examples
- ✅ Visual diagrams/explanations
- ✅ Lecture flow and notes

### Use Separate .java files for:
- ✅ Multi-class projects
- ✅ Runnable programs
- ✅ Student practice files
- ✅ Code they'll modify in their IDE

## Safety Checklist Before Syncing

- [ ] Remove answer keys from visible files
- [ ] Check no INSTRUCTOR-ONLY content in public folders
- [ ] Test that code runs as-is for students
- [ ] Update README.md navigation
- [ ] Review git status before merge

## File Naming Convention

**Student-safe:**
- `ChapterX.ipynb`
- `ClassName.java`
- `TestDriver.java`

**Instructor-only (auto-ignored):**
- `ChapterX-ANSWER-KEY.ipynb`
- `Solution-TEACHER.java`
- Anything in `.instructor/`
